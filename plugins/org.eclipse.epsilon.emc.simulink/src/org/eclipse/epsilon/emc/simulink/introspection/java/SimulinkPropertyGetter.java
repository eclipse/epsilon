package org.eclipse.epsilon.emc.simulink.introspection.java;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.engine.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.model.element.StateflowBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;

public class SimulinkPropertyGetter extends JavaPropertyGetter {

	private static final String TYPE = "type";

	protected MatlabEngine engine;

	public SimulinkPropertyGetter() {}

	@Override
	public Object invoke(Object object, String property) throws EolRuntimeException {

		try {
			return super.invoke(object, property);
		} catch (Exception e) {

			SimulinkModelElement element = (SimulinkModelElement) object;
			
			if (element instanceof SimulinkModelElement) {
				if (property.equalsIgnoreCase(TYPE)) {
					return ((SimulinkModelElement) element).getType();
				}
				try {
					if (element instanceof StateflowBlock)
						return ((StateflowBlock) element).getProperty(property);

					if (element instanceof SimulinkBlock)
						return ((SimulinkBlock) element).getProperty(property);

				} catch (MatlabException me) {
					throw new EolRuntimeException(me.getMessage());
				}
			}
			
			throw new EolRuntimeException(e.getMessage());
		}
		
		
	}

}
