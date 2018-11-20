/*******************************************************************************
 * Copyright (c) 2012 The University of York, Antonio García-Domínguez.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - clean up, add "step over" and "step return"
 ******************************************************************************/
package org.eclipse.epsilon.eol.dt.debug;

import java.io.File;
import java.net.URI;
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
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.dom.Statement;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.ExecutionController;

public class EolDebugger implements ExecutionController {

	private IDebugTarget target = null;
	private boolean stepping = false;
	private HashMap<String, IFile> iFiles = new HashMap<>();
	private ModuleElement currentModuleElement, stopAfterModuleElement;
	private Integer stopAfterFrameStackSizeDropsBelow;

	public EolDebugger() {}
	
	@Override
	public void control(ModuleElement ast, IEolContext context) {
		if (!controls(ast, context)) return;
		IFile lastFile = getIFile(ast);
		currentModuleElement = ast;

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
	public boolean isTerminated() {
		return target.isTerminated();
	}

	@Override
	public void report(IEolContext context) {
		
	}

	@Override
	public void dispose() {
		target = null;
	}

	public Object debug(IEolModule module) throws EolRuntimeException {
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
		return ((EolDebugTarget)target).getModule().getContext().getFrameStack().getFrames().size();
	}

	private int getRealLine(int line) {
		return line;
	}

	private IFile getIFile(ModuleElement ast) {
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

	private ModuleElement getGrandparent(ModuleElement ast) {
		return getParent(getParent(ast));
	}
	
	private ModuleElement getParent(ModuleElement ast) {
		return ast != null ? ast.getParent() : null;
	}

	private boolean hasBreakpoint(ModuleElement ast) {
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

	private boolean hasBreakpointItself(ModuleElement ast) {
		if (!DebugPlugin.getDefault().getBreakpointManager().isEnabled()) {
			// Debugging has been globally disabled
			return false;
		}

		IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(EolDebugConstants.MODEL_IDENTIFIER);
		for (IBreakpoint breakpoint : breakpoints) {
			IMarker marker = breakpoint.getMarker();
			if (marker.getResource().equals(getIFile(ast)) && marker.getAttribute(IMarker.LINE_NUMBER, 0) == getRealLine(ast.getRegion().getStart().getLine())) {
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
	
	private void suspend(IFile file, ModuleElement ast) {
		try {
			target.suspend();
			EclipseUtil.openEditorAt(file, getRealLine(ast.getRegion().getStart().getLine()), 1, false);
			while (target.isSuspended()
					&& !stepping
					&& stopAfterModuleElement == null
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
