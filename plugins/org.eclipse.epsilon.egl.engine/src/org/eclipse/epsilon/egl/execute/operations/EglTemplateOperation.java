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

package org.eclipse.epsilon.egl.execute.operations;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.internal.EglPreprocessorContext;
import org.eclipse.epsilon.egl.output.IOutputBuffer;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class EglTemplateOperation extends EglOperation {

	public EglTemplateOperation(AST ast) {
		super(ast);
	}
	
	@Override
	protected Object executeBody(IEolContext context) throws EolRuntimeException {
		final IEglContext parentContext = ((EglPreprocessorContext)context).getEglContext();
		final IOutputBuffer out = new OutputBuffer(parentContext);
		context.getFrameStack().put(Variable.createReadOnlyVariable("out", out));
		super.executeBody(context);
		return new Return(out.toString());
	}
	
}
 