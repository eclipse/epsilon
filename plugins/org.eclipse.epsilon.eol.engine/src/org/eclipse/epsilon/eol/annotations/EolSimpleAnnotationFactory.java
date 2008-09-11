/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.annotations;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;


public class EolSimpleAnnotationFactory {
	
	public static List<EolSimpleAnnotation> createSimpleAnnotations(AST ast) {
		
		List<EolSimpleAnnotation> annotations = new ArrayList<EolSimpleAnnotation>();
		
		String str = ast.getText().trim();
		int spaceIndex = str.indexOf(" ");
		int commaIndex = str.indexOf(",");
		
		String names = "";
		String value = "";
		
		if (spaceIndex == -1) {
			names = str.substring(1, str.length());
			value = "";
		}
		else {
			names = str.substring(1, spaceIndex);
			value = str.substring(spaceIndex + 1, str.length());
		}
		
		for (String name : names.split(",")) {
			EolSimpleAnnotation annotation = new EolSimpleAnnotation(ast, name, value);
			annotations.add(annotation);
		}
		
		return annotations;
	}
	
}
