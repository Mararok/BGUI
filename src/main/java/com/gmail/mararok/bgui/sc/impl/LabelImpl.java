/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.sc.impl;

import com.gmail.mararok.bgui.sc.Label;
import com.gmail.mararok.bgui.scene.ParentSceneNode;
import com.gmail.mararok.bgui.scene.impl.SceneNodeImpl;
import com.gmail.mararok.bgui.spi.render.TextVisualNode;

public class LabelImpl extends SceneNodeImpl implements Label {
	
	public LabelImpl(String id) {
		super(id);
	}
	
	public LabelImpl(String id, ParentSceneNode parent) {
		this(id);
		parent.attachChild(this);
	}

	@Override
	public void setText(String newText) {
		((TextVisualNode)visualNode).setText(newText);
	}

	@Override
	public String getText() {
		return ((TextVisualNode)visualNode).getText();
	}
}
