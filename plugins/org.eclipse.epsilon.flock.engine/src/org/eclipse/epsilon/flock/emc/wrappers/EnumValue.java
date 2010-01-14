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
package org.eclipse.epsilon.flock.emc.wrappers;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.execution.exceptions.ConservativeCopyException;

class EnumValue extends SingleBackedModelValue<Enumerator> {

	EnumValue(Model model, Enumerator underlyingModelObject) {
		super(model, underlyingModelObject);
	}

	@Override
	public EnumValue getEquivalentIn(Model model, IFlockContext context) throws ConservativeCopyException {
		try {
			return new EnumValue(model, model.getEquivalent(underlyingModelObject));
			
		} catch (EolEnumerationValueNotFoundException e) {
			throw new ConservativeCopyException("Could not find in migrated metamodel an enumeration value equivalent to: " + underlyingModelObject, e);
		}
	}
}
