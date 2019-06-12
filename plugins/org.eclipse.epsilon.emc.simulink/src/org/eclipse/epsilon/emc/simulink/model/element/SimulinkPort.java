/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.model.element;

import java.util.Collection;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.exception.MatlabRuntimeException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.util.collection.SimulinkLineCollection;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class SimulinkPort extends SimulinkElement {
	
	public SimulinkPort(SimulinkModel model, MatlabEngine engine, Double handle) throws MatlabRuntimeException {
		super(model, engine, handle);
	}

	public Collection<ISimulinkModelElement> getLines() throws EolRuntimeException {
		Object children = null;
		Object lines = null; 
		try {
			engine.eval("handle = ?;" + "lines = get_param(handle, 'Line');", this.handle);
			lines = engine.getVariable("lines");
		} catch (MatlabException e) {
			throw new EolRuntimeException(e.getMessage());
		}
		// sometimes it might return an empty cell array and sometimes a -1 we dont know why
		// in the -1 cases we found that the block had no connections and was masked, it might also be due to properties
		if (lines.equals(-1.0) || lines.equals(-1)) {
			return new SimulinkLineCollection(null, ((SimulinkModel)model));
		}
		try {
			engine.eval("children = get_param(lines, 'LineChildren');");
			children = engine.getVariable("children");
			if (children != null) {
				return new SimulinkLineCollection(children, ((SimulinkModel)model));
			} else {
				return new SimulinkLineCollection(lines, ((SimulinkModel)model));
			}
		} catch (Exception e) {
			throw new EolRuntimeException(e.getMessage());					
		}
	}
	
	@Override
	public boolean deleteElementInModel() throws EolRuntimeException {
		return false;
	}

}
