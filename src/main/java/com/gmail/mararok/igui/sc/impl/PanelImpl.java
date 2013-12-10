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
	private GeometryVisualNode geometry;
	public PanelImpl(ImpactGUI gui) {
		super(gui);
		geometry = gui.getRenderDevice().createGeometryNode("pgeometry");
		geometry.setMesh(new QuadMemoryMesh());
		mainVisualNode.attachChild(geometry);
	}
	
	@Override
	public void setBackgroundColor(RGBAColor newColor) {
		geometry.getMesh().setColors(newColor);
		geometry.updateGeometry();
	}
	
}
