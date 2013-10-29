/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.jme.render;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.LinkedList;

import com.gmail.mararok.bgui.render.MemoryMesh;
import com.gmail.mararok.bgui.render.QuadMemoryMesh;
import com.gmail.mararok.bgui.spi.render.Font;
import com.gmail.mararok.bgui.spi.render.TextVisualNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.util.BufferUtils;

public class JMETextVisualNode extends JMEVisualNode implements TextVisualNode {
	private Font font;
	private Color color;
	private String text;
	
	private LinkedList<QuadMemoryMesh> memoryMeshes;
	
	private int currentIndexOffset = 0;
	
	JMETextVisualNode(String id) {
		spatial = new Geometry(id,new Mesh());
		memoryMeshes = new LinkedList<QuadMemoryMesh>();
		setColor(Color.WHITE);
	}
	
	@Override
	public Font getFont() {
		return font;
	}

	@Override
	public void setFont(Font newFont) {
		setFont(newFont);
		updateGeometry();
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color newColor) {
		color = newColor;
		updateGeometry();
	}

	@Override
	public void setColor(float red, float green, float blue) {
		setColor(new Color(red,green,blue));
	}

	@Override
	public void setText(String newText) {
		text = newText;
		memoryMeshes.clear();
		updateGeometry();
	}

	@Override
	public String getText() {
		return text;
	}

	private void updateGeometry() {
		Mesh realMesh = getGeometry().getMesh();
		FloatBuffer positionBuffer = BufferUtils.createFloatBuffer(
			getText().length()*MemoryMesh.VERTEX_COMPONENT_COUNT*MemoryMesh.QUAD_VERTEX_COUNT);
		FloatBuffer colorBuffer = BufferUtils.createFloatBuffer(
				getText().length()*MemoryMesh.COLOR_COMPONENT_COUNT*MemoryMesh.QUAD_VERTEX_COUNT);
		
		FloatBuffer texCoordBuffer = BufferUtils.createFloatBuffer(
				getText().length()*2*MemoryMesh.QUAD_VERTEX_COUNT);
		
		ShortBuffer indexBuffer = BufferUtils.createShortBuffer(getText().length()*6);
		
		currentIndexOffset = 0;
		for (QuadMemoryMesh memoryMesh : memoryMeshes) {
			positionBuffer.put(memoryMesh.getVeritces());
			colorBuffer.put(memoryMesh.getColors());
			texCoordBuffer.put(memoryMesh.getTextureCooridnates());
			short[] indexes = memoryMesh.getIndexes();
			for (int j = 0; j < indexes.length; ++j) {
				indexBuffer.put((short)(indexes[j]+currentIndexOffset));
			}
			currentIndexOffset += 4;
		}

		realMesh.setBuffer(Type.Position,3,positionBuffer);
		realMesh.setBuffer(Type.Color,4,colorBuffer);
		realMesh.setBuffer(Type.TexCoord,2,texCoordBuffer);
		realMesh.setBuffer(Type.Index,1,indexBuffer);
		
		//realMesh.setMode(Mesh.Mode.TriangleStrip);
	}
	
	private Geometry getGeometry() {
		return (Geometry)spatial;
	}
}