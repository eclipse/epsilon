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
package org.eclipse.epsilon.egl.execute.context;

import org.eclipse.epsilon.egl.output.IOutputBuffer;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.egl.traceability.Variable;
import org.eclipse.epsilon.eol.execute.context.FrameStack;

public class ExecutableTemplateSpecification {
	
	public Template template;
	public IOutputBuffer outputBuffer;

	public ExecutableTemplateSpecification(Template template, IOutputBuffer outputBuffer) {
		this.template = template;
		this.outputBuffer = outputBuffer;
	}

	public void addAsChild(ExecutableTemplateSpecification child) {
		template.add(child.template);
	}
	
	public void addVariablesTo(FrameStack frameStack) {
		addOutAsGlobalVariable(frameStack);
		addTemplateVariablesAsLocalVariables(frameStack);
	}
	
	private void addOutAsGlobalVariable(FrameStack frameStack) {
		frameStack.putGlobal(createEolVariable("out", outputBuffer));
	}
	
	private void addTemplateVariablesAsLocalVariables(FrameStack frameStack) {
		for (Variable variable : template.getVariables()) {
			frameStack.put(createEolVariable(variable.getName(), variable.getValue()));
		}
	}

	private org.eclipse.epsilon.eol.execute.context.Variable createEolVariable(String name, Object value) {
		return org.eclipse.epsilon.eol.execute.context.Variable.createReadOnlyVariable(name, value);
	}
	
	@Override
	public String toString() {
		return template.toString();
	}
}