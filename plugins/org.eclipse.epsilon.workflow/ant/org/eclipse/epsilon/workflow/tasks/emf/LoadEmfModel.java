/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
******************************************************************************/

package org.eclipse.epsilon.workflow.tasks.emf;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.workflow.tasks.EpsilonTask;
import org.eclipse.epsilon.workflow.tasks.ShutdownProjectRepositoryListener;

//TODO: Finish this
public class LoadEmfModel extends EpsilonTask {

	protected String name;
	protected String alias;
	protected File modelFile;
	protected String modelUri;
	protected File metamodelFile;
	protected String metamodelUri;
	protected boolean read = true;
	protected boolean store = false;
	protected boolean expand = false;
	
	@Override
	public void executeImpl() throws BuildException {
		ShutdownProjectRepositoryListener.activate(getProject(), getProjectRepository());
		
		final EmfModel model = createEmfModel();
		
		final StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, name + "");
		properties.put(EmfModel.PROPERTY_ALIASES, alias + "");
		properties.put(EmfModel.PROPERTY_IS_METAMODEL_FILE_BASED, (metamodelUri == null) + "");
		properties.put(EmfModel.PROPERTY_READONLOAD, read + "");
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, store + "");
		properties.put(EmfModel.PROPERTY_EXPAND, expand + "");

		if (metamodelUri != null) {
			properties.put(EmfModel.PROPERTY_METAMODEL_URI, metamodelUri + "");
		}

		if (modelFile != null && modelUri != null) {
			throw new BuildException("Only one of modelFile or modelUri may be used");
		}
		else if (modelUri != null) {
			properties.put(EmfModel.PROPERTY_MODEL_URI, modelUri);
		}
		else {
			properties.put(EmfModel.PROPERTY_MODEL_URI, convertFileToUri(modelFile));
		}

		if (metamodelFile != null) {
			properties.put(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI, convertFileToUri(metamodelFile));
		}
		
		try {
			model.load(properties, null);
			getProjectRepository().addModel(model);
		} catch (EolModelLoadingException e) {
			e.printStackTrace();
			throw new BuildException(e);
		}
	}

	private URI convertFileToUri(File file) {
		return file == null ? null : URI.createFileURI(file.getAbsolutePath());
	}

	// This logic has been extracted so that it can be stubbed out in tests
	protected EmfModel createEmfModel() {
		return new EmfModel();
	}
	
	public boolean isExpand() {
		return expand;
	}

	public void setExpand(boolean expand) {
		this.expand = expand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		System.out.println("[WARNING] Attribute 'alias' is deprecated. Please use 'aliases' instead.");
		this.alias = alias;
	}

	public void setAliases(String aliases) {
		this.alias = aliases;
	}
	
	public String getAliases() {
		return this.alias;
	}
	
	public File getModelFile() {
		return modelFile;
	}

	public void setModelFile(File modelFile) {
		this.modelFile = modelFile;
	}

	public String getModelUri() {
		return modelUri;
	}

	public void setModelUri(String modelUri) {
		this.modelUri = modelUri;
	}

	public File getMetamodelFile() {
		return metamodelFile;
	}

	public void setMetamodelFile(File metamodelFile) {
		this.metamodelFile = metamodelFile;
	}

	public String getMetamodelUri() {
		return metamodelUri;
	}

	public void setMetamodelUri(String metamodelUri) {
		this.metamodelUri = metamodelUri;
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
	
}
 