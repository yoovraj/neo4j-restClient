package com.client.response;

/**
 * Service root for the neo db 
 * @author yoovraj
 *
 */
public class ServiceRoot {
	Extensions extensions;
	String node;
	String reference_node;
	String node_index;
	String relationship_index;
	String extensions_info;
	String relationship_types;
	String batch;
	String cypher;
	String neo4j_version;

	public ServiceRoot() {
	}
	public Extensions getExtensions() {
		return extensions;
	}
	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getReference_node() {
		return reference_node;
	}
	public void setReference_node(String reference_node) {
		this.reference_node = reference_node;
	}
	public String getNode_index() {
		return node_index;
	}
	public void setNode_index(String node_index) {
		this.node_index = node_index;
	}
	public String getRelationship_index() {
		return relationship_index;
	}
	public void setRelationship_index(String relationship_index) {
		this.relationship_index = relationship_index;
	}
	public String getExtensions_info() {
		return extensions_info;
	}
	public void setExtensions_info(String extensions_info) {
		this.extensions_info = extensions_info;
	}
	public String getRelationship_types() {
		return relationship_types;
	}
	public void setRelationship_types(String relationship_types) {
		this.relationship_types = relationship_types;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getCypher() {
		return cypher;
	}
	public void setCypher(String cypher) {
		this.cypher = cypher;
	}
	public String getNeo4j_version() {
		return neo4j_version;
	}
	public void setNeo4j_version(String neo4j_version) {
		this.neo4j_version = neo4j_version;
	}
}

class Extensions {
	CypherPlugin CypherPlugin;
	GremlinPlugin GremlinPlugin;
	public CypherPlugin getCypherPlugin() {
		return CypherPlugin;
	}
	public void setCypherPlugin(CypherPlugin cypherPlugin) {
		CypherPlugin = cypherPlugin;
	}
	public GremlinPlugin getGremlinPlugin() {
		return GremlinPlugin;
	}
	public void setGremlinPlugin(GremlinPlugin gremlinPlugin) {
		GremlinPlugin = gremlinPlugin;
	}
	
}
class CypherPlugin {
	String execute_query;

	public String getExecute_query() {
		return execute_query;
	}

	public void setExecute_query(String execute_query) {
		this.execute_query = execute_query;
	}
}
class GremlinPlugin {
	String execute_query;

	public String getExecute_query() {
		return execute_query;
	}

	public void setExecute_query(String execute_query) {
		this.execute_query = execute_query;
	}
}