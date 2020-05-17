/*******************************************************************************
 * Copyright (c) 2008-2011 The University of York, Antonio García-Domínguez.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - override getCause, to comply with standard API
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.epsilon.common.module.ModuleElement;

public class EolInternalException extends EolRuntimeException {
	
	Throwable internal;
	
	public EolInternalException(Throwable internal) {
		setStackTrace(internal.getStackTrace());
		//internal.printStackTrace();
		this.internal = internal;
	}
	
	public EolInternalException(Throwable internal, ModuleElement ast) {
		setStackTrace(internal.getStackTrace());
		//internal.printStackTrace();
		this.internal = internal;
		this.ast = ast;
	}
	
	@Override
	public String getReason() {
		//return "Internal error: " + internal.getMessage() + " [" + internal.getClass().getName() + "]";
		//StringOutputStream sos = new StringOutputStream();
		//internal.printStackTrace(new PrintStream(sos));
		//return "Internal error: " + sos.toString();
		return internal.getMessage();
	}
	
	public Throwable getInternal() {
		return internal;
	}

	@Override
	public Throwable getCause() {
		return internal;
	}

	class StringOutputStream extends OutputStream {

		StringBuffer buffer = new StringBuffer();
		
		@Override
		public void write(int chr) throws IOException {
			buffer.append((char) chr);
		}
		
		@Override
		public String toString() {
			return buffer.toString();
		}
	}
}

