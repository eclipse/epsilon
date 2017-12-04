package org.eclipse.epsilon.emc.simulink.introspection.java;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.models.SimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
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
		try {
			String cmd = "";
			if (object instanceof SimulinkModelElement) 		
				cmd = SimulinkUtil.handleMethod((SimulinkModelElement) object, name, parameters);
			engine.eval(cmd);
			return engine.getVariable("result");
		} catch (Exception e) {
			throw new EolRuntimeException(e.getMessage(), ast);
		}
	}
	
	
	
}
