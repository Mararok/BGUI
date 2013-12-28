/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event;


public class EventHandler {
	private Controller controller;
	private String callbackName;
	private int methodIndex;
	
	public EventHandler(Controller controller, String callbackName) {
		this.controller = controller;
		this.callbackName = callbackName;
		this.methodIndex = controller.getMethodIndex(callbackName);
	}
	
	public void onEvent(ImpactEvent event) {
		controller.onEvent(event,methodIndex);
	}
	
	public Controller getController() {
		return controller;
	}

	public String getCallbackName() {
		return callbackName;
	}
}
