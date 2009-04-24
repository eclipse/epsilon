/*******************************************************************************
 * Copyright (c) 2008 The University of York.
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
package org.eclipse.epsilon.hutn.xmi.test.unit.util;

import org.eclipse.epsilon.hutn.test.model.families.FamiliesFactory;
import org.eclipse.epsilon.hutn.test.model.families.Person;

public abstract class PersonFactory {

	private PersonFactory() {}
	
	public static Person createPerson() {
		return createPerson(null);
	}
	
	public static Person createPerson(String name) {
		final Person person = FamiliesFactory.eINSTANCE.createPerson();
		person.setName(name);
		return person;
	}
}
