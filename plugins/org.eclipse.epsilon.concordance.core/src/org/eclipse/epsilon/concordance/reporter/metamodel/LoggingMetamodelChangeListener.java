/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.reporter.metamodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.concordance.index.ConcordanceIndex;

public class LoggingMetamodelChangeListener implements MetamodelChangeListener {

	public void ePackageAdded(EPackage ePackage) {
		log("EPackage added: "  + ePackage);
	}

	public void ePackageChanged(EPackage oldEPackage, EPackage newEPackage) {
		log("EPackage changed: "  + oldEPackage + " -> " + newEPackage);
	}

	public void ePackageRemoved(EPackage ePackage) {
		log("EPackage removed: "  + ePackage);
	}

	public void switchIndex(ConcordanceIndex index) {
		log("Index switched to: "  + index);
	}

	private void log(String msg) {
		System.err.println(msg);
		EpsilonConsole.getInstance().getInfoStream().println(msg);
	}

}
