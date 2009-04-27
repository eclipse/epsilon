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
	
	private List<String> cachedKeywords = new LinkedList<String>();
	
	public HutnKeywordManager(HutnScanner scanner) {
		this.scanner = scanner;
	}
	
	
	public boolean updateKeywordsFrom(List<String> nsUris) {
		if (nsUris == null)
			throw new IllegalArgumentException("nsUris cannot be null");
		
		if (!keywordsHaveChanged(nsUris))
			return false;
		
		
		final List<String> keywords = getKeywordsFor(nsUris);
		scanner.setKeywords(keywords);
		cachedKeywords = keywords;
		
		return true;
	}
	
	public boolean keywordsHaveChanged(List<String> nsUris) {
		return !cachedKeywords.equals(getKeywordsFor(nsUris));
	}
	
	private List<String> getKeywordsFor(List<String> nsUris) {
		final List<String> keywords = new LinkedList<String>();

		for (String nsUri : nsUris) {
			try {
				final IModel metamodel = new EmfMetaModel(nsUri);
				metamodel.load();
				
				keywords.addAll(addKeywordsFrom(metamodel, "EClassifier"));
				keywords.addAll(addKeywordsFrom(metamodel, "EPackage"));
				
			} catch (EolModelLoadingException e) {
				// Ignore, as this is reported during as a parse problem
			} catch (EolModelElementTypeNotFoundException e) {
				EpsilonConsole.getInstance().getErrorStream().println("Could not find the the type EClassifier for metamodel with nsUri: " + nsUri);
			}
		}
		
		return keywords;
	}
	
	private List<String> addKeywordsFrom(IModel metamodel, String type) throws EolModelElementTypeNotFoundException {
		final List<String> keywords = new LinkedList<String>();
		
		final Iterator<?> iterator = metamodel.getAllOfKind(type).iterator();
		
		while (iterator.hasNext()) {
			final ENamedElement element = (ENamedElement)iterator.next();
			keywords.add(element.getName());
		}
		
		return keywords;
	}
}
