package org.eclipse.epsilon.emc.simulink.models;

import static org.eclipse.epsilon.emc.simulink.introspection.java.MatlabEngineCommands.GET_HANDLE_PROPERTY;
import static org.eclipse.epsilon.emc.simulink.introspection.java.MatlabEngineCommands.HANDLE;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.util.MatlabEngineUtil;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IModelElement;

public abstract class SimulinkModelElement implements IModelElement {

	protected SimulinkModel model = null;
	protected Double handle = null;
	protected MatlabEngine engine;
	
	@Override
	public IModel getOwningModel() {
		return model;
	}

	public Double getHandle() {
		return handle;
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof SimulinkModelElement && ((SimulinkModelElement) other).getHandle().equals(this.getHandle());
	}
	
	public Object getProperty(String property) {
		Object eval = engine.evalWithSetupAndResult(HANDLE, GET_HANDLE_PROPERTY, getHandle(), property);
		return MatlabEngineUtil.castMatlabArray(eval);
	}
	
	public Double getId() {
		return this.handle;
	}
	
	public MatlabEngine getEngine() {
		return engine;
	};
}
