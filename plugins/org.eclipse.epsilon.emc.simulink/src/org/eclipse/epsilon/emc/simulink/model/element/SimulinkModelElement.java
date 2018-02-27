package org.eclipse.epsilon.emc.simulink.model.element;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.eol.models.IModel;

public abstract class SimulinkModelElement implements ISimulinkModelElement {

	protected SimulinkModel model = null;
	protected MatlabEngine engine;
	protected String type;
	protected String path;
	
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
