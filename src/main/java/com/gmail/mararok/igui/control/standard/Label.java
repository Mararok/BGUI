/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.control.standard;

import com.gmail.mararok.igui.event.ImpactEvent;
import com.gmail.mararok.igui.render.Gradient;
import com.gmail.mararok.igui.render.QuadMemoryMesh;
import com.gmail.mararok.igui.render.RGBAColor;
import com.gmail.mararok.igui.render.SolidGradient;
import com.gmail.mararok.igui.scene.SceneNode;
import com.gmail.mararok.igui.spi.render.Font;
import com.gmail.mararok.igui.spi.render.GeometryVisualNode;
import com.gmail.mararok.igui.spi.render.TextVisualNode;
import com.gmail.mararok.igui.style.attributes.Attribute;
import com.gmail.mararok.igui.style.attributes.AttributeType;
import com.gmail.mararok.igui.style.attributes.BackgroundAttribute;
import com.gmail.mararok.igui.style.attributes.ColorAttribute;

public class Label extends SceneNode {
	private GeometryVisualNode panelGeometry;
	private TextVisualNode labelTextNode;
	
	private String text;
	private Font font;
	
	private Gradient color = new SolidGradient(RGBAColor.WHITE);
	private Gradient backgroundColor = new SolidGradient(RGBAColor.GREEN);
	
	public String getText() {
		return text;
	}
	
	public void setText(String newText) {
		text = newText;
		if (getScene() == null) {
			return;
		}
		
		if (newText == "") {
			destroyLabelText();
			destroyPanelGeometry();
			return;
		}
		
		if (labelTextNode == null) {
			createLabelText();
		} else {
			labelTextNode.setText(text);
		}
		
		setSize((int)labelTextNode.getFont().getLineWidth(text),(int)labelTextNode.getFont().getLineHeight(text));
	}
	
	@Override
	public void updateAttribute(AttributeType type, Attribute value) {
		switch (type) {
		case color: 
			setColor(((ColorAttribute)value).getColor());
			break;
			
		case background: 
			setBackgroundColor(((BackgroundAttribute)value).getColor());
			break;
			
		default:
			break;
		}
	}

	private void setColor(Gradient newColor) {
		color = newColor;
		if (getScene() == null) {
			return;
		}
		
		if (color == null && labelTextNode != null) {
			destroyLabelText();
			destroyPanelGeometry();
		} else if (labelTextNode != null) {
			labelTextNode.setColor(((SolidGradient)color).getColor());
		}
	}
	
	private void setBackgroundColor(Gradient newColor) {
		backgroundColor = newColor;
		if (getScene() == null) {
			return;
		}
		
		if (newColor == null && panelGeometry != null) {
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
	
	private void setFont(Font newFont) {
		font = newFont;
		if (getScene() == null) {
			return;
		}
		
		if (labelTextNode != null) {
			labelTextNode.setFont(font);
		}
	}

	@Override
	protected void onAttachToScene() {
		createLabelText();
		createPanelGeometry();
	}
	
	@Override
	protected void onDetachFromScene() {
		destroyLabelText();
		destroyPanelGeometry();
	}
	
	@Override
	protected void updateBounds() {
		System.out.println(getCenterX()+" "+getCenterY());
		if (labelTextNode != null) {
			labelTextNode.setTranslation(getCenterX()-getWidth()/2,getScene().getRenderDevice().getHeight()-getCenterY()+getHeight()/2,getZ()+2);
		}
		
		if (panelGeometry != null) {
			panelGeometry.setTranslation(getCenterX(),getScene().getRenderDevice().getHeight()-getCenterY(),getZ()+1);
			panelGeometry.setScale(getWidth()/2,getHeight()/2,1);
		}
	}
	
	@Override
	public void onEvent(ImpactEvent event) {
		
	}
	
	private void createLabelText() {
		labelTextNode = getScene().getRenderDevice().createTextNode();
		boolean canShow = false;
		
		if (color != null) {
			setColor(color);
			canShow = true;
		} else {
			canShow = true;
		}
		
		if (font != null) {
			setFont(font);
			canShow = true;
		} else {
			canShow = true;
		}
		
		if (text != "") {
			setText(getText());	
			canShow = true;
		} else {
			canShow = false;
		}
		
		if (canShow)
			getScene().getVisualRoot().attachChild(labelTextNode);
	}
	
	private void destroyLabelText() {
		if (labelTextNode != null) {
			getScene().getVisualRoot().detachChild(labelTextNode);
			labelTextNode = null;
		}
	}
	
	private void createPanelGeometry() {
		if (backgroundColor == null) {
			return;
		}
		
		panelGeometry = getScene().getRenderDevice().createGeometryNode();
		panelGeometry.setMesh(new QuadMemoryMesh());
		
		updateBounds();
			
		if (backgroundColor instanceof SolidGradient) {
			panelGeometry.getMesh().setColors(((SolidGradient) backgroundColor).getColor());
		}
		
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
