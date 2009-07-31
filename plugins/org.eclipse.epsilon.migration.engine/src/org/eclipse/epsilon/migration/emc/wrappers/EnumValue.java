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
package org.eclipse.epsilon.migration.emc.wrappers;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.migration.execution.Equivalences;

class EnumValue extends BackedModelValue<Enumerator> {

	EnumValue(Model model, Enumerator underlyingModelObject) {
		super(model, underlyingModelObject);
	}

	@Override
	EnumValue getEquivalentIn(Model model, Equivalences equivalences) throws CopyingException {
		try {
			return new EnumValue(model, model.getEquivalent(underlyingModelObject));
			
		} catch (EolEnumerationValueNotFoundException e) {
			throw new CopyingException("Could not find in target model an enumeration value equivalent to: " + underlyingModelObject, e);
		}
	}
}
