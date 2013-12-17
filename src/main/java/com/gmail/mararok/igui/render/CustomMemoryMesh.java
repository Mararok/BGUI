/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.render;

public class CustomMemoryMesh implements MemoryMesh {
	
	private float[] vertices;
	private float[] colors;
	private float[] textureCoordinates;
	private short[] indexes;
	
	private int triangleCount;
	
	private RenderMode renderMode = RenderMode.TRIANGLE_STRIP;
	
	@Override
	public float[] getVeritces() {
		return vertices;
	}
	
	@Override
	public void setVertices(float[] newVertices) {
		vertices = newVertices;
		triangleCount = vertices.length/9;
	}

	@Override
	public void setVertex(int vertexIndex, float x, float y, float z) {
		int offset = vertexIndex*VERTEX_COMPONENT_COUNT;
		vertices[offset] = x;
		vertices[offset+1] = y;
		vertices[offset+2] = z;
	}
	
	@Override
	public float[] getColors() {
		return colors;
	}
	
	@Override
	public void setColors(RGBAColor newColor) {
		for (int i = 0; i < getVerticeCount();++i) {
			setColor(i,newColor);
		}
	}
	
	@Override
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
	
	@Override
	public float[] getTextureCooridnates() {
		return textureCoordinates;
	}
	
	@Override
	public void setTextureCoordinates(float[] newTextureCoordinates) {
		textureCoordinates = newTextureCoordinates;
	}

	@Override
	public void setTextureCoordinates(int vertexIndex, float u, float v) {
		int offset = vertexIndex*TEXTURE_COORDINATES_COUNT;
		textureCoordinates[offset] = u;
		textureCoordinates[offset+1] = v;
	}
	
	@Override
	public short[] getIndexes() {
		return indexes;
	}
	
	@Override
	public void setIndexes(short[] newIndexes) {
		indexes = newIndexes;
	}
	
	@Override
	public int getTriangleCount() {
		return triangleCount;
	}
	
	@Override
	public int getVerticeCount() {
		return vertices.length/3;
	}
	
	@Override
	public RenderMode getRenderMode() {
		return renderMode;
	}
	
	@Override
	public void setRenderMode(RenderMode newMode) {
		renderMode = newMode;
	}
	
	
	@Override
	public void translateLocal(float xOffset, float yOffset, float zOffset) {
		int len  = vertices.length;
		for (int i = 0; i < len; i += 3) {
			vertices[i] += xOffset;
			vertices[i+1] += yOffset;
			vertices[i+2] += zOffset;
		}
	}
	
	@Override
	public void scaleLocal(float xScale, float yScale, float zScale) {
		int len  = vertices.length;
		for (int i = 0; i < len; i += 3) {
			vertices[i] *= xScale;
			vertices[i+1] *= yScale;
			vertices[i+2] *= zScale;
		}
	}
}
