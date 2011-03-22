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
package org.eclipse.epsilon.eol.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.models.transactions.ModelRepositoryTransactionSupport;

public class ModelRepository {
	
	ModelRepositoryTransactionSupport transactionSupport;
	List<IModel> models = new ArrayList<IModel>();
	
	public ModelRepositoryTransactionSupport getTransactionSupport() {
		if (transactionSupport == null) {
			transactionSupport = new ModelRepositoryTransactionSupport(this);
		}
		return transactionSupport;
	}
	
	public void addModel(IModel model){
		
		if (!models.contains(model)){
			models.add(model);
		}
	}
	
	public void removeModel(IModel model) {
		models.remove(model);
		cachedModelGroups = new HashMap<String, ModelGroup>();
	}
	
	public IModel getModelByNameSafe(String modelName) {
		try {
			return getModelByName(modelName);
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	private HashMap<String, ModelGroup> cachedModelGroups = new HashMap<String, ModelGroup>();
	public IModel getModelByName(String modelName) throws EolModelNotFoundException{

		// Note: EUnit's model bindings depend on having "" aliased to the first model.
		// If you change this, don't forget to change EUnitModule#runSuite!
		if (modelName.length() == 0){
			if (models.size() > 0) {
			//if (models.size() == 1) {
				return models.get(0);
			}
			else return null;
		}
		
		for (IModel model : models){
			if (model.getName().equals(modelName)){
				return model;
			} 
		}
		
		ModelGroup modelGroup = (ModelGroup) cachedModelGroups.get(modelName);
		if (modelGroup == null) {
			modelGroup = new ModelGroup(this,modelName);
			cachedModelGroups.put(modelName,modelGroup);
		}
		return modelGroup;
	}
	
	/*
	public Collection<IModel> getModelsByAlias(String metaModelName){
		ArrayList<IModel> selected = new ArrayList<IModel>();
		for (IModel model : models){
			if (model.getAliases().contains(metaModelName)){
				selected.add(model);
			}
		}
		return selected;
	}
	*/
	
	//TODO : Add support for using #vk_public straight
	// and test for MDR models
	//FIXME : Remove method from model repository
	public Object getEnumerationValue(String modelAndEnumerationAndLabel) throws EolModelNotFoundException, EolEnumerationValueNotFoundException{
		
		String modelName = getModelName(modelAndEnumerationAndLabel);
		String enumerationAndLabel = getMetaClassName(modelAndEnumerationAndLabel);
		String enumeration = getEnumeration(enumerationAndLabel);
		String label = getLabel(enumerationAndLabel);
		
		IModel model = getModelByName(modelName);
		return model.getEnumerationValue(enumeration, label);
	}
	
	/*
	public Object createInstance(String modelAndMetaClass) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException, EolModelNotFoundException {
		String modelName = getModelName(modelAndMetaClass);
		IModel model = getModelByName(modelName);
		if (model != null){
			return model.createInstance(getMetaClassName(modelAndMetaClass));
			
		}
		else {
			throw new EolModelNotFoundException(modelName);
		}
	}
	*/
	
	/*
	public Collection getAllOfType(String modelAndMetaClass) throws EolModelElementTypeNotFoundException, EolModelNotFoundException{
		String modelName = getModelName(modelAndMetaClass);
		String metaClass = getMetaClassName(modelAndMetaClass);
		IModel model = getModelByName(modelName);
		if (model != null){
			return model.getAllOfType(metaClass);
		} else {
			Collection<IModel> models = getModelsByAlias(modelName);
			if (models.size() > 0){
				ArrayList allOfClass = new ArrayList();
				for (IModel m : models) {
					allOfClass.addAll(m.getAllOfType(metaClass));
				}
				return allOfClass;
			}
		}
		throw new EolModelNotFoundException(modelName);
	}
	
	public Collection getAllOfKind(String modelAndMetaClass) throws EolModelElementTypeNotFoundException, EolModelNotFoundException{
		String modelName = getModelName(modelAndMetaClass);
		String metaClass = getMetaClassName(modelAndMetaClass);
		IModel model = getModelByName(modelName);
		if (model != null){
			return model.getAllOfKind(getMetaClassName(modelAndMetaClass));
		} else {
			Collection<IModel> models = getModelsByAlias(modelName);
			if (models.size() > 0){
				ArrayList allOfType = new ArrayList();
				for (IModel m : models) {
					allOfType.addAll(m.getAllOfType(metaClass));
				}
				return allOfType;
			}
		}
		throw new EolModelNotFoundException(modelName);		
	}
	*/
	
	/*
	public boolean isInstantiable(String modelAndMetaClass) throws EolModelNotFoundException {
		String modelName = getModelName(modelAndMetaClass);
		String metaClass = getMetaClassName(modelAndMetaClass);
		IModel model = getModelByName(modelName);
		return model.isInstantiable(metaClass);
	}
	*/
	/*
	public boolean existsMetaClass(String modelAndMetaClass) throws EolModelNotFoundException {
		String modelName = getModelName(modelAndMetaClass);
		String metaClass = getMetaClassName(modelAndMetaClass);
		IModel model = getModelByName(modelName);
		return model.hasType(metaClass);		
	}
	*/
	
	public IModel getOwningModel(Object instance){
		for (IModel model : models) {
			if (model.owns(instance)){
				return model;
			}
		}
		return null;
	}
	
	/*
	public boolean isModelElement(Object instance){
		for (IModel model : models) {
			if (model.isModelElement(instance)) return true;
		}
		return false;
	}
	*/
	
	protected String getMetaClassName(String modelAndMetaClass){
		if (modelAndMetaClass.indexOf("!") != -1){
			return modelAndMetaClass.split("!")[1];
		}
		else {
			return modelAndMetaClass;
		}
	}
	
	protected String getModelName(String modelAndMetaClass){
		if (modelAndMetaClass.indexOf("!") != -1){
			return modelAndMetaClass.split("!")[0];
		}
		else {
			return "";
		}
	}
	
	protected String getEnumeration(String enumerationAndLabel){
		return enumerationAndLabel.split("#")[0];
	}
	
	protected String getLabel(String enumerationAndLabel){
		return enumerationAndLabel.split("#")[1];
	}
	
	public void dispose(){
		for (IModel model : models) {
			model.dispose();
			model = null;
		}
		models.clear();
		transactionSupport = null;
	}
	
	public List<IModel> getModels(){
		return models;
	}
	
}
