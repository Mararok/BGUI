/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.event;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.gmail.mararok.igui.scene.SceneNode;

abstract public class ImpactEvent {
	private long time;
	private SceneNode target;
	
	public ImpactEvent(long time) {
		this(time,null);
	}
	
	public ImpactEvent(long time, SceneNode target) {
		this.time = time;
		this.target = target;
	}
	
	public long getTime() {
		return time;
	}
	
	public void setTime(long newTime) {
		time = newTime;
	}
	
	public SceneNode getTarget() {
		return target;
	}
	
	public void setTarget(SceneNode newTarget) {
		target = newTarget;
	}
	
	public boolean hasTarget() {
		return (target != null);
	}
	
	abstract public String getName();
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("EVENT[ ");
		sb.append(getName()+" ]");
		sb.append(" at ");
		Date date = new Date(time);
	    Format format = new SimpleDateFormat("HH:mm:ss:ms");
		sb.append(format.format(date).toString());
		if (target != null) {
			sb.append(" for ");
			sb.append(target);
		}
		
		sb.append(" ]");
		return sb.toString();
	}
}
