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

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.eclipse.epsilon.common.dt.console.EolRuntimeExceptionHyperlinkListener;
import org.eclipse.epsilon.commons.util.StringUtil;
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

public abstract class ExecutableModuleTask extends ModuleTask {
	
	protected List<ModelNestedElement> modelNestedElements = new ArrayList<ModelNestedElement>();
	protected List<VariableNestedElement> usesVariableNestedElements = new ArrayList<VariableNestedElement>();
	protected List<VariableNestedElement> exportsVariableNestedElements = new ArrayList<VariableNestedElement>();
	protected List<ParameterNestedElement> parameterNestedElements = new ArrayList<ParameterNestedElement>();

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

	@Override
	protected void configureModule() throws EolModelNotFoundException, BuildException {
		super.configureModule();
		populateModelRepository();
		accessParameters();
		useVariables();
	}

	@Override
	protected void useResults() throws Exception {
		exportVariables();
		super.useResults();
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
			String var = usesVariableNestedElement.getRef();
			Variable usedVariable = getProjectStackFrame().get(var);
			
			// FIXME : Remove this hack using a proper design!
			if (usedVariable != null) {
				Object value = usedVariable.getValue();
				if (value instanceof IModel) {
					IModel model = (IModel) value;
					ModelReference reference = new ModelReference(model);
					String as = usesVariableNestedElement.getAs();
					if (as != null) {
						reference.setName(as);
					}
					else {
						reference.setName(var);	
					}
					module.getContext().getModelRepository().addModel(reference);
					continue;
				}
			}
			// ENDFIXME
			
			if (usedVariable == null) {
				if (getProject().getProperty(var) != null) {
					usedVariable = new Variable(var, getProject().getProperty(var), EolPrimitiveType.String);
				}
			}

			if (usedVariable == null && !usesVariableNestedElement.isOptional()) throw new BuildException("Undefined variable " + usesVariableNestedElement.getRef());
			if (usesVariableNestedElement.getAs() != null) {
				usedVariable.setName(usesVariableNestedElement.getAs());
			}
			module.getContext().getFrameStack().getGlobals().put(usedVariable);
		}		
	}

	private void exportVariables() {
		for (VariableNestedElement exportVariableNestedElement : exportsVariableNestedElements) {
			String var = exportVariableNestedElement.getRef();
			String as = exportVariableNestedElement.getAs();
			
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
			}
			else if (!exportVariableNestedElement.isOptional()) {
				throw new BuildException("Variable " + var + " is undefined");
			}
		}
	}
		
}
