/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control.standard;

import com.gmail.mararok.igui.render.Gradient;
import com.gmail.mararok.igui.render.QuadMemoryMesh;
import com.gmail.mararok.igui.render.SolidGradient;
import com.gmail.mararok.igui.scene.ParentSceneNode;
import com.gmail.mararok.igui.spi.render.GeometryVisualNode;
import com.gmail.mararok.igui.style.attributes.Attribute;
import com.gmail.mararok.igui.style.attributes.AttributeType;
import com.gmail.mararok.igui.style.attributes.BackgroundAttribute;

public class Panel extends ParentSceneNode {
	private GeometryVisualNode panelGeometry;
	private Gradient backgroundColor;
	
	@Override
	public void updateAttribute(AttributeType type, Attribute value) {
		switch (type) {
		case background: {
			setBackgroundColor((BackgroundAttribute)value);
		}
		default:
			break;
		}
	}
	
	private void setBackgroundColor(BackgroundAttribute attribute) {
		backgroundColor = attribute.getColor();
		if (getScene() == null) {
			return;
		}
		
		if (backgroundColor == null && panelGeometry != null) {
			getScene().getVisualRoot().detachChild(panelGeometry);
			panelGeometry = null;
		} else {
			if (panelGeometry != null) {
				if (backgroundColor != null) {
					if (backgroundColor instanceof SolidGradient) {
						panelGeometry.getMesh().setColors(((SolidGradient) backgroundColor).getColor());
					}
					panelGeometry.updateGeometry();
				}
			} else {
				createPanelGeometry();
			}
		}
	}
	
	
	@Override
	protected void onAttachToScene() {
		super.onAttachToScene();
		createPanelGeometry();
	}

	private void createPanelGeometry() {
		if (backgroundColor == null) {
			return;
		}
		
		panelGeometry = getScene().getRenderDevice().createGeometryNode();
		panelGeometry.setMesh(new QuadMemoryMesh());
		
		panelGeometry.setTranslation(getCenterX(),getScene().getRenderDevice().getHeight()-getCenterY(),getZ());
		panelGeometry.setScale(getWidth()/2,getHeight()/2,1);
			
		if (backgroundColor instanceof SolidGradient) {
			panelGeometry.getMesh().setColors(((SolidGradient) backgroundColor).getColor());
		}
		panelGeometry.updateGeometry();
		
		getScene().getVisualRoot().attachChild(panelGeometry);
	}
	
	@Override
	protected void updateBounds() {
		super.updateBounds();
		if (panelGeometry != null) {
			panelGeometry.setTranslation(getCenterX(),getScene().getRenderDevice().getHeight()-getCenterY(),getZ());
			panelGeometry.setScale(getWidth()/2,getHeight()/2,1);
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
