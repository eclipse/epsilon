/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
import org.eclipse.epsilon.concordance.model.IConcordanceModel;
import org.eclipse.epsilon.concordance.model.ModelVisitor;
import org.eclipse.epsilon.concordance.reporter.model.ModelChangeListener;
import org.eclipse.epsilon.concordance.reporter.model.ModelChangeReporter;

/**
 * This is a partial implementation of an in-memory index. It may not work as expected.
 */
public class InMemoryConcordanceIndex implements ConcordanceIndex, ModelChangeListener {

	final Map<IConcordanceModel, String>      modelToNsUri = new HashMap<>();
	final Map<IConcordanceModel, Set<IConcordanceModel>> modelToReferencedModels = new HashMap<>();
	
	final Map<String, Set<IConcordanceModel>> modelsByNsUri           = new HashMap<>();
	final Map<IConcordanceModel, Set<IConcordanceModel>> modelsByReferencedModel = new HashMap<>();
	
	/**
	 * @deprecated WARNING: This is a partial implementation of an in-memory index. It may not work as expected. 
	 */
	public InMemoryConcordanceIndex(ModelChangeReporter reporter) {
		reporter.addListener(this, false);
	}

	public void visitAllInstancesOf(String nsUri, ModelVisitor visitor) {
		if (!modelsByNsUri.containsKey(nsUri)) return;
		
		for (IConcordanceModel model : modelsByNsUri.get(nsUri)) {
			visitor.visit(model);
		}
	}
	
	public void visitAllModelsWithCrossReferencesTo(IConcordanceModel target, ModelVisitor visitor) {
		if (!modelsByReferencedModel.containsKey(target)) return;
		
		for (IConcordanceModel model : modelsByReferencedModel.get(target)) {
			visitor.visit(model);
		}
	}
	
	public void visitAllCrossReferencesWithTarget(IConcordanceModel target, CrossReferenceVisitor visitor) {
		// TODO Auto-generated method stub
		
	}

	public void modelAdded(IConcordanceModel model) {
		addNsUriOfModel(model, model.getNsUri());
		addReferencedModelsOfModel(model, model.getAllReferencedModels());
	}

	public void modelChanged(IConcordanceModel model) {
		final String oldNsUri = modelToNsUri.get(model);
		final String newNsUri = model.getNsUri();
		
		if (!oldNsUri.equals(newNsUri)) {
			modelsByNsUri.get(oldNsUri).remove(model);
			addNsUriOfModel(model, newNsUri);
		}
		
		final Set<IConcordanceModel> oldReferencedModels = modelToReferencedModels.get(model);
		final Set<IConcordanceModel> newReferencedModels = model.getAllReferencedModels();
				
		if (!oldReferencedModels.equals(newReferencedModels)) {
			for (IConcordanceModel oldReferencedModel : oldReferencedModels) {
				modelsByReferencedModel.get(oldReferencedModel).remove(model);
			}
			
			addReferencedModelsOfModel(model, newReferencedModels);
		}
	}
	
	private void addNsUriOfModel(IConcordanceModel model, String nsUri) {
		modelToNsUri.put(model, nsUri);
		
		if (!modelsByNsUri.containsKey(nsUri)) {
			modelsByNsUri.put(nsUri, new HashSet<IConcordanceModel>());
		}
		
		modelsByNsUri.get(nsUri).add(model);
	
	}
	
	private void addReferencedModelsOfModel(IConcordanceModel model, Set<IConcordanceModel> referencedModels) {
		modelToReferencedModels.put(model, referencedModels);
		
		for (IConcordanceModel referencedModel : referencedModels) {
			if (!modelsByReferencedModel.containsKey(referencedModel)) {
				modelsByReferencedModel.put(referencedModel, new HashSet<IConcordanceModel>());
			}
			
			modelsByReferencedModel.get(referencedModel).add(model);
		}
	}	

	public void modelMoved(IConcordanceModel original, IConcordanceModel moved) {
		final String nsUri = modelToNsUri.remove(original);
		
		modelToNsUri.put(moved, nsUri);
		modelsByNsUri.get(nsUri).remove(original);
		modelsByNsUri.get(nsUri).add(moved);
		
		
		final Set<IConcordanceModel> referencedModels = modelToReferencedModels.remove(original);
		
		modelToReferencedModels.put(moved, referencedModels);
		
		for (IConcordanceModel referencedModel : referencedModels) {
			modelsByReferencedModel.get(referencedModel).remove(original);
			modelsByReferencedModel.get(referencedModel).add(moved);
		}
	}

	public void modelRemoved(IConcordanceModel model) {
		modelToNsUri.remove(model);
		
		final String nsUri = model.getNsUri();
		
		if (modelsByNsUri.containsKey(nsUri)) {
			modelsByNsUri.get(nsUri).remove(model);
		}
		
		for (IConcordanceModel referencedModel : model.getAllReferencedModels()) {
			if (modelsByReferencedModel.containsKey(referencedModel)) {
				modelsByReferencedModel.get(referencedModel).remove(model);
			}
		}
	}
}
