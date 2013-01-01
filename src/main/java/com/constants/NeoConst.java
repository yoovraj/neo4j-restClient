package com.constants;

/**
 * Neo4j Constants 
 * @author yoovraj
 *
 */
public interface NeoConst {

	public static int NO_CONTENT = 204;
	
	public interface Node {
		public static int DELETE_SUCCESS  = 204;
		
		//The relationships on a node has to be deleted before the node can be deleted.
		public static int DELETE_CONFLICT = 409;
	}
	
	public interface Relationship {
		public interface DIRECTION {
			public static String ALL = "all";
			public static String IN  = "in";
			public static String OUT = "out";
		}
		
		public interface PROPERTIES {
			public static int SET_SUCCESS = 204;
		}
	}
}
