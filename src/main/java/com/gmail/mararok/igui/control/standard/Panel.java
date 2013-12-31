/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control.standard;

import com.gmail.mararok.igui.render.Gradient;
import com.gmail.mararok.igui.render.QuadMemoryMesh;
import com.gmail.mararok.igui.scene.ParentSceneNode;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.scene.SceneNode;
import com.gmail.mararok.igui.spi.render.GeometryVisualNode;
import com.gmail.mararok.igui.style.attributes.Attribute;
import com.gmail.mararok.igui.style.attributes.AttributeType;
import com.gmail.mararok.igui.style.attributes.BackgroundAttribute;
import com.gmail.mararok.igui.style.attributes.MarginAttribute;
import com.gmail.mararok.igui.style.attributes.PaddingAttribute;

public class Panel extends ParentSceneNode {
	private GeometryVisualNode panelGeometry;
	private Gradient backgroundColor;
	
	@Override
	public void attachChild(SceneNode child) {
		super.attachChild(child);
		child.setPosition(getCenterX()-child.getWidth()/2,getCenterY()-child.getHeight()/2);
	}

	@Override
	public void detachChild(SceneNode child) {
		super.detachChild(child);
		child.setPosition(0,0);
	}
	
	@Override
	public void updateAttribute(AttributeType type, Attribute value) {
		switch (type) {
		case background: 
			setBackgroundColor((BackgroundAttribute)value);
			break;
			
		default:
			break;
		}
	}
	
	private void setBackgroundColor(BackgroundAttribute attribute) {
		backgroundColor = attribute.getColor();
		if (hasScene()) {
			
			if (backgroundColor == null) {
				destroyPanelGeometry();
			} else {
				if (panelGeometry == null) {
					createPanelGeometry();
				} else {
					backgroundColor.setMeshColors(panelGeometry.getMesh());
					panelGeometry.updateGeometry();
				}
			}
		}
	}
	
	
	@Override
	protected void onAttachToScene(Scene newScene) {
		super.onAttachToScene(newScene);
		createPanelGeometry();
	}

	private void createPanelGeometry() {
		if (backgroundColor == null || panelGeometry != null) {
			return;
		}
		
		panelGeometry = getScene().getRenderDevice().createGeometryNode();
		panelGeometry.setMesh(new QuadMemoryMesh());
		
		updatePanelGeometryBounds();
		
		backgroundColor.setMeshColors(panelGeometry.getMesh());
		panelGeometry.updateGeometry();
		
		getScene().getVisualRoot().attachChild(panelGeometry);
	}
	
	private void updatePanelGeometryBounds() {
		panelGeometry.setTranslation(getCenterX(),getScene().getRenderDevice().getHeight()-getCenterY(),getZ());
		panelGeometry.setScale(getWidth()/2,getHeight()/2,1);
	}
	@Override
	protected void updateBounds() {
		super.updateBounds();
		if (panelGeometry != null) {
			updatePanelGeometryBounds();
		}
		
		if (hasChildren()) {
			for (SceneNode child : children) {
				child.setPosition(getCenterX()-child.getWidth()/2,getCenterY()-child.getHeight()/2);
			}
		}
	}
	
	@Override
	protected void onDetachFromScene() {
		super.onDetachFromScene();
		destroyPanelGeometry();
	}
	
	private void destroyPanelGeometry() {
		if (panelGeometry != null) {
			getScene().getVisualRoot().detachChild(panelGeometry);
			panelGeometry = null;
		}
	}

}
