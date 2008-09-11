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
package org.eclipse.epsilon.eol.exceptions;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.epsilon.commons.parse.AST;


public class EolInternalException extends EolRuntimeException{
	
	Throwable internal;
	
	public EolInternalException(Throwable internal){
		setStackTrace(internal.getStackTrace());
		//internal.printStackTrace();
		this.internal = internal;
	}
	
	public EolInternalException(Throwable internal, AST ast){
		setStackTrace(internal.getStackTrace());
		//internal.printStackTrace();
		this.internal = internal;
		this.ast = ast;
	}
	
	@Override
	public String getReason(){
		//return "Internal error: " + internal.getMessage() + " [" + internal.getClass().getName() + "]";
		StringOutputStream sos = new StringOutputStream();
		internal.printStackTrace(new PrintStream(sos));
		return "Internal error: " + sos.toString();
	}
	
	public Throwable getInternal() {
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

