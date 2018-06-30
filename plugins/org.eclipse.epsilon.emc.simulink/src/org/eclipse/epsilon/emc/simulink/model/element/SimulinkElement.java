package org.eclipse.epsilon.emc.simulink.model.element;

import static org.eclipse.epsilon.emc.simulink.engine.MatlabEngineCommands.GET_HANDLE_PROPERTY;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.TypeHelper.Kind;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;

public abstract class SimulinkElement extends SimulinkModelElement implements ISimulinkElement {

	protected static final String ADD_BLOCK_MAKE_NAME_UNIQUE_ON = "add_block('?', '?', 'MakeNameUnique', 'on');";
	protected static final String HANDLE = "handle = ?;";
	protected static final String GET_SIMULINK_TYPE = "get_param(handle, '%sType');";
	protected static final String GET_FULL_NAME = "getfullname(?);";

	protected Double handle = null;

	public SimulinkElement(SimulinkModel model, MatlabEngine engine, Double handle) {
		super(model, engine);
		this.handle = handle;
		setType();
	}

	public SimulinkElement(SimulinkModel model, MatlabEngine engine, String type) {
		super(model, engine);
		try {
			String path = SimulinkUtil.getTypePathInModel(model, type);
			this.handle = (Double) engine.evalWithResult(ADD_BLOCK_MAKE_NAME_UNIQUE_ON, type, path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setType();
	}

	public SimulinkElement(String path, SimulinkModel model, MatlabEngine engine) {
		super(model, engine);
		setHandle(path);
		setType();
	}

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

	abstract protected String getSimulinkType();
	
	private void setType(String type) {
		if (type != null) {
			this.type = new String(type);
		} else {
			if (handle != null) {
				try {
					this.type = (String) engine.evalWithSetupAndResult(HANDLE, getSimulinkType(), handle);
				} catch (Exception e) {
					// e.printStackTrace();
				}
			}
		}
	}

	private void setType() {
		setType(null);
	}

	/**
	 * @return Identifier (Path)
	 */
	public String getPath() {
		try {
			return (String) engine.evalWithResult(GET_FULL_NAME, handle);
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
		return Arrays.asList(Kind.SIMULINK.name(), getType());
	}

}
