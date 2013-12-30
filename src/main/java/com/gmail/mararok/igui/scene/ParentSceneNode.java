/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.style.attributes.Attribute;
import com.gmail.mararok.igui.style.attributes.AttributeType;

public class ParentSceneNode extends SceneNode {
	private List<SceneNode> children;
	
	public void attachChild(SceneNode child) {
		if (child == null) {
			throw new IllegalArgumentException(
					"Can't attach null child to parent: "+this.getID());
		}
	
		if (children == null) {
			children = new LinkedList<SceneNode>();
		}
		child.setParent(this);
		children.add((SceneNode) child);
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
	
	public boolean hasChildren() {
		return children != null;
	}
	
	public void onEvent(ImpactEvent event) {
		if (children != null) {
			for (SceneNode child : children) {
				((SceneNode)child).onEvent(event);
			}
		}
	}

	@Override
	public void updateAttribute(AttributeType type, Attribute attribute) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateBounds() {
		// update in childs;
	}

	@Override
	protected void onAttachToScene() {
		if (children != null)
			for (SceneNode child : children) {
				child.onAttachToScene();
			}
		
	}

	@Override
	protected void onDetachFromScene() {
		if (children != null)
			for (SceneNode child : children) {
				child.onAttachToScene();
			}
	}
	
}
