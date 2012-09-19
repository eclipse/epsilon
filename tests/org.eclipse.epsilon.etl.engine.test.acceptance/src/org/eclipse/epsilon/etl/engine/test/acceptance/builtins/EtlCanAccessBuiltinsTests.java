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
package org.eclipse.epsilon.etl.engine.test.acceptance.builtins;

import java.io.File;

import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.test.builtins.CanAccessBuiltinsTests;

public class EtlCanAccessBuiltinsTests extends CanAccessBuiltinsTests {

	@Override
	protected IEolLibraryModule createModule() {
		return new EtlModule();
	}

	@Override
	protected File getProgram() {
		return FileUtil.getFile(("System.etl"), EtlCanAccessBuiltinsTests.class);
	}

	@Override
	protected String getExpectedPrintedValue() {
		return "Running ETL";
	}		
}
