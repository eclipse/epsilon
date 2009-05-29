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
package org.eclipse.epsilon.hutn.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;

public abstract class HutnExtendedFactory {
	
	private HutnExtendedFactory() {}
	
	public static ReferenceSlot createReferenceSlot(String feature, ClassObject owner, EList<String> values) {
		final ReferenceSlot referenceSlot = HutnFactory.eINSTANCE.createReferenceSlot();
		
		referenceSlot.setFeature(feature);
		referenceSlot.setOwner(owner);
		referenceSlot.setValues(values);
		
		return referenceSlot;
	}
}
