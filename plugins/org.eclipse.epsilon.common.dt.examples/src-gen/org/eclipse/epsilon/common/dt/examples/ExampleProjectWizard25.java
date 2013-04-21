package org.eclipse.epsilon.common.dt.examples;

public class ExampleProjectWizard25 extends WebSvnProjectNewWizard {
	
	public ExampleProjectWizard25() {
		super("Use model transactions in a workflow", "In this example we demonstrate using the ant-contrib try/catch tasks and the Epsilon model transactions tasks to conditionally rollback changes in models modified in a workflow.", "org.eclipse.epsilon.examples.workflow.transactions",
				"https://dev.eclipse.org/svnroot/modeling/org.eclipse.epsilon/trunk/examples/org.eclipse.epsilon.examples.workflow.transactions/");
		
	}

}