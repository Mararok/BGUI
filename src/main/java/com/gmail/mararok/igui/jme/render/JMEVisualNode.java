/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.jme.render;

import javax.vecmath.AxisAngle4f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

import com.gmail.mararok.igui.spi.render.ParentVisualNode;
import com.gmail.mararok.igui.spi.render.RenderDevice;
import com.gmail.mararok.igui.spi.render.VisualNode;
import com.jme3.math.Quaternion;
import com.jme3.scene.Spatial;

class JMEVisualNode implements VisualNode {
	protected Spatial spatial;
	private RenderDevice renderDevice;
	private ParentVisualNode parent;
	
	public JMEVisualNode(RenderDevice renderDevice) {
		this.renderDevice = renderDevice;
	}
	
	@Override
	public Vector3f getTranslation() {
		com.jme3.math.Vector3f v = spatial.getLocalTranslation();
		return new Vector3f(v.x,v.y,v.z);
	}

	@Override
	public void setTranslation(float x, float y, float z) {
		spatial.setLocalTranslation(x,y,z);
	}

	@Override
	public Quat4f getRotation() {
		Quaternion rot = spatial.getLocalRotation();
		return new Quat4f(rot.getX(),rot.getY(),rot.getZ(),rot.getW());
	}

	@Override
	public void setRotation(Quat4f newRotation) {
		spatial.setLocalRotation(new Quaternion(newRotation.x,newRotation.y,newRotation.z,newRotation.w));
	}

	@Override
	public void setRotation(float xaxis, float yaxis, float zaxis,
			float angle) {
		Quat4f rot = new Quat4f();
		rot.set(new AxisAngle4f(xaxis,yaxis,zaxis,angle));
		setRotation(rot);
	}

	@Override
	public Vector3f getScale() {
		com.jme3.math.Vector3f scale = spatial.getLocalScale();
		return new Vector3f(scale.x,scale.y,scale.z);
	}

	@Override
	public void setScale(float newScale) {
		setScale(newScale,newScale,newScale);
	}

	@Override
	public void setScale(float xScale, float yScale, float zScale) {
		spatial.setLocalScale(xScale,yScale,zScale);
	}

	@Override
	public ParentVisualNode getParent() {
		return parent;
	}

	@Override
	public void setParent(ParentVisualNode newParent) {
		parent = newParent;
	}

	@Override
	public RenderDevice getRenderDevice() {
		return renderDevice;
	}
}
