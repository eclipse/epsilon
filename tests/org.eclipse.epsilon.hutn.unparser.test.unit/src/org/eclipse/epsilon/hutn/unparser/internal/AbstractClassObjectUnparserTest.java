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
package org.eclipse.epsilon.hutn.unparser.internal;

import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;

public abstract class AbstractClassObjectUnparserTest extends AbstractObjectUnparserTest {
	
	public static void classObjectUnparserTest(ClassObject co) {
		EmfUtil.createResource(co);
		
		expected = co;
		unparsed = new ClassObjectUnparser(co).unparse();
	}
	
	
	protected static int numberOfFeatures() {
		if (!bodyContents().contains("\n")) {
			return 0;
		}
		
		return bodyContents().split("\\n").length;
	}
	
	protected static String feature(int index) {
		return bodyContents().split("\\n")[index].trim();
	}
	
	protected static String featureName(int index) {
		return feature(index).split(":")[0].trim();
	}
	
	protected static String featureValues(int index) {
		return feature(index).split(":")[1].trim();
	}
}
