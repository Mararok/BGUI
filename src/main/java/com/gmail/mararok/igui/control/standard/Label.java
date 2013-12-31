/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control.standard;

import com.gmail.mararok.igui.render.Gradient;
import com.gmail.mararok.igui.render.QuadMemoryMesh;
import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.render.SolidGradient;
import com.gmail.mararok.igui.scene.Scene;
import com.gmail.mararok.igui.scene.SceneNode;
import com.gmail.mararok.igui.spi.render.GeometryVisualNode;
import com.gmail.mararok.igui.spi.render.TextVisualNode;
import com.gmail.mararok.igui.style.attributes.Attribute;
import com.gmail.mararok.igui.style.attributes.AttributeType;
import com.gmail.mararok.igui.style.attributes.BackgroundAttribute;
import com.gmail.mararok.igui.style.attributes.ColorAttribute;
import com.gmail.mararok.igui.style.attributes.FontAttribute;

public class Label extends SceneNode {
	private GeometryVisualNode panelGeometry;
	private TextVisualNode labelTextNode;
	
	private String text = "";
	private String fontName;
	
	private Gradient color = new SolidGradient(RGBAColor.WHITE);
	private Gradient backgroundColor;
	
	public String getText() {
		return text;
	}
	
	public void setText(String newText) {
		text = (newText == null)?"":newText;
		if (hasScene()) {
		
			if (newText == "") {
				destroyLabelText();
				destroyPanelGeometry();
				return;
			}
		
			if (labelTextNode == null) {
				createLabelText();
				createPanelGeometry();
			} else {
				labelTextNode.setText(text);
			}
			
			setSize((int)labelTextNode.getFont().getLineWidth(text),(int)labelTextNode.getFont().getLineHeight(text));
		}
	}
	
	@Override
	public void updateAttribute(AttributeType type, Attribute value) {
		switch (type) {
		case color: 
			setColor(((ColorAttribute)value));
			break;
			
		case background: 
			setBackgroundColor(((BackgroundAttribute)value));
			break;
		
		case font:
			setFont((FontAttribute)value);
			break;
		default:
			break;
		}
	}

	private void setColor(ColorAttribute newColor) {
		color = newColor.getColor();
		if (hasScene()) {
			
			if (color == null) {
				destroyLabelText();
				return;
			}
			
			if (labelTextNode == null) {
				createLabelText();
			} else {
				labelTextNode.setColor(((SolidGradient)color).getColor());
			}
		}
	}
	
	private void setBackgroundColor(BackgroundAttribute newBackground) {
		backgroundColor = newBackground.getColor();
		if (hasScene()) {
			
			if (backgroundColor == null) {
				destroyPanelGeometry();
				return;
			}
			
			if (panelGeometry == null) {
				createPanelGeometry();
			} else {
				backgroundColor.setMeshColors(panelGeometry.getMesh());
				panelGeometry.updateGeometry();
			}
		}
	}
	
	private void setFont(FontAttribute newFont) {
		fontName = newFont.getFont();
		if (hasScene()) {
			if (fontName == null) {
				destroyLabelText();
				return;
			}
			if(labelTextNode == null) {
				createLabelText();
			} else {
				labelTextNode.setFont(getScene().getSceneManager().getGUI().getFontManager().getFontByName(fontName));
			}
			setSize((int)labelTextNode.getFont().getLineWidth(text),(int)labelTextNode.getFont().getLineHeight(text));
		}
	}

	@Override
	protected void onAttachToScene(Scene newScene) {
		super.onAttachToScene(newScene);
		createLabelText();
	}
	
	@Override
	protected void onDetachFromScene() {
		super.onDetachFromScene();
		destroyLabelText();
	}
	
	@Override
	protected void updateBounds() {
		if (labelTextNode != null) {
			labelTextNode.setTranslation(getCenterX()-getWidth()/2,getScene().getRenderDevice().getHeight()-getCenterY()+getHeight()/2,getZ()+2);
		}
		
		if (panelGeometry != null) {
			panelGeometry.setTranslation(getCenterX(),getScene().getRenderDevice().getHeight()-getCenterY(),getZ()+1);
			panelGeometry.setScale(getWidth()/2,getHeight()/2,1);
		}
	}
	
	private void createLabelText() {
		labelTextNode = getScene().getRenderDevice().createTextNode();
		
		if (color == null || text == "") {
			return;
		}
		
		labelTextNode.setColor(((SolidGradient)color).getColor());
		labelTextNode.setFont(getScene().getSceneManager().getGUI().getFontManager().getFontByName(fontName));
		labelTextNode.setText(text);
		
		setSize((int)labelTextNode.getFont().getLineWidth(text),(int)labelTextNode.getFont().getLineHeight(text));
		
		getScene().getVisualRoot().attachChild(labelTextNode);
		
		createPanelGeometry();
	}
	
	private void destroyLabelText() {
		if (labelTextNode != null) {
			getScene().getVisualRoot().detachChild(labelTextNode);
			labelTextNode = null;
			destroyPanelGeometry();
		}
	}
	
	private void createPanelGeometry() {
		if (backgroundColor == null || labelTextNode == null) {
			return;
		}

		panelGeometry = getScene().getRenderDevice().createGeometryNode();
		panelGeometry.setMesh(new QuadMemoryMesh());
		
		updateBounds();
			
		backgroundColor.setMeshColors(panelGeometry.getMesh());
		panelGeometry.updateGeometry();
		getScene().getVisualRoot().attachChild(panelGeometry);
	}

	private void destroyPanelGeometry() {
		if (panelGeometry != null) {
			getScene().getVisualRoot().detachChild(panelGeometry);
			panelGeometry = null;
		}
	}
}
