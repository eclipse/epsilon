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
	
	public EolSequence<Object> asSequence() {
		EolSequence<Object> sequence = new EolSequence<Object>();
		sequence.add(target);
		return sequence;
	}
	
	public EolSet<Object> asSet() {
		EolSet<Object>set = new EolSet<Object>();
		set.add(target);
		return set;
	}
	
	public EolBag<Object> asBag() {
		EolBag<Object> bag = new EolBag<Object>();
		bag.add(target);
		return bag;
	}
	
	public EolOrderedSet<Object> asOrderedSet() {
		EolOrderedSet<Object> set = new EolOrderedSet<Object>();
		set.add(target);
		return set;
	}
	
	public int size() {
		return 1;
	}
	
}
