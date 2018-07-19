package org.eclipse.epsilon.emc.simulink.model;

import static org.eclipse.epsilon.emc.simulink.util.SimulinkUtil.FIND;
import static org.eclipse.epsilon.emc.simulink.util.SimulinkUtil.FIND_FOLLOW;

import java.util.ArrayList;
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

	/*public static void process(MatlabEngine engine, String instantiationType) throws MatlabRuntimeException {

		if (instantiationType.startsWith("Stateflow.")) {
			String type = instantiationType.substring(instantiationType.indexOf(".")+1);
			TypeHelper.put(type, "Stateflow");
		} else if (instantiationType.startsWith("Simulink.")) {
			// TODO
		} else {			
			String model = instantiationType.substring(0, instantiationType.indexOf("/"));
			try {
				engine.eval("load_system " + model);				
			} catch (Exception e) {
			}
			String supertype;
			try {
				supertype = (String) engine.evalWithResult("get_param('?', 'Type')", instantiationType);
			} catch (MatlabException e) {
				throw new MatlabRuntimeException(e);
			}
			String type;
			try {
				type = (String) engine.evalWithResult("get_param('?', '?Type')", instantiationType, supertype);
			} catch (MatlabException e) {
				throw new MatlabRuntimeException(e);

			}
			TypeHelper.put(type, supertype);
			
		}
	}*/	

	public static <T extends ISimulinkModelElement> Collection<T> getAllOfType(SimulinkModel model, MatlabEngine engine,
			String type) throws EolModelElementTypeNotFoundException {
		Kind kind = null;
		String cmd = "";
		Collection<?> list = Collections.emptyList();
		kind = TypeHelper.getKind(type);
		if (kind == null) {
			Collections.emptyList();
			for (Kind k : Kind.values()) {
				try {
					list = k.getAllSimulinkTypeFromModel(model, engine, type);
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				return kind.getAllSimulinkTypeFromModel(model, engine, type);
			} catch (Exception e) {
			}
		}
		return (Collection<T>) list;
	}

	public static Collection<ISimulinkModelElement> getAll(MatlabEngine engine, SimulinkModel model) {
		Collection<ISimulinkModelElement> list = new ArrayList<ISimulinkModelElement>();
		list.addAll(Kind.SIMULINK.getAll(engine, model));
		list.addAll(Kind.STATEFLOW.getAll(engine, model));
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

		@SuppressWarnings("unchecked")
		public <T extends ISimulinkModelElement> Collection<T> getAll(MatlabEngine engine, SimulinkModel model) {
			switch (this) {
			case BLOCK:
			case LINE:
			case PORT:
				try {
					return (Collection<T>) this.getAllSimulinkKindFromModel(model, engine);
				} catch (Exception e) {					
					break;
				}
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
					break;
				}
			}
			return Collections.emptyList();
		}

		@SuppressWarnings("unchecked")
		private <T extends ISimulinkModelElement> Collection<T> getAllSimulinkKindFromModel(SimulinkModel model,
				MatlabEngine engine) throws MatlabException, IllegalStateException {
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
					throw new IllegalStateException("Invalid Kind");
				}
				return (Collection<T>) list.stream().map(e -> (ISimulinkElement) e)
						.collect(Collectors.toList());
			} catch (MatlabException e) {
				return Collections.emptyList();
			}
		}
		
		@SuppressWarnings("unchecked")
		private <T extends ISimulinkModelElement> Collection<T> getAllSimulinkTypeFromModel(SimulinkModel model,
				MatlabEngine engine, String type) throws Exception {
			Collection<?> list = Collections.emptyList();
			Object blocks = null;
			if (isSimulink()) {
				String cmd = String.format(model.isFollowLinks() ? FIND_TYPE_WITH_REFS : FIND_TYPE, this.getKind());
				blocks = engine.evalWithResult(cmd, model.getSimulinkModelName(), type);
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
					break;
				}
				return (Collection<T>) list.stream().map(e -> (ISimulinkElement) e).collect(Collectors.toList());
			} else if (this.equals(Kind.STATEFLOW)) {
				return (Collection<T>) StateflowUtil.getAllOfStateflowTypeFromModel(model, engine, type);
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
