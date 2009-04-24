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
import org.eclipse.epsilon.hutn.model.hutn.Spec;

public abstract class AbstractSpecUnparserTest {

	protected static String unparsed;
	protected static Spec expected;
	
	public static void specUnparserTest(Spec spec) {
		EmfUtil.createResource(spec);
		
		expected = spec;
		unparsed = new SpecUnparser(spec).unparse();
	}
	
	protected static int numberOfPackageObjects() {
		int size = 0;
				
		if (unparsed.contains("@Spec {"))
			size++;
		
		if (unparsed.contains("families  {"))
			size++;
		
		return size;
	}
	
	protected static String packageObject(int index) {
		if (numberOfPackageObjects() == 1)
			return unparsed.trim();
		
		else {
			String[] packages = new String[] { unparsed.split("families {")[0],
			                                   "families {" + unparsed.split("families {")[1]};
			
			return packages[index].trim();
		}
	}
}
