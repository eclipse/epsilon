package org.eclipse.epsilon.eol.dom;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolBreakException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolContinueException;
import org.eclipse.epsilon.eol.execute.Return;
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
	public Object execute(IEolContext context) throws EolRuntimeException {
		
		Object iteratedObject = context.getExecutorFactory().execute(this.iteratedExpression, context);
		
		Collection<Object> iteratedCol = null;
		Iterator<Object> it = null;
		
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
			it = (Iterator) iteratedObject;
		}
		else {
			iteratedCol = CollectionUtil.createDefaultList();
			iteratedCol.add(iteratedObject);
		}
		
		EolType iteratorType = iteratorParameter.getType(context);
		if (it == null) it = iteratedCol.iterator();

		boolean loopBroken = false;
		
		int loop = 1;
		while (it.hasNext() && !loopBroken) {
			Object next = it.next();
			
			if (!iteratorType.isKind(next)) continue;
			context.getFrameStack().enterLocal(FrameType.UNPROTECTED, this);
			
			context.getFrameStack().put(new Variable(iteratorParameter.getName(), next, iteratorType));
			context.getFrameStack().put(new Variable("hasMore", it.hasNext(), EolPrimitiveType.Boolean, true));
			context.getFrameStack().put(new Variable("loopCount", loop++, EolPrimitiveType.Integer, true));
			
			Object result = null; 
			
			try {
				result = context.getExecutorFactory().execute(bodyStatementBlock, context);
				context.getFrameStack().leaveLocal(this);
			}
			catch (EolBreakException ex) {
				loopBroken = true;
				context.getFrameStack().leaveLocal(this);
				if (ex.isBreaksAll() && context.getFrameStack().isInLoop()) {
					throw ex;
				}
			}
			catch (EolContinueException cex) {
				context.getFrameStack().leaveLocal(this);
			}
			
			if (result instanceof Return) {
				return result;
			}
			
		}
		
		return null;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		//TODO: Fix iterator type
		iteratedExpression.compile(context);
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, bodyStatementBlock, 
				new Variable("loopCount", EolPrimitiveType.Integer), 
				new Variable("hasMore", EolPrimitiveType.Boolean));
		
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
}
