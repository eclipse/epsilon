/*******************************************************************************
 * Copyright (c) 2010 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Horacio Hoyos - Support for headers and model modification/save
 ******************************************************************************/
package org.eclipse.epsilon.emc.csv;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;
import org.eclipse.epsilon.eol.models.CachedModel;

/**
 * The Class CsvModel provides The Epsilon Model Connectivity Layer for CSV
 * files (http://tools.ietf.org/html/rfc4180), with the difference that it 
 * supports files in which each line has a different number of fields.
 * <p>
 * Three properties allow configuration of how to read the CSV file:
 * <ul>
 * <li>PROPERTY_FIELD_SEPARATOR, by default a comma (','), but you can specify
 * a different separator. In particular, fields are identified using
 * {@link java.lang.String#split(String)}, and as such, PROPERTY_FIELD_SEPARATOR is
 * actually treated as regular expression (see <a href="Regex>http://docs.oracle.com/javase/6/docs/api/java/util/regex/Pattern.html#sum)</a>
 * <li>PROPERTY_HAS_KNOWN_HEADERS, "There maybe an optional header line appearing
 * as the first line of the file with the same format as normal record lines. This
 * header will contain names corresponding to the fields in the file and should
 * contain the same number of fields as the records in the rest of the file". If
 * this property is set to true, model loading will verify that all lines have the
 * same number of fields as the header. When accessing the model elements (rows)
 * each of the header fields can be used to access information on each record.
 * <li>PROPERTY_HAS_VARARGS_HEADERS, allows the use of varargs headers. This is
 * a special type of header in which the last filed in the header line is used
 * as a base name for all fields after this one. This allows for lines to have a
 * variable number of fields. During model loading it will be verified that each
 * line has at least the same number of fields as header fields minus one. Fields
 * in a record including and following the last header filed will be assigned the
 * header lastHeader0, lastHeader1, lastHeader2,... and so on an so forth.
 * </ul>
 * 
 * 
 */
public class CsvModel extends CachedModel<Map<String, Object>> {

	/** The Constant PROPERTY_FILE. */
	public static final String PROPERTY_FILE = "file";

	/** The Constant PROPERTY_FIELD_SEPARATOR. */
	public static final String PROPERTY_FIELD_SEPARATOR = "fieldSeparator";

	/** The Constant PROPERTY_HAS_KNOWN_HEADERS. */
	public static final String PROPERTY_HAS_KNOWN_HEADERS = "hasKNownHeaders";
	
	/** The Constant PROPERTY_HAS_VARARGS_HEADERS. */
	public static final String PROPERTY_HAS_VARARGS_HEADERS = "hasVarargsHeaders";
	
	/** The field separator. */
	private String fieldSeparator = ",";
	
	/** The has known headers. */
	private boolean knownHeaders;
	
	/** The has varargs headers. */
	private boolean varargsHeaders;
	
	/** The file. */
	private String file;
	
	/* Objects in this model are Maps */
	/** The rows. */
	private Collection<Map<String, Object>> rows = new LinkedList<Map<String, Object>>();

	
	/**
	 * Gets the field separator.
	 *
	 * @return the field separator
	 */
	public String getFieldSeparator() {
		return fieldSeparator;
	}

	/**
	 * Sets the field separator.
	 *
	 * @param fieldSeparator the new field separator
	 */
	public void setFieldSeparator(String fieldSeparator) {
		this.fieldSeparator = fieldSeparator;
	}

	/**
	 * Checks if is known headers.
	 *
	 * @return true, if is known headers
	 */
	public boolean isKnownHeaders() {
		return knownHeaders;
	}

	/**
	 * Sets the known headers.
	 *
	 * @param knownHeaders the new known headers
	 */
	public void setKnownHeaders(boolean knownHeaders) {
		this.knownHeaders = knownHeaders;
	}

	/**
	 * Checks if is varargs headers.
	 *
	 * @return true, if is varargs headers
	 */
	public boolean isVarargsHeaders() {
		return varargsHeaders;
	}

	/**
	 * Sets the varargs headers.
	 *
	 * @param varargsHeaders the new varargs headers
	 */
	public void setVarargsHeaders(boolean varargsHeaders) {
		this.varargsHeaders = varargsHeaders;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.IModel#getEnumerationValue(java.lang.String, java.lang.String)
	 */
	@Override
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.Model#getTypeOf(java.lang.Object)
	 */
	@Override
	public Object getTypeOf(Object instance) {
		return LinkedHashMap.class;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.IModel#getTypeNameOf(java.lang.Object)
	 */
	@Override
	public String getTypeNameOf(Object instance) {
		return LinkedHashMap.class.getName();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.IModel#getElementById(java.lang.String)
	 */
	@Override
	public Object getElementById(String id) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.IModel#getElementId(java.lang.Object)
	 */
	@Override
	public String getElementId(Object instance) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.IModel#setElementId(java.lang.Object, java.lang.String)
	 */
	@Override
	public void setElementId(Object instance, String newId) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.IModel#owns(java.lang.Object)
	 */
	@Override
	public boolean owns(Object instance) {
		return rows.contains(instance);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.IModel#isInstantiable(java.lang.String)
	 */
	@Override
	public boolean isInstantiable(String type) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.Model#isModelElement(java.lang.Object)
	 */
	@Override
	public boolean isModelElement(Object instance) {
		return instance instanceof LinkedHashMap;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.IModel#hasType(java.lang.String)
	 */
	@Override
	public boolean hasType(String type) {
		return "Row".equals(type);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.IModel#store(java.lang.String)
	 */
	@Override
	public boolean store(String location) {
		try {
			FileUtil.setFileContents(concatenateMap(), new File(location));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.IModel#store()
	 */
	@Override
	public boolean store() {
		
		try {
			FileUtil.setFileContents(concatenateMap(), new File(this.file));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private String concatenateMap() {
		StringBuilder output = new StringBuilder();
		if (this.knownHeaders) {
			// First line is the headers
			Iterator<String> keyIt = ((Map<String, Object>) ((LinkedList<Map<String, Object>>) rows).getFirst()).keySet().iterator();
			output.append(keyIt.next());
			while (keyIt.hasNext()) {
				output.append(this.fieldSeparator);
				output.append(keyIt.next());
			}
			output.append(System.getProperty("line.separator"));
		}
		for (Map<String, Object>row : rows) {
			Iterator<Object> fieldIt = row.values().iterator();
			output.append(fieldIt.next());
			while (fieldIt.hasNext()) {
				output.append(this.fieldSeparator);
				output.append(fieldIt.next());
			}
			output.append(System.getProperty("line.separator"));
			
		}
		return output.toString();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.CachedModel#allContentsFromModel()
	 */
	@Override
	protected Collection<? extends Map<String, Object>> allContentsFromModel() {
		return rows;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.CachedModel#getAllOfTypeFromModel(java.lang.String)
	 */
	@Override
	protected Collection<? extends Map<String, Object>> getAllOfTypeFromModel(String type) throws EolModelElementTypeNotFoundException {
		if (!"Row".equals(type)) {
			throw new EolModelElementTypeNotFoundException(this.name, type);
		}
		return allContents();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.CachedModel#getAllOfKindFromModel(java.lang.String)
	 */
	@Override
	protected Collection<? extends Map<String, Object>> getAllOfKindFromModel(String kind) throws EolModelElementTypeNotFoundException {
		if (!"Row".equals(kind)) {
			throw new EolModelElementTypeNotFoundException(this.name, kind);
		}
		return allContents();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.CachedModel#createInstanceInModel(java.lang.String)
	 */
	@Override
	protected Map<String, Object> createInstanceInModel(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		if (!"Row".equals(type)) {
			throw new EolModelElementTypeNotFoundException(this.name, type);
		}
		Map<String, Object> returnVal = new LinkedHashMap<String, Object>();
		for (String key : ((Map<String, Object>) ((LinkedList<Map<String, Object>>) rows).getFirst()).keySet()) {
			returnVal.put(key, "");
		}
		rows.add(returnVal);
		return returnVal;
	}
	
	@Override
	public IPropertyGetter getPropertyGetter() {
		return new CsvPropertyGetter();
	}
	
	@Override
	public IReflectivePropertySetter getPropertySetter() {
		return new CsvPropertySetter();
	}

	/**
	 * Checks if the model elements have this property.
	 * 
	 *
	 * @param type the type (should always be "Row" (see {@link #hasType(String)} )
	 * @param property the property
	 * @return true, if successful
	 * @throws EolModelElementTypeNotFoundException the eol model element type not found exception
	 */
	public boolean hasProperty(String type, String property) throws EolModelElementTypeNotFoundException {
		if (!hasType(type)) {
			throw new EolModelElementTypeNotFoundException(this.name, type);
		}
		if (!this.knownHeaders) {
			return true;
		} else {
			if (this.varargsHeaders) {
				if (((LinkedHashMap<String, Object>) ((LinkedList<Map<String, Object>>) rows).getFirst()).keySet().contains(property)) {
					return true;
				} else {
					// It might be the varargs header field
					String varargsHeader = ((LinkedHashMap<String, Object>) ((LinkedList<Map<String, Object>>) rows).getFirst()).keySet().iterator().next();
					return varargsHeader.startsWith(property);
				}
			} else {
				return ((LinkedHashMap<String, Object>) ((LinkedList<Map<String, Object>>) rows).getFirst()).keySet().contains(property);
			}
			
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.CachedModel#loadModel()
	 */
	@Override
	protected void loadModel() throws EolModelLoadingException {
		LinkedList<String> lines = null;
		try {
			lines = new LinkedList<String>(FileUtil.getFileLineContents(new File(file)));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			throw new EolModelLoadingException(ex, this);
		} finally {
			if(this.knownHeaders) {
				List<String> keys = Arrays.asList(lines.get(0).split(this.fieldSeparator));
				List<String> values;
				for (int i=1; i < lines.size(); i++) {
					LinkedHashMap<String, Object> row = new LinkedHashMap<String, Object>();
					values = Arrays.asList(lines.get(i).split(this.fieldSeparator));
					if (!this.varargsHeaders) {
						if (keys.size() != values.size()) {
							Exception ex = new Exception("Line " + (i+1) + " contains different number of elements than the header");
							throw new EolModelLoadingException(ex, this);
						}
						for (int f=0; f<keys.size(); f++) {
							row.put(keys.get(f), values.get(f));
						}
					} else {
						if (keys.size()-1 > values.size()) {
							Exception ex = new Exception("Line " + i + " contains different number of elements than the header");
							throw new EolModelLoadingException(ex, this);
						}
						int numKeys= keys.size();
						String varargHeader = keys.get(numKeys-1);
						for (int f=0; f<numKeys-1; f++) {
								row.put(keys.get(f), values.get(f));
						}
						List<String> varargsField = new ArrayList<String>();
						for (int v = numKeys-1; v < values.size(); v++) {
							varargsField.add( values.get(v));
						}
						row.put(varargHeader, varargsField);
					}
					rows.add(row);
				}
			} else {
				for (int i=0; i < lines.size(); i++) {
					LinkedHashMap<String, Object> row = new LinkedHashMap<String, Object>();
					row.put("field", Arrays.asList(lines.get(i).split(this.fieldSeparator)));
					rows.add(row);
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.CachedModel#load(org.eclipse.epsilon.common.util.StringProperties, java.lang.String)
	 */
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		super.load(properties, basePath);
		
		if (basePath != null)
			this.file = basePath + properties.getProperty(PROPERTY_FILE);
		else
			this.file = properties.getProperty(PROPERTY_FILE);
		this.fieldSeparator = properties.getProperty(PROPERTY_FIELD_SEPARATOR);
		this.knownHeaders = properties.getBooleanProperty(PROPERTY_HAS_KNOWN_HEADERS, true);
		this.varargsHeaders = properties.getBooleanProperty(PROPERTY_HAS_VARARGS_HEADERS, false);	
		load();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.CachedModel#disposeModel()
	 */
	@Override
	protected void disposeModel() {
		rows.clear();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.CachedModel#deleteElementInModel(java.lang.Object)
	 */
	@Override
	protected boolean deleteElementInModel(Object instance) throws EolRuntimeException {
		return rows.remove(instance);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.CachedModel#getCacheKeyForType(java.lang.String)
	 */
	@Override
	protected Object getCacheKeyForType(String type) throws EolModelElementTypeNotFoundException {
		return type;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.epsilon.eol.models.CachedModel#getAllTypeNamesOf(java.lang.Object)
	 */
	@Override
	protected Collection<String> getAllTypeNamesOf(Object instance) {
		return Collections.singleton("Row");
	}

}
