package org.eclipse.epsilon.eol.function;

import org.eclipse.epsilon.common.function.CheckedFunction;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

@FunctionalInterface
public interface CheckedEolFunction<T, R> extends CheckedFunction<T, R, EolRuntimeException> {
	
	@Override
	default R apply(T t) {
		try {
			return applyThrows(t);
		}
		catch (EolRuntimeException ex) {
			throw new RuntimeException(ex);
		}
	}
}
