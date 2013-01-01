package com.client.response;

import java.util.Map;

/**
 * Node data information
 * @author yoovraj
 *
 */
public class Node {
	String outgoing_relationships;
	Map<String, String > data ;
	String traverse;
	String all_typed_relationships;
	String property;
	String self;
	String properties;
	String outgoing_typed_relationships;
	String incoming_relationships;
	String create_relationship;
	String paged_traverse;
	String all_relationships;
	String incoming_typed_relationships;
	
	Extensions extensions;
	public String getOutgoing_relationships() {
		return outgoing_relationships;
	}
	public void setOutgoing_relationships(String outgoing_relationships) {
		this.outgoing_relationships = outgoing_relationships;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	public String getTraverse() {
		return traverse;
	}
	public void setTraverse(String traverse) {
		this.traverse = traverse;
	}
	public String getAll_typed_relationships() {
		return all_typed_relationships;
	}
	public void setAll_typed_relationships(String all_typed_relationships) {
		this.all_typed_relationships = all_typed_relationships;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	public String getOutgoing_typed_relationships() {
		return outgoing_typed_relationships;
	}
	public void setOutgoing_typed_relationships(String outgoing_typed_relationships) {
		this.outgoing_typed_relationships = outgoing_typed_relationships;
	}
	public String getIncoming_relationships() {
		return incoming_relationships;
	}
	public void setIncoming_relationships(String incoming_relationships) {
		this.incoming_relationships = incoming_relationships;
	}
	public String getCreate_relationship() {
		return create_relationship;
	}
	public void setCreate_relationship(String create_relationship) {
		this.create_relationship = create_relationship;
	}
	public String getPaged_traverse() {
		return paged_traverse;
	}
	public void setPaged_traverse(String paged_traverse) {
		this.paged_traverse = paged_traverse;
	}
	public String getAll_relationships() {
		return all_relationships;
	}
	public void setAll_relationships(String all_relationships) {
		this.all_relationships = all_relationships;
	}
	public String getIncoming_typed_relationships() {
		return incoming_typed_relationships;
	}
	public void setIncoming_typed_relationships(String incoming_typed_relationships) {
		this.incoming_typed_relationships = incoming_typed_relationships;
	}
	
	public Extensions getExtensions() {
		return extensions;
	}
	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}
	@Override
	public String toString() {
		return "Node [outgoing_relationships=" + outgoing_relationships
				+ ", data=" + data + ", traverse=" + traverse
				+ ", all_typed_relationships=" + all_typed_relationships
				+ ", property=" + property + ", self=" + self + ", properties="
				+ properties + ", outgoing_typed_relationships="
				+ outgoing_typed_relationships + ", incoming_relationships="
				+ incoming_relationships + ", create_relationship="
				+ create_relationship + ", paged_traverse=" + paged_traverse
				+ ", all_relationships=" + all_relationships
				+ ", incoming_typed_relationships="
				+ incoming_typed_relationships + "]";
	}

}
