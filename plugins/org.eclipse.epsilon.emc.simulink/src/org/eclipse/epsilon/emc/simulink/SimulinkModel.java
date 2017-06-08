package org.eclipse.epsilon.emc.simulink;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.CachedModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;

public class SimulinkModel extends CachedModel<SimulinkBlock> {
	
	protected File file = null;
	protected MatlabEngine engine;
	protected SimulinkPropertyGetter propertyGetter;
	protected SimulinkPropertySetter propertySetter;
	protected String libraryPath;
	protected String engineJarPath;
	protected double handle = -1;
	
	public static String PROPERTY_FILE = "file";
	public static String PROPERTY_LIBRARY_PATH = "library_path";
	public static String PROPERTY_ENGINE_JAR_PATH = "engine_jar_path";
	
	public static void main(String[] args) throws Exception {
		SimulinkModel model = new SimulinkModel();
		model.setName("M");
		model.setFile(File.createTempFile("foo", ".slx"));
		model.setReadOnLoad(false);
		model.setStoredOnDisposal(false);
		model.setEngineJarPath("/Applications/MATLAB_R2017a.app/extern/engines/java/jar/engine.jar");
		model.setLibraryPath("/Applications/MATLAB_R2017a.app/bin/maci64");
		model.load();
		System.out.println(model.getAllOfType("Gain"));
	}
	
	public void load(StringProperties properties, IRelativePathResolver resolver)
			throws EolModelLoadingException {
		
		super.load(properties, resolver);
		
		String filePath = properties.getProperty(SimulinkModel.PROPERTY_FILE);
		if (properties.hasProperty(SimulinkModel.PROPERTY_LIBRARY_PATH)) libraryPath = properties.getProperty(SimulinkModel.PROPERTY_LIBRARY_PATH);
		if (properties.hasProperty(SimulinkModel.PROPERTY_ENGINE_JAR_PATH)) engineJarPath = properties.getProperty(SimulinkModel.PROPERTY_ENGINE_JAR_PATH);
		
		if (filePath != null && filePath.trim().length() > 0) {
			file = new File(resolver.resolve(filePath));
		}
		
		load();
	}
	
	@Override
	protected SimulinkBlock createInstanceInModel(String type)
			throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		
		return new SimulinkBlock(this, getSimulinkModelName() + "/" + getSimpleTypeName(type), type, engine);
	}
	
	protected String getSimpleTypeName(String type) {
		if (type.indexOf("/") > -1) {
			String[] parts = type.split("/");
			return parts[parts.length-1];
		}
		else {
			return type;
		}
	}
	
	@Override
	protected void loadModel() throws EolModelLoadingException {
		try {
			engine = MatlabEnginePool.getInstance(libraryPath, engineJarPath).getMatlabEngine();
			if (readOnLoad) {
				// TODO: Add a flag for using the invisible load_system instead
				engine.eval("open_system " + file.getAbsolutePath());
			}
			else {
				try {
					engine.eval("new_system('?', 'Model')", getSimulinkModelName());
				}
				catch (Exception ex) {
					// Ignore; system already exists
				}
				engine.eval("open_system " + getSimulinkModelName());
			}
			
			this.handle = (Double) engine.evalWithResult("get_param('?', 'Handle')", getSimulinkModelName());
			
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this);
		};
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	@Override
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getTypeNameOf(Object instance) {
		return ((SimulinkBlock) instance).getType();
	}

	@Override
	public Object getElementById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getElementId(Object instance) {
		return ((SimulinkBlock) instance).getHandle() + "";
	}

	@Override
	public void setElementId(Object instance, String newId) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean owns(Object instance) {
		return instance instanceof SimulinkElement && 
			((SimulinkElement) instance).getOwningModel() == this;
	}

	@Override
	public boolean isInstantiable(String type) {
		return hasType(type);
	}

	@Override
	public boolean hasType(String type) {
		return true;
	}

	@Override
	public boolean store(String location) {
		try {
			engine.eval("save_system ('?', '?')", getSimulinkModelName(), location);
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
	protected Collection<SimulinkBlock> allContentsFromModel() {
		try {
			return getBlocks(engine.evalWithResult("find_system(?, 'FindAll', 'on')", this.handle), null);
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}

	@Override
	protected Collection<SimulinkBlock> getAllOfTypeFromModel(String type)
			throws EolModelElementTypeNotFoundException {
		try {
			return getBlocks(engine.evalWithResult("find_system('?', 'FindAll', 'on', 'BlockType', '?')", getSimulinkModelName(), type), type);
		} catch (Exception e) {
			throw new EolModelElementTypeNotFoundException(this.getName(), type);
		}
	}

	@Override
	protected Collection<SimulinkBlock> getAllOfKindFromModel(String kind)
			throws EolModelElementTypeNotFoundException {
		if ("Block".equals(kind)) {
			return allContentsFromModel();
		}
		else return getAllOfTypeFromModel(kind);
	}
	
	protected List<SimulinkBlock> getBlocks(Object handles) {
		return getBlocks(handles, null);
	}
	
	public List<SimulinkBlock> getBlocks(Object handles, String type) {
		if (handles instanceof Double) {
			handles = new Double[]{(Double) handles};
		}
		
		List<SimulinkBlock> elements = new ArrayList<SimulinkBlock>();
		
		if (handles instanceof Double[]) {
			for (Double handle : (Double[]) handles) {
				elements.add(new SimulinkBlock(this, handle, type, engine));
			}
		}
		else if (handles instanceof double[]) {
			for (double handle : (double[]) handles) {
				elements.add(new SimulinkBlock(this, handle, type, engine));
			}
		}
		
		return elements;
	}

	public List<SimulinkLine> getLines(Object handles) {
		if (handles instanceof Double) {
			handles = new Double[]{(Double) handles};
		}
		
		List<SimulinkLine> lines = new ArrayList<SimulinkLine>();
		
		if (handles instanceof Double[]) {
			for (Double handle : (Double[]) handles) {
				lines.add(new SimulinkLine(this, handle, engine));
			}
		}
		else if (handles instanceof double[]) {
			for (double handle : (double[]) handles) {
				lines.add(new SimulinkLine(this, handle, engine));
			}
		}
		
		return lines;
	}
	
	public List<SimulinkPort> getPorts(Object handles) {
		if (handles instanceof Double) {
			handles = new Double[]{(Double) handles};
		}
		
		List<SimulinkPort> ports = new ArrayList<SimulinkPort>();
		
		if (handles instanceof Double[]) {
			for (Double handle : (Double[]) handles) {
				ports.add(new SimulinkPort(this, handle, engine));
			}
		}
		else if (handles instanceof double[]) {
			for (double handle : (double[]) handles) {
				ports.add(new SimulinkPort(this, handle, engine));
			}
		}
		
		return ports;
	}
	
	@Override
	protected void disposeModel() {
		MatlabEnginePool.getInstance(libraryPath, engineJarPath).release(engine);
	}

	@Override
	protected boolean deleteElementInModel(Object instance) throws EolRuntimeException {
		try {
			engine.eval("handle = ? \n delete_block (handle)", ((SimulinkElement) instance).getHandle());
			return true;
		} catch (Exception e) {
			throw new EolInternalException(e);
		}
	}

	@Override
	protected Object getCacheKeyForType(String type) throws EolModelElementTypeNotFoundException {
		return type;
	}

	@Override
	protected Collection<String> getAllTypeNamesOf(Object instance) {
		return Arrays.asList("Block", ((SimulinkBlock)instance).getType());
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
	
	public MatlabEngine getEngine() {
		return engine;
	}
	
	public String getSimulinkModelName() {
		String name = file.getName();
		int pos = name.lastIndexOf(".");
		if (pos > 0) { name = name.substring(0, pos); }
		return name;
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
	
	
	
}