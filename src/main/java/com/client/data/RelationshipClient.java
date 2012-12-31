package com.client.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

import com.client.response.Relationship;
import com.config.NeoConfig;
import com.constants.NeoConst;
import com.google.gson.Gson;

public class RelationshipClient {
	static HttpClient httpclient = null;
	NeoConfig neoConfig = null;
	
	public RelationshipClient(NeoConfig neoConfig) {
		this.neoConfig = neoConfig;
		HostConfiguration hostConfig = new HostConfiguration();
		hostConfig.setHost(neoConfig.getNeoHost(), neoConfig.getNeoPort());
		httpclient = new HttpClient();
		httpclient.setHostConfiguration(hostConfig);
	}
	
	public Relationship createRelationship(int startNode, int endNode, String type) {
		return this.createRelationship(new RelationshipNodeParam(startNode, endNode	, type));
	}
	
	public Relationship createRelationship(RelationshipNodeParam relationshipReqParam) {
		PostMethod post = new PostMethod();
		post.setPath("/db/data/node/" + relationshipReqParam.getFrom() + "/relationships");
		post.setRequestHeader("Accept", "application/json");
		post.setRequestHeader("Content-Type", "application/json");

		relationshipReqParam.reconfigure(neoConfig);
		post.setRequestEntity(new StringRequestEntity(new Gson().toJson(relationshipReqParam)));
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
			return new Gson().fromJson(sb.toString(), Relationship.class);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}
	
	public Relationship getRelationshipById(int relationshipNo) {
		GetMethod get = new GetMethod();
		get.setPath("/db/data/relationship/" + relationshipNo);
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
			return new Gson().fromJson(sb.toString(), Relationship.class);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		
	}
	
	public Map<String, String> getPropertiesOnRelationship(int relationshipNo) {
		GetMethod get = new GetMethod();
		get.setPath("/db/data/relationship/" + relationshipNo + "/properties");
		get.setRequestHeader("Accept", "application/json");
		try {
			int responseCode = httpclient.executeMethod(get);
			System.out.println(responseCode);
			if (responseCode == NeoConst.NO_CONTENT) {
				return new HashMap<String, String>();
			}
			//http://saaspose.com/docs/display/rest/Convert+InputStream+to+String+(Java+REST)
			BufferedReader reader = new BufferedReader(new InputStreamReader(get.getResponseBodyAsStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null)
			{
				sb.append(line);
			}
			return new Gson().fromJson(sb.toString(), new HashMap<String, String>().getClass());
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public boolean setPropertiesOnRelationship(int relationshipNo, Map<String, String> relationshipProperties) {
		PutMethod put = new PutMethod();
		put.setPath("/db/data/relationship/" + relationshipNo + "/properties");
		put.setRequestHeader("Accept", "application/json");
		put.setRequestHeader("Content-Type", "application/json");

		put.setRequestEntity(new StringRequestEntity(new Gson().toJson(relationshipProperties)));
		try {
			int responseCode = httpclient.executeMethod(put);
			System.out.println(responseCode);
			if (responseCode == NeoConst.Relationship.PROPERTIES.SET_SUCCESS) {
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
	
	public boolean setSinglePropertyOnRelationship(int relationshipNo, String propertyName, String propertyValue) {
		PutMethod put = new PutMethod();
		put.setPath("/db/data/relationship/" + relationshipNo + "/properties/" + propertyName);
		put.setRequestHeader("Accept", "application/json");
		put.setRequestHeader("Content-Type", "application/json");
		
		put.setRequestEntity(new StringRequestEntity(propertyValue));
		
		try {
			int responseCode = httpclient.executeMethod(put);
			if (responseCode == NeoConst.Relationship.PROPERTIES.SET_SUCCESS) {
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
	
	public Relationship[] getRelationships(int nodeNo, String typeOf, String direction) {
		GetMethod get = new GetMethod();
		if (typeOf != null) {
			get.setPath("/db/data/node/" + nodeNo + "/relationships/" + direction + "/" + typeOf);			
		} else {
			get.setPath("/db/data/node/" + nodeNo + "/relationships/" + direction);
		}
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
			return new Gson().fromJson(sb.toString(), Relationship[].class);			
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Relationship[] getRelationships(int nodeNo, String[] typeOf, String direction) {
		StringBuilder sb = new StringBuilder();
		
		//TODO modify this loop for performance 
		for(int i = 0; i< typeOf.length; i++) {
			if (i == 0) {
				sb.append(typeOf[i]);
			} else {
				sb.append("&" + typeOf[i] );
			}
		}
		
		return this.getRelationships(nodeNo, sb.toString(), direction);
	}

}
