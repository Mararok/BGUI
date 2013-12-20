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

public class ImpactEvent {
	private EventsType type;
	private long time;
	private SceneNode target;
	
	public ImpactEvent(EventsType type, long time) {
		this(type,time,null);
	}
	
	public ImpactEvent(EventsType type, long time, SceneNode target) {
		this.type = type;
		this.time = time;
		this.target = target;
	}
	
	public EventsType getType() {
		return type;
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("EVENT[ ");
		sb.append(type.toString());
		sb.append(" at ");
		Date date = new Date(time);
	    Format format = new SimpleDateFormat("HH:mm:ss");
		sb.append(format.format(date).toString());
		sb.append(" for ");
		sb.append(target);
		sb.append(" ]");
		return sb.toString();
	}
}
