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
import org.eclipse.epsilon.hutn.model.HutnExtendedFactory;
import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;

public class ReferenceCoercionStrategy extends AbstractCoercionStrategy {
	
	private final String value;
	
	public ReferenceCoercionStrategy(AttributeSlot slot) {
		super(slot);
		
		this.value = values.get(0);
	}
	
	public boolean isApplicable() {
		return slotContainsOneValue() && valueIsReference();
	}
	
	private boolean slotContainsOneValue() {
		return values.size() == 1;
	}
		
	private boolean valueIsReference() {
		return value.startsWith("_");
	}
	

	public ReferenceSlot coerce() {
		final ReferenceSlot coercedSlot = HutnExtendedFactory.createReferenceSlot(slot.getFeature(), slot.getOwner(), coercedReferenceValues());
		
		setTraceabilityInformation(coercedSlot);
		
		slot.setOwner(null);
		
		return coercedSlot;
	}

	private EList<String> coercedReferenceValues() {
		return EListUtil.asEList(value.split(" "));
	}
	
	private void setTraceabilityInformation(final ReferenceSlot coercedSlot) {
		coercedSlot.setLine(slot.getLine());
		coercedSlot.setCol(slot.getCol());
	}
}
