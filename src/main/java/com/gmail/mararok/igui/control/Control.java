/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;

import com.gmail.mararok.igui.scene.ParentSceneNode;
import com.jme3.math.Vector2f;

public interface Control extends ParentSceneNode {
	
	void onClick();
	void onDoubleClick();
	void onMouseDown();
	void onMouseUp();
	void onMouseMove();
	void onMouseOver();
	
	void onKeyPress();
	void onKeyDown();
	void onKeyUp();
	
	void onChange();
	void onSelect();
	
	void setEnabled(boolean enabled);
	void enable();
	void disable();
	boolean isEnabled();
	
	void onEnable();
	void onDisable();
	
	Vector2f getPosition();
	void setPosition(int newX, int newY);
	
	int getWidth();
	int getHeight();
	void setSize(int newWidth, int newHeight);
}
