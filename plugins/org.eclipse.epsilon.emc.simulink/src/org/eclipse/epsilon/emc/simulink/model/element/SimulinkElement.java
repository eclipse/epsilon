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

import static org.eclipse.epsilon.emc.simulink.engine.MatlabEngineCommands.GET_HANDLE_PROPERTY;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.exception.MatlabRuntimeException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.TypeHelper;
import org.eclipse.epsilon.emc.simulink.model.TypeHelper.Kind;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;

public abstract class SimulinkElement extends SimulinkModelElement implements ISimulinkElement {

	protected static final String ADD_BLOCK_MAKE_NAME_UNIQUE_ON = "add_block('?', '?', 'MakeNameUnique', 'on');";
	protected static final String HANDLE = "handle = ?;";
	protected static final String GET_SIMULINK_KIND = "get_param(handle, 'Type');";
	protected static final String GET_SIMULINK_TYPE = "get_param(handle, '%sType');";
	protected static final String GET_FULL_NAME = "getfullname(?);";

	protected Double handle = null;

	// Used when creating blocks
	public SimulinkElement(SimulinkModel model, MatlabEngine engine, String type) throws MatlabRuntimeException {
		super(model, engine);
		try {
			String path = SimulinkUtil.getTypePathInModel(model, type);
			this.handle = (Double) engine.evalWithResult(ADD_BLOCK_MAKE_NAME_UNIQUE_ON, type, path);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MatlabRuntimeException("Unable to create block element");
		}
		try {
			setType();
		} catch (MatlabException e) {
			throw new MatlabRuntimeException("Unable to set up the type");
		}
	}
	
	// Used when retrieving blocks with find_system
	public SimulinkElement(SimulinkModel model, MatlabEngine engine, Double handle) throws MatlabRuntimeException{
		super(model, engine);
		if (handle == -1 ) {
			throw new MatlabRuntimeException("Bad handle -1");
		} else {			
			this.handle = handle;
		}
		try {
			setType();
		} catch (MatlabException e) {
			throw new MatlabRuntimeException("Unable to set up the type");
		}
	}

	// Used when retrieving blocks with find_system
	public SimulinkElement(String path, SimulinkModel model, MatlabEngine engine) throws MatlabRuntimeException {
		super(model, engine);
		setHandle(path);
		try {
			setType();
		} catch (MatlabException e) {
			throw new MatlabRuntimeException("Unable to set up the type");
		}
	}

	// FIXME is this being called?
	public SimulinkElement(SimulinkModel model, MatlabEngine engine) {
		super(model, engine);
	}

	public Object getProperty(String property) throws EolIllegalPropertyException {
		try {
			return engine.evalWithSetupAndResult(HANDLE, GET_HANDLE_PROPERTY, getHandle(), property);
		} catch (MatlabException e) {
			e.printStackTrace();
			throw new EolIllegalPropertyException(this, property, null, null);
		}
	}

	public void setProperty(String property, Object value) throws EolIllegalPropertyException {
		try {
			String escaped = "?";
			if (value instanceof ISimulinkElement) {
				ISimulinkElement element = (ISimulinkElement) value;
				value = element.getHandle();
			} else {
				escaped = "'" + escaped + "'";
			}
			String cmd = "handle = ?; set_param(handle, '?', " + escaped + ");";
			engine.eval(cmd, this.getHandle(), property, value);
		} catch (MatlabException ex) {
			throw new EolIllegalPropertyException(value, property, null, null);
		}
	}

	@Override
	public Double getHandle() {
		return this.handle;
	}
	
	private void setHandle(String path) {
		this.handle = SimulinkUtil.getHandle(path, engine);
	}
	
	private void setType() throws MatlabException {
		if (handle != null) {
			this.superType = (String) engine.evalWithSetupAndResult(HANDLE, GET_SIMULINK_KIND, handle);
			String typeCmd = String.format(GET_SIMULINK_TYPE, this.superType);
			this.type = (String) engine.evalWithSetupAndResult(HANDLE, typeCmd, handle);
			try {
				TypeHelper.put(type, superType);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return Identifier (Path)
	 */
	public String getPath() {
		try {
			String path = (String) engine.evalWithResult(GET_FULL_NAME, handle);
			return path.replace("\n", " ");
		} catch (MatlabException e) {
			return null;
		}
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof SimulinkElement
				&& ((SimulinkElement) other).getHandle().equals(this.getHandle());
	}

	@Override
	public Collection<String> getAllTypeNamesOf() {
		return Arrays.asList(Kind.SIMULINK.getKind(), getType(), getSuperType());
	}

	@Override
	public String toString() {
		return getType() + "[ Path=" + getPath() + ", handle=" + getHandle() + "]";
	}

}
