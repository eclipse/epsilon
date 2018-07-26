/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
		return specs.top();
	}
	
	public boolean hasParent() {
		return specs.size() > 1;
	}
	
	public ExecutableTemplateSpecification getParent() {
		return specs.second();
	}

	public ExecutableTemplateSpecification getBase() {
		return specs.bottom();
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
		
		public ExecutableTemplateSpecification top() {
			return specs.isEmpty() ? null : specs.peek();
		}
		
		/**
		 * @return the executable template specification
		 *         that is one below the top() of the stack.
		 */
		public ExecutableTemplateSpecification second() {
			return specs.elementAt(specs.size()-2);
		}
		
		public ExecutableTemplateSpecification bottom() {
			return firstSpec;
		}
		

		public int size() {
			return specs.size();
		}
	}
}
