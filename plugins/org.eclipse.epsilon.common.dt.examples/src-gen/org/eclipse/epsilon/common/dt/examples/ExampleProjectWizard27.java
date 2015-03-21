package org.eclipse.epsilon.common.dt.examples;

public class ExampleProjectWizard27 extends WebGitProjectNewWizard {
	
	public ExampleProjectWizard27() {
		super("Use model transactions in a workflow", "In this example we demonstrate using the ant-contrib try/catch tasks and the Epsilon model transactions tasks to conditionally rollback changes in models modified in a workflow.", "org.eclipse.epsilon.examples.workflow.transactions",
				"https://git.eclipse.org", "/c/epsilon/org.eclipse.epsilon.git/plain/examples/org.eclipse.epsilon.examples.workflow.transactions/");
		
	}

}