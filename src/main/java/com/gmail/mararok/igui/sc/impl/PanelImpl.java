/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.sc.impl;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.control.ControlBase;
import com.gmail.mararok.igui.render.QuadMemoryMesh;
import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.sc.Panel;
import com.gmail.mararok.igui.spi.render.GeometryVisualNode;

public class PanelImpl extends ControlBase implements Panel {
	
	private GeometryVisualNode panelGeometryNode;
	private static int panelCounter = 0;
	public PanelImpl(ImpactGUI gui) {
		super(gui);
		panelGeometryNode = gui.getRenderDevice().createGeometryNode("PANEL:"+(++panelCounter));
		mainVisualNode.attachChild(panelGeometryNode);
		QuadMemoryMesh q = new QuadMemoryMesh();
		q.setColor(0,RGBAColor.RED);
		q.setColor(1,RGBAColor.GREEN);
		q.setColor(2,RGBAColor.BLUE);
		q.setColor(3,RGBAColor.WHITE);
		panelGeometryNode.setMesh(q);
	}
	
}
