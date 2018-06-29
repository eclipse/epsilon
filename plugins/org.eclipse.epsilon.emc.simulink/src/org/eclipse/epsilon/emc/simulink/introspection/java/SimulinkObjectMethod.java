package org.eclipse.epsilon.emc.simulink.introspection.java;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkElement;
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
		String cmd = "";
		try {
			if (object instanceof ISimulinkElement) 		
				cmd = SimulinkUtil.handleMethodWithResult((ISimulinkElement) object, name, parameters);
			if (object instanceof SimulinkModel) 
				cmd = SimulinkUtil.handleMethodWithResult((SimulinkModel) object, name, parameters);
			
			engine.eval(cmd);
			return engine.getVariable("result");
		} catch (MatlabException e) {
			if (e.isTooManyOutput()) {
				try {
					if (object instanceof ISimulinkElement) 		
						cmd = SimulinkUtil.handleMethod((ISimulinkElement) object, name, parameters);
					if (object instanceof SimulinkModel) {
						cmd = SimulinkUtil.handleMethod((SimulinkModel) object, name, parameters);
					}
					engine.eval(cmd);
					return null;
				} catch (MatlabException ex) {
					return new EolRuntimeException(e.getMessage());
				}
			} else {
				return new EolRuntimeException(e.getMessage());
			}
		}
	}

}
