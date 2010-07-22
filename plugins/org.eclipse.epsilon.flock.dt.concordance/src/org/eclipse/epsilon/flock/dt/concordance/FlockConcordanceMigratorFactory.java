package org.eclipse.epsilon.flock.dt.concordance;

import java.net.URI;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.concordance.clients.migration.Migrator;
import org.eclipse.epsilon.concordance.clients.migration.MigratorFactory;
import org.eclipse.epsilon.flock.dt.util.MigrationStrategyExecutor;

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
