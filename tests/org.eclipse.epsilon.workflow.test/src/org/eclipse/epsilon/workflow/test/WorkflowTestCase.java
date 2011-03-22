/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.test;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.helper.ProjectHelper2;
import org.apache.tools.ant.taskdefs.CallTarget;
import org.apache.tools.ant.taskdefs.Property;
import org.apache.tools.ant.taskdefs.optional.junit.XMLResultAggregator;
import org.eclipse.epsilon.workflow.tasks.EUnitTask;
import org.eclipse.epsilon.workflow.tasks.emf.LoadModel;

/**
 * Superclass for all test cases for the workflow classes, providing several
 * utility methods.
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public abstract class WorkflowTestCase {

	/**
	 * Runs the specified target in the provided Ant buildfile. Only some tasks
	 * are available: check the source code for details.
	 * @param buildFile Ant buildfile to be run.
	 * @param targetName Name of the target to be run.
	 * @throws BuildException The build failed.
	 */
	public void runTarget(File buildFile, String targetName) {
		Project project = new Project();
		ProjectHelper2.configureProject(project, buildFile);
		project.setProperty("ant.file", buildFile.getName());
		project.addTaskDefinition("epsilon.eunit", EUnitTask.class);
		project.addTaskDefinition("epsilon.emf.loadModel", LoadModel.class);
		project.addTaskDefinition("junitreport", XMLResultAggregator.class);
		project.addTaskDefinition("antcall", CallTarget.class);
		project.addTaskDefinition("property", Property.class);
		project.executeTarget(targetName);
	}

}
