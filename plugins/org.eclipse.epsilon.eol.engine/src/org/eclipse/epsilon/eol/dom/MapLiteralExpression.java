package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolMap;

public class MapLiteralExpression extends Expression {
	
	protected List<KeyValueExpressionPair> keyValueExpressionPairs = new ArrayList<MapLiteralExpression.KeyValueExpressionPair>();
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		
		final AST keyvalListAST = cst.getFirstChild();

		if (keyvalListAST != null) {
			for (AST keyValAst : keyvalListAST.getChildren()) {
				keyValueExpressionPairs.add(new KeyValueExpressionPair(
						(Expression) module.createAst(keyValAst.getFirstChild(), this),
						(Expression) module.createAst(keyValAst.getSecondChild(), this)
				));
			}
		}
		
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		final EolMap map = new EolMap();

		for (KeyValueExpressionPair keyValueExpressionPair : keyValueExpressionPairs) {
			final Object key = context.getExecutorFactory().executeAST(keyValueExpressionPair.getKey(), context);
			final Object val = context.getExecutorFactory().executeAST(keyValueExpressionPair.getValuel(), context);
			map.put(key, val);
		}

		return map;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		// TODO Auto-generated method stub
	}
	
	class KeyValueExpressionPair {
		
		protected Expression key;
		protected Expression valuel;
		
		public KeyValueExpressionPair(Expression key, Expression valuel) {
			super();
			this.key = key;
			this.valuel = valuel;
		}

		public Expression getKey() {
			return key;
		}
		
		public Expression getValuel() {
			return valuel;
		}
		
	}
	
}
