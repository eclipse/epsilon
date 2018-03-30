package org.eclipse.epsilon.eol.function;

import org.eclipse.epsilon.common.function.CheckedConsumer;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

@FunctionalInterface
public interface CheckedEolConsumer<T> extends CheckedConsumer<T, EolRuntimeException> {
	
	@Override
	default void accept(T t) {
		try {
			acceptThrows(t);
		}
		catch (EolRuntimeException ex) {
			throw new RuntimeException(ex);
		}
	}
}
