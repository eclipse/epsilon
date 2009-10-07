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
package org.eclipse.epsilon.hutn.xmi.postprocessor;

import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.model.hutn.Spec;
import org.eclipse.epsilon.hutn.xmi.util.EmfUtil;

public class UriFragmentPostProcessor {

	private final Spec spec;
	private final UriFragmentResolver resolver;
	
	public UriFragmentPostProcessor(Spec spec) {
		this.spec     = spec;
		this.resolver = new UriFragmentResolver(spec);
	}

	public void process() {	
		resolveReferences();
	}
	
	private void resolveReferences() {
		for (ReferenceSlot slot : allReferenceSlots()) {
			final EList<String> newValues = new BasicEList<String>();
			
			for (String value : slot.getValues()) {
				newValues.add(resolve(value));
			}
			
			slot.setValues(newValues);
		}
	}
	
	private List<ReferenceSlot> allReferenceSlots() {
		return EmfUtil.getAllModelElementsOfType(spec, ReferenceSlot.class);
	}
	
	private String resolve(String value) {
		if (UriFragmentResolver.isUriFragment(value)) {
			final ClassObject object = resolver.resolve(value);
			
			if (object != null) {
				if (object.getIdentifier() == null) {
					addUniqueIdentifier(object);
				}
				
				return object.getIdentifier();
			}
		
		}
		
		return value;
	}
	
	private void addUniqueIdentifier(ClassObject object) {
		object.setIdentifier(EcoreUtil.generateUUID());
	}
	
		
	//       inconsistent: wrong index
	//                     wrong feature name
	//                     wrong type?
	// nested
}
