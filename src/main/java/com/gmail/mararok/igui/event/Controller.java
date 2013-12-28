/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event;

import com.esotericsoftware.reflectasm.MethodAccess;

public class Controller {
	private MethodAccess methods;
	
	int getMethodIndex(String methodName) {
		return methods.getIndex(methodName);
	}
	
	void onEvent(ImpactEvent event, int methodIndex) {
		methods.invoke(this,methodIndex,event);
	}

}
