package org.eclipse.epsilon.eol.dom;

import java.util.Collection;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolMap;

public class ItemSelectorExpression extends Expression {

	public Object execute(IEolContext context) throws EolRuntimeException {
		
		AST expressionAst = getFirstChild();
		AST indexAst = expressionAst.getNextSibling();
		
		Object expression = context.getExecutorFactory().executeAST(expressionAst, context);
		Object index = context.getExecutorFactory().executeAST(indexAst, context);
		
		if ((expression instanceof Collection)) {
			if (!(index instanceof Integer)) 
				throw new EolRuntimeException("Collection index must be an integer but " + index + " was provided instead.", indexAst);
			else return CollectionUtil.asList(expression).get((Integer)index);
		}
		else if (expression instanceof EolMap){
			return ((EolMap) expression).get(index);
		}
		
		throw new EolRuntimeException(expression + " is not a collection or a map.", expressionAst);
		
	}
	
	public static void main(String[] args) throws Exception {
		
		EolModule module = new EolModule();
		//module.parse("var map = new Map; map.put('foo', 'bar'); map['foo'].println();");
		module.parse("var list = List{1,2,3}; list[2].println();");
		if (module.getParseProblems().size() > 0) {
			for (ParseProblem p : module.getParseProblems()) {
				System.out.println(p);
			}
		}
		else {
			module.execute();
		}
	}
	
}
