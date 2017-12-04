package org.eclipse.epsilon.emc.simulink.models;

import java.util.List;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;

public class SimulinkPort extends SimulinkModelElement {

	public SimulinkPort(SimulinkModel model, MatlabEngine engine, Double handle) {
		this.model = model;
		this.handle = handle;
		this.engine = engine;
	}
	
	public List<SimulinkLine> getLines() {
		engine.eval("handle = ?;"
				+ "lines = get_param(handle, 'Line'); "
				+ "children = get_param(lines, 'LineChildren');", this.handle);
		Object children = engine.getVariable("children");
		Object lines = engine.getVariable("lines");
		
		if (children != null) {
			return model.getLines(children);
		} else {
			return model.getLines(lines);
		}
	}
	
}
