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


public class SimulinkRequirement extends SimulinkModelElement implements ISimulinkRequirementModelElement{

	protected MatlabHandleElement requirementHandle;
	
	public SimulinkRequirement(SimulinkRequirementModel model, MatlabEngine engine, SimulinkRequirement requirement) {
		super(model, engine);
		try {
			requirementHandle = new MatlabHandleElement(model, engine, (HandleObject) engine.feval("add", requirement.getHandle().getHandle()));
		} catch (MatlabException e) {
			e.printStackTrace();
		}
	}
	
	public SimulinkRequirement(SimulinkRequirementModel model, MatlabEngine engine, SimulinkJustification justification) {
		super(model, engine);
		try {
			requirementHandle = new MatlabHandleElement(model, engine, (HandleObject) engine.feval("add", justification.getHandle().getHandle()));
		} catch (MatlabException e) {
			e.printStackTrace();
		}
	}

	// Model Handle is a ReqSet
	public SimulinkRequirement(SimulinkRequirementModel model, MatlabEngine engine) {
		super(model, engine);
		try {
			requirementHandle = new MatlabHandleElement(model, engine, (HandleObject) engine.feval("add", model.getHandle().getHandle()));
		} catch (MatlabException e) {
			e.printStackTrace();
		}
	}
	
	public SimulinkRequirement(SimulinkRequirementModel model, MatlabEngine engine, HandleObject id) {
		super(model, engine);
		requirementHandle = new MatlabHandleElement(model, engine, id);
	}
	
	@Override
	public Object getProperty(String property) throws EolRuntimeException {
		return requirementHandle.getProperty(property);
	}

	@Override
	public void setProperty(String property, Object value) throws EolRuntimeException {
		requirementHandle.setProperty(property, value);
	}

	@Override
	public Collection<String> getAllTypeNamesOf() {
		return Arrays.asList(getType());
	}

	@Override
	public boolean deleteElementInModel() throws EolRuntimeException {
		throw new EolRuntimeException("Can't remove requirements");
	}

	@Override
	public String getPath() {
		throw new IllegalAccessError("No path");
	}

	@Override
	public MatlabHandleElement getHandle() {
		return requirementHandle;
	}
	
	@Override
	public String getType() {
		return "Requirement";
	}

	/**
	add Add requirement to requirements set
	children Find child requirements of a requirement
	demote Demote requirements
	promote Promote requirements
	find Find requirements that have matching attribute values
	getAttribute Get requirement custom attributes
	parent Find parent item of requirement
	reqSet Return parent requirements set
	setAttribute Set requirement custom attributes
	getImplementationStatus Query requirement implementation status summary
	getVerificationStatus Query requirement verification status summary
	isJustifiedFor Check if requirement is justified
	justifyImplementation Justify requirements for implementation
	justifyVerification Justify requirements for verification
	*/
	
}
