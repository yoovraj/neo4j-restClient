package com.client.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.client.response.Node;
import com.config.NeoConfig;
import com.constants.NeoConst;
import com.google.gson.Gson;

/**
 * Client for interacting with Nodes 
 * supports create, read, delete operations.
 * update operation still TODO
 * @author yoovraj
 *
 */
public class NodeClient {
	static HttpClient httpclient = null;
	NeoConfig neoConfig = null;
	
	public NodeClient(NeoConfig neoConfig) {
		this.neoConfig = neoConfig;
		HostConfiguration hostConfig = new HostConfiguration();
		hostConfig.setHost(neoConfig.getNeoHost(), neoConfig.getNeoPort());
		httpclient = new HttpClient();
		httpclient.setHostConfiguration(hostConfig);
	}
	/**
	 * Create node without Properties 
	 * @return the created Node
	 */
	public Node createNode() {
		return this.createNode(null);
	}

	/**
	 * Create a node with the given <key, value> properties
	 * @param nodeProperties
	 * @return the created Node
	 */
	public Node createNode(Map<String, String> nodeProperties) {
		PostMethod post = new PostMethod();
		post.setPath("/db/data/node");
		post.setRequestHeader("Accept", "application/json");
		
		if (nodeProperties != null) {
			post.setRequestEntity(new StringRequestEntity(new Gson().toJson(nodeProperties))) ;
		}

		try {
			int responseCode = httpclient.executeMethod(post);
			System.out.println(responseCode);

			//http://saaspose.com/docs/display/rest/Convert+InputStream+to+String+(Java+REST)
			BufferedReader reader = new BufferedReader(new InputStreamReader(post.getResponseBodyAsStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null)
			{
				sb.append(line);
			}
			return new Gson().fromJson(sb.toString(), Node.class);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}

	/**
	 * Get the node information based on nodeNumber
	 * @param nodeNo
	 * @return the requested Node
	 */
	public Node getNode(int nodeNo) {
		GetMethod get = new GetMethod();
		get.setPath("/db/data/node/" + nodeNo);
		get.setRequestHeader("Accept", "application/json");
		try {
			int responseCode = httpclient.executeMethod(get);
			System.out.println(responseCode);

			//http://saaspose.com/docs/display/rest/Convert+InputStream+to+String+(Java+REST)
			BufferedReader reader = new BufferedReader(new InputStreamReader(get.getResponseBodyAsStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null)
			{
				sb.append(line);
			}
			return new Gson().fromJson(sb.toString(), Node.class);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	/**
	 * Delete the node with given nodeNo.
	 * @param nodeNo
	 * @return result SUCCESS:true<br>FAIL:false
	 */
	public boolean deleteNode(int nodeNo) {
		DeleteMethod delete = new DeleteMethod();
		delete.setPath("/db/data/node/" + nodeNo);
		delete.setRequestHeader("Accept", "application/json");
		try {
			int responseCode = httpclient.executeMethod(delete);
			System.out.println(responseCode);
			if (responseCode == NeoConst.Node.DELETE_SUCCESS) {
				return true;
			} else {
				return false;
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
