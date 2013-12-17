/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.jme.render;

import com.gmail.mararok.igui.spi.render.Font;
import com.gmail.mararok.igui.spi.render.GeometryVisualNode;
import com.gmail.mararok.igui.spi.render.Image;
import com.gmail.mararok.igui.spi.render.ParentVisualNode;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.gmail.mararok.igui.spi.render.TextVisualNode;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;

public class JMERenderDevice implements RenderDevice {
	private JMEParentVisualNode rootGUINode;
	private AssetManager assetManager;
	private Camera currentCamera;
	
	//private MouseCursor mainMouseCursor;
	private Font defaultFont;
	private Material defaultMaterial;
	
	public JMERenderDevice(Node guiNode, AssetManager assetManager,Camera camera) {
		rootGUINode = new JMEParentVisualNode(guiNode,this);
		this.assetManager = assetManager;
		currentCamera = camera;
		
		defaultMaterial = new Material(assetManager,"Common/MatDefs/Misc/Unshaded.j3md");
		defaultMaterial.setBoolean("VertexColor",true);
		defaultFont = createFont("Interface/Fonts/Console.fnt");
	}
	
	@Override
	public Font createFont(String fontName) {
		return new JMEFontAC(assetManager.loadFont(fontName));
	}
	
	@Override
	public Font createFont(String fontName, Font.Style style, int size) {
		return createFont(fontName);
	}

	@Override
	public Image createImage(String filename) {
		return new JMEImage(assetManager.loadTexture(filename));
	}

	@Override
	public ParentVisualNode createParentNode() {
		return new JMEParentVisualNode(this);
	}

	@Override
	public GeometryVisualNode createGeometryNode() {
		return new JMEGeometryVisualNode(this);
	}

	@Override
	public TextVisualNode createTextNode() {
		return new JMETextVisualNodeAC(this);
	}

	@Override
	public void showMouseCursor() {
		
	}

	@Override
	public void hideMouseCursor() {
		
	}

	@Override
	public int getWidth() {
		return currentCamera.getWidth();
	}

	@Override
	public int getHeight() {
		return currentCamera.getHeight();
	}
	
	public JMEParentVisualNode getRootGUINode() {
		return rootGUINode;
	}
	
	AssetManager getAssetManager() {
		return assetManager;
	}
	
	Material getDefaultMaterial() {
		return defaultMaterial;
	}

	@Override
	public Font getDefaultFont() {
		return defaultFont;
	}

}
