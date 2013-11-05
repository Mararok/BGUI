/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.render;

public interface ParentVisualNode extends VisualNode {
	
	void attachChild(VisualNode child);
	void detachChild(VisualNode child);
	void detachAllChildren();
}
