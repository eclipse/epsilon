package org.eclipse.epsilon.emc.csvpro;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.epsilon.eol.dom.EqualsOperatorExpression;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.GreaterEqualOperatorExpression;
import org.eclipse.epsilon.eol.dom.GreaterThanOperatorExpression;
import org.eclipse.epsilon.eol.dom.LessEqualOperatorExpression;
import org.eclipse.epsilon.eol.dom.LessThanOperatorExpression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.NotEqualsOperatorExpression;
import org.eclipse.epsilon.eol.dom.OperatorExpression;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;

public class CsvProCollectionSelectOperation extends SelectOperation {
	
	private IEolContext context;
	private Variable iterator;
	private String index;
	
	public CsvProCollectionSelectOperation(String index) {
		super();
		this.index = index;
	}

	@Override
	public Object execute(Object target, Variable iterator, Expression ast, IEolContext context,
			boolean returnOnFirstMatch) throws EolRuntimeException {

		if (!(target instanceof CsvProCollection)) {
			return super.execute(target, iterator, ast, context, returnOnFirstMatch);
		}
		try {
			this.context = context;
			this.iterator = iterator;
			if (isOptimisable(ast)) {
				return optimisedExecution((CsvProCollection)target, ast, returnOnFirstMatch);
			} else {
				// System.err.println("giving to super: "+ast.toStringTree());
				Object ret = super.execute(target, iterator, (Expression) ast, context, returnOnFirstMatch);
				// System.err.println("super returns: "+ret.getClass());
				return (Collection<Object>) ret;
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new EolRuntimeException("OptimisableCollectionSelectOperation: parseAST(iterator, ast) failed:", ast);
		}

	}

	private boolean isOptimisable(Expression ast) {
		// WE support >, <, >=, <=, == and <>
		if (!(ast instanceof EqualsOperatorExpression ||
				ast instanceof GreaterThanOperatorExpression ||
				ast instanceof GreaterEqualOperatorExpression ||
				ast instanceof LessEqualOperatorExpression ||
				ast instanceof LessThanOperatorExpression ||
				ast instanceof NotEqualsOperatorExpression)) {
			return false;
		}
		// LEFT - we should have iterator.property
		// L1. Check for a property call expression
		final OperatorExpression opExp = (OperatorExpression) ast;
		final Expression rawLOperand = opExp.getFirstOperand();
		if (!(rawLOperand instanceof PropertyCallExpression)) {
			return false;
		}
		final PropertyCallExpression lOperand = (PropertyCallExpression) rawLOperand;

		// L2. Check that we're using the iterator
		final Expression rawTargetExpression = lOperand.getTargetExpression();
		if (!(lOperand.getTargetExpression() instanceof NameExpression)) {
			return false;
		}
		final NameExpression nameExpression = (NameExpression) rawTargetExpression;
		if (!iterator.getName().equals(nameExpression.getName())) {
			return false;
		}
		// Check that we are accessing the index property
		final NameExpression propertyNameExpression = lOperand.getPropertyNameExpression();
		if (!index.equals(propertyNameExpression.getName())) {
			return false;
		}
		return true;
	}
	
	private Object optimisedExecution(CsvProCollection target, Expression ast, boolean returnOnFirstMatch) throws EolRuntimeException {
		
		final OperatorExpression opExp = (OperatorExpression) ast;
		final PropertyCallExpression lOperand = (PropertyCallExpression) opExp.getFirstOperand();
		final String attributename = lOperand.getPropertyNameExpression().getName();
		final Expression valueAST = opExp.getSecondOperand();
		Object attributevalue = null;
		try {
			attributevalue = context.getExecutorFactory().executeAST(valueAST, context);
		} catch (Exception e) {
			// if the rhs is invalid or tries to use the iterator of the select
			// (which is outside its scope) -- default to epsilon's select
			// FIXME Make message more Artisan like
			System.err.println("Warning: the RHS of the expression:\n" + ast
					+ "\ncannot be evaluated using indexing,\nas the iterator variable of the current select operation ("
					+ iterator.getName() + ") is not used in this process.\nDefaulting to Epsion's select");
		}
		if (attributevalue instanceof String) {
			String id = (String) attributevalue;
			Collection<Integer> result = null;
			if (ast instanceof EqualsOperatorExpression) {
				result = new ArrayList<>(1);
				Integer obj = target.get(id);
				if (obj != null) {
					result.add(obj);
				}
			}
			else if(ast instanceof GreaterThanOperatorExpression) {
				result = target.tailMap(id, false).values();
			}
			else if(ast instanceof GreaterEqualOperatorExpression) {
				result = target.tailMap(id, true).values();
			}
			else if(ast instanceof LessThanOperatorExpression) {
				result = target.headMap(id, false).values();
			}
			else if(ast instanceof LessEqualOperatorExpression) {
				result = target.headMap(id, true).values();
			}
			else if(ast instanceof NotEqualsOperatorExpression) {
				result = new ArrayList<>();
				result.addAll(target);
				result.remove(id);
			}
			return result;
		} else {
			return (Collection<Object>) super.execute(target, iterator, (Expression) ast, context, returnOnFirstMatch);
		}
	}

	

}
