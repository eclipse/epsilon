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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.hutn.xmi.util.EListUtil;

class StringToReferenceCoercionStrategy extends AbstractCoercionStrategy<String> {
	
	public StringToReferenceCoercionStrategy(ValueCoercer coercer) {
		super(coercer, String.class);
	}
	
	protected boolean isApplicable() {
		return valueContainsOnlyReferences();
	}
	
	protected Object doCoerce() {
		return resolveReferencesInValue();
	}

	
	private boolean valueContainsOnlyReferences() {
		return EListUtil.elementsAreAllInstancesOf(resolveReferencesInValue(), EObject.class);
	}
	
	private EList<EObject> resolveReferencesInValue() {
		final EList<EObject> coerced = new BasicEList<EObject>();
		
		for (String reference : value.split(" ")) {
			coerced.add(coercer.getResource().getEObject(reference));
		}
		
		return coerced;
	}
}
