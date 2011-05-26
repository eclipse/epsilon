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

import java.util.Stack;

public class EglExecutionManager {

	private final EglFrameStackManager frameStackManager;
	private final ExecutableTemplateSpecificationStack specs = new ExecutableTemplateSpecificationStack();
		
	public EglExecutionManager(EglFrameStackManager frameStackManager) {
		this.frameStackManager = frameStackManager;
	}
	
	public void prepareFor(ExecutableTemplateSpecification spec) {
		specs.push(spec);
		frameStackManager.prepareFrameStackFor(spec);
	}

	public void restore() {
		frameStackManager.restoreFrameStackToPreviousState();
		specs.pop();
	}

	public ExecutableTemplateSpecification getCurrent() {
		return specs.peek();
	}

	public ExecutableTemplateSpecification getBase() {
		return specs.first();
	}
	
	
	private static class ExecutableTemplateSpecificationStack {
		
		private final Stack<ExecutableTemplateSpecification> specs = new Stack<ExecutableTemplateSpecification>();
		private ExecutableTemplateSpecification firstSpec;
		
		public void push(ExecutableTemplateSpecification template) {
			linkToPrevious(template);
			specs.push(template);
		}

		private void linkToPrevious(ExecutableTemplateSpecification template) {
			if (firstSpec == null) firstSpec = template;
			if (!specs.isEmpty()) specs.peek().addAsChild(template);
		}		
		
		public void pop() {
			specs.pop();
		}
		
		public ExecutableTemplateSpecification peek() {
			return specs.isEmpty() ? null : specs.peek();
		}
		
		public ExecutableTemplateSpecification first() {
			return firstSpec;
		}
	}
}
