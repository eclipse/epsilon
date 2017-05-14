package org.eclipse.epsilon.emc.simulink;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;

public class SimulinkPropertyGetter extends JavaPropertyGetter {
	
	protected MatlabEngine engine;
	
	public SimulinkPropertyGetter() {}
	
	@Override
	public Object invoke(Object object, String property) throws EolRuntimeException {
		
		SimulinkElement element = (SimulinkElement) object;
		
		if (element instanceof SimulinkBlock && "parent".equalsIgnoreCase(property)) {
			return ((SimulinkBlock) element).getParent();
		}
		
		try {
			return element.getProperty(property);
		}
		catch (Exception ex) {
			return super.invoke(object, property);
		}
	}

}
