/*******************************************************************************
 * Copyright (c) 2008-2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - revised assertions
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations;

import java.util.HashMap;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.declarative.AggregateOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.ClosureOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.CollectOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.ExistsOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.ForAllOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.IterateOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.OneOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.RejectOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOneOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SortByOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.AssertErrorOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.AssertOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.BooleanAssertionOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.EqualityAssertionOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.FailOperation;

public class OperationFactory {
	
	//protected ArrayList lookupPackages = new ArrayList();
	
	protected HashMap<String, AbstractOperation> operationCache = new HashMap<String, AbstractOperation>();
	
	public OperationFactory(){
		createCache();
	}
	
	protected void createCache() {
		
		operationCache.put("assert", new AssertOperation());
		operationCache.put("assertTrue", new BooleanAssertionOperation(true));
		operationCache.put("assertFalse", new BooleanAssertionOperation(false));
		operationCache.put("assertEquals", new EqualityAssertionOperation(true));
		operationCache.put("assertNotEquals", new EqualityAssertionOperation(false));
		operationCache.put("assertError", new AssertErrorOperation());
		operationCache.put("fail", new FailOperation());
		operationCache.put("collect", new CollectOperation());
		operationCache.put("exists", new ExistsOperation());
		operationCache.put("one", new OneOperation());
		operationCache.put("forAll", new ForAllOperation());
		operationCache.put("iterate", new IterateOperation());
		operationCache.put("reject", new RejectOperation());
		operationCache.put("select", new SelectOperation());
		operationCache.put("aggregate", new AggregateOperation());
		operationCache.put("selectOne", new SelectOneOperation());
		operationCache.put("closure", new ClosureOperation());
		operationCache.put("sortBy", new SortByOperation());
		
	}

	
	/**
	 * Create an instance of the specified operation.
	 * Implementations of operations exist under the
	 * lookupPackage package collection. The implementation of 
	 * the requested operation must have the following 
	 * class name: 
	 * <code>toCamel(name) + "Operation"</code>
	 * so for <code>o-&gt;print()</code> the method will try to instantiate
	 * and return <code>org.xol.execute.operations.simple.PrintOperation</code>
	 * @param name
	 * @return AbstractOperation
	 */
	/*
	protected AbstractOperation getOperationFor(String name){
		
		AbstractOperation operation = null;
		
		ListIterator li = lookupPackages.listIterator();
		
		while (li.hasNext()){
			String className = li.next().toString() + "." + StringUtil.firstToUpper(name) + "Operation";
			try {
				operation = (AbstractOperation) Class.forName(className).newInstance();
				if (operation != null){
					return operation;
				}
			}
			catch (Exception ex){
				// Safely ignore the exception
			}
		}
		return null;
	}
	*/
	
	public AbstractOperation getOperationFor(String name) {
		return operationCache.get(name);
	}
	
	public AbstractOperation getOperationFor(AST operationAst, IEolContext context){
		return getOperationFor(operationAst.getText());
	}
	
	public Object executeOperation(Object source, AST operationAst, IEolContext context) throws EolRuntimeException{
		AbstractOperation operation = getOperationFor(operationAst.getText());
		if (operation == null) {
			throw new EolIllegalOperationException(source, operationAst.getText(), operationAst);
		} else {
			return operation.execute(source, operationAst, context);
		}
	}
}
