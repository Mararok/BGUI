/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.scene.impl;

import java.util.List;

import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

import com.gmail.mararok.bgui.scene.ParentSceneNode;
import com.gmail.mararok.bgui.scene.Scene;
import com.gmail.mararok.bgui.scene.SceneNode;
import com.gmail.mararok.bgui.spi.render.VisualNode;
import com.gmail.mararok.bgui.style.Styleable;

public abstract class SceneNodeImpl implements SceneNode {
	private String id;
	
	private ParentSceneNode parent;
	
	protected VisualNode visualNode;
	
	private boolean visible;
	private boolean enabled;
	
	private String style;
	private List<String> styleClasses;
	
	public SceneNodeImpl(String id) {
		this.id = id;
	}
	
	@Override
	public String getID() {
		return id;
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
		}
		
		parent = newParent;
	}
	
	@Override
	public String getStyle() {
		return style;
	}
	
	@Override
	public void setStyle(String newStyle) {
		style = newStyle;
	}
	
	@Override
	public List<String> getStyleClasses() {
		return styleClasses;
	}
	
	@Override
	public Styleable getStyleableParent() {
		return parent;
	}
	
	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	@Override
	public void show() {
		setVisible(true);
	}
	
	@Override
	public void hide() {
		setVisible(false);
	}
	
	@Override
	public boolean isVisible() {
		return visible;
	}
	
	@Override
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public void enable() {
		setEnabled(true);
	}
	
	@Override
	public void disable() {
		setEnabled(false);
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	@Override
	public Scene getScene() {
		return getParent().getScene();
	}
	
	@Override
	public void onShow() {
		
	}
	
	@Override
	public void onHide() {
		
	}
	
	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@Override
	public Vector3f getLocalTranslation() {
		return visualNode.getLocalTranslation();
	}
	
	@Override
	public void setLocalTranslation(float x, float y) {
		setLocalTranslation(x,y,1f);
	}
	
	@Override
	public void setLocalTranslation(float x, float y, float z) {
		visualNode.setLocalTranslation(x,y,z);
	}
	
	@Override
	public Quat4f getLocalRotation() {
		return visualNode.getLocalRotation();
	}
	
	@Override
	public void setLocalRotationX(float angle) {
		setLocalRotation(1f,0f,0f,angle);
	}
	
	@Override
	public void setLocalRotationY(float angle) {
		setLocalRotation(0f,1f,0f,angle);
	}
	
	@Override
	public void setLocalRotationZ(float angle) {
		setLocalRotation(0f,0f,1f,angle);
	}
	
	@Override
	public void setLocalRotation(float xaxis, float yaxis, float zaxis, float angle) {
		visualNode.setLocalRotation(xaxis,yaxis,zaxis,angle);
	}
	
	@Override
	public Vector3f getLocalScale() {
		return visualNode.getLocalScale();
	}
	
	@Override
	public void setLocalScale(float scale) {
		setLocalScale(scale,scale,scale);
	}
	
	@Override
	public void setLocalScale(float xscale, float yscale, float zscale) {
		visualNode.setLocalScale(xscale,yscale,zscale);
	}
	
	VisualNode getVisualNode() {
		return visualNode;
	}
}
