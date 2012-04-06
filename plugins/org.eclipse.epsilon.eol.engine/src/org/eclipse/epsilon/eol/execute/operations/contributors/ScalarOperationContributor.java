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

import java.util.Collection;

import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolOrderedSet;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolSet;

public class ScalarOperationContributor extends OperationContributor {
	
	@Override
	public boolean contributesTo(Object target) {
		return !(target instanceof Collection);
	}
	
	public EolSequence asSequence() {
		EolSequence sequence = new EolSequence();
		sequence.add(target);
		return sequence;
	}
	
	public EolSet asSet() {
		EolSet set = new EolSet();
		set.add(target);
		return set;
	}
	
	public EolBag asBag() {
		EolBag bag = new EolBag();
		bag.add(target);
		return bag;
	}
	
	public EolOrderedSet asOrderedSet() {
		EolOrderedSet set = new EolOrderedSet();
		set.add(target);
		return set;
	}
	
	public int size() {
		return 1;
	}
	
}
