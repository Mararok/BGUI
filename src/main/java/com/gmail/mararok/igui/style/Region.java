/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import com.gmail.mararok.igui.scene.ParentSceneNode;

public interface Region extends ParentSceneNode, Styleable {
	public int getLocalCenterX();
	public int getLocalCenterY();
	
	public int getLocalX();
	public void setLocalX(int newX);
	
	public int getLocalY();
	public void setLocalY(int newY);
	
	public void setLocalPosition(int newX, int newY);
	
	public int getLocalZ();
	public void setLocalZ(int newZ);
	
	public int getWidth();
	public void setWidth(int newWidth);
	
	public int getHeight();
	public void setHeight(int newHeight);
	
	public void setSize(int newWidth, int newHeight);
}
