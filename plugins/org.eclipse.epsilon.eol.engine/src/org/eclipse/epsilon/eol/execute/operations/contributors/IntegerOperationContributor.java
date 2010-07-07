package org.eclipse.epsilon.eol.execute.operations.contributors;

import org.eclipse.epsilon.eol.types.EolSequence;

public class IntegerOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof Integer;
	}

	public EolSequence to(Integer end) {
		Integer start = (Integer) target;
		EolSequence result = new EolSequence();
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

	public EolSequence iota(int i, int step) throws Exception {
		EolSequence result = new EolSequence();
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

}
