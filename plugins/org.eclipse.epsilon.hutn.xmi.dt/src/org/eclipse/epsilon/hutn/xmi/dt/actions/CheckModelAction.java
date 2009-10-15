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
package org.eclipse.epsilon.hutn.xmi.dt.actions;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.common.dt.actions.AbstractObjectActionDelegate;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.hutn.dt.markers.MarkerManager;
import org.eclipse.epsilon.hutn.xmi.Xmi2Hutn;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IObjectActionDelegate;

public class CheckModelAction extends AbstractObjectActionDelegate implements IObjectActionDelegate {
		
	public void run(IAction action) {
		try {
			if (getFirstElementInSelection() instanceof IFile) {
				checkConformance((IFile)getFirstElementInSelection());				
			}
		} catch (Exception e) {
			EpsilonConsole.getInstance().getErrorStream().println(e.toString());
			e.printStackTrace();
		}
	}
	
	private void checkConformance(IFile file) throws Exception {		
		final Collection<ParseProblem> conformanceProblems = new Xmi2Hutn(file.getRawLocationURI()).checkConformanceWithRegisteredMetamodel();
		
		if (conformanceProblems.isEmpty()) {
			EpsilonConsole.getInstance().getInfoStream().println(file.getName() + " conforms to its registered metamodel.");
		} else {						
			new MarkerManager(file).replaceErrorMarkers(conformanceProblems);
		}
	}
}
