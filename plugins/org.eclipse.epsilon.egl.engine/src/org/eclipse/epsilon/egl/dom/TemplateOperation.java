/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
******************************************************************************/
package org.eclipse.epsilon.egl.dom;

import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.output.IOutputBuffer;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class TemplateOperation extends Operation {

	@Override
	protected Return executeBody(IEolContext context) throws EolRuntimeException {
		final IEglContext eglContext = (IEglContext) context;
		final IOutputBuffer out = eglContext.newOutputBuffer();
		final String outName = "out";
		final FrameStack frameStack = context.getFrameStack();
		frameStack.put(Variable.createReadOnlyVariable(outName, out));
		super.executeBody(context);
		//frameStack.remove(outName);	
		return new Return(out.toString());
	}
	
}
 
