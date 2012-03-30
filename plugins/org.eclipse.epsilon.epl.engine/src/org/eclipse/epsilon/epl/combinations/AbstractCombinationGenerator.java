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
