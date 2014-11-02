package org.eclipse.epsilon.eol.models;

import java.util.Collection;

public interface IComparableModel extends IModel {
	
	public Object getElementSignature(Object instance);
	
	public boolean isIdenticalTo(IComparableModel model);
	
	public Collection<Difference> getDifferences(IComparableModel model);
	
	public class Difference {
		
	}
	
	public enum DifferenceType {
		Added,
		Deleted,
		Modified
	}
	
}
