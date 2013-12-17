/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene;

public interface SceneNode {
	String getID();
	void setID(String newID);
	
	ParentSceneNode getParent();
	void setParent(ParentSceneNode newParent);
	boolean hasParent();
	
	Scene getScene();
	
	void setFocus(boolean focus);
	boolean hasFocus();
}
