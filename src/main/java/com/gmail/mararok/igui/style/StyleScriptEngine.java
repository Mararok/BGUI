/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import javax.script.ScriptContext;

import com.gmail.mararok.igui.script.GUIScriptEngine;

public class StyleScriptEngine {
	private GUIScriptEngine scriptEngine;
	private ScriptContext styleScriptContext;
	
	public StyleScriptEngine(GUIScriptEngine scriptEngine) {
		this.scriptEngine = scriptEngine;
		styleScriptContext = scriptEngine.newScriptContext();
	}
	
	public void parseStyle(String style) {
		scriptEngine.eval(style,styleScriptContext);
	}
}
