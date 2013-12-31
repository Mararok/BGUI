/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.script;

import java.io.Reader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class GUIScriptEngine {
	private ScriptEngineManager scriptEngineManager;
	private ScriptEngine scriptEngine;
	
	public GUIScriptEngine() {
		System.setProperty("rhino.opt.level","9");
		scriptEngineManager = new ScriptEngineManager();
		scriptEngine = scriptEngineManager.getEngineByExtension("js");
	}
	
	Object eval(String script, ScriptEngineContext context) {
		Object ret = null;
		try {
			ret = scriptEngine.eval(script,context.getRealContext());
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	Object eval(Reader reader, ScriptEngineContext context) {
		Object ret = null;
		try {
			ret = scriptEngine.eval(reader,context.getRealContext());
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
