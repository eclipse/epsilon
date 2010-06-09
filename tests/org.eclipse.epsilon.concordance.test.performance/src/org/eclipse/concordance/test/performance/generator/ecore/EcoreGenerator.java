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
package org.eclipse.concordance.test.performance.generator.ecore;

import org.eclipse.concordance.test.performance.generator.AbstractGenerator;
import org.eclipse.emf.ecore.EcorePackage;

public class EcoreGenerator extends AbstractGenerator {

	public EcoreGenerator() {
		super("Ecore", EcorePackage.eNS_URI, EcoreGenerator.class.getResource("GenerateModel.eol"));
	}
}
