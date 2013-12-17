/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event;

import com.gmail.mararok.igui.scene.Scene;

public interface SceneController {
	void bind(Scene scene);
	
	void onSceneEnable();
	void onSceneDisable();
}
