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

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.simple.AbstractSimpleOperation;

public class IncludeOperation extends AbstractSimpleOperation {

	@SuppressWarnings("rawtypes")
	@Override
	public Object execute(Object source, List parameters, IEolContext context, AST ast) throws EolRuntimeException {
				
		Variable templateFactoryVariable = context.getFrameStack().get("TemplateFactory");
		EglTemplateFactory templateFactory = (EglTemplateFactory) templateFactoryVariable.getValue();
		
		Variable outVariable = context.getFrameStack().get("out");
		
		OutputBuffer out = (OutputBuffer)outVariable.getValue();
		
		String templatePath = (String) parameters.get(0);
		EglTemplate template = templateFactory.load(templatePath);
		
		try {
			String output = template.process();
			out.println(output);
		}
		catch (EglRuntimeException ex) {
			throw ex;
		}

		return null;
		
	}

}
