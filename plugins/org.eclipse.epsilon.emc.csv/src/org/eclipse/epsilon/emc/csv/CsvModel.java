/*******************************************************************************
 * Copyright (c) 2010 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.csv;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.models.CachedModel;

public class CsvModel extends CachedModel<Collection<String>> {

	public static final String PROPERTY_FILE = "file";
	
	private String file;
	private Collection<Collection<String>> rows = new LinkedList<Collection<String>>();

	@Override
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getTypeOf(Object instance) {
		return Collection.class;
	}

	@Override
	public String getTypeNameOf(Object instance) {
		return "Row";
	}

	@Override
	public Object getElementById(String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getElementId(Object instance) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setElementId(Object instance, String newId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean owns(Object instance) {
		return instance instanceof Collection;
	}

	@Override
	public boolean isInstantiable(String type) {
		return false;
	}

	@Override
	public boolean isModelElement(Object instance) {
		return instance instanceof Collection;
	}

	@Override
	public boolean hasType(String type) {
		return "Row".equals(type);
	}

	@Override
	public boolean store(String location) {
		return false;
	}

	@Override
	public boolean store() {
		return false;
	}

	@Override
	protected Collection<Collection<String>> allContentsFromModel() {
		return rows;
	}

	@Override
	protected Collection<Collection<String>> getAllOfTypeFromModel(String type) throws EolModelElementTypeNotFoundException {
		return allContents();
	}

	@Override
	protected Collection<Collection<String>> getAllOfKindFromModel(String kind) throws EolModelElementTypeNotFoundException {
		return allContents();
	}

	@Override
	protected Collection<String> createInstanceInModel(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void loadModel() throws EolModelLoadingException {
		try {
			final String contents = FileUtil.getFileContents(new File(file));
			
			for (String row : contents.split("\\r\\n")) {
				final Collection<String> cells = new LinkedList<String>();
				
				for (String cell : row.split(",")) {
					cells.add(cell);
				}
				
				rows.add(cells);
			}
		
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this);
		}
	}
	
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		super.load(properties, basePath);
		
		if (basePath != null)
			this.file = basePath + properties.getProperty(PROPERTY_FILE);
		else
			this.file = properties.getProperty(PROPERTY_FILE);
		
		load();
	}

	@Override
	protected void disposeModel() {
		rows.clear();
	}

	@Override
	protected boolean deleteElementInModel(Object instance) throws EolRuntimeException {
		return false;
	}

	@Override
	protected Object getCacheKeyForType(String type) throws EolModelElementTypeNotFoundException {
		return type;
	}

	@Override
	protected Collection<String> getAllTypeNamesOf(Object instance) {
		return Collections.singleton("Row");
	}

}
