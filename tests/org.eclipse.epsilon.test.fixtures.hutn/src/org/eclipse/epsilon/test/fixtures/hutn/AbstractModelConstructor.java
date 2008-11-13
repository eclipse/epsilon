/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id:$
 */
package org.eclipse.epsilon.test.fixtures.hutn;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.hutn.HutnModule;
import org.eclipse.epsilon.hutn.IHutnModule;
import org.eclipse.epsilon.hutn.exceptions.HutnGenerationException;

public abstract class AbstractModelConstructor<T> {
	
	private static final IHutnModule hutnModule = new HutnModule(); 
	
	protected static boolean parse(String hutn) {
		try {
			hutnModule.reset();
			
			if (hutnModule.parse(hutn)) {
				return true;	
			}
			
			for (ParseProblem problem : hutnModule.getParseProblems()) {
				System.err.println(problem);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	protected static IModel constructModel(String hutn) {
		try {
			if (parse(hutn)) {
				return hutnModule.generateEmfModel();	
			}
		} catch (HutnGenerationException e) {
			e.printStackTrace();
		} 

		return null;
	}
	
	protected static String addPreamble(String hutn, String nsUri, String configFile) {
		return addPreamble(hutn, Collections.singletonList(nsUri), Collections.singletonList(configFile));
	}
	
	protected static String addPreamble(String hutn, List<String> nsUris, List<String> configFiles) {
		String preamble = "@Spec {";
		
		for (int index = 0; index < nsUris.size(); index++) {
			preamble += "MetaModel \"MetaModel\" {";
			preamble += "	nsUri = \"" + nsUris.get(index) + "\"";
			preamble +=     getConfigFilePreamble(configFiles.get(index));
			preamble += "}";
		}
		
		preamble += "}";
		
		return preamble + hutn;
	}
	
	protected static String getConfigFilePreamble(String configFile) {
		return (configFile == null) ? "" : "configFile = \"" + configFile + "\"";
	}
	
	public T construct(String hutn) {
		final IModel model = constructModel(addPreamble(hutn, getNsUris(), getConfigFiles()));
		
		try {
			for (Object o : model.getAllOfKind(getRootElementType().getSimpleName())) {
				if (getRootElementType().isInstance(o)) {
					return getRootElementType().cast(o);
				}
			}
		} catch (EolModelElementTypeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;	
	}

	protected abstract List<String> getNsUris();
	protected abstract List<String> getConfigFiles();
	protected abstract Class<T> getRootElementType();
}
