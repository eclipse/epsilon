/*******************************************************************************
 * Copyright (c) 2010 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.model.domain.typemappings;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.equivalences.factory.EquivalenceFactory;
import org.eclipse.epsilon.flock.model.domain.common.TypedAndGuardedConstruct;

public abstract class TypeMappingConstruct extends TypedAndGuardedConstruct implements EquivalenceFactory {

	protected TypeMappingConstruct(AST ast, String originalType, AST guard) {
		super(ast, originalType, guard);
	}
}
