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
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.workflow.tasks.nestedelements.EglDefaultFormatterNestedElement;

public class EglTask extends ExecutableModuleTask {
	
	protected File target;
	protected Class<? extends EglTemplateFactory> templateFactoryType = EglFileGeneratingTemplateFactory.class;
	protected List<EglDefaultFormatterNestedElement> defaultFormatterNestedElements = new LinkedList<EglDefaultFormatterNestedElement>();
	
	@Override
	protected IEolExecutableModule createModule() throws InstantiationException, IllegalAccessException {
		final EglTemplateFactory templateFactory = templateFactoryType.newInstance();
		templateFactory.setDefaultFormatters(instantiateDefaultFormatters());
		return new EglTemplateFactoryModuleAdapter(templateFactory);
	}

	private List<Formatter> instantiateDefaultFormatters() throws InstantiationException, IllegalAccessException {
		final List<Formatter> defaultFormatters = new LinkedList<Formatter>();
		
		for (EglDefaultFormatterNestedElement defaultFormatterNestedElement : defaultFormatterNestedElements) {
			defaultFormatters.add(defaultFormatterNestedElement.getImplementation().newInstance());
		}
		
		return defaultFormatters;
	}

	@Override
	protected void examine() throws Exception {
		if (target!=null) {
			FileWriter fw = new FileWriter(target);
			fw.write(String.valueOf(result));
			fw.flush();
			fw.close();
		}
	}

	@Override
	protected void initialize() throws Exception {}

	public File getTarget() {
		return target;
	}

	public void setTarget(File output) {
		this.target = output;
	}
	
	public Class<? extends EglTemplateFactory> getTemplateFactoryType() {
		return templateFactoryType;
	}
	
	public void setTemplateFactoryType(Class<? extends EglTemplateFactory> templateFactoryType) {
		if (EglTemplateFactory.class.isAssignableFrom(templateFactoryType)) {
			this.templateFactoryType = templateFactoryType;
		
		} else {
			throw new BuildException("The templateFactoryType parameter must be class that subtypes org.eclipse.epsilon.egl.EglTemplateFactory.");
		}
	}
	
	public EglDefaultFormatterNestedElement createDefaultFormatter() {
		final EglDefaultFormatterNestedElement nestedElement = new EglDefaultFormatterNestedElement();
		defaultFormatterNestedElements.add(nestedElement);
		return nestedElement;
	}
	
	@Override
	protected EolDebugger createDebugger() {
		return new EolDebugger();
	}

}
