/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.epl.combinations;

import java.util.List;

public abstract class AbstractCombinationGenerator<T> implements CombinationGenerator<T>{
	
	protected int index = 0;
	
	@Override
	public abstract boolean hasMore();

	@Override
	public List<T> getNext() {
		index++;
		return getNextImpl();
	}
	
	protected abstract List<T> getNextImpl();
	
	@Override
	public void reset() {
		resetImpl();
		index = 0;
	}

	protected abstract void resetImpl();
	
}
