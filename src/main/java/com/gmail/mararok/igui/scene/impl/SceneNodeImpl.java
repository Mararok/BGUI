/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene.impl;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.scene.ParentSceneNode;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.scene.SceneNode;
import com.gmail.mararok.igui.spi.render.ParentVisualNode;
import com.gmail.mararok.igui.util.Rectangle;

public abstract class SceneNodeImpl implements SceneNode {
	private String id;
	private Rectangle localBounds;
	private int z;
	private boolean visible;
	private ParentSceneNode parent;
	
	protected ParentVisualNode mainVisualNode;
	private ImpactGUI gui;
	
	public SceneNodeImpl(ImpactGUI gui) {
		this.gui = gui;
		localBounds = new Rectangle(0,0,0,0);
	}
	
	@Override
	public String getID() {
		return id;
	}
	
	@Override
	public void setID(String newID) {
		id = newID;
	}
	
	@Override
	public Rectangle getBoundsInLocal() {
		return localBounds;
	}
	
	@Override
	public ParentSceneNode getParent() {
		return parent;
	}
	
	@Override
	public boolean hasParent() {
		return parent != null;
	}
	
	@Override
	public void setParent(ParentSceneNode newParent) {
		if (hasParent()) {
			getParent().detachChild(this);
			((ParentSceneNodeImpl)getParent()).mainVisualNode.detachChild(mainVisualNode);
		}
		
		parent = newParent;
		((ParentSceneNodeImpl)getParent()).mainVisualNode.attachChild(mainVisualNode);
	}
	
	@Override
	public void show() {
		setVisible(true);
	}
	
	@Override
	public void hide() {
		setVisible(false);
	}
	
	protected void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	@Override
	public boolean isVisible() {
		if (hasParent()) {
			return getParent().isVisible()&&visible;
		}
		
		return visible;
	}
	
	@Override
	public Scene getScene() {
		if (hasParent())
			return getParent().getScene();
		return null;
	}
	
	@Override
	public void onShow() {
		
	}
	
	@Override
	public void onHide() {
		
	}
	
	@Override
	public int getX() {
		return localBounds.x;
	}

	@Override
	public void setX(int newX) {
		localBounds.x = newX;
		
	}

	@Override
	public int getY() {
		return localBounds.y;
	}

	@Override
	public void setY(int newY) {
		localBounds.y = newY;
		
	}

	@Override
	public void setPosition(int newX, int newY) {
		setX(newX);
		setY(newY);
	}

	@Override
	public int getZ() {
		return z;
	}

	@Override
	public void setZ(int newZ) {
		z = newZ;
	}

	@Override
	public int getWidth() {
		return localBounds.width;
	}

	@Override
	public void setWidth(int newWidth) {
		localBounds.width = newWidth;
	}

	@Override
	public int getHeight() {
		return localBounds.height;
	}

	@Override
	public void setHeight(int newHeight) {
		localBounds.height = newHeight;
	}

	@Override
	public void setSize(int newWidth, int newHeight) {
		setWidth(newWidth);
		setHeight(newHeight);
	}

	protected ImpactGUI getGUI() {
		return gui;
	}

}
