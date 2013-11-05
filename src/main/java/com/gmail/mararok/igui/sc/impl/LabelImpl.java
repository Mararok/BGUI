/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.sc.impl;

import com.gmail.mararok.igui.ImpactGUI;
import com.gmail.mararok.igui.control.ControlBase;
import com.gmail.mararok.igui.sc.Label;
import com.gmail.mararok.igui.spi.render.TextVisualNode;

public class LabelImpl extends ControlBase implements Label {
	private TextVisualNode labelTextNode;
	private static int nextLabelID = 0;
	
	public LabelImpl(ImpactGUI gui) {
		super(gui);
		labelTextNode = gui.getRenderDevice().createTextNode("LABEL:"+(++nextLabelID));
		mainVisualNode.attachChild(labelTextNode);
	}

	@Override
	public void setText(String newText) {
		labelTextNode.setText(newText);
	}

	@Override
	public String getText() {
		return labelTextNode.getText();
	}
}
