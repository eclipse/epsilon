/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.eclipse.core.runtime.Platform;
import org.eclipse.epsilon.common.dt.console.EolRuntimeExceptionHyperlinkListener;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.profiling.FileMarker;
import org.eclipse.epsilon.commons.profiling.Profiler;
import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.epsilon.eol.EolSystem;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.ExtensionPointToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.dt.userinput.JFaceUserInput;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.ModelRepository;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.workflow.tasks.nestedelements.ModelNestedElement;
import org.eclipse.epsilon.workflow.tasks.nestedelements.ParameterNestedElement;
import org.eclipse.epsilon.workflow.tasks.nestedelements.VariableNestedElement;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IOConsole;

public abstract class ExecutableModuleTask extends EpsilonTask {
	
	protected List<ModelNestedElement> modelNestedElements = new ArrayList<ModelNestedElement>();
	protected List<VariableNestedElement> usesVariableNestedElements = new ArrayList<VariableNestedElement>();
	protected List<VariableNestedElement> exportsVariableNestedElements = new ArrayList<VariableNestedElement>();
	protected List<ParameterNestedElement> parameterNestedElements = new ArrayList<ParameterNestedElement>();
	protected File src;
	protected String code = "";
	protected IEolExecutableModule module;
	protected boolean assertions = true;
	protected String uri;
	protected Object result;
	private boolean isGUI = true;

	static {
		if (ConsolePlugin.getDefault() != null) {
			for (IConsole c : ConsolePlugin.getDefault().getConsoleManager().getConsoles()) {
				if (c instanceof IOConsole) {
					IOConsole ioConsole = ((IOConsole) c);
					ioConsole.addPatternMatchListener(new EolRuntimeExceptionHyperlinkListener(ioConsole));
				}
			}
		}
	}

	public ModelNestedElement createModel() {
		ModelNestedElement model = new ModelNestedElement();
		modelNestedElements.add(model);
		return model;
	}
	
	public VariableNestedElement createUses() {
		VariableNestedElement variableNestedElement = new VariableNestedElement();
		usesVariableNestedElements.add(variableNestedElement);
		return variableNestedElement;
	}
	
	public VariableNestedElement createExports() {
		VariableNestedElement variableNestedElement = new VariableNestedElement();
		exportsVariableNestedElements.add(variableNestedElement);
		return variableNestedElement;
	}
	
	public ParameterNestedElement createParameter() {
		ParameterNestedElement parameterNestedElement = new ParameterNestedElement();
		parameterNestedElements.add(parameterNestedElement);
		return parameterNestedElement;
	}

	protected void configureModule() throws EolModelNotFoundException, BuildException {
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

		populateModelRepository();
		accessParameters();
		useVariables();
	}

	protected void useResults() throws Exception {
		exportVariables();
		examine();
	}

	private void populateModelRepository() throws EolModelNotFoundException {
		ModelRepository repository = module.getContext().getModelRepository();
		ModelRepository projectRepository = getProjectRepository();
		for (ModelNestedElement modelNestedElement : modelNestedElements) {
			IModel model = projectRepository.getModelByName(modelNestedElement.getRef());
			ModelReference reference = new ModelReference(model);
			if (modelNestedElement.getAs() != null) {
				reference.setName(modelNestedElement.getAs());
			}
			if (modelNestedElement.getAlias() != null) {
				reference.getAliases().addAll(StringUtil.split(modelNestedElement.getAlias(), ","));
			}
			repository.addModel(reference);
		}
	}
	
	private void accessParameters() {
		for (ParameterNestedElement parameterNestedElement : parameterNestedElements) {
			module.getContext().getFrameStack().getGlobals().put(
					Variable.createReadOnlyVariable(
							parameterNestedElement.getName(), 
							parameterNestedElement.getValue()
			));
		}
	}
	
	private void useVariables() throws BuildException {
		for (VariableNestedElement usesVariableNestedElement : usesVariableNestedElements) {
			useVariable(usesVariableNestedElement.getRef(),
					usesVariableNestedElement.getAs(),
					usesVariableNestedElement.isOptional());
		}		
	}

	private void exportVariables() {
		for (VariableNestedElement exportVariableNestedElement : exportsVariableNestedElements) {
			exportVariable(
					exportVariableNestedElement.getRef(),
					exportVariableNestedElement.getAs(),
					exportVariableNestedElement.isOptional());
		}
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

	protected void useVariable(final String var, final String as, final boolean optional) {
		Variable usedVariable = getProjectStackFrame().get(var);

		// FIXME : Remove this hack using a proper design!
		if (usedVariable != null) {
			Object value = usedVariable.getValue();
			if (value instanceof IModel) {
				IModel model = (IModel) value;
				ModelReference reference = new ModelReference(model);
				if (as != null) {
					reference.setName(as);
				}
				else {
					reference.setName(var);
				}
				module.getContext().getModelRepository().addModel(reference);
				return;
			}
		}
		// ENDFIXME

		if (usedVariable == null) {
			if (getProject().getProperty(var) != null) {
				usedVariable = new Variable(var, getProject().getProperty(var), EolPrimitiveType.String);
			}
		}

		if (usedVariable == null && !optional) throw new BuildException("Undefined variable " + var);
		if (as != null) {
			usedVariable.setName(as);
		}
		module.getContext().getFrameStack().getGlobals().put(usedVariable);
	}

	protected void exportVariable(String var, String as, final boolean optional) {
		Variable exportedVariable = module.getContext().getFrameStack().get(var);
	
		// FIXME : 2nd part of the hack
		if (exportedVariable == null) {
			IModel model = module.getContext().getModelRepository().getModelByNameSafe(var);
			if (model != null) {
				exportedVariable = Variable.createReadOnlyVariable(var, model);
			}
		}
		// ENDFIXME

		if (exportedVariable != null) {
			if (as != null) {
				exportedVariable.setName(as);
			}
			getProjectStackFrame().put(exportedVariable);
		} else {
			if (!optional) {
				throw new BuildException("Variable " + var + " is undefined");
			}
		}
	}

	protected abstract void initialize() throws Exception;

	protected abstract void examine() throws Exception;

	protected abstract IEolExecutableModule createModule();
		
}
