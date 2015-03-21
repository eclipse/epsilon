package org.eclipse.epsilon.common.dt.examples;

public class ExampleProjectWizard25 extends WebGitProjectNewWizard {
	
	public ExampleProjectWizard25() {
		super("Construct a workflow to orchestrate several Epsilon programs with Ant", "In this example we demonstrate how to use the built-in Epsilon Ant tasks to define a workflow by combining several Epsilon programs. Here, we validate, transform and generate HTML from a flowchart model.", "org.eclipse.epsilon.examples.workflow.flowchart",
				"https://git.eclipse.org", "/c/epsilon/org.eclipse.epsilon.git/plain/examples/org.eclipse.epsilon.examples.workflow.flowchart/");
		
	}

}