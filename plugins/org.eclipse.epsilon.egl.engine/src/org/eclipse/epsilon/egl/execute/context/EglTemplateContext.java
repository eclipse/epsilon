/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.egl.execute.context;

import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.egl.traceability.Variable;
import org.eclipse.epsilon.eol.execute.context.FrameStack;

public class EglTemplateContext {

	private final Template template;
	private final OutputBuffer outputBuffer;
	private final FrameStack frameStack;

	EglTemplateContext(EglContext context, Template template) {
		this.template     = template;
		this.outputBuffer = new OutputBuffer(context);
		this.frameStack   = context.getFrameStack();
		
		addVariablesFromUserPopulate();
		addVariable("out", outputBuffer);	
	}
	
	public Template getTemplate() {
		return template;
	}
	
	public OutputBuffer getOutputBuffer() {
		return outputBuffer;
	}

	private void addVariablesFromUserPopulate() {
		for (Object child : template.getChildren()) { // FIXME a template.getVariables would make this cleaner
			if (child instanceof Variable) {
				final Variable variable = (Variable)child;
				addVariable(variable.getName(), variable.getValue());
			}
		}
	}

	private void addVariable(String name, Object value) {
		frameStack.put(org.eclipse.epsilon.eol.execute.context.Variable.createReadOnlyVariable(name, value));
	}	
}
