package org.eclipse.epsilon.emc.simulink;

import java.util.List;

public class SimulinkBlock extends SimulinkElement {
	
	protected String type;
	
	public SimulinkBlock(SimulinkModel model, String path, String type, MatlabEngine engine) {
		this.model = model;
		try {
			handle = (Double) engine.evalWithResult("add_block('?', '?', 'MakeNameUnique', 'on')", type, path);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		this.type = type;
		this.engine = engine;
	}
	
	public SimulinkBlock(SimulinkModel model, Double handle, String type, MatlabEngine engine) {
		this.model = model;
		this.handle = handle;
		this.type = type;
		this.engine = engine;
	}
	
	public String getType() {
		if (type == null) {
			try {
				type = (String) engine.evalWithSetupAndResult("handle = ?", "get_param (handle, 'BlockType')", getHandle());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return type;
	}
	
	public void link(SimulinkBlock other) {
		link(other, 1, 1);
	}
	
	public void linkTo(SimulinkBlock other, int inPort) {
		link(other, 1, inPort);
	}
	
	public void linkFrom(SimulinkBlock other, int outPort) {
		link(other, outPort, 1);
	}
	
	public void link(SimulinkBlock other, int outPort, int inPort) {
		manageLink(other, outPort, inPort, true);
	}
	
	public void unlink(SimulinkBlock other) {
		unlink(other, 1, 1);
	}
	
	public void unlinkTo(SimulinkBlock other, int inPort) {
		unlink(other, 1, inPort);
	}
	
	public void unlinkFrom(SimulinkBlock other, int outPort) {
		unlink(other, outPort, 1);
	}
	
	public void unlink(SimulinkBlock other, int outPort, int inPort) {
		manageLink(other, outPort, inPort, false);
	}
	
	public void manageLink(SimulinkBlock other, int outPort, int inPort, boolean create) {
		String command = "sourceHandle = ?\n" +
						 "targetHandle = ?\n" +
						 "OutPortHandles = get_param(sourceHandle,'PortHandles')\n" +
						 "InPortHandles = get_param(targetHandle,'PortHandles')\n" + 
						 "?_line('?',OutPortHandles.Outport(?),InPortHandles.Inport(?))";
		try {
			engine.eval(command, getHandle(), other.getHandle(), create ? "add" : "delete", getParentPath(), outPort, inPort);
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	protected String getParentPath() {
		SimulinkBlock parent = getParent();
		return parent == null ? model.getSimulinkModelName() : parent.getPath();
	}
	
	public void setParent(SimulinkBlock parent) {
		try {
			String name = (String) getProperty("name");
			String parentPath = parent == null ? model.getSimulinkModelName() : parent.getPath();
			Double newHandle = (Double) engine.evalWithResult("add_block('?', '?', 'MakeNameUnique', 'on')", getPath(), parentPath + "/" + name);
			engine.eval("handle = ? \n delete_block(handle)", handle);
			handle = newHandle;
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	/**
	 * Returns null for top-level elements and a 
	 * SimulinkElement for nested elements
	 */
	public SimulinkBlock getParent() {
		
		String path = getPath();
		int lastPathSeparator = path.lastIndexOf("/");
		
		if (lastPathSeparator > -1) {
			String parentPath = path.substring(0, lastPathSeparator);
			
			if (parentPath.indexOf("/") < 0) return null;
			
			try {
				Double parentHandle = (Double) engine.evalWithResult("getSimulinkBlockHandle('?')", parentPath);
				return new SimulinkBlock(model, parentHandle, null, engine);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		
		return null;
	}
	
	public String getPath() {
		try {
			return (String) engine.evalWithResult("getfullname(" + handle + ")");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String toString() {
		return getPath();
	}
	
	public List<SimulinkPort> getOutports() {
		engine.eval("handle = ? \n ph = get_param(handle, 'PortHandles') \n "
				+ "handles = ph.Outport;", this.handle);
		return model.getPorts(engine.getVariable("handles"));
	}

	public List<SimulinkPort> getInports() {
		engine.eval("handle = ? \n ph = get_param(handle, 'PortHandles') \n "
				+ "handles = ph.Inport;", this.handle);
		return model.getPorts(engine.getVariable("handles"));
	}
	
	public void setScript(String script) {
		engine.eval("sf = sfroot();\n" +
				"block = sf.find('Path','?','-isa','Stateflow.EMChart');\n" +
				"block.Script = sprintf('?');", getPath(), script);
	}
	
	public String getScript() {
		engine.eval("sf = sfroot();\n" +
				"block = sf.find('Path','?','-isa','Stateflow.EMChart');\n" +
				"script = string(block.Script)", getPath());
		return engine.getVariable("script") + "";
	}
	
}
