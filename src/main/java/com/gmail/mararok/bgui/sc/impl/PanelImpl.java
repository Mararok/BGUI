/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.sc.impl;

import com.gmail.mararok.bgui.render.MemoryMesh;
import com.gmail.mararok.bgui.sc.Panel;
import com.gmail.mararok.bgui.scene.impl.ParentSceneNodeImpl;

public class PanelImpl extends ParentSceneNodeImpl implements Panel {
	private MemoryMesh mesh;
	
	public PanelImpl(String id) {
		super(id);
	}
	
}
