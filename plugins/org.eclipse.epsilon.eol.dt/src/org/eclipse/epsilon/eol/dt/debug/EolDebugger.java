package org.eclipse.epsilon.eol.dt.debug;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.ExecutionController;
import org.eclipse.epsilon.eol.parse.EolParser;

public class EolDebugger implements ExecutionController {
	
	protected IDebugTarget target = null;
	protected boolean stepping = false;
	protected HashMap<String, IFile> iFiles = new HashMap<String, IFile>();
	protected ArrayList<Integer> expressionOrStatementBlockContainers = new ArrayList<Integer>();
	protected ArrayList<Integer> structuralBlocks = new ArrayList<Integer>();
	
	public EolDebugger() {
		expressionOrStatementBlockContainers.add(EolParser.HELPERMETHOD);
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

	public Object debug(IEolExecutableModule module) throws EolRuntimeException {
		return module.execute();
	}
	
	protected AST getParent(AST ast) {
		if (ast == null) return null;
		else return (AST) ast.getParent();
	}
	
	protected AST getGrandparent(AST ast) {
		return getParent(getParent(ast));
	}
	
	protected boolean isExpressionOrStatementBlockContainer(AST ast) {
		if (ast == null) return false;
		return getExpressionOrStatementBlockHolders().contains(ast.getType());
	}
	
	protected boolean isStructuralBlock(AST ast) {
		if (ast == null) return false;
		else return structuralBlocks.contains(ast.getType());
	}
	
	protected boolean isContainedExpression(AST ast) {
		AST parent = getParent(ast);
		if (parent == null) return false;
		return isExpressionOrStatementBlockContainer(parent) && parent.getChildCount() == 1;
	}
	
	protected boolean isFirstStatement(AST ast) {
		AST parent = getParent(ast);
		if (parent == null) return false;
		if (parent.getType() != EolParser.BLOCK) return false;
		AST grandparent = getParent(parent);
		if (!isExpressionOrStatementBlockContainer(grandparent)) return false;
		return parent.getFirstChild() == ast;
	}
	
	protected boolean isStatement(AST ast) {
		AST parent = getParent(ast);
		if (parent == null) return false;
		return parent.getType() == EolParser.BLOCK;
	}
	
	protected boolean controls(AST ast, IEolContext context) {
		
		// Top level element or block
		if (ast.getParent() == null || ast.getType() == EolParser.BLOCK) return false;
		return isStatement(ast) || isContainedExpression(ast);
		
	}
	
	public void control(AST ast, IEolContext context) {

		if (!controls(ast, context)) return;
		
		IFile file = getIFile(ast.getFile());
		
		if (stepping) {
			stepping = false; suspend(file, ast);
		}
		else if (hasBreakpoint(ast)) {
			suspend(file, ast);
		}
		
		if (target.isTerminated()) return;
	}
	
	protected ArrayList<Integer> getExpressionOrStatementBlockHolders() {
		return expressionOrStatementBlockContainers;
	}
	
	public void suspend(IFile file, AST ast) {
		try {
//			System.err.println("Suspending at: " + ast);
			target.suspend();
			EclipseUtil.openEditorAt(file, getRealLine(ast.getLine()), 1, false);
			while (target.isSuspended() && !stepping) { System.err.print(""); }
		}
		catch (Exception ex) { }
		
	}
	
	public boolean hasBreakpoint(AST ast) {
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
	
	public boolean hasBreakpointItself(AST ast) {
		IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(EolDebugConstants.MODEL_IDENTIFIER);
		
		for (IBreakpoint breakpoint : breakpoints) {
			
			IMarker marker = breakpoint.getMarker();
			
			if (marker.getResource().equals(getIFile(ast.getFile())) && 
					marker.getAttribute(IMarker.LINE_NUMBER, 0) == 
						getRealLine(ast.getLine())) {
				return true;
			}
			
		}
		return false;
	}
	
	protected int getRealLine(int line) {
		return line;
	}

	public boolean isTerminated() {
		return target.isTerminated();
	}

	public void report(IEolContext context) {
		
	}

	public void dispose() {
		target = null;
	}

	protected IFile getIFile(File file) {
		
		IFile iFile = iFiles.get(file.getAbsolutePath());
		if (iFile == null) {
			iFile = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(file.toURI())[0];
			iFiles.put(file.getAbsolutePath(), iFile);
		}
		return iFile;
	}

}
