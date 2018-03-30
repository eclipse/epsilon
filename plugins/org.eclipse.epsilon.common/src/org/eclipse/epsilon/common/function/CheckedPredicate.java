package org.eclipse.epsilon.common.function;

import java.util.function.Predicate;

@FunctionalInterface
public interface CheckedPredicate<E extends Exception, T> extends Predicate<T> {
	
	@Override
	default boolean test(T t) throws RuntimeException {
		try {
			return testThrows(t);
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	boolean testThrows(T t) throws E;
	
}
