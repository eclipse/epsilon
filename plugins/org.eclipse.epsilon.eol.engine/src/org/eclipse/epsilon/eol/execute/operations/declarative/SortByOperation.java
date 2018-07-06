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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.NumberUtil;

public class SortByOperation extends CollectOperation {
	
	@Override
	public Collection<?> execute(Object target, org.eclipse.epsilon.eol.execute.context.Variable iterator, Expression expression, IEolContext context) throws EolRuntimeException {
		final List<?> source = CollectionUtil.asList(target);
		final List<?> collected = CollectionUtil.asList(super.execute(target, iterator, expression, context));
		
		List<DecoratedObject> decoratedObjects = new ArrayList<>(collected.size());
		
		// Determine which collected values correspond to which collection elements
		//final Map<Object, Object> map = new HashMap<>();
		
		for (int index = 0; index < collected.size(); index++) {
			decoratedObjects.add(new DecoratedObject(source.get(index), collected.get(index)));
		}
		
		Collections.sort(decoratedObjects, new DecoratedObjectComparator(context.getPrettyPrinterManager()));
		
		// Build a new collection of the original collection elements
		// ordered by the result of sorting the collected items
		final Collection<Object> result = new EolSequence<>(); //EolCollectionType.createSameType(source);
		
		for (int index = 0; index < collected.size(); index++) {
			result.add(decoratedObjects.get(index).getObject());
		}
		
		return result;
	};
	
	class DecoratedObjectComparator implements Comparator<DecoratedObject> {
		
		protected PrettyPrinterManager p;
		
		public DecoratedObjectComparator(PrettyPrinterManager p) {
			this.p = p;
		}
		

		@SuppressWarnings({"unchecked", "rawtypes"})
		public int compare(DecoratedObject do1, DecoratedObject do2) {

			Object o1 = do1.getDecoration();
			Object o2 = do2.getDecoration();

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
	
	class DecoratedObject {
		protected Object object;
		protected Object decoration;
		
		public DecoratedObject(Object object, Object decoration) {
			this.object = object;
			this.decoration = decoration;
		}
		
		public Object getObject() {
			return object;
		}
		public void setObject(Object object) {
			this.object = object;
		}
		public Object getDecoration() {
			return decoration;
		}
		public void setDecoration(Object decoration) {
			this.decoration = decoration;
		}
	}
}
