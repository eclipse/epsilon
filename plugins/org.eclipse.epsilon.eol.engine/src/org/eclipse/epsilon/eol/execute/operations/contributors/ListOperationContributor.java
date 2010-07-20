package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.util.List;

public class ListOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof List;
	}
	
	
	public Object removeAt(int index) {
		return ((List) target).remove(index);
	}
	
}
