/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.jme.render;

import com.gmail.mararok.igui.spi.render.Font;
import com.gmail.mararok.igui.spi.render.GeometryVisualNode;
import com.gmail.mararok.igui.spi.render.Image;
import com.gmail.mararok.igui.spi.render.MouseCursor;
import com.gmail.mararok.igui.spi.render.ParentVisualNode;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.gmail.mararok.igui.spi.render.TextVisualNode;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.scene.Node;

public class JMERenderDevice implements RenderDevice {
	private Node guiNode;
	private JMEParentVisualNode rootGUINode;
	private AssetManager assetManager;
	private Material defaultMaterial;
	
	public JMERenderDevice(Node guiNode, AssetManager assetManager) {
		this.guiNode = guiNode;
		rootGUINode = new JMEParentVisualNode("rootGUI");
		this.guiNode.attachChild(rootGUINode.getNode());
		this.assetManager = assetManager;
		defaultMaterial = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
		defaultMaterial.setBoolean("VertexColor",true);
	}
	
	@Override
	public Font createFont(String fontName, Font.Style style, int size) {
		JMEFont font = new JMEFont();
		font.setFont(new java.awt.Font(fontName,style.toAWTStyle(),size));
		return font;
	}

	@Override
	public Image createImage(String filename) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MouseCursor createMouseCursor(String filename, int hotspotX,
			int hotspotY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParentVisualNode createParentNode(String id) {
		return new JMEParentVisualNode(id);
	}

	@Override
	public GeometryVisualNode createGeometryNode(String id) {
		return new JMEGeometryVisualNode(id,this);
	}

	@Override
	public TextVisualNode createTextNode(String id) {
		return new JMETextVisualNode(id);
	}

	@Override
	public void enableMouseCursor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disableMouseCursor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getWidth() {
		return 800;
	}

	@Override
	public int getHeight() {
		return 600;
	}
	
	public JMEParentVisualNode getRootGUINode() {
		return rootGUINode;
	}
	
	public AssetManager getAssetManager() {
		return assetManager;
	}
	
	public Material getDefaultMaterial() {
		return defaultMaterial;
	}

}
