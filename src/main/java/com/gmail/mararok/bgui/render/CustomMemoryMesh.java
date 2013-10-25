/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.render;

public class CustomMemoryMesh implements MemoryMesh {
	
	private float[] vertices;
	private float[] colors;
	private float[] textureCoordinates;
	private short[] indexes;
	
	private int triangleCount;
	
	private RenderMode renderMode = RenderMode.TRIANGLE_STRIP;
	
	public float[] getVeritces() {
		return vertices;
	}
	
	public void setVertices(float[] newVertices) {
		vertices = newVertices;
	}

	public float[] getColors() {
		return colors;
	}
	
	public void setColors(float[] newColors) {
		colors = newColors;
	}

	public float[] getTextureCooridnates() {
		return textureCoordinates;
	}
	
	public void setTextureCoordinates(float[] newTextureCoordinates) {
		textureCoordinates = newTextureCoordinates;
	}

	public short[] getIndexes() {
		return indexes;
	}
	
	public void setIndexes(short[] newIndexes) {
		indexes = newIndexes;
	}
	
	public int getTriangleCount() {
		return triangleCount;
	}
	
	public RenderMode getRenderMode() {
		return renderMode;
	}
	
	public void setRenderMode(RenderMode newMode) {
		renderMode = newMode;
	}
	
	
}
