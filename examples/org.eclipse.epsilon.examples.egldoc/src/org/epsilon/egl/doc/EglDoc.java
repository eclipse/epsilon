package org.epsilon.egl.doc;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.epsilon.egl.exceptions.EglRuntimeException;
import org.epsilon.eol.exceptions.models.EolModelLoadingException;

public class EglDoc {

	private static String destination  = System.getProperty("user.dir") +
	                                     System.getProperty("file.separator") +
	                                     "output";	// Destination is CWD/output by default
	private static String graphviz     = null;
	private static File   model        = null;
	
	private static boolean destinationFound = false;
	private static boolean graphvizFound    = false;
	
	private static void printUsage() {
		System.out.println("Usage: EglDoc [-destination outputDir] [-dot pathToDot] MetaModelFile");
		System.out.println("where:");
		System.out.println("\toutputDir\tis the directory in which the documentation will be generated.");
		System.out.println("\tpathToDot\tis the path to the GraphViz dot executable.");
		System.out.println("\tMetaModelFile\tis a MOF 2.0 (EMF) conformant meta-model file.");
		System.exit(1);
	}
	
	private static void processArgs(String[] args) {
		if (args.length == 0) {
			printUsage();
		} else {
			for (int count = 0; count < args.length; count++) {
				final String currentArg = args[count];
				
				if (currentArg.equals("-destination")) {
					if (destinationFound || count == args.length-1) {
						printUsage();
					} else {
						destination = args[++count];
						destinationFound = true;
					}
				
				} else if(currentArg.equals("-dot")) {
					if (graphvizFound || count == args.length-1) {
						printUsage();
					} else {
						graphviz = args[++count];
						graphvizFound = true;
					}
					
				} else {
					model = new File(currentArg);
				}
			}
		}
	}
	
	public static void main(String[] args) throws EolModelLoadingException, EglRuntimeException, IOException, URISyntaxException {
		processArgs(args);
		
		new EglDocFacade(graphviz).generate(model, destination);
	}
}
