package org.eclipse.epsilon.workflow.tasks.emf;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.workflow.tasks.EpsilonTask;

public class RegisterTaskStandalone extends EpsilonTask {
	
	protected File file;
	protected boolean permanently = false;
	
	@Override
	public void executeImpl() throws BuildException {
		if (!file.exists()) {
			fail("File " + file.getAbsolutePath() + " doesn't exist", null);
		}
		
		try {
			EmfUtil.register(file, EPackage.Registry.INSTANCE);
			if (permanently) {
			    warn("permanent is not supported in standalone mode");
			}
		}
		catch (Exception e) {
			fail(e.getMessage(), e);
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public boolean isPermanently() {
		return permanently;
	}

	public void setPermanently(boolean permanently) {
		this.permanently = permanently;
	}
}
