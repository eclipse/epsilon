/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * Copyright (c) 2014 University of Twente.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Maarten Bezemer - toBinary, toHex
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.contributors;

import org.eclipse.epsilon.eol.types.EolSequence;

public class IntegerOperationContributor extends OperationContributor {
	
	@Override
	public boolean contributesTo(Object target) {
		return target instanceof Integer;
	}

	public EolSequence<Integer> to(Integer end) {
		Integer start = (Integer) target;
		EolSequence<Integer> result = new EolSequence<>();
		if (start < end) {
			for (int i = start; i <= end; i++) {
				result.add(i);
			}
		} else {
			for (int i = start; i >= end; i--) {
				result.add(i);
			}
		}
		return result;
	}

	public EolSequence<Integer> iota(int i, int step) throws Exception {
		EolSequence<Integer> result = new EolSequence<>();
		int x = (Integer) target;
		if ((step == 0) || (x < i && step < 0) || (x > i && step > 0)) {
			throw new Exception("Invalid argument(s) to iota(i, step)");
		}
		while (x <= i) {
			result.add(x);
			x = x + step;
		}
		return result;
	}

	public String toBinary() {
		Integer i = (Integer) target;
		return Integer.toBinaryString(i);
	}

	public String toHex() {
		Integer i = (Integer) target;
		return Integer.toHexString(i);
	}
	
	public Integer mod(Integer other) {
		return ((Integer) target) % other;
	}
	
}
