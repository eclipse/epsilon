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
package org.eclipse.epsilon.test.builtins;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.junit.Test;


public abstract class CanAccessBuiltinsTests {
	
	@Test
	public void builtinVariableShouldBeAvailable() throws Exception {
		final IEolLibraryModule module = createModule();
		module.parse(getProgram());
		
		final ByteArrayOutputStream printed = new ByteArrayOutputStream();
		module.getContext().setOutputStream(new PrintStream(printed));
		
		execute(module);
		
		assertEquals(getExpectedPrintedValue(), printed.toString());
	}
	
	protected abstract IEolLibraryModule createModule() throws Exception;
	protected abstract File getProgram() throws Exception;
	protected abstract String getExpectedPrintedValue() throws Exception;
	
	protected void execute(IEolLibraryModule module) throws EolRuntimeException {
		if (module instanceof IEolExecutableModule) {
			((IEolExecutableModule)module).execute();
		
		} else {
			throw new IllegalArgumentException("CanAccessBuiltins does not know how to execute the following module. (Please override this method). " + module);
		}
	}
}
