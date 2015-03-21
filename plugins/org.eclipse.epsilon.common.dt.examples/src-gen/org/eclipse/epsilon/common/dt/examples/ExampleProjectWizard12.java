package org.eclipse.epsilon.common.dt.examples;

public class ExampleProjectWizard12 extends WebGitProjectNewWizard {
	
	public ExampleProjectWizard12() {
		super("Experiment with the different types of transformation rule in ETL using a Flowchart-to-HTML transformation.", "In this example, we show the different types of transformation rule that are provided by ETL, including plain, abstract, lazy, primary and greedy rules. We also explore rule inheritance and rules that generate more than model element. We transform from a Flowchart model to an HTML model.", "org.eclipse.epsilon.examples.etl.flowchart2html",
				"https://git.eclipse.org", "/c/epsilon/org.eclipse.epsilon.git/plain/examples/org.eclipse.epsilon.examples.etl.flowchart2html/");
		
	}

}