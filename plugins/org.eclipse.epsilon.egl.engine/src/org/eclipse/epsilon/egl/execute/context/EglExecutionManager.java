/*******************************************************************************
 * Copyright (c) 2011-2019 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Sina Madani - refactoring
 ******************************************************************************/
package org.eclipse.epsilon.egl.execute.context;

import java.util.LinkedList;
import org.eclipse.epsilon.eol.execute.context.FrameStack;

class EglExecutionManager {

	private final LinkedList<ExecutableTemplateSpecification> specs = new LinkedList<>();
	private final EglFrameStackManager frameStackManager = new EglFrameStackManager();
	private ExecutableTemplateSpecification firstSpec;
	
	public void prepareFor(ExecutableTemplateSpecification spec, FrameStack frameStack) {
		if (firstSpec == null) firstSpec = spec;
		if (!specs.isEmpty()) specs.peek().addAsChild(spec);
		specs.push(spec);
		frameStackManager.prepareFrameStackFor(spec, frameStack);
	}

	public void restore() {
		frameStackManager.restoreFrameStackToPreviousState();
		specs.pop();
	}

	public ExecutableTemplateSpecification getCurrent() {
		return specs.peek();
	}
	
	public boolean hasParent() {
		return specs.size() > 1;
	}
	
	public ExecutableTemplateSpecification getParent() {
		return specs.get(specs.size()-2);
	}

	public ExecutableTemplateSpecification getBase() {
		return firstSpec;
	}
}
