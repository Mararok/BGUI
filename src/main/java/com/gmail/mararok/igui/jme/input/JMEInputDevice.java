/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.jme.input;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.event.mouse.MouseButton;
import com.gmail.mararok.igui.event.mouse.MouseClickEvent;
import com.gmail.mararok.igui.event.mouse.MouseDownEvent;
import com.gmail.mararok.igui.event.mouse.MouseMotionEvent;
import com.gmail.mararok.igui.event.mouse.MouseUpEvent;
import com.gmail.mararok.igui.jme.render.JMEMouseCursor;
import com.gmail.mararok.igui.scene.impl.SceneManagerImpl;
import com.gmail.mararok.igui.spi.input.InputDevice;
import com.gmail.mararok.igui.spi.render.MouseCursor;
import com.jme3.input.InputManager;
import com.jme3.input.RawInputListener;
import com.jme3.input.event.JoyAxisEvent;
import com.jme3.input.event.JoyButtonEvent;
import com.jme3.input.event.KeyInputEvent;
import com.jme3.input.event.MouseButtonEvent;
import com.jme3.input.event.TouchEvent;
import com.jme3.math.Vector2f;

public class JMEInputDevice implements InputDevice {
	private InputManager jmeInputManager;
	private ImpactGUI gui;
	
	public JMEInputDevice(InputManager inputManager) {
		
		jmeInputManager = inputManager;
	}

	@Override
	public void setGUI(ImpactGUI gui) {
		this.gui = gui;
		jmeInputManager.addRawInputListener(new JMECustomRawListener());
	}
	
	private class JMECustomRawListener implements RawInputListener {

		@Override
		public void beginInput() {
			
		}

		@Override
		public void endInput() {
			
		}

		@Override
		public void onJoyAxisEvent(JoyAxisEvent evt) {
			
		}

		@Override
		public void onJoyButtonEvent(JoyButtonEvent evt) {
			
		}

		@Override
		public void onKeyEvent(KeyInputEvent evt) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onMouseButtonEvent(MouseButtonEvent event) {
			
			if (event.isPressed()) {
				ImpactEvent newEvent = new MouseDownEvent(gui.getTimeProvider().getMiliTime(),
						event.getX(),event.getY(),MouseButton.fromIndex(event.getButtonIndex())
				);
				((SceneManagerImpl)gui.getSceneManager()).onEvent(newEvent);
			} else if (event.isReleased()) {
				ImpactEvent newEvent = new MouseUpEvent(gui.getTimeProvider().getMiliTime(),
						event.getX(),event.getY(),MouseButton.fromIndex(event.getButtonIndex())
				);
				((SceneManagerImpl)gui.getSceneManager()).onEvent(newEvent);
				
				newEvent = new MouseClickEvent(gui.getTimeProvider().getMiliTime(),
						event.getX(),event.getY(),MouseButton.fromIndex(event.getButtonIndex())
				);
				((SceneManagerImpl)gui.getSceneManager()).onEvent(newEvent);
			}
		}

		@Override
		public void onMouseMotionEvent(com.jme3.input.event.MouseMotionEvent event) {
			MouseMotionEvent newEvent = new MouseMotionEvent(gui.getTimeProvider().getMiliTime(),
					event.getX(),event.getX(),event.getDX(),event.getDX()
			);
			((SceneManagerImpl)gui.getSceneManager()).onEvent(newEvent);
		}

		@Override
		public void onTouchEvent(TouchEvent evt) {
		}
		
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
