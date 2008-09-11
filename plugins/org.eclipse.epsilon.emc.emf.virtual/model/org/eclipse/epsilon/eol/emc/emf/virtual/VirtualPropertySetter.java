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
package org.eclipse.epsilon.eol.emc.emf.virtual;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.emc.emf.virtual.Slot;
import org.eclipse.epsilon.emc.emf.virtual.VirtualObject;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.AbstractPropertySetter;

class VirtualPropertySetter extends AbstractPropertySetter {
	
	public void invoke(Object value) throws EolRuntimeException {
//		System.err.println("PS invoked on: ");
//		System.err.println("\tObject: "   + object);
//		System.err.println("\tProperty: " + property);
//		System.err.println("\tValue: "    + value);
		
		final VirtualObject vObject = (VirtualObject)object;
		
//		System.err.println("\tSlots: " + vObject.getSlots());
		
		final Slot slot = SlotFactory.getInstance().createSlotFor(value);
		
		if (slot == null)
			throw new EolIllegalPropertyException(object, property, ast, context);
		
		slot.setType(property);
		
		vObject.getSlots().add(slot);
		
//		System.err.println("\tUpdated Slots: " + vObject.getSlots());
	}
	
	public static void main(String[] args) {
		System.err.println(EcorePackage.eINSTANCE.getNsURI());
	}
}
