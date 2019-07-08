/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.requirement.introspection.java;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.element.MatlabHandleElement;
import org.eclipse.epsilon.emc.simulink.requirement.model.element.ISimulinkRequirementModelElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;

public class SimulinkRequirementObjectMethod extends ObjectMethod {
	
	protected String name;
	protected MatlabEngine engine;
	
	public SimulinkRequirementObjectMethod(MatlabEngine engine, Object object, String name) {
		this.engine = engine;
		this.name = name;
		this.object = (ISimulinkRequirementModelElement) object;
	}

	@Override
	public Object execute(Object[] parameters, ModuleElement ast) throws EolRuntimeException {
		try {
			if (parameters ==null || parameters.length==0) {
				return engine.feval(name, ((MatlabHandleElement)((ISimulinkRequirementModelElement) object).getHandle()).getHandle());
			} else {
				return engine.feval(name, ((MatlabHandleElement)((ISimulinkRequirementModelElement) object).getHandle()).getHandle(), parameters);
			}
			
		} catch (MatlabException e) {
			throw new EolRuntimeException(e);
		}
	}

}
