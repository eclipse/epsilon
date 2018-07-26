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

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;
import org.junit.Before;
import org.junit.Test;

public class AutomaticMigrationIntegrationTests extends AutomaticMigrationIntegrationTest {

	private static final String ORIGINAL_MODEL = "<?xml version=\"1.0\" encoding=\"ASCII\"?>"  + "\n" +
	                                             "<families:Family xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:families=\"families/1.0.0\">" + "\n" +
	                                             "  <members name=\"John\" male=\"true\"/>" + "\n" +
	                                             "  <members name=\"Joan\"/>" + "\n" +
	                                             "</families:Family>";
	
	private ModelWithEolAssertions migrated;
	
	@Before
	public void setup() throws Throwable {
		final IFile original = createFile(project, "instance.model", ORIGINAL_MODEL);
		waitForModelChangeNotifications();
		
		final EPackage evolved = dynamicallyLoadPackage("org.eclipse.epsilon.concordance.clients.test", "/src/org/eclipse/epsilon/concordance/clients/migration/Evolved.ecore");
        registerMetamodel(evolved);
        
        waitForMigrationToComplete();
        
        migrated = loadAsModelWithEolAssertions(original, "Migrated", evolved);
        migrated.setVariable("family", "Family.all.first");
	}
	
	@Test
	public void shouldMigrateModel() throws Exception {	
		migrated.assertDefined("family");	
		migrated.assertEquals("Man",   "family.members.selectOne(p|p.name = 'John').eClass.name");	
		migrated.assertEquals("Woman", "family.members.selectOne(p|p.name = 'Joan').eClass.name");
	}
}
