package org.eclipse.epsilon.common.function;

import java.util.function.Consumer;

@FunctionalInterface
public interface CheckedConsumer<T, E extends Exception> extends Consumer<T> {
	
	@Override
	default void accept(T t) throws RuntimeException {
		try {
			acceptThrows(t);
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	void acceptThrows(T t) throws E;
	
}
