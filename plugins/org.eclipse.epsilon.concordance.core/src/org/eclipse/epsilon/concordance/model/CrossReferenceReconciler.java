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
package org.eclipse.epsilon.concordance.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.common.dt.util.LogUtil;

public class CrossReferenceReconciler {

	private final Model reconcilee;
	
	public CrossReferenceReconciler(Model reconcilee) {
		this.reconcilee = reconcilee;
	}

	public void reconcile(Model original, Model moved) {
		try {
			reconcile(new Renaming(original, moved));
		
		} catch (IOException e) {
			LogUtil.log("Error encountered whilst trying to reconcile " + reconcilee + " by changing " + original + " to " + moved, e);
		}
	}
	
	private void reconcile(Renaming renaming) throws IOException {
		final Resource res;
		
		if (renaming.isRenamed(reconcilee)) {
			res = renaming.loadResource();
			
			EcoreUtil.resolveAll(res);
			
			res.setURI(renaming.renamed.getUri());
			
		} else {
			res = reconcilee.loadEmfResource(false);
			
			final Resource renamed = renaming.loadResource();
			
			res.getResourceSet().getResources().add(renamed);
			EcoreUtil.resolveAll(res);
			
			renamed.setURI(renaming.renamed.getUri());
		}
		
		res.save(null);
	}
	
	
	private static class Renaming {
		
		public final Model original, renamed;
		
		public Renaming(Model original, Model renamed) {
			this.original = original;
			this.renamed  = renamed;
		}
		
		private boolean isRenamed(Model model) {
			return renamed.equals(model);
		}
		
		public Resource loadResource() throws FileNotFoundException, IOException {
			final Resource resource = new ResourceSetImpl().createResource(original.getUri());
			
			final FileInputStream inputStream = new FileInputStream(renamed.getResource().getRawLocation().toOSString());
			resource.load(inputStream, null);
			inputStream.close();
			
			return resource;
		}
		
	}
}
