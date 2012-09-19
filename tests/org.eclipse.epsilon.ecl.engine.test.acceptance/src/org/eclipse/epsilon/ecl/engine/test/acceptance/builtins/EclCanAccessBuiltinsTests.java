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
package org.eclipse.epsilon.ecl.engine.test.acceptance.builtins;

import java.io.File;

import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.test.builtins.CanAccessBuiltinsTests;

public class EclCanAccessBuiltinsTests extends CanAccessBuiltinsTests {

	@Override
	protected IEolLibraryModule createModule() {
		return new EclModule();
	}

	@Override
	protected File getProgram() {
		return FileUtil.getFile(("System.ecl"), EclCanAccessBuiltinsTests.class);
	}

	@Override
	protected String getExpectedPrintedValue() {
		return "Running ECL";
	}
}
