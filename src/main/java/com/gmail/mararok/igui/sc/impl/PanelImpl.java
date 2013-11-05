/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.sc.impl;

import com.gmail.mararok.igui.render.MemoryMesh;
import com.gmail.mararok.igui.sc.Panel;
import com.gmail.mararok.igui.scene.impl.ParentSceneNodeImpl;

public class PanelImpl extends ParentSceneNodeImpl implements Panel {
	private MemoryMesh mesh;
	
	public PanelImpl(String id) {
		super(id);
	}
	
}
