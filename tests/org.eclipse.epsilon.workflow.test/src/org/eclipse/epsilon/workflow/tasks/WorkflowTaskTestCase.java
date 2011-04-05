/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks;

import java.io.File;
import java.io.IOException;

import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.workflow.test.WorkflowTestCase;

public abstract class WorkflowTaskTestCase extends WorkflowTestCase {

	protected File antFile;

	protected void runTask(String taskStatement) throws Exception {
		final String antProject = "<project default=\"aTarget\">" + '\n' +
		      	                  	"<target name=\"aTarget\">"   + '\n' +
		      	                  		taskStatement             + '\n' +	
		      	                    "</target>"                   + '\n' +
		                          "</project>";
		
		antFile = createTemporaryFile(antProject);
		super.runTarget(antFile, "aTarget");
		antFile.delete();
	}

	private static File createTemporaryFile(String contents) throws IOException, Exception {
		final File tmp = File.createTempFile("EpsilonWorkflowTaskTest", ".xml");
		FileUtil.setFileContents(contents, tmp);
		return tmp;
	}
}