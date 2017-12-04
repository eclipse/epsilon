package org.eclipse.epsilon.emc.simulink.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.models.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.models.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.models.StateflowBlock;

public class StateflowUtil {

	private static final String STATEFLOW = "Stateflow.";
	private static final String M = "m";
	private static final String SF_MODEL = 
			"rt = sfroot; " +
					"? = rt.find('-isa', 'Simulink.BlockDiagram', '-and', 'Name', '?');";

	private static final String FIND_ALL = "list = ?.find;";
	private static final String FIND_BLOCK_TYPE = "list = ?.find('-class','?');";
	private static final String FIND_RESULT = "get(list, 'Id');"; 
	private static final String FIND_BY_TYPE_ID = "? = ?.find('-isa', '?', 'Id', ?);";
	private static final String FIND_BY_ID = "? = ?.find('Id', ?);";
	
	/*************/
	/** HANDLES **/
	/*************/

	public static String randomHandleName() {
		return "E" + UUID.randomUUID().toString().replace("-", "").substring(0, 10);
	}

	public static void getBlockHandleAs(StateflowBlock block, String varName) {
		modelHandleAsM(block);
		try {
			block.getEngine().eval(FIND_BY_TYPE_ID, varName, M, block.getType(), block.getId().intValue());
		} catch (Exception e) {
			block.getEngine().eval(FIND_BY_ID, varName, M, block.getId().intValue());
		}		
	}

	public static String getBlockHandle(StateflowBlock block) {
		String varName = randomHandleName();
		getBlockHandleAs(block, varName);
		return varName;
	}

	public static void modelHandleAsM(StateflowBlock obj) {
		modelHandleAs(obj, M);	
	}

	public static void modelHandleAsM(SimulinkModel model) {
		modelHandleAs(model, M);	
	}

	public static void modelHandleAs(StateflowBlock obj, String as) {
		modelHandleAs(((SimulinkModel) obj.getOwningModel()), as);	
	}

	public static void modelHandleAs(SimulinkModel model, String as) {
		String modelName = model.getSimulinkModelName();
		model.getEngine().eval(SF_MODEL, as, modelName);	
	}

	/*******************/
	/** OBJECT METHOD **/
	/*******************/

	public static String handleMethod(StateflowBlock block, String methodName, Object[] parameters) {
		String h = getBlockHandle(block);
		String cmd = "result = " + h + "." + methodName; 
		if (parameters != null && parameters.length > 0){
			cmd += "(";
			for (Object parameter : parameters) {
				if (Arrays.asList(parameters).indexOf(parameter) != 0) {
					cmd += ", ";
				}
				String val = String.valueOf(parameter).replace("'", "''");
				try {
					Double.valueOf(val);
					cmd += val;
				} catch (NumberFormatException e) {
					cmd += "'" + val + "'";
				}
			}
			cmd += ")"; 
		} 
		return cmd + ";" ;
	}

	/***********/
	/** TYPES **/
	/***********/	

	public static Collection<SimulinkBlock> getAllStateflowBlocksFromModel(SimulinkModel model, MatlabEngine engine) {
		System.out.println("in getAllStateflowBlocksFromModel");
		modelHandleAsM(model);
		try {
			Object result = model.getEngine().evalWithSetupAndResult(FIND_ALL, FIND_RESULT, M);
			System.out.println(result.getClass().getName() + "-" + result.getClass().getCanonicalName() + ":" + result);
		} catch (Exception e) {
			MatlabEngineUtil.formatException(e);
			return null;
		}
		return null;
	}

	public static Collection<SimulinkBlock> getAllOfStateflowTypeFromModel(SimulinkModel model, MatlabEngine engine, String type) {
		System.out.println("in getAllOfStateflowTypeFromModel");
		modelHandleAsM(model);
		try {
			Object result = engine.evalWithSetupAndResult(FIND_BLOCK_TYPE, FIND_RESULT, M, type);
			return getStateflowBlocksFromArray(model, engine, result, type);
		} catch (Exception e) {
			MatlabEngineUtil.formatException(e);
			return null;
		}	
	}

	public static Collection<StateflowBlock> getAllOfStateflowKindFromModel(SimulinkModel model, MatlabEngine engine, String kind) {
		System.out.println("in getAllOfStateflowKindFromModel");
		return null;
	}

	public static List<StateflowBlock> getAllStateflowBlocksFromChart(SimulinkModel model, MatlabEngine engine) {
		return null;
	}

	public static List<StateflowBlock> getAllOfStateflowTypeFromChart(SimulinkModel model, MatlabEngine engine, String type) {
		return null;
	}

	public static List<StateflowBlock> getAllOfStateflowKindFromChart(SimulinkModel model, MatlabEngine engine, String kind) {
		return null;
	}

	/**
	"ch = m.find('-isa', 'Stateflow.Chart');", <- model chart(s)
	ch(1).Id; <- chart 1's ID
	ch.find; <- all elements from chart
	 */

	public static StateflowBlock fromSimulinkBlock(SimulinkBlock block) {
		//TODO
		return null;
	}

	public static Collection<SimulinkBlock> getStateflowBlocksFromArray(SimulinkModel model, MatlabEngine engine, Object array, String type) {
		System.out.println("ARRAY IS OF CLASS: " + array.getClass());
		//ARRAY IS OF CLASS: class java.lang.Double
		return null;
	}
}
