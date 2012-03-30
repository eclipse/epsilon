package org.eclipse.epsilon.epl.combinations;

import java.util.List;

public interface CombinationGeneratorListener<T> {
	
	public void generated(List<T> next);
	
	public void reset();
	
}
