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

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.declarative.AggregateOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.AsOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.ClosureOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.CollectOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.ExistsOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.FindOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.ForAllOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.MapByOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.OneOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.RejectOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOneOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.SortByOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.AssertErrorOperation;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.AssertOperation;

public class OperationFactory {

	//protected ArrayList lookupPackages = new ArrayList();
	
	protected HashMap<String, AbstractOperation> operationCache = new HashMap<String, AbstractOperation>();
	
	public OperationFactory(){
		createCache();
	}
	
	protected void createCache() {

		operationCache.put("assert", new AssertOperation());
		operationCache.put("assertError", new AssertErrorOperation());
		operationCache.put("collect", new CollectOperation());
		operationCache.put("exists", new ExistsOperation());
		operationCache.put("one", new OneOperation());
		operationCache.put("forAll", new ForAllOperation());
		operationCache.put("reject", new RejectOperation());
		operationCache.put("select", new SelectOperation());
		operationCache.put("aggregate", new AggregateOperation());
		operationCache.put("selectOne", new SelectOneOperation());
		operationCache.put("closure", new ClosureOperation());
		operationCache.put("sortBy", new SortByOperation());
		operationCache.put("mapBy", new MapByOperation());
		operationCache.put("as", new AsOperation());
		operationCache.put("find", new FindOperation());
		
	}

	public AbstractOperation getOperationFor(String name) {
		return operationCache.get(name);
	}
	
}
