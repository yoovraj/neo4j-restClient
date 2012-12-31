package com.client.data;

import java.util.HashMap;
import java.util.Map;

import com.config.NeoConfig;

public class RelationshipNodeParam {

	String from;
	String to;
	String type;
	Map<String, String> data = new HashMap<String, String>();
		
	public RelationshipNodeParam(int from, int to, String type, Map<String, String> data) {
		this.from = String.valueOf(from);
		this.to = String.valueOf(to);
		this.type = type;
		this.data = data;
	}
	
	public RelationshipNodeParam(int from, int to, String type) {
		this.from = String.valueOf(from);
		this.to = String.valueOf(to);
		this.type = type;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Map<String, String> getData() {
		return data;
	}
	public void setData(Map<String, String> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "RelationshipReqParam [to=" + to + ", type=" + type + ", data="
				+ data + "]";
	}
	public void reconfigure (NeoConfig config) {
		to = config.getNodeURI(Integer.parseInt(to));
	}
//	public String toJSONString(final NeoConfig config) {
//		final int toURI  = this.to;
//		return new Gson().toJson(new Object() {String to = config.getNeoHost() + config.getNodeRelationsURI(toURI);});
//	}
	
}