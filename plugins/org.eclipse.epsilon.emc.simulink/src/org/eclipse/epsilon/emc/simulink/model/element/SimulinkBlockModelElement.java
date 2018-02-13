package org.eclipse.epsilon.emc.simulink.model.element;

import static org.eclipse.epsilon.emc.simulink.engine.MatlabEngineCommands.GET_HANDLE_PROPERTY;
import static org.eclipse.epsilon.emc.simulink.engine.MatlabEngineCommands.SET_PROPERTY_TO_HANDLE;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.engine.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.util.MatlabEngineUtil;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;

public abstract class SimulinkBlockModelElement extends SimulinkModelElement implements ISimulinkBlockModelElement{

	protected static final String ADD_BLOCK_MAKE_NAME_UNIQUE_ON = "add_block('?', '?', 'MakeNameUnique', 'on');";
	protected static final String HANDLE = "handle = ?;";

	protected Double handle = null;

	public SimulinkBlockModelElement(SimulinkModel model, MatlabEngine engine, Double handle, String type) {
		super(model, engine, type);
		this.handle = handle;
	}
		
	public SimulinkBlockModelElement(SimulinkModel model, MatlabEngine engine, Double handle) {
		super(model, engine);
		this.handle = handle;
	}
	
	public SimulinkBlockModelElement(SimulinkModel model, MatlabEngine engine, String type) {
		super(model, engine, type);
		try {
			String path = SimulinkUtil.getTypePathInModel(model, type);
			this.handle = (Double) engine.evalWithResult(ADD_BLOCK_MAKE_NAME_UNIQUE_ON, type, path);
		} catch (Exception e) {}
	}
	
	public SimulinkBlockModelElement(SimulinkModel model, MatlabEngine engine) {
		super(model, engine);
	}

	public Object getProperty(String property) throws MatlabException {
		Object eval = engine.evalWithSetupAndResult(HANDLE, GET_HANDLE_PROPERTY, getHandle(), property);
		return MatlabEngineUtil.parseMatlabEngineVariable(eval);
	}

	public void setProperty(String property, Object value) throws EolIllegalPropertyException {
		try {
			engine.eval(SET_PROPERTY_TO_HANDLE, this.getHandle(), property, value);
		} catch (MatlabException ex) {
			throw new EolIllegalPropertyException(value, property, null, null);
		}
	}
	
	@Override
	public Double getHandle() {
		return handle;
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof SimulinkBlockModelElement
				&& ((SimulinkBlockModelElement) other).getHandle().equals(this.getHandle());
	}

	
}
