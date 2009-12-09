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
package org.eclipse.epsilon.hutn.dt.editor.contentAssist;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.hutn.dt.editor.EmfMetamodelDirectory;
import org.eclipse.epsilon.hutn.parse.spec.HutnPreamble;

public class ContentAssistHelper {

	private final String content;
	private final String context;
	private final EmfMetamodelDirectory directory;
	
	private final LastWordLocator locator = new LastWordLocator();
	
	public ContentAssistHelper(String content) throws EolModelLoadingException {
		this.content   = content;
		this.context   = new Contextualiser().contextualise(content);
		this.directory = new EmfMetamodelDirectory(new HutnPreamble().process(content).getNsUris());
	}

	public String lastWord() {
		return locator.lastWord(content);
	}
	
	public Collection<String> computeCompletionProposals() {
		if (contextIsClass()) {
			return slotSuggestionsFor(context);
			
		} else {
			return classObjectSuggestions();
		}
	}
	
	private boolean contextIsClass() {
		return classObjectSuggestions().contains(context);
	}
	
	private Collection<String> classObjectSuggestions() {
		return directory.concreteClassNames();
	}
	
	private Collection<String> slotSuggestionsFor(String type) {
		final Collection<String> slotSuggestions = new LinkedList<String>();
		
		for (String feature : directory.featureNamesFor(type)) {
			slotSuggestions.add(feature + ": ");
		}
		
		return slotSuggestions;
	}
}
