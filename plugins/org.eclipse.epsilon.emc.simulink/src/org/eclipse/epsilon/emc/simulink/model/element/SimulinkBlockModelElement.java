package org.eclipse.epsilon.emc.simulink.model.element;

import static org.eclipse.epsilon.emc.simulink.engine.MatlabEngineCommands.GET_HANDLE_PROPERTY;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.engine.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;

public abstract class SimulinkBlockModelElement extends SimulinkModelElement implements ISimulinkBlockModelElement {

	protected static final String ADD_BLOCK_MAKE_NAME_UNIQUE_ON = "add_block('?', '?', 'MakeNameUnique', 'on');";
	protected static final String HANDLE = "handle = ?;";
	private static final String GET_PARAM_BLOCK_TYPE = "get_param(handle, 'BlockType')";
	private static final String GET_FULL_NAME = "getfullname(?);";

	protected Double handle = null;
	protected String blockType = null;

	public SimulinkBlockModelElement(SimulinkModel model, MatlabEngine engine, Double handle) {
		super(model, engine);
		this.handle = handle;
		setType();
	}

	public SimulinkBlockModelElement(SimulinkModel model, MatlabEngine engine, String type) {
		super(model, engine);
		try {
			String path = SimulinkUtil.getTypePathInModel(model, type);
			this.handle = (Double) engine.evalWithResult(ADD_BLOCK_MAKE_NAME_UNIQUE_ON, type, path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setType(type);
	}

	public SimulinkBlockModelElement(SimulinkModel model, MatlabEngine engine) {
		super(model, engine);
	}

	public Object getProperty(String property) throws MatlabException {
		return engine.evalWithSetupAndResult(HANDLE, GET_HANDLE_PROPERTY, getHandle(), property);
	}

	public void setProperty(String property, Object value) throws EolIllegalPropertyException {
		try {
			String escaped = "?";
			if (value instanceof ISimulinkBlockModelElement) {
				ISimulinkBlockModelElement element = (ISimulinkBlockModelElement) value;
				value = element.getHandle();
			}
			if (value instanceof String && (!((String) value).startsWith("[") && !((String) value).endsWith("]"))) {
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
		if (this.handle == null && this.path != null) {
			this.handle = SimulinkUtil.getHandle(this.path, engine);
		}
		return this.handle;
	}

	private void setType(String type) {
		if (type != null ) {
			this.type = SimulinkUtil.getSimpleTypeName(type);
		} else {
			if (getPath() != null) {
				this.type = SimulinkUtil.extractTypeFromPath(getPath());
			} 
		}
		setBlockType();
	}
	
	private void setType() {
		setType(null);
	}

	private void setBlockType() {
		if (handle != null) {
			try {
				this.blockType = (String) engine.evalWithSetupAndResult(HANDLE, GET_PARAM_BLOCK_TYPE, handle);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return Identifier (Path)
	 */
	public String getPath() {
		if (path == null) {
			try {
				this.path = (String) engine.evalWithResult(GET_FULL_NAME, handle);
			} catch (MatlabException e) {}
		} 
		return path;
	}
	
	public String getBlockType() { // FIXME set accessible via EOL. Problem because its declared in superclass
		return this.blockType;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof SimulinkBlockModelElement
				&& ((SimulinkBlockModelElement) other).getHandle().equals(this.getHandle());
	}
	
	@Override
	public Collection<String> getAllTypeNamesOf() {
		return Arrays.asList(SimulinkModel.BLOCK, SimulinkModel.SIMULINK, getType(), getBlockType());
	}

}
