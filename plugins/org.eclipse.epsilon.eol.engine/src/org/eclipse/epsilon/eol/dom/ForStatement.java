/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.dom;

import java.util.Collection;
import java.util.Iterator;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.compile.context.IEolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolBreakException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolContinueException;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.EolType;

public class ForStatement extends Statement {
	
	protected Parameter iteratorParameter;
	protected Expression iteratedExpression;
	protected StatementBlock bodyStatementBlock;
	
	public ForStatement() {}
	
	public ForStatement(Parameter iteratorParameter, Expression iteratedExpression, StatementBlock bodyStatementBlock) {
		this.iteratorParameter = iteratorParameter;
		this.iteratedExpression = iteratedExpression;
		this.bodyStatementBlock = bodyStatementBlock;
	}

	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		iteratorParameter = (Parameter) module.createAst(cst.getFirstChild(), this);
		iteratedExpression = (Expression) module.createAst(cst.getSecondChild(), this);
		bodyStatementBlock = toStatementBlock(module.createAst(cst.getThirdChild(), this));
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public Return execute(IEolContext context) throws EolRuntimeException {
		
		ExecutorFactory executorFactory = context.getExecutorFactory();
		Object iteratedObject = executorFactory.execute(this.iteratedExpression, context);
		
		Collection<Object> iteratedCol = null;
		Iterator<?> it = null;
		
		if (iteratedObject instanceof Collection<?>) {
			iteratedCol = (Collection<Object>) iteratedObject;
		}
		//TODO: Reduce duplication between here and EolCollection.asCollection
		else if (iteratedObject instanceof Iterable) {
			iteratedCol = CollectionUtil.iterate((Iterable) iteratedObject);
		}
		else if (iteratedObject instanceof EolModelElementType) {
			iteratedCol = CollectionUtil.createDefaultList(); 
			iteratedCol.addAll(((EolModelElementType) iteratedObject).all());
		}
		else if (iteratedObject instanceof Iterator) {
			it = (Iterator<?>) iteratedObject;
		}
		else {
			iteratedCol = CollectionUtil.createDefaultList();
			iteratedCol.add(iteratedObject);
		}
		
		EolType iteratorType = iteratorParameter.getType(context);
		if (it == null) it = iteratedCol.iterator();

		boolean loopBroken = false;
		
		FrameStack frameStack = context.getFrameStack();
		
		for (int loop = 1; it.hasNext() && !loopBroken;) {
			Object next = it.next();
			
			if (!iteratorType.isKind(next)) continue;
			frameStack.enterLocal(FrameType.UNPROTECTED, this,
				new Variable(iteratorParameter.getName(), next, iteratorType),
				new Variable("hasMore", it.hasNext(), EolPrimitiveType.Boolean, true),
				new Variable("loopCount", loop++, EolPrimitiveType.Integer, true)
			);
			
			Object result = null; 
			
			try {
				result = executorFactory.execute(bodyStatementBlock, context);
				frameStack.leaveLocal(this);
			}
			catch (EolBreakException ex) {
				loopBroken = true;
				frameStack.leaveLocal(this);
				if (ex.isBreaksAll() && frameStack.isInLoop()) {
					throw ex;
				}
			}
			catch (EolContinueException cex) {
				frameStack.leaveLocal(this);
			}
			
			if (result instanceof Return) {
				return (Return) result;
			}
			
		}
		
		return null;
	}
	
	@Override
	public void compile(IEolCompilationContext context) {
		//TODO: Fix iterator type
		iteratedExpression.compile(context);
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, bodyStatementBlock, 
				new Variable("loopCount", EolPrimitiveType.Integer), 
				new Variable("hasMore", EolPrimitiveType.Boolean)
		);
		
		iteratorParameter.compile(context);
		bodyStatementBlock.compile(context);
		context.getFrameStack().leaveLocal(bodyStatementBlock);
		
		if (iteratedExpression.hasResolvedType() && !(iteratedExpression.getResolvedType() instanceof EolCollectionType)) {
			context.addErrorMarker(iteratedExpression, "Collection expected instead of " + iteratedExpression.getResolvedType());
		}
	}
	
	public Expression getIteratedExpression() {
		return iteratedExpression;
	}
	
	public void setIteratedExpression(Expression iteratedExpression) {
		this.iteratedExpression = iteratedExpression;
	}
	
	public Parameter getIteratorParameter() {
		return iteratorParameter;
	}
	
	public void setIteratorParameter(Parameter iteratorParameter) {
		this.iteratorParameter = iteratorParameter;
	}
	
	public StatementBlock getBodyStatementBlock() {
		return bodyStatementBlock;
	}
	
	public void setBodyStatementBlock(StatementBlock bodyStatementBlock) {
		this.bodyStatementBlock = bodyStatementBlock;
	}
	
	public void accept(IEolVisitor visitor) {
		visitor.visit(this);
	}
}
