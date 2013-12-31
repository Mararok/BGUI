/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event;

import gnu.trove.map.hash.THashMap;

public class Events {
	private THashMap<String,String> eventTypes;
	
	public Events() {
		eventTypes = new THashMap<String,String>();
	}
	
	public void register(String eventPropertyName,String eventTypeName) {
		eventTypes.put(eventPropertyName.toLowerCase(),eventTypeName);
	}
	
	public String getEventName(String eventPropertyName) {
		return eventTypes.get(eventPropertyName.toLowerCase());
	}
}
