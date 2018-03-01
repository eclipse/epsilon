package org.eclipse.epsilon.emc.simulink.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.engine.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.model.element.StateflowBlock;

public class StateflowUtil {

	private static final String M = "m";
	private static final String SF_MODEL = "rt = sfroot; "
			+ "? = rt.find('-isa', 'Simulink.BlockDiagram', '-and', 'Name', '?');";

	private static final String FIND_ALL = "list = ?.find('-isa','Stateflow.Object');";
	private static final String FIND_BLOCK_TYPE = "list = ?.find('-isa','?');"; 
	private static final String GET_IDS = "get(list, 'Id')";
	private static final String FIND_BY_ID = "? = ?.find('Id', ?);";
	private static final String FIND_BY_PATH = "? = ?.find('Path', '?');";
	private static final String FIND_BY_TYPE_PATH = "? = ?.find('-isa', '?', 'Path', '?');";

	/*************/
	/** HANDLES **/
	/*************/

	public static String randomHandleName() {
		return "e" + UUID.randomUUID().toString().replace("-", "").substring(0, 10);
	}

	public static void getBlockHandleAs(StateflowBlock block, String varName) throws MatlabException {
		modelHandleAsM(block);
		if (block.getId() != null) {
			block.getEngine().eval(FIND_BY_ID, varName, M, block.getId().intValue());
		} else if (block.getPath() != null) {
			block.getEngine().eval(FIND_BY_TYPE_PATH, varName, M, block.getType(), block.getPath());
		}
	}

	public static String getBlockHandle(StateflowBlock block) throws MatlabException {
		String varName = randomHandleName();
		getBlockHandleAs(block, varName);
		return varName;
	}
	
	public static String getBlockHandleFromId(SimulinkModel model, MatlabEngine engine, Integer id) throws MatlabException {
		modelHandleAsM(model);
		String varName = randomHandleName();
		engine.eval(FIND_BY_ID, varName, M, id.intValue());
		return varName;
	}
	
	public static String getBlockHandleFromPath(SimulinkModel model, MatlabEngine engine, String path) throws MatlabException {
		modelHandleAsM(model);
		String varName = randomHandleName();
		engine.eval(FIND_BY_PATH, varName, M, path);
		return varName;
	}
	
	public static String getBlockHandleFromTypeAndPath(SimulinkModel model, MatlabEngine engine, String type, String path) throws MatlabException {
		modelHandleAsM(model);
		String varName = randomHandleName();
		engine.eval(FIND_BY_TYPE_PATH, varName, M, type, path);
		return varName;
	}
	
	public static String getBlockHandleFromId(SimulinkModel model, MatlabEngine engine, Double id) throws MatlabException {
		return getBlockHandleFromId(model, engine, id.intValue());
	}

	public static void modelHandleAsM(ISimulinkModelElement obj) throws MatlabException {
		modelHandleAs(obj, M);
	}

	public static void modelHandleAsM(SimulinkModel model) throws MatlabException {
		modelHandleAs(model, M);
	}

	public static void modelHandleAs(ISimulinkModelElement obj, String as) throws MatlabException {
		modelHandleAs(((SimulinkModel) obj.getOwningModel()), as);
	}

	public static void modelHandleAs(SimulinkModel model, String as) throws MatlabException {
		String modelName = model.getSimulinkModelName();
		model.getEngine().eval(SF_MODEL, as, modelName);
	}
	
	/*******************/
	/** OBJECT METHOD **/
	/*******************/

	public static String handleMethod(StateflowBlock block, String methodName, Object[] parameters) throws MatlabException {
		String h = getBlockHandle(block);
		String cmd = "result = " + h + "." + methodName;
		if (parameters != null && parameters.length > 0) {
			cmd += "(";
			List<Object> list = Arrays.asList(parameters);
			for (Object parameter : list) {
				if (list.indexOf(parameter) != 0) cmd += ", ";
				if (parameter instanceof String) {
					cmd += "'" + String.valueOf(parameter) + "'";
				} else {
					cmd += parameter;
				}
			}
			cmd += ")";
		}
		cmd += ";";
		return cmd;
	}

	/***********/
	/** TYPES **/
	/***********/

	public static Collection<ISimulinkModelElement> getAllStateflowBlocksFromModel(SimulinkModel model, MatlabEngine engine)
			throws MatlabException {
		try{
			StateflowUtil.modelHandleAsM(model);
			Object ids = engine.evalWithSetupAndResult(FIND_ALL, GET_IDS, M);
			return getTypeList(model, engine, ids);
		} catch (MatlabException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static Collection<ISimulinkModelElement> getAllOfStateflowTypeFromModel(SimulinkModel model, MatlabEngine engine,
			String type) throws MatlabException {
		try{
			StateflowUtil.modelHandleAsM(model);
			Object ids = engine.evalWithSetupAndResult(FIND_BLOCK_TYPE, GET_IDS, M, type);
			return getTypeList(model, engine, ids);
		} catch (MatlabException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	public static  Collection<ISimulinkModelElement> getTypeList(SimulinkModel model, MatlabEngine engine, Object ids) {
		if (ids == null) 
			return Collections.emptyList();
		
		List<StateflowBlock> list = new ArrayList<StateflowBlock>();
		if (ids instanceof List) {
			try {
				for (Double id : (List<Double>) ids) {
					list.add(new StateflowBlock(model, engine, id));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (ids instanceof Double) {
				list.add(new StateflowBlock(model, engine, (Double) ids));
		}
		return list.stream().map(e-> (ISimulinkModelElement) e).collect(Collectors.toList());
	}
	
	public static StateflowBlock cast(Object object){ // TODO to cast response to Simulink or Stateflow Block
		return null;
	}
	
}
