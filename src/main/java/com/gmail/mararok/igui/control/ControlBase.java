/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.scene.impl.ParentSceneNodeImpl;
import com.jme3.math.Vector2f;

public abstract class ControlBase extends ParentSceneNodeImpl implements Control {
	private Vector2f position;
	private int width;
	private int height;
	
	public ControlBase(ImpactGUI gui) {
		super(gui);
		position = new Vector2f();
	}

	@Override
	public Vector2f getPosition() {
		return position.clone();
	}
	
	@Override
	public void setPosition(int newX, int newY) {
		position.set(newX,newY);
		setTranslation(getWidth()/2+newX,getHeight()/2+newY);
	}
	
	@Override
	public int getWidth() {
		return width;
	}
	
	@Override
	public int getHeight() {
		return height;
	}
	
	@Override
	public void setSize(int newWidth, int newHeight) {
		width = newWidth;
		height = newHeight;
		setScale(newWidth,newHeight,1);
	}
	
	@Override
	public void onClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDoubleClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMouseOver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyPress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onKeyUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onChange() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSelect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}
}
