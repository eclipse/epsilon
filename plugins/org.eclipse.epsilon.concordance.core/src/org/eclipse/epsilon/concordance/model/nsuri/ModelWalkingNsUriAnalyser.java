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
package org.eclipse.epsilon.concordance.model.nsuri;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.common.dt.util.LogUtil;

public class ModelWalkingNsUriAnalyser implements NsUriAnalyser {

	private final EObjectContainer container;

	public ModelWalkingNsUriAnalyser(EObjectContainer container) {
		this.container = container;
	}

	public Set<String> determineNsUris() {
		try {
			final Set<String> nsUris = new HashSet<String>();
			
			for (EObject object : container.getAllContents(false)) {
				nsUris.add(nsUriFor(object));
			}
							
			return nsUris;
		
		} catch (IOException e) {
			LogUtil.log("Error encountered whilst trying to determine NS URI of elements in: " + container, e);
			return Collections.emptySet();
		}
	}

	private String nsUriFor(EObject object) {
		return object.eClass().getEPackage().getNsURI();
	}
}
