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
package org.eclipse.epsilon.eol.userinput;

import java.io.InputStream;
import java.io.PrintStream;

public class JavaConsoleUserInput extends ConsoleUserInput {

	@Override
	public InputStream getInputStream() {
		return System.in;
	}

	@Override
	public PrintStream getOutputStream() {
		return System.out;
	}

	@Override
	public PrintStream getErrorStream() {
		return System.err;
	}
	
}
