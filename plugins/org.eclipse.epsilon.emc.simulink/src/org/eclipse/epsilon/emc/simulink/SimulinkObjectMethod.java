package org.eclipse.epsilon.emc.simulink;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;

public class SimulinkObjectMethod extends ObjectMethod {
	
	protected String name;
	protected MatlabEngine engine;
	
	public SimulinkObjectMethod(MatlabEngine engine, Object object, String name) {
		this.engine = engine;
		this.name = name;
		this.object = object;
	}
	
	@Override
	public Object execute(Object[] parameters, ModuleElement ast) throws EolRuntimeException {
		
		String cmd = "handle = " + ((SimulinkElement) object).getHandle() + "; result = " + name + "(handle";
		for (Object parameter : parameters) {
			cmd += ", '" + String.valueOf(parameter).replace("'", "''") + "'";
		}
		cmd += ")";
		engine.eval(cmd);
		return engine.getVariable("result");
	}
	
	
}
