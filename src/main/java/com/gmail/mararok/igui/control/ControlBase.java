/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;

import com.gmail.mararok.igui.ImpactGUI;

public abstract class ControlBase extends ControlRegion implements Control {
	private boolean enabled;
	private boolean visibled;
	
	public ControlBase(ImpactGUI gui) {
		super(gui);
	}

	@Override
	public void setEnabled(boolean enable) {
		if (enabled == enable) {
			return;
		}
		
		enabled = enable;
		if (enable) {
			onEnable();
		} else {
			onDisable();
		}
	}

	@Override
	public void enable() {
		setEnabled(true);
	}

	@Override
	public void disable() {
		setEnabled(false);
	}

	@Override
	public boolean isEnable() {
		return enabled;
	}
	
	
	@Override
	public void setVisibled(boolean visible) {
		if (visibled == visible) {
			return;
		}
		
		visibled = visible;
		if (visible) {
			onShow();
		} else {
			onHide();
		}
	}

	@Override
	public void show() {
		setVisibled(true);
	}

	@Override
	public void hide() {
		setVisibled(false);
	}

	@Override
	public boolean isVisible() {
		return enabled;
	}

}
