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
package test.strong2strong;

import static org.junit.Assert.fail;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.hutn.test.model.HutnTestWithFamiliesMetaModel;
import org.eclipse.epsilon.migration.IMigrationModule;
import org.eclipse.epsilon.migration.MigrationModule;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;

import util.FamiliesModelConstructor;

public abstract class Strong2StrongMigrationAcceptanceTest extends HutnTestWithFamiliesMetaModel {
	
	protected static ModelWithEolAssertions migrated;
	

	protected static void migrateFamiliesToFamilies(String strategy, String hutnForOriginalModel) throws Exception {
		final InMemoryEmfModel targetModel = new InMemoryEmfModel("Target", EmfUtil.createResource(), "families");
		migrate(strategy, hutnForOriginalModel, targetModel);
	}
	
	protected static void migrateFamiliesTo(EPackage evolvedMetamodel, String strategy, String hutnForOriginalModel) throws Exception {
		final InMemoryEmfModel targetModel = new InMemoryEmfModel("Target", EmfUtil.createResource(), evolvedMetamodel);
		migrate(strategy, hutnForOriginalModel, targetModel);
	}
	
	
	// FIXME ! Move - some of this is a helper for migration module
	private static void migrate(String strategy, String originalModel, InMemoryEmfModel target) throws Exception {
		final IMigrationModule migrator = new MigrationModule();
		
		if (migrator.parse(strategy) && migrator.getParseProblems().isEmpty()) {
			final AbstractEmfModel original = new FamiliesModelConstructor().constructModel("Original", originalModel);
			
			migrator.execute(original, target);
			
			migrated = new ModelWithEolAssertions(target);
			
		} else {
			for (ParseProblem problem : migrator.getParseProblems()) {
				System.err.println(problem);
			}
			fail("Could not parse migration strategy.");
		}
	}
}
