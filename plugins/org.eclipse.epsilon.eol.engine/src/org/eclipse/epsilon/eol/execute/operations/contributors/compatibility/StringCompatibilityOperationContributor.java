/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.contributors.compatibility;

import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;

public class StringCompatibilityOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof String;
	}

	/**
	 * In the previous version of EOL, EolString.replace
	 * mapped to String.replaceAll.
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public String replace(String regex, String replacement) {
		return ((String) target).replaceAll(regex, replacement);
	}

	/** Java charAt returns a 'char', but EOL does not have that primitive type, so we redefine it to return a String. */
	public String charAt(int index) {
		return ((String) target).charAt(index) + "";
	}
}
