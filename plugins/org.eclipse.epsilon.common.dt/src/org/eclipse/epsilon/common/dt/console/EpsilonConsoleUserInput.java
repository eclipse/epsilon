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
package org.eclipse.epsilon.common.dt.console;

import java.io.InputStream;
import java.io.PrintStream;

import org.eclipse.epsilon.eol.userinput.ConsoleUserInput;

public class EpsilonConsoleUserInput extends ConsoleUserInput {

	public EpsilonConsoleUserInput() {
		super();
	}

	@Override
	public InputStream getInputStream() {
		return EpsilonConsole.getInstance().getInputStream();
	}

	@Override
	public PrintStream getOutputStream() {
		return EpsilonConsole.getInstance().getDebugStream();
	}

	@Override
	public PrintStream getErrorStream() {
		return EpsilonConsole.getInstance().getErrorStream();
	}
	
}
