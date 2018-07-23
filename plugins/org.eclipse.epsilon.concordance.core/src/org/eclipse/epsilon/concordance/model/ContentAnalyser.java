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
package org.eclipse.epsilon.concordance.model;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;

public class ContentAnalyser {

	private final IConcordanceModel model;
	
	public ContentAnalyser(IConcordanceModel model) {
		this.model = model;
	}

	public boolean contains(String modelElementFragment) {
		try {
			final Resource resource = model.getEmfResource(false);
			
			if (modelElementFragment.isEmpty()) {
				return true;
			
			} else {
				return resource.getEObject(modelElementFragment) != null;
			}
		
		} catch (IOException e) {
			return false;
		}
	}
}
