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
		children = new LinkedList<SceneNode>();
	}

	public ParentSceneNodeImpl(String id, ParentSceneNode parentNode) {
		this(id);
		parentNode.attachChild(this);
	}
	
	public void attachChild(SceneNode child) {
		if (child == null) {
			throw new IllegalArgumentException(
					"Can't attach null child to parent: "+this.getID());
		}
		
		child.setParent(this);
		children.add(child);
	}

	public void detachChild(SceneNode child) {
		if (child == null) {
			throw new IllegalArgumentException(
					"Can't detach null child from parent: "+this.getID());
		}
		
		if (child.getParent() != this) {
			throw new IllegalArgumentException(
				"Can't detach child from illegal parent, child: "+child.getID()+", parent: "+this.getID());
		}
		
		children.remove(child);
		child.setParent(null);
	}
	
	public SceneNode getChild(int childIndex) {
		return children.get(childIndex);
	}
	
	public Iterator<SceneNode> getIterator() {
		return children.iterator();
	}
}
