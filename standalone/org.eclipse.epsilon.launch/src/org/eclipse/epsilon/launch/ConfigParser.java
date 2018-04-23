package org.eclipse.epsilon.launch;

import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Consumer;
import org.apache.commons.cli.*;

/*
 * Convenience class providing an extensible command-line builder for {@link ProfilableRunConfiguration}.
 * 
 * @author Sina Madani
 */
public class ConfigParser implements Consumer<String[]> {
	
	//The variables to be parsed
	public Optional<Boolean> profileExecution, showResults;
	public Path script;
	public Optional<Path> outputFile;
	public Optional<Integer> id = Optional.empty();
	
	protected String
		nL = System.lineSeparator(),
		lang = "script",
		profileExecutionOpt = "profile",
		showResultsOpt = "results",
		outFileOpt = "outfile",
		requiredUsage = "  [absolute path to "+lang+" file] "+nL,
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
		
		script = Paths.get(args[0]);
		profileExecution = Optional.of(cmdLine.hasOption(profileExecutionOpt));
		showResults = Optional.of(cmdLine.hasOption(showResultsOpt));
		
		outputFile = cmdLine.hasOption(outFileOpt) ?
			Optional.of(Paths.get(cmdLine.getOptionValue(outFileOpt))) :
			Optional.empty();
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
}