package org.eclipse.epsilon.common.dt.examples;

public class ExampleProjectWizard24 extends WebGitProjectNewWizard {
	
	public ExampleProjectWizard24() {
		super("Compare, validate and merge OO models", "In this example, we use ECL to compare two OO models, then use EVL to check the identified matches for consistency and finally EML to merge them.", "org.eclipse.epsilon.examples.oomerging",
				"https://git.eclipse.org", "/c/epsilon/org.eclipse.epsilon.git/plain/examples/org.eclipse.epsilon.examples.oomerging/");
		
	}

}