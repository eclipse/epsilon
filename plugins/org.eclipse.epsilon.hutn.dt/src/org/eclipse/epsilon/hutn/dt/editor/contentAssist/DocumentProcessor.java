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
import java.util.Collections;

import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.hutn.dt.editor.EmfMetamodelDirectory;
import org.eclipse.epsilon.hutn.model.hutn.NsUri;
import org.eclipse.epsilon.hutn.parse.spec.HutnPreamble;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

public class DocumentProcessor {

	private final LastWordLocator locator = new LastWordLocator();
	
	public Collection<String> classifierNames(IDocument doc) {
		try {
			final Collection<NsUri> nsUris = new HutnPreamble().process(doc.get()).getNsUris();
			
			return new EmfMetamodelDirectory(nsUris).concreteClassNames();
		
		} catch (EolModelLoadingException e) {
			return Collections.emptyList();
		}
	}
	
	public String lastWord(IDocument doc, int offset) {
		return locator.lastWord(getDocumentText(doc, offset));
	}

	private String getDocumentText(IDocument doc, int offset) {
		try {
			return doc.get(0, offset);
		
		} catch (BadLocationException e) {
			throw new IllegalArgumentException("Offset, " + offset + " is past the end of this document, length: " + doc.getLength());
		}
	}
}
