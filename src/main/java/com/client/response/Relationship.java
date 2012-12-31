package com.client.response;

import java.util.HashMap;
import java.util.Map;

public class Relationship {
	String start;
	Map<String, String> data = new HashMap<String, String>();
	String self;
	String property;
	String properties;
	String type;
	Extensions extensions;
	String end;
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Extensions getExtensions() {
		return extensions;
	}
	public void setExtensions(Extensions extensions) {
		this.extensions = extensions;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "Relationship [start=" + start + ", data=" + data + ", self="
				+ self + ", property=" + property + ", properties="
				+ properties + ", type=" + type + ", extensions=" + extensions
				+ ", end=" + end + "]";
	}
	
}
