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

import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolString;
import org.eclipse.epsilon.eol.types.EolTypeWrapper;

public class EmfM0Model extends EmfModel{
	
	
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
		//this.metamodelFile = basePath + properties.getProperty("metamodelFile");
		this.metamodelUri = properties.getProperty("metamodelUri");
		//this.isMetamodel = Boolean.parseBoolean(properties.getProperty("isMetamodel"));
		//if (this.isMetamodel){
		//	this.modelFile = this.metamodelFile;
		//}
		//else {
		//	this.modelFile = basePath + properties.getProperty("modelFile");
		//}
		this.isMetamodelFileBased = Boolean.parseBoolean(properties.getProperty("isMetamodelFileBased"));
		this.m0SpecificationFile = new File(basePath + properties.getProperty("m0SpecificationFile"));
		this.readOnLoad = Boolean.parseBoolean(properties.getProperty("readOnLoad"));
		this.storeOnDisposal = Boolean.parseBoolean(properties.getProperty("storeOnDisposal"));
		load();
	}

	@Override
	public void load() throws EolModelLoadingException {
		super.load();
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
		copy.setMetamodelFile(this.getMetamodelFile());
		copy.setMetamodelUri(this.getMetamodelUri());
		copy.setModelFile(this.getModelFile());
		copy.setMetamodelFileBased(this.isMetamodelFileBased());
		//copy.setMetamodelImpl(this.getMetamodelImpl());
		copy.setModelImpl(this.getModelImpl());
		copy.setReadOnLoad(this.isReadOnLoad());
		copy.setStoredOnDisposal(this.isStoredOnDispoal());
		copy.setName("Model");
		
		eolModule.getContext().getModelRepository().addModel(copy);
	}
	
	public EolOperation getHelper(String name){
		ListIterator li = eolModule.getDeclaredOperations().listIterator();
		while (li.hasNext()){
			EolOperation helper = (EolOperation) li.next();
			if (helper.getName().equals(name)){
				return helper;
			}
		}
		return null;
	}
	
	class EmfM0PropertyGetter extends AbstractPropertyGetter {

		public Object invoke(Object object, String property) throws EolRuntimeException {
			ArrayList parameterValues = new ArrayList();
			parameterValues.add(new EolString(property));
			EolOperation propertyGetter = eolModule.getDeclaredOperations().getOperation(object,"getProperty",parameterValues,eolModule.getContext());
			if (propertyGetter != null){
				return propertyGetter.execute(object,parameterValues,eolModule.getContext());
			}
			else {
				return null;
			}
		}
	}
	
	class EmfM0PropertySetter extends AbstractPropertySetter {

		public void invoke(Object value) throws EolRuntimeException {
			ArrayList parameterValues = new ArrayList();
			parameterValues.add(new EolString(property));
			parameterValues.add(EolTypeWrapper.getInstance().wrap(value));
			EolOperation propertySetter = eolModule.getDeclaredOperations().getOperation(object,"setProperty",parameterValues,eolModule.getContext());
			if (propertySetter != null) {
				propertySetter.execute(object,parameterValues,eolModule.getContext());
			}
		}
	}

	@Override
	public IPropertyGetter getPropertyGetter() {
		return new EmfM0PropertyGetter();
	}

	@Override
	public IPropertySetter getPropertySetter() {
		return new EmfM0PropertySetter();
	}

	@Override
	public Collection getAllOfType(String metaClass) throws EolModelElementTypeNotFoundException {
		EolOperation allOfTypeHelper = getHelper("allOfType");
		EolCollection allOfType = null;
		
		try {
			allOfType = (EolCollection) allOfTypeHelper.execute(new EolString(metaClass), new ArrayList(), eolModule.getContext());
		}
		catch (EolRuntimeException rex){
			eolModule.getContext().getErrorStream().print(rex);
		}
		return allOfType.getStorage();
	}
	
	@Override
	public Collection getAllOfKind(String metaClass) throws EolModelElementTypeNotFoundException {
		EolOperation allOfKindHelper = getHelper("allOfKind");
		EolCollection allOfKind = null;
		
		try {
			allOfKind = (EolCollection) allOfKindHelper.execute(new EolString(metaClass), new ArrayList(), eolModule.getContext());
		}
		catch (EolRuntimeException rex){
			eolModule.getContext().getErrorStream().print(rex);
		}
		return allOfKind.getStorage();
	}
	
	//FIXME : Actually check is such a type is present
	@Override
	public boolean hasType(String type){
		EolOperation hasTypeHelper = getHelper("hasType");
		EolBoolean hasType = EolBoolean.FALSE;
		
		try {
			hasType = (EolBoolean) hasTypeHelper.execute(new EolString(type), new ArrayList(), eolModule.getContext());
		}
		catch (EolRuntimeException rex){
			eolModule.getContext().getErrorStream().print(rex);
		}
		return hasType.booleanValue();
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
/*
	public static void main(String[] args) throws Exception{
		
		String basePath = "E:/Projects/Eclipse/3.2.1/workspace/org.eclipse.epsilon.eol.models.emf/src/org/epsilon/eol/models/emf/m0/";
		
		EmfM0Model model = new EmfM0Model();
		//model.setMetamodel(false);
		model.setMetamodelFileBased(true);
		model.setMetamodelFile(basePath + "Relational.ecore");
		model.setModelFile(basePath + "RelationalInstance.ecore");
		model.setM0SpecificationFile(new File(basePath + "Relational.eol"));
		model.setName("Relational");
		model.setReadOnLoad(true);
		model.load();
	
		IEolModule testModule = new EolModule();
		
		try {
			if (testModule.parse(new File(basePath + "RelationalTest.eol"))){
				testModule.getContext().getModelRepository().addModel(model);
				testModule.execute();
			}
			else {
				for (ParseProblem problem : testModule.getParseProblems()) {
					System.err.println(problem);
				}
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
		
	}
*/	
}
