/**
 * *******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 * ******************************************************************************
 *
 * $Id: Associations.java,v 1.2 2008/08/07 12:44:21 louis Exp $
 */
package org.eclipse.epsilon.hutn.translate;

import org.eclipse.epsilon.hutn.test.util.ModelWithEolAssertions;
import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Ast;
import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Node;
import org.junit.BeforeClass;
import org.junit.Test;

public class Associations extends HutnTranslatorTest {
	
	private static ModelWithEolAssertions model;
	
	@BeforeClass
	public static void createAstModel() throws Exception {
		final Node pet1Node    = createClass("Pet", "Fido");
		final Node pet2Node    = createClass("Pet", "Lassie");
		
		final Node familyNode = createClass("Family", "The Smiths");
		familyNode.getChildren().add(createReference("pets", new Reference("Pet", "Fido"), new Reference("Pet", "Lassie")));
		
		final Node packageNode = createPackage("FamilyPackage");
		packageNode.getChildren().add(pet1Node);
		packageNode.getChildren().add(pet2Node);
		packageNode.getChildren().add(familyNode);
		
		final Ast ast = initialiseAst();
		ast.getRoots().add(packageNode);
		
		model = translatorTest(ast);
		model.setVariable("package", "spec.objects.first()");
		model.setVariable("family",  "package.slots.first().objects.select(o : Object | o.type = 'Family').first()");
		
		model.setVariable("slot", "family.slots.first()");
	}
	
	@Test
	public void packageShouldContainThreeObjects() {
		model.assertEquals(3, "package.slots.first().objects.size()");
	}
	
	@Test
	public void slotShouldBeCorrectType() {
		model.assertTrue("ReferenceSlot.isType(slot)");
	}
	
	@Test
	public void slotShouldHaveCorrectFeatureName() {
		model.assertEquals("pets", "slot.feature");
	}
	
	@Test
	public void slotShouldHaveTwoIdentifiers() {
		model.assertEquals(2, "slot.identifiers.size()");
	}
	
	@Test
	public void slotShouldContainFirstIdentifier() {
		model.assertEquals("Fido", "slot.identifiers.at(0)");
	}
	
	@Test
	public void slotShouldContainSecondIdentifier() {
		model.assertEquals("Lassie", "slot.identifiers.at(1)");
	}
}
