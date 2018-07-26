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

import static org.eclipse.epsilon.concordance.dt.ConcordanceNature.hasConcordanceNature;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.concordance.model.CrossReference;
import org.eclipse.epsilon.concordance.model.CrossReferenceVisitor;
import org.eclipse.epsilon.concordance.model.IConcordanceModel;
import org.eclipse.epsilon.concordance.model.ConcordanceModelFactory;
import org.eclipse.epsilon.concordance.model.ModelVisitor;

public class BruteForceConcordanceIndex implements ConcordanceIndex {
	
	public void visitAllInstancesOf(String nsUri, ModelVisitor visitor) {
		for (IConcordanceModel model : findAllModels()) {
			if (model.isInstance(nsUri)) {
				visitor.visit(model);
			}
		}
	}

	private Collection<IConcordanceModel> findAllModels() {
		try {
			final Collection<IConcordanceModel> models = new LinkedList<IConcordanceModel>();
			
			for (IFile modelFile : new FileLocator("model").findAllMatchingFiles(workspaceRoot())) {
				if (hasConcordanceNature(modelFile.getProject())) {
					models.add(ConcordanceModelFactory.createModel(modelFile));
				}
			}
			
			return models;
		
		} catch (CoreException e) {
			LogUtil.log("Error encountered while locating all models in the workspace.", e);
			
			return Collections.emptyList();
		}
	}

	private IWorkspaceRoot workspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	
	
	public void visitAllCrossReferencesWithTarget(IConcordanceModel target, CrossReferenceVisitor visitor) {
		for (IConcordanceModel model : findAllModels()) {
			for (CrossReference xref : model.getAllCrossReferences()) {
				if (xref.target.model.equals(target)) {
					visitor.visit(xref);
				}
			}
		}
	}

	public void visitAllModelsWithCrossReferencesTo(IConcordanceModel target, ModelVisitor visitor) {
		for (IConcordanceModel model : findAllModels()) {
			for (CrossReference xref : model.getAllCrossReferences()) {
				if (xref.target.model.equals(target)) {
					visitor.visit(xref.source.model);
					break;
				}
			}
		}
	}
}
