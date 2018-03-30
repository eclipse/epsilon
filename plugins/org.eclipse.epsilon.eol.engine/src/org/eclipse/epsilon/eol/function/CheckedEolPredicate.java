package org.eclipse.epsilon.eol.function;

import org.eclipse.epsilon.common.function.CheckedPredicate;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

@FunctionalInterface
public interface CheckedEolPredicate<T> extends CheckedPredicate<EolRuntimeException, T> {
	
	@Override
	default boolean test(T t) {
		try {
			return testThrows(t);
		}
		catch (EolRuntimeException ex) {
			throw new RuntimeException(ex);
		}
	}
}
