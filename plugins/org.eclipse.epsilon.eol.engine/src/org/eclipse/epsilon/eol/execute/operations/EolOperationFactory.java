/*******************************************************************************
 * Copyright (c) 2008-2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - revised assertions
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.epsilon.eol.execute.operations.declarative.*;
import org.eclipse.epsilon.eol.execute.operations.declarative.concurrent.*;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.*;

public class EolOperationFactory {
	
	protected final Map<String, AbstractOperation> operationCache = new HashMap<>(32, 0.9f);
	
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
		operationCache.put("parallelSelect", new ParallelSelectOperation());
		operationCache.put("parallelSelectOne", new ParallelSelectOneOperation());
		operationCache.put("parallelReject", new ParallelRejectOperation());
		operationCache.put("parallelRejectOne", new ParallelRejectOneOperation());
		operationCache.put("parallelOne", new ParallelNMatchOperation(1));
		operationCache.put("parallelNone", new ParallelNMatchOperation(0));
		operationCache.put("parallelExists", new ParallelExistsOperation());
		operationCache.put("parallelForAll", new ParallelForAllOperation());
		operationCache.put("parallelCollect", new ParallelCollectOperation());
		operationCache.put("parallelSortBy", new ParallelSortByOperation());
		operationCache.put("parallelMapBy", new ParallelMapByOperation());
	}

	public AbstractOperation getOperationFor(String name) {
		return operationCache.get(name);
	}	
}
