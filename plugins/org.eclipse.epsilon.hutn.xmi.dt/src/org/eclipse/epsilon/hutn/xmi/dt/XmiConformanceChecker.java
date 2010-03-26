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

import java.io.PrintStream;
import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.hutn.dt.markers.MarkerManager;
import org.eclipse.epsilon.hutn.xmi.Xmi2Hutn;
import org.eclipse.ui.PlatformUI;

public class XmiConformanceChecker {

	private final ConformanceReporter informer;
	
	public XmiConformanceChecker() {
		this(initialiseInformer());
	}

	private static PrintStreamConformanceInformer initialiseInformer() {
		final PrintStream printStream;
		
		if (PlatformUI.isWorkbenchRunning()) {
			printStream = EpsilonConsole.getInstance().getInfoStream();
		} else {
			printStream = System.out;
		}
		
		return new PrintStreamConformanceInformer(printStream);
	}
	
	public XmiConformanceChecker(ConformanceReporter informer) {
		this.informer = informer;
	}
	
	public void reportConformanceOf(IResource resource) {		
		try {
			final Collection<ParseProblem> conformanceProblems = new Xmi2Hutn(resource.getRawLocationURI()).checkConformanceWithRegisteredMetamodel();
			
			new MarkerManager(resource).replaceErrorMarkers(conformanceProblems);
			
			if (conformanceProblems.isEmpty()) {
				informOfConformance(resource.getName());
			}
			
		} catch (Exception e) {
			LogUtil.log("Error encountered while checking the conformance of: " + resource.getName(), e);
		}
	}
	
	private void informOfConformance(String name) {
		informer.reportConformant(name);
	}
	
	
	public static interface ConformanceReporter {
		public void reportConformant(String name);
	}
	
	private static class PrintStreamConformanceInformer implements ConformanceReporter {

		private final PrintStream printStream;
		
		public PrintStreamConformanceInformer(PrintStream printStream) {
			this.printStream = printStream;
		}

		public void reportConformant(String name) {
			printStream.println(name + " conforms to its registered metamodel.");			
		}
	}
}
