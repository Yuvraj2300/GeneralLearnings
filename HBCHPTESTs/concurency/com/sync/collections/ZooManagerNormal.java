package com.sync.collections;

import java.util.HashMap;
import java.util.Map;

public class ZooManagerNormal {

	/*
	 * public synchronized void put(String key, String value) { foodData.put(key,
	 * value); }
	 * 
	 * public synchronized void get(String key) { foodData.get(key); }
	 */

	public static void main(String[] args) {
		 Map<String, Object> foodData = new HashMap<>();
		 foodData.put("1", "Ghaas");
		 foodData.put("2", "phoos");
		 for(String	key: foodData.keySet()) {
			 foodData.remove(key);
		 }
		 
	}

}
