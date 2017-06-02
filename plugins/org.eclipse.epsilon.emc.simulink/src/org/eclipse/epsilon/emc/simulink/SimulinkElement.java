package org.eclipse.epsilon.emc.simulink;

import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IModelElement;

public abstract class SimulinkElement implements IModelElement {

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
		return other instanceof SimulinkElement && ((SimulinkElement) other).getHandle().equals(this.getHandle());
	}
	
	public Object getProperty(String property) {
		return engine.evalWithSetupAndResult("handle = ?", "get_param (handle, '?')", getHandle(), property);
	}
	
	public SimulinkElement inspect() {
		engine.eval("handle = ?; inspect(handle);", handle);
		return this;
	}
	
}
