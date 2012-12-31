package com.test.client;

import java.util.HashMap;
import java.util.Map;

import com.client.data.RelationshipClient;
import com.config.NeoConfig;

public class RelationshipClientTest {
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String> ();
		map.put("test1", "val1");
		map.put("test2", "val2");
		RelationshipClient client = new RelationshipClient(new NeoConfig("192.168.2.4", 7474));
//		System.out.println(client.createRelationship(30 , 31, "KNOWS").toString());
		
		System.out.println(client.getRelationshipById(12).toString());
		System.out.println(client.getPropertiesOnRelationship(12).toString());
		System.out.println(client.setPropertiesOnRelationship(12, map));
		System.out.println(client.getPropertiesOnRelationship(12));
		
		
	}

}
