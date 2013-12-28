/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;

import gnu.trove.map.hash.THashMap;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.event.EventHandler;
import com.gmail.mararok.igui.event.EventType;
import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.event.mouse.MouseEvent;
import com.gmail.mararok.igui.style.RegionImpl;

public class ControlBase extends RegionImpl {
	private THashMap<String,EventHandler> eventHandlers;
	
	public ControlBase(ImpactGUI gui) {
		super(gui);
	}
	
	public void registerHandler(String eventName, EventHandler handler) {
		if (eventHandlers == null) {
			eventHandlers = new THashMap<String,EventHandler>();
		}
		
		eventHandlers.put(eventName,handler);
	}
	
	public void registerHandler(EventType eventType, EventHandler handler) {
		registerHandler(eventType.toString(),handler);
	}
	
	@Override
	public void onEvent(ImpactEvent event) {
		if (event instanceof MouseEvent) {
			onMouseEvent((MouseEvent)event);
		}
	}
	protected void onMouseEvent(MouseEvent event) {
		event.setX(getLocalX() - event.getX());
		event.setY(getLocalY() - event.getY());
		if (contains(event.getX(),event.getY())) {
			super.onEvent(event);
			EventHandler handler = eventHandlers.get(event.getName());
			if (handler != null) {
				handler.onEvent(event);
			}
		}
		
		event.setX(getLocalX() + event.getX());
		event.setY(getLocalY() + event.getY());
	}
}
