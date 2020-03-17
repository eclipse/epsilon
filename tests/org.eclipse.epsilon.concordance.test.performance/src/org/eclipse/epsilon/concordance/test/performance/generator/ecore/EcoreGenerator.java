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
package org.eclipse.epsilon.concordance.test.performance.generator.ecore;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.concordance.test.performance.generator.AbstractGenerator;

public class EcoreGenerator extends AbstractGenerator {

	public EcoreGenerator() {
		super("Ecore", EcorePackage.eNS_URI, EcoreGenerator.class.getResource("GenerateModel.eol"));
	}
}
