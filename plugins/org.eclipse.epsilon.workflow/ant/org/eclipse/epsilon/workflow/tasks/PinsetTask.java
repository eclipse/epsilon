package org.eclipse.epsilon.workflow.tasks;

import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.pinset.PinsetModule;

public class PinsetTask extends ExecutableModuleTask {

	@Override
	protected void initialize() throws Exception {
	}

	@Override
	protected void examine() throws Exception {
	}

	@Override
	protected IEolModule createDefaultModule() throws Exception {
		return new PinsetModule();
	}

}
