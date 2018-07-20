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
import java.util.Map;
import org.eclipse.epsilon.eol.execute.operations.declarative.*;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.*;

public class EolOperationFactory {
	
	protected final Map<String, AbstractOperation> operationCache = new HashMap<>();
	
	public EolOperationFactory() {
		createCache();
	}
	
	protected void createCache() {
		operationCache.put("assert", new AssertOperation());
		operationCache.put("assertError", new AssertErrorOperation());
		operationCache.put("collect", new CollectOperation());
		operationCache.put("exists", new ExistsOperation());
		operationCache.put("one", new NMatchOperation(1));
		operationCache.put("none", new NMatchOperation(0));
		operationCache.put("forAll", new ForAllOperation());
		operationCache.put("reject", new RejectOperation());
		operationCache.put("rejectOne", new RejectOneOperation());
		operationCache.put("select", new SelectOperation());
		operationCache.put("selectOne", new SelectOneOperation());
		operationCache.put("aggregate", new AggregateOperation());
		operationCache.put("closure", new ClosureOperation());
		operationCache.put("sortBy", new SortByOperation());
		operationCache.put("mapBy", new MapByOperation());
		operationCache.put("as", new AsOperation());
		operationCache.put("find", new FindOperation());
		operationCache.put("findOne", new FindOneOperation());
	}

	public AbstractOperation getOperationFor(String name) {
		return operationCache.get(name);
	}	
}
