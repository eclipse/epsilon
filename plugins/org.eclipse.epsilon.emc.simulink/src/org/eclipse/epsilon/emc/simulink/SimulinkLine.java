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
	
	public SimulinkPort getDestinationPort() {
		engine.eval("handle = ? \n "
				+ "handles = get_param(handle, 'DstPortHandle');", this.handle);
		return model.getPorts(engine.getVariable("handles")).get(0);
	}
	
	public SimulinkPort getSourcePort() {
		engine.eval("handle = ? \n "
				+ "handles = get_param(handle, 'SrcPortHandle');", this.handle);
		return model.getPorts(engine.getVariable("handles")).get(0);
	}
}
