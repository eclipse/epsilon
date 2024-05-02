/*********************************************************************
 * Copyright (c) 2012-2024 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.debug;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.dom.Statement;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.ExecutionController;

public class EolDebugger implements ExecutionController {

	private IEpsilonDebugTarget target = null;

	protected boolean stepping = false;
	protected ModuleElement currentModuleElement;
	protected ModuleElement stopAfterModuleElement;
	protected Integer stopAfterFrameStackSizeDropsBelow;

	@Override
	public boolean isTerminated() {
		return target.isTerminated();
	}

	@Override
	public void dispose() {
		target = null;
	}

	public void setTarget(IEpsilonDebugTarget target) {
		this.target = target;
	}
	
	public IEpsilonDebugTarget getTarget() {
		return target;
	}

	protected void suspend(ModuleElement ast) {
		target.suspend(ast);
	}

	protected IEolModule getModule() {
		return target.getModule();
	}

	@Override
	public void control(ModuleElement ast, IEolContext context) {
		if (!controls(ast, context)) return;
		currentModuleElement = ast;
	
		if (stepping) {
			stepping = false;
			suspend(ast);
		}
		else if (hasBreakpoint(ast)) {
			suspend(ast);
		}
	
		if (isTerminated()) return;
	}

	@Override
	public void done(ModuleElement ast, IEolContext context) {
		if (stopAfterModuleElement != null && ast == stopAfterModuleElement) {
			stepping = true;
			stopAfterModuleElement = null;
		}
		if (stopAfterFrameStackSizeDropsBelow != null && frameStackSize() < stopAfterFrameStackSizeDropsBelow) {
			stepping = true;
			stopAfterFrameStackSizeDropsBelow = null;
		}
	}

	@Override
	public void report(IEolContext context) {
		// nothing to do
	}

	public void step() {
		stepping = true;
	}

	public void stepOver() {
		stopAfterModuleElement = currentModuleElement;
	}

	public void stepReturn() {
		stopAfterFrameStackSizeDropsBelow = frameStackSize();
	}

	private boolean controls(ModuleElement ast, IEolContext context) {
		// Top level element or block
		if (ast.getParent() == null || ast instanceof StatementBlock) return false;
		return isStatement(ast) || isContainedExpression(ast);
	}

	private int frameStackSize() {
		return getModule().getContext().getFrameStack().getFrames().size();
	}

	private ModuleElement getGrandparent(ModuleElement ast) {
		return getParent(getParent(ast));
	}

	private ModuleElement getParent(ModuleElement ast) {
		return ast != null ? ast.getParent() : null;
	}

	private boolean hasBreakpoint(ModuleElement ast) {
		if (target.hasBreakpointItself(ast)) return true;
		
		if (isFirstStatement(ast)) {
			return hasBreakpoint(getGrandparent(ast));
		}
		else if (isContainedExpression(ast)) {
			return hasBreakpoint(getParent(ast));
		}
		
		if (isStructuralBlock(getParent(ast))) {
			if (isExpressionOrStatementBlockContainer(ast)) {
				return hasBreakpoint(getParent(ast));
			}
			else if (isStructuralBlock(ast)) {
				return hasBreakpoint(getParent(ast));
			}
		}
		
		return false;
	}

	protected boolean isExpressionOrStatementBlockContainer(ModuleElement ast) {
		if (ast == null) return false;
		return ast instanceof Operation || ast instanceof ExecutableBlock<?>;
	}

	protected boolean isStructuralBlock(ModuleElement ast) {
		return false;
	}

	private boolean isContainedExpression(ModuleElement ast) {
		ModuleElement parent = getParent(ast);
		if (parent == null) return false;
		return isExpressionOrStatementBlockContainer(parent) && parent.getChildren().size() == 1;
	}

	private boolean isFirstStatement(ModuleElement ast) {
		
		ModuleElement parent = getParent(ast);
		if (parent == null) return false;
		if (!(parent instanceof StatementBlock)) return false;
		ModuleElement grandparent = getParent(parent);
		if (!isExpressionOrStatementBlockContainer(grandparent)) return false;
		return parent.getChildren().get(0) == ast;
		
	}

	private boolean isStatement(ModuleElement ast) {
		return ast instanceof Statement;
	}

	public boolean isStepping() {
		return stepping;
	}

	public ModuleElement getStopAfterModuleElement() {
		return stopAfterModuleElement;
	}

	public Integer getStopAfterFrameStackSizeDropsBelow() {
		return stopAfterFrameStackSizeDropsBelow;
	}
	
}
