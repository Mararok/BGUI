/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.jme.input;

import java.util.BitSet;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.event.keyboard.KeyDownEvent;
import com.gmail.mararok.igui.event.keyboard.KeyModifierType;
import com.gmail.mararok.igui.event.keyboard.KeyPressedEvent;
import com.gmail.mararok.igui.event.keyboard.KeyUpEvent;
import com.gmail.mararok.igui.event.mouse.MouseButton;
import com.gmail.mararok.igui.event.mouse.MouseClickedEvent;
import com.gmail.mararok.igui.event.mouse.MouseDownEvent;
import com.gmail.mararok.igui.event.mouse.MouseMovedEvent;
import com.gmail.mararok.igui.event.mouse.MouseUpEvent;
import com.gmail.mararok.igui.jme.render.JMEMouseCursor;
import com.gmail.mararok.igui.scene.SceneManager;
import com.gmail.mararok.igui.spi.input.InputDevice;
import com.gmail.mararok.igui.spi.render.MouseCursor;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
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
	
	private BitSet keyModifiers;
	
	public JMEInputDevice(InputManager inputManager) {
		jmeInputManager = inputManager;
		keyModifiers = new BitSet(KeyModifierType.values().length);
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
		public void onKeyEvent(KeyInputEvent event) {
			ImpactEvent newEvent = null;
			if (event.isPressed()) {
				newEvent = new KeyDownEvent(gui.getTimeProvider().getMiliTime(),event.getKeyCode(),keyModifiers);
				
				if (event.getKeyCode() == KeyInput.KEY_LMENU || event.getKeyCode() == KeyInput.KEY_RMENU) {
					keyModifiers.set(KeyModifierType.ALT.ordinal());
				} else if (event.getKeyCode() == KeyInput.KEY_LCONTROL || event.getKeyCode() == KeyInput.KEY_RCONTROL) {
					keyModifiers.set(KeyModifierType.CONTROL.ordinal());
				} else if (event.getKeyCode() == KeyInput.KEY_LSHIFT || event.getKeyCode() == KeyInput.KEY_RSHIFT) {
					keyModifiers.set(KeyModifierType.SHIFT.ordinal());
				}
				
				((SceneManager)gui.getSceneManager()).onEvent(newEvent);
				
			} else if (event.isReleased()) {
				newEvent = new KeyUpEvent(gui.getTimeProvider().getMiliTime(),event.getKeyCode(),keyModifiers);
				
				if (event.getKeyCode() == KeyInput.KEY_LMENU || event.getKeyCode() == KeyInput.KEY_RMENU) {
					keyModifiers.clear(KeyModifierType.ALT.ordinal());
				} else if (event.getKeyCode() == KeyInput.KEY_LCONTROL || event.getKeyCode() == KeyInput.KEY_RCONTROL) {
					keyModifiers.clear(KeyModifierType.CONTROL.ordinal());
				} else if (event.getKeyCode() == KeyInput.KEY_LSHIFT || event.getKeyCode() == KeyInput.KEY_RSHIFT) {
					keyModifiers.clear(KeyModifierType.SHIFT.ordinal());
				}
				
				((SceneManager)gui.getSceneManager()).onEvent(newEvent);
				
				newEvent = new KeyPressedEvent(gui.getTimeProvider().getMiliTime(),event.getKeyCode(),keyModifiers);
				((SceneManager)gui.getSceneManager()).onEvent(newEvent);
				
			}
			
		}

		@Override
		public void onMouseButtonEvent(MouseButtonEvent event) {
			ImpactEvent newEvent = null;
			if (event.isPressed()) {
				newEvent = new MouseDownEvent(gui.getTimeProvider().getMiliTime(),
						event.getX(),event.getY(),MouseButton.fromIndex(event.getButtonIndex())
				);
				((SceneManager)gui.getSceneManager()).onEvent(newEvent);
			} else if (event.isReleased()) {
				
				newEvent = new MouseUpEvent(gui.getTimeProvider().getMiliTime(),
						event.getX(),event.getY(),MouseButton.fromIndex(event.getButtonIndex())
				);
				((SceneManager)gui.getSceneManager()).onEvent(newEvent);
				
				newEvent = new MouseClickedEvent(gui.getTimeProvider().getMiliTime(),
						event.getX(),event.getY(),MouseButton.fromIndex(event.getButtonIndex())
				);
				((SceneManager)gui.getSceneManager()).onEvent(newEvent);
			}
			
		}

		@Override
		public void onMouseMotionEvent(com.jme3.input.event.MouseMotionEvent event) {
			MouseMovedEvent newEvent = new MouseMovedEvent(gui.getTimeProvider().getMiliTime(),
					event.getX(),event.getX(),event.getDX(),event.getDX()
			);
			((SceneManager)gui.getSceneManager()).onEvent(newEvent);
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
