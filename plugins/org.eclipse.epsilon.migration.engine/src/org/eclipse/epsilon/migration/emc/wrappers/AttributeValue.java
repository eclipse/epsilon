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

import org.eclipse.epsilon.migration.execution.Equivalences;

class AttributeValue extends BackedModelValue<Object> {

	AttributeValue(Model model, Object underlyingModelObject) {
		super(model, underlyingModelObject);
	}
	
	@Override
	AttributeValue getEquivalentIn(Model model, Equivalences equivalences) throws CopyingException {
		return new AttributeValue(model, underlyingModelObject);
	}
}
