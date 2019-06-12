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
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.types.HandleObject;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class SimulinkTestManager extends SimulinkElement{

	MatlabHandleElement handle;
	
	public SimulinkTestManager(SimulinkModel model, MatlabEngine engine) {
		super(model, engine);
		// TODO Auto-generated constructor stub
	}
	
	public void view() throws MatlabException {
		engine.eval("sltest.testmanager.view");
	}
	
	public Object TestFile(String path) throws MatlabException {
		return handle = new MatlabHandleElement(model, engine, (HandleObject) engine.feval("sltest.testmanager.TestFile", path));		
	}

	@Override
	public boolean deleteElementInModel() throws EolRuntimeException {
		// TODO Auto-generated method stub
		return false;
	}

}
