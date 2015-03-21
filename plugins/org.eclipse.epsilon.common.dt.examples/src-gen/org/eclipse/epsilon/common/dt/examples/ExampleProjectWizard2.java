package org.eclipse.epsilon.common.dt.examples;

public class ExampleProjectWizard2 extends WebGitProjectNewWizard {
	
	public ExampleProjectWizard2() {
		super("Modify a Tree model with EOL", "In this example we use EOL to programmatically modify a model that conforms to a Tree metamodel and store the modified version as a new model.", "org.eclipse.epsilon.examples.modelmodification",
				"https://git.eclipse.org", "/c/epsilon/org.eclipse.epsilon.git/plain/examples/org.eclipse.epsilon.examples.modelmodification/");
		
	}

}