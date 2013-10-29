/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.jme.render;

import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.bgui.spi.render.ParentVisualNode;
import com.gmail.mararok.bgui.spi.render.VisualNode;
import com.jme3.scene.Node;

public class JMEParentVisualNode extends JMEVisualNode implements ParentVisualNode {
	private List<VisualNode> children;
	
	JMEParentVisualNode(String id) {
		children = new LinkedList<VisualNode>();
		spatial = new Node(id);
	}
	@Override
	public void attachChild(VisualNode child) {
		child.setParent(this);
		children.add(child);
		
		getNode().attachChild(((JMEVisualNode)child).spatial);
	}

	@Override
	public void detachChild(VisualNode child) {
		child.setParent(null);
		children.remove(child);
		
		getNode().attachChild(((JMEVisualNode)child).spatial);
	}

	@Override
	public void detachAllChildren() {
		for (VisualNode child : children) {
			child.setParent(null);
		}
		
		getNode().detachAllChildren();
		children.clear();
	}

	
	Node getNode() {
		return (Node)spatial;
	}
}
