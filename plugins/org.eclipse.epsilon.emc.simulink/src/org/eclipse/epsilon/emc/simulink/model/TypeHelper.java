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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.util.StateflowUtil;
import org.eclipse.epsilon.emc.simulink.util.collection.SimulinkBlockCollection;
import org.eclipse.epsilon.emc.simulink.util.collection.SimulinkElementCollection;
import org.eclipse.epsilon.emc.simulink.util.collection.SimulinkLineCollection;
import org.eclipse.epsilon.emc.simulink.util.collection.SimulinkPortCollection;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;

public class TypeHelper {

	private static final String FIND_KIND	= FIND + ", 'Type', '%s');";
	private static final String FIND_TYPE 	= FIND + ", '%sType', '?');";

	private static Map<String, String> map = new HashMap<String, String>();

	public static Kind getKind(String type) {
		if (type.toLowerCase().startsWith(Kind.STATEFLOW.name().toLowerCase())) {
			return Kind.STATEFLOW;
		} else {
			String kind = map.get(type);
			if (kind != null) {				
				try {
					return Kind.get(kind);
				} catch (Exception e) {}
			}
			return null;
		} 
	}

	public static Collection<ISimulinkModelElement> getAllOfType(SimulinkModel model, MatlabEngine engine,
			String type) throws EolModelElementTypeNotFoundException {
		Kind kind = null;
		Collection<ISimulinkModelElement> list = Collections.emptyList();
		kind = TypeHelper.getKind(type);
		if (kind == null) {
			Collections.emptyList();
			for (Kind k : Kind.values()) {
				try {
					list = k.getAllSimulinkTypeFromModel(model, type);
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				return kind.getAllSimulinkTypeFromModel(model, type);
			} catch (Exception e) {
			}
		}
		return list;
	}

	public static Collection<ISimulinkModelElement> getAll(MatlabEngine engine, SimulinkModel model) {
		Collection<ISimulinkModelElement> list = new SimulinkElementCollection(model);
		list.addAll(Kind.SIMULINK.getAll(model));
		list.addAll(Kind.STATEFLOW.getAll(model));
		return list;
	}
	
	public static void put(String type, String supertype) {
		if (!map.containsKey(type)) {				
			try {
				map.put(type, supertype);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("unable to add to types");
			}
		}
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

		public  Collection<ISimulinkModelElement> getAll(SimulinkModel model) {
			switch (this) {
			case BLOCK:
			case LINE:
			case PORT:
				try {
					return getAllSimulinkKindFromModel(model);
				} catch (Exception e) {					
					break;
				}
			case SIMULINK: 
				Collection<ISimulinkModelElement> collection = new SimulinkElementCollection(model);
				collection.addAll(BLOCK.getAll(model));
				collection.addAll(LINE.getAll(model));
				collection.addAll(PORT.getAll(model));
				return collection;
			case STATEFLOW:
				try {
					return StateflowUtil.getAllStateflowBlocksFromModel(model);
				} catch (MatlabException e) {					
					break;
				}
			}
			return Collections.emptyList();
		}

		private Collection<ISimulinkModelElement> getAllSimulinkKindFromModel(SimulinkModel model) throws MatlabException, IllegalStateException {
			try {
				String cmd = String.format(FIND_KIND, getKind());
				Object blocks = model.getEngine().evalWithResult(cmd, model.getSimulinkModelName());
				switch (this) {
				case BLOCK:
					return new SimulinkBlockCollection(blocks, model);
				case LINE:
					return new SimulinkLineCollection(blocks, model);
				case PORT:
					return new SimulinkPortCollection(blocks, model);
				default:
					throw new IllegalStateException("Invalid Kind");
				}
			} catch (MatlabException e) {
				return Collections.emptyList();
			}
		}
		
		private Collection<ISimulinkModelElement> getAllSimulinkTypeFromModel(SimulinkModel model, String type) throws Exception {
			Object blocks = null;
			if (isSimulink()) {
				String cmd = String.format(FIND_TYPE, this.getKind());
				blocks = model.getEngine().evalWithResult(cmd, model.getSimulinkModelName(), type);
				switch (this) {
				case BLOCK:
					return new SimulinkBlockCollection(blocks, model);
				case LINE:
					return new SimulinkLineCollection(blocks, model);
				case PORT:
					return new SimulinkPortCollection(blocks, model);
				default:
					return Collections.emptyList();
				}
			} else if (this.equals(Kind.STATEFLOW)) {
				return StateflowUtil.getAllOfStateflowTypeFromModel(model, type);
			} else {
				throw new EolModelElementTypeNotFoundException(model.getName(), type);
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
