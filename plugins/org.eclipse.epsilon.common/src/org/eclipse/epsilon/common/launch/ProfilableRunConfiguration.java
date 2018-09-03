/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.common.launch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import org.eclipse.epsilon.common.util.OperatingSystem;
import org.eclipse.epsilon.common.util.profiling.ProfileDiagnostic;
import static org.eclipse.epsilon.common.util.profiling.BenchmarkUtils.*;
import org.eclipse.epsilon.common.util.profiling.ProfileDiagnostic.MemoryUnit;

public abstract class ProfilableRunConfiguration<R> implements Runnable {
	
	protected String printMarker = "-----------------------------------------------------";
	protected int id;
	public final boolean showResults, profileExecution;
	public final Path script, outputFile;
	protected final Collection<ProfileDiagnostic> profiledStages;
	protected boolean hasRun = false;
	protected R result;
	
	protected ProfilableRunConfiguration(
		Path scriptFile,
		Optional<Boolean> showResults,
		Optional<Boolean> profileExecution,
		Optional<Integer> configID,
		Optional<Path> scratchFile) {
			this.script = scriptFile;
			this.showResults = showResults.orElse(false);
			this.profileExecution = profileExecution.orElse(true);
			this.outputFile = scratchFile.orElse(null);
			this.profiledStages = new LinkedList<>();
			this.id = configID.orElseGet(() ->
				Objects.hash(
					Objects.toString(scriptFile)
				)
			);
	}
	
	protected ProfilableRunConfiguration(ProfilableRunConfiguration<? extends R> other) {
		this(
			other.script,
			Optional.of(other.showResults),
			Optional.of(other.profileExecution),
			Optional.of(other.id),
			Optional.ofNullable(other.outputFile)
		);
		this.result = other.result;
	}
	
	@Override
	public final void run() {
		try {
			preExecute();
			result = execute();
			postExecute();
		}
		catch (Exception ex) {
			handleException(ex);
		}
		hasRun = true;
	}
	
	protected void handleException(Exception ex) {
		ex.printStackTrace();
	}
	
	protected void preExecute() throws Exception {
		if (outputFile != null) {
			Path parent = outputFile.getParent();
			if (parent != null) {
				Files.createDirectories(parent);
			}
		}
		if (profileExecution) {
			writeOut(
				OperatingSystem.getCpuName(),
				"Logical processors: "+getNumberOfHardwareThreads(),
				"Xms: "+getAvailableMemory(MemoryUnit.MB),
				"Xmx: "+getMaxMemory(MemoryUnit.MB),
				"Starting execution at "+getTime(),
				printMarker
			);
		}
	}
	
	protected abstract R execute() throws Exception;
	
	protected void postExecute() throws Exception {
		if (profileExecution) {
			writeOut("",
				"Profiled processes:",
				formatExecutionStages(profiledStages),
				"Finished at "+getTime(),
				printMarker
			);
		}
		if (showResults) {
			writeOut("Result: ", "", result, printMarker);
		}
	}
	
	public Duration getExecutionTime() {
		if (!hasRun) {
			throw new IllegalStateException("Not yet run!");
		}
		return getTotalExecutionTimeFrom(profiledStages);
	}
	
	public R getResult() {
		if (!hasRun)
			throw new IllegalStateException("Attempted to get result without calling run()!");
		
		return result;
	}
	
	public int getId() {
		return id;
	}
	
	protected final void writeOut(Object... lines) {
		writeOut(Arrays.asList(lines));
	}
	
	protected void writeOut(Collection<?> lines) {
		if (outputFile != null) {
			try {
				Files.write(
					outputFile,
					lines.stream().map(Object::toString).collect(Collectors.toList()),
					StandardOpenOption.APPEND, StandardOpenOption.CREATE, StandardOpenOption.WRITE
				);
				return;
			}
			catch (IOException iox) {
				System.err.println("Couldn't write to file '"+outputFile+"': "+iox.getMessage());
			}
		}
		//Fall back to stdout if couldn't write to file
		lines.forEach(System.out::println);
	}
	
	@Override
	public String toString() {
		return
			getClass().getSimpleName()+
			": id="+id+
			", script='"+Objects.toString(script.getFileName())+"'";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, script, showResults, profileExecution, outputFile);
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof ProfilableRunConfiguration))
			return false;
		
		ProfilableRunConfiguration<?> prc = (ProfilableRunConfiguration<?>) other;
		return
			Objects.equals(this.id, prc.id) &&
			Objects.equals(this.script, prc.script) &&
			Objects.equals(this.showResults, prc.showResults) &&
			Objects.equals(this.profileExecution, prc.profileExecution) &&
			Objects.equals(this.outputFile, prc.outputFile) &&
			Objects.equals(this.result, prc.result);
	}
}
