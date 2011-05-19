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
package org.eclipse.epsilon.eml.engine.test.acceptance.builtins;


import java.io.File;

import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.eml.EmlModule;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.test.builtins.CanAccessBuiltinsTests;

public class EmlCanAccessBuiltinsTests extends CanAccessBuiltinsTests {

	@Override
	protected IEolLibraryModule createModule() {
		return new EmlModule();
	}

	@Override
	protected File getProgram() {
		return FileUtil.getFile(("System.eml"), EmlCanAccessBuiltinsTests.class);
	}

	@Override
	protected String getExpectedPrintedValue() {
		return "Running EML";
	}
}
