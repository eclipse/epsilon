package org.eclipse.epsilon.erl.engine.profiling;

import java.util.Collection;
import java.util.function.Consumer;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.function.*;
import org.eclipse.epsilon.profiling.util.*;

public interface ProfilableIEolModule extends IEolModule {
	
	Collection<ProfileDiagnostic> getProfiledStages();
	
	default void profileExecution(Consumer<EolRuntimeException> exceptionHandler) {
		try {
			profileExecution();
		}
		catch (EolRuntimeException | RuntimeException rx) {
			exceptionHandler.accept(EolRuntimeException.findCause(rx));
		}
	}
	
	default void addProfileInfo(String stage, long nanos, long memory) {
		BenchmarkUtils.addProfileInfo(getProfiledStages(), stage, nanos, memory);
	}
	
	default Object profileExecution() throws EolRuntimeException {
		return BenchmarkUtils.profileExecutionStage(getProfiledStages(), "execute()", this::execute);
	}
	
	default <T, R> R profileExecutionStage(String description, CheckedEolFunction<T, R> code, T argument) throws EolRuntimeException {
		return BenchmarkUtils.profileExecutionStage(getProfiledStages(), description, code, argument);
	}
	default <R> R profileExecutionStage(String description, CheckedEolSupplier<R> code) throws EolRuntimeException {
		return BenchmarkUtils.profileExecutionStage(getProfiledStages(), description, code);
	}
	default <T> void profileExecutionStage(String description, CheckedEolConsumer<T> code, T argument) throws EolRuntimeException {
		BenchmarkUtils.profileExecutionStage(getProfiledStages(), description, code, argument);
	}
	default void profileExecutionStage(String description, CheckedEolRunnable code) throws EolRuntimeException {
		BenchmarkUtils.profileExecutionStage(getProfiledStages(), description, code);
	}
}
