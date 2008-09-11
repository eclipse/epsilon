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
package org.eclipse.epsilon.eol;

import java.io.File;

import org.eclipse.epsilon.commons.parse.Antlr3TreeViewer;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EolWorkbench {
	
	
	public static void main(String[] args) throws Exception {
		
		EolModule module = new EolModule();
		
		String path = "E:\\Projects\\Eclipse\\3.3\\workspace\\org.eclipse.epsilon.eol.engine\\src\\org\\eclipse\\epsilon\\eol\\test.eol";		
		module.parse(new File(path));
		
		try {
			module.execute();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			new Antlr3TreeViewer(module.getAst(), EolParser.class);
		}
	}
	
}
