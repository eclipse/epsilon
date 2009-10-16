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
package org.eclipse.epsilon.hutn.xmi.hashing.test.integration;

import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.EReferenceBuilder.MANY;
import static org.eclipse.epsilon.test.util.builders.emf.EReferenceBuilder.anEReference;
import static org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder.aMetamodel;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.epsilon.hutn.xmi.hashing.hashers.ecore.EPackageHasher;

import org.junit.Test;

public class BidirectionalReference {
	
	@Test
	public void sameHashCodeForEquivalentMetamodels() {
		assertThat(hashFor(buildMetamodelWithBidirectionalReference()), equalTo(hashFor(buildMetamodelWithBidirectionalReference())));
	}
	
	private int hashFor(EPackage pkg) {
		return EPackageHasher.getInstance().hashSafely(pkg);
	}

	private EPackage buildMetamodelWithBidirectionalReference() {
		final EClass person  = anEClass().named("Person").build();
		final EClass account = anEClass().named("Account").build();
		
		final EReference accounts = anEReference().named("accounts").references(0, MANY, account).build();
		final EReference owners   = anEReference().named("owners").references(1, MANY, person).build();
		
		accounts.setEOpposite(owners);
		owners.setEOpposite(accounts);
		
		person.getEStructuralFeatures().add(accounts);
		account.getEStructuralFeatures().add(owners);
		
		return aMetamodel().with(person).with(account).build();
	}
}
