package org.eclipse.epsilon.emc.simulink.model.element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class SimulinkDualBlock extends SimulinkBlock {

	private StateflowBlock stateflowBlock;
		
	public final static String SIMULINK_BLOCK_TYPE = "sflib/Chart";
	public final static String CACHE_TYPE = "Chart";
	public final static ArrayList<String> dualTypes;
	
	static {
		dualTypes = new ArrayList<String>();
		dualTypes.add(SIMULINK_BLOCK_TYPE);
	}
	
	public SimulinkDualBlock(SimulinkModel model, MatlabEngine engine) {
		super(model, engine, SIMULINK_BLOCK_TYPE);
		this.stateflowBlock = new StateflowBlock(this);
	}
	
	public SimulinkDualBlock(SimulinkModel model, MatlabEngine engine, StateflowBlock block) {
		super(model, engine, SIMULINK_BLOCK_TYPE);
		this.stateflowBlock = block;
		this.handle = SimulinkUtil.getHandle(block.getPath(), engine);
	}
	
	public SimulinkDualBlock(SimulinkModel model, MatlabEngine engine, String type) {
		super(model, engine, type);
		this.stateflowBlock = new StateflowBlock(this);
	}
	
	public StateflowBlock asStateflow() {
		return this.stateflowBlock; 
	}

	public static boolean includes(String type) {
		return dualTypes.contains(type);
	}
	
	@Override
	public Collection<String> getAllTypeNamesOf() {
		return super.getAllTypeNamesOf();
	}
	
	public SimulinkDualBlock add(StateflowBlock block) {
		try {
			block.setParent(this);
		} catch (EolRuntimeException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public Collection<StateflowBlock> getStateflowBlocks(){
		return this.stateflowBlock.getChildren();
	}
	
	@Override
	public List<SimulinkBlock> getChildren() {
		return super.getChildren();
	}
	
	@Override
	public String toString() {
		return getType() + "[ SimulinkHAndle= " + getHandle() + ", StateflowId = " + this.stateflowBlock.getId() + " ]";
	}
}
