/**
 * ImpactGUI
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.igui;

import com.gmail.mararok.igui.scene.SceneManager;
import com.gmail.mararok.igui.scene.impl.SceneManagerImpl;
import com.gmail.mararok.igui.spi.input.InputDevice;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.gmail.mararok.igui.spi.sound.NullSoundDevice;
import com.gmail.mararok.igui.spi.sound.SoundDevice;
import com.gmail.mararok.igui.spi.time.StandardTimeProvider;
import com.gmail.mararok.igui.spi.time.TimeProvider;

public class ImpactGUI {
	private RenderDevice renderDevice;
	private SoundDevice soundDevice;
	private InputDevice inputDevice;
	private TimeProvider timeProvider;
	
	private SceneManager sceneManager;
	
	public ImpactGUI(RenderDevice renderDevice,InputDevice inputDevice) {
		this(renderDevice,inputDevice,new NullSoundDevice(),new StandardTimeProvider());
	}
	
	public ImpactGUI(RenderDevice renderDevice, InputDevice inputDevice, SoundDevice soundDevice, TimeProvider timeProvider) {
		this.renderDevice = renderDevice;
		this.soundDevice = soundDevice;
		this.inputDevice = inputDevice;
		this.timeProvider = timeProvider;
		sceneManager = new SceneManagerImpl(this);
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
}
