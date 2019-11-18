/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolMap;

public class MapLiteralExpression extends Expression {
	
	protected List<KeyValueExpressionPair> keyValueExpressionPairs = new ArrayList<>();
	
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
	public EolMap<?, ?> execute(IEolContext context) throws EolRuntimeException {
		final EolMap<Object, Object> map = new EolMap<>();
		ExecutorFactory executorFactory = context.getExecutorFactory();
		
		for (KeyValueExpressionPair keyValueExpressionPair : keyValueExpressionPairs) {
			final Object key = executorFactory.execute(keyValueExpressionPair.getKey(), context);
			final Object val = executorFactory.execute(keyValueExpressionPair.getValue(), context);
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
		protected Expression value;
		
		public KeyValueExpressionPair(Expression key, Expression value) {
			super();
			this.key = key;
			this.value = value;
		}

		public Expression getKey() {
			return key;
		}
		
		public Expression getValue() {
			return value;
		}
	}
}
