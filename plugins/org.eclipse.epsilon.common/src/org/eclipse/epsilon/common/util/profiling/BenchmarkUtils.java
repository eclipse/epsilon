/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.common.util.profiling;

import static java.lang.System.nanoTime;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.eclipse.epsilon.common.function.*;
import org.eclipse.epsilon.common.util.profiling.ProfileDiagnostic.MemoryUnit;

/**
 * Utility for performance profiling; mainly for measuring execution times.
 * All long temporal values are assumed to be nanoseconds if not otherwise specified.
 * Similarly, all long memory values are assumed to be in bytes if not otherwise specified.
 * 
 * @author Sina Madani
 */
public final class BenchmarkUtils {
	
	private BenchmarkUtils() {}
	
	public static final MemoryUnit DEFAULT_MEMORY_UNITS = MemoryUnit.MB;
	static final Runtime RT = Runtime.getRuntime();
	
	/**
	 * @param profileInfo the stages profiled.
	 * @param includeTime whether to include execution times.
	 * @param conversionFactor - this parameter has two uses: if it is null, memory won't be included in the results.
	 * If it is present, then the displayed units will be standardized to the specified unit. Otherwise the original
	 * memory units will be used.
	 * 
	 * @return the formatted and raw execution time concerted to milliseconds and memory consumption.
	 * That is, a line-separated String in the form
	 * "<Stage name>: <Execution time in HH:mm:ss.000> (<milliseconds> ms), <Memory consumption> <MemoryUnits>".
	 */
	static String formatExecutionStages(Iterable<ProfileDiagnostic> profileInfo, boolean includeTime, Optional<MemoryUnit> conversionFactor) {
		StringBuilder formatted = new StringBuilder();
		for (ProfileDiagnostic pd : profileInfo) {
			formatted.append(pd.stageName+": ");
			if (includeTime) {
				formatted.append(formatDuration(pd.executionTime)+" ("+pd.executionTime.toMillis()+" ms)");
			}
			if (conversionFactor != null) {
				if (includeTime) {
					formatted.append(", ");
				}
				
				formatted.append(formatMemory(pd, conversionFactor));
			}
			
			formatted.append(System.lineSeparator());
		}
		return formatted.toString();
	}
	
	/**
	 * NOTE: Only durations less than 24 hours are supported.
	 */
	public static String formatDuration(Duration duration) {
    	String pattern = "";
    	if (duration.toHours() >= 1)
    		pattern += "H:";
    	if (duration.toMinutes() >= 1)
    		pattern += "mm:";
    	if (duration.getSeconds() >= 1)
    		pattern += "ss.";
    	pattern += "SSS";
        return LocalTime.MIDNIGHT.plus(duration).format(DateTimeFormatter.ofPattern(pattern));
    }
	
	public static Duration getTotalExecutionTimeFrom(Collection<ProfileDiagnostic> profiledStages) {
		return Duration.ofNanos(profiledStages
			.stream()
			.mapToLong(pd -> pd.executionTime.toNanos())
			.sum()
		);
	}

	//Memory Utils
	
	/**
	 * @return The sum of peak memory usage for all memory pools.
	 */
	public static long getTotalMemoryUsage() {
		return ManagementFactory.getMemoryPoolMXBeans()
			.stream()
			.map(MemoryPoolMXBean::getPeakUsage)
			.filter(usage -> usage != null)
			.mapToLong(MemoryUsage::getUsed)
			.sum();
	}
	
	public static long getCurrentMemoryUsage() {
		return RT.totalMemory() - RT.freeMemory();
	}
	
	public static String getTime() {
		return LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
	}
	
	public static String formatMemory(ProfileDiagnostic pd, Optional<MemoryUnit> conversionFactor) {
		String formatted;
		if (conversionFactor.isPresent()) {
			MemoryUnit cf = conversionFactor.get();
			formatted = (long) MemoryUnit.convertUnits(pd.memoryUnits, cf, pd.memoryUsage)+" "+cf;
		}
		else {
			formatted = (pd.memoryUsage+" "+pd.memoryUnits);
		}
		return formatted;
	}
	
	public static String getAvailableMemory(MemoryUnit units) {
		return formatMemory(RT.totalMemory(), units);
	}
	
	public static String getMaxMemory(MemoryUnit units) {
		return formatMemory(RT.maxMemory(), units);
	}
	
	public static String formatMemory(long amountInBytes, MemoryUnit units) {
		MemoryUnit mu = units != null ? units : DEFAULT_MEMORY_UNITS;
		return (long) MemoryUnit.convertFromBytes(mu, amountInBytes)+" "+mu.name();
	}
	
	//CPU utils
	
	public static int getNumberOfHardwareThreads() {
		return RT.availableProcessors();
	}
	
	//Profile utils
	
	public static <T, R, E extends Exception> R profileExecutionStage(Collection<ProfileDiagnostic> profileInfo, String description, CheckedFunction<T, R, E> code, T argument) throws E {
		System.gc();
		final long
			endTime, endMemory,
			startMemory = getCurrentMemoryUsage(),
			startTime = nanoTime();
		
		R result = code.applyThrows(argument);
		
		endTime = nanoTime();
		System.gc();
		endMemory = getCurrentMemoryUsage();
		
		addProfileInfo(profileInfo, description, endTime-startTime, endMemory-startMemory);
		return result;
	}
	
	public static <T, E extends Exception> void profileExecutionStage(Collection<ProfileDiagnostic> profileInfo, String description, CheckedConsumer<T, E> code, T argument) throws E {
		CheckedFunction<T, Void, E> funcEquivalent = t -> {
			code.acceptThrows(t);
			return null;
		};
		profileExecutionStage(profileInfo, description, funcEquivalent, argument);
	}
	
	public static <R, E extends Exception> R profileExecutionStage(Collection<ProfileDiagnostic> profileInfo, String description, CheckedSupplier<R, E> code) throws E {
		CheckedFunction<Void, R, E> funcEquivalent = v -> code.getThrows();
		return profileExecutionStage(profileInfo, description, funcEquivalent, null);
	}
	
	public static <E extends Exception> void profileExecutionStage(Collection<ProfileDiagnostic> profileInfo, String description, CheckedRunnable<E> code) throws E {
		CheckedFunction<Void, Void, E> funcEquivalent = v -> {
			code.runThrows();
			return null;
		};
		profileExecutionStage(profileInfo, description, funcEquivalent, null);
	}
	
	
	public static <T, R> R profileExecutionStage(Collection<ProfileDiagnostic> profileInfo, String description, Function<T, R> code, T argument) {
		CheckedFunction<T, R, RuntimeException> checkedEquivalent = code::apply;
		return profileExecutionStage(profileInfo, description, checkedEquivalent, argument);
	}
	
	public static <T> void profileExecutionStage(Collection<ProfileDiagnostic> profileInfo, String description, Consumer<T> code, T argument) {
		CheckedConsumer<T, RuntimeException> checkedEquivalent = code::accept;
		profileExecutionStage(profileInfo, description, checkedEquivalent, argument);
	}
	
	public static <R> R profileExecutionStage(Collection<ProfileDiagnostic> profileInfo, String description, Supplier<R> code) {
		CheckedSupplier<R, RuntimeException> checkedEquivalent = code::get;
		return profileExecutionStage(profileInfo, description, checkedEquivalent);
	}
	
	public static void profileExecutionStage(Collection<ProfileDiagnostic> profileInfo, String description, Runnable code) {
		CheckedRunnable<RuntimeException> checkedEquivalent = code::run;
		profileExecutionStage(profileInfo, description, checkedEquivalent);
	}
	
	
	//Temporal utils
	
	public static <T, E extends Exception> long measureTimeNanos(CheckedConsumer<T, E> code, T argument) throws E {
		final long endTime, startTime = nanoTime();
		code.acceptThrows(argument);
		endTime = nanoTime();
		return endTime-startTime;
	}
	
	public static <E extends Exception> long measureTimeNanos(CheckedRunnable<E> code) throws E {
		CheckedConsumer<Void, E> consEquivalent = v -> code.run();
		return measureTimeNanos(consEquivalent, null);
	}
	
	public static long measureTimeNanos(Runnable code) {
		CheckedRunnable<RuntimeException> checkedEquivalent = () -> code.run();
		return measureTimeNanos(checkedEquivalent);
	}
	
	public static <T> long measureTimeNanos(Consumer<T> code, T argument) {
		CheckedConsumer<T, RuntimeException> checkedEquivalent = code::accept;
		return measureTimeNanos(checkedEquivalent, argument);
	}
	
	
	//Format utils
	
	public static void addProfileInfo(Collection<ProfileDiagnostic> profileStages, String stage, long nanos, long memory) {
		profileStages.add(new ProfileDiagnostic(stage, Duration.ofNanos(nanos), (double) memory, MemoryUnit.BYTES));
	}
	
	public static String formatExecutionStages(Iterable<ProfileDiagnostic> profileInfo) {
		return formatExecutionStages(profileInfo, true, Optional.of(DEFAULT_MEMORY_UNITS));
	}
	
	public static String formatMemoryConsumption(Iterable<ProfileDiagnostic> profileInfo, MemoryUnit units) {
		return formatExecutionStages(profileInfo, false, Optional.ofNullable(units));
	}
	
	public static String formatExecutionTimes(Iterable<ProfileDiagnostic> profileInfo) {
		return formatExecutionStages(profileInfo, true, null);
	}
	
	public static String formatExecutionTime(Duration time) {
		return formatExecutionTime("Execution time", time);
	}
	
	public static String formatExecutionTime(String title, Duration time) {
		return formatExecutionTimes(Collections.singleton(new ProfileDiagnostic(title, time, 0, MemoryUnit.BYTES)));
	}
	
	public static String formatExecutionTime(long nanos) {
		return formatExecutionTime(Duration.ofNanos(nanos));
	}
	
	public static String formatExecutionTime(String title, long nanos) {
		return formatExecutionTime(title, Duration.ofNanos(nanos));
	}
	
	public static String formatMillis(long millis) {
		return formatDuration(Duration.ofMillis(millis));
	}
	
	public static String formatNanos(long nanos) {
		return formatDuration(Duration.ofNanos(nanos));
	}
	
	public static long nanosToMillis(long nanos) {
		return Duration.ofNanos(nanos).toMillis();
	}
}