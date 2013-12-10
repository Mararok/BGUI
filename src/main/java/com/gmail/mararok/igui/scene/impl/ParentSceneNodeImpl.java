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
import com.gmail.mararok.igui.scene.ParentSceneNode;
import com.gmail.mararok.igui.scene.SceneNode;

public abstract class ParentSceneNodeImpl extends SceneNodeImpl implements ParentSceneNode {
	private List<SceneNode> children;
	private static int parentCounter = 0;
	public ParentSceneNodeImpl(ImpactGUI gui) {
		super(gui);
		mainVisualNode = gui.getRenderDevice().createParentNode("PARENT:"+(++parentCounter));
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
}
