package org.eclipse.epsilon.eunit.operations;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolAssertionException;
import org.eclipse.epsilon.eunit.extensions.IModelComparator;

/**
 * Extended version of {@link EolAssertionException} which tracks the comparator
 * that produces the detected differences.
 */
public class EUnitFailedModelComparisonException extends EolAssertionException {

	private static final long serialVersionUID = -8368177791718138568L;

	private final IModelComparator comparator;

	public EUnitFailedModelComparisonException(String reason, ModuleElement ast, Object expected, Object actual, Object delta, IModelComparator comparator) {
		super(reason, ast, expected, actual, delta);
		this.comparator = comparator;
	}

	public IModelComparator getComparator() {
		return comparator;
	}

}
