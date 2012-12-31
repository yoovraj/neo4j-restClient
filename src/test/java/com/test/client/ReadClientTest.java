package com.test.client;



import com.client.action.CypherQuery;
import com.client.action.ReadClient;
import com.client.response.Node;
import com.client.response.NodeResponse;
import com.client.response.Relationship;
import com.client.response.RelationshipResponse;
import com.client.response.ServiceRoot;
import com.config.NeoConfig;

public class ReadClientTest {
	public static void main(String[] args) {
		ReadClient client = new ReadClient(new NeoConfig("192.168.2.4", 7474));
		ServiceRoot serviceRoot = client.getServiceRoot();
		System.out.println(serviceRoot.getNeo4j_version());
		
		NodeResponse nodeResponse = client.getNodeQueryResponse(new CypherQuery("start n = node(1) match n--a return a"));
		for (Node node : nodeResponse.getNodes()) {
			System.out.println(node.toString());
		}
		
		RelationshipResponse relationshipResponse = client.getRelationshipQueryResponse(new CypherQuery("start n = node(1) match n-[r]-a return r"));
		for (Relationship relationship : relationshipResponse.getRelationships()) {
			System.out.println(relationship.toString());
		}
		
	}

}
