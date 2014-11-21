package org.eclipse.epsilon.eol.dom;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolBreakException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolContinueException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.EolType;

public class ForStatement extends Statement {
	
	protected Parameter iterator;
	protected Expression iterated;
	protected StatementBlock body;
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		
		Object iteratedObject = context.getExecutorFactory().executeAST(this.iterated, context);
		
		Collection<Object> iteratedCol = null;
		Iterator<Object> it = null;
		
		if (iteratedObject instanceof Collection<?>){
			iteratedCol = (Collection<Object>) iteratedObject;
		}
		//TODO: Reduce duplication between here and EolCollection.asCollection
		else if (iteratedObject instanceof Iterable){
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
		
		EolType iteratorType = iterator.getType(context);
		if (it == null) it = iteratedCol.iterator();

		boolean loopBroken = false;
		
		int loop = 1;
		while (it.hasNext() && !loopBroken){
			Object next = it.next();
			
			if (!iteratorType.isKind(next)) continue;
			context.getFrameStack().enterLocal(FrameType.UNPROTECTED, this);
			
			context.getFrameStack().put(new Variable(iterator.getName(), next, iteratorType));
			context.getFrameStack().put(new Variable("hasMore", it.hasNext(), EolPrimitiveType.Boolean, true));
			context.getFrameStack().put(new Variable("loopCount", loop++, EolPrimitiveType.Integer, true));
			
			Object result = null; 
			
			try {
				result = context.getExecutorFactory().executeAST(body, context);
				context.getFrameStack().leaveLocal(this);
			}
			catch (EolBreakException ex){
				loopBroken = true;
				context.getFrameStack().leaveLocal(this);
				if (ex.isBreaksAll() && context.getFrameStack().isInLoop()){
					throw ex;
				}
			}
			catch (EolContinueException cex){
				context.getFrameStack().leaveLocal(this);
			}
			
			if (result instanceof Return) {
				return result;
			}
			
		}
		
		return null;
		
	}
	
	@Override
	public void build() {
		super.build();
		iterator = (Parameter) getFirstChild();
		iterated = (Expression) getSecondChild();
		if (getThirdChild() instanceof StatementBlock) {
			body = (StatementBlock) getThirdChild();
		}
		else {
			body = new StatementBlock();
			body.getStatements().add((Statement) getThirdChild());
		}
		
	}
	
	public Parameter getIterator() {
		return iterator;
	}
	
	public void setIterator(Parameter iterator) {
		this.iterator = iterator;
	}
	
	public Expression getIterated() {
		return iterated;
	}
	
	public void setIterated(Expression iterated) {
		this.iterated = iterated;
	}
	
	public StatementBlock getBody() {
		return body;
	}
	
	public void setBody(StatementBlock body) {
		this.body = body;
	}
}
