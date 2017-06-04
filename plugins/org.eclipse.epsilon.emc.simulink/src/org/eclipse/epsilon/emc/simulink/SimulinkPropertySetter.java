package org.eclipse.epsilon.emc.simulink;

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
		
		if ("parent".equalsIgnoreCase(property)) {
			element.setParent((SimulinkBlock) value); return;
		}
		
		try {
			engine.eval("handle = ? \n set_param (handle, '?', '?')", element.getHandle(), property, value);
		}
		catch (Exception ex) {
			super.invoke(value);
		}
	}
	
}
