/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.models.transactions.ModelRepositoryTransactionSupport;

public class ModelRepository {
	
	ModelRepositoryTransactionSupport transactionSupport;
	List<IModel> models = new ArrayList<>();
	
	public ModelRepositoryTransactionSupport getTransactionSupport() {
		if (transactionSupport == null) {
			transactionSupport = new ModelRepositoryTransactionSupport(this);
		}
		return transactionSupport;
	}
	
	public void addModels(IModel... models) {
		if (models == null || models.length == 0) return;
		CollectionUtil.addCapacityIfArrayList(this.models, models.length);
		for (IModel model : models)
			addModel(model);
	}
	
	/**
	 * 
	 * @param models
	 * @since 1.6
	 */
	public void addModels(Collection<? extends IModel> models) {
		if (models == null || models.isEmpty()) return;
		CollectionUtil.addCapacityIfArrayList(this.models, models.size());
		for (IModel model : models)
			addModel(model);
	}
	
	public void addModel(IModel model) {
		if (!models.contains(model)) {
			models.add(model);
		}
	}
	
	public void removeModel(IModel model) {
		models.remove(model);
		cachedModelGroups = new HashMap<>();
	}
	
	public IModel getModelByNameSafe(String modelName) {
		try {
			return getModelByName(modelName);
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	private HashMap<String, ModelGroup> cachedModelGroups = new HashMap<>();
	
	public IModel getModelByName(String modelName) throws EolModelNotFoundException {

		// Note: EUnit's model bindings depend on having "" aliased to the first model.
		// If you change this, don't forget to change EUnitModule#runSuite!
		if (modelName.length() == 0) {
			if (models.size() > 0) {
				return models.get(0);
			}
			else return null;
		}
		
		for (IModel model : models) {
			if (modelName.equals(model.getName())) {
				return model;
			} 
		}
		
		ModelGroup modelGroup = cachedModelGroups.get(modelName);
		if (modelGroup == null) {
			modelGroup = new ModelGroup(this,modelName);
			cachedModelGroups.put(modelName, modelGroup);
		}
		return modelGroup;
	}
	
	/**
	 * Returns a result that indicates (1) whether the specified type
	 * is ambiguous (i.e. more than one {@link IModel} in this repository
	 * has the type), and (2) the set of models that do have this type.
	 */
	public AmbiguityCheckResult checkAmbiguity(String typeName) {	
		final List<String> namesOfModelsThatHaveThisType = namesOfModelsThatHaveTheType(typeName);
		final boolean      typeIsAmbiguous               = namesOfModelsThatHaveThisType.size() > 1;
		final String       nameOfSelectedModel           = namesOfModelsThatHaveThisType.isEmpty() ? "" : namesOfModelsThatHaveThisType.get(0);
		
		return new AmbiguityCheckResult(typeIsAmbiguous, namesOfModelsThatHaveThisType, nameOfSelectedModel);
	}

	private List<String> namesOfModelsThatHaveTheType(String typeName) {
		final List<String> modelNames = new LinkedList<>();
		
		for (IModel model : getModels()) {
			if (model.hasType(typeName)) {
				modelNames.add(model.getName());
			}
		}
		return modelNames;
	}
	
	public static class AmbiguityCheckResult {
		public final boolean isAmbiguous;
		public final Collection<String> namesOfOwningModels;
		public final String nameOfSelectedModel;
		
		public AmbiguityCheckResult(boolean isAmbiguous, Collection<String> namesOfOwningModels, String nameOfSelectedModel) {
			this.isAmbiguous = isAmbiguous;
			this.namesOfOwningModels = namesOfOwningModels;
			this.nameOfSelectedModel = nameOfSelectedModel;
		} 		
	}
	
	//TODO : Add support for using #vk_public straight
	// and test for MDR models
	//FIXME : Remove method from model repository
	public Object getEnumerationValue(String modelAndEnumerationAndLabel) throws EolModelNotFoundException, EolEnumerationValueNotFoundException {
		
		String modelName = getModelName(modelAndEnumerationAndLabel);
		String enumerationAndLabel = getMetaClassName(modelAndEnumerationAndLabel);
		String enumeration = getEnumeration(enumerationAndLabel);
		String label = getLabel(enumerationAndLabel);
		
		IModel model = getModelByName(modelName);
		return model.getEnumerationValue(enumeration, label);
	}
	
	public IModel getOwningModel(Object instance) {
		// Fail fast since models should not contain null objects.
		if (instance == null) {
			return null;
		}
		if (instance instanceof IModelElement) {
			return ((IModelElement) instance).getOwningModel();
		}
		
		for (IModel model : models) {
			if (model.owns(instance)) {
				return model;
			}
		}
		return null;
	}
	
	protected String getMetaClassName(String modelAndMetaClass) {
		if (modelAndMetaClass.contains("!")) {
			return modelAndMetaClass.split("!")[1];
		}
		else {
			return modelAndMetaClass;
		}
	}
	
	protected String getModelName(String modelAndMetaClass) {
		if (modelAndMetaClass.contains("!")) {
			return modelAndMetaClass.split("!")[0];
		}
		else {
			return "";
		}
	}
	
	protected String getEnumeration(String enumerationAndLabel) {
		return enumerationAndLabel.split("#")[0];
	}
	
	protected String getLabel(String enumerationAndLabel) {
		return enumerationAndLabel.split("#")[1];
	}
	
	public void dispose() {
		for (IModel model : models) {
			model.dispose();
			model = null;
		}
		models.clear();
		transactionSupport = null;
	}
	
	public List<IModel> getModels() {
		return models;
	}

	@Override
	public String toString() {
		return "ModelRepository [transactionSupport=" + transactionSupport + ", models=" + models + "]";
	}
}
