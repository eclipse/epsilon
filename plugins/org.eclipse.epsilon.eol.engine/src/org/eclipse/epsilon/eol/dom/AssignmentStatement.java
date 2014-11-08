package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;

public class AssignmentStatement extends Statement {
	
	protected Expression lhs;
	protected Expression rhs;
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		AST varAst = getFirstChild();
		AST valueAst = varAst.getNextSibling();
		
		// Executing the varAst can return either a Variable
		// or a SetterMethod with one argument (set method)
		// Executing the valueAst will return an object
		
		Object varAstResult = null;
		
		if (varAst instanceof PropertyCallExpression) {
			varAstResult = ((PropertyCallExpression) varAst).execute(context, true);
		}
		else if (varAst instanceof NameExpression) {
			varAstResult = ((NameExpression) varAst).execute(context, true);
		}
		else {
			varAstResult = context.getExecutorFactory().executeAST(varAst, context);
		}
		
		Object valueAstResult = context.getExecutorFactory().executeAST(valueAst, context);
		
		if (varAstResult instanceof IPropertySetter){
			IPropertySetter setter = (IPropertySetter) varAstResult;
			try {
				Object value = getRhsEquivalent(setter.getObject(), valueAstResult, context);
				
				setter.invoke(value);
			}
			catch (EolRuntimeException ex){
				if (ex.getAst() == null) {
					ex.setAst(setter.getAst());
				}
				throw ex;
			}
		} else if (varAstResult instanceof Variable){
			Variable variable = (Variable) varAstResult;
			try {
				Object value = getRhsEquivalent(variable.getValue(), valueAstResult, context);
				variable.setValue(value, context);
			}
			catch (EolRuntimeException ex){
				ex.setAst(varAst);
				throw ex;
			}
		} else {
			throw new EolRuntimeException("Internall error. Expected either a SetterMethod or a Variable and got an " + varAstResult + "instead", this);
		}
		
		return null;
		
	}
	
	public Object getRhsEquivalent(Object source, Object value, IEolContext context) throws EolRuntimeException {
		return value;
	}
	
}
