package org.eclipse.epsilon.emc.simulink;

import java.lang.reflect.Method;

public class MatlabEngine {
	
	protected Object engine;
	protected Method evalMethod;
	protected Method getVariableMethod;
	
	public MatlabEngine(Class<?> matlabEngineClass) {
		try {
			engine = matlabEngineClass.getMethod("connectMatlab").invoke(null);
			evalMethod = engine.getClass().getMethod("eval", String.class);
			getVariableMethod = engine.getClass().getMethod("getVariable", String.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Object evalWithResult(String cmd) throws Exception {
		eval("result = " + cmd);
		return getVariable("result");
	}
	
	public Object evalWithSetupAndResult(String setup, String cmd, Object... parameters) {
		eval(setup + "\n" + "result = " + cmd, parameters);
		try {
			return getVariable("result");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Object evalWithResult(String cmd, Object... parameters) {
		eval("result = " + cmd, parameters);
		try {
			return getVariable("result");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void eval(String cmd, Object... parameters) {
		cmd = " " + cmd + " ";
		String[] parts = cmd.split("[?]");
		if (parts.length != parameters.length + 1) 
			throw new RuntimeException(parts.length - 1 + " parameters were expected but " + parameters.length + " were provided");
		
		cmd = parts[0];
		for (int i=0; i<parameters.length; i++) {
			cmd += String.valueOf(parameters[i]).replace("'", "''").replace("\n", "\\n") + parts[i+1];
		}
		cmd = cmd.substring(1, cmd.length()-1);
		try {
			eval(cmd);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void eval(String cmd) {
		try {
			evalMethod.invoke(engine, cmd);
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public Object getVariable(String variable) {
		try {
			return getVariableMethod.invoke(engine, variable);
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	
}
