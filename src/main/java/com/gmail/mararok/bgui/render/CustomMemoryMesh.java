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

	@Override
	public void setVertex(int vertexIndex, float x, float y, float z) {
		int offset = vertexIndex*VERTEX_COMPONENT_COUNT;
		vertices[offset] = x;
		vertices[offset+1] = y;
		vertices[offset+2] = z;
	}
	
	public float[] getColors() {
		return colors;
	}
	
	public void setColors(float[] newColors) {
		colors = newColors;
	}

	@Override
	public void setColor(int vertexIndex, RGBAColor newColor) {
		int offset = vertexIndex*COLOR_COMPONENT_COUNT;
		colors[offset] = newColor.r();
		colors[offset+1] = newColor.g();
		colors[offset+2] = newColor.b();
		colors[offset+3] = newColor.a();
	}
	
	public float[] getTextureCooridnates() {
		return textureCoordinates;
	}
	
	public void setTextureCoordinates(float[] newTextureCoordinates) {
		textureCoordinates = newTextureCoordinates;
	}

	public void setTextureCoordinates(int vertexIndex, float u, float v) {
		int offset = vertexIndex*TEXTURE_COORDINATES_COUNT;
		textureCoordinates[offset] = u;
		textureCoordinates[offset+1] = v;
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
