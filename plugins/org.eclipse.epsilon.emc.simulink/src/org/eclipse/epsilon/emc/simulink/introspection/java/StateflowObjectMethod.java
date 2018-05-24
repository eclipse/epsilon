package org.eclipse.epsilon.emc.simulink.introspection.java;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.model.element.StateflowBlock;
import org.eclipse.epsilon.emc.simulink.util.StateflowUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;

public class StateflowObjectMethod extends ObjectMethod {
	
	protected String name;
	protected MatlabEngine engine;
	
	public StateflowObjectMethod(MatlabEngine engine, Object object, String name) {
		this.engine = engine;
		this.name = name;
		this.object = object;
	}
	
	@Override
	public Object execute(Object[] parameters, ModuleElement ast) throws EolRuntimeException {
		try {
			String cmd = "";
			if (object instanceof StateflowBlock) {		
				cmd = StateflowUtil.handleMethod((StateflowBlock) object, name, parameters);
			}
			engine.eval(cmd);
			return engine.getVariable("result");
		} catch (Exception e) {
			e.printStackTrace();
			throw new EolRuntimeException(e.getMessage());
		}
		
	}	
		
}
