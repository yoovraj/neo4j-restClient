package com.test.client;

import org.apache.commons.httpclient.NameValuePair;

import com.client.action.WriteClient;
import com.client.response.Node;
import com.config.NeoConfig;
import com.google.gson.Gson;

public class WriteClientTest {
	public static void main(String[] args) {
		WriteClient client = new WriteClient(new NeoConfig("192.168.2.4", 7474));
		Node node = client.createNode();
		System.out.println(node.toString());
		
		NameValuePair[] nameVal = new NameValuePair[] { new NameValuePair("test1", "val1"), new NameValuePair("test2", "val2")};
		System.out.println(new Gson().toJson(nameVal));

	}
}
