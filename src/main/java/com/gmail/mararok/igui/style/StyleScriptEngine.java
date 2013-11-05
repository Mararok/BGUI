/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.style;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class StyleScriptEngine {
	private ScriptEngineManager scriptEngineManager;
	private ScriptEngine scriptEngine;
	
	public StyleScriptEngine() {
		System.setProperty("rhino.opt.level","9");
		scriptEngineManager = new ScriptEngineManager();
		scriptEngine = scriptEngineManager.getEngineByExtension("js");
	}
	
	public void parseStyle(String styleSource) {
		
	}
}
