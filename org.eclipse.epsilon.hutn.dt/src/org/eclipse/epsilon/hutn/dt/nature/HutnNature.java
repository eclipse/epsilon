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
package org.eclipse.epsilon.hutn.dt.nature;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.hutn.dt.builder.HutnBuilder;

public class HutnNature implements IProjectNature {

	public static final String ID = "org.eclipse.epsilon.hutn.dt.nature.HutnNature";
	
	private IProject project;
	
	public void configure() throws CoreException {
		System.err.println("Configure on: " + project);
		
		if (!projectHasHutnBuilder()) {
			final IProjectDescription desc = project.getDescription();
			
			final ICommand hutnBuildCommand = desc.newCommand();
			hutnBuildCommand.setBuilderName(HutnBuilder.ID);
			
			
			final ICommand[] buildSpec  = desc.getBuildSpec();
			
			final ICommand[] newBuildSpec = new ICommand[buildSpec.length + 1];
			System.arraycopy(buildSpec, 0, newBuildSpec, 1, buildSpec.length);
			newBuildSpec[0] = hutnBuildCommand;
			
			desc.setBuildSpec(newBuildSpec);
			project.setDescription(desc, null);
		}
	}

	private boolean projectHasHutnBuilder() throws CoreException {
		return getHutnBuilderCommandIndex() > -1;
	}
	
	private int getHutnBuilderCommandIndex() throws CoreException {
		if (project != null) {
			final ICommand[] buildSpec = project.getDescription().getBuildSpec();
			
			for (int index = 0; index < buildSpec.length; index++) {
				if (HutnBuilder.ID.equals(buildSpec[index].getBuilderName())) {
					return index;
				}
			}
		}
		
		return -1;
	}

	public void deconfigure() throws CoreException {
		System.err.println("Deconfigure on: " + project);
		
		if (projectHasHutnBuilder()) {
			final int index = getHutnBuilderCommandIndex();;
			final IProjectDescription desc = project.getDescription();
			final ICommand[] buildSpec     = desc.getBuildSpec();
						
			final ICommand[] newBuildSpec = new ICommand[buildSpec.length - 1];
			System.arraycopy(buildSpec, 0, newBuildSpec, 0, index);
			System.arraycopy(buildSpec, index + 1, newBuildSpec, index, buildSpec.length - index - 1);
			desc.setBuildSpec(newBuildSpec);
			
			project.setDescription(desc, null);
		}

	}

	public IProject getProject() {
		return project;
	}

	public void setProject(IProject project) {
		this.project = project;
	}

}
