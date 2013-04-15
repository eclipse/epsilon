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
package org.eclipse.epsilon.concordance.dt;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.nature.BuilderConfiguringNature;

public class ConcordanceNature extends BuilderConfiguringNature {

	public static final String ID = "org.eclipse.epsilon.concordance.nature.ConcordanceNature";

	@Override
	protected String getBuilderID() {
		return ConcordanceBuilder.ID;
	}
	
	public static boolean hasConcordanceNature(IProject project) throws CoreException {
		return project.isOpen() && project.hasNature(ConcordanceNature.ID);
	}

	@Override
	public void configure() throws CoreException {
		super.configure();
		ConcordancePlugin.getDefault().getMetamodelChangeReporterScheduler().schedule();
	}
}
