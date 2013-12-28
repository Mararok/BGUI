/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control.standard.impl;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.control.standard.Panel;
import com.gmail.mararok.igui.render.QuadMemoryMesh;
import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.spi.render.GeometryVisualNode;
import com.gmail.mararok.igui.style.RegionImpl;
import com.gmail.mararok.igui.style.attributes.Attribute;
import com.gmail.mararok.igui.style.attributes.AttributeType;
import com.gmail.mararok.igui.style.attributes.ColorAttribute;

public class PanelImpl extends RegionImpl implements Panel {
	private GeometryVisualNode geometry;
	
	private RGBAColor backgroundColor;
	
	public PanelImpl(ImpactGUI gui) {
		super(gui);
		geometry = gui.getRenderDevice().createGeometryNode();
		geometry.setMesh(new QuadMemoryMesh());
		mainVisualNode.attachChild(geometry);
		setLocalPosition(0,0);
	}
	
	@Override
	public RGBAColor getBackgroundColor() {
		return backgroundColor;
	}
	
	@Override
	public void setBackgroundColor(RGBAColor newColor) {
		geometry.getMesh().setColors(newColor);
		geometry.updateGeometry();
		backgroundColor = newColor;
	}
	
	@Override
	public void updateAttribute(AttributeType type, Attribute value) {
		switch (type) {
		case background: {
			setBackgroundColor(((ColorAttribute)value).getColor());
		}
		default:
			break;
		}
	}
	
}
