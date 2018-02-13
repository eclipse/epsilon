package org.eclipse.epsilon.emc.simulink.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.engine.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkBlockModelElement;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkLine;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkPort;

public class SimulinkUtil {

	private static final String FIND_BLOCKS = "find_system('?', 'BlockType', '?')";
	private static final String FIND_SYSTEM = "find_system('?', 'FindAll', 'on')";

	public static String getSimpleTypeName(String type) { // OK
		if (type.indexOf("/") > -1) {
			String[] parts = type.split("/");
			return parts[parts.length - 1];
		}
		if (type.indexOf(".") > -1) {
			String[] parts = type.split("\\.");
			return parts[parts.length - 1];
		}
		return type;
	}
	
	public static String getTypePathInModel(SimulinkModel model, String type) { // OK
		return model.getSimulinkModelName() + "/" + getSimpleTypeName(type);
	}
	
	public static String handleMethod(ISimulinkBlockModelElement obj, String methodName, Object... parameters) {
		Double handle = ((ISimulinkBlockModelElement) obj).getHandle();
		return "handle = " + handle + "; " + handleMethod(methodName, "handle", parameters);
	}
	
	public static String handleMethodWithResult(ISimulinkBlockModelElement obj, String methodName, Object... parameters) {
		Double handle = ((ISimulinkBlockModelElement) obj).getHandle();
		return "handle = " + handle + "; " + handleMethodWithResult(methodName, "handle", parameters);
	}

	public static String handleMethodWithResult(String methodName, Object... parameters) {
		return "result = " + handleMethod(methodName, parameters) + ";"; 
	}
	
	public static String handleMethod(String methodName, Object... parameters) {
		String cmd = methodName;
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
		return cmd;
	}

	public static Double getHandle(String path, MatlabEngine engine) {
		try {
			return (Double) engine.evalWithResult("getSimulinkBlockHandle('?')", path);
		} catch (MatlabException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** GENERAL COLLECTION */

	public static <T extends ISimulinkModelElement> List<T> getTypeList(Class<T> returnType, SimulinkModel model, MatlabEngine engine,
			Object handles) {
		return getTypeList(returnType, model, engine, handles, null);
	}
	
	public static <T extends ISimulinkModelElement> List<T> getTypeList(Class<T> returnType, SimulinkModel model, MatlabEngine engine, Object handles,
			String type) {
		if (handles instanceof double[]) {
			handles = new Double[] { (Double) handles };
		}

		List<T> list = new ArrayList<T>();

		if (handles instanceof Double[]) {
			for (Double handle : (Double[]) handles) {
				list.add(instantiate(returnType, model, engine, handle, null));
			}
		} else if (handles instanceof double[]) {
			for (double handle : (double[]) handles) {
				list.add(instantiate(returnType, model, engine, handle, null));
			}
		} else if (handles instanceof List) {
			try{
				for (String path : (List<String>) handles) {
					list.add(instantiate(returnType, model, engine, null, path));
				}
			} catch (Exception e) {
				try{
					for (Double handle : (List<Double>) handles) {
						list.add(instantiate(returnType, model, engine, handle, null));
					}
				} catch (Exception ex) {}
			}
		} else if (handles instanceof String) {
			list.add(instantiate(returnType, model, engine, null, (String) handles));
		} 
 
		return list;
	}
	
	private static <T> T instantiate(Class<T> aClass, SimulinkModel model, MatlabEngine engine, Double handle,
			String path) {
		try {
			if (handle == null && path != null) {
				handle = getHandle(path, engine);
			}
			if (handle != null) {
				return aClass.getConstructor(SimulinkModel.class, MatlabEngine.class, Double.class).newInstance(model,
						engine, handle);
			} else {
				return aClass.getConstructor(SimulinkModel.class, MatlabEngine.class, Double.class, String.class)
						.newInstance(model, engine, handle);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/** SPECIFIC COLLECTION */
	
	public static List<SimulinkBlock> getSimulinkBlocks(SimulinkModel model,
			MatlabEngine engine, Object handles) {
		return SimulinkUtil.getTypeList(SimulinkBlock.class, model, engine, handles);
	}
	
	public static List<SimulinkLine> getSimulinkLines(SimulinkModel model,
			MatlabEngine engine, Object handles) {
		return SimulinkUtil.getTypeList(SimulinkLine.class, model, engine, handles);
	}
	
	public static List<SimulinkPort> getSimulinkPorts(SimulinkModel model,
			MatlabEngine engine, Object handles) {
		return SimulinkUtil.getTypeList(SimulinkPort.class, model, engine, handles);
	}
	
	public static List<ISimulinkModelElement> getAllSimulinkBlocksFromModel(SimulinkModel model,
			MatlabEngine engine) {
		try {
			return getSimulinkBlocks(model, engine, engine.evalWithResult(FIND_SYSTEM, model.getSimulinkModelName()))
					.stream().map(e -> (ISimulinkBlockModelElement) e).collect(Collectors.toList());
		} catch (MatlabException e) {
			e.printStackTrace();
			return Collections.emptyList();
		} 
	}
	
	public static List<ISimulinkModelElement> getAllSimulinkBlocksFromModel(SimulinkModel model,
			MatlabEngine engine, String type) {
		try {
			type = getSimpleTypeName(type);
			return getSimulinkBlocks(model, engine, engine.evalWithResult(FIND_BLOCKS, model.getSimulinkModelName(), type))
					.stream().map(e -> (ISimulinkBlockModelElement) e).collect(Collectors.toList());
		} catch (MatlabException e) {
			e.printStackTrace();
			return Collections.emptyList();
		} 
	}

}
