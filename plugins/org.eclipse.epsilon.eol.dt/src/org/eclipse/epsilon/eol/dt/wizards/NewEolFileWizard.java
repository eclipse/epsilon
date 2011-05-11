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
package org.eclipse.epsilon.eol.dt.wizards;

import org.eclipse.epsilon.common.dt.wizards.AbstractNewFileWizard2;

public class NewEolFileWizard extends AbstractNewFileWizard2 {

	@Override
	public String getTitle() {
		return "New EOL Program";
	}

	@Override
	public String getExtension() {
		return "eol";
	}

	@Override
	public String getDescription() {
		return "This wizard creates a new EOL program file with *.eol extension";
	}
	
	/*
	@Override
	public ImageDescriptor getImageDescriptor() {
		return EolPlugin.getImageDescriptor("icons/eol.big.gif");
	}
	*/
}
