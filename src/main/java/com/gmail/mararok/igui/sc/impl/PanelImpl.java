/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.sc.impl;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.control.ControlBase;
import com.gmail.mararok.igui.render.QuadMemoryMesh;
import com.gmail.mararok.igui.sc.Panel;
import com.gmail.mararok.igui.spi.render.GeometryVisualNode;

public class PanelImpl extends ControlBase implements Panel {
	private GeometryVisualNode panelGeometryNode;
	private static int panelCounter = -1;
	public PanelImpl(ImpactGUI gui) {
		super(gui);
		panelGeometryNode = gui.getRenderDevice().createGeometryNode("PANEL:"+(++panelCounter));
		mainVisualNode.attachChild(panelGeometryNode);
		panelGeometryNode.setMesh(new QuadMemoryMesh());
		panelGeometryNode.setLocalScale(800,600,1);
	}
	
}
