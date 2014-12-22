/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
******************************************************************************/

package org.eclipse.epsilon.workflow.tasks.csv;


import java.io.File;

import org.apache.tools.ant.BuildException;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.csv.CsvModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.epsilon.workflow.tasks.EpsilonTask;
import org.eclipse.epsilon.workflow.tasks.ShutdownProjectRepositoryListener;

/**
 * The Class LoadEmfModelTask.
 */
public class LoadCsvModelTask extends EpsilonTask {
	
	/** The name. */
	protected String name;
	
	/** The field separator. */
	protected String fieldSeparator = ",";
	
	/** The has known headers. */
	protected boolean knownHeaders;
	
	/** The has varargs headers. */
	protected boolean varargsHeaders;
	
	/** The file. */
	protected File file;

	/** The alias. */
	protected String alias;

	/** The cached. */
	protected boolean cached = true;

	/** The read on load. */
	protected boolean read = true;

	/** The store on disposal. */
	protected boolean store = false;

	

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.workflow.tasks.EpsilonTask#executeImpl()
	 */
	@Override
	public void executeImpl() throws BuildException {
		ShutdownProjectRepositoryListener.activate(getProject(), getProjectRepository());
		
		final CsvModel model = createCsvModel();

		
		final StringProperties properties = new StringProperties();
		properties.put(CsvModel.PROPERTY_NAME, name + "");
		properties.put(CsvModel.PROPERTY_ALIASES, alias + "");
		properties.put(CsvModel.PROPERTY_CACHED, String.valueOf(cached));
		properties.put(CsvModel.PROPERTY_READONLOAD, String.valueOf(read));
		properties.put(CsvModel.PROPERTY_STOREONDISPOSAL, String.valueOf(store));
		properties.put(CsvModel.PROPERTY_FIELD_SEPARATOR, fieldSeparator);
		properties.put(CsvModel.PROPERTY_HAS_KNOWN_HEADERS, String.valueOf(knownHeaders));
		properties.put(CsvModel.PROPERTY_HAS_VARARGS_HEADERS, String.valueOf(varargsHeaders));
		
		if (file != null) {
			properties.put(CsvModel.PROPERTY_FILE, file.getAbsolutePath());
		}
		
		try {
			model.load(properties);
			getProjectRepository().addModel(model);
		} catch (EolModelLoadingException e) {
			throw new BuildException(e);
		}
		
	}

	/**
	 * Creates the csv model. This logic has been extracted so that it can be
	 * stubbed out in tests
	 *
	 * @return the csv model
	 */
	protected CsvModel createCsvModel() {
		return new CsvModel();
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the field separator.
	 *
	 * @return the fieldSeparator
	 */
	public String getFieldSeparator() {
		return fieldSeparator;
	}

	/**
	 * Sets the field separator.
	 *
	 * @param fieldSeparator the fieldSeparator to set
	 */
	public void setFieldSeparator(String fieldSeparator) {
		this.fieldSeparator = fieldSeparator;
	}

	/**
	 * Checks if is known headers.
	 *
	 * @return the knownHeaders
	 */
	public boolean isKnownHeaders() {
		return knownHeaders;
	}

	/**
	 * Sets the known headers.
	 *
	 * @param knownHeaders the knownHeaders to set
	 */
	public void setKnownHeaders(boolean knownHeaders) {
		this.knownHeaders = knownHeaders;
	}

	/**
	 * Checks if is varargs headers.
	 *
	 * @return the varargsHeaders
	 */
	public boolean isVarargsHeaders() {
		return varargsHeaders;
	}

	/**
	 * Sets the varargs headers.
	 *
	 * @param varargsHeaders the varargsHeaders to set
	 */
	public void setVarargsHeaders(boolean varargsHeaders) {
		this.varargsHeaders = varargsHeaders;
	}

	/**
	 * Gets the file.
	 *
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Sets the file.
	 *
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * Gets the alias.
	 *
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Sets the alias.
	 *
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Checks if is cached.
	 *
	 * @return the cached
	 */
	public boolean isCached() {
		return cached;
	}

	/**
	 * Sets the cached.
	 *
	 * @param cached the cached to set
	 */
	public void setCached(boolean cached) {
		this.cached = cached;
	}

	/**
	 * Checks if is read.
	 *
	 * @return the read
	 */
	public boolean isRead() {
		return read;
	}

	/**
	 * Sets the read.
	 *
	 * @param read the read to set
	 */
	public void setRead(boolean read) {
		this.read = read;
	}

	/**
	 * Checks if is store.
	 *
	 * @return the store
	 */
	public boolean isStore() {
		return store;
	}

	/**
	 * Sets the store.
	 *
	 * @param store the store to set
	 */
	public void setStore(boolean store) {
		this.store = store;
	}

}
