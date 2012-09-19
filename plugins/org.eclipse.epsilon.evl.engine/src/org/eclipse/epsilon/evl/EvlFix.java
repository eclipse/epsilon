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
package org.eclipse.epsilon.evl;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.EolLabeledBlock;
import org.eclipse.epsilon.eol.exceptions.EolNoReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.parse.EvlParser;


public class EvlFix extends AbstractModuleElement{

	protected EvlGuard guardBlock;
	protected EolLabeledBlock titleBlock;
	protected EolLabeledBlock bodyBlock;
	
	public EvlFix() {
		super();
	}
	
	public void parse(AST ast) {
		guardBlock = new EvlGuard(AstUtil.getChild(ast, EvlParser.GUARD));
		titleBlock = new EolLabeledBlock(AstUtil.getChild(ast,EvlParser.TITLE), "title");
		bodyBlock = new EolLabeledBlock(AstUtil.getChild(ast,EvlParser.DO), "DO");
	}
	
	public List getChildren() {
		return Collections.EMPTY_LIST;
	}
	
	public String getTitle(Object self, IEvlContext context) throws EolRuntimeException{
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, titleBlock.getAst());
		context.getFrameStack().put(Variable.createReadOnlyVariable("self",self));
		Object result = context.getExecutorFactory().executeBlockOrExpressionAst(titleBlock.getAst(), context);
		if (result instanceof Return) {
			result = Return.getValue(result);
		}
		else {
			throw new EolNoReturnException("String", titleBlock.getAst(), context);		
		}

		context.getFrameStack().leaveLocal(titleBlock.getAst());
		return String.valueOf(result);
	}
	
	public void execute(Object self, IEvlContext context) throws EolRuntimeException{
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, bodyBlock.getAst());
		context.getFrameStack().put(Variable.createReadOnlyVariable("self",self));
		context.getExecutorFactory().executeBlockOrExpressionAst(bodyBlock.getAst(), context);
		context.getFrameStack().leaveLocal(bodyBlock.getAst());
	}

	public boolean appliesTo(Object self, IEvlContext context) throws EolRuntimeException {
		return guardBlock.evaluate(self, context);
	}
}
