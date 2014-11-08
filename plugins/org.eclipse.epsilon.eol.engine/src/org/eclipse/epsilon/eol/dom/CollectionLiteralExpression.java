package org.eclipse.epsilon.eol.dom;

import java.util.Collection;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolOrderedSet;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolSet;

public class CollectionLiteralExpression extends LiteralExpression {

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException{
		
		Collection<Object> collection = null; 
		
		if (getText().equals("Sequence") || getText().equals("List")){
			collection = new EolSequence<Object>();
		}
		else if (getText().equals("Set")){
			collection = new EolSet<Object>();
		}
		else if (getText().equals("OrderedSet")){
			collection = new EolOrderedSet<Object>();
		}
		else {
			collection = new EolBag<Object>();
		}
		
		AST expressionListAst = getFirstChild();
		
		if (expressionListAst != null){
			
			if (expressionListAst.getType() == EolParser.EXPRLIST){
				AST statementAst = expressionListAst.getFirstChild();
				while (statementAst != null){
					Object value = context.getExecutorFactory().executeAST(statementAst, context);
					//collection.add(EolTypeWrapper.getInstance().unwrap(value));
					//collection.add(EolTypeWrapper.getInstance().wrap(value));
					collection.add(value);
					statementAst = statementAst.getNextSibling();
				}
			}
			else { // EolParserTokenTypes.EXPRRANGE
				AST rangeStartAst = expressionListAst.getFirstChild();
				AST rangeEndAst = rangeStartAst.getNextSibling();
				
				Object rangeStart = context.getExecutorFactory().executeAST(rangeStartAst, context);
				Object rangeEnd = context.getExecutorFactory().executeAST(rangeEndAst, context);
				
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
						throw new EolRuntimeException("The start of a range should be of type Integer", rangeStartAst);
					}
					if (!(rangeEnd instanceof Integer)){
						throw new EolRuntimeException("The end of a range should be of type Integer", rangeEndAst);
					}
					
				}
			}
		}
		
		return collection;
	}



}
