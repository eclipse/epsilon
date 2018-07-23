/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.clients.migration;

import java.net.URI;

import org.eclipse.emf.ecore.EPackage;

class Migration {

	private final String originalNsUri;
	private final String evolvedNsUri;
	private final URI strategy;
	private final MigratorFactory factory;
	
	public Migration(String originalNsUri, String evolvedNsUri, URI strategy, MigratorFactory factory) {
		this.originalNsUri = originalNsUri;
		this.evolvedNsUri  = evolvedNsUri;
		this.strategy      = strategy;
		this.factory       = factory;
	}

	public String getOriginalNsUri() {
		return originalNsUri;
	}
	
	public boolean targetIs(EPackage ePackage) {
		return evolvedNsUri.equals(ePackage.getNsURI());
	}

	public Migrator createMigrator() throws MigratorInstantiationException {
		return factory.migratorFor(strategy, getEPackage(originalNsUri), getEPackage(evolvedNsUri));
	}
	
	private EPackage getEPackage(String nsUri) throws MigratorInstantiationException {
		final EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(nsUri);
		
		if (ePackage == null) {
			throw new MigratorInstantiationException("Could not locate EPackage with nsUri: " + nsUri);
		}
		
		return ePackage;
	}
}
