package com.client.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

import com.client.response.Node;
import com.config.NeoConfig;
import com.google.gson.Gson;

public class WriteClient {
	static HttpClient httpclient = null;
	NeoConfig neoConfig = null;
	
	public WriteClient(NeoConfig neoConfig) {
		this.neoConfig = neoConfig;
		HostConfiguration hostConfig = new HostConfiguration();
		hostConfig.setHost(neoConfig.getNeoHost(), neoConfig.getNeoPort());
		httpclient = new HttpClient();
		httpclient.setHostConfiguration(hostConfig);
	}
	
	public Node createNode() {
		PostMethod post = new PostMethod();
		post.setPath("/db/data/node");
		post.setRequestHeader("Accept", "application/json");
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

}
