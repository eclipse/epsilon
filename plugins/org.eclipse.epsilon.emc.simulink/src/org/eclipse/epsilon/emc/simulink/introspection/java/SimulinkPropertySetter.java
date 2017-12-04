package org.eclipse.epsilon.emc.simulink.introspection.java;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.models.SimulinkBlock;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;

public class SimulinkPropertySetter extends JavaPropertySetter {
	
	protected MatlabEngine engine;
	
	public SimulinkPropertySetter(MatlabEngine engine) {
		this.engine = engine;
	}
	
	@Override
	public void invoke(Object value) throws EolRuntimeException {
		
		SimulinkBlock element = (SimulinkBlock) object;
		
		try {
			element.setProperty(property, value);
		} catch (EolIllegalPropertyException e) {
			super.invoke(value);
		}
		
	}
	
}
