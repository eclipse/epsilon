/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
