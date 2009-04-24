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

import org.eclipse.core.resources.IFile;
import org.eclipse.epsilon.common.dt.actions.AbstractObjectActionDelegate;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.hutn.IHutnModule;
import org.eclipse.epsilon.hutn.dt.markers.MarkerManager;
import org.eclipse.epsilon.hutn.dt.util.HutnBuilderHelper;
import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.Xmi2Hutn;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IObjectActionDelegate;

public class CheckModelAction extends AbstractObjectActionDelegate implements IObjectActionDelegate {
	
	private IFile file;
	private MarkerManager markerManager;
	private String hutn;
	
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
		hutn = new Xmi2Hutn(file.getRawLocationURI()).getHutn();
	}
	
	private void checkHutn() throws Exception {
		if (hutn != null) {
			final IHutnModule hutnModule = HutnBuilderHelper.initialiseHutnModule(file);
			
			if (hutnModule.parse(hutn)) {
				EpsilonConsole.getInstance().getInfoStream().println(file.getName() + " is consistent with its metamodel.");
			} else {						
				for (ParseProblem problem : hutnModule.getParseProblems()) {
					markerManager.addErrorMarker(problem.getReason(), 1);
				}
			}
		}
	}

}
