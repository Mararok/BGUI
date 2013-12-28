/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.igui.scene;

import java.util.Iterator;

public interface ParentSceneNode extends SceneNode {
	
	void attachChild(SceneNode child);
	void detachChild(SceneNode child);
	
	SceneNode getChild(int childIndex);
	Iterator<SceneNode> getIterator();
	boolean hasChildren();
}
