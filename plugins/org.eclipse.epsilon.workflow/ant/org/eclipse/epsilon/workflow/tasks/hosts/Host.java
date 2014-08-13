/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks.hosts;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eunit.EUnitModule;

public interface Host {
	
	public boolean isRunning();
	
	public void initialise();
	
	public void addNativeTypeDelegates(IEolExecutableModule module);
	
	public void addStopCapabilities(Project project, IEolExecutableModule module);

	public boolean supportsDebugging();
	
	public Object debug(IEolExecutableModule module, File file) throws Exception;
	
	public void configureUserInput(IEolExecutableModule module, boolean isGui);

	public IModel createModel(String type) throws BuildException;

	public void addEUnitListeners(EUnitModule eunitModule) throws Exception;

	public void setupContext(IEolContext context);

}
