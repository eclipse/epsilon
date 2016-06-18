/*******************************************************************************
 * Copyright (c) 2011-2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.execute.context;

import java.net.URI;
import java.util.ArrayDeque;
import java.util.Deque;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dom.StatementBlock;
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
 *       which ensures that the global variables of the parent template
 *       (if any) are accessible to the child, unless they are overwritten.
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
 *       this template are cleared. The {@link FrameStack} is now
 *       setup for executing the parent template, which continues
 *       to execute.</li>
 *  </ol>
 */
public class EglFrameStackManager {

	private final FrameStack frameStack;
	private final Deque<ModuleElement> localMarkers = new ArrayDeque<ModuleElement>(), globalMarkers = new ArrayDeque<ModuleElement>();
	
	public EglFrameStackManager(FrameStack frameStack) {
		this.frameStack = frameStack;
	}

	public void prepareFrameStackFor(ExecutableTemplateSpecification spec) {
		createFrameForTemplateSpecificGlobals();
		createOwnFrameForLocals();
		spec.addVariablesTo(frameStack);
	}

	public void restoreFrameStackToPreviousState() {
		frameStack.leaveLocal(localMarkers.pop());
		frameStack.leaveGlobal(globalMarkers.pop());
	}
	
	private void createFrameForTemplateSpecificGlobals() {
		final StatementBlock frameGlobalStackMarker = new StatementBlock();
		//frameGlobalStackMarker.setUri(URI.create("template-specific-globals"));
		globalMarkers.push(frameGlobalStackMarker);
		frameStack.enterGlobal(FrameType.UNPROTECTED, frameGlobalStackMarker);
	}
	
	private void createOwnFrameForLocals() {
		final StatementBlock frameLocalStackMarker = new StatementBlock();
		//frameLocalStackMarker.setUri(URI.create("locals"));
		localMarkers.push(frameLocalStackMarker);
		frameStack.enterLocal(FrameType.PROTECTED, frameLocalStackMarker);
	}
}