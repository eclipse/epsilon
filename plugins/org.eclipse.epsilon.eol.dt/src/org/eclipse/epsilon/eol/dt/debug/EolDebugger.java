/*******************************************************************************
 * Copyright (c) 2012 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - clean up, add "step over" and "step return"
 ******************************************************************************/
package org.eclipse.epsilon.eol.dt.debug;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.EolPlugin;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.ExecutionController;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EolDebugger implements ExecutionController {
	protected ArrayList<Integer> expressionOrStatementBlockContainers = new ArrayList<Integer>();
	protected ArrayList<Integer> structuralBlocks = new ArrayList<Integer>();

	private IDebugTarget target = null;
	private boolean stepping = false;
	private HashMap<String, IFile> iFiles = new HashMap<String, IFile>();
	private AST currentAST, stopAfterAST;
	private Integer stopAfterFrameStackSizeDropsBelow;

	public EolDebugger() {
		expressionOrStatementBlockContainers.add(EolParser.HELPERMETHOD);
	}
	
	public void control(AST ast, IEolContext context) {
		if (!controls(ast, context)) return;
		IFile lastFile = getIFile(ast);
		currentAST = ast;

		if (stepping) {
			stepping = false;
			suspend(lastFile, ast);
		}
		else if (hasBreakpoint(ast)) {
			suspend(lastFile, ast);
		}
	
		if (target.isTerminated()) return;
	}

	@Override
	public void done(AST ast, IEolContext context) {
		if (stopAfterAST != null && ast == stopAfterAST) {
			stepping = true;
			stopAfterAST = null;
		}
		if (stopAfterFrameStackSizeDropsBelow != null && frameStackSize() < stopAfterFrameStackSizeDropsBelow) {
			stepping = true;
			stopAfterFrameStackSizeDropsBelow = null;
		}
	}

	public boolean isTerminated() {
		return target.isTerminated();
	}

	public void report(IEolContext context) {
		
	}

	public void dispose() {
		target = null;
	}

	public Object debug(IEolExecutableModule module) throws EolRuntimeException {
		final Object result = module.execute();
		try {
			target.terminate();
		} catch (DebugException e) {
			throw new EolRuntimeException(e.getLocalizedMessage());
		}
		return result;
	}

	public void setTarget(IDebugTarget target) {
		this.target = target;
	}
	
	public IDebugTarget getTarget() {
		return target;
	}
	
	public void step() {
		stepping = true;
	}

	public void stepOver() {
		stopAfterAST = currentAST;
	}

	public void stepReturn() {
		stopAfterFrameStackSizeDropsBelow = frameStackSize();
	}

	private boolean controls(AST ast, IEolContext context) {
		// Top level element or block
		if (ast.getParent() == null || ast.getType() == EolParser.BLOCK) return false;
		return isStatement(ast) || isContainedExpression(ast);
	}

	private int frameStackSize() {
		return ((EolDebugTarget)target).getModule().getContext().getFrameStack().getFrames().size();
	}

	private ArrayList<Integer> getExpressionOrStatementBlockHolders() {
		return expressionOrStatementBlockContainers;
	}

	private int getRealLine(int line) {
		return line;
	}

	private IFile getIFile(AST ast) {
		if (ast.getFile() != null) {
			return getIFile(ast.getFile());
		} else {
			return getIFile(ast.getUri());
		}
	}

	private IFile getIFile(File file) {
		IFile iFile = iFiles.get(file.getAbsolutePath());
		if (iFile == null) {
			iFile = getIFile(file.toURI());
			iFiles.put(file.getAbsolutePath(), iFile);
		}
		return iFile;
	}

	private IFile getIFile(URI uri) {
		// If the URI starts by platform:/resource, we need to strip that off
		// before invoking ResourcesPlugin - see bug #286017 and its patch
		final String[] uriParts = uri.toString().split("platform:/resource");
		if (uriParts.length > 1) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uriParts[1]));
		}
		return ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(uri)[0];
	}

	private AST getGrandparent(AST ast) {
		return getParent(getParent(ast));
	}
	
	private AST getParent(AST ast) {
		return ast != null ? ast.getParent() : null;
	}

	private boolean hasBreakpoint(AST ast) {
		if (hasBreakpointItself(ast)) return true;
		
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

	private boolean hasBreakpointItself(AST ast) {
		if (!DebugPlugin.getDefault().getBreakpointManager().isEnabled()) {
			// Debugging has been globally disabled
			return false;
		}

		IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(EolDebugConstants.MODEL_IDENTIFIER);
		for (IBreakpoint breakpoint : breakpoints) {
			IMarker marker = breakpoint.getMarker();
			if (marker.getResource().equals(getIFile(ast)) && marker.getAttribute(IMarker.LINE_NUMBER, 0) == getRealLine(ast.getLine())) {
				try {
					return breakpoint.isEnabled();
				} catch (CoreException e) {
					LogUtil.log(e);
					return false;
				}
			}
		}
		return false;
	}

	private boolean isExpressionOrStatementBlockContainer(AST ast) {
		if (ast == null) return false;
		return getExpressionOrStatementBlockHolders().contains(ast.getType());
	}

	private boolean isStructuralBlock(AST ast) {
		if (ast == null) return false;
		else return structuralBlocks.contains(ast.getType());
	}
	
	private boolean isContainedExpression(AST ast) {
		AST parent = getParent(ast);
		if (parent == null) return false;
		return isExpressionOrStatementBlockContainer(parent) && parent.getChildCount() == 1;
	}
	
	private boolean isFirstStatement(AST ast) {
		AST parent = getParent(ast);
		if (parent == null) return false;
		if (parent.getType() != EolParser.BLOCK) return false;
		AST grandparent = getParent(parent);
		if (!isExpressionOrStatementBlockContainer(grandparent)) return false;
		return parent.getFirstChild() == ast;
	}
	
	private boolean isStatement(AST ast) {
		AST parent = getParent(ast);
		if (parent == null) return false;
		return parent.getType() == EolParser.BLOCK;
	}
	
	private void suspend(IFile file, AST ast) {
		try {
			target.suspend();
			EclipseUtil.openEditorAt(file, getRealLine(ast.getLine()), 1, false);
			while (target.isSuspended()
					&& !stepping
					&& stopAfterAST == null
					&& stopAfterFrameStackSizeDropsBelow == null) {
				synchronized(this) {
					try {
						wait(500);
					} catch (InterruptedException ex) {
						// timeout
					}
				}
			}
		}
		catch (Exception ex) {}
	}

}
