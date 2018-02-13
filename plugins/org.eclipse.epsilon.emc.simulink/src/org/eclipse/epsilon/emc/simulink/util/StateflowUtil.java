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

	private static final String FIND_ALL = "list = ?.find;";
	private static final String FIND_BLOCK_KIND = "list = ?.find('-isa','?')";
	private static final String FIND_BLOCK_TYPE = "list = ?.find('-isa','?')"; 
	private static final String FIND_RESULT = "get(list, 'Path')";
	private static final String FIND_BY_TYPE_ID = "? = ?.find('-isa', '?', 'Id', ?);";
	private static final String FIND_BY_ID = "? = ?.find('Id', ?);";
	private static final String FIND_BY_PATH = "? = ?.find('Path', '?');";

	/*************/
	/** HANDLES **/
	/*************/

	public static String randomHandleName() {
		return "e" + UUID.randomUUID().toString().replace("-", "").substring(0, 10);
	}

	public static void getBlockHandleAs(StateflowBlock block, String varName) throws MatlabException {
		modelHandleAsM(block);
		try {
			block.getEngine().eval(FIND_BY_TYPE_ID, varName, M, block.getType(), block.getId().intValue());
		} catch (Exception e) {
			block.getEngine().eval(FIND_BY_ID, varName, M, block.getId().intValue());
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
			Object result = engine.evalWithSetupAndResult(FIND_ALL, FIND_RESULT, M);
			return getTypeList(model, engine, result, null);
		} catch (MatlabException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static Collection<ISimulinkModelElement> getAllOfStateflowTypeFromModel(SimulinkModel model, MatlabEngine engine,
			String type) throws MatlabException {
		try{
			StateflowUtil.modelHandleAsM(model);
			type = SimulinkModel.STATEFLOW + "." + SimulinkUtil.getSimpleTypeName(type);
			Object result = engine.evalWithSetupAndResult(FIND_BLOCK_TYPE, FIND_RESULT, M, type);
			return getTypeList(model, engine, result, type);
		} catch (MatlabException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	public static Collection<ISimulinkModelElement> getAllOfStateflowKindFromModel(SimulinkModel model, MatlabEngine engine,
			String kind) {
		try {
			StateflowUtil.modelHandleAsM(model);
			Object result = engine.evalWithSetupAndResult(FIND_BLOCK_KIND, FIND_RESULT, M, kind);
			return getTypeList(model, engine, result, null);
		} catch (MatlabException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
		 
	}

	public static  List<ISimulinkModelElement> getTypeList(SimulinkModel model, MatlabEngine engine, Object paths,
			String type) {
			
		List<StateflowBlock> list = new ArrayList<StateflowBlock>();
		if (paths instanceof List) {
			try {
				for (String path : (List<String>) paths) {
					list.add(new StateflowBlock(path, model, engine));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (paths instanceof String) {
				list.add(new StateflowBlock((String) paths, model, engine));
			
		}
		return list.stream().map(e-> (ISimulinkModelElement) e).collect(Collectors.toList());
	}
	
}
