package org.eclipse.epsilon.emc.simulink.model.element;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.eol.models.IModel;

public abstract class SimulinkModelElement implements ISimulinkModelElement {

	protected SimulinkModel model = null;
	protected MatlabEngine engine;
	public String type;
	
	public SimulinkModelElement(SimulinkModel model, MatlabEngine engine) {
		this.model = model;
		this.engine = engine;
	}
	
	public SimulinkModelElement(SimulinkModel model, MatlabEngine engine, String type) {
		this(model, engine);
		this.type = type;
	}
		
	@Override
	public IModel getOwningModel() {
		return model;
	}
	
	public MatlabEngine getEngine() {
		return engine;
	}
	
	public String getType() {
		return this.type;
	}
	
}
