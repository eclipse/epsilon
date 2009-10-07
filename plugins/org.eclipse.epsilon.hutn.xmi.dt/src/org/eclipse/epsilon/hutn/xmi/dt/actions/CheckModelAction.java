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

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.common.dt.actions.AbstractObjectActionDelegate;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.hutn.dt.markers.MarkerManager;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.validation.model.HutnValidator;
import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.Xmi2Hutn;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IObjectActionDelegate;

public class CheckModelAction extends AbstractObjectActionDelegate implements IObjectActionDelegate {
	
	private IFile file;
	private MarkerManager markerManager;
	private Spec hutnModel;
	
	public void run(IAction action) {
		try {
			if (getFirstElementInSelection() instanceof IFile) {
				file = (IFile)getFirstElementInSelection();
				markerManager = new MarkerManager(file);
				
				markerManager.removeMarkers();
				generateHutn();			
				checkHutn();				
			}
		} catch (Exception e) {
			EpsilonConsole.getInstance().getErrorStream().println(e.toString());
			e.printStackTrace();
		}
	}
	
	private void generateHutn() throws HutnXmiBridgeException {
		hutnModel = new Xmi2Hutn(file.getRawLocationURI()).getSpec();
	}
	
	private void checkHutn() throws Exception {		
		if (hutnModel != null) {
			final List<ParseProblem> problems = new HutnValidator().getProblemsForIntermediateModel(hutnModel);
			
			if (problems.isEmpty()) {
				EpsilonConsole.getInstance().getInfoStream().println(file.getName() + " conforms to its registered metamodel.");
			} else {						
				for (ParseProblem problem : problems) {
					markerManager.addErrorMarker(getReason(problem), problem.getLine());
				}
			}
		}
	}

	private String getReason(ParseProblem problem) {
		if ("Unrecognised classifier: UnknownType".equals(problem.getReason())) {
			return "Unable to determine the type of this model element.";
			
		} else {
			return problem.getReason();
		}
	}
}
