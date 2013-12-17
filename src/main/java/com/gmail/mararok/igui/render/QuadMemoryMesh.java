/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.render;

public class QuadMemoryMesh extends CustomMemoryMesh {
	public QuadMemoryMesh() {
		setVertices(new float[] {
			/*1f,1f,0f,
			-1f,-1f,0f,
			1f,-1f,0f,
			-1f,1f,0f*/
			-1f, -1f,  0f,
			-1f,  1f,  0f,
			 1f,  1f,  0f,
			 1f, -1f,  0f,	
			
		});
		
		setColors(new float[] {
				1f,1f,1f,1f,
				1f,1f,1f,1f,
				1f,1f,1f,1f,
				1f,1f,1f,1f
		});
		
		setIndexes(new short[] {
			0,1,2,
			0,2,3
		});
	}
}
