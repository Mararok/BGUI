/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.scene.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.bgui.scene.ContainerSceneNode;
import com.gmail.mararok.bgui.scene.SceneNode;

public class ContainerSceneNodeImpl extends SceneNodeImpl implements ContainerSceneNode {
	private List<SceneNodeImpl> children;
	
	public ContainerSceneNodeImpl(String id) {
		super(id);
	}

	public ContainerSceneNodeImpl(String id, ContainerSceneNode parentNode) {
		super(id,parentNode);
	}
	
	public void attachChild(SceneNode child) {
		if (children == null) {
			children = new LinkedList<SceneNodeImpl>();
		}
	}

	public void detachChild(SceneNode child) {
		if (children.isEmpty()) {
			children = null;
		}
		
	}
	
	public SceneNodeImpl getChild(int childIndex) {
		return children.get(childIndex);
	}
	
	public Iterator<SceneNodeImpl> getIterator() {
		return children.iterator();
	}
}
