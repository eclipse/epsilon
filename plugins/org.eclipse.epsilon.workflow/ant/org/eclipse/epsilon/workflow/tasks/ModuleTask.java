package org.eclipse.epsilon.workflow.tasks;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.profiling.FileMarker;
import org.eclipse.epsilon.commons.profiling.Profiler;
import org.eclipse.epsilon.eol.EolSystem;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.ExtensionPointToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.dt.userinput.JFaceUserInput;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.context.Variable;

public abstract class ModuleTask extends EpsilonTask {

	protected File src;
	protected String code = "";
	protected IEolExecutableModule module;
	protected boolean assertions = true;
	protected String uri;
	protected Object result;
	private boolean isGUI = true;

	public ModuleTask() {
		super();
	}

	@Override
	public String getTaskName() {
		if (src != null) {
			return super.getTaskName() + " - " + src.getName();
		}
		else {
			return super.getTaskName();
		}
	}

	@Override
	public void executeImpl() throws BuildException {
		if (src!=null && profile) {
			Profiler.INSTANCE.start(src.getName(), "", new FileMarker(src,0,0));
		}

		try {
			parseModule();
			configureModule();
			initialize();
			result = module.execute();
			useResults();
			if (src!=null && profile) Profiler.INSTANCE.stop(src.getName());
		}
		catch (Throwable t) {
			if (profile) Profiler.INSTANCE.stop(src.getName());
			if (t instanceof BuildException) {
				throw (BuildException) t;
			}
			else {
				StringWriter sw = new StringWriter();
				t.printStackTrace(new PrintWriter(sw));
				log("EXCEPTION: " + sw.toString(), Project.MSG_ERR);
				throw new BuildException(t);
			}
		}
	}

	protected void useResults() throws Exception {
		examine();
	}

	protected void configureModule() throws EolModelNotFoundException {
		//module.getContext().setUserInput(new EpsilonConsoleUserInput());
		//module.getContext().setUserInput(new AntUserInput(getProject().getInputHandler()));

		// We can only run these if we're inside a real Eclipse instance:
		// we must avoid these calls if we're running the Ant task inside
		// a JUnit test
		if (Platform.getExtensionRegistry() != null) {
			module.getContext().getNativeTypeDelegates().add(new ExtensionPointToolNativeTypeDelegate());
			if (!isGUI()) {
				module.getContext().setUserInput(new JFaceUserInput(module.getContext().getPrettyPrinterManager()));
			}
		}
		module.getContext().setExtendedProperties(getExtendedProperties());

		EolSystem system = new EolSystem();
		system.setContext(module.getContext());
		module.getContext().setAssertionsEnabled(assertions);
		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("System", system));
		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable("null", null));
	}

	private void parseModule() throws Exception {
		module = createModule();
		if (src!=null) {
			module.parse(src);
		}
		else if (uri != null) {
			module.parse(URI.create(uri));
		}
		else {
			module.parse(code);
		}
		if (module.getParseProblems().size() > 0) {
			for (ParseProblem problem : module.getParseProblems()) {
				log(problem.toString(), Project.MSG_ERR);
			}
		}
	}

	public void addText(String msg) {
		if (msg != null) {
			code += getProject().replaceProperties(msg);
		}
	}

	protected abstract void initialize() throws Exception;

	protected abstract void examine() throws Exception;

	protected abstract IEolExecutableModule createModule();

	public File getSrc() {
		return src;
	}

	public void setSrc(File src) {
		this.src = src;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		return uri;
	}

	public boolean isAssertions() {
		return assertions;
	}

	public void setAssertions(boolean assertions) {
		this.assertions = assertions;
	}

	/**
	 * Changes whether Epsilon's graphical user input facilities should be enabled or not.
	 * By default, they are enabled for all tasks except for the EUnit Ant task, in which
	 * they are disabled.
	 */
	public void setGUI(boolean gui) {
		this.isGUI = gui;
	}

	/**
	 * Returns whether Epsilon's graphical user input facilities should be enabled or not.
	 * @see #setGUI(boolean)
	 */
	public boolean isGUI() {
		return isGUI;
	}
}