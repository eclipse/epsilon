package org.eclipse.epsilon.emc.simulink.models;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.introspection.java.MatlabEngineCommands;

public class SimulinkLine extends SimulinkModelElement {
	
	private static final String GET_PROPERTY_FROM_HANDLE_RETURN = "handle = ?; handles = get_param(handle, '%s');";
	private static final String HANDLES = "handles";
	private static final String DST_BLOCK_HANDLE = "DstBlockHandle";
	private static final String SRC_BLOCK_HANDLE = "SrcBlockHandle";
	private static final String DST_PORT_HANDLE = "DstPortHandle";
	private static final String SRC_PORT_HANDLE = "SrcPortHandle";

	public SimulinkLine(SimulinkModel model, MatlabEngine engine, Double handle) {
		this.model = model;
		this.handle = handle;
		this.engine = engine;
	}
	
	private static String cmd(String val) {
		return MatlabEngineCommands.cmd(GET_PROPERTY_FROM_HANDLE_RETURN, val);
	}
	
	public SimulinkBlock getDestination() {
		engine.eval(cmd(DST_BLOCK_HANDLE), this.handle);
		return model.getSimulinkBlocks(engine.getVariable(HANDLES), null).get(0);
	}
	
	public SimulinkBlock getSource() {
		engine.eval(cmd(SRC_BLOCK_HANDLE), this.handle);
		return model.getSimulinkBlocks(engine.getVariable(HANDLES), null).get(0);
	}
	
	public SimulinkPort getDestinationPort() {
		engine.eval(cmd(DST_PORT_HANDLE), this.handle);
		return model.getPorts(engine.getVariable(HANDLES)).get(0);
	}
	
	public SimulinkPort getSourcePort() {
		engine.eval(cmd(SRC_PORT_HANDLE), this.handle);
		return model.getPorts(engine.getVariable(HANDLES)).get(0);
	}
	
}
