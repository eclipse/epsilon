package org.eclipse.epsilon.eol.dom;

import java.util.Collection;

import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.compile.context.IEolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolCollectionType;

public class DeleteStatement extends Statement {

	protected Expression expression;
	
	@Override
	public void build() {
		super.build();
		expression = (Expression) getFirstChild();
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		Object target = null;
		if (expression != null){
			target = context.getExecutorFactory().executeAST(expression, context);
		}
		
		Collection<?> col = CollectionUtil.asCollection(target);
		
		for (Object instance : EolCollectionType.clone(col)) {
			IModel model = context.getModelRepository().getOwningModel(instance);
				
			if (model != null) {
				model.deleteElement(instance);
			}
		}
		return null;
	}
	
	public Expression getExpression() {
		return expression;
	}
	
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public void compile(IEolCompilationContext context) {
		expression.compile(context);
	}
	
}
