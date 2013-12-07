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

public abstract class SceneNodeImpl implements SceneNode {
	private String id;
	private ParentSceneNode parent;
	
	protected ParentVisualNode mainVisualNode;
	private ImpactGUI gui;
	
	public SceneNodeImpl(ImpactGUI gui) {
		this.gui = gui;
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
	public Scene getScene() {
		if (hasParent())
			return getParent().getScene();
		return null;
	}

	protected ImpactGUI getGUI() {
		return gui;
	}

}
