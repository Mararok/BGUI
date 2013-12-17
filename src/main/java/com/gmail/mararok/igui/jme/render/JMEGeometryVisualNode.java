/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.jme.render;

import com.gmail.mararok.igui.render.MemoryMesh;
import com.gmail.mararok.igui.spi.render.GeometryVisualNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Mesh;
import com.jme3.scene.Mesh.Mode;
import com.jme3.scene.VertexBuffer.Type;

class JMEGeometryVisualNode extends JMEVisualNode implements GeometryVisualNode {
	private static int GeometryCounter = -1;
	private MemoryMesh mesh;
	
	JMEGeometryVisualNode(JMERenderDevice renderDevice) {
		super(renderDevice);
		
		spatial = new Geometry("GN"+(++GeometryCounter),new Mesh());
		getGeometry().setMaterial(renderDevice.getDefaultMaterial());
	}

	@Override
	public MemoryMesh getMesh() {
		return mesh;
	}

	@Override
	public void setMesh(MemoryMesh newMesh) {
		mesh = newMesh;
		updateGeometry();
	}

	@Override
	public void updateGeometry() {
		Mesh realMesh = getGeometry().getMesh();
		
		realMesh.setBuffer(Type.Position,3,mesh.getVeritces());
		
		realMesh.setBuffer(Type.Color,4,mesh.getColors());
		
		if (mesh.getTextureCooridnates() != null) {
			realMesh.setBuffer(Type.TexCoord,2,mesh.getTextureCooridnates());
		}
		
		realMesh.setBuffer(Type.Index,1,mesh.getIndexes());
		
		Mesh.Mode mode = Mode.TriangleStrip;
		
		switch (mesh.getRenderMode()) {
			case LINES: mode = Mesh.Mode.Lines;
				break;
			case LINE_STRIP: mode = Mesh.Mode.LineStrip;
				break;
			case POINTS: mode = Mesh.Mode.Points;
				break;
			case TRIANGLES: mode = Mesh.Mode.Triangles;
				break;
			case TRIANGLE_FAN: mode = Mesh.Mode.TriangleFan;
				break;
			case TRIANGLE_STRIP: mode = Mesh.Mode.TriangleStrip;
				break;
			default:
				break;
	
		}
		realMesh.setMode(mode);
	}

	Geometry getGeometry() {
		return (Geometry)spatial;
	}
}
