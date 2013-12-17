/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;

public interface Control extends Region {
	
	void setEnabled(boolean enabled);
	void enable();
	void disable();
	boolean isEnable();
	
	void setVisible(boolean visible);
	void show();
	void hide();
	boolean isVisible();
	
}
