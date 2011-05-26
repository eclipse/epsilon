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

import org.eclipse.epsilon.eol.execute.context.Frame;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;

/**
 * Manipulates a {@link FrameStack} to provide a slightly more 
 * sophisticated semantics for EGL. Specifically, the 
 * {@link FrameStack} is manipulated as follows when a template
 * is to be executed:
 * <ol>
 * 	<li> The client calls
 *       {@link #prepareFrameStackFor(ExecutableTemplateSpecification)}
 *       to save the current global variables of the {@link FrameStack}.
 *       Note that the global variables are not cleared at this point, 
 *       and hence the specified template has access to any global 
 *       variables of its parent, unless they are overwritten. Note that
 *       {@link ExecutableTemplateSpecification#addVariablesTo(FrameStack)}
 *       is called at this point to initialise any template-specific
 *       variables, such as <code>out</code> (the template-specific
 *       global output buffer variable).</li>
 *  <li> The {@link FrameStack} is now setup for the specified
 *       template, and the client executes the template.</li>
 *  <li> The client calls {@link #restoreFrameStackToPreviousState()}
 *       to restore the previous set of global variables to the
 *       {@link FrameStack}. Any global variables created for the
 *       this template are cleared. All of the global variables
 *       saved before this template was executed are now restored
 *       to the {@link FrameStack}. The {@link FrameStack} is now
 *       setup for executing the parent template, which continues
 *       to execute.</li>
 *  </ol>
 */
public class EglFrameStackManager {

	private final FrameStack frameStack;
	private final Stack<Frame> savedGlobals = new Stack<Frame>();
	
	public EglFrameStackManager(FrameStack frameStack) {
		this.frameStack = frameStack;
	}

	public void prepareFrameStackFor(ExecutableTemplateSpecification spec) {
		saveGlobals();
		frameStack.enter(FrameType.PROTECTED, null);
		spec.addVariablesTo(frameStack);
	}

	public void restoreFrameStackToPreviousState() {
		frameStack.leave(null);
		restoreGlobals();
	}
	
	private void saveGlobals() {
		savedGlobals.push(frameStack.getGlobals().clone());
	}
	
	private void restoreGlobals() {
		frameStack.getGlobals().clear();
		frameStack.getGlobals().putAll(savedGlobals.pop().getAll());
	}
}