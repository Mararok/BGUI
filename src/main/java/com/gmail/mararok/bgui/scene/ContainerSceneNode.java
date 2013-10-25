/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.scene;

import java.util.Iterator;

import com.gmail.mararok.bgui.scene.impl.SceneNodeImpl;

public interface ContainerSceneNode extends SceneNode {
	
	void attachChild(SceneNode child);
	void detachChild(SceneNode child);
	
	SceneNodeImpl getChild(int childIndex);
	Iterator<SceneNodeImpl> getIterator();
}
