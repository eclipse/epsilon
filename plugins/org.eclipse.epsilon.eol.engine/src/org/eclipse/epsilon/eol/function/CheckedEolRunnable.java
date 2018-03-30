package org.eclipse.epsilon.eol.function;

import org.eclipse.epsilon.common.function.CheckedRunnable;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

@FunctionalInterface
public interface CheckedEolRunnable extends CheckedRunnable<EolRuntimeException> {
	
	@Override
	default void run() {
		try {
			runThrows();
		}
		catch (EolRuntimeException ex) {
			throw new RuntimeException(ex);
		}
	}
}
