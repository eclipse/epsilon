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
package test.strong2strong.errors;

import org.eclipse.epsilon.migration.execution.exceptions.IllegalMigrationException;
import org.junit.Test;

import test.strong2strong.Strong2StrongMigrationAcceptanceTest;

public class MoveOriginalModelElementToMigratedModel extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate Family {" +
	                                       "	migrated.members.add(Original!Person.all.first);" +
	                                       "}";
	
	private static final String originalModel = "Families {"                         +
	                                            "	Family {"                        +
	                                            "		members: Person \"John\" {}" + 
	                                            "	}"                               +
	                                            "}";
	
	
	@Test(expected=IllegalMigrationException.class)
	public void executionShouldCauseException() throws Exception {
		migrateFamiliesToFamilies(strategy, originalModel);
	}
}
