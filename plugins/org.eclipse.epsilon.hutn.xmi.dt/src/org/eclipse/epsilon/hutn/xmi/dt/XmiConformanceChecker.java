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
package org.eclipse.epsilon.hutn.xmi.dt;

import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.hutn.dt.markers.MarkerManager;
import org.eclipse.epsilon.hutn.xmi.Xmi2Hutn;
import org.eclipse.ui.PlatformUI;

public class XmiConformanceChecker {

	public void reportConformanceOf(IResource resource) {		
		try {
			final Collection<ParseProblem> conformanceProblems = new Xmi2Hutn(resource.getRawLocationURI()).checkConformanceWithRegisteredMetamodel();
			
			if (conformanceProblems.isEmpty()) {
				printInfo(resource.getName() + " conforms to its registered metamodel.");
			} else {						
				new MarkerManager(resource).replaceErrorMarkers(conformanceProblems);
			}
			
		} catch (Exception e) {
			LogUtil.log("Error encountered while checking the conformance of: " + resource.getName(), e);
		}
	}
	
	private void printInfo(String msg) {
		if (PlatformUI.isWorkbenchRunning())
			EpsilonConsole.getInstance().getInfoStream().println(msg);
		else
			System.out.println(msg);
	}
}
