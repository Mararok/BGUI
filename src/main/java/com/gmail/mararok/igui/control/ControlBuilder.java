/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.scene.SceneNode;

public abstract class ControlBuilder<T extends SceneNode> {
	public abstract T build(ImpactGUI igui);
}
