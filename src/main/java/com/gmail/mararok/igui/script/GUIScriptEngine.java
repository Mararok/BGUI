/**
 * ImpactGUI
 * all rights reserved
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
*/
package com.gmail.mararok.igui.script;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

public class GUIScriptEngine {
	private ScriptEngineManager scriptEngineManager;
	private ScriptEngine scriptEngine;
	
	public GUIScriptEngine() {
		System.setProperty("rhino.opt.level","9");
		scriptEngineManager = new ScriptEngineManager();
		scriptEngine = scriptEngineManager.getEngineByExtension("js");
	}

	public ScriptContext newScriptContext() {
		return new SimpleScriptContext();
	}
	
	public Object eval(String script) {
		try {
			return scriptEngine.eval(script);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Object eval(String script, ScriptContext newContext) {
		try {
			return scriptEngine.eval(script);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return null;
	}
}
