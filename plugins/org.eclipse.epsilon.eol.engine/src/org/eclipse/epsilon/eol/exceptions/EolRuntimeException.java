/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class EolRuntimeException extends Exception{
	
	protected ModuleElement ast = null;
	protected String reason = "";
	protected IEolContext context = null;
	
	public EolRuntimeException(){
		
	}

	public EolRuntimeException(String reason){
		super(reason);
		this.reason = reason;
	}

	public EolRuntimeException(String reason, ModuleElement ast) {
		super(reason);
		this.ast = ast;
		this.reason = reason;
	}
	
	public ModuleElement getAst() {
		return ast;
	}

	
	public void setAst(ModuleElement ast) {
		this.ast = ast;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public int getLine(){
		if (getAst() != null) {
			System.out.println(getAst().getParent().getParent());
			return getAst().getRegion().getStart().getLine();
		}
		else return 0;
	}
	
	public int getColumn(){
		if (getAst() != null) return getAst().getRegion().getStart().getColumn();
		else return 0;
	}
	
	@Override
	public String getMessage() {
		String str = getReason().replace('(','[').replace(')',']');
		if (ast != null && ast.getModule() instanceof IEolModule) {
			IEolContext context = ((IEolModule) ast.getModule()).getContext();
			if (context != null) {
				str = str + "\r\n" + context.getExecutorFactory().getStackTraceManager().getStackTraceAsString();
			}
		}
		return str;
	}
	
	@Override
	public String toString(){
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
