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

import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.eol.types.concurrent.EolConcurrentMap;

public class MapLiteralExpression extends LiteralExpression {
	
	protected List<Entry<Expression, Expression>> keyValueExpressionPairs = new ArrayList<>();
	protected String mapName;
	
	/**
	 * 
	 * @return
	 * @since 1.6
	 */
	protected EolMap<Object, Object> createMap() {
		return mapName != null && mapName.contains("Concurrent") ?
			new EolConcurrentMap<>() : new EolMap<>();
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		this.mapName = cst.getText();
		
		final AST keyvalListAST = cst.getFirstChild();

		if (keyvalListAST != null) {
			for (AST keyValAst : keyvalListAST.getChildren()) {
				keyValueExpressionPairs.add(new SimpleEntry<>(
						(Expression) module.createAst(keyValAst.getFirstChild(), this),
						(Expression) module.createAst(keyValAst.getSecondChild(), this)
				));
			}
		}
		
	}
	
	@Override
	public EolMap<Object, Object> execute(IEolContext context) throws EolRuntimeException {
		final EolMap<Object, Object> map = createMap();
		ExecutorFactory executorFactory = context.getExecutorFactory();
		
		for (Entry<Expression, Expression> keyValueExpressionPair : keyValueExpressionPairs) {
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
}
