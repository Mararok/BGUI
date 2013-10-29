/**
 * BGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.bgui.jme.render;

import javax.vecmath.AxisAngle4f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;

import com.gmail.mararok.bgui.spi.render.ParentVisualNode;
import com.gmail.mararok.bgui.spi.render.VisualNode;
import com.jme3.math.Quaternion;
import com.jme3.scene.Spatial;

public class JMEVisualNode implements VisualNode {
	protected Spatial spatial;
	
	private ParentVisualNode parent;
	
	@Override
	public Vector3f getLocalTranslation() {
		com.jme3.math.Vector3f v = spatial.getLocalTranslation();
		return new Vector3f(v.x,v.y,v.z);
	}

	@Override
	public void setLocalTranslation(Vector3f newTranslation) {
		setLocalTranslation(newTranslation.x,newTranslation.y,newTranslation.z);
	}

	@Override
	public void setLocalTranslation(float x, float y, float z) {
		spatial.setLocalTranslation(x,y,z);
	}

	@Override
	public Quat4f getLocalRotation() {
		Quaternion rot = spatial.getLocalRotation();
		return new Quat4f(rot.getX(),rot.getY(),rot.getZ(),rot.getW());
	}

	@Override
	public void setLocalRotation(Quat4f newRotation) {
		spatial.setLocalRotation(new Quaternion(newRotation.x,newRotation.y,newRotation.z,newRotation.w));
	}

	@Override
	public void setLocalRotation(float xaxis, float yaxis, float zaxis,
			float angle) {
		Quat4f rot = new Quat4f();
		rot.set(new AxisAngle4f(xaxis,yaxis,zaxis,angle));
		setLocalRotation(rot);
	}

	@Override
	public Vector3f getLocalScale() {
		com.jme3.math.Vector3f scale = spatial.getLocalScale();
		return new Vector3f(scale.x,scale.y,scale.z);
	}

	@Override
	public void setLocalScale(Vector3f newScale) {
		setLocalScale(newScale.x,newScale.y,newScale.z);
	}

	@Override
	public void setLocalScale(float xscale, float yscale, float zscale) {
		spatial.setLocalScale(xscale,yscale,zscale);
	}

	@Override
	public ParentVisualNode getParent() {
		return parent;
	}

	@Override
	public void setParent(ParentVisualNode newParent) {
		parent = newParent;
	}
}
