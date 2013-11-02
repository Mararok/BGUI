/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.render;

public interface MemoryMesh {
	enum RenderMode {
		LINES,
		LINE_STRIP,
		POINTS,
		TRIANGLE_FAN,
		TRIANGLES,
		TRIANGLE_STRIP
	};
	
	static final int VERTEX_COMPONENT_COUNT = 3;
	static final int COLOR_COMPONENT_COUNT = 4;
	static final int TEXTURE_COORDINATES_COUNT = 2;
	
	static final int TRIANGLE_VERTEX_COUNT = 3;
	static final int QUAD_VERTEX_COUNT = 4;
	
	float[] getVeritces();
	void setVertices(float[] newVertices);
	void setVertex(int vertexIndex, float x, float y, float z);
	
	float[] getColors();
	void setColors(float[] newColors);
	void setColor(int vertexIndex, RGBAColor newColor);
	
	float[] getTextureCooridnates();
	void setTextureCoordinates(float[] newTextureCoordinates);
	void setTextureCoordinates(int vertexIndex, float u, float v);
	
	short[] getIndexes();
	
	void setIndexes(short[] newIndexes);
	
	int getTriangleCount();
	
	RenderMode getRenderMode();
	
	void setRenderMode(RenderMode newMode);
}
