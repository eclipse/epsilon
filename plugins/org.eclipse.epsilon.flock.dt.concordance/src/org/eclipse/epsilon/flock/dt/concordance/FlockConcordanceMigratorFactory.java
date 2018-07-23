/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.dt.concordance;

import java.net.URI;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.concordance.clients.migration.Migrator;
import org.eclipse.epsilon.concordance.clients.migration.MigratorFactory;
import org.eclipse.epsilon.flock.dt.emf.util.MigrationStrategyExecutor;

public class FlockConcordanceMigratorFactory implements MigratorFactory {

	// This class is an adaptor for MigrationStrategyExecutor
	
	public Migrator migratorFor(final URI strategy, final EPackage originalMetamodel, final EPackage evolvedMetamodel) {
		return new Migrator() {

			public void migrate(IResource model) {
				new MigrationStrategyExecutor(model, strategy, originalMetamodel, evolvedMetamodel).run();
			}
			
		};
	}

}
