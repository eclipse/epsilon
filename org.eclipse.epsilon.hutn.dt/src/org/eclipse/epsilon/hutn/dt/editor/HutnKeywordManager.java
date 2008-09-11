/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.hutn.dt.editor;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.emc.emf.EmfMetaModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;

final class HutnKeywordManager {
	
	private final HutnScanner scanner;
	
	private List<String> keywords;
	private List<String> cachedKeywords = new LinkedList<String>();;
	
	public HutnKeywordManager(HutnScanner scanner) {
		this.scanner = scanner;
	}
	
	private void addKeywordsFrom(IModel metamodel, String type) throws EolModelElementTypeNotFoundException {
		final Iterator<?> iterator = metamodel.getAllOfKind(type).iterator();
		
		while (iterator.hasNext()) {
			final ENamedElement element = (ENamedElement)iterator.next();
			keywords.add(element.getName());
		}
	}
	
	public boolean updateKeywordsFrom(List<String> nsUris) {
		if (nsUris == null)
			throw new IllegalArgumentException("nsUris cannot be null");
		
		keywords = new LinkedList<String>();
		
		for (String nsUri : nsUris) {
			try {
				final IModel metamodel = new EmfMetaModel(nsUri);
				metamodel.load();
				
				addKeywordsFrom(metamodel, "EClassifier");
				addKeywordsFrom(metamodel, "EPackage");
				
			} catch (EolModelLoadingException e) {
				// Ignore, as this is reported during as a parse problem
			} catch (EolModelElementTypeNotFoundException e) {
				EpsilonConsole.getInstance().getErrorStream().println("Could not find the the type EClassifier for metamodel with nsUri: " + nsUri);
			}
		}
		
		scanner.setKeywords(keywords);
		
		if (cachedKeywords.equals(keywords)) {
			return false;
		} else {
			cachedKeywords = keywords;
			return true;
		}
	}
}
