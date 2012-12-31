package com.client.response;

public class NodeResponse {
	String[] columns;
	Node[][] data;
	public String[] getColumns() {
		return columns;
	}
	public void setColumns(String[] columns) {
		this.columns = columns;
	}
	public Node[][] getData() {
		return data;
	}
	public void setData(Node[][] data) {
		this.data = data;
	}
	
	public Node[] getNodes() {
		Node[] nodes = new Node[data.length];
		for(int i = 0; i < data.length; i++) {
			nodes[i] = data[i][0];
		}
		return nodes;
	}
}
