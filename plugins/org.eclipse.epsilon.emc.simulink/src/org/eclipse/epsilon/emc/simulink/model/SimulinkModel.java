package org.eclipse.epsilon.emc.simulink.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

import org.eclipse.epsilon.common.util.Multimap;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.engine.MatlabEnginePool;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.exception.MatlabRuntimeException;
import org.eclipse.epsilon.emc.simulink.introspection.java.SimulinkPropertyGetter;
import org.eclipse.epsilon.emc.simulink.introspection.java.SimulinkPropertySetter;
import org.eclipse.epsilon.emc.simulink.model.TypeHelper.Kind;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.model.element.StateflowBlock;
import org.eclipse.epsilon.emc.simulink.operations.contributors.ModelOperationContributor;
import org.eclipse.epsilon.emc.simulink.util.MatlabEngineUtil;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
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
	public static final String PROPERTY_SHOW_IN_MATLAB_EDITOR = "hidden_editor";
	public static final String PROPERTY_FOLLOW_LINKS = "follow_links";
	public static final String PROPERTY_WORKING_DIR = "working_dir";

	public static final String BLOCK = "Block";
	public static final String SIMULINK = "Simulink";
	public static final String STATEFLOW = "Stateflow";

	public static final String PWD = "cd ?;";
	public static final String GET_PARAM = "get_param('?', 'Handle');";
	public static final String LOAD_SYSTEM = "load_system ?";
	public static final String OPEN_SYSTEM = "open_system ?";
	public static final String NEW_SYSTEM = "new_system('?', 'Model');";
	public static final String SAVE_SYSTEM = "save_system('?', '?');";

	//
	private static final Multimap<String, String> createBlockMap = new Multimap<String, String>();
	//
	private static final ArrayList<ArrayList<String>> deleteBlockMap = new ArrayList<ArrayList<String>>();
	
	static {
		createBlockMap.put("sflib/Chart", "Stateflow.Chart");
		ArrayList<String> chart = new ArrayList<String>();
		chart.add("SubSystem");
		chart.add("Stateflow.Chart");
		deleteBlockMap.add(chart);
	}

	/** FIELDS */

	protected File file = null;
	protected SimulinkPropertyGetter propertyGetter;
	protected SimulinkPropertySetter propertySetter;
	protected ModelOperationContributor simulinkOperationContributor;

	protected File workingDir = null;
	protected String libraryPath;
	protected String engineJarPath;
	protected MatlabEngine engine;

	protected boolean showInMatlabEditor = false;
	protected boolean followLinks = true;
	protected double handle = -1;

	@Override
	protected void loadModel() throws EolModelLoadingException { 
		try {
			engine = MatlabEnginePool.getInstance(libraryPath, engineJarPath).getMatlabEngine();
			simulinkOperationContributor = new ModelOperationContributor(engine);
				
			try {
				String pwd = (workingDir != null) ? workingDir.getAbsolutePath() : file.getParentFile().getAbsolutePath();
				if (pwd != null) {
					//System.out.println("Setting working directory to " + pwd);
					engine.eval(PWD, pwd);
				}
			} catch (Exception ex) {
				// couldn't set the the working directory
			}
			if (!readOnLoad) {
				try {
					engine.eval(NEW_SYSTEM, getSimulinkModelName());
				} catch (Exception ex) {
					 // Ignore; system already exists	
				}
			}
			String cmd = showInMatlabEditor ? OPEN_SYSTEM : LOAD_SYSTEM;
			engine.eval(cmd, getSimulinkModelName());
			this.handle = (Double) engine.evalWithResult(GET_PARAM, getSimulinkModelName());
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this);
		}
	}
	
	@Override
	protected void disposeModel() { 
		try {
			MatlabEnginePool.getInstance(libraryPath, engineJarPath).release(engine);
		} catch (MatlabRuntimeException e) {
			
		}
	}

	@Override
	protected ISimulinkModelElement createInstanceInModel(String type)
			throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException { 
		if (type.contains("/")) {
			try {
				return new SimulinkBlock(this, engine, type);
			} catch (MatlabRuntimeException e) {
				throw new EolNotInstantiableModelElementTypeException(getSimulinkModelName(), type);
			}
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
	protected void addToCache(String type, ISimulinkModelElement instance) throws EolModelElementTypeNotFoundException {
		for (String kind : getAllTypeNamesOf(instance)) {
			Object kindCacheKey = getCacheKeyForType(kind);
			if (cachedKinds.contains(kindCacheKey)) {
				kindCache.put(kindCacheKey, instance);
			}
		}
	}

	@Override
	protected void removeFromCache(ISimulinkModelElement instance) throws EolModelElementTypeNotFoundException {
		for (String kind : getAllTypeNamesOf(instance)) {
			final Object kindCacheKey = getCacheKeyForType(kind);
			if (cachedKinds.contains(kindCacheKey)) {
				kindCache.remove(kindCacheKey, instance);
			}
		}
	}
		
	@Override
	public void deleteElement(Object o) throws EolRuntimeException {
		deleteElementInModel(o);
		if (isCachingEnabled()) {
			if (o instanceof ISimulinkModelElement) {
				removeFromCache((ISimulinkModelElement) o);
				String type = ((ISimulinkModelElement) o).getType();
				for (List<String> specialType : deleteBlockMap) {
					if (specialType.contains(type)) {
						for (String equivalent : specialType) {
							if (!equivalent.equals(type) && cachedKinds.contains(equivalent)) {
								kindCache.get(equivalent).clear();
								kindCache.putAll(equivalent, getAllOfTypeFromModel(equivalent)); // refresh for type
							}
						}
					}
				}
			}
		}
	}

	@Override
	public ISimulinkModelElement createInstance(String type)
			throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		ISimulinkModelElement instance = createInstanceInModel(type);
		if (isCachingEnabled()) {
			addToCache(instance.getType(), instance);
			if (createBlockMap.containsKey(type)){
				for (String equivalent : createBlockMap.get(type)){
					if (cachedKinds.contains(equivalent)) {
						kindCache.get(equivalent).clear();
						kindCache.putAll(equivalent, getAllOfTypeFromModel(equivalent)); // refresh for type
					}
					
				}
			}
		}
		return instance;
	}
	
	@Override
	public Object createInstance(String type, Collection<Object> parameters) 
			throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException { 
		if (type.startsWith(STATEFLOW) && parameters.size() == 1) {
			Object parentObject = parameters.toArray()[0];
			try {
				if (parentObject instanceof StateflowBlock) {
					try {
						StateflowBlock instance = new StateflowBlock(this, engine, type, (StateflowBlock) parentObject);
						if (isCachingEnabled()) {
							addToCache(instance.getType(), instance);
							if (createBlockMap.containsKey(type)){
								for (String equivalent : createBlockMap.get(type)){
									if (cachedKinds.contains(equivalent)) {
										kindCache.get(equivalent).clear();
										kindCache.putAll(equivalent, getAllOfTypeFromModel(equivalent)); // refresh for type
									}
									
								}
							}
						}
						return instance; 
					} catch (MatlabException e) {
						throw new EolModelElementTypeNotFoundException(type, null, e.getMessage());
					}
				} else { 
					throw new EolModelElementTypeNotFoundException(type, null, "invalid parameters");
				}
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
		return TypeHelper.getAll(engine, this);
	}
	
	@Override // FIXME
	protected Collection<ISimulinkModelElement> getAllOfTypeFromModel(String type) 
			throws EolModelElementTypeNotFoundException { 
		return TypeHelper.getAllOfType(this, engine, type);		
	}

	@Override
	protected Collection<ISimulinkModelElement> getAllOfKindFromModel(String kind)  
			throws EolModelElementTypeNotFoundException {
		try {
			try {
				return Kind.get(kind).getAll(engine, this);
			} catch (Exception e) {
				return getAllOfTypeFromModel(kind);
			}
		} catch (Exception e) {
			throw new EolModelElementTypeNotFoundException(null, null);
		}
	}
	
	public static void main(String[] args) throws Exception {
		File tmpFile = File.createTempFile("foo", ".slx");
		
		SimulinkModel model = new SimulinkModel();
		model.setName("M");
		model.setFile(tmpFile);
		model.setWorkingDir(tmpFile.getParentFile());
		model.setReadOnLoad(false);
		model.setStoredOnDisposal(false);
		model.setShowInMatlabEditor(true);
		model.setFollowLinks(false);
		//model.setEngineJarPath(MatlabEngineFilesEnum.ENGINE_JAR.path());
		//model.setLibraryPath(MatlabEngineFilesEnum.LIBRARY_PATH.path());
		model.load();
		System.out.println(model.getAllOfType("Gain"));
	}

	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException { 
		super.load(properties, resolver);

		String filePath = properties.getProperty(SimulinkModel.PROPERTY_FILE);
		String workingDirPath = properties.getProperty(SimulinkModel.PROPERTY_WORKING_DIR);
		if (properties.hasProperty(SimulinkModel.PROPERTY_LIBRARY_PATH))
			libraryPath = properties.getProperty(SimulinkModel.PROPERTY_LIBRARY_PATH);
		if (properties.hasProperty(SimulinkModel.PROPERTY_ENGINE_JAR_PATH))
			engineJarPath = properties.getProperty(SimulinkModel.PROPERTY_ENGINE_JAR_PATH);
		if (properties.hasProperty(SimulinkModel.PROPERTY_SHOW_IN_MATLAB_EDITOR))
			showInMatlabEditor = properties.getBooleanProperty(SimulinkModel.PROPERTY_SHOW_IN_MATLAB_EDITOR, false);
		if (properties.hasProperty(SimulinkModel.PROPERTY_FOLLOW_LINKS))
			followLinks = properties.getBooleanProperty(SimulinkModel.PROPERTY_FOLLOW_LINKS, true);
		if (filePath != null && filePath.trim().length() > 0)
			file = new File(resolver.resolve(filePath));
		if (workingDirPath != null && workingDirPath.trim().length() > 0) {
			workingDir = new File(resolver.resolve(filePath));
		} else {
			workingDir = file.getParentFile();			
		}			

		load();
	}

	public void simulate() throws InterruptedException {
		String name = getFile().getName().substring(0, getFile().getName().lastIndexOf("."));
		Future<Void> fSim;
		try {
			fSim = engine.evalAsync("simout = sim('" + name + "', []);");
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
		if (instance == null) {
			return false;
		}
		return ((instance instanceof ISimulinkModelElement) 
				&& ((ISimulinkModelElement) instance).getOwningModel() == this ) 
				|| (instance instanceof SimulinkModel)
				|| (instance.getClass().getCanonicalName().startsWith("org.eclipse.epsilon.emc.simulink.types"));
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

	public boolean isShowInMatlabEditor() {
		return showInMatlabEditor;
	}
	
	public File getWorkingDir() {
		return workingDir;
	}

	public void setWorkingDir(File workingDir) {
		this.workingDir = workingDir;
	}
	
	/**
	 * If true, the model will be shown in the MATLAB Editor. 
	 * If the model is already loaded, it will not open it again. 
	 * If false, the model will not be open in the MATLAB editor, 
	 * but won't close an already open model
	 */
	public void setShowInMatlabEditor(boolean openMatlabEditor) { 
		this.showInMatlabEditor = openMatlabEditor;
	}

	public boolean isFollowLinks() {
		return followLinks;
	}

	/**
	 * If true, adds the 'Follow_Link' parameter to the 'find_system' method in MATLAB 
	 */
	public void setFollowLinks(boolean followLinks) {
		this.followLinks = followLinks;
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
	
	public Collection<ISimulinkModelElement> getChildren() throws MatlabException {
		return SimulinkUtil.findBlocks(this, engine, 1);
	}
	
	public Collection<ISimulinkModelElement> findBlocks(Integer depth) throws MatlabException{
		return SimulinkUtil.findBlocks(this, engine, depth);
	}
	
	public Collection<ISimulinkModelElement> findBlocks() throws MatlabException{
		return findBlocks(1);
	}

}
