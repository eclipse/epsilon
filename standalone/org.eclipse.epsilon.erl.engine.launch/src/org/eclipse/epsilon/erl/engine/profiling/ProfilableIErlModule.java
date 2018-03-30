package org.eclipse.epsilon.erl.engine.profiling;

import java.util.Collection;
import java.util.function.Consumer;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.function.CheckedEolConsumer;
import org.eclipse.epsilon.eol.function.CheckedEolFunction;
import org.eclipse.epsilon.eol.function.CheckedEolRunnable;
import org.eclipse.epsilon.eol.function.CheckedEolSupplier;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.profiling.BenchmarkUtils;
import org.eclipse.epsilon.profiling.ProfileDiagnostic;

public interface ProfilableIErlModule extends IErlModule {
	
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
