package com.test.client;

import java.util.HashMap;
import java.util.Map;

import com.client.data.NodeClient;
import com.config.NeoConfig;

public class NodeClientTest {
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String> ();
		map.put("test1", "val1");
		map.put("test2", "val2");
		NodeClient client = new NodeClient(new NeoConfig("192.168.2.4", 7474));
//		System.out.println(client.createNode(map).toString());
		System.out.println(client.getNode(40).getSelf());
		System.out.println("deleted : " + client.deleteNode(40));
		System.out.println(client.getNode(40).getSelf());
		
	}

}
