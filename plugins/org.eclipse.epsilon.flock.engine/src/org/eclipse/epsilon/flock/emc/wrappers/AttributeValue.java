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

import org.eclipse.epsilon.flock.context.ConservativeCopyContext;

class AttributeValue extends BackedModelValue<Object> {

	AttributeValue(Model model, Object underlyingModelObject) {
		super(model, underlyingModelObject);
	}
	
	@Override
	public AttributeValue getEquivalentIn(Model model, ConservativeCopyContext context) {
		return new AttributeValue(model, underlyingModelObject);
	}
}
