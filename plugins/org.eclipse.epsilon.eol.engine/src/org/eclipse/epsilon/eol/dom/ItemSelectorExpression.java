package org.eclipse.epsilon.eol.dom;

import java.util.Collection;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolType;

public class ItemSelectorExpression extends Expression {

	protected Expression targetExpression;
	protected Expression indexExpression;
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		targetExpression = (Expression) module.createAst(cst.getFirstChild(), module);
		indexExpression = (Expression) module.createAst(cst.getSecondChild(), module);
	}
	
	public Object execute(IEolContext context) throws EolRuntimeException {
		
		Object expression = context.getExecutorFactory().execute(targetExpression, context);
		Object index = context.getExecutorFactory().execute(indexExpression, context);
		
		if ((expression instanceof Collection)) {
			if (!(index instanceof Integer)) 
				throw new EolRuntimeException("Collection index must be an integer but " + index + " was provided instead.", indexExpression);
			else return CollectionUtil.asList(expression).get((Integer)index);
		}
		//else if (expression instanceof EolMap){
		//	return ((EolMap) expression).get(index);
		//}
		
		throw new EolRuntimeException(expression + " is not a collection or a map.", targetExpression);
		
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		targetExpression.compile(context);
		indexExpression.compile(context);
		
		EolType targetExpressionType = targetExpression.getResolvedType();
		if (targetExpressionType != EolAnyType.Instance) {
			if (targetExpressionType instanceof EolCollectionType) {
				resolvedType = ((EolCollectionType) targetExpressionType).getContentType();
			}
			else {
				context.addErrorMarker(indexExpression, "[...] only applies to collections");
			}
		}
		
	}
	
}
