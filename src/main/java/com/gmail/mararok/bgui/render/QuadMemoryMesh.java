/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.render;

public class QuadMemoryMesh extends CustomMemoryMesh {
	public QuadMemoryMesh() {
		setVertices(new float[] {
			-0.5f,-0.5f,0f,
			0.5f,-0.5f,0f,
			0.5f,0.5f,0f,
			-0.5f,0.5f,0f
			
		});
		
		setColors(new float[] {
				1f,1f,1f,1f,
				1f,1f,1f,1f,
				1f,1f,1f,1f,
				1f,1f,1f,1f
		});
		
		setIndexes(new short[] {
			0,1,2,
			2,3,0
		});
	}
}
