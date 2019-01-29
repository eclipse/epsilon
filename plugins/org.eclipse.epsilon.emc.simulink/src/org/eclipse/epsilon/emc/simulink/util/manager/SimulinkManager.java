/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.util.manager;

import org.eclipse.epsilon.emc.simulink.exception.MatlabRuntimeException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkElement;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkLine;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkPort;
import org.eclipse.epsilon.emc.simulink.model.element.StateflowBlock;

public class SimulinkManager extends AbstractManager<ISimulinkElement, Double> {

	public SimulinkManager(SimulinkModel model){
		super(model);
	}
	
	public ISimulinkElement construct(Double id) {
		// FIXME
		try {
			return new SimulinkBlock(getModel(), getEngine(), id);
		} catch (MatlabRuntimeException e) {
			return null;
		}
	}
	
	public Double getId(ISimulinkElement from) {
		if (from instanceof StateflowBlock) {
			return new StateflowBlockManager(model).getId((StateflowBlock) from);
		} else if (from instanceof SimulinkLine) {
			return new SimulinkLineManager(model).getId((SimulinkLine) from);
		} else if (from instanceof SimulinkPort) {
			return new SimulinkPortManager(model).getId((SimulinkPort) from);
		} else if (from instanceof SimulinkBlock) {
			return new SimulinkBlockManager(model).getId((SimulinkBlock) from);
		} 
		return null;
	}	
	
}