package org.eclipse.epsilon.emc.simulink.models;

import static org.eclipse.epsilon.emc.simulink.introspection.java.MatlabEngineCommands.SET_PROPERTY_TO_HANDLE;

import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.util.MatlabEngineUtil;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationException;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;

public class SimulinkBlock extends SimulinkModelElement {

	/** CONSTANTS */
	
	private static final String HANDLE_DELETE_BLOCK_HANDLE = "handle = ?; delete_block(handle);";
	private static final String INSPECT_HANDLE = "handle = ?; inspect(handle);";
	private static final String ADD_BLOCK_MAKE_NAME_UNIQUE_ON = "add_block('?', '?', 'MakeNameUnique', 'on');";
	private static final String GET_PARAM_BLOCK_TYPE = "get_param(handle, 'BlockType');";
	private static final String GET_SIMULINK_BLOCK_HANDLE = "getSimulinkBlockHandle('?');";
	private static final String GET_FULL_NAME = "getfullname(?);";
	private static final String HANDLE = "handle = ?;";
	private static final String NAME_PROPERTY = "name";
	private static final String DELETE = "delete";
	private static final String CREATE = "add";

	/** FIELDS */
	
	protected String type;
	protected Boolean dualNature;

	/** CONSTRUCTORS */
	
	public SimulinkBlock(SimulinkModel model, MatlabEngine engine, String type, String path) {
		this.model = model;
		this.type = type;
		this.engine = engine;
		try {
			handle = (Double) engine.evalWithResult(ADD_BLOCK_MAKE_NAME_UNIQUE_ON, type, path);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public SimulinkBlock(SimulinkModel model, MatlabEngine engine, Double handle, String type) {
		this.model = model;
		this.handle = handle;
		this.type = type;
		this.engine = engine;
	}
	
	public SimulinkBlock(SimulinkModel model, MatlabEngine engine, Double handle) {
		this.model = model;
		this.handle = handle;
		this.engine = engine;
		this.type = getType();
	}

	protected SimulinkBlock(SimulinkModel model, MatlabEngine engine, String type) {
		this.model = model;
		this.engine = engine;
		this.type = type;
	}
	
	protected SimulinkBlock(SimulinkModel model, MatlabEngine engine) {
		this.model = model;
		this.engine = engine;
	}

	/** TYPE */
	
	public String getType() {
		if (type == null && handle != null) {
			try {
				type = (String) engine.evalWithSetupAndResult(HANDLE, GET_PARAM_BLOCK_TYPE, handle);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return type;
	}
	
	public String getSimpleType() {
		return SimulinkUtil.getSimpleTypeName(getType());
	}
	
	/** 
	 * @return Identifier (Path)
	 */
	public String getPath() {
		try {
			return (String) engine.evalWithResult(GET_FULL_NAME, handle);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/** TYPE-SPECIFIC METHODS */
	
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
		String command = "sourceHandle = ?;" +
				"targetHandle = ?;" +
				"OutPortHandles = get_param(sourceHandle,'PortHandles');" +
				"InPortHandles = get_param(targetHandle,'PortHandles');" + 
				"?_line('?',OutPortHandles.Outport(?),InPortHandles.Inport(?));";
		try {
			engine.eval(command, getHandle(), other.getHandle(), create ? CREATE : DELETE, getParentPath(), outPort, inPort);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public List<SimulinkPort> getOutports() {
		engine.eval("handle = ?;"
				+ "ph = get_param(handle, 'PortHandles');"
				+ "handles = ph.Outport;", this.handle);
		return model.getPorts(engine.getVariable("handles"));
	}

	public List<SimulinkPort> getInports() {
		engine.eval("handle = ? \n "
				+ "ph = get_param(handle, 'PortHandles');"
				+ "handles = ph.Inport;", this.handle);
		return model.getPorts(engine.getVariable("handles"));
	}

	/** PARENT / CHILDREN **/ 
	
	protected String getParentPath() {
		SimulinkBlock parent = getParent();
		return parent == null ? model.getSimulinkModelName() : parent.getPath();
	}

	public void setParent(SimulinkBlock parent) {
		try {
			String name = (String) getProperty(NAME_PROPERTY);
			String parentPath = parent == null ? model.getSimulinkModelName() : parent.getPath();
			Double newHandle = (Double) engine.evalWithResult(ADD_BLOCK_MAKE_NAME_UNIQUE_ON, getPath(), parentPath + "/" + name);
			engine.eval(HANDLE_DELETE_BLOCK_HANDLE, handle);
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
	    String name = ((String) getProperty("name")).replace("/", "//"); 
	    if (!path.equalsIgnoreCase(name)) { 
	    	  String parentPath = path.substring(0, path.length() - name.length() - 1); 
	          
	          if (parentPath.replace("//","").indexOf("/") < 0) return null; 
	          try {
					Double parentHandle = (Double) engine.evalWithResult("getSimulinkBlockHandle('?')", parentPath);
					return new SimulinkBlock(model, engine, parentHandle);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
	    }
	    return null;
	}
	
	public Collection<SimulinkBlock> getChildren() {
		// TODO unimplemented
		return null;
	}

	@Override
	public String toString() {
		return getPath();
	}
	
	public Double getId() {
		return this.getHandle();
	}

	public void setProperty(String property, Object value) throws EolIllegalPropertyException {
		try {
			engine.eval(SET_PROPERTY_TO_HANDLE, this.getHandle(), property, value);
		} catch (Exception ex) {
			throw new EolIllegalPropertyException(value, property, null, null);
		}
	}
	
	public void setScript(String script) {
		engine.eval("sf = sfroot();" +
				"block = sf.find('Path','?','-isa','Stateflow.EMChart');" +
				"block.Script = sprintf('?');", getPath(), script);
	}

	public String getScript() {
		engine.eval("sf = sfroot();" +
				"block = sf.find('Path','?','-isa','Stateflow.EMChart');" +
				"script = string(block.Script);", getPath());
		return engine.getVariable("script") + "";
	}

	public SimulinkModelElement inspect() {
		engine.eval(INSPECT_HANDLE, handle);
		return this;
	}
	
	/** */
	
	public StateflowBlock asStateflow() throws EolIllegalOperationException {
		if (isDualNature()) {
			Object eval = engine.evalWithSetupAndResult("sf = sfroot();" +
					"block = sf.find('Path','?');",
					"block.id;",
					this.getPath());
			Integer sfid = (Integer) MatlabEngineUtil.castMatlabArray(eval);
			return new StateflowBlock(model, engine, sfid.doubleValue());
		} else {
			throw new EolIllegalOperationException(this, "cannot cast to stateflow block", null, null);
		}
	}
	
	public Boolean isDualNature() {
		if (dualNature == null) 
			this.dualNature = getType().startsWith(StateflowBlock.STATEFLOW_LIB) ? true : false;
		return dualNature;
	}
	
	/*************************/
	/** METHODS BELOW ARE OK */
	/*************************/
	
	

}
