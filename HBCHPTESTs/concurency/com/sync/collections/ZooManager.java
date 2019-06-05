package com.sync.collections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ZooManager {
	private Map<Object, Object> foodData = new ConcurrentHashMap<>();

	public void set(String k, String v) {
		foodData.put(k, v);
	}
}
