/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.render;

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
	void setColors(RGBAColor newColor);
	void setColors(float[] newColors);
	void setColor(int vertexIndex, RGBAColor newColor);
	
	float[] getTextureCooridnates();
	void setTextureCoordinates(float[] newTextureCoordinates);
	void setTextureCoordinates(int vertexIndex, float u, float v);
	
	short[] getIndexes();
	
	void setIndexes(short[] newIndexes);
	
	int getTriangleCount();
	int getVerticeCount();
	
	RenderMode getRenderMode();
	
	void setRenderMode(RenderMode newMode);
	
	void translateLocal(float xOffset, float yOffset, float zOffset);
	
	void scaleLocal(float xScale, float yScale, float zScale);
}
