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

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.concordance.index.ConcordanceIndex;
import org.eclipse.epsilon.concordance.model.IConcordanceModel;
import org.eclipse.epsilon.concordance.model.ModelVisitor;
import org.eclipse.epsilon.concordance.reporter.metamodel.DefaultMetamodelChangeListener;

public class AutomaticMigrator extends DefaultMetamodelChangeListener {

	private final Collection<Migration> migrations;
	
	public AutomaticMigrator() {
		this.migrations = new MigrationLoader().loadFromExtensions();
	}
	
	public AutomaticMigrator(ConcordanceIndex index) {
		this(index, new LinkedList<Migration>());
	}
	
	public AutomaticMigrator(ConcordanceIndex index, Collection<Migration> migrations) {
		super(index);
		this.migrations = migrations;
	}

	public void ePackageAdded(EPackage ePackage) {
		for (Migration migration : migrations) {
			try {
				if (migration.targetIs(ePackage)) {
					index.visitAllInstancesOf(migration.getOriginalNsUri(), new MigratingVisitor(migration.createMigrator()));
				}
			
			} catch (MigratorInstantiationException e) {
				LogUtil.log("Exection encountered whilst automatically migrating instances of " + migration.getOriginalNsUri(), e);
			}
		}
	}

	static class MigratingVisitor extends ModelVisitor {

		private final Migrator migrator;	
	
		public MigratingVisitor(Migrator migrator) {
			this.migrator = migrator;
		}

		public void visit(IConcordanceModel model) {
			if (model.getResource() != null)
				migrator.migrate(model.getResource());
		}
	}
}
