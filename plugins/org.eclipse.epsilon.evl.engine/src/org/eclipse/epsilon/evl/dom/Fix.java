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
package org.eclipse.epsilon.evl.dom;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.exceptions.EolNoReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.parse.EvlParser;


public class Fix extends AbstractModuleElement {

	protected ExecutableBlock<Boolean> guardBlock;
	protected ExecutableBlock<String> titleBlock;
	protected ExecutableBlock<Void> bodyBlock;
	
	public Fix() {
		super();
	}
	
	public void build() {
		guardBlock = (ExecutableBlock<Boolean>) AstUtil.getChild(this, EvlParser.GUARD);
		titleBlock = (ExecutableBlock<String>) AstUtil.getChild(this,EvlParser.TITLE);
		bodyBlock = (ExecutableBlock<Void>) AstUtil.getChild(this,EvlParser.DO);
	}
	
	public List getModuleElements() {
		return Collections.EMPTY_LIST;
	}
	
	public String getTitle(Object self, IEvlContext context) throws EolRuntimeException{
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, titleBlock.getBody());
		context.getFrameStack().put(Variable.createReadOnlyVariable("self",self));
		Object result = context.getExecutorFactory().executeBlockOrExpressionAst(titleBlock.getBody(), context);
		if (result instanceof Return) {
			result = Return.getValue(result);
		}
		else {
			throw new EolNoReturnException("String", titleBlock.getBody(), context);		
		}

		context.getFrameStack().leaveLocal(titleBlock.getBody());
		return String.valueOf(result);
	}
	
	public void execute(Object self, IEvlContext context) throws EolRuntimeException{
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, bodyBlock.getBody());
		context.getFrameStack().put(Variable.createReadOnlyVariable("self",self));
		context.getExecutorFactory().executeBlockOrExpressionAst(bodyBlock.getBody(), context);
		context.getFrameStack().leaveLocal(bodyBlock.getBody());
	}

	public boolean appliesTo(Object self, IEvlContext context) throws EolRuntimeException {
		if (guardBlock != null) {
			return guardBlock.execute(context, Variable.createReadOnlyVariable("self", self));
		}
		else return true;
	}
}
