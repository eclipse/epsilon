/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildListener;

public abstract class BuildFinishedListener implements BuildListener{
	
	public abstract void buildFinished(BuildEvent event);

	public void buildStarted(BuildEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void messageLogged(BuildEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void targetFinished(BuildEvent event) {
		// TODO Auto-generated method stub
	}

	public void targetStarted(BuildEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void taskFinished(BuildEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void taskStarted(BuildEvent event) {
		// TODO Auto-generated method stub
		
	}

}
