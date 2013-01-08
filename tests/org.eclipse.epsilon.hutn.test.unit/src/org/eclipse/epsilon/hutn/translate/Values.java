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
 * $Id: AttributeTypes.java,v 1.3 2008/08/12 12:59:13 louis Exp $
 */
package org.eclipse.epsilon.hutn.translate;

import org.eclipse.epsilon.hutn.exceptions.HutnTranslationException;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;
import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Ast;
import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Node;
import org.junit.Test;

public class Values extends HutnTranslatorTest {
		
	private void attributeTest(Node attributeNode,
	                           Object expectedValue) throws HutnTranslationException {
		
		final Node classNode = createClass("Family", "The Smiths");
		classNode.getChildren().add(attributeNode);
		
		final Node packageNode = createPackage("FamilyPackage");
		packageNode.getChildren().add(classNode);
		
		final Ast ast = initialiseAst();
		ast.getRoots().add(packageNode);
		
		final ModelWithEolAssertions model = translatorTest(ast);
		model.setVariable("package", "spec.objects.first()");
		model.setVariable("class",   "package.classObjects.first()");
				
		if (expectedValue == null)
			model.assertTrue("class.slots.isEmpty()");
		else {
			model.setVariable("slot" ,   "class.slots.at(0)");
			model.assertEquals(expectedValue, "slot.values.first()");
		}
	}
	
	@Test
	public void valueShouldBeNull() throws HutnTranslationException {
		attributeTest(createNullAttribute("null"), null);
	}
	
	@Test
	public void typeShouldBeStringSlot() throws HutnTranslationException {
		attributeTest(createAttribute("name", "The Smiths"), "The Smiths");
	}
	
	@Test
	public void typeShouldBeIntegerSlot() throws HutnTranslationException {
		attributeTest(createAttribute("numberOfChildren", 2), 2);
	}
	
	@Test
	public void typeShouldBeBooleanSlotWhenTrue() throws HutnTranslationException {
		attributeTest(createAttribute("migrant", true), true);
	}
	
	@Test
	public void typeShouldBeBooleanSlotWhenFalse() throws HutnTranslationException {
		attributeTest(createAttribute("nuclear", false), false);
	}
	
	@Test
	public void typeShouldBeBooleanSlotWhenPositiveAdjective() throws HutnTranslationException {
		attributeTest(createAdjective("nuclear"), true);
	}
	
	@Test
	public void typeShouldBeBooleanSlotWhenExplicitPositiveAdjective() throws HutnTranslationException {
		attributeTest(createAdjective("#nuclear"), true);
	}
	
	@Test
	public void typeShouldBeBooleanSlotWhenNegativeAdjective() throws HutnTranslationException {
		attributeTest(createAdjective("~nuclear"), false);
	}
}