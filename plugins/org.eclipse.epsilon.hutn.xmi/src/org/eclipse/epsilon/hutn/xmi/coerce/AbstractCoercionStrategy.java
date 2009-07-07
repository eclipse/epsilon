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

import org.eclipse.emf.common.util.EList;
import org.eclipse.epsilon.emc.emf.util.EListUtil;
import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.model.hutn.Slot;

public abstract class AbstractCoercionStrategy {

	protected final AttributeSlot slot;
	protected final EList<String> values;

	public AbstractCoercionStrategy(AttributeSlot slot) {
		this.slot   = slot;
		this.values = EListUtil.castElements(slot.getValues(), String.class);
	}
	
	public abstract boolean isApplicable();
	public abstract Slot<?> coerce();
	
	
	public static AbstractCoercionStrategy getCoercerFor(AttributeSlot slot) {
		if (new ReferenceCoercionStrategy(slot).isApplicable()) {
			return new ReferenceCoercionStrategy(slot);
			
		} else {
			return new PrimitiveCoercionStrategy(slot);
		}
	}
}
