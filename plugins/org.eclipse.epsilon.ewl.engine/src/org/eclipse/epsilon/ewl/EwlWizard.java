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
package org.eclipse.epsilon.ewl;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolLabeledBlock;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolNoReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.ewl.parse.EwlParser;


public class EwlWizard extends AbstractModuleElement{
	
	protected String name;
	protected EolLabeledBlock guardBlock;
	protected EolLabeledBlock bodyBlock;
	protected EolLabeledBlock titleBlock;
	
	public EwlWizard() {
		super();
	}
	
	public void build(AST ast) {
		this.ast = ast;
		this.name = ast.getText();
		this.guardBlock = new EolLabeledBlock(AstUtil.getChild(ast, EwlParser.GUARD),"guard");
		this.bodyBlock = new EolLabeledBlock(AstUtil.getChild(ast,EwlParser.DO),"do");
		this.titleBlock = new EolLabeledBlock(AstUtil.getChild(ast, EwlParser.TITLE),"title");
	}
	
	public boolean appliesTo(Object self, IEolContext context) throws EolRuntimeException{
		if (guardBlock.getAst() != null) {
			context.getFrameStack().enterLocal(FrameType.UNPROTECTED, guardBlock.getAst());
			context.getFrameStack().put(Variable.createReadOnlyVariable("self", self));
			Object result = null;
			result = context.getExecutorFactory().executeBlockOrExpressionAst(guardBlock.getAst(), context);
			if (result instanceof Return) {
				result = Return.getValue(result);
			}
			else {
				throw new EolNoReturnException("Boolean", guardBlock.getAst(), context);		
			}
		
			//context.getScope().leave(guardBlock.getAst());
			if (result instanceof Boolean){
				return ((Boolean) result);
			}
			else {
				throw new EolIllegalReturnException("Boolean",result,guardBlock.getAst(),context);
			}
		}
		else {
			return true;
		}
	}
	
	public void process(Object self, IEolContext context) throws EolRuntimeException {
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, bodyBlock.getAst());
		context.getFrameStack().put(Variable.createReadOnlyVariable("self",self));
		context.getExecutorFactory().executeAST(bodyBlock.getAst(), context);
		context.getFrameStack().leaveLocal(bodyBlock.getAst());
	}
	
	public String getTitle(Object self, IEolContext context) throws EolRuntimeException{
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, titleBlock.getAst());
		context.getFrameStack().put(Variable.createReadOnlyVariable("self",self));
		Object result = null;
		result = context.getExecutorFactory().executeBlockOrExpressionAst(titleBlock.getAst(), context);
		if (result instanceof Return) {
			result = Return.getValue(result);
		}
		else {
			throw new EolNoReturnException("String", titleBlock.getAst(), context);		
		}
		
		context.getFrameStack().leaveLocal(titleBlock.getAst());
		return String.valueOf(result);
	}
	
	@Override
	public AST getAst() {
		return ast;
	}

	public List<?> getChildren() {
		return Collections.emptyList();
	}
	
	@Override
	public String toString(){
		return name;
	}

	public String getName() {
		return name;
	}
	
}
