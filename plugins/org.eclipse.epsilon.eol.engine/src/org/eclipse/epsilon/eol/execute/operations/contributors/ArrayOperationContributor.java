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
package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.util.Arrays;

import org.eclipse.epsilon.eol.types.EolSequence;


public class ArrayOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target != null && target.getClass().isArray();
	}
	
	public EolSequence asSequence() {
		EolSequence sequence = new EolSequence();
		sequence.addAll(Arrays.asList(target));
		return sequence;
	}
	
}
