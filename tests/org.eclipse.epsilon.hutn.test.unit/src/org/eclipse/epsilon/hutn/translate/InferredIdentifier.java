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
 * $Id: InferredIdentifier.java,v 1.2 2008/08/07 12:44:20 louis Exp $
 */
package org.eclipse.epsilon.hutn.translate;

import org.eclipse.epsilon.test.util.ModelWithEolAssertions;
import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Ast;
import org.eclipse.epsilon.antlr.postprocessor.model.antlrAst.Node;
import org.junit.BeforeClass;
import org.junit.Test;

public class InferredIdentifier extends HutnTranslatorTest {
	
	private static final String CONFIG_FILE = "../org.eclipse.epsilon.hutn.test.dependencies/models/org/eclipse/epsilon/hutn/test/acceptance/models/FamiliesConfig.model";
	
	private static ModelWithEolAssertions model;
	
	@BeforeClass
	public static void createAstModel() throws Exception {
		final Node attribute = createAttribute("id", "id-001");
		
		final Node classNode = createClass("Family");
		classNode.getChildren().add(attribute);
		
		final Node packageNode = createPackage("FamilyPackage");
		packageNode.getChildren().add(classNode);
		
		final Node configFileAttribute = createAttribute("configFile", CONFIG_FILE);
		
		final Node metaModelClass = createClass("Metamodel", "FamiliesMetaModel");
		metaModelClass.getChildren().add(configFileAttribute);
		
		final Node specPackage = createPackage("@Spec");
		specPackage.getChildren().add(metaModelClass);
		
		final Ast ast = initialiseAst();
		ast.getRoots().add(specPackage);
		ast.getRoots().add(packageNode);
		
		model = translatorTest(ast);
		model.setVariable("package", "spec.objects.first()");
		model.setVariable("class",   "package.slots.first().objects.first()");
	}
	
	@Test
	public void classShouldHaveCorrectInferredIdentifier() {
		model.assertEquals("id-001", "class.identifier");
	}
}
