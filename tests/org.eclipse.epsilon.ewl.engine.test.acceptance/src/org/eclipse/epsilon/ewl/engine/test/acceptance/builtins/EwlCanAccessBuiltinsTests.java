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
package org.eclipse.epsilon.ewl.engine.test.acceptance.builtins;


import java.io.File;
import java.util.List;

import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.ewl.EwlModule;
import org.eclipse.epsilon.ewl.execute.WizardInstance;
import org.eclipse.epsilon.test.builtins.CanAccessBuiltinsTests;

public class EwlCanAccessBuiltinsTests extends CanAccessBuiltinsTests {

	@Override
	protected IEolLibraryModule createModule() {
		return new EwlModule();
	}

	@Override
	protected File getProgram() {
		return FileUtil.getFile(("System.ewl"), EwlCanAccessBuiltinsTests.class);
	}

	@Override
	protected String getExpectedPrintedValue() {
		return "Running EWL";
	}
	
	@Override
	protected void execute(IEolLibraryModule module) throws EolRuntimeException {
		final List<WizardInstance> wizards = ((EwlModule)module).getWizardsFor("Running EWL");
		
		for (WizardInstance wizard : wizards) {
			wizard.process();
		}
	}
}
