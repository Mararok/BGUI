/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;

import com.gmail.mararok.igui.scene.SceneNode;

import gnu.trove.map.hash.THashMap;

public class Controls {
	private THashMap<String,ControlBuilder<? extends SceneNode> > controlBuilders;
	public Controls() {
		controlBuilders = new THashMap<>();
	}
	
	public void addControlType(String typeName, ControlBuilder<? extends SceneNode> typeBuilder) {
		controlBuilders.put(typeName, typeBuilder);
	}

	public ControlBuilder<? extends SceneNode> getControlTypeBuilder(String typeName) {
		return controlBuilders.get(typeName);
	}
}
