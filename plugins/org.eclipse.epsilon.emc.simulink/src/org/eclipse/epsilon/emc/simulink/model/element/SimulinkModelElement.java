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

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.eol.models.IModel;

public abstract class SimulinkModelElement implements ISimulinkModelElement {

	protected SimulinkModel model = null;
	protected MatlabEngine engine;
	protected String type;
	
	public SimulinkModelElement(SimulinkModel model, MatlabEngine engine) {
		this.model = model;
		this.engine = engine;
	}
		
	@Override
	public IModel getOwningModel() {
		return model;
	}
	
	public MatlabEngine getEngine() {
		return engine;
	}
	
	@Override
	public String getType() {
		return this.type;
	}
	
}
