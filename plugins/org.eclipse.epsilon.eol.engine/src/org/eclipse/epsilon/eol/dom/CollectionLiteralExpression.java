package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.epsilon.common.module.IModule;
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
	protected List<Expression> parameterExpressions = new ArrayList<>();
	
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
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		this.collectionType = cst.getText();
		this.range = false;
		if (cst.getFirstChild() != null) {
			for (AST parameterAst : cst.getFirstChild().getChildren()) {
				parameterExpressions.add((Expression) module.createAst(parameterAst, this));
			}
			if (cst.getFirstChild().getType() == EolParser.EXPRRANGE) {
				range = true;
			}
		}
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		
		Collection<Object> collection = null; 
		
		if (collectionType.equals("Sequence") || collectionType.equals("List")){
			collection = new EolSequence<>();
		}
		else if (collectionType.equals("Set")){
			collection = new EolSet<>();
		}
		else if (collectionType.equals("OrderedSet")){
			collection = new EolOrderedSet<>();
		}
		else {
			collection = new EolBag<>();
		}
		

		if (range) {
			Expression rangeStartExpression = parameterExpressions.get(0);
			Expression rangeEndExpression = parameterExpressions.get(1);
			
			Object rangeStart = context.getExecutorFactory().execute(rangeStartExpression, context);
			Object rangeEnd = context.getExecutorFactory().execute(rangeEndExpression, context);
			
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
				collection.add(context.getExecutorFactory().execute(parameterExpression, context));
			}
		}
		
		
		return collection;
	}

	@Override
	public void compile(EolCompilationContext context) {}

}
