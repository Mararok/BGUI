/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.render;

public class FanMemoryMesh extends CustomMemoryMesh {
	
	public FanMemoryMesh() {
		setVertices(new float[] {
			0f,0f,0f,
			1f,1f,0f,
			-1f,-1f,0f,
			1f,-1f,0f,
			-1f,1f,0f
				
		});
			
		setColors(new float[] {
			1f,1f,1f,1f,
			1f,1f,1f,1f,
			1f,1f,1f,1f,
			1f,1f,1f,1f,
			1f,1f,1f,1f
		});
		setRenderMode(RenderMode.TRIANGLE_FAN);
	}
}
