/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi.coerce;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.epsilon.hutn.xmi.util.EListUtil;

@SuppressWarnings("unchecked")
class EListCoercionStrategy extends AbstractCoercionStrategy<EList> {

	public EListCoercionStrategy(ValueCoercer coercer) {
		super(coercer, EList.class);
	}
	
	protected boolean isApplicable() {
		return coercedElementsAreAllOfSameType();
	}
	
	protected Object doCoerce() {
		return coerceEachElement();
	}
	
	private boolean coercedElementsAreAllOfSameType() {
		return EListUtil.elementsAreAllOfSameType(coerceEachElement());
	}
	
	private EList<?> coerceEachElement() {
		final EList<Object> results = new BasicEList<Object>();
		
		for (Object element : value) {
			results.add(coercer.coerce(element));
		}
		
		return results;
	}
}
