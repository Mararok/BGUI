/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene;

import com.gmail.mararok.igui.util.Rectangle;

public interface SceneNode {
	
	String getID();
	void setID(String newID);
	
	Rectangle getBoundsInLocal();
	
	ParentSceneNode getParent();
	void setParent(ParentSceneNode newParent);
	boolean hasParent();
	
	Scene getScene();
	
	void show();
	void hide();
	boolean isVisible();
	
	void onShow();
	void onHide();
	
	int getX();
	void setX(int newX);
	
	int getY();
	void setY(int newY);
	
	void setPosition(int newX, int newY);
	
	int getZ();
	void setZ(int newZ);
	
	int getWidth();
	void setWidth(int newWidth);
	
	int getHeight();
	void setHeight(int newHeight);
	
	void setSize(int newWidth, int newHeight);
}
