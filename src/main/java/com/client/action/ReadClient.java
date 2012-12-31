package com.client.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.client.response.NodeResponse;
import com.client.response.RelationshipResponse;
import com.client.response.ServiceRoot;
import com.config.NeoConfig;
import com.google.gson.Gson;

public class ReadClient {
	static HttpClient httpclient = null;
	NeoConfig neoConfig = null;
	
	public ReadClient(NeoConfig neoConfig) {
		this.neoConfig = neoConfig;
		HostConfiguration hostConfig = new HostConfiguration();
		hostConfig.setHost(neoConfig.getNeoHost(), neoConfig.getNeoPort());
		httpclient = new HttpClient();
		httpclient.setHostConfiguration(hostConfig);
	}
	
	public ServiceRoot getServiceRoot() {
		GetMethod get = new GetMethod();
		get.setPath("/db/data");
		get.setRequestHeader("Accept", "application/json");
		try {
			int responseCode = httpclient.executeMethod(get);
			System.out.println(responseCode);
			return new Gson().fromJson(get.getResponseBodyAsString(), ServiceRoot.class);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public NodeResponse getNodeQueryResponse(CypherQuery query) {
		PostMethod post = new PostMethod();
		post.setPath("/db/data/cypher");
		post.setRequestHeader("Accept", "application/json");
		post.setRequestHeader("Content-Type", "application/json");
		post.setRequestEntity(new StringRequestEntity(query.toJsonString()));
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
			return new Gson().fromJson(sb.toString(), NodeResponse.class);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public RelationshipResponse getRelationshipQueryResponse(CypherQuery query) {
		PostMethod post = new PostMethod();
		post.setPath("/db/data/cypher");
		post.setRequestHeader("Accept", "application/json");
		post.setRequestHeader("Content-Type", "application/json");
		post.setRequestEntity(new StringRequestEntity(query.toJsonString()));
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
			return new Gson().fromJson(sb.toString(), RelationshipResponse.class);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
