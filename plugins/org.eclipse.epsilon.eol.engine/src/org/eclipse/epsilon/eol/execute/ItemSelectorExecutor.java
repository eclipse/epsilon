package org.eclipse.epsilon.eol.execute;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolInteger;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.eol.types.EolSequence;

public class ItemSelectorExecutor extends AbstractExecutor {
	
	public Object execute(AST ast, IEolContext context)
			throws EolRuntimeException {
		
		AST expressionAst = ast.getFirstChild();
		AST indexAst = expressionAst.getNextSibling();
		
		Object expression = context.getExecutorFactory().executeAST(expressionAst, context);
		Object index = context.getExecutorFactory().executeAST(indexAst, context);
		
		if ((expression instanceof EolCollection)) {
			if (!(index instanceof EolInteger)) 
				throw new EolRuntimeException("Collection index must be an integer but " + index + " was provided instead.", indexAst);
			else return ((EolCollection) expression).at((EolInteger)index);
		}
		else if (expression instanceof EolMap){
			return ((EolMap) expression).get(index);
		}
		
		throw new EolRuntimeException(expression + " is not a collection or a map.", expressionAst);
		
	}
	
	public static void main(String[] args) throws Exception {
		
		EolModule module = new EolModule();
		//module.parse("var map = new Map; map.put('foo', 'bar'); map['foo'].println();");
		module.parse("var list = List{1,2,3}; list.println();");
		if (module.getParseProblems().size() > 0) {
			for (ParseProblem p : module.getParseProblems()) {
				System.err.println(p);
			}
		}
		else {
			module.execute();
		}
	}
	
	
}
