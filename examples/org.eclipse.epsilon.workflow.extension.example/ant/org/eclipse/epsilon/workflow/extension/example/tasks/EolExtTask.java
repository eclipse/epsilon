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

package org.eclipse.epsilon.workflow.extension.example.tasks;

import org.eclipse.epsilon.workflow.tasks.EolTask; 
 
public class EolExtTask extends EolTask{
	
	@Override
	protected void initialize() {
		System.err.println("Extending initialize()");
		super.initialize();
	}
	
	@Override
	protected void examine() throws Exception {
		super.examine();
		System.err.println("Extending examine()");
	}
} 
 