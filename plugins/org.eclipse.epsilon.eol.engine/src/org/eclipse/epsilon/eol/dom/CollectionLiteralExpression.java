package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolOrderedSet;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolSet;

public class CollectionLiteralExpression extends LiteralExpression {
	
	protected String collectionType;
	protected boolean range;
	protected List<Expression> parameterExpressions = new ArrayList<Expression>();
	
	public CollectionLiteralExpression() {}
	
	public CollectionLiteralExpression(String collectionType, Expression... parameterExpressions) {
		this.collectionType = collectionType;
		this.range = false;
		for (Expression parameterExpression : parameterExpressions) {
			this.parameterExpressions.add(parameterExpression);
		}
	}
	
	public CollectionLiteralExpression(String collectionType, boolean range, Expression... parameterExpressions) {
		this.collectionType = collectionType;
		this.range = range;
		for (Expression parameterExpression : parameterExpressions) {
			this.parameterExpressions.add(parameterExpression);
		}
	}

	@Override
	public void build() {
		super.build();
		this.collectionType = getText();
		this.range = false;
		if (getFirstChild() != null) {
			for (AST parameterAst : getFirstChild().getChildren()) {
				parameterExpressions.add((Expression) parameterAst);
			}
			if (getFirstChild().getType() == EolParser.EXPRRANGE) {
				range = true;
			}
		}
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		
		Collection<Object> collection = null; 
		
		if (collectionType.equals("Sequence") || collectionType.equals("List")){
			collection = new EolSequence<Object>();
		}
		else if (collectionType.equals("Set")){
			collection = new EolSet<Object>();
		}
		else if (collectionType.equals("OrderedSet")){
			collection = new EolOrderedSet<Object>();
		}
		else {
			collection = new EolBag<Object>();
		}
		

		if (range) {
			Expression rangeStartExpression = parameterExpressions.get(0);
			Expression rangeEndExpression = parameterExpressions.get(1);
			
			Object rangeStart = context.getExecutorFactory().executeAST(rangeStartExpression, context);
			Object rangeEnd = context.getExecutorFactory().executeAST(rangeEndExpression, context);
			
			if (rangeStart instanceof Integer && rangeEnd instanceof Integer){
				
				Integer s = (Integer) rangeStart;
				Integer e = (Integer) rangeEnd;
				
				if (s > e) {
					for (int i=s.intValue(); i>=e.intValue(); i--){
						collection.add(i);
					}											}
				else {
					for (int i=s.intValue(); i<=e.intValue(); i++){
						collection.add(i);
					}
				}
			}
			else {
				if (!(rangeStart instanceof Integer)){
					throw new EolRuntimeException("The start of a range should be of type Integer", rangeStartExpression);
				}
				if (!(rangeEnd instanceof Integer)){
					throw new EolRuntimeException("The end of a range should be of type Integer", rangeEndExpression);
				}
				
			}
		}
		else {
			for (Expression parameterExpression : parameterExpressions) {
				collection.add(context.getExecutorFactory().executeAST(parameterExpression, context));
			}
		}
		
		
		return collection;
	}

	@Override
	public void compile(EolCompilationContext context) {}

}
