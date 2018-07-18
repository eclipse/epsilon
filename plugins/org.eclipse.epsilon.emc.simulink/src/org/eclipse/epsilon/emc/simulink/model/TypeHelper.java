/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.model;

import static org.eclipse.epsilon.emc.simulink.util.SimulinkUtil.FIND;
import static org.eclipse.epsilon.emc.simulink.util.SimulinkUtil.FIND_FOLLOW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkElement;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkLine;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkPort;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
import org.eclipse.epsilon.emc.simulink.util.StateflowUtil;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;

public class TypeHelper {

	private static final String LOAD_SIMULINK 	= "load_system simulink";
	private static final String FIND_SYSTEM 		= "sim = find_system('simulink', 'FindAll', 'on', 'LookUnderMasks', 'On', 'type', '?');";
	private static final String TYPES 			= "unique(get_param(sim, '?Type'));";

	private static final String FIND_KIND_WITH_REFS 	= FIND_FOLLOW 	+ ", 'type', '%s');";
	private static final String FIND_KIND 			= FIND 			+ ", 'Type', '%s');";
	private static final String FIND_TYPE_WITH_REFS 	= FIND_FOLLOW 	+ ", '%sType', '?');";
	private static final String FIND_TYPE 			= FIND 			+ ", '%sType', '?');";

	private static Map<String, Kind> map = null;

	public static Kind getKind(String type) throws Exception {
		if (type.toLowerCase().startsWith(Kind.STATEFLOW.name().toLowerCase())) {
			return Kind.STATEFLOW;
		} else if (map != null) {
			return map.get(type);
		} else {
			throw new Exception("Type-Kind map has not been initialised yet");
		}
	}

	public static Map<String, Kind> getMap() {
		return map;
	}

	public static void init(MatlabEngine engine) throws MatlabException {
		if (map == null) {
			map = new HashMap<String, TypeHelper.Kind>();
			engine.eval(LOAD_SIMULINK);
			List<Kind> kinds = Arrays.asList(Kind.BLOCK, Kind.LINE, Kind.PORT);
			for (Kind k : kinds) {
				engine.eval(FIND_SYSTEM, k.getKind());
				Object types = engine.evalWithResult(TYPES, k.getKind());
				try {
					List<String> typesList = (List<String>) types;
					for (String t : typesList) {
						map.put(t, k);
					}
				} catch (ClassCastException e) {
					map.put((String) types, k);
				}
			}
		}
	}

	public static <T extends ISimulinkModelElement> Collection<T> getAllOfType(SimulinkModel model, MatlabEngine engine,
			String type) throws EolModelElementTypeNotFoundException {
		Kind kind = null;
		String cmd = "";
		Collection<?> list = Collections.emptyList();
		try {
			kind = TypeHelper.getKind(type);
		} catch (Exception e) {
			throw new EolModelElementTypeNotFoundException(model.getName(), type);
		}
		try {
			Object blocks = null;
			if (kind.isSimulink()) {
				cmd = String.format(model.isFollowLinks() ? FIND_TYPE_WITH_REFS : FIND_TYPE, kind.getKind());
				blocks = engine.evalWithResult(cmd, model.getSimulinkModelName(), type);
				switch (kind) {
				case BLOCK:
					list = SimulinkUtil.getTypeList(SimulinkBlock.class, model, engine, blocks);
					break;
				case LINE:
					list = SimulinkUtil.getTypeList(SimulinkLine.class, model, engine, blocks);
					break;
				case PORT:
					list = SimulinkUtil.getTypeList(SimulinkPort.class, model, engine, blocks);
					break;
				}
				return (Collection<T>) list.stream().map(e -> (ISimulinkElement) e).collect(Collectors.toList());
			} else if (kind.equals(Kind.STATEFLOW)) {
				return (Collection<T>) StateflowUtil.getAllOfStateflowTypeFromModel(model, engine, type);
			} else {
				throw new EolModelElementTypeNotFoundException(model.getName(), type);
			}
		} catch (MatlabException e) {
			return Collections.emptyList();
		}
	}

	public static Collection<ISimulinkModelElement> getAll(MatlabEngine engine, SimulinkModel model) {
		Collection<ISimulinkModelElement> list = new ArrayList<ISimulinkModelElement>();
		list.addAll(Kind.SIMULINK.getAll(engine, model));
		list.addAll(Kind.STATEFLOW.getAll(engine, model));
		return list;
	}

	public enum Kind {
		BLOCK("Block"), LINE("Line"), PORT("Port"), SIMULINK("Simulink"), STATEFLOW("Stateflow");

		private String kind;

		Kind(String kind) {
			this.kind = kind;
		}

		public String getKind() {
			return kind;
		}
		

		public boolean is(String v) {
			return name().equalsIgnoreCase(v);
		}

		public boolean isSimulink() {
			return !this.equals(STATEFLOW);
		}

		public <T extends ISimulinkModelElement> Collection<T> getAll(MatlabEngine engine, SimulinkModel model) {
			switch (this) {
			case BLOCK:
			case LINE:
			case PORT:
				try {
					return (Collection<T>) this.getAllSimulinkKindFromModel(model, engine);
				} catch (Exception e) {
				}
				break;
			case SIMULINK:
				Collection<ISimulinkModelElement> list = new ArrayList<ISimulinkModelElement>();
				list.addAll(BLOCK.getAll(engine, model));
				list.addAll(LINE.getAll(engine, model));
				list.addAll(PORT.getAll(engine, model));
				return (Collection<T>) list;
			case STATEFLOW:
				try {
					return (Collection<T>) StateflowUtil.getAllStateflowBlocksFromModel(model, engine);
				} catch (MatlabException e) {
				}
				break;
			}
			return Collections.emptyList();
		}

		private <T extends ISimulinkModelElement> Collection<T> getAllSimulinkKindFromModel(SimulinkModel model,
				MatlabEngine engine) throws Exception {
			try {
				String cmd = String.format(model.isFollowLinks() ? FIND_KIND_WITH_REFS : FIND_KIND, getKind());
				Object blocks = engine.evalWithResult(cmd, model.getSimulinkModelName());
				List<? extends ISimulinkModelElement> list = Collections.emptyList();
				switch (this) {
				case BLOCK:
					list = SimulinkUtil.getTypeList(SimulinkBlock.class, model, engine, blocks);
					break;
				case LINE:
					list = SimulinkUtil.getTypeList(SimulinkLine.class, model, engine, blocks);
					break;
				case PORT:
					list = SimulinkUtil.getTypeList(SimulinkPort.class, model, engine, blocks);
					break;
				default:
					throw new Exception("Invalid Kind");
				}
				return (Collection<T>) list.stream().map(e -> (ISimulinkElement) e)
						.collect(Collectors.toList());
			} catch (MatlabException e) {
				return Collections.emptyList();
			}
		}

		public static Kind get(String kind) throws Exception {
			try {
				 return valueOf(kind.toUpperCase());
			} catch (IllegalArgumentException e) {
				throw new Exception("Is not kind");
			}
		}
		
	}

}
