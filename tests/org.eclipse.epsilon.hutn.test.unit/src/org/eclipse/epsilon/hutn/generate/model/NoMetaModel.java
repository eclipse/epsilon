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
 * $Id: NoMetaModel.java,v 1.2 2008/08/07 12:44:20 louis Exp $
 */
package org.eclipse.epsilon.hutn.generate.model;

import static org.eclipse.epsilon.hutn.test.util.HutnUtil.createSpec;

import org.eclipse.epsilon.hutn.exceptions.HutnGenerationException;
import org.junit.Test;

public class NoMetaModel extends HutnModelGeneratorTest {

	@Test(expected=IllegalArgumentException.class)
	public void modelShouldHaveNoFamilies() throws HutnGenerationException {
		modelGeneratorTest(createSpec());
	}
}