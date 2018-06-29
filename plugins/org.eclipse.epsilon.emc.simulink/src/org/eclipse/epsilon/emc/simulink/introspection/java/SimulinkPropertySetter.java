package org.eclipse.epsilon.emc.simulink.introspection.java;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.model.element.StateflowBlock;
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
		try {
			if (object instanceof StateflowBlock) {
				StateflowBlock sfElement = (StateflowBlock) object;
				sfElement.setProperty(property, value);

			} else if (object instanceof SimulinkModelElement) {
				SimulinkModelElement element = (SimulinkModelElement) object;
				element.setProperty(property, value);
			}
		} catch (EolIllegalPropertyException e) {
			// FIXME In which case can a Simulink object not have a simulink property but a Java one?
			// IF this is the case, then <element>.setProperty needs to throw a different type of exception when there was an actual Simulink exception,
			// and this one when it wants to delegate to the Java getter. 
			super.invoke(value);
		}
	}

}
