/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.jme.input;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.jme.render.JMEMouseCursor;
import com.gmail.mararok.igui.spi.input.InputDevice;
import com.gmail.mararok.igui.spi.render.MouseCursor;
import com.jme3.input.InputManager;
import com.jme3.input.RawInputListener;
import com.jme3.input.event.JoyAxisEvent;
import com.jme3.input.event.JoyButtonEvent;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.MouseMotionEvent;
import com.jme3.input.event.TouchEvent;
import com.jme3.math.Vector2f;

public class JMEInputDevice implements InputDevice {
	private InputManager jmeInputManager;
	public ImpactGUI igui;
	
	public JMEInputDevice(InputManager inputManager) {
		
		jmeInputManager = inputManager;
		jmeInputManager.addRawInputListener(new RawInputListener() {
			@Override
			public void onTouchEvent(TouchEvent event) {
				// empty
			}
			
			@Override
			public void onMouseMotionEvent(MouseMotionEvent event) {
				// TODO send my motion event to scene graph;
			}
			
			@Override
			public void onMouseButtonEvent(MouseButtonEvent event) {
				// TODO send my button event to scene graph;
				
			}
			
			@Override
			public void onKeyEvent(KeyInputEvent event) {
				// TODO send my key event to scene graph;
				
			}
			
			@Override
			public void onJoyButtonEvent(JoyButtonEvent event) {
				// empty
			}
			
			@Override
			public void onJoyAxisEvent(JoyAxisEvent event) {
				// empty
			}
			
			@Override
			public void endInput() {
				// empty
			}
			
			@Override
			public void beginInput() {
				// empty
			}
		});
	}

	@Override
	public Vector2f getCursorPosition() {
		return jmeInputManager.getCursorPosition();
	}

	@Override
	public void setCursorVisible(boolean visible) {
		jmeInputManager.setCursorVisible(visible);
		
	}

	@Override
	public void setDefaultMouseCursor() {
		jmeInputManager.setMouseCursor(null);
	}
	
	@Override
	public void setMouseCursor(MouseCursor newMouseCursor) {
		jmeInputManager.setMouseCursor(((JMEMouseCursor)newMouseCursor).getNative());
	}
}
