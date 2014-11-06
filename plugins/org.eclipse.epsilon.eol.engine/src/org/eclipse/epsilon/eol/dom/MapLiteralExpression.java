package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolMap;

public class MapLiteralExpression extends Expression implements IExecutableModuleElement {
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		final EolMap map = new EolMap();
		final AST keyvalListAST = getFirstChild();

		if (keyvalListAST == null) {
			return map;
		}

		assert keyvalListAST.getType() == EolParser.KEYVALLIST;
		for (AST keyvalAst : keyvalListAST.getChildren()) {
			assert keyvalAst.getType() == EolParser.KEYVAL;
			final AST keyAst = keyvalAst.getFirstChild();
			final AST valAst = keyAst.getNextSibling();
			final Object key = context.getExecutorFactory().executeAST(keyAst, context);
			final Object val = context.getExecutorFactory().executeAST(valAst, context);
			map.put(key, val);
		}

		return map;
	}
	
}
