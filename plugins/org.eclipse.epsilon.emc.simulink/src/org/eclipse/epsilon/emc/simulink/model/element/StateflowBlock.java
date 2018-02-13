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
import org.eclipse.epsilon.emc.simulink.util.StateflowUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class StateflowBlock extends SimulinkModelElement {

	/** CONSTANTS */

	public static final String STATEFLOW_LIB = "sflib/";
	private static final String FULLY_QUALIFIED_CLASS = "?.class;";
	private static final String SIMPLE_TYPE = "?.classhandle.Name;";
	private static final String DELETE_SF = "?.delete;";

	/** FIELDS */

	private Double id;
	private Double parentId;
	private HashMap<String, Object> properties = new HashMap<String, Object>();

	/** CONSTRUCTORS */

	// SimulinkBlock Chart as StateflowBlock
	public StateflowBlock(SimulinkDualBlock chart) {
		super(chart.model, chart.engine, SimulinkModel.STATEFLOW + "." + chart.getSimpleType());

		try {
			buildChart(chart);
		} catch (MatlabException e) {
			e.printStackTrace();
		}
	}

	// From SimulinkBlock Chart Parent
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, String type, SimulinkDualBlock parent) {
		this(model, engine, type, parent.asStateflow());
	}

	// From StateflowBlock Parent
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, String type, StateflowBlock parent) {
		super(model, engine, type);
		this.parentId = parent.getId();
		try {
			buildFromStateflow(parent);
		} catch (MatlabException e) {
			e.printStackTrace();
		}
	}

	/** PARENT-LESS CONSTRUCTORS */

	public StateflowBlock(SimulinkModel model, MatlabEngine engine, String type) {
		super(model, engine, type);
		this.parentId = null;
	}

	/** FROM DIFFERENT PROPERTIES */

	public StateflowBlock(String path, SimulinkModel model, MatlabEngine engine) {
		super(model, engine);
		this.id = getIdFromPath(path);
		getType();
		setParent();
	}

	// From known StateflowBlock Id
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, Double stateflowId) {
		super(model, engine);
		this.id = stateflowId;
		getType();
		setParent();
	}

	// From known StateflowBlock Id as Integer
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, Integer stateflowId) {
		this(model, engine, stateflowId.doubleValue());
	}

	// From known StateflowBlock Id
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, String type, Double stateflowId) {
		super(model, engine, type);
		this.id = stateflowId;
		setParent();
	}

	// From known StateflowBlock Id as Integer
	public StateflowBlock(SimulinkModel model, MatlabEngine engine, String type, Integer stateflowId) {
		this(model, engine, type, stateflowId.doubleValue());
	}

	/** TYPE */

	@Override
	public String getType() { // OK RETURNS E.G. "STATEFLOW.STATE"
		if (this.type == null && this.id != null) {
			try {
				String h = StateflowUtil.getBlockHandleFromId(model, engine, getId());
				this.type = (String) engine.evalWithResult(FULLY_QUALIFIED_CLASS, h);
			} catch (MatlabException e) {
				e.printStackTrace();
			}
		}
		return this.type;
	}

	public String getSimpleType() { // OK RETURNS E.G. "STATE"
		try {
			String h = StateflowUtil.getBlockHandle(this);
			return (String) engine.evalWithResult(SIMPLE_TYPE, h);
		} catch (MatlabException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String getStateflowType(SimulinkBlock block) { // OK
		String t = block.getType();
		return t.startsWith(STATEFLOW_LIB) ? t.replace(STATEFLOW_LIB, "Stateflow.") : "Stateflow." + t;
	}

	/** PROPERTIES **/

	private boolean isUnset() {
		return id == null && parentId == null;
	}

	@Override
	public Object getProperty(String property) throws MatlabException { // OK
		if (isUnset()) {
			return properties.get(property.toLowerCase());
		} else {
			if (property.equalsIgnoreCase("parent") || property.equalsIgnoreCase("up")) {
				return getParent();
			} else {
				StateflowUtil.modelHandleAsM(this);
				return engine.evalWithSetupAndResult("block = m.find('-isa', '?', 'Id', ?);", "block.?;", getType(),
						getId().intValue(), property);				
			}
		}
	}

	@Override
	public void setProperty(String property, Object value) throws EolIllegalPropertyException { // OK
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
					String val = "?";

					String randomHandle = "";
					if (value instanceof StateflowBlock) {
						randomHandle = StateflowUtil.getBlockHandle(((StateflowBlock) value));
						value = randomHandle;
					}
					if (value instanceof String
							&& (!((String) value).startsWith("[") && !((String) value).endsWith("]"))
							&& !((String) value).equals(randomHandle)) {
						val = "'" + val + "'";
					}
					String cmd = "block = m.find('-isa', '?', 'Id', ?);" + "block.? = " + val + ";";
					engine.eval(cmd, getType(), getId().intValue(), property, value);
				}
			}
		} catch (MatlabException e) {
			e.printStackTrace();
			throw new EolIllegalPropertyException(this, property, null, null);
		}

	}

	/** IDENTIFIER */

	public Double getId() { // OK
		return this.id;
	}

	public Double getIdFromPath(String path) { // OK
		try {
			String h = StateflowUtil.getBlockHandleFromPath(model, engine, path);
			return (Double) engine.evalWithResult("?.Id;", h);
		} catch (MatlabException e) {
			return null;
		}
	}

	public String getPath() {
		try {
			String h = StateflowUtil.getBlockHandle(this);
			return (String) engine.evalWithResult("?.Path;", h);
		} catch (MatlabException e) {
			return null;
		}
	}

	// PARENT CHILDREN

	private void setParent() { // When Id is provided
		if (this.id != null) {
			try {
				String h = StateflowUtil.getBlockHandle(this);
				String path = (String) engine.evalWithSetupAndResult("p=?.up;", "p.Path;", h);
				String parentHanlde = StateflowUtil.getBlockHandleFromPath(model, engine, path);
				this.parentId = (Double) engine.evalWithResult("?.id;", parentHanlde);
			} catch (MatlabException e) {
				System.out.println("Parent is the model");
				this.parentId = null;
			}
		}
	}

	public ISimulinkModelElement getParent() {
		if (this.parentId != null) {
			try {
				String handle = StateflowUtil.getBlockHandleFromId(model, engine, parentId);
				String parentType = (String) engine.evalWithResult("?.class;", handle);
				StateflowBlock sf = new StateflowBlock(model, engine, parentType, parentId);
				if (parentType.toLowerCase().contains("chart")) {
					return new SimulinkDualBlock(model, engine, sf);
				} else {
					return sf;
				}
			} catch (MatlabException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public void setParent(Object parent) throws EolRuntimeException {
		if (parent instanceof SimulinkDualBlock) {
			this.setParent((SimulinkDualBlock) parent);
		} else if (parent instanceof StateflowBlock) {
			this.setParent((StateflowBlock) parent);
		}
	}

	public void setParent(SimulinkDualBlock parent) throws EolRuntimeException {
		if (this.parentId != null) {
			throw new RuntimeException("Not yet implemented");
			// changeParent(parent);
		} else {
			try {
				buildFromDual(parent);
				applyProperties();
			} catch (MatlabException e) {
				e.printStackTrace();
			}
		}
	}

	public void setParent(StateflowBlock parent) throws EolRuntimeException {
		if (this.parentId != null) {
			throw new RuntimeException("Not yet implemented");
			// changeParent(parent);
		} else {
			//this.parentId = parent.getId();
			try {
				buildFromStateflow(parent);
				applyProperties();
			} catch (MatlabException e) {
				e.printStackTrace();
			}
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

	private void changeParent(StateflowBlock parent) throws MatlabException { // TODO
		try {
			String positionProperty = "Position";
			Object position = getProperty(positionProperty);
			Object newParentPosition = parent.getProperty(positionProperty);
			Object newPosition = newParentPosition; // FIXME
			// setProperty(positionProperty, newPosition);
		} catch (MatlabException e) {
			e.printStackTrace();
		}
	}

	/** BUILDERS */

	private void buildChart(SimulinkDualBlock chart) throws MatlabException {
		StateflowUtil.modelHandleAsM(this);
		this.id = (Double) this.engine.evalWithSetupAndResult("chart = m.find('Path','?', '-isa', '?');", "chart.id;",
				chart.getPath(), getStateflowType(chart));
	}

	private void buildFromStateflow(StateflowBlock parent) throws MatlabException {
		StateflowUtil.modelHandleAsM(this);
		this.parentId = parent.getId();
		this.id = (Double) this.engine.evalWithSetupAndResult(
				"parent = m.find('Path','?', '-isa', '?');" + "block = ?(parent);", "block.id;", parent.getPath(),
				parent.getType(), type);
	}
	
	private void buildFromDual(SimulinkDualBlock parent) throws MatlabException {
		buildFromStateflow(parent.asStateflow());
	}

	@SuppressWarnings("unchecked")
	public Collection<StateflowBlock> getChildren() {
		try {
			String handle = StateflowUtil.getBlockHandle(this);
			List<Double> children = (List<Double>) this.engine.evalWithSetupAndResult("list = ?.find('-depth',1);", "get(list, 'Id');", handle);
			return children.stream().map(e -> new StateflowBlock(model, engine, e)).collect(Collectors.toList());
		} catch (MatlabException e) {
			e.printStackTrace();
			return Collections.<StateflowBlock>emptyList();
		}
	}

	public StateflowBlock inspect() { // OK
		try {
			String h = StateflowUtil.getBlockHandle(this);
			engine.eval("get(?);", h);
		} catch (MatlabException e) {
		}
		return this;
	}

	@Override
	public boolean equals(Object other) { // OK
		return ((other instanceof StateflowBlock) && ((StateflowBlock) other).getId().equals(this.getId()))
				|| ((other instanceof SimulinkDualBlock) && ((SimulinkDualBlock) other).asStateflow().getId().equals(this.getId()));
	}

	@Override
	public String toString() {
		return getType() + "[ id = " + String.valueOf(getId()) + " ]";
	}

	@Override
	public Collection<String> getAllTypeNamesOf() { // TODO Try without simple type
		return Arrays.asList(SimulinkModel.BLOCK, SimulinkModel.STATEFLOW, getType(), getSimpleType());
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
	
	public SimulinkDualBlock asSimulink() {
		if (SimulinkDualBlock.includes(this.getType())){
			return new SimulinkDualBlock(model, engine, this);
		} else {
			return null;
		}
	}
}
