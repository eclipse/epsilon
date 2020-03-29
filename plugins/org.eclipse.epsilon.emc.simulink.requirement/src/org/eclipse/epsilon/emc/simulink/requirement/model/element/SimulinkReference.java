/*********************************************************************
 * Copyright (c) 2008 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
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


public class SimulinkReference extends SimulinkModelElement implements ISimulinkRequirementModelElement{

	protected MatlabHandleElement referenceHandle;
	
	public SimulinkReference(SimulinkRequirementModel model, MatlabEngine engine) {
		super(model, engine);
		// TODO create
	}
	
	public SimulinkReference(SimulinkRequirementModel model, MatlabEngine engine, String artifact) {
		super(model, engine);
		HandleObject id;
		try {
			id = (HandleObject) engine.fevalWithResult("add", model.getHandle().getHandle(), "Artifact", artifact);
			referenceHandle = new MatlabHandleElement(model, engine, id);
		} catch (MatlabException e) {
			e.printStackTrace(); //FIXME
		}
	}
	
	public SimulinkReference(SimulinkRequirementModel model, MatlabEngine engine, HandleObject id) {
		super(model, engine);
		referenceHandle = new MatlabHandleElement(model, engine, id);
	}

	@Override
	public Object getProperty(String property) throws EolRuntimeException {
		return referenceHandle.getProperty(property);
	}

	@Override
	public void setProperty(String property, Object value) throws EolRuntimeException {
		referenceHandle.setProperty(property, value);
	}

	@Override
	public Collection<String> getAllTypeNamesOf() {
		return Arrays.asList(getType());
	}

	@Override
	public boolean deleteElementInModel() throws EolRuntimeException {
		try {
			engine.feval("remove", referenceHandle.getHandle());
			return true;
		} catch (MatlabException e) {
			return false;
		}
	}

	@Override
	public MatlabHandleElement getHandle() {
		return referenceHandle;
	}

	@Override
	public String getType() {
		return "Reference";
	}
	
	/** 
	Find children references
	find Find referenced requirements
	getAttribute Get referenced requirement custom attributes
	getImplementationStatus Query referenced requirement implementation status
	summary
	getVerificationStatus Query referenced requirement verification status summary
	isJustifiedFor Check if referenced requirement is justified
	justifyImplementation Justify referenced requirements for implementation
	justifyVerification Justify referenced requirements for verification
	parent Find parent item of referenced requirement
	remove Remove referenced requirements
	reqSet Return parent requirements set
	setAttribute Set referenced requirement custom attributes
	unlock Unlock referenced requirements
	unlockAll Unlock all child referenced requirements for editing
	updateFromDocument Update referenced requirements from external requirements
	document
	 */
}
