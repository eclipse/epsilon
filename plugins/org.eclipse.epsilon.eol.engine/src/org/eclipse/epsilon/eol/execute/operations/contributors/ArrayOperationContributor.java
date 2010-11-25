package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.util.Arrays;

import org.eclipse.epsilon.eol.types.EolSequence;


public class ArrayOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target != null && target.getClass().isArray();
	}
	
	public EolSequence asSequence() {
		EolSequence sequence = new EolSequence();
		sequence.addAll(Arrays.asList(target));
		return sequence;
	}
	
}
