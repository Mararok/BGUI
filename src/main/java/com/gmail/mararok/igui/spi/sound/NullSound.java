/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.spi.sound;

public class NullSound implements Sound {
	private String name;
	private boolean playing;
	private float volume;
	
	public NullSound(String name) {
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void play() {
		playing = true;
	}

	@Override
	public void stop() {
		playing = false;
	}

	@Override
	public boolean isPlaying() {
		return playing;
	}

	@Override
	public void setVolume(float newVolume) {
		volume = newVolume;
	}

	@Override
	public float getVolume() {
		return volume;
	}

	@Override
	public void dispose() {
		
	}
}
