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
package org.eclipse.epsilon.emc.emf.m0;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;

public class EmfM0Model extends EmfModel {
	
	
	protected File m0SpecificationFile;
	protected IEolModule eolModule;
	
	public EmfM0Model() {
		super();
	}
	
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		this.name = properties.getProperty("name");
		String[] aliases = properties.getProperty("aliases").split(",");
		for (int i=0;i<aliases.length;i++){
			this.aliases.add(aliases[i].trim());
		}
		setMetamodelFile(properties.getProperty(EmfModel.PROPERTY_METAMODEL_FILE));
		setMetamodelUri(properties.getProperty("metamodelUri"));
		this.isMetamodelFileBased = Boolean.parseBoolean(properties.getProperty("isMetamodelFileBased"));
		this.m0SpecificationFile = new File(basePath + properties.getProperty("m0SpecificationFile"));
		this.readOnLoad = Boolean.parseBoolean(properties.getProperty("readOnLoad"));
		this.storeOnDisposal = Boolean.parseBoolean(properties.getProperty("storeOnDisposal"));
		load();
	}

	@Override
	protected void loadModel() throws EolModelLoadingException {
		super.loadModel();
		eolModule = new EolModule();
		
		try {
			eolModule.parse(m0SpecificationFile);
			eolModule.execute();
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		
		EmfModel copy = new EmfModel();
		
		//copy.setMetamodel(this.isMetamodel());
		copy.getAliases().addAll(this.getAliases());
		copy.setMetamodelFiles(this.getMetamodelFiles());
		copy.setMetamodelUris(this.getMetamodelUris());
		copy.setModelFile(this.getModelFile());
		copy.setMetamodelFileBased(this.isMetamodelFileBased());
		//copy.setMetamodelImpl(this.getMetamodelImpl());
		copy.setModelImpl(this.getModelImpl());
		copy.setReadOnLoad(this.isReadOnLoad());
		copy.setStoredOnDisposal(this.isStoredOnDisposal());
		copy.setName("Model");
		
		eolModule.getContext().getModelRepository().addModel(copy);
	}
	
	public EolOperation getHelper(String name){
		ListIterator<EolOperation> li = eolModule.getDeclaredOperations().listIterator();
		while (li.hasNext()){
			EolOperation helper = li.next();
			if (helper.getName().equals(name)){
				return helper;
			}
		}
		return null;
	}
	
	class EmfM0PropertyGetter extends AbstractPropertyGetter {

		public Object invoke(Object object, String property) throws EolRuntimeException {
			ArrayList<Object> parameterValues = new ArrayList<Object>();
			parameterValues.add(property);
			EolOperation propertyGetter = eolModule.getDeclaredOperations().getOperation(object,"getProperty",parameterValues,eolModule.getContext());
			if (propertyGetter != null){
				return propertyGetter.execute(object,parameterValues,eolModule.getContext());
			}
			else {
				return null;
			}
		}
	}
	
	class EmfM0PropertySetter extends AbstractPropertySetter implements IReflectivePropertySetter {

		public void invoke(Object value) throws EolRuntimeException {
			ArrayList<Object> parameterValues = new ArrayList<Object>();
			parameterValues.add(property);
			parameterValues.add(value);
			EolOperation propertySetter = eolModule.getDeclaredOperations().getOperation(object,"setProperty",parameterValues,eolModule.getContext());
			if (propertySetter != null) {
				propertySetter.execute(object,parameterValues,eolModule.getContext());
			}
		}

		public Object coerce(Object value) throws EolIllegalPropertyException {
			return value;
		}

		public boolean conforms(Object value) throws EolIllegalPropertyException {
			return true;
		}
	}

	@Override
	public IPropertyGetter getPropertyGetter() {
		return new EmfM0PropertyGetter();
	}

	@Override
	public IReflectivePropertySetter getPropertySetter() {
		return new EmfM0PropertySetter();
	}

	@Override
	protected Collection<EObject> getAllOfTypeFromModel(String metaClass) throws EolModelElementTypeNotFoundException {
		EolOperation allOfTypeHelper = getHelper("allOfType");
		Collection<EObject> allOfType = null;
		
		try {
			allOfType = (Collection<EObject>) allOfTypeHelper.execute(metaClass, new ArrayList<EObject>(), eolModule.getContext());
		}
		catch (EolRuntimeException rex){
			eolModule.getContext().getErrorStream().print(rex);
		}
		return allOfType;
	}
	
	@Override
	protected Collection<EObject> getAllOfKindFromModel(String metaClass) throws EolModelElementTypeNotFoundException {
		EolOperation allOfKindHelper = getHelper("allOfKind");
		Collection<EObject> allOfKind = null;
		
		try {
			allOfKind = (Collection<EObject>) allOfKindHelper.execute(metaClass, new ArrayList<Object>(), eolModule.getContext());
		}
		catch (EolRuntimeException rex){
			eolModule.getContext().getErrorStream().print(rex);
		}
		return allOfKind;
	}
	
	//FIXME : Actually check is such a type is present
	@Override
	public boolean hasType(String type){
		EolOperation hasTypeHelper = getHelper("hasType");
		boolean hasType = false;
		
		try {
			hasType = (Boolean) hasTypeHelper.execute(type, new ArrayList<Object>(), eolModule.getContext());
		}
		catch (EolRuntimeException rex){
			eolModule.getContext().getErrorStream().print(rex);
		}
		return hasType;
	}
	
	public File getM0SpecificationFile() {
		return m0SpecificationFile;
	}

	public void setM0SpecificationFile(File specification) {
		m0SpecificationFile = specification;
	}
	
	public IEolModule getEolModule() {
		return eolModule;
	}

	public void setEolModule(IEolModule eolModule) {
		this.eolModule = eolModule;
	}
	
}
