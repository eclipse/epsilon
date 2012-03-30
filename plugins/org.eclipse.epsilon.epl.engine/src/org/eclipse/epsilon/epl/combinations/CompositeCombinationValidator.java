package org.eclipse.epsilon.epl.combinations;

import java.util.List;

public interface CompositeCombinationValidator<T> {
	
	public boolean isValid(List<List<T>> combination) throws Exception ;
	
}
