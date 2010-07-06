/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.CollectionUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.declarative.CollectOperation;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;
import org.eclipse.epsilon.eol.types.NumberUtil;

public class SortByOperation extends CollectOperation {

	public SortByOperation() {
		super();
	}
  
	@Override
	public Object execute(Object obj, AST operationAst, IEolContext context) throws EolRuntimeException {
		final List source = CollectionUtil.asList(obj);
		final List collected = CollectionUtil.asList(super.execute(obj, operationAst, context));
		
		// Determine which collected values correspond to which collection elements
		final Map<Object, Object> map = new HashMap<Object, Object>();
		
		for (int index = 0; index < collected.size(); index++)
			map.put(collected.get(index), source.get(index));
		
		Collections.sort(collected, new ObjectComparator(context.getPrettyPrinterManager()));
		
		// Build a new collection of the original collection elements
		// ordered by the result of sorting the collected items
		final Collection result = CollectionUtil.createCollection(source);
		
		for (int index = 0; index < collected.size(); index++)
			result.add(map.get(collected.get(index)));
		
		return result;
	}
	
	class ObjectComparator implements Comparator {
		
		protected PrettyPrinterManager p;
		
		public ObjectComparator(PrettyPrinterManager p) {
			this.p = p;
		}
		
		public int compare(Object o1, Object o2) {
			if (o1 instanceof Number && o2 instanceof Number) {
				if (NumberUtil.greaterThan((Number) o2, (Number) o1)) return -1;
				else if (NumberUtil.greaterThan((Number) o1, (Number) o2)) return 1;
				else return 0;
			}
			else if (o1 instanceof Comparable && o2 instanceof Comparable) {
				return ((Comparable) o1).compareTo(o2);
			}
			else {
				String str1 = p.print(o1);
				String str2 = p.print(o2);
				return str1.compareTo(str2);
			}
		}
		
	}
	
}
