/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control;

import com.gmail.mararok.igui.ImpactGUI;

public abstract class ControlBase extends RegionImpl implements Control {
	private boolean enabled;
	private boolean visible;
	
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
			//onEnable();
		} else {
			//onDisable();
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
	public void setVisible(boolean visible) {
		if (this.visible == visible) {
			return;
		}
		
		this.visible = visible;
		if (visible) {
			//onShow();
		} else {
			//onHide();
		}
	}

	@Override
	public void show() {
		setVisible(true);
	}

	@Override
	public void hide() {
		setVisible(false);
	}

	@Override
	public boolean isVisible() {
		return enabled;
	}

}
