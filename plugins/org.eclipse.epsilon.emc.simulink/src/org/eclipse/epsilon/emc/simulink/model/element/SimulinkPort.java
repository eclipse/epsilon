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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.exception.MatlabRuntimeException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.TypeHelper.Kind;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class SimulinkPort extends SimulinkElement {

	private static final Kind kind = Kind.PORT;
	
	public SimulinkPort(SimulinkModel model, MatlabEngine engine, Double handle) throws MatlabRuntimeException {
		super(model, engine, handle);
	}

	public List<SimulinkLine> getLines() throws EolRuntimeException {
		Object children = null;
		Object lines = null; 
		try {
			engine.eval("handle = ?;" + "lines = get_param(handle, 'Line');", this.handle);
			lines = engine.getVariable("lines");
		} catch (MatlabException e) {
			throw new EolRuntimeException(e.getMessage());
		}
		try {
			engine.eval("children = get_param(lines, 'LineChildren');", this.handle);
			children = engine.getVariable("children");
			if (children != null) {
				return SimulinkUtil.getSimulinkLines(model, engine, children);
			}
		} catch (Exception e) {
			return SimulinkUtil.getSimulinkLines(model, engine, lines);
		}
		return Collections.emptyList();
	}
	
	@Override
	public Collection<String> getAllTypeNamesOf() {
		ArrayList<String> types = new ArrayList<String>();
		super.getAllTypeNamesOf().forEach(e -> types.add(e));
		types.add(kind.getKind());
		return types;
	}
	
	@Override
	public boolean deleteElementInModel() throws EolRuntimeException {
		return false;
	}

	@Override
	protected String getSimulinkType() {
		return String.format(GET_SIMULINK_TYPE, kind.getKind());
	}

}
