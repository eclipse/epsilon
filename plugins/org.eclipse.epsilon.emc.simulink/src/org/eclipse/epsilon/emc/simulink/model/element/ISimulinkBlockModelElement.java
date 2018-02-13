package org.eclipse.epsilon.emc.simulink.model.element;

import org.eclipse.epsilon.emc.simulink.engine.MatlabException;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;

public interface ISimulinkBlockModelElement extends ISimulinkModelElement {

	public Object getProperty(String property) throws MatlabException ;

	public void setProperty(String property, Object value) throws EolIllegalPropertyException;
	
	public Double getHandle();

}
