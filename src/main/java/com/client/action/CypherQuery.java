package com.client.action;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class CypherQuery {
	String query;
	Map<String, String> params = new HashMap<String, String>();
	public CypherQuery(String query, Map<String, String> params) {
		super();
		this.query = query;
		this.params = params;
	}
	
	public CypherQuery(String query) {
		super();
		this.query = query;
	}

	public CypherQuery() {
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Map<String, String> getParams() {
		return params;
	}
	public void setParams(Map<String, String> params) {
		this.params = params;
	}
	public String toJsonString() {
		return new Gson().toJson(this);
	}
}
