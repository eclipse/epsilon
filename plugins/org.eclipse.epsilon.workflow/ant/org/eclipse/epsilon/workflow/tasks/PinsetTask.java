package org.eclipse.epsilon.workflow.tasks;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.pinset.PinsetModule;

public class PinsetTask extends ExecutableModuleTask {

	protected File outputFolder;

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

	@Override
	protected void configureModule() throws EolModelNotFoundException, BuildException, EolModelLoadingException {
		super.configureModule();

		if (outputFolder != null) {
			((PinsetModule) module).setOutputFolder(outputFolder.getAbsolutePath());
		}
	}

	public File getOutputFolder() {
		return outputFolder;
	}

	public void setOutputFolder(File outputFolder) {
		this.outputFolder = outputFolder;
	}
}
