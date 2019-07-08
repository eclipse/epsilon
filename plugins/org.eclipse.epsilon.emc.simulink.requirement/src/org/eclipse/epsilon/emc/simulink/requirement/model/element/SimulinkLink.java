package org.eclipse.epsilon.emc.simulink.requirement.model.element;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.element.MatlabHandleElement;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.requirement.model.SimulinkRequirementModel;
import org.eclipse.epsilon.emc.simulink.types.HandleObject;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class SimulinkLink extends SimulinkModelElement implements ISimulinkRequirementModelElement {

	protected MatlabHandleElement linkHandle;
	

	public SimulinkLink(SimulinkRequirementModel model, MatlabEngine engine) {
		super(model, engine);
		// TODO Create
	}
	
	public SimulinkLink(SimulinkRequirementModel model, MatlabEngine engine, HandleObject id) {
		super(model, engine);
		linkHandle = new MatlabHandleElement(model, engine, id);
	}

	@Override
	public Object getProperty(String property) throws EolRuntimeException {
		return linkHandle.getProperty(property);
	}

	@Override
	public void setProperty(String property, Object value) throws EolRuntimeException {
		linkHandle.setProperty(property, value);
	}

	@Override
	public Collection<String> getAllTypeNamesOf() {
		return Arrays.asList(getType());
	}

	@Override
	public boolean deleteElementInModel() throws EolRuntimeException {
		try {
			engine.feval("remove", linkHandle.getHandle());
			return true;
		} catch (MatlabException e) {
			return false;
		}
	}

	@Override
	public String getPath() {
		return null; // FIXME
	}

	@Override
	public MatlabHandleElement getHandle() {
		return linkHandle;
	}
	
	@Override
	public String getType() {
		return "Link";
	}

	/**
	destination Get link destination artifact
	isResolved Check if the link is resolved
	isResolvedDestination Check if the link destination is resolved
	isResolvedSource Check if the link source is resolved
	linkSet Return parent link set
	remove Delete links
	source Get link source artifact
	 */
	
}
