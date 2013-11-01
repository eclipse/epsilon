/*******************************************************************************
 * Copyright (c) 2008-2013 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - store frame stack for better error reporting
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.SingleFrame;


public class EolRuntimeException extends Exception {
	private static final long serialVersionUID = 5763145956886241622L;

	// Frame stack, from innermost to outermost. Should not be null or contain null values.
	private List<AST> asts = new ArrayList<AST>();

	protected String reason = "";
	protected IEolContext context = null;
	
	public EolRuntimeException() {
		// nothing
	}

	public EolRuntimeException(String reason) {
		super(reason);
		this.reason = reason;
	}

	/**
	 * The old constructor that only saved the innermost frame.
	 */
	@Deprecated
	public EolRuntimeException(String reason, AST ast) {
		this(reason);
		this.asts.add(ast);
	}

	/**
	 * The new recommended constructor which saves the full frame stack.
	 */
	public EolRuntimeException(String reason, FrameStack stack) {
		this(reason);
		generateAstStackFrom(stack);
	}

	/**
	 * Constructor for reusing AST lists from other exceptions.
	 */
	public EolRuntimeException(String reason, List<AST> astStack) {
		this(reason);
		this.asts = new ArrayList<AST>(astStack);
	}

	/**
	 * Constructor for extra-detailed frame stacks (e.g. range start / end AST nodes).
	 */
	public EolRuntimeException(String string, AST innermostAST, FrameStack frameStack) {
		this(string, frameStack);
		if (innermostAST != null) {
			this.asts.add(0, innermostAST);
		}
	}

	/**
	 * Returns the list of AST nodes where this exception occurred, from innermost to outermost.
	 */
	public List<AST> getAstStack() {
		return asts;
	}

	/**
	 * Changes the list of AST nodes where this exception occurred, from innermost to outermost.
	 */
	public void setAstStack(List<AST> asts) {
		this.asts = asts;
	}

	/**
	 * Changes the list of AST nodes where this exception occurred.
	 */
	public void generateAstStackFrom(FrameStack stack) {
		asts.clear();
		if (stack == null) {
			return;
		}

		final List<SingleFrame> frames = stack.getFrames();
		if (!frames.isEmpty()) {
			final AST currentStatement = frames.get(0).getCurrentStatement();
			if (currentStatement != null) {
				this.asts.add(currentStatement);
			}
			for (SingleFrame f : stack.getFrames()) {
				if (f.getEntryPoint() != null) {
					this.asts.add(f.getEntryPoint());
				}
			}
		}
	}
	
	@Deprecated
	public AST getAst() {
		return asts.isEmpty() ? null : asts.get(0);
	}

	@Deprecated
	public void setAst(AST ast) {
		this.asts.clear();
		this.asts.add(ast);
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Deprecated
	public int getLine() {
		if (getAst() != null) return getAst().getLine();
		else return 0;
	}

	@Deprecated
	public int getColumn() {
		if (getAst() != null) return getAst().getColumn();
		else return 0;
	}
	
	@Override
	public String getMessage() {
		final StringBuffer sbuf = new StringBuffer();
		sbuf.append(getReason().replace('(','[').replace(')',']'));
		
		if (asts != null && !asts.isEmpty()) {
			for (AST ast : asts) {
				sbuf.append("\n  at (");
				if (ast.getFile() != null) {
					sbuf.append(ast.getFile().getAbsolutePath());
					sbuf.append("@");
				}
				else if (ast.getUri() != null) {
					sbuf.append(ast.getUri());
					sbuf.append("@");
				}
				sbuf.append(ast.getLine());
				sbuf.append(":");
				sbuf.append(ast.getColumn());
				sbuf.append(")");
			}
		}

		return sbuf.toString();
	}
	
	@Override
	public String toString() {
		return getMessage();
	}

	public static EolRuntimeException wrap(Throwable t) {
		if (t instanceof EolRuntimeException) return (EolRuntimeException) t;
		else return new EolInternalException(t);
	}

	public static void propagate(Throwable t) throws EolRuntimeException {
		throw wrap(t);
	}
}
