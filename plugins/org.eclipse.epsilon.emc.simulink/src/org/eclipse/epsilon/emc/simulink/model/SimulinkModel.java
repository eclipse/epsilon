package org.eclipse.epsilon.emc.simulink.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEnginePool;
import org.eclipse.epsilon.emc.simulink.engine.MatlabException;
import org.eclipse.epsilon.emc.simulink.introspection.java.SimulinkPropertyGetter;
import org.eclipse.epsilon.emc.simulink.introspection.java.SimulinkPropertySetter;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.model.element.StateflowBlock;
import org.eclipse.epsilon.emc.simulink.operations.contributors.ModelOperationContributor;
import org.eclipse.epsilon.emc.simulink.util.MatlabEngineUtil;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
import org.eclipse.epsilon.emc.simulink.util.StateflowUtil;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.execute.operations.contributors.IOperationContributorProvider;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.models.CachedModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;

public class SimulinkModel extends CachedModel<ISimulinkModelElement> implements IOperationContributorProvider {

	/** CONSTANTS */
	public static final String PROPERTY_FILE = "file";
	public static final String PROPERTY_LIBRARY_PATH = "library_path";
	public static final String PROPERTY_ENGINE_JAR_PATH = "engine_jar_path";
	public static final String PROPERTY_HIDDEN_EDITOR = "hidden_editor";

	private static final String GET_PARAM = "get_param('?', 'Handle');";
	private static final String LOAD_SYSTEM = "load_system ";
	private static final String OPEN_SYSTEM = "open_system ";
	private static final String NEW_SYSTEM = "new_system('?', 'Model');";
	private static final String SAVE_SYSTEM = "save_system('?', '?');";

	public static final String BLOCK = "Block";
	public static final String SIMULINK = "Simulink";
	public static final String STATEFLOW = "Stateflow";
	public static final String CHART = "Chart";

	public static final String STATEFLOW_SIMULINK_BLOCK = "sflib/";
	public static final String STATEFLOW_SIMULINK_BLOCK_DEFAULT = STATEFLOW_SIMULINK_BLOCK + "Chart";

	/** FIELDS */

	protected File file = null;
	protected SimulinkPropertyGetter propertyGetter;
	protected SimulinkPropertySetter propertySetter;
	protected ModelOperationContributor simulinkOperationContributor;

	protected String libraryPath;
	protected String engineJarPath;
	protected MatlabEngine engine;

	protected boolean hiddenEditor = true;
	protected double handle = -1;

	@Override
	protected void loadModel() throws EolModelLoadingException { 
		try {
			engine = MatlabEnginePool.getInstance(libraryPath, engineJarPath).getMatlabEngine();
			simulinkOperationContributor = new ModelOperationContributor(engine);

			String modelToLoad = "";
			if (readOnLoad) {
				modelToLoad = file.getAbsolutePath();
			} else {
				try {
					engine.eval(NEW_SYSTEM, getSimulinkModelName());
				} catch (Exception ex) {
				} // Ignore; system already exists
				modelToLoad = getSimulinkModelName();
			}
			if (hiddenEditor) {
				engine.eval(LOAD_SYSTEM + modelToLoad);
			} else {
				engine.eval(OPEN_SYSTEM + modelToLoad);
			}

			this.handle = (Double) engine.evalWithResult(GET_PARAM, getSimulinkModelName());
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this);
		}
	}
	
	@Override
	protected void disposeModel() { 
		MatlabEnginePool.getInstance(libraryPath, engineJarPath).release(engine);
	}
	
	@Override
	protected ISimulinkModelElement createInstanceInModel(String type)
			throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException { 
		if (type.contains("/")) {
			return new SimulinkBlock(this, engine, type);
		} else if (type.startsWith(STATEFLOW + ".")) {
			try {
				return new StateflowBlock(this, engine, type);
			} catch (MatlabException e) {
				throw new EolNotInstantiableModelElementTypeException(getSimulinkModelName(), type);
			}
		} else {
			throw new EolModelElementTypeNotFoundException(type, null);
		}
	}
	
	@Override
	public Object createInstance(String type, Collection<Object> parameters) 
			throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException { 
		if (type.startsWith(STATEFLOW) && parameters.size() == 1) {
			Object parentObject = parameters.toArray()[0];
			try {
				if (parentObject instanceof StateflowBlock)
					try {
						return new StateflowBlock(this, engine, type, (StateflowBlock) parentObject);
					} catch (MatlabException e) {
						throw new EolModelElementTypeNotFoundException(type, null, e.getMessage());
					}
				else 
					throw new EolModelElementTypeNotFoundException(type, null, "invalid parameters");
			} catch (EolRuntimeException e) {
				throw new EolModelElementTypeNotFoundException(type, null, e.getMessage());
			}
		} 
		throw new EolModelElementTypeNotFoundException(type, null);
	}

	@Override
	protected boolean deleteElementInModel(Object instance) throws EolRuntimeException { 
		try {
			if (instance instanceof ISimulinkModelElement) 
				return ((ISimulinkModelElement) instance).deleteElementInModel();
			return false;
		} catch (Exception e) {
			throw new EolInternalException(e);
		}
	}
	
	@Override
	protected Object getCacheKeyForType(String type) throws EolModelElementTypeNotFoundException { 
		return type;
	}
	
	// COLLECTORS 

	@Override
	protected Collection<String> getAllTypeNamesOf(Object instance) { 
		if (instance instanceof ISimulinkModelElement) {
			return ((ISimulinkModelElement) instance).getAllTypeNamesOf();
		} else {
			return Arrays.asList(getTypeNameOf(instance));
		}
	}

	@Override 
	protected Collection<ISimulinkModelElement> allContentsFromModel() { 
		Collection<ISimulinkModelElement> all = new ArrayList<ISimulinkModelElement>();
		try {
			Collection<ISimulinkModelElement> allStateflowBlocksFromModel = StateflowUtil.getAllStateflowBlocksFromModel(this, engine);
			if (!allStateflowBlocksFromModel.isEmpty()) 
				all.addAll(allStateflowBlocksFromModel);
			List<ISimulinkModelElement> allSimulinkBlocksFromModel = SimulinkUtil.getAllSimulinkBlocksFromModel(this, engine);
			if (!allSimulinkBlocksFromModel.isEmpty()) 
				all.addAll(allSimulinkBlocksFromModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override // FIXME
	protected Collection<ISimulinkModelElement> getAllOfTypeFromModel(String type) 
			throws EolModelElementTypeNotFoundException { 
		try {
			Collection<ISimulinkModelElement> all = new ArrayList<ISimulinkModelElement>();
			if (type.startsWith(STATEFLOW)) {
				Collection<ISimulinkModelElement> allOfStateflowTypeFromModel = StateflowUtil.getAllOfStateflowTypeFromModel(this, engine, type);
				if (!allOfStateflowTypeFromModel.isEmpty()) 
					all.addAll(allOfStateflowTypeFromModel);
				
			} else {
				List<ISimulinkModelElement> allSimulinkBlocksFromModel = SimulinkUtil.getAllSimulinkBlocksFromModel(this, engine, type);
				if (!allSimulinkBlocksFromModel.isEmpty()) 
					all.addAll(allSimulinkBlocksFromModel);
			}
			return all;	
		} catch (Exception e) {
			throw new EolModelElementTypeNotFoundException(this.getName(), type);
		}
	}

	@Override
	protected Collection<ISimulinkModelElement> getAllOfKindFromModel(String kind)  
			throws EolModelElementTypeNotFoundException {
		try {
			if (BLOCK.equalsIgnoreCase(kind)) {
				return allContentsFromModel();
			} else if (STATEFLOW.equalsIgnoreCase(kind)) {
				return StateflowUtil.getAllStateflowBlocksFromModel(this, engine);
			} else if (SIMULINK.equalsIgnoreCase(kind)) {
				return SimulinkUtil.getAllSimulinkBlocksFromModel(this, engine);
			} else {
				return getAllOfTypeFromModel(kind);
			}
		} catch (Exception e) {
			throw new EolModelElementTypeNotFoundException(null, null);
		}
	}
	
	public static void main(String[] args) throws Exception {
		SimulinkModel model = new SimulinkModel();
		model.setName("M");
		model.setFile(File.createTempFile("foo", ".slx"));
		model.setReadOnLoad(false);
		model.setStoredOnDisposal(false);
		model.setHiddenEditor(true);
		//model.setEngineJarPath(MatlabEngineFilesEnum.ENGINE_JAR.path());
		//model.setLibraryPath(MatlabEngineFilesEnum.LIBRARY_PATH.path());
		model.load();
		System.out.println(model.getAllOfType("Gain"));
	}

	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException { 
		super.load(properties, resolver);

		String filePath = properties.getProperty(SimulinkModel.PROPERTY_FILE);
		if (properties.hasProperty(SimulinkModel.PROPERTY_LIBRARY_PATH))
			libraryPath = properties.getProperty(SimulinkModel.PROPERTY_LIBRARY_PATH);
		if (properties.hasProperty(SimulinkModel.PROPERTY_ENGINE_JAR_PATH))
			engineJarPath = properties.getProperty(SimulinkModel.PROPERTY_ENGINE_JAR_PATH);
		if (properties.hasProperty(SimulinkModel.PROPERTY_HIDDEN_EDITOR))
			hiddenEditor = new Boolean(properties.getProperty(SimulinkModel.PROPERTY_HIDDEN_EDITOR));
		if (filePath != null && filePath.trim().length() > 0)
			file = new File(resolver.resolve(filePath));

		load();
	}

	public void simulate() throws InterruptedException {
		String name = getFile().getName().substring(0, getFile().getName().lastIndexOf("."));
		Future<Void> fSim;
		try {
			fSim = engine.evalAsync("simOut = sim('" + name + "', []);");
			while (!fSim.isDone()) {
				Thread.sleep(1000);
			}
		} catch (MatlabException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean hasType(String type) {
		return true; // FIXME No validation?
	}
	
	@Override
	public String getTypeNameOf(Object instance) { 
		if (instance instanceof ISimulinkModelElement) {
			return ((ISimulinkModelElement) instance).getType();
		}
		return instance.getClass().getSimpleName().replace(SIMULINK, "");
	}
	
	@Override
	public Object getElementById(String id) { 
		return null;
	}

	@Override
	public void setElementId(Object instance, String newId) {	 
	}
	
	@Override
	public String getElementId(Object instance) { 
		try {
			return (String) propertyGetter.invoke(instance, "id");
		} catch (EolRuntimeException e) {
			return "";
		}
	}

	@Override
	public boolean owns(Object instance) { 
		return ((instance instanceof ISimulinkModelElement) 
				&& ((ISimulinkModelElement) instance).getOwningModel() == this ) 
				|| (instance instanceof SimulinkModel);
	}

	@Override
	public boolean store(String location) { 
		try {
			engine.eval(SAVE_SYSTEM, getSimulinkModelName(), location);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public boolean store() { 
		store(file.getAbsolutePath());
		return true;
	}

	@Override
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {  
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isInstantiable(String type) { 
		return hasType(type);
	}

	public String getSimulinkModelName() { 
		String name = file.getName();
		int pos = name.lastIndexOf(".");
		if (pos > 0) {
			name = name.substring(0, pos);
		}
		return name;
	}
	
	@Override
	public IPropertySetter getPropertySetter() { 
		if (propertySetter == null) {
			propertySetter = new SimulinkPropertySetter(engine);
		}
		return propertySetter;
	}

	@Override
	public IPropertyGetter getPropertyGetter() { 
		if (propertyGetter == null) {
			propertyGetter = new SimulinkPropertyGetter();
		}
		return propertyGetter;
	}

	@Override
	public OperationContributor getOperationContributor() { 
		return simulinkOperationContributor;
	}

	public File getFile() { 
		return file;
	}

	public void setFile(File file) { 
		this.file = file;
	}

	public MatlabEngine getEngine() { 
		return engine;
	}

	public Double getHandle() { 
		return handle;
	}

	public String getLibraryPath() { 
		return libraryPath;
	}

	public void setLibraryPath(String libraryPath) { 
		this.libraryPath = libraryPath;
	}

	public String getEngineJarPath() { 
		return engineJarPath;
	}

	public void setEngineJarPath(String engineJarPath) { 
		this.engineJarPath = engineJarPath;
	}

	public void setHiddenEditor(boolean hidden) { 
		this.hiddenEditor = hidden;
	}

	public Object parseMatlabEngineVariable(String variableName) throws MatlabException { 
		return MatlabEngineUtil.parseMatlabEngineVariable(engine, variableName);
	}
	
	public void statement(String statement) throws EolRuntimeException {
		try{
			engine.eval(statement);
		} catch (MatlabException e) {
			throw new EolRuntimeException(e.getMessage());
		}
	}
	
	public Object getWorkspaceVariable(String value) {
		try {
			return MatlabEngineUtil.parseMatlabEngineVariable(engine,value);
		} catch (MatlabException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Collection<ISimulinkModelElement> getChildren() {
		return findBlocks();
	}
	
	public Collection<ISimulinkModelElement> findBlocks(Integer depth){
		return SimulinkUtil.findBlocks(this, engine, depth);
	}
	
	public Collection<ISimulinkModelElement> findBlocks(){
		return findBlocks(1);
	}

}
