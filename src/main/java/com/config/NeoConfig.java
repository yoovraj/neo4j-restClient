package com.config;

/**
 * Neo4j server database configuration
 * @author yoovraj
 *
 */
public class NeoConfig {
	String neoHost = null;
	int    neoPort = 0;

	public NeoConfig (String hostName, int port) {
		this.neoHost = hostName;
		this.neoPort = port;
	}
	
	public NeoConfig () {
		this.neoHost = "localhost";
		this.neoPort = 7474;
	}
	
	public String getNeoHost() {
		return neoHost;
	}
	public int getNeoPort() {
		return neoPort;
	}
	
	public String getNeoHostRoot() {
		return "http://" + neoHost + ":" + neoPort;
	}
	public String getNodeURI(int nodeNo) {
		return "/db/data/node/" + nodeNo;
	}
	
	public String getNodeRelationsURI(int nodeNo) {
		return "/db/data/node/" + nodeNo + "relationships";
	}
}
