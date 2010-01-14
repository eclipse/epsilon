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


abstract class SingleBackedModelValue<UnwrappedType> extends BackedModelValue<UnwrappedType> {

	protected SingleBackedModelValue(Model model, UnwrappedType underlyingModelObject) {
		super(model, underlyingModelObject);
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public boolean isMany() {
		return false;
	}
}
