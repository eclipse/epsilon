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
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkBlock;

public class SimulinkBlockManager extends AbstractManager<SimulinkBlock, Double> {
	
	public SimulinkBlockManager(SimulinkModel model){
 		super(model);
	}
	
	public SimulinkBlock construct(Double id) {
		try {
			return new SimulinkBlock(getModel(), getEngine(), id);
		} catch (MatlabRuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Double getId(SimulinkBlock from) {
		return from.getHandle();
	}	
	
}