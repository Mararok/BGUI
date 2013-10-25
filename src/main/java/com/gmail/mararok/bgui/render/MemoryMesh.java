/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.render;

public interface MemoryMesh {
	public enum RenderMode {
		LINES,
		LINE_STRIP,
		POINTS,
		TRIANGLE_FAN,
		TRIANGLES,
		TRIANGLE_STRIP
	};
	
	public static final int VERTEX_COMPONENT_COUNT = 3;
	public static final int COLOR_COMPONENT_COUNT = 4;
	public static final int TEXTURE_COORDINATES_COUNT = 2;
	
	public static final int TRIANGLE_VERTEX_COUNT = 3;
	public static final int QUAD_VERTEX_COUNT = 4;
	
	public float[] getVeritces();
	
	public void setVertices(float[] newVertices);

	public float[] getColors();
	
	public void setColors(float[] newColors);

	public float[] getTextureCooridnates();
	
	public void setTextureCoordinates(float[] newTextureCoordinates);

	public short[] getIndexes();
	
	public void setIndexes(short[] newIndexes);
	
	public int getTriangleCount();
	
	public RenderMode getRenderMode();
	
	public void setRenderMode(RenderMode newMode);
}
