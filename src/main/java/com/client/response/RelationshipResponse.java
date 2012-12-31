package com.client.response;

public class RelationshipResponse {
	String[] columns;
	Relationship[][] data;
	public String[] getColumns() {
		return columns;
	}
	public void setColumns(String[] columns) {
		this.columns = columns;
	}
	public Relationship[][] getRelationship() {
		return data;
	}
	public void setRelationship(Relationship[][] relationship) {
		this.data = relationship;
	}
	
	public Relationship[] getRelationships() {
		Relationship[] relationships = new Relationship[data.length];
		for (int i = 0; i < data.length; i++) {
			relationships[i] = data[i][0];
		}
		return relationships;
	}
}
