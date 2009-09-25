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
package org.eclipse.epsilon.hutn.unparser.internal;

import java.util.List;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.model.hutn.Slot;

class SlotUnparser extends Unparser {

	private final Slot<?> slot;
	
	public SlotUnparser(Slot<?> slot) {
		this.slot = slot;
	}
	
	public SlotUnparser(Slot<?> slot, StringBuilder builder) {
		super(builder);
		this.slot = slot;
	}
	
	
	public void doUnparse() {
		unparseFeature();		
		unparseValues();
	}
	
	
	private void unparseFeature() {
		builder.append(slot.getFeature());
		builder.append(": ");
	}
	
	
	private void unparseValues() {		
		for (int index = 0; index < slot.getValues().size(); index++) {
			final Object value = slot.getValues().get(index);
		
			if (slot instanceof ReferenceSlot) {
				final ClassObject co = ((ReferenceSlot)slot).getClassObjects().get(index);
				
				if (co == null) {
					appendSignature("UnknownType", (String)value);
					
				} else {
					appendSignature(co);
				}
				
			} else {
				unparseValue(value);
			}
			
			if (hasNext(slot.getValues(), index)) {
				builder.append(", ");
			}
		}
	}

	private static boolean hasNext(List<?> list, int currentIndex) {
		return currentIndex + 1 < list.size();
	}

	
	private void unparseValue(Object value) {
		if (value == null) {
			builder.append("null");
			
		} else if (value instanceof String) {
			unparseValue((String)value);
		
		} else if (value instanceof Integer ||
		           value instanceof Float   ||
		           value instanceof Boolean) {
			
			builder.append(value);
			
		} else if (value instanceof EEnumLiteral) {
			unparseValue((EEnumLiteral)value);
		
		} else if (value instanceof ClassObject) {
			unparseValue((ClassObject)value);
			
		} else { 
			throw new IllegalStateException("Cannot unparse instances of " +
			                                value.getClass().getCanonicalName() + ": " + 
			                                value);
		}
	}
	
	private void unparseValue(String value) {
		appendStringValue(escape(value));
	}
	
	private String escape(String value) {
		String escaped = value;

		escaped = escaped.replaceAll("\\\\", "\\\\\\\\");
		escaped = escaped.replaceAll("\\\"", "\\\\\"");
		
		return escaped;
	}
	
	private void unparseValue(EEnumLiteral value) {
		builder.append(value.getLiteral());
	}
	
	private void unparseValue(ClassObject value) {
		new ClassObjectUnparser(value, builder).unparse();
	}
}
