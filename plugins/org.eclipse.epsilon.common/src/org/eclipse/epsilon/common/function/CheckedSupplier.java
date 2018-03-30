package org.eclipse.epsilon.common.function;

import java.util.function.Supplier;

@FunctionalInterface
public interface CheckedSupplier<R, E extends Exception> extends Supplier<R> {
	
	@Override
	default R get() throws RuntimeException {
		try {
			return getThrows();
		}
		catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	R getThrows() throws E;
	
}
