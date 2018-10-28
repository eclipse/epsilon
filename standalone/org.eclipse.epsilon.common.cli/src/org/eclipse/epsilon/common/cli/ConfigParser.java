/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.common.cli;

import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.commons.cli.*;
import org.eclipse.epsilon.common.launch.ProfilableRunConfiguration;

/**
 * Convenience class providing an extensible command-line builder for {@link ProfilableRunConfiguration}.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ConfigParser<R extends ProfilableRunConfiguration<?>> implements Consumer<String[]>, Function<String[], R> {
	
	// The variables to be parsed
	public Optional<Boolean> profileExecution, showResults;
	public Optional<Path> outputFile;
	public Path script;
	public Optional<Integer> id = Optional.empty();
	public R runConfig;
	
	protected String
		nL = System.lineSeparator(),
		profileExecutionOpt = "profile",
		showResultsOpt = "results",
		outFileOpt = "outfile",
		requiredUsage = "  [absolute path to script] "+nL,
		optionalUsage = "  [show results] "+nL
		  + "  [profile execution] "+nL
		  + "  [output file] "+nL;
	
	protected String formatUsage() {
		return  nL+"Required: " + nL + requiredUsage + nL + "Optional: " + nL + optionalUsage + nL;
	}
	
	protected Options options = new Options()
		.addOption("h", false, "help")
		.addOption(profileExecutionOpt, false, "Whether to profile execution time and memory usage.")
		.addOption(showResultsOpt, false, "Whether to output the results.")
		.addOption(outFileOpt, true, "Specify a path to output file.");
	
	protected HelpFormatter help = new HelpFormatter();
	protected CommandLine cmdLine;
	
	protected void parseArgs(String[] args) throws Exception {
		cmdLine = new DefaultParser().parse(options, args);
		
		if (cmdLine.hasOption('h') || cmdLine.hasOption("help")) {
			help.printHelp(formatUsage(), options);
		}
		
		profileExecution = Optional.of(cmdLine.hasOption(profileExecutionOpt));
		showResults = Optional.of(cmdLine.hasOption(showResultsOpt));
		
		outputFile = cmdLine.hasOption(outFileOpt) ?
			Optional.of(Paths.get(cmdLine.getOptionValue(outFileOpt))) :
			Optional.empty();
		
		script = Paths.get(args[0]);
	}
	
	protected void handleException(Exception ex) {
		System.err.print("Invalid arguments: ");
		ex.printStackTrace();
		
		try (PrintWriter outWriter = new PrintWriter(System.out)) {
			help.printUsage(outWriter, 80, formatUsage(), options);
		}
	}
	
	@Override
	public final void accept(String[] args) {
		try {
			parseArgs(args);
		}
		catch (Exception ex) {
			handleException(ex);
		}
	}
	

	@Override
	public final R apply(String[] args) {
		accept(args);
		return runConfig;
	}
}