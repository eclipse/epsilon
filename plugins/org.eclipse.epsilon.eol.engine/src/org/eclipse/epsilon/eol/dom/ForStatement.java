package org.eclipse.epsilon.eol.dom;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolBreakException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolContinueException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.EolType;

public class ForStatement extends Statement {
	
	protected Parameter iterator;
	protected Expression iterated;
	protected AbstractModuleElement body;
	
	@Override
	public void build() {
		super.build();
		iterator = (Parameter) getFirstChild();
		iterated = (Expression) getSecondChild();
		body = (AbstractModuleElement) getThirdChild();
	}
	
	public Parameter getIterator() {
		return iterator;
	}
	
	public Expression getIterated() {
		return iterated;
	}
	
	public AbstractModuleElement getBody() {
		return body;
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		
		AST iteratorAst = getFirstChild();
		AST iteratedCollectionAst = getFirstChild().getNextSibling();
		AST bodyAst = iteratedCollectionAst.getNextSibling();
		
		Object iterated = context.getExecutorFactory().executeAST(iteratedCollectionAst, context);
		
		Collection<Object> iteratedCol = null;
		
		if (iterated instanceof Collection){
			iteratedCol = (Collection) iterated;
		}
		//TODO: See if we can make other classes iterable as well
		//TODO: Reduce duplication between here and EolCollection.asCollection
		else if (iterated instanceof Iterable){
			iteratedCol = CollectionUtil.iterate((Iterable) iterated);
		}
		else if (iterated instanceof EolModelElementType) {
			iteratedCol = CollectionUtil.createDefaultList(); 
			iteratedCol.addAll(((EolModelElementType) iterated).all());
		}
		else {
			iteratedCol = CollectionUtil.createDefaultList();
			iteratedCol.add(iterated);
		}
		
		String iteratorName = "";
		EolType iteratorType = null;

		iteratorName = iteratorAst.getFirstChild().getText();
		AST iteratorTypeAst = iteratorAst.getFirstChild().getNextSibling();
		if (iteratorTypeAst != null) {
			iteratorType = (EolType) context.getExecutorFactory().executeAST(iteratorTypeAst, context);
		}
		else {
			iteratorType = EolAnyType.Instance;
		}
		
		Iterator<Object> li = iteratedCol.iterator();

		
		boolean loopBroken = false;
		
		//TODO : Address the case where elements are removed from the collection during iteration
		
		int loop = 1;
		while (li.hasNext() && !loopBroken){
			Object next = li.next();
			
			if (!iteratorType.isKind(next)) continue;
			// TODO: See if enter and leave should be performed inside or outside the while loop
			context.getFrameStack().enterLocal(FrameType.UNPROTECTED, this);
			
			context.getFrameStack().put(new Variable(iteratorName, next, iteratorType));
			context.getFrameStack().put(new Variable("hasMore", li.hasNext(), EolPrimitiveType.Boolean, true));
			context.getFrameStack().put(new Variable("loopCount", loop++, EolPrimitiveType.Integer, true));
			
			Object result = null; 
			
			try {
				result = ((IExecutableModuleElement) bodyAst).execute(context);
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
}
