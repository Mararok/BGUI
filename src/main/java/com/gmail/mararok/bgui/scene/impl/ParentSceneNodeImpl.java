/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.scene.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.bgui.scene.ParentSceneNode;
import com.gmail.mararok.bgui.scene.SceneNode;

public class ParentSceneNodeImpl extends SceneNodeImpl implements ParentSceneNode {
	private List<SceneNode> children;
	
	public ParentSceneNodeImpl(String id) {
		super(id);
	}

	public ParentSceneNodeImpl(String id, ParentSceneNode parentNode) {
		super(id,parentNode);
	}
	
	public void attachChild(SceneNode child) {
		if (children == null) {
			children = new LinkedList<SceneNode>();
		}
		children.add(child);
		getVisualNode();
	}

	public void detachChild(SceneNode child) {
		if (children.isEmpty()) {
			children = null;
		}
		
	}
	
	public SceneNode getChild(int childIndex) {
		return children.get(childIndex);
	}
	
	public Iterator<SceneNode> getIterator() {
		return children.iterator();
	}
}
