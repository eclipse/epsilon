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
package org.eclipse.epsilon.etl;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;

public class EtlModuleWorkbench {
	
	
	public static void main(String[] args) throws Exception {
		
		EtlModule module = new EtlModule();
		module.parse(new java.io.File(EtlModuleWorkbench.class.getResource("test.etl").toURI()));
		
		System.out.println(module.getTransformRules().size());
		
		for (ParseProblem p : module.getParseProblems()) {
			System.out.println(p.getReason());
		}
		
	}
	
}
