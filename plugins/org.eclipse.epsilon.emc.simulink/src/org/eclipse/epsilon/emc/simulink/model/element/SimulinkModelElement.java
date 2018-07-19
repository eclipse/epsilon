package org.eclipse.epsilon.emc.simulink.model.element;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.eol.models.IModel;

public abstract class SimulinkModelElement implements ISimulinkModelElement {

	protected SimulinkModel model = null;
	protected MatlabEngine engine = null;
	protected String type = null;
	protected String superType = null;


	public SimulinkModelElement(SimulinkModel model, MatlabEngine engine) {
		this.model = model;
		this.engine = engine;
	}
		
	@Override
	public IModel getOwningModel() {
		return this.model;
	}
	
	public MatlabEngine getEngine() {
		return this.engine;
	}
	
	@Override
	public String getType() {
		return this.type;
	}
	
	public String getSuperType() {
		return superType;
	}

}
