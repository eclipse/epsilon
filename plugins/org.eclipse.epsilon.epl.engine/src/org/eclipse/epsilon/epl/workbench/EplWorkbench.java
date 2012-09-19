/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.epl.workbench;

import java.io.File;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.epl.EplModule;
import org.eclipse.epsilon.epl.PatternMatchModel;
import org.eclipse.epsilon.epl.PatternMatcher;

public class EplWorkbench {
	
	public static void main(String[] args) throws Exception {
		/*
		EplModule module = new EplModule();
		module.parse(new File("/Users/dimitrioskolovos/Projects/Eclipse/3.7.1/workspace-new/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/workbench/library.epl"));
		
		if (module.getParseProblems().size() > 0) {
			for (ParseProblem p : module.getParseProblems()) {
				System.err.println(p);
			}
			System.exit(0);
		}
		*/
//		PlainXmlModel model = new PlainXmlModel();
//		model.setName("L");
//		model.setFile(new File("/Users/dimitrioskolovos/Projects/Eclipse/3.7.1/workspace-new/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/workbench/library.xml"));
//		model.load();
//		
//		//module.getContext().getModelRepository().addModel(model);
//		//module.getContext().setModule(module);
//		//PatternMatchModel pmm = new PatternMatcher().match(module);
//		//pmm.setName("EPL");
//		
//		EolModule eolModule = new EolModule();
//		eolModule.parse(new File("/Users/dimitrioskolovos/Projects/Eclipse/3.7.1/workspace-new/org.eclipse.epsilon.epl.engine/src/org/eclipse/epsilon/epl/workbench/calllibraryepl.eol"));
//		
//		if (eolModule.getParseProblems().size() > 0) {
//			for (ParseProblem p : eolModule.getParseProblems()) {
//				System.err.println(p);
//			}
//			System.exit(0);
//		}
//		
//		eolModule.getContext().getModelRepository().addModel(model);
//		//eolModule.getContext().getModelRepository().addModel(pmm);
//		eolModule.execute();
		
	}
	
}
