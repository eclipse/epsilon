/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.index;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.epsilon.concordance.model.CrossReferenceVisitor;
import org.eclipse.epsilon.concordance.model.Model;
import org.eclipse.epsilon.concordance.model.ModelVisitor;
import org.eclipse.epsilon.concordance.reporter.model.ModelChangeListener;
import org.eclipse.epsilon.concordance.reporter.model.ModelChangeReporter;

/**
 * This is a partial implementation of an in-memory index. It may not work as expected.
 */
public class InMemoryConcordanceIndex implements ConcordanceIndex, ModelChangeListener {

	final Map<Model, String>       modelToNsUri = new HashMap<Model, String>();
	final Map<Model, Set<Model>>   modelToReferencedModels = new HashMap<Model, Set<Model>>();
	
	final Map<String, Set<Model>> modelsByNsUri           = new HashMap<String, Set<Model>>();
	final Map<Model, Set<Model>>  modelsByReferencedModel = new HashMap<Model, Set<Model>>();
	
	/**
	 * @deprecated WARNING: This is a partial implementation of an in-memory index. It may not work as expected. 
	 */
	public InMemoryConcordanceIndex(ModelChangeReporter reporter) {
		reporter.addListener(this);
	}

	public void visitAllInstancesOf(String nsUri, ModelVisitor visitor) {
		if (!modelsByNsUri.containsKey(nsUri)) return;
		
		for (Model model : modelsByNsUri.get(nsUri)) {
			visitor.visit(model);
		}
	}
	
	public void visitAllModelsWithCrossReferencesTo(Model target, ModelVisitor visitor) {
		if (!modelsByReferencedModel.containsKey(target)) return;
		
		for (Model model : modelsByReferencedModel.get(target)) {
			visitor.visit(model);
		}
	}
	
	public void visitAllCrossReferencesWithTarget(Model target, CrossReferenceVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

	public void modelAdded(Model model) {
		addNsUriOfModel(model, model.getNsUri());
		addReferencedModelsOfModel(model, model.getAllReferencedModels());
	}

	public void modelChanged(Model model) {
		final String oldNsUri = modelToNsUri.get(model);
		final String newNsUri = model.getNsUri();
		
		if (!oldNsUri.equals(newNsUri)) {
			modelsByNsUri.get(oldNsUri).remove(model);
			addNsUriOfModel(model, newNsUri);
		}
		
		final Set<Model> oldReferencedModels = modelToReferencedModels.get(model);
		final Set<Model> newReferencedModels = model.getAllReferencedModels();
				
		if (!oldReferencedModels.equals(newReferencedModels)) {
			for (Model oldReferencedModel : oldReferencedModels) {
				modelsByReferencedModel.get(oldReferencedModel).remove(model);
			}
			
			addReferencedModelsOfModel(model, newReferencedModels);
		}
	}
	
	private void addNsUriOfModel(Model model, String nsUri) {
		modelToNsUri.put(model, nsUri);
		
		if (!modelsByNsUri.containsKey(nsUri)) {
			modelsByNsUri.put(nsUri, new HashSet<Model>());
		}
		
		modelsByNsUri.get(nsUri).add(model);
	
	}
	
	private void addReferencedModelsOfModel(Model model, Set<Model> referencedModels) {
		modelToReferencedModels.put(model, referencedModels);
		
		for (Model referencedModel : referencedModels) {
			if (!modelsByReferencedModel.containsKey(referencedModel)) {
				modelsByReferencedModel.put(referencedModel, new HashSet<Model>());
			}
			
			modelsByReferencedModel.get(referencedModel).add(model);
		}
	}	

	public void modelMoved(Model original, Model moved) {
		final String nsUri = modelToNsUri.remove(original);
		
		modelToNsUri.put(moved, nsUri);
		modelsByNsUri.get(nsUri).remove(original);
		modelsByNsUri.get(nsUri).add(moved);
		
		
		final Set<Model> referencedModels = modelToReferencedModels.remove(original);
		
		modelToReferencedModels.put(moved, referencedModels);
		
		for (Model referencedModel : referencedModels) {
			modelsByReferencedModel.get(referencedModel).remove(original);
			modelsByReferencedModel.get(referencedModel).add(moved);
		}
	}

	public void modelRemoved(Model model) {
		modelToNsUri.remove(model);
		
		final String nsUri = model.getNsUri();
		
		if (modelsByNsUri.containsKey(nsUri)) {
			modelsByNsUri.get(nsUri).remove(model);
		}
		
		for (Model referencedModel : model.getAllReferencedModels()) {
			if (modelsByReferencedModel.containsKey(referencedModel)) {
				modelsByReferencedModel.get(referencedModel).remove(model);
			}
		}
	}
}
