/*******************************************************************************
 * Copyright (c) 2008 The University of York.
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
package org.eclipse.epsilon.hutn.xmi.test.unit.util;

import org.eclipse.epsilon.hutn.test.model.families.FamiliesFactory;
import org.eclipse.epsilon.hutn.test.model.families.Model;
import org.eclipse.epsilon.hutn.test.model.families.NamedElement;

public abstract class ModelFactory {

	private ModelFactory() {}
	
	public static Model createModel(NamedElement... contents) {
		final Model model = FamiliesFactory.eINSTANCE.createModel();
		
		for (NamedElement content : contents) {
			model.getContents().add(content);
		}
		
		return model;
	}
}
