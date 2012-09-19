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
package org.eclipse.epsilon.emc.bibtex;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.emc.bibtex.domain.Bibliography;
import org.eclipse.epsilon.emc.bibtex.domain.Publication;
import org.eclipse.epsilon.emc.bibtex.parser.BibtexParser;
import org.eclipse.epsilon.emc.bibtex.parser.BibtexUnparser;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.CachedModel;

public class BibtexModel extends CachedModel<Publication> {

	public static final String PROPERTY_SOURCE_FILE = "sourceFile";
	
	private String bibtex;
	private Bibliography bibliography = new Bibliography();

	public void setBibtex(String bibtex) {
		this.bibtex = bibtex;
	}
	
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		super.load(properties, basePath);

		readBibtexFromFile(properties, basePath);
		load();
	}

	private void readBibtexFromFile(StringProperties properties, String basePath) throws EolModelLoadingException {
		try {				
			final File bibtexFile = new File(StringUtil.toString(basePath) + properties.getProperty(PROPERTY_SOURCE_FILE));
			this.bibtex = FileUtil.getFileContents(bibtexFile);
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this);
		}
	}
	
	@Override
	protected void loadModel() throws EolModelLoadingException {
		bibliography = new BibtexParser(bibtex).parse();
	}

	public boolean owns(Object instance) {
		return instance instanceof Publication;
	}
	
	public boolean hasType(String type) {
		return bibliography.hasType(type);
	}
	
	@Override
	protected Collection<? extends Publication> allContentsFromModel() {
		return new LinkedList<Publication>(bibliography.publications);
	}
	
	@Override
	protected Collection<? extends Publication> getAllOfTypeFromModel(String type) throws EolModelElementTypeNotFoundException {
		return bibliography.allOfType(type);	
	}
	
	@Override
	protected Collection<? extends Publication> getAllOfKindFromModel(String kind) throws EolModelElementTypeNotFoundException {
		return getAllOfType(kind);
	}
	
	@Override
	protected Object getCacheKeyForType(String type) throws EolModelElementTypeNotFoundException {
		return type;
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return new AbstractPropertyGetter() {
			
			@Override
			public boolean hasProperty(Object object, String property) {
				return "id".equals(property) || ((Publication)object).hasProperty(property);
			}

			public Object invoke(Object object, String property) throws EolRuntimeException {
				final Publication publication = (Publication)object;
				
				return "id".equals(property) ? publication.id : publication.getProperty(property);
			}
		};
	}
	
	@Override
	public IPropertySetter getPropertySetter() {
		return new AbstractPropertySetter() {
			
			public void invoke(Object value) throws EolRuntimeException {
				((Publication)object).setProperty(property, value);
			}
		};
	}
	
	public boolean store(String location) {
		try {
			FileUtil.setFileContents(new BibtexUnparser(bibliography).unparse(), new File(location));
			return true;
		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		throw new UnsupportedOperationException();
	}

	public Object getTypeOf(Object instance) {
		throw new UnsupportedOperationException();
	}

	public String getTypeNameOf(Object instance) {
		throw new UnsupportedOperationException();
	}

	public Object getElementById(String id) {
		throw new UnsupportedOperationException();
	}

	public String getElementId(Object instance) {
		throw new UnsupportedOperationException();
	}

	public void setElementId(Object instance, String newId) {
		throw new UnsupportedOperationException();
	}

	public boolean isInstantiable(String type) {
		throw new UnsupportedOperationException();
	}

	public boolean isModelElement(Object instance) {
		throw new UnsupportedOperationException();
	}

	public boolean store() {
		throw new UnsupportedOperationException();
	}

	@Override
	protected Publication createInstanceInModel(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void disposeModel() {}

	@Override
	protected boolean deleteElementInModel(Object instance) throws EolRuntimeException {
		throw new UnsupportedOperationException();
	}

	@Override
	protected Collection<String> getAllTypeNamesOf(Object instance) {
		throw new UnsupportedOperationException();
	}
}
