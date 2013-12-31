/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.render;

public class SolidGradient implements Gradient {
	public RGBAColor color;
	public SolidGradient(RGBAColor color) {
		this.color = color;
	}

	public RGBAColor getColor() {
		return color;
	}

	@Override
	public void setMeshColors(MemoryMesh mesh) {
		mesh.setColors(color);
	}
}
