package org.eclipse.epsilon.emc.simulink.models;

import static org.eclipse.epsilon.emc.simulink.util.MatlabEngineUtil.castMatlabArray;

import java.util.Collection;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.util.StateflowUtil;

public class StateflowBlock extends SimulinkBlock {
	
	/** CONSTANTS */
	
	public static final String STATEFLOW_LIB = "sflib/";
	private static final String FULLY_QUALIFIED_CLASS = ".class;";
	private static final String SIMPLE_TYPE = ".classhandle.Name;";
	
	/** FIELDS */
	
	private SimulinkBlock parent;
	private Double id;
	
	/** CONSTRUCTORS */
	
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, String type, SimulinkBlock parent) {
		super(model, engine, type);
		build(parent);
		// TODO get handle of parent and build
	}
	
	public StateflowBlock(SimulinkModel model, String type, MatlabEngine engine, StateflowBlock parent) {
		super(model, engine, type);
		build(parent); 
		// TODO get handle of parent and build 
	}
	
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, Double stateflowId) {
		super(model, engine);
		this.id = stateflowId;
		this.parent = getParent();
	}
	
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, Integer stateflowId) {
		this(model, engine, stateflowId.doubleValue());
	}
	
	public StateflowBlock(SimulinkModel model, String type, MatlabEngine engine, Double stateflowId) {
		super(model, engine, type);
		this.id = stateflowId;
		this.parent = getParent();
	}
	
	public StateflowBlock(SimulinkModel model, String type, MatlabEngine engine, Integer stateflowId) {
		this(model, type, engine, stateflowId.doubleValue());
	}
	
	public StateflowBlock(SimulinkModel model, String type, MatlabEngine engine) {
		super(model, engine, type);
		this.parent = getParent();
	}
	
	private void build(SimulinkBlock parent) {
		StateflowUtil.modelHandleAsM(this);
		this.parent = parent;
		this.id = ((Double) this.engine.evalWithSetupAndResult(
				"parent = m.find('Path','?', '-isa', '?');"
				+ "block = ?(parent);", 
				"block.id;", 
				this.parent.getPath(), getStateflowType(parent), type));
	}

	/** TYPE */
	
	/**
	 * Returns e.g. "Stateflow.State"
	 */
	@Override
	public String getType() {
		if (this.type == null) {
			String h = StateflowUtil.getBlockHandle(this);
			try {
				this.type = (String) engine.evalWithResult(h + FULLY_QUALIFIED_CLASS); 
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return this.type; 
	}
	
	/**
	 * returns e.g. "State"
	 */
	@Override
	public String getSimpleType() {
		String h = StateflowUtil.getBlockHandle(this);
		try {
			return (String) engine.evalWithResult(h + SIMPLE_TYPE); 
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}
	
	public String getStateflowType(SimulinkBlock block) {
		String t = block.getType();
		return t.startsWith(STATEFLOW_LIB) ? t.replace(STATEFLOW_LIB, "Stateflow.") : t;  
	}

	/** PROPERTIES **/
	
	@Override
	public Object getProperty(String property) {
		StateflowUtil.modelHandleAsM(this);
		Object result = engine.evalWithSetupAndResult(
				"block = m.find('-isa', '?', 'Id', ?);",
				"block.?;", getType(), getId().intValue() , property);
		return castMatlabArray(result);
	}

	@Override
	public void setProperty(String property, Object value) {
		String val = "?";
		String randomHandle = "";
		if (value instanceof StateflowBlock) {
			randomHandle = StateflowUtil.getBlockHandle(((StateflowBlock) value));
			value = randomHandle;
		}
		if (value instanceof String 
				&& (!((String)value).startsWith("[") && !((String)value).endsWith("]")) 
				&& !((String)value).equals(randomHandle)) 
		{
			val = "'" + val + "'";
		}
		String cmd = "block = m.find('-isa', '?', 'Id', ?);"
				+ "block.? = " + val + ";";
		engine.eval(cmd, getType(), getId().intValue(), property, value);
	}

	/** IDENTIFIER */
	
	@Override
	public Double getId() {
		return this.id;
	}

	@Override
	public Double getHandle() {
		return getId();
	}

	@Override
	public String getPath() {
		String h = StateflowUtil.getBlockHandle(this);
		return (String) engine.evalWithResult("?.Path;", h);
	}
	
	@Override
	public SimulinkBlock getParent() {
		if (this.parent == null) {
			String h = StateflowUtil.getBlockHandle(this); // Requires ID and Type
			// Object p = engine.evalWithSetupAndResult("p=?.up;","p.class;", h);
			// FIXME TODO this.parent = 	
		}
		return this.parent;		
	}

	@Override
	public void setParent(SimulinkBlock parent) {	
		throw new RuntimeException("Not yet implemented"); 
		// FIXME
	}
	
	@Override
	public Collection<SimulinkBlock> getChildren() {
		// TODO unimplemented
		return null;
	}
	
	@Override
	public SimulinkModelElement inspect() {
		String h = StateflowUtil.getBlockHandle(this);
		engine.eval("get(?);", h);
		return this;
	}
	
	public SimulinkBlock asSimulink() {
		// FIXME
		return (SimulinkBlock) this;
	}

	/*************************/
	/** METHODS BELOW ARE OK */
	/*************************/
	
	@Override
	public boolean equals(Object other) {
		return (other instanceof StateflowBlock) 
				&& ((StateflowBlock) other).getId().equals(this.getId());
	}

}
