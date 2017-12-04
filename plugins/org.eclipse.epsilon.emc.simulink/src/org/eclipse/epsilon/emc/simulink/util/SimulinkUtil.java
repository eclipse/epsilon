package org.eclipse.epsilon.emc.simulink.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.models.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.models.SimulinkModelElement;

public class SimulinkUtil {

	public static String getSimpleTypeName(String type) {
		if (type.indexOf("/") > -1) {
			String[] parts = type.split("/");
			return parts[parts.length-1];
		}
		if (type.indexOf(".") > -1) {
			String[] parts = type.split(".");
			return parts[parts.length-1];
		}
		return type;
	}
	
	public static String handleMethod(SimulinkModelElement obj, String methodName, Object[] parameters) {
		Double handle = ((SimulinkModelElement) obj).getHandle();
		String cmd = "handle = " + handle + "; result = " + methodName + "(handle";
		for (Object parameter : parameters) {
			String val = String.valueOf(parameter).replace("'", "''");
			try {
				Double.valueOf(val);
				cmd += ", " + val;
			} catch (NumberFormatException e) {
				cmd += ", '" + val + "'";
			}
		}
		return cmd + ")";
	}

	public static <T> List<T> getTypeList(Class<T> returnType, SimulinkModel model, MatlabEngine engine, Object handles) {
		return getTypeList(returnType, model, engine, handles, null);
	}
	
	public static <T> List<T> getTypeList(Class<T> returnType, SimulinkModel model, MatlabEngine engine, Object handles, String type) {
		if (handles instanceof Double) {
			handles = new Double[]{(Double) handles};
		}
		
		List<T> list = new ArrayList<T>();
		
		if (handles instanceof Double[]) {
			for (Double handle : (Double[]) handles) {
				list.add(instantiate(returnType, model, engine, handle, type));
			}
		}
		else if (handles instanceof double[]) {
			for (double handle : (double[]) handles) {
				list.add(instantiate(returnType, model, engine, handle, type));
			}
		}
		
		return list;
	}
	
	private static <T> T instantiate(Class<T> aClass, SimulinkModel model, MatlabEngine engine, Double handle, String type) {
		 try {
			 if (type == null) {
				 return aClass
							.getConstructor(SimulinkModel.class, MatlabEngine.class, Double.class)
							.newInstance(model, engine, handle);
			 } else {
				 return aClass
							.getConstructor(SimulinkModel.class, MatlabEngine.class, Double.class, String.class)
							.newInstance(model, engine, handle, type);
			 }
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

}
