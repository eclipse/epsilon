package org.eclipse.epsilon.common.function;

import java.util.function.Function;

@FunctionalInterface
public interface CheckedFunction<T, R, E extends Exception> extends Function<T, R> {
	
	@Override
	default R apply(T t) throws RuntimeException {
		try {
			return applyThrows(t);
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	R applyThrows (T t) throws E;
	
}
