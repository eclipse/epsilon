/*******************************************************************************
 * Copyright (c) 2008-2018 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - revised assertions
 *     Sina Madani - parallel operations
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.epsilon.eol.execute.operations.declarative.*;
import org.eclipse.epsilon.eol.execute.operations.declarative.concurrent.*;
import org.eclipse.epsilon.eol.execute.operations.simple.assertions.*;

public class EolOperationFactory {
	
	protected final Map<String, AbstractOperation> operationCache = new HashMap<>(64);
	
	public EolOperationFactory() {
		operationCache.put("assert", new AssertOperation());
		operationCache.put("assertError", new AssertErrorOperation());
		operationCache.put("atLeastNMatch", new NMatchOperation(NMatchOperation.MatchMode.MINIMUM));
		operationCache.put("atMostNMatch", new NMatchOperation(NMatchOperation.MatchMode.MAXIMUM));
		operationCache.put("collect", new CollectOperation());
		operationCache.put("count", new CountOperation());
		operationCache.put("exists", new ExistsOperation());
		operationCache.put("none", new NMatchOperation(NMatchOperation.MatchMode.EXACT, 0));
		operationCache.put("one", new NMatchOperation(NMatchOperation.MatchMode.EXACT, 1));
		operationCache.put("nMatch", new NMatchOperation(NMatchOperation.MatchMode.EXACT));
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
		operationCache.put("parallelCount", new ParallelCountOperation());
		operationCache.put("parallelSelect", new ParallelSelectOperation());
		operationCache.put("parallelSelectOne", new ParallelSelectOneOperation());
		operationCache.put("parallelReject", new ParallelRejectOperation());
		operationCache.put("parallelRejectOne", new ParallelRejectOneOperation());
		operationCache.put("parallelOne", new ParallelNMatchOperation(NMatchOperation.MatchMode.EXACT, 1));
		operationCache.put("parallelNone", new ParallelNMatchOperation(NMatchOperation.MatchMode.EXACT, 0));
		operationCache.put("parallelNMatch", new ParallelNMatchOperation(NMatchOperation.MatchMode.EXACT));
		operationCache.put("parallelAtMostNMatch", new ParallelNMatchOperation(NMatchOperation.MatchMode.MAXIMUM));
		operationCache.put("parallelAtLeastNMatch", new ParallelNMatchOperation(NMatchOperation.MatchMode.MINIMUM));
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
