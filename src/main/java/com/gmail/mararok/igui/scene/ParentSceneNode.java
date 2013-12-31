/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.scene;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.igui.event.mouse.MouseEvent;

public abstract class ParentSceneNode extends SceneNode {
	protected List<SceneNode> children;
	
	public void attachChild(SceneNode child) {
		if (child == null) {
			throw new IllegalArgumentException(
					"Can't attach null child to parent: "+this.getID());
		}
	
		if (children == null) {
			children = new LinkedList<SceneNode>();
		}
		child.setParent(this);
		child.updateBounds();
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
	
	@Override
	protected void onMouseEvent(MouseEvent event) {
		super.onMouseEvent(event);
		if (children != null) {
			for (SceneNode child : children) {
				((SceneNode)child).onEvent(event);
			}
		}
	}
	

	@Override
	protected void updateBounds() {
		// update in childs;
	}

	@Override
	protected void onAttachToScene(Scene newScene) {
		super.onAttachToScene(newScene);
		if (children != null)
			for (SceneNode child : children) {
				child.onAttachToScene(newScene);
			}
		
	}

	@Override
	protected void onDetachFromScene() {
		super.onDetachFromScene();
		
		if (children != null)
			for (SceneNode child : children) {
				child.onDetachFromScene();
			}
	}
	
}
