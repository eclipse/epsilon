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
package org.eclipse.epsilon.hutn.xmi.util.hutn;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.epsilon.hutn.model.hutn.impl.ClassObjectImpl;

public class ClassObjectStub extends ClassObjectImpl {

	private final EClass metaClass;

	public ClassObjectStub(EClass metaClass) {
		this.metaClass = metaClass;
	}

	@Override
	public boolean hasEClass() {
		return true;
	}

	@Override
	public EClass getEClass() {
		return metaClass;
	}
}
