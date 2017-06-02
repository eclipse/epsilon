package org.eclipse.epsilon.emc.simulink;

import java.util.List;

public class SimulinkPort extends SimulinkElement {

	public SimulinkPort(SimulinkModel model, double handle, MatlabEngine engine) {
		this.model = model;
		this.handle = handle;
		this.engine = engine;
	}
	
	public List<SimulinkLine> getLines() {
		engine.eval("handle = ? \n lines = get_param(handle, 'Line') \n "
				+ "children = get_param(lines, 'LineChildren');", this.handle);
		
		Object children = engine.getVariable("children");
		Object lines = engine.getVariable("lines");
		
		if (children != null) {
			return model.getLines(children);
		}
		else {
			return model.getLines(lines);
		}
	}
	
}
