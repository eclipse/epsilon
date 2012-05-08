/*******************************************************************************
 * Copyright (c) 2011 Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio García-Domínguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eunit.dt.cmp.emf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.diff.metamodel.ComparisonResourceSetSnapshot;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.DiffResourceSet;
import org.eclipse.emf.compare.diff.service.DiffService;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.internal.statistic.NameSimilarity;
import org.eclipse.emf.compare.match.metamodel.MatchFactory;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.MatchResourceSet;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.compare.match.metamodel.UnmatchModel;
import org.eclipse.emf.compare.match.service.MatchService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelResourceSet;
import org.eclipse.epsilon.eol.models.IAdaptableModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eunit.extensions.IModelComparator;

/**
 * Model comparator for EMF models, using EMF Compare.
 */
public class EMFModelComparator implements IModelComparator {

	@Override
	public boolean canCompare(IModel m1, IModel m2) {
		return adaptToEMF(m1) != null && adaptToEMF(m2) != null;
	}

	@Override
	public Object compare(IModel m1, IModel m2) throws Exception {
		final AbstractEmfModel emfM1 = adaptToEMF(m1);
		final AbstractEmfModel emfM2 = adaptToEMF(m2);
		if (emfM1 == null || emfM2 == null) {
			throw new IllegalArgumentException("Cannot compare non-EMF models");			
		}

		// For later viewing, we need to ensure the models are saved. If they are not, just
		// store them to a temporary file.
		final ResourceSet myResourceSet = cloneToTmpFiles(emfM1.getResource().getResourceSet());
		final ResourceSet otherResourceSet = cloneToTmpFiles(emfM2.getResource().getResourceSet());

		final HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(MatchOptions.OPTION_IGNORE_XMI_ID, true);
		MatchResourceSet match = doResourceSetMatch(myResourceSet, otherResourceSet, options);
		if (match.getUnmatchedModels().size() > 0) {
			throw new UnmatchedModelsException(match.getUnmatchedModels());
		}
		DiffResourceSet diff = DiffService.doDiff(match);
		boolean bAnyDifferences = false;
		for (DiffModel diffModel : diff.getDiffModels()) {
			if (!diffModel.getDifferences().isEmpty()) {
				bAnyDifferences = true;
			}
		}
		if (!bAnyDifferences) {
			return null;
		}

		ComparisonResourceSetSnapshot snap = DiffFactory.eINSTANCE.createComparisonResourceSetSnapshot();
		snap.setDate(new Date());
		snap.setDiffResourceSet(diff);
		snap.setMatchResourceSet(match);
		return snap;
	}

	private MatchResourceSet doResourceSetMatch(
			final ResourceSet leftResourceSet,
			final ResourceSet rightResourceSet,
			final HashMap<String, Object> options) throws InterruptedException
	{
		EcoreUtil.resolveAll(leftResourceSet);
		EcoreUtil.resolveAll(rightResourceSet);
		MatchResourceSet matchSet = MatchFactory.eINSTANCE.createMatchResourceSet();

		final List<Resource> leftResources = new ArrayList<Resource>(leftResourceSet.getResources());
		final List<Resource> rightResources = new ArrayList<Resource>(rightResourceSet.getResources());

		// Special case: just 1 model in each resource set
		if (leftResources.size() == rightResources.size() && rightResources.size() == 1) {
			addMatchModel(leftResources.get(0), rightResources.get(0), options, matchSet);
			return matchSet;
		}

		// Otherwise, we'll need to pair up the models ourselves
		for (Iterator<Resource> iLeftR = leftResources.iterator(); iLeftR.hasNext(); ) {
			 final Resource leftR = iLeftR.next();
			 final Resource matchingR = findMatchingResource(leftR, rightResources);
			 if (matchingR != null) {
				 iLeftR.remove();
				 rightResources.remove(matchingR);
				 addMatchModel(leftR, matchingR, options, matchSet);
			 }
		}
		for (Iterator<Resource> iRightR = rightResources.iterator(); iRightR.hasNext(); ) {
			final Resource rightR = iRightR.next();
			final Resource matchingR = findMatchingResource(rightR, leftResources);
			if (matchingR != null) {
				iRightR.remove();
				leftResources.remove(matchingR);
				addMatchModel(rightR, matchingR, options, matchSet);
			}
		}

		// Any remaining models are left unmatched
		for (Resource lR : leftResources) {
			UnmatchModel um = MatchFactory.eINSTANCE.createUnmatchModel();
			um.setSide(Side.LEFT);
			um.getRoots().addAll(lR.getContents());
			matchSet.getUnmatchedModels().add(um);
		}
		for (Resource rR : rightResources) {
			UnmatchModel um = MatchFactory.eINSTANCE.createUnmatchModel();
			um.setSide(Side.RIGHT);
			um.getRoots().addAll(rR.getContents());
			matchSet.getUnmatchedModels().add(um);
		}

		return matchSet;
	}

	private void addMatchModel(Resource leftResource, Resource rightResource,
			final HashMap<String, Object> options, MatchResourceSet matchSet)
			throws InterruptedException {
		MatchModel match = MatchService.doResourceMatch(leftResource, rightResource, options);
		matchSet.getMatchModels().add(match);
	}

	private Resource findMatchingResource(Resource leftR, List<Resource> rightResources)
	{
		// Try to use the EClass of the root element as a key
		final String rootEClass = getRootEClass(leftR);

		if (rootEClass != null) {
			final List<Resource> sameRootEClass = new ArrayList<Resource>();
			for (Resource r : rightResources) {
				if (rootEClass.equals(getRootEClass(r))) {
					sameRootEClass.add(r);
				}
			}
			if (sameRootEClass.size() == 1) {
				// There's only one matching element: that's it
				return sameRootEClass.get(0);
			}
			else if (sameRootEClass.size() > 1) {
				// More than one candidate: try the one with the highest name similarity
				return findMatchingResourceByNameSimilarity(leftR, sameRootEClass);
			}
		}

		// No candidates at all, or empty model? Try to use EPackages.
		return findMatchingResourceByRootEPackage(leftR, rightResources);
	}

	private Resource findMatchingResourceByRootEPackage(Resource leftR, List<Resource> rightResources) {
		final String rootEPackage = getRootEPackage(leftR);

		if (rootEPackage != null) {
			final List<Resource> sameEPackage = new ArrayList<Resource>();
			for (Resource r : rightResources) {
				if (rootEPackage.equals(getRootEPackage(r))) {
					sameEPackage.add(r);
				}
			}
			if (sameEPackage.size() == 1) {
				// One candidate: done!
				return sameEPackage.get(0);
			}
			else if (sameEPackage.size() > 1) {
				// Still need to whittle down the list somehow
				return findMatchingResourceByNameSimilarity(leftR, sameEPackage);
			}
		}

		// Still no candidates found: use name similarity as last resort
		return findMatchingResourceByNameSimilarity(leftR, rightResources);
	}

	private Resource findMatchingResourceByNameSimilarity(Resource leftR, List<Resource> rightResources) {
		// In addition to having the maximum similarity, it should also have the same file extension
		final String leftExtension = leftR.getURI().fileExtension();
	
		double maxSimilarity = -1;
		Resource maxSimR = null;
		for (Resource r : rightResources) {
			final double sim = NameSimilarity.nameSimilarityMetric(leftR.getURI().lastSegment(), r.getURI().lastSegment());
			if (leftExtension.equals(r.getURI().fileExtension()) && sim > maxSimilarity) {
				maxSimilarity = sim;
				maxSimR = r;
			}
		}
		return maxSimR;
	}

	private String getRootEPackage(Resource res) {
		TreeIterator<EObject> allContents = res.getAllContents();
		if (allContents.hasNext()) {
			return allContents.next().eClass().getEPackage().getName();
		} else {
			return null;
		}
	}

	private String getRootEClass(Resource res) {
		TreeIterator<EObject> allContents = res.getAllContents();
		if (allContents.hasNext()) {
			return allContents.next().eClass().getName();
		} else {
			return null;
		}
	}

	private AbstractEmfModel adaptToEMF(IModel model) {
		if (model instanceof AbstractEmfModel) {
			return (AbstractEmfModel)model;
		}
		else if (model instanceof IAdaptableModel) {
			return ((IAdaptableModel)model).adaptTo(AbstractEmfModel.class);
		}
		else {
			return null;
		}
	}

	/**
	 * This method is used to take a snapshot of an entire resource set. Resources which
	 * do not have platform:// URIs are saved into temporary files. Cross-references are
	 * preserved: all non-platform:// URIs are rewritten to the proper temporary files.
	 */
	private ResourceSet cloneToTmpFiles(ResourceSet resourceSet) throws IOException {
		EcoreUtil.resolveAll(resourceSet);
		ResourceSet newResourceSet = new EmfModelResourceSet();

		// Save the original non-platform URIs
		final Map<Resource, URI> originalURIMap = new HashMap<Resource, URI>();
		for (Resource res : resourceSet.getResources()) {
			if ("platform".equals(res.getURI().scheme())) {
				// skip platform: models
				continue;
			}
			originalURIMap.put(res, res.getURI());
		}

		try {
			// Map each non-platform resource to a new temporary file
			for (Resource res : originalURIMap.keySet()) {
				/*
				 * It is important to build the file names for the temporary files in a way
				 * that ensures that the 70% URI minimum similarity threshold for the default
				 * EMF Compare match engine is reached. Since creating a temporary file adds
				 * an unique suffix, it might lower the value to the point in which a false
				 * negative is produced. For this reason, we will add a long common prefix to
				 * all these temporary clones.
				 */
				File tmpFile = File.createTempFile("emf-model-comparator-clone-" + res.getURI().lastSegment() + ".", ".model");
				res.setURI(URI.createFileURI(tmpFile.getAbsolutePath()));
			}

			// Save all the non-platform resources and add them to the new resource set.
			// The platform: resources will be resolved implicitly by the comparison.
			final List<Resource> newResources = new ArrayList<Resource>(originalURIMap.size());
			for (Resource res : originalURIMap.keySet()) {
				res.save(Collections.EMPTY_MAP);
				final Resource newResource = newResourceSet.createResource(res.getURI());
				newResources.add(newResource);
			}

			// Reuse the metamodels loaded by the user in the new resource set, by
			// using the same package registry as in the original resource set.
			newResourceSet.setPackageRegistry(resourceSet.getPackageRegistry());

			// Load all the resources in the new resource set.
			for (Resource res : newResources) {
				res.load(null);
				EcoreUtil.resolveAll(res);
			}
		}
		finally {
			// Restore the original URIs to the original resource set
			for (Map.Entry<Resource, URI> entry : originalURIMap.entrySet()) {
				entry.getKey().setURI(entry.getValue());
			}
		}

		return newResourceSet;
	}

}
