/**
 * ImpactGUI
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.igui;

import com.gmail.mararok.igui.render.FontManager;
import com.gmail.mararok.igui.scene.SceneManager;
import com.gmail.mararok.igui.script.GUIScriptEngine;
import com.gmail.mararok.igui.spi.input.InputDevice;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.gmail.mararok.igui.spi.sound.NullSoundDevice;
import com.gmail.mararok.igui.spi.sound.SoundDevice;
import com.gmail.mararok.igui.spi.time.StandardTimeProvider;
import com.gmail.mararok.igui.spi.time.TimeProvider;
import com.gmail.mararok.igui.style.StyleClassManager;

public class ImpactGUI {
	private RenderDevice renderDevice;
	private SoundDevice soundDevice;
	private InputDevice inputDevice;
	private TimeProvider timeProvider;
	
	private SceneManager sceneManager;
	
	private GUIScriptEngine scriptEngine;
	
	private FontManager fontManager;
	
	private StyleClassManager styleClassManager;
	
	public ImpactGUI(RenderDevice renderDevice,InputDevice inputDevice) {
		this(renderDevice,inputDevice,new NullSoundDevice(),new StandardTimeProvider());
	}
	
	public ImpactGUI(RenderDevice renderDevice, InputDevice inputDevice, SoundDevice soundDevice, TimeProvider timeProvider) {
		this.renderDevice = renderDevice;
		this.soundDevice = soundDevice;
		this.inputDevice = inputDevice;
		inputDevice.setGUI(this);
		this.timeProvider = timeProvider;
		sceneManager = new SceneManager(this);
		
		scriptEngine = new GUIScriptEngine();
		
		fontManager = new FontManager(renderDevice);
		styleClassManager = new StyleClassManager();
	}
	
	public RenderDevice getRenderDevice() {
		return renderDevice;
	}
	
	public InputDevice getInputDevice() {
		return inputDevice;
	}
	
	public SoundDevice getSoundDevice() {
		return soundDevice;
	}

	public TimeProvider getTimeProvider() {
		return timeProvider;
	}
	
	public SceneManager getSceneManager() {
		return sceneManager;
	}
	
	public GUIScriptEngine getScriptEngine() {
		return scriptEngine;
	}
	
	public FontManager getFontManager() {
		return fontManager;
	}
	
	public StyleClassManager getStyleClassManager() {
		return styleClassManager;
	}
}
