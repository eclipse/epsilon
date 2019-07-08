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

/** 
save Save link set
sources Get link sources
 */
public class SimulinkLinkSet extends SimulinkModelElement implements ISimulinkRequirementModelElement {

	/*public SimulinkLinkSet(AbstractSimulinkModel model) {
		//myLinkset2 = slreq.load(model.getFile());
		//myLinkset2.Description = 'Link set for the fuel system'
		//myLinkset2.Description <- getter?
	}*/
	
	protected MatlabHandleElement linkSetHandle;
	
	public SimulinkLinkSet(SimulinkRequirementModel model, MatlabEngine engine) {
		super(model, engine);
		// TODO create
	}
	
	public SimulinkLinkSet(SimulinkRequirementModel model, MatlabEngine engine, String artifact) {
		super(model, engine);
		HandleObject id;
		try {
			id = (HandleObject) engine.feval("add", model.getHandle().getHandle(), "Artifact", artifact);
			linkSetHandle = new MatlabHandleElement(model, engine, id);
		} catch (MatlabException e) {
			e.printStackTrace(); //FIXME
		}
	}
	
	
	public SimulinkLinkSet(SimulinkRequirementModel model, MatlabEngine engine, HandleObject id) {
		super(model, engine);
		linkSetHandle = new MatlabHandleElement(model, engine, id);
	}

	@Override
	public Object getProperty(String property) throws EolRuntimeException {
		return linkSetHandle.getProperty(property);
	}

	@Override
	public void setProperty(String property, Object value) throws EolRuntimeException {
		linkSetHandle.setProperty(property, value);
	}

	@Override
	public Collection<String> getAllTypeNamesOf() {
		return Arrays.asList(getType());
	}

	@Override
	public boolean deleteElementInModel() throws EolRuntimeException {
		throw new IllegalAccessError("Cannot remove LinkSet");
	}

	@Override
	public String getPath() {
		return null; //FIXME
	}

	@Override
	public MatlabHandleElement getHandle() {
		return linkSetHandle;
	}
	
	@Override
	public String getType() {
		return "LinkSet";
	}
}
