package org.eclipse.epsilon.emc.simulink.introspection.java;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.models.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.models.SimulinkModelElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;

public class SimulinkPropertyGetter extends JavaPropertyGetter {
	
	private static final String TYPE = "type";
		
	protected MatlabEngine engine;
	
	public SimulinkPropertyGetter() {}
	
	@Override
	public Object invoke(Object object, String property) throws EolRuntimeException {
		
		SimulinkModelElement element = (SimulinkModelElement) object;
		
		if (element instanceof SimulinkBlock) {
			if (property.equalsIgnoreCase(TYPE)) {
				return ((SimulinkBlock) element).getSimpleType();
			}
		}
			
		try {
			return element.getProperty(property);
		} catch (Exception ex) {
			return super.invoke(object, property);
		}
	}

}
