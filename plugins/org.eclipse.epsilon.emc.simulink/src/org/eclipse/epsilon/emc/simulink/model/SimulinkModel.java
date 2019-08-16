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

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.common.util.Multimap;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.emc.simulink.exception.MatlabException;
import org.eclipse.epsilon.emc.simulink.exception.MatlabRuntimeException;
import org.eclipse.epsilon.emc.simulink.model.AbstractSimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.TypeHelper.Kind;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.model.element.StateflowBlock;
import org.eclipse.epsilon.emc.simulink.operations.contributors.ModelOperationContributor;
import org.eclipse.epsilon.emc.simulink.util.SimulinkUtil;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.operations.contributors.IOperationContributorProvider;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimulinkModel extends AbstractSimulinkModel implements IOperationContributorProvider {

	/** CONSTANTS */
	public static final String PROPERTY_PATHS = "paths";
	public static final String PROPERTY_SHOW_IN_MATLAB_EDITOR = "hidden_editor";
	public static final String PROPERTY_FOLLOW_LINKS = "follow_links";
	public static final String PROPERTY_WORKING_DIR = "working_dir";

	public static final String BLOCK = "Block";
	public static final String SIMULINK = "Simulink";
	public static final String STATEFLOW = "Stateflow";

	public static final String PWD = "cd '?';";
	public static final String GET_PARAM = "get_param('?', 'Handle');";
	public static final String LOAD_SYSTEM = "load_system('?')";
	public static final String OPEN_SYSTEM = "open_system('?')";
	public static final String NEW_SYSTEM = "new_system('?', 'Model');";
	public static final String SAVE_SYSTEM = "save_system('?', '?');";

	private static final Logger LOGGER = LoggerFactory.getLogger(SimulinkModel.class);
	
	//
	private static final Multimap<String, String> createBlockMap = new Multimap<>();
	//
	private static final ArrayList<ArrayList<String>> deleteBlockMap = new ArrayList<>();
	
	static {
		createBlockMap.put("sflib/Chart", "Stateflow.Chart");
		ArrayList<String> chart = new ArrayList<>();
		chart.add("SubSystem");
		chart.add("Stateflow.Chart");
		deleteBlockMap.add(chart);
	}

	/** FIELDS */

	protected ModelOperationContributor simulinkOperationContributor;

	protected File workingDir = null;
	
	protected boolean showInMatlabEditor = false;
	protected boolean followLinks = true;
	protected double handle = -1;

	@Override
	protected void loadModel() throws EolModelLoadingException { 
		super.loadModel();
		
		try {
			simulinkOperationContributor = new ModelOperationContributor(engine);
				
			if ((workingDir != null && workingDir.exists())) {
				try {
					engine.eval(PWD, workingDir);
				} catch (Exception ex) {
					LOGGER.info(ex.getMessage());
				}
			}
			
			if (readOnLoad) {
				String cmd = showInMatlabEditor ? OPEN_SYSTEM : LOAD_SYSTEM;
				try {
					engine.eval(cmd, file.getAbsolutePath());				
				} catch (Exception e) {
					try {
						engine.eval(NEW_SYSTEM, getSimulinkModelName());
					} catch (Exception ex) {
						// Ignore; system already exists
					}
				}
			} else {
				try {
					engine.eval(NEW_SYSTEM, getSimulinkModelName());
				} catch (Exception ex) {
					// Ignore; system already exists
				}
			}
			for (String path : paths) {
				engine.eval("addpath ?", path);
			}
			
			this.handle = (Double) engine.evalWithResult(GET_PARAM, getSimulinkModelName());
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this);
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
			return super.createInstanceInModel(type);
		}
	}
	
	@Override
	protected void addToCache(String type, ISimulinkModelElement instance) throws EolModelElementTypeNotFoundException {
		for (String kind : getAllTypeNamesOf(instance)) {
			Object kindCacheKey = getCacheKeyForType(kind);
			kindCache.putIfPresent(kindCacheKey, instance);
		}
	}

	@Override
	protected void removeFromCache(ISimulinkModelElement instance) throws EolModelElementTypeNotFoundException {
		for (String kind : getAllTypeNamesOf(instance)) {
			final Object kindCacheKey = getCacheKeyForType(kind);
			kindCache.remove(kindCacheKey, instance);
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
							if (!equivalent.equals(type)) {
								kindCache.replaceValues(equivalent, getAllOfTypeFromModel(equivalent)); // refresh for type
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
					kindCache.replaceValues(equivalent, getAllOfTypeFromModel(equivalent)); // refresh for type
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
									kindCache.replaceValues(equivalent, getAllOfTypeFromModel(equivalent)); // refresh for type
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
	
	
	// COLLECTORS 

	@Override 
	protected Collection<ISimulinkModelElement> allContentsFromModel() { 
		return TypeHelper.getAll(this);
	}
	
	@Override
	protected Collection<ISimulinkModelElement> getAllOfTypeFromModel(String type) 
			throws EolModelElementTypeNotFoundException { 
		return TypeHelper.getAllOfType(this, type);		
	}

	@Override
	protected Collection<ISimulinkModelElement> getAllOfKindFromModel(String kind_)  
			throws EolModelElementTypeNotFoundException {
		try {
			return Kind.get(kind_).getAll(this);
		} catch (Exception e) {
			return getAllOfTypeFromModel(kind_);
		}
	}
	
	public static void main(String[] args) throws Exception {
		File tmpFile = File.createTempFile("foo", ".slx");
		
		SimulinkModel model = new SimulinkModel();
		model.setName("M");
		model.setFile(tmpFile);
		model.setWorkingDir(null);
		model.setReadOnLoad(false);
		model.setStoredOnDisposal(false);
		model.setShowInMatlabEditor(true);
		model.setFollowLinks(false);
		model.setLibraryPath("/Applications/MATLAB_R2018b.app/bin/maci64/");
		model.setEngineJarPath("/Applications/MATLAB_R2018b.app/extern/engines/java/jar/engine.jar");
		//model.addPath("");
	
		model.load();
		
		System.out.println(model.getAllOfType("Gain"));
	}

	@Override
	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException { 
		super.load(properties, resolver);
		
		String workingDirPath = properties.getProperty(SimulinkModel.PROPERTY_WORKING_DIR);
		if (properties.hasProperty(SimulinkModel.PROPERTY_SHOW_IN_MATLAB_EDITOR))
			showInMatlabEditor = properties.getBooleanProperty(SimulinkModel.PROPERTY_SHOW_IN_MATLAB_EDITOR, false);
		if (properties.hasProperty(SimulinkModel.PROPERTY_FOLLOW_LINKS))
			followLinks = properties.getBooleanProperty(SimulinkModel.PROPERTY_FOLLOW_LINKS, true);
		String filePath = properties.getProperty(PROPERTY_FILE);
		if (!StringUtil.isEmpty(workingDirPath)) {
			workingDir = new File(resolver.resolve(filePath));
		}
		String paths = properties.getProperty(SimulinkModel.PROPERTY_PATHS);
		if (!StringUtil.isEmpty(paths)) {
			Arrays.stream(paths.trim().split(";")).forEach(this::addPath);
		}

		load();
	}

	public void simulate() throws InterruptedException {
		String name = getFile().getName().substring(0, getFile().getName().lastIndexOf("."));
		try {
			engine.evalAsync("simout = sim('" + name + "', []);").get();
		} catch (MatlabException | ExecutionException e) {
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
				|| (instance instanceof SimulinkModel) || super.owns(instance);
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
	public boolean isInstantiable(String type) { 
		return hasType(type) || super.isInstantiable(type);
	}

	public String getSimulinkModelName() {
		return FileUtil.getFileName(file.getName(), false);
	}

	@Override
	public OperationContributor getOperationContributor() { 
		return simulinkOperationContributor;
	}

	
	public Double getHandle() { 
		return handle;
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
	
	private List<String> paths = new ArrayList<>();
	
	public void addPath(String path) {
		paths.add(path);
	}
	public void addPath(File path) {
		paths.add(path.getAbsolutePath());
	}

	public List<String> getPaths(File workingDir) {
		return paths;
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
	
	public Collection<ISimulinkModelElement> getChildren() throws MatlabException {
		return SimulinkUtil.findBlocks(this,1);
	}
	
	public Collection<ISimulinkModelElement> findBlocks() throws MatlabException{
		return SimulinkUtil.findBlocks(this,1);
	}
	
	public Collection<ISimulinkModelElement> findBlocks(Integer depth) throws MatlabException {
		return SimulinkUtil.findBlocks(this,depth);
	}
	
}
