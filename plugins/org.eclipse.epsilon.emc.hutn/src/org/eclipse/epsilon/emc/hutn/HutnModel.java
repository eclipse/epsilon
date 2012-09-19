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
package org.eclipse.epsilon.emc.hutn;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotAnEnumerationValueException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;
import org.eclipse.epsilon.eol.models.IAdaptableModel;
import org.eclipse.epsilon.eol.models.IReflectiveModel;
import org.eclipse.epsilon.eol.models.Model;
import org.eclipse.epsilon.hutn.HutnModule;
import org.eclipse.epsilon.hutn.IHutnModule;
import org.eclipse.epsilon.hutn.exceptions.HutnGenerationException;
import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.Xmi2Hutn;


public class HutnModel extends Model implements IAdaptableModel, IReflectiveModel {

	public static final String PROPERTY_SOURCE_FILE = "sourceFile";
	
	private String hutn;
	private File hutnSourceFile;
	
	private EmfModel model;
	
	public HutnModel() {}
	
	public HutnModel(String name, String hutn) {
		this.hutn = hutn;
		setName(name);
	}
	
	public boolean preventLoadingOfExternalModelElements() {
		return false;
	}
	
	public void load() throws EolModelLoadingException {
		try {
			final IHutnModule module = new HutnModule();
			
			if (hutn != null)
				module.parse(hutn);
			else if (hutnSourceFile != null) {
				module.parse(hutnSourceFile);
			}
			
			if (!module.getParseProblems().isEmpty()) {
				final StringBuilder problems = new StringBuilder();
				
				for (ParseProblem problem : module.getParseProblems()) {
					problems.append('\n');
					problems.append(problem);
				}
				
				throw new EolModelLoadingException(new HutnGenerationException("Could not parse HUTN: " + problems), this);
			}

			model = (EmfModel)module.generateEmfModel();
			
			model.load();
		
		} catch (Exception e) {
			throw new EolModelLoadingException(e, this);
		}
	}
	
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		super.load(properties, basePath);
		
		this.hutnSourceFile = new File(StringUtil.toString(basePath) + properties.getProperty(PROPERTY_SOURCE_FILE));
		
		load();
	}

	@Override
	public IPropertyGetter getPropertyGetter() {
		return model.getPropertyGetter();
	}

	@Override
	public IReflectivePropertySetter getPropertySetter() {
		return model.getPropertySetter();
	}

	public boolean store(String location) {
		try {
			FileUtil.setFileContents(getHutn(), new File(location));
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean store() {
		return hutnSourceFile == null ? false : store(hutnSourceFile.getAbsolutePath());
	}
	
	@Override
	public String toString() {
		try {
			return getHutn();
		
		} catch (HutnXmiBridgeException e) {
			return "HutnModel(Could not deseralise to HUTN source)"; 
		}
	}

	private String getHutn() throws HutnXmiBridgeException {
		try {
			final StringOutputStream xmi = new StringOutputStream();
			
			model.getResource().save(xmi, Collections.EMPTY_MAP);
			
			return new Xmi2Hutn(xmi.toString()).getHutn();
		
		} catch (IOException e) { // Using a StringOutputStream
			e.printStackTrace();  // so this should never happen
			return "";
		}
	}
	
	class StringOutputStream extends OutputStream {
		
		StringBuffer buffer = new StringBuffer();
		
		@Override
		public void write(int chr) throws IOException {
			buffer.append((char) chr);
		}
		
		@Override
		public String toString() {
			return buffer.toString();
		}
	}
	
	
// Delegates //	

	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		return model.getEnumerationValue(enumeration, label);
	}

	public Collection<?> allContents() {
		return model.allContents();
	}

	public Collection<?> getAllOfType(String type) throws EolModelElementTypeNotFoundException {
		return model.getAllOfType(type);
	}

	public Collection<?> getAllOfKind(String type) throws EolModelElementTypeNotFoundException {
		return model.getAllOfKind(type);
	}

	public Object getTypeOf(Object instance) {
		return model.getTypeOf(instance);
	}

	public String getTypeNameOf(Object instance) {
		return model.getTypeNameOf(instance);
	}

	public Object createInstance(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		return model.createInstance(type);
	}

	public Object getElementById(String id) {
		return model.getElementById(id);
	}

	public String getElementId(Object instance) {
		return model.getElementId(instance);
	}

	public void setElementId(Object instance, String newId) {
		model.setElementId(instance, newId);
	}

	public void deleteElement(Object instance) throws EolRuntimeException {
		model.deleteElement(instance);
	}

	public boolean owns(Object instance) {
		return model.owns(instance);
	}

	public boolean isInstantiable(String type) {
		return model.isInstantiable(type);
	}
	
	public boolean isModelElement(Object instance) {
		return isModelElement(instance);
	}

	public boolean hasType(String type) {
		return model.hasType(type);
	}

	public Collection<String> getPropertiesOf(String type) throws EolModelElementTypeNotFoundException {
		return model.getPropertiesOf(type);
	}

	public boolean hasProperty(String type, String property) throws EolModelElementTypeNotFoundException {
		return model.hasProperty(type, property);
	}

	public boolean isEnumerationValue(Object object) {
		return model.isEnumerationValue(object);
	}

	public String getEnumerationTypeOf(Object literal) throws EolNotAnEnumerationValueException {
		return model.getEnumerationTypeOf(literal);
	}

	public String getEnumerationLabelOf(Object literal) throws EolNotAnEnumerationValueException {
		return model.getEnumerationLabelOf(literal);
	}
	
	public <T> T adaptTo(Class<T> modelType) {
		if (modelType.isInstance(model)) {
			return modelType.cast(model);
		}
		else {
			return null;
		}
	}

}
