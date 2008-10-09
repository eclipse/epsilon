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
 * $Id: EmptyAst.java,v 1.2 2008/08/07 12:44:21 louis Exp $
 */
package org.eclipse.epsilon.hutn.translate;

import org.eclipse.epsilon.hutn.test.util.ModelWithEolAssertions;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmptyAst extends HutnTranslatorTest {
	
	private static ModelWithEolAssertions model;
	
	@BeforeClass
	public static void createAstModel() throws Exception {		
		model = translatorTest(initialiseAst());
	}
	
	@Test
	public void specShouldHaveNoObjects() {
		model.assertEquals(0, "spec.objects.size()");
	}
	
	@Test
	public void specShouldHaveNoNsUris() {
		model.assertEquals(0, "spec.nsUris.size()");
	}
}
