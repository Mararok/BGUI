/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.sc.impl;

import java.awt.Color;

import com.gmail.mararok.bgui.sc.Label;
import com.gmail.mararok.bgui.scene.ParentSceneNode;
import com.gmail.mararok.bgui.scene.impl.SceneNodeImpl;

public class LabelImpl extends SceneNodeImpl implements Label {
	
	public LabelImpl(String id) {
		super(id);
	}
	
	public LabelImpl(String id, ParentSceneNode parent) {
		super(id,parent);
	}

	@Override
	public void setText(String newText) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}
}
