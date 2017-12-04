package org.eclipse.epsilon.emc.simulink.models;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEngineFilesEnum;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEnginePool;
import org.eclipse.epsilon.emc.simulink.introspection.java.SimulinkPropertyGetter;
import org.eclipse.epsilon.emc.simulink.introspection.java.SimulinkPropertySetter;
import org.eclipse.epsilon.emc.simulink.operations.contributors.SimulinkOperationContributor;
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

public class SimulinkModel extends CachedModel<SimulinkBlock> implements IOperationContributorProvider {
	
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
	private static final String CLOSE_SYSTEM = "close_system('?', 0)";

	private static final String DELETE_BLOCK = "handle = ?; delete_block(handle);";
	private static final String DELETE_LINE = "handle = ?; delete_line(handle);";
	private static final String DELETE_SF = "?.delete;";
	private static final String FIND_BLOCKS = "find_system('?', 'FindAll', 'on', 'BlockType', '?');";
	private static final String FIND_SYSTEM = "find_system(?, 'FindAll', 'on');";
	
	private static final String BLOCK = "Block";
	private static final String SIMULINK = "Simulink";
	private static final String STATEFLOW = "Stateflow";
	private static final String STATEFLOW_SIMULINK_BLOCK = "sflib/";
	private static final String STATEFLOW_SIMULINK_BLOCK_DEFAULT = STATEFLOW_SIMULINK_BLOCK + "Chart";
	
	/** FIELDS */
	
	protected File file = null;
	protected SimulinkPropertyGetter propertyGetter;
	protected SimulinkPropertySetter propertySetter;
	protected SimulinkOperationContributor simulinkOperationContributor;
	
	protected String libraryPath;
	protected String engineJarPath;
	protected MatlabEngine engine;
	
	protected boolean hiddenEditor = true;
	protected double handle = -1;
	
	/** Create Instances in Model */
	
	@Override
	protected SimulinkBlock createInstanceInModel(String type)
			throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {		
		if (type.contains("/")) {
			String blockPath = getSimulinkModelName() + "/" + SimulinkUtil.getSimpleTypeName(type);
			return new SimulinkBlock(this, engine, type, blockPath);
		} else if (type.startsWith(STATEFLOW + ".")) {
			return new StateflowBlock(this, engine, type, activeChart());
		} else {
			throw new EolModelElementTypeNotFoundException(type, null);
		}
	}
	
	@Override
	public Object createInstance(String type, Collection<Object> parameters)
			throws EolModelElementTypeNotFoundException, 	EolNotInstantiableModelElementTypeException {
		if (type.startsWith(STATEFLOW) && parameters.size() == 1) {
			Object parentObject = parameters.toArray()[0];
			if (parentObject instanceof SimulinkBlock) {
				return new StateflowBlock(this, engine, type, (SimulinkBlock) parentObject);
			} else {
				throw new EolModelElementTypeNotFoundException(type, null);	
			}
		} else {
			throw new EolModelElementTypeNotFoundException(type, null);
		}
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
	public boolean hasType(String type) {
		return true; // FIXME No validation?
	}
	
	@Override
	public String getTypeNameOf(Object instance) {
		if (instance instanceof SimulinkBlock) {
			return ((SimulinkBlock) instance).getType(); 
		}
		return instance.getClass().getSimpleName().replace(SIMULINK, "");
	}
	
	@Override
	protected Collection<String> getAllTypeNamesOf(Object instance) {
		List<String> result;
		if (instance instanceof SimulinkBlock) {
			result = Arrays.asList(BLOCK, ((SimulinkBlock)instance).getType());
			if (instance instanceof StateflowBlock) {
				result.add(STATEFLOW);
			} else {
				result.add(SIMULINK);
			}
			return result;
		} else 
			return Arrays.asList(getTypeNameOf(instance));
	}
	
	// Model / Active Charts
	
	protected List<Double> modelCharts;
	protected double activeChart = -1;
	
	public List<Double> getModelCharts() {
		if (modelCharts == null) {
			return Collections.emptyList();
		} else {
			return modelCharts;
		}
	}
	
	public SimulinkBlock activeChart() {
		SimulinkBlock active = null; 
		if (getModelCharts().isEmpty() && activeChart == -1){
			active = new SimulinkBlock(this, engine, STATEFLOW_SIMULINK_BLOCK_DEFAULT);
			addModelChart(active);
		} else {
			active = new SimulinkBlock(this, engine, activeChart, STATEFLOW_SIMULINK_BLOCK_DEFAULT);
		}
		return active;
	}
	
	public void addModelChart(SimulinkBlock block) {
		if (block != null) {
			if (modelCharts == null){
				modelCharts = new ArrayList<Double>();
			} 
			activeChart = block.getHandle();
			modelCharts.add(new Double(this.activeChart));
		}
	}
	
	public void setActiveChart(double chartHandle) {
		if (this.activeChart != chartHandle) {
			if (this.getModelCharts().contains(new Double(chartHandle))) {
				this.activeChart = chartHandle;
			} else {
				// addModelChart FIXME
			}
		}
	}
	
	
	// COLLECTORS
	
	@Override
	protected Collection<SimulinkBlock> allContentsFromModel() {
		Collection<SimulinkBlock> all = new ArrayList<SimulinkBlock>();
		try {
			all.addAll(getSimulinkBlocks(engine.evalWithResult(FIND_SYSTEM, this.handle), null));
			all.addAll(StateflowUtil.getAllStateflowBlocksFromModel(this, engine));
		} catch (Exception e) {}
		return all;
	}

	@Override
	protected Collection<SimulinkBlock> getAllOfTypeFromModel(String type)
			throws EolModelElementTypeNotFoundException {
		try {	
			if (type.startsWith(STATEFLOW)) {
				return StateflowUtil.getAllOfStateflowTypeFromModel(this, engine, type);
			} else {
				return getSimulinkBlocks(engine.evalWithResult(FIND_BLOCKS, getSimulinkModelName(), type), type);
			}
		} catch (Exception e) {
			try {
				MatlabEngineUtil.formatException(e);
				return null;
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new EolModelElementTypeNotFoundException(this.getName(), type);
			}
		}
	}

	@Override
	protected Collection<SimulinkBlock> getAllOfKindFromModel(String kind)
			throws EolModelElementTypeNotFoundException {
		if (BLOCK.equals(kind)) {
			return allContentsFromModel();
		} else if (STATEFLOW.equals(kind)) {
			return StateflowUtil.getAllStateflowBlocksFromModel(this, engine);
		} else if (SIMULINK.equals(kind)) {
			return null; //FIXME
		} else {
			return getAllOfTypeFromModel(kind);
		}
	}
	
	// HELPERS
	
	public List<StateflowBlock> getStateflowObjects(Object ids){
		return getStateflowObjects(ids, null);
	}
	
	public List<StateflowBlock> getStateflowObjects(Object ids, String type) {
		return null; // FIXME
	}
	
	
	public List<SimulinkBlock> getSimulinkBlocks(Object handles) {
		return getSimulinkBlocks(handles, null);
	}
	
	public List<SimulinkBlock> getSimulinkBlocks(Object handles, String type) {
		return SimulinkUtil.getTypeList(SimulinkBlock.class, this, engine, handles, type);
	}

	public List<SimulinkLine> getLines(Object handles) {
		return SimulinkUtil.getTypeList(SimulinkLine.class, this, engine, handles);
	}
	
	public List<SimulinkPort> getPorts(Object handles) {
		return SimulinkUtil.getTypeList(SimulinkPort.class, this, engine, handles);
	}
	
	@Override
	protected boolean deleteElementInModel(Object instance) throws EolRuntimeException {
		try {
			if (instance instanceof SimulinkLine) {
				engine.eval(DELETE_LINE, ((SimulinkModelElement) instance).getHandle());
			} else if (instance instanceof StateflowBlock){
				engine.eval(DELETE_SF, StateflowUtil.getBlockHandle((StateflowBlock) instance));
			} else {
				engine.eval(DELETE_BLOCK, ((SimulinkModelElement) instance).getHandle());
			}
			return true;
		} catch (Exception e) {
			throw new EolInternalException(e);
		}
	}
	
	/*************************/
	/** METHODS BELOW ARE OK */
	/*************************/
	
	public static void main(String[] args) throws Exception {
		SimulinkModel model = new SimulinkModel();
		model.setName("M");
		model.setFile(File.createTempFile("foo", ".slx"));
		model.setReadOnLoad(false);
		model.setStoredOnDisposal(false);
		model.setHiddenEditor(true);
		model.setEngineJarPath(MatlabEngineFilesEnum.ENGINE_JAR.path());
		model.setLibraryPath(MatlabEngineFilesEnum.LIBRARY_PATH.path());
		model.load();
		System.out.println(model.getAllOfType("Gain"));
	}
	
	public void load(StringProperties properties, IRelativePathResolver resolver)
			throws EolModelLoadingException {
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
	
	@Override
	protected void loadModel() throws EolModelLoadingException {
		try {
			engine = MatlabEnginePool.getInstance(libraryPath, engineJarPath).getMatlabEngine();
			simulinkOperationContributor = new SimulinkOperationContributor(engine);
			
			String modelToLoad = "";
			if (readOnLoad) {
				modelToLoad = file.getAbsolutePath();
			} else {
				try {
					engine.eval(NEW_SYSTEM, getSimulinkModelName());
				} catch (Exception ex) {} // Ignore; system already exists
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
		};
	}
	
	@Override
	public boolean owns(Object instance) {
		return (instance instanceof SimulinkModelElement) && 
			((SimulinkModelElement) instance).getOwningModel() == this;
	}

	@Override
	public boolean store(String location) {
		try {
			engine.eval(SAVE_SYSTEM, getSimulinkModelName(), location);
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override	
	public boolean store() {
		store(file.getAbsolutePath());
		return true;
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
	
	@Override
	public Object getElementById(String id) {
		return null;
	}
	
	@Override
	public void setElementId(Object instance, String newId) {	}
	
	@Override
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public boolean isInstantiable(String type) {
		return hasType(type);
	}
	
	@Override
	protected Object getCacheKeyForType(String type) throws EolModelElementTypeNotFoundException {
		return type;
	}
	
	public String getSimulinkModelName() {
		String name = file.getName();
		int pos = name.lastIndexOf(".");
		if (pos > 0) { name = name.substring(0, pos); }
		return name;
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
	
	public double getHandle() {
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

	public void simulate() throws InterruptedException {
        String name = getFile().getName().substring(0,getFile().getName().lastIndexOf("."));
        Future<Void> fSim = engine.evalAsync("simOut = sim('" + name + "', []);");
        while (!fSim.isDone()) {
            Thread.sleep(1000);
        }
	}
	
	public Object getArrayWorkspaceVariable(String variableName) {
		return MatlabEngineUtil.getArrayWorkspaceVariable(engine, variableName);
	}
	
	@Override
	protected void disposeModel() {
		engine.eval(CLOSE_SYSTEM, this.getSimulinkModelName());
		MatlabEnginePool.getInstance(libraryPath, engineJarPath).release(engine);
	}
	
}
