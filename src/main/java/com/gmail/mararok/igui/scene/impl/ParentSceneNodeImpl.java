/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.scene.ParentSceneNode;
import com.gmail.mararok.igui.scene.SceneNode;
import com.gmail.mararok.igui.spi.render.ParentVisualNode;

public class ParentSceneNodeImpl extends SceneNodeImpl implements ParentSceneNode {
	private List<SceneNode> children;
	
	public ParentSceneNodeImpl(ImpactGUI gui) {
		super(gui);
	}
	
	public ParentSceneNodeImpl(ImpactGUI gui, ParentVisualNode visualNode) {
		this(gui);
		mainVisualNode = visualNode;
	}
	public void attachChild(SceneNode child) {
		if (child == null) {
			throw new IllegalArgumentException(
					"Can't attach null child to parent: "+this.getID());
		}
	
		if (children == null) {
			children = new LinkedList<SceneNode>();
		}
		child.setParent(this);
		children.add((SceneNodeImpl) child);
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
		if (children.size() == 0) {
			children = null;
		}
		child.setParent(null);
	}
	
	public SceneNode getChild(int childIndex) {
		return children.get(childIndex);
	}
	
	public Iterator<SceneNode> getIterator() {
		return children.iterator();
	}
	
	@Override
	public void onEvent(ImpactEvent event) {
		for (SceneNode child : children) {
			((SceneNodeImpl)child).onEvent(event);
		}
	}
	
}
