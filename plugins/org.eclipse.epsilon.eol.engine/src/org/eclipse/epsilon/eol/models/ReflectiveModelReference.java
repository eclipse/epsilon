/*******************************************************************************
 * Copyright (c) 2011 The University of York.
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
package org.eclipse.epsilon.eol.models;

import java.util.Collection;

import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;

public class ReflectiveModelReference extends ModelReference implements IReflectiveModel {
	
	public ReflectiveModelReference(IReflectiveModel target) {
		super(target);
	}
	
	@Override
	public IReflectivePropertySetter getPropertySetter() {
		return ((IReflectiveModel)target).getPropertySetter();
	}
	
	@Override
	public Collection<String> getPropertiesOf(String type) throws EolModelElementTypeNotFoundException {
		return ((IReflectiveModel)target).getPropertiesOf(type);
	}

	@Override
	public boolean hasProperty(String type, String property) throws EolModelElementTypeNotFoundException {
		return ((IReflectiveModel)target).hasProperty(type, property);
	}

}
