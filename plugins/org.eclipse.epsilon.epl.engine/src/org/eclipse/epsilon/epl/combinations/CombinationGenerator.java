package org.eclipse.epsilon.epl.combinations;

import java.util.List;

public interface CombinationGenerator<T> {
	
	public boolean hasMore() throws Exception;
	
	public List<T> getNext() throws Exception;
	
	public void reset();
	
	public void producedValidCombination();
	
}
