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

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.helper.ProjectHelper2;
import org.eclipse.epsilon.workflow.tasks.EolTask;

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
	public void runTarget(File buildFile, String targetName) throws BuildException, IOException {
		Project project = new Project();
		project.init();
		project.setProperty("ant.file", buildFile.getName());
		addTaskDefinitionsTo(project);
		project.addTaskDefinition("epsilon.eol", EolTask.class);
		ProjectHelper2.configureProject(project, buildFile);
		project.executeTarget(targetName);
	}

	protected abstract void addTaskDefinitionsTo(Project project);

	protected void assertContains(final String message, final String substr) {
		assertTrue(String.format("'%s' contains '%s'", message, substr), message.contains(substr));
	}
}