package org.eclipse.epsilon.emc.simulink;

public class SimulinkLine extends SimulinkElement {
	
	public SimulinkLine(SimulinkModel model, double handle, MatlabEngine engine) {
		this.model = model;
		this.handle = handle;
		this.engine = engine;
	}
	
	public SimulinkBlock getDestination() {
		engine.eval("handle = ? \n "
				+ "handles = get_param(handle, 'DstBlockHandle');", this.handle);
		return model.getBlocks(engine.getVariable("handles"), null).get(0);
	}
	
	public SimulinkBlock getSource() {
		engine.eval("handle = ? \n "
				+ "handles = get_param(handle, 'SrcBlockHandle');", this.handle);
		return model.getBlocks(engine.getVariable("handles"), null).get(0);
	}
}
