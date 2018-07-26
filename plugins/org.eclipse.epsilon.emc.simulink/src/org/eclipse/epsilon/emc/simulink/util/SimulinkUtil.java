/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.TypeHelper.Kind;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkElement;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkLine;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkPort;

public class SimulinkUtil {

	private static final String GET_BLOCK_HANDLE = "getSimulinkBlockHandle('?');";
	
	public static final String FIND = "find_system('?', 'FindAll', 'on', 'LookUnderMasks', 'On'";
	public static final String FIND_FOLLOW = "find_system('?', 'FindAll', 'on', 'LookUnderMasks', 'On', 'FollowLinks', 'on'";
	
	private static final String FIND_BLOCKS_OF_TYPE_WITH_REFS = 	FIND_FOLLOW 		+ ", 'BlockType', '?');";
	private static final String FIND_BLOCKS_OF_TYPE = 			FIND 			+ ", 'BlockType', '?');";
	private static final String FIND_SYSTEM_BLOCKS_WITH_REFS = 	FIND_FOLLOW 		+ ", 'Type', 'Block');";
	private static final String FIND_SYSTEM_BLOCKS = 				FIND 			+ ", 'Type', 'Block');";
	private static final String FIND_SYSTEM_LINES_WITH_REFS = 	FIND_FOLLOW 		+ ", 'Type', 'line');";
	private static final String FIND_SYSTEM_LINES = 				FIND 			+ ", 'Type', 'line');";
	
	private static final String FIND_BLOCKS_AT_DEPTH = 			FIND 			+ ", 'SearchDepth', ?, 'Type', 'Block');";
	private static final String FIND_BLOCKS_AT_DEPTH_WITH_REFS = 	FIND_FOLLOW 		+ ", 'SearchDepth', ?, 'Type', 'Block');";
	private static final String CHILDREN_BLOCKS = 				FIND 			+ ", 'SearchDepth', 1, 'Type', 'Block');";
	private static final String CHILDREN_BLOCKS_WITH_REFS = 		FIND_FOLLOW 		+ ", 'SearchDepth', 1, 'Type', 'Block');";
	
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
	
	public static String getTypePathInModel(SimulinkModel model, String type) { 
		return model.getSimulinkModelName() + "/" + getSimpleTypeName(type);
	}
	
	public static String handleMethod(ISimulinkElement obj, String methodName, Object[] parameters) {
		Double handle = obj.getHandle();
		return handleMethod(handle, methodName, parameters);
	}
	
	public static String handleMethod(SimulinkModel obj, String methodName, Object[] parameters) {
		Double handle = obj.getHandle();
		return handleMethod(handle, methodName, parameters);
	}
	
	private static String handleMethod(Object objHandle, String methodName, Object[] parameters) {
		List<Object> list = new ArrayList<Object>();
		list.add("handle");
		list.addAll(Arrays.asList(parameters));
		return "handle = " + objHandle + "; " + handleMethod(methodName, list.toArray());
	}
	
	public static String handleMethodWithResult(ISimulinkElement obj, String methodName, Object[] parameters) {
		Double handle = obj.getHandle();
		return handleMethodWithResult(handle, methodName, parameters);
	}
	
	public static String handleMethodWithResult(SimulinkModel obj, String methodName, Object[] parameters) {
		Double handle = obj.getHandle();
		return handleMethodWithResult(handle, methodName, parameters);
	}
	
	private static String handleMethodWithResult(Object objHandle, String methodName, Object[] parameters) {
		List<Object> list = new ArrayList<Object>();
		list.add("handle");
		list.addAll(Arrays.asList(parameters));
		return "handle = " + objHandle + "; " + handleMethodWithResult(methodName, list.toArray());
	}

	public static String handleMethodWithResult(String methodName, Object[] parameters) {
		return "result = " + handleMethod(methodName, parameters); 
	}
	
	public static String handleMethod(String methodName, Object[] parameters) {
		String cmd = methodName;
		if (parameters != null && parameters.length > 0) {
			cmd += "(" + parameters[0];
			for (int i = 1; i < parameters.length; i++) {
				cmd += ", " + "'" + String.valueOf(parameters[i]) + "'";
			}
			cmd += ");";
		}
		return cmd;
	}

	public static Double getHandle(String path, MatlabEngine engine) {
		try {
			return (Double) engine.evalWithResult(GET_BLOCK_HANDLE, path);
		} catch (MatlabException e) {
			e.printStackTrace();
		}
		return -1.0;
	}

	/** GENERAL COLLECTION */
	
	public static <T extends ISimulinkModelElement> List<T> getTypeList(Class<T> returnType, SimulinkModel model, MatlabEngine engine, Object elements) {

		List<T> list = new ArrayList<T>();

		if (elements instanceof List) {
			try{
				for (Object element : (List<?>) elements) {
					if (element instanceof String) {
						String path = (String) element;
						T instantiate = instantiate(returnType, model, engine, null, path);
						if (instantiate!= null) list.add(instantiate);	
					} else if (element instanceof Double) {
						Double handle = (Double) element;
						T instantiate = instantiate(returnType, model, engine, handle, null);
						if (instantiate!= null) list.add(instantiate);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		} else if (elements instanceof String) {
			T instantiate = instantiate(returnType, model, engine, null, (String) elements);
			if (instantiate!= null) list.add(instantiate);
		} else if (elements instanceof Double) {
			T instantiate = instantiate(returnType, model, engine, (Double) elements, null);
			if (instantiate!= null) list.add(instantiate);
		}
		return list;
	}
	
	private static <T> T instantiate(Class<T> clazz, SimulinkModel model, MatlabEngine engine, Double handle, String path) {
		try {
			if (handle != null) {
				return clazz.getConstructor(SimulinkModel.class, MatlabEngine.class, Double.class).newInstance(model, engine, handle);
			} else if (path != null) {
				return clazz.getConstructor(String.class, SimulinkModel.class, MatlabEngine.class).newInstance(path, model, engine);
			} else {
				return null;
			}
		} catch (Exception e) {
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
	
	public static List<SimulinkBlock> getChildren(SimulinkModel model,
			MatlabEngine engine, SimulinkBlock block) throws MatlabException {
			return getSimulinkBlocks(model, engine, engine.evalWithResult(CHILDREN_BLOCKS, block.getPath())); 
	}
	
	public static List<SimulinkBlock> getChildren(SimulinkModel model,
			MatlabEngine engine) throws MatlabException {
		return getSimulinkBlocks(model, engine, engine.evalWithResult(CHILDREN_BLOCKS, model.getSimulinkModelName(), model.getSimulinkModelName()));
	}
	
	public static List<ISimulinkModelElement> findBlocks(SimulinkModel model,
			MatlabEngine engine, Integer depth) throws MatlabException {
			return getSimulinkBlocks(model, engine, engine.evalWithResult(FIND_BLOCKS_AT_DEPTH, model.getSimulinkModelName(), depth))
					.stream().map(e -> (ISimulinkElement) e).collect(Collectors.toList());

	}
	
	public static List<ISimulinkModelElement> getAllSimulinkFromModel(SimulinkModel model,
			MatlabEngine engine, Kind kind) throws MatlabException {
			String cmd = model.isFollowLinks() ? FIND_SYSTEM_BLOCKS_WITH_REFS : FIND_SYSTEM_BLOCKS;
			return getSimulinkBlocks(model, engine, engine.evalWithResult(cmd, model.getSimulinkModelName()))
					.stream().map(e -> (ISimulinkElement) e).collect(Collectors.toList());	 
	}
	
	public static List<ISimulinkModelElement> getAllSimulinkBlocksFromModel(SimulinkModel model,
			MatlabEngine engine) throws MatlabException {
			String cmd = model.isFollowLinks() ? FIND_SYSTEM_BLOCKS_WITH_REFS : FIND_SYSTEM_BLOCKS;
			return getSimulinkBlocks(model, engine, engine.evalWithResult(cmd, model.getSimulinkModelName()))
					.stream().map(e -> (ISimulinkElement) e).collect(Collectors.toList());
	}
	
	public static List<ISimulinkModelElement> getAllSimulinkLinesFromModel(SimulinkModel model,
			MatlabEngine engine) throws MatlabException {
			String cmd = model.isFollowLinks() ? FIND_SYSTEM_LINES_WITH_REFS : FIND_SYSTEM_LINES;
			return getSimulinkLines(model, engine, engine.evalWithResult(cmd, model.getSimulinkModelName()))
					.stream().map(e -> (ISimulinkElement) e).collect(Collectors.toList());
	}
	
	public static List<ISimulinkModelElement> getAllSimulinkBlocksFromModel(SimulinkModel model,
			MatlabEngine engine, String type) throws MatlabException {
			final String simpleType = type;
			String cmd = model.isFollowLinks() ? FIND_BLOCKS_OF_TYPE_WITH_REFS : FIND_BLOCKS_OF_TYPE;
			Object blocks = engine.evalWithResult(cmd, model.getSimulinkModelName(), simpleType);
			return getSimulinkBlocks(model, engine, blocks)
					.stream().map(e -> (ISimulinkElement) e).collect(Collectors.toList());
	}

}
