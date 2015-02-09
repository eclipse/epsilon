package org.eclipse.epsilon.workflow.tasks.emf;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.xml.XmlModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.workflow.tasks.EpsilonTask;
import org.eclipse.epsilon.workflow.tasks.ShutdownProjectRepositoryListener;

public class LoadXmlModelTask extends EpsilonTask {

	protected String name;
	protected String aliases;
	protected File modelFile;
	protected File xsdFile;
	protected boolean read = true;
	protected boolean store = false;
	protected boolean expand = false;
	protected boolean cached = true;
	
	@Override
	public void executeImpl() throws BuildException {
		ShutdownProjectRepositoryListener.activate(getProject(), getProjectRepository());
		
		final StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, name + "");
		properties.put(EmfModel.PROPERTY_ALIASES, aliases + "");
		properties.put(XmlModel.PROPERTY_MODEL_FILE, modelFile.getAbsolutePath());
		properties.put(XmlModel.PROPERTY_XSD_FILE, xsdFile.getAbsolutePath());
		properties.put(EmfModel.PROPERTY_READONLOAD, read + "");
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, store + "");
		properties.put(EmfModel.PROPERTY_EXPAND, expand + "");
		properties.put(EmfModel.PROPERTY_CACHED, cached + "");
		
		try {
			XmlModel model = new XmlModel();
			model.load(properties);
			getProjectRepository().addModel(model);
		}
		catch (EolModelLoadingException e) {
			throw new BuildException(e);
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAliases() {
		return aliases;
	}

	public void setAliases(String aliases) {
		this.aliases = aliases;
	}

	public File getModelFile() {
		return modelFile;
	}

	public void setModelFile(File modelFile) {
		this.modelFile = modelFile;
	}

	public File getXsdFile() {
		return xsdFile;
	}

	public void setXsdFile(File xsdFile) {
		this.xsdFile = xsdFile;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean isStore() {
		return store;
	}

	public void setStore(boolean store) {
		this.store = store;
	}

	public boolean isExpand() {
		return expand;
	}

	public void setExpand(boolean expand) {
		this.expand = expand;
	}
	
	public void setCached(boolean cached) {
		this.cached = cached;
	}
	
	public boolean isCached() {
		return cached;
	}
	
}
