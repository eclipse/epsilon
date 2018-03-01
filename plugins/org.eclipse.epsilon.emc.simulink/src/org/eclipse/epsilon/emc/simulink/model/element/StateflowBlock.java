package org.eclipse.epsilon.emc.simulink.model.element;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.engine.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
import org.eclipse.epsilon.emc.simulink.util.StateflowUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class StateflowBlock extends SimulinkModelElement {
	
	/** CONSTANTS */

	//public static final String STATEFLOW_LIB = "sflib/";
	private static final String SIMPLE_TYPE = "?.classhandle.get('Name');";
	private static final String DELETE_SF = "?.delete;";

	/** FIELDS */

	private Double id;
	private Double parentId;
	
	private String path;
	private String parentPath;
	
	private HashMap<String, Object> properties = new HashMap<String, Object>();

	/** CONSTRUCTORS */

	// SimulinkBlock as StateflowBlock
	/*public StateflowBlock(SimulinkBlock simulinkBlock) throws EolRuntimeException {
		super(simulinkBlock.model, simulinkBlock.engine);
			String stateflowType = SimulinkModel.STATEFLOW + "." + simulinkBlock.getType().replace(" ", "");
			stateflowType = (stateflowType.endsWith("Chart")) ?  stateflowType : stateflowType + "Chart";
			System.out.println(stateflowType);
			setType(stateflowType);
			try {
				buildFromSimulink(simulinkBlock);
			} catch (MatlabException e) {
				throw new EolRuntimeException(e.getMessage());
			}	
		} else {
			throw new EolRuntimeException("Could not guess stateflow type");
		}
		
	}*/

	// From SimulinkBlock Chart Parent
	/*public StateflowBlock(SimulinkModel model, MatlabEngine engine, String type, SimulinkBlock parent) throws EolRuntimeException {
		this(model, engine, type, parent.asStateflow());
	}*/

	// From StateflowBlock Parent
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, String type, StateflowBlock parent) throws EolRuntimeException {
		super(model, engine);
		setType(type);
		this.parentId = parent.getId();
		this.parentPath = parent.getPath();
		buildFromStateflow(parent);
	}

	/** PARENT-LESS CONSTRUCTORS */

	public StateflowBlock(SimulinkModel model, MatlabEngine engine, String type) {
		super(model, engine);
		setType(type);
		this.parentId = null;
		this.parentPath = null;
	}
	
	/** FROM ID */

	// From known StateflowBlock Id
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, Double stateflowId) {
		super(model, engine);
		this.id = stateflowId;
		setType();
		setPath();
		setParent();
	}

	// From known StateflowBlock Id as Integer
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, Integer stateflowId) {
		this(model, engine, stateflowId.doubleValue());
	}

	// From known StateflowBlock Id
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, String type, Double stateflowId) {
		super(model, engine);
		this.id = stateflowId;
		setType();
		setPath();
		setParent();
	}

	// From known StateflowBlock Id as Integer
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, String type, Integer stateflowId) {
		this(model, engine, type, stateflowId.doubleValue());
	}

	/** TYPE */

	private void setType(String type){
		if (type != null) {
			if (type.startsWith(SimulinkModel.STATEFLOW))
				this.type = type;
		} else {
			setType();
		}
	}
	
	private void setType(){
		if (this.id != null) {
			try {
				String handle = StateflowUtil.getBlockHandleFromId(model, engine, this.id);
				this.type = SimulinkModel.STATEFLOW + ". " + (String) engine.evalWithResult(SIMPLE_TYPE, handle);
			} catch (MatlabException e) {
				this.type = null;
			}
		}
	}
	
	@Override
	public String getType() { // RETURNS E.G. "STATE"
		return this.type;	
	}

	/** PROPERTIES **/

	private boolean isUnset() {
		return id == null;
	}

	@Override
	public Object getProperty(String property) throws MatlabException { 
		if (isUnset()) {
			return properties.get(property.toLowerCase());
		} else {
			if (property.equalsIgnoreCase("parent") || property.equalsIgnoreCase("up")) {
				return getParent();
			} else {
				String h = StateflowUtil.getBlockHandle(this);
				return engine.evalWithResult("?.?;", h, property);				
			}
		}
	}

	@Override
	public void setProperty(String property, Object value) throws EolIllegalPropertyException { 
		try {
			if (property.equalsIgnoreCase("parent") || property.equalsIgnoreCase("up")) {
				try {
					setParent(value);
				} catch (EolRuntimeException e) {
					e.printStackTrace();
					throw new EolIllegalPropertyException(this, property, null, null);
				}
			} else {
				if (isUnset()) {
					properties.put(property.toLowerCase(), value);
				} else {
					String escaped = "?";

					String randomHandle = "";
					if (value instanceof StateflowBlock) {
						randomHandle = StateflowUtil.getBlockHandle(((StateflowBlock) value));
						value = randomHandle;
					}
					if (value instanceof String
							&& (!((String) value).startsWith("[") && !((String) value).endsWith("]"))
							&& !((String) value).equals(randomHandle)
							) {
						escaped = "'" + escaped + "'";
					}
					String cmd = "?.? = " + escaped + ";";
					String h = "";
					h = StateflowUtil.getBlockHandle(this);
					engine.eval(cmd, h, property, value);					
				}
			}
		} catch (MatlabException e) {
			e.printStackTrace();
			throw new EolIllegalPropertyException(this, property, null, null);
		}
	}

	/** IDENTIFIER */

	public Double getId() { 
		if (this.id == null) { 
			System.err.println("ID WAS NULL");
		}
		return this.id;
	}
	
	private void setPath() {
		if (this.id != null) {
			try {
				String handle = StateflowUtil.getBlockHandleFromId(model, engine, id);
				this.path = (String) engine.evalWithResult("?.path", handle);
			} catch (MatlabException e) {
				this.path = null;
			}
		}
	}
	
	public String getPath() {
		return path;
	}

	// PARENT CHILDREN

	public ISimulinkModelElement getParent() {
		if (this.parentId != null || this.parentPath != null) {
			//try {
				//String handle; 
				if (parentId != null) {
				//	handle = StateflowUtil.getBlockHandleFromId(model, engine, parentId);
					return new StateflowBlock(model, engine, parentId);
				} else if (this.parentPath != null) {
				//	handle = StateflowUtil.getBlockHandleFromPath(model, engine, parentPath);
					//return new StateflowBlock(parentPath, model, engine);	
				}
				//String parentType = (String) engine.evalWithResult("?.class;", handle);
				/*if (parentType.toLowerCase().contains("chart")) {
					return new SimulinkDualBlock(model, engine, sf);
				} else {
					return sf;
				}*/
			/*} catch (MatlabException e) {
				e.printStackTrace();
			}*/
		}
		return null;
	}
	
	private void setParent() { // When Id is known
		if (this.id != null) {
			try {
				String h = StateflowUtil.getBlockHandle(this);
				this.parentId = (Double) engine.evalWithSetupAndResult("p=?.up;", "p.Id;", h);
				this.parentPath = (String) engine.evalWithResult("p.Path;");
			} catch (MatlabException e) {
				System.out.println("Parent is the model");
				this.parentId = null;
				this.parentPath = null;
			}
		}
	}

	public void setParent(Object parent) throws EolRuntimeException {
		/*if (parent instanceof SimulinkBlock) {
			this.setParent((SimulinkBlock) parent);
		} else*/ if (parent instanceof StateflowBlock) {
			this.setParent((StateflowBlock) parent);
		}
	}

	/*public void setParent(SimulinkBlock parent) throws EolRuntimeException {
		setParent(parent.asStateflow());
	}*/

	public void setParent(StateflowBlock parent) throws EolRuntimeException {
		if (!this.isUnset()) {
			changeParent(parent);
		} else {
			buildFromStateflow(parent);
			applyProperties();
		}
	}

	private void applyProperties() throws EolIllegalPropertyException {
		Iterator<String> keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			setProperty(key, properties.get(key));
		}
		properties.clear();
	}

	private void changeParent(StateflowBlock parent) throws RuntimeException { // TODO
		throw new RuntimeException("Not yet implemented");
		/*try {
			String positionProperty = "Position";
			Object position = getProperty(positionProperty);
			Object newParentPosition = parent.getProperty(positionProperty);
			Object newPosition = newParentPosition;
			// setProperty(positionProperty, newPosition);
		} catch (MatlabException e) {
			e.printStackTrace();
		}*/
	}

	/** BUILDERS */

	/*private void buildFromSimulink(SimulinkBlock chart) throws MatlabException {
		StateflowUtil.modelHandleAsM(this);
		String chartPath = chart.getPath();
		this.id = (Double) this.engine.evalWithSetupAndResult("sim = m.find('Path','?', '-isa', '?');", "sim.id;",
				chartPath, this.getType());//, sim.getProperty("Name")); // Relying in the MakeNameUnique Parameter
		this.path = (String) this.engine.evalWithResult("sim.Path;");
	}*/

	private void buildFromStateflow(StateflowBlock parent) throws EolRuntimeException {
		if (!parent.isUnset()) {
			String parentHandle;
			try {
				parentHandle = StateflowUtil.getBlockHandle(parent);
				engine.eval("block = ?(?);", getType(), parentHandle);
				this.id = (Double) engine.evalWithResult("block.id;");
				this.path = (String) this.engine.evalWithResult("block.path;");
			} catch (MatlabException e) {
				e.printStackTrace();
				throw new EolRuntimeException(e.getMessage());
			}
		} else {
			throw new EolRuntimeException("Parent was not a valid entity");
		}
	}

	@SuppressWarnings("unchecked")
	public Collection<StateflowBlock> getChildren() {
		try {
			String handle = StateflowUtil.getBlockHandle(this);
			List<Double> children = (List<Double>) this.engine.evalWithSetupAndResult("list = ?.find('-depth',1);", "get(list,'Id');", handle);
			return children.stream().map(e -> new StateflowBlock( model, engine, id)).collect(Collectors.toList());
		} catch (MatlabException e) {
			e.printStackTrace();
			return Collections.<StateflowBlock>emptyList();
		}
	}

	public StateflowBlock inspect() { 
		try {
			String h = StateflowUtil.getBlockHandle(this);
			engine.eval("get(?);", h);
		} catch (MatlabException e) {
		}
		return this;
	}

	@Override
	public boolean equals(Object other) { 
		return (other instanceof StateflowBlock) && ((StateflowBlock) other).getId().equals(this.getId());
	}

	@Override
	public String toString() {
		return getType() + "[ id = " + getId() + ", path = " + getPath() + " ]";
	}

	@Override
	public Collection<String> getAllTypeNamesOf() {
		return Arrays.asList(SimulinkModel.BLOCK, SimulinkModel.STATEFLOW, getType());
	}

	@Override
	public boolean deleteElementInModel() throws EolRuntimeException { 
		try {
			engine.eval(DELETE_SF, StateflowUtil.getBlockHandle(this));
			return true;
		} catch (MatlabException e) {
			return false;
		}
	}
	
	public StateflowBlock add(StateflowBlock block) { 
		try {
			block.setParent(this);
		} catch (EolRuntimeException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public SimulinkBlock asSimulink() throws EolRuntimeException {
		Double h = SimulinkUtil.getHandle(this.getPath(), this.engine);
		if (h >= 0) 
			return new SimulinkBlock(model, engine, h);	
		throw new EolRuntimeException("This block does not have a simulink Nature");
	}
}
