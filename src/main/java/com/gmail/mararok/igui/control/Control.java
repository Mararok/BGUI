/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;

import com.gmail.mararok.igui.scene.ParentSceneNode;

public interface Control extends ParentSceneNode,Region {
	
	/*void onClick();
	void onDoubleClick();
	void onMouseDown();
	void onMouseUp();
	void onMouseMove();
	void onMouseOver();
	
	void onKeyPress();
	void onKeyDown();
	void onKeyUp();
	
	void onChanged();
	void onSelect();
	*/
	void setEnabled(boolean enabled);
	void enable();
	void disable();
	boolean isEnable();
	
	//void onEnable();
	//void onDisable();
	
	void setVisible(boolean visible);
	void show();
	void hide();
	boolean isVisible();
	
	//void onShow();
	//void onHide();
	
}
