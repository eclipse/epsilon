/*********************************************************************
 * Copyright (c) 2008 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simuink.requirement.dt;

import org.eclipse.epsilon.common.dt.locators.IModelElementLocator;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.emc.simulink.introspection.java.SimulinkPropertySetter;
import org.eclipse.epsilon.emc.simulink.requirement.model.SimulinkRequirementModel;
import org.eclipse.epsilon.emc.simulink.requirement.model.element.ISimulinkRequirementModelElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class SimulinkRequirementModelElementLocator implements IModelElementLocator {

	public SimulinkRequirementModelElementLocator() {}

	@Override
	public boolean canLocate(Object o) {
		return o instanceof ISimulinkRequirementModelElement;
	}

	@Override
	public void locate(Object o) {
		ISimulinkRequirementModelElement element = (ISimulinkRequirementModelElement) o;
		SimulinkPropertySetter setter = new SimulinkPropertySetter(((SimulinkRequirementModel)element.getOwningModel()).getEngine());
		setter.setProperty("selected");
		setter.setObject(element);
		try {
			setter.invoke("on");
		} catch (EolRuntimeException e) {
			LogUtil.log(e);
		}
	}

}
