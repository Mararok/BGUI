/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.scene;

import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

import com.gmail.mararok.bgui.style.Styleable;

public interface SceneNode extends Styleable {
	String getID();
	
	ParentSceneNode getParent();
	void setParent(ParentSceneNode newParent);
	
	Scene getScene();
	
	void setVisible(boolean visible);
	void show();
	void hide();
	boolean isVisible();
	
	void setEnabled(boolean enabled);
	void enable();
	void disable();
	boolean isEnabled();
	
	void onShow();
	void onHide();
	
	void onEnable();
	void onDisable();
	
	Vector3f getLocalTranslation();
	void setLocalTranslation(float x, float y);
	void setLocalTranslation(float x, float y, float z);
	
	Quat4f getLocalRotation();
	void setLocalRotationX(float angle);
	void setLocalRotationY(float angle);
	void setLocalRotationZ(float angle);
	void setLocalRotation(float xaxis, float yaxis, float zaxis, float angle);
	
	Vector3f getLocalScale();
	void setLocalScale(float scale);
	void setLocalScale(float xscale, float yscale, float zscale);
}
