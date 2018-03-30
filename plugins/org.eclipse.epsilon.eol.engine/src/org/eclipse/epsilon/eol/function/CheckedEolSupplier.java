package org.eclipse.epsilon.eol.function;

import org.eclipse.epsilon.common.function.CheckedSupplier;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

@FunctionalInterface
public interface CheckedEolSupplier<R> extends CheckedSupplier<R, EolRuntimeException> {
	
	@Override
	default R get() {
		try {
			return getThrows();
		}
		catch (EolRuntimeException ex) {
			throw new RuntimeException(ex);
		}
	}
}
