/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.util;

public class Bounds3D {
	public float minX;
	public float minY;
	public float minZ;
	
	public float width;
	public float height;
	public float depth;
	
	public Bounds3D(float minX, float minY, float minZ, 
					float width, float height, float depth) {
		
		set(minX,minY,minZ,width,height,depth);
	}
	
	public void set(float minX, float minY, float minZ, 
					float width, float height, float depth) {
		this.minX = minX;
		this.minY = minY;
		this.minZ = minZ;
		
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
}
