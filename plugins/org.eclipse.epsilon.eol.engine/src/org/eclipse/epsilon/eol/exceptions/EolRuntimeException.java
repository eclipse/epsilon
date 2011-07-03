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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class EolRuntimeException extends Exception{
	
	protected AST ast = null;
	protected String reason = "";
	protected IEolContext context = null;
	
	public EolRuntimeException(){
		
	}

	public EolRuntimeException(String reason){
		super(reason);
		this.reason = reason;
	}

	public EolRuntimeException(String reason, AST ast) {
		super(reason);
		this.ast = ast;
		this.reason = reason;
	}
	
	public AST getAst() {
		return ast;
	}

	
	public void setAst(AST ast) {
		this.ast = ast;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public int getLine(){
		if (getAst() != null) return getAst().getLine();
		else return 0;
	}
	
	public int getColumn(){
		if (getAst() != null) return getAst().getColumn();
		else return 0;
	}
	
	@Override
	public String getMessage() {
		String str = getReason().replace('(','[').replace(')',']');
		if (getAst() != null) {
			str += " (";
		}
		if (getAst() != null && getAst().getFile() != null) {
			str += getAst().getFile().getAbsolutePath() + "@" ;
		}
		if (getAst() != null) {
			str += getLine() + ":" + getColumn() + ")";
		}
		return str;

	}
	
	@Override
	public String toString(){
		return getMessage();
	}
}
