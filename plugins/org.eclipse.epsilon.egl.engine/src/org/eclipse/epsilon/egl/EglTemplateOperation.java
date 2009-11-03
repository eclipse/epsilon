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

package org.eclipse.epsilon.egl;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolReturnException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class EglTemplateOperation extends EolOperation{

	public EglTemplateOperation() {
		super();
	}

	public EglTemplateOperation(AST ast) {
		super(ast);
	}
	
	@Override
	protected Object executeBody(IEolContext context) throws EolRuntimeException {
		OutputBuffer out = new OutputBuffer();
		context.getFrameStack().put(Variable.createReadOnlyVariable("out", out));
		super.executeBody(context);
		return new Return(out.toString());
		//throw new EolReturnException(this.getBody(), out.toString());
	}
	
}
 