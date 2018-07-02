package org.eclipse.epsilon.emc.simulink.model.element;

import static org.eclipse.epsilon.emc.simulink.engine.MatlabEngineCommands.SET_PROPERTY_TO_HANDLE;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.TypeHelper.Kind;
import org.eclipse.epsilon.emc.simulink.util.MatlabEngineUtil;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationException;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

@SuppressWarnings("unused")
public class SimulinkBlock extends SimulinkElement {

	/** CONSTANTS */

	private static final Kind kind = Kind.BLOCK;

	private static final String HANDLE_DELETE_BLOCK_HANDLE = "handle = ?; delete_block(handle);";
	private static final String INSPECT_HANDLE = "handle = ?; inspect(handle);";
	private static final String GET_SIMULINK_BLOCK_HANDLE = "getSimulinkBlockHandle('?');";
	private static final String DELETE = "delete";
	private static final String CREATE = "add";
	private static final String DELETE_BLOCK = "handle = ?; delete_block(handle);";

	/**
	 * CONSTRUCTORS
	 * 
	 * @throws EolRuntimeException
	 */

	public SimulinkBlock(SimulinkModel model, MatlabEngine engine, Double handle) {
		super(model, engine, handle);
	}
	
	public SimulinkBlock(String path, SimulinkModel model, MatlabEngine engine) {
		super(path, model, engine);
	}

	public SimulinkBlock(SimulinkModel model, MatlabEngine engine, String type) {
		super(model, engine, type);
	}

	/** PARENT / CHILDREN **/

	protected String getParentPath() {
		SimulinkBlock parent = getParent();
		return parent == null ? model.getSimulinkModelName() : parent.getPath();
	}

	public void setParent(SimulinkBlock parent) {
		try {
			String name = (String) getProperty("name");
			String parentPath = parent == null ? model.getSimulinkModelName() : parent.getPath();
			Double newHandle = (Double) engine.evalWithResult(ADD_BLOCK_MAKE_NAME_UNIQUE_ON, getPath(),
					parentPath + "/" + name);
			engine.eval(HANDLE_DELETE_BLOCK_HANDLE, handle);
			handle = newHandle;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// Returns null for top-level elements and a SimulinkElement for nested elements
	public SimulinkBlock getParent() {
		try {
			String path = getPath();
			String name = ((String) getProperty("name")).replace("/", "//");
			if (!path.equalsIgnoreCase(name)) {
				String parentPath = path.substring(0, path.length() - name.length() - 1);
			if (parentPath.replace("//", "").indexOf("/") < 0)
				return null;
			return new SimulinkBlock(parentPath, model, engine);
			}
		} catch (EolIllegalPropertyException e) {}
			return null;
	}
	
	public List<SimulinkBlock> getChildren() {
		return SimulinkUtil.getChildren(model, engine, this);
	}
	
	public SimulinkModelElement inspect() throws EolRuntimeException {
		try {
			engine.eval(INSPECT_HANDLE, handle);
			return this;
		} catch (MatlabException e) {
			throw new EolRuntimeException(e.getMessage());
		}
	}

	@Override
	public boolean deleteElementInModel() throws EolRuntimeException {
		try {
			engine.eval(DELETE_BLOCK, getHandle());
			return true;
		} catch (MatlabException e) {
			return false;
		}
	}

	/** TYPE-SPECIFIC METHODS */

	public void setScript(String script) {
		try {
			engine.eval("sf = sfroot();" + "block = sf.find('Path','?','-isa','Stateflow.EMChart');"
					+ "block.Script = sprintf('?');", getPath(), script);
		} catch (MatlabException e) {
			e.printStackTrace();
		}
	}

	public String getScript() {
		try {
			engine.eval("sf = sfroot();" + "block = sf.find('Path','?','-isa','Stateflow.EMChart');"
					+ "script = string(block.Script);", getPath());
			return engine.getVariable("script") + "";
		} catch (MatlabException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public void link(SimulinkBlock other) throws EolRuntimeException {
		link(other, 1, 1);
	}

	public void linkTo(SimulinkBlock other, int inPort) throws EolRuntimeException {
		link(other, 1, inPort);
	}

	public void linkFrom(SimulinkBlock other, int outPort) throws EolRuntimeException {
		link(other, outPort, 1);
	}

	public void link(SimulinkBlock other, int outPort, int inPort) throws EolRuntimeException {
		manageLink(other, outPort, inPort, true);
	}

	public void unlink(SimulinkBlock other) throws EolRuntimeException {
		unlink(other, 1, 1);
	}

	public void unlinkTo(SimulinkBlock other, int inPort) throws EolRuntimeException {
		unlink(other, 1, inPort);
	}

	public void unlinkFrom(SimulinkBlock other, int outPort) throws EolRuntimeException {
		unlink(other, outPort, 1);
	}

	public void unlink(SimulinkBlock other, int outPort, int inPort) throws EolRuntimeException {
		manageLink(other, outPort, inPort, false);
	}

	public void manageLink(SimulinkBlock other, int outPort, int inPort, boolean create) throws EolRuntimeException {
		String command = "sourceHandle = ?;" + "targetHandle = ?;"
				+ "OutPortHandles = get_param(sourceHandle,'PortHandles');"
				+ "InPortHandles = get_param(targetHandle,'PortHandles');"
				+ "?_line('?',OutPortHandles.Outport(?),InPortHandles.Inport(?));";
		try {
			engine.eval(command, 
					getHandle(), 
					other.getHandle(), 
					create ? CREATE : DELETE, 
					getParentPath(), 
					outPort,
					inPort);
		} catch (MatlabException ex) {
			throw new EolRuntimeException(ex.getMessage());
		}
	}

	public List<SimulinkPort> getOutports() {
		try {
			Object handles = engine.evalWithSetupAndResult("handle = ?; " + "ph = get_param(handle, 'PortHandles');", 
					"ph.Outport;", this.handle);
			return SimulinkUtil.getSimulinkPorts(model, engine, handles);
		} catch (MatlabException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<SimulinkPort> getInports() {
		try {
			Object handles = engine.evalWithSetupAndResult("handle = ?; " + "ph = get_param(handle, 'PortHandles');", 
					"ph.Inport;", this.handle);
			return SimulinkUtil.getSimulinkPorts(model, engine, handles);
		} catch (MatlabException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	protected String getSimulinkType() {
		return String.format(GET_SIMULINK_TYPE, kind.getKind());
	}
	
	@Override
	public Collection<String> getAllTypeNamesOf() {
		Collection<String> list = super.getAllTypeNamesOf();
		list.add(kind.name());
		return list;
	}

}
