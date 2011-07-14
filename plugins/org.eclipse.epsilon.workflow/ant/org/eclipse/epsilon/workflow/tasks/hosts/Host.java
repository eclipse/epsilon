package org.eclipse.epsilon.workflow.tasks.hosts;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.models.IModel;

public interface Host {
	
	public boolean isRunning();
	
	public void initialise();
	
	public void addNativeTypeDelegates(IEolExecutableModule module);
	
	public void addStopCapabilities(Project project, IEolExecutableModule module);

	public boolean supportsDebugging();
	
	public Object debug(IEolExecutableModule module, File file) throws Exception;
	
	public void configureUserInput(IEolExecutableModule module, boolean isGui);

	public IModel createModel(String type) throws BuildException;
	
}
