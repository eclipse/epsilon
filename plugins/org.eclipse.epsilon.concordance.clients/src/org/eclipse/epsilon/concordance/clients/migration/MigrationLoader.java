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
package org.eclipse.epsilon.concordance.clients.migration;

import java.net.URI;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.osgi.framework.Bundle;

class MigrationLoader {
	
	private static final String MIGRATION_EXT_POINT_ID = "org.eclipse.epsilon.concordance.clients.Migration";

	public Collection<Migration> loadFromExtensions() {
		final Collection<Migration> migrations = new LinkedList<Migration>();
				
		for (IConfigurationElement extPoint : getMigrationExtensionDefinitions()) {
			final Migration migration = createMigrationFrom(extPoint);
			
			if (migration != null)
				migrations.add(migration);
		}
		
		return migrations;
	}	

	private static IConfigurationElement[] getMigrationExtensionDefinitions() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(MIGRATION_EXT_POINT_ID);
	}

	private Migration createMigrationFrom(IConfigurationElement extPoint) {
		try {
			final Bundle bundle = Platform.getBundle(extPoint.getDeclaringExtension().getNamespaceIdentifier());
			
			final String originalNsUri    = extPoint.getAttribute("originalNsUri");
			final String evolvedNsUri     = extPoint.getAttribute("evolvedNsUri");
			final URI strategy            = bundle.getEntry(extPoint.getAttribute("migrationStrategy")).toURI();
			final MigratorFactory factory = (MigratorFactory)extPoint.createExecutableExtension("migratorFactory");
			
			
			return new Migration(originalNsUri, evolvedNsUri, strategy, factory);
		
		} catch (Exception e) {
			LogUtil.log("Error encountered while loading migration configuration from extension.", e);
			return null;
		}
	}
}
