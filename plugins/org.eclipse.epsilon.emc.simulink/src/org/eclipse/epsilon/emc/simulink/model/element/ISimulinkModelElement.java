package org.eclipse.epsilon.emc.simulink.model.element;

import java.util.Collection;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModelElement;

public interface ISimulinkModelElement extends IModelElement {

	public Object getProperty(String property) throws EolIllegalPropertyException ;

	public void setProperty(String property, Object value) throws EolIllegalPropertyException;

	public MatlabEngine getEngine();

	public boolean equals(Object other);
	
	public Collection<String> getAllTypeNamesOf();
	
	public boolean deleteElementInModel() throws EolRuntimeException;

	public String getType(); 
	
	public String getPath();

}
