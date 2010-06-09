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

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;

public class ContentAnalyser {

	private final Model model;
	
	public ContentAnalyser(Model model) {
		this.model = model;
	}

	public boolean contains(String modelElementFragment) {
		try {
			final Resource resource = model.loadEmfResource(false);
			
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
