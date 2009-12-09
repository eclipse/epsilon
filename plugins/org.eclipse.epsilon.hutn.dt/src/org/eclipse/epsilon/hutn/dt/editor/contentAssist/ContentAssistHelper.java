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

public class ContentAssistHelper {

	private final LastWordLocator locator = new LastWordLocator();
	
	public String lastWord(String text) {
		return locator.lastWord(text);
	}
	
	public Collection<String> classifierNames(String doc) {
		try {
			final Collection<NsUri> nsUris = new HutnPreamble().process(doc).getNsUris();
						
			return new EmfMetamodelDirectory(nsUris).concreteClassNames();
		
		} catch (EolModelLoadingException e) {
			return Collections.emptyList();
		}
	}
}
