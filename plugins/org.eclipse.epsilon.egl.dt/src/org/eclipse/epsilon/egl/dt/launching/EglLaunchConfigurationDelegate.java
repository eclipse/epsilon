/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.dt.launching;

import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.APPEND_TO_FILE;
import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.GENERATE_TO;
import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.GENERATE_TO_CONSOLE;
import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.OUTPUT_FILE_PATH;
import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.PRODUCE_TRACE;
import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.TRACE_DESTINATION;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.dt.debug.EgxDebugger;
import org.eclipse.epsilon.egl.dt.extensions.fineGrainedTracePostprocessor.FineGrainedTracePostprocessorSpecification;
import org.eclipse.epsilon.egl.dt.extensions.fineGrainedTracePostprocessor.FineGrainedTracePostprocessorSpecificationFactory;
import org.eclipse.epsilon.egl.dt.extensions.formatter.FormatterSpecification;
import org.eclipse.epsilon.egl.dt.extensions.formatter.FormatterSpecificationFactory;
import org.eclipse.epsilon.egl.dt.extensions.templateFactoryType.TemplateFactoryTypeSpecificationFactory;
import org.eclipse.epsilon.egl.dt.views.CurrentTemplate;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;
import org.eclipse.epsilon.egl.execute.context.EglContext;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.util.FileUtil;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public class EglLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {

	@Override
	public IEolExecutableModule createModule() throws CoreException {
		EglTemplateFactory templateFactory = createTemplateFactoryFromConfiguration();
		if (isEgx()) {
			return new EgxModule(templateFactory);
		}
		else {
			return new EglTemplateFactoryModuleAdapter(templateFactory); 
		}
	}

	private EglTemplateFactory createTemplateFactoryFromConfiguration() throws CoreException {
		final TemplateFactoryTypeSpecificationFactory factory = new TemplateFactoryTypeSpecificationFactory();
		
		final String templateFactoryTypeIdentifier = configuration.getAttribute(EglLaunchConfigurationAttributes.TEMPLATE_FACTORY_TYPE, factory.findByIndex(0).getIdentifier());
		return factory.findByIdentifier(templateFactoryTypeIdentifier).instantiate();
	}

	@Override
	protected void preParse(IEolExecutableModule module) {
		// The default formatters must be set when the template is instantiated.
		// EglTemplateFactoryModuleAdapter#parse instantiates templates.
		// Therefore, the default formatters must be set before parsing occurs.
		loadDefaultFormatters(module);
	}
	
	private void loadDefaultFormatters(IEolExecutableModule module) {
		try {
			Collection<Formatter> defaultFormatters = loadDefaultFormattersFromConfiguration();
			if (isEgx()) {
				((EgxModule) module).getTemplateFactory().setDefaultFormatters(defaultFormatters);
			}
			else {
				((EglTemplateFactoryModuleAdapter)module).setDefaultFormatters(defaultFormatters);
			}
		} catch (CoreException e) {
			LogUtil.log("Error encountered whilst trying to load postprocessor", e);
		}
	}

	@SuppressWarnings("unchecked")
	private Collection<Formatter> loadDefaultFormattersFromConfiguration() throws CoreException {
		final List<Formatter> defaultFormatters = new LinkedList<Formatter>();
		final Collection<String> identifiers = configuration.getAttribute(EglLaunchConfigurationAttributes.DEFAULT_FORMATTERS, Collections.emptyList());
		
		for (FormatterSpecification spec : new FormatterSpecificationFactory().findByIdentifiers(identifiers)) {
			defaultFormatters.add(spec.instantiate());
		}
		
		return defaultFormatters;
	}
	
	@Override
	protected void preExecute(IEolExecutableModule module) throws CoreException, EolRuntimeException {
		super.preExecute(module);
		
		addEglPrintStream(module);
	}
	
	private void addEglPrintStream(final IEolExecutableModule module) {
		final Display display = PlatformUI.getWorkbench().getDisplay();
		display.syncExec(new Runnable() {

			public void run() {
				module.getContext().setOutputStream(EpsilonConsole.getInstance().newPrintStream(display.getSystemColor(SWT.COLOR_DARK_MAGENTA)));	
			}
			
		});
	}
	
	@Override
	protected void postExecute(IEolExecutableModule module) throws CoreException, EolRuntimeException {
		super.postExecute(module);
		
		final String output = StringUtil.toString(result);
		
		if (output!=null && output.length() > 0) {
			if (configuration.getAttribute(GENERATE_TO, GENERATE_TO_CONSOLE) == GENERATE_TO_CONSOLE) {
				EpsilonConsole.getInstance().getDebugStream().println(output);
			} else {
				storeOutput(module, output);
			}
		}
		
		if (configuration.getAttribute(PRODUCE_TRACE, false)) {
			storeTraceModel((IEglContext) module.getContext());
		}
		
		for (StatusMessage message : ((EglContext) module.getContext()).getStatusMessages())
			EpsilonConsole.getInstance().getInfoStream().println(message);
		
		CurrentTemplate.getInstance().setTemplate(((EglContext) module.getContext()).getBaseTemplate());
		
	}

	private void storeOutput(IEolExecutableModule module, final String output) throws CoreException {
		// FIXME use the template to write to file?
		final String outputFilePath = configuration.getAttribute(OUTPUT_FILE_PATH, "");
		
		if (outputFilePath.length() > 0) {
			try {
				final boolean appendToFile = configuration.getAttribute(APPEND_TO_FILE, false);
				final String verb = appendToFile ? "appended" : "generated";
			
				final String absoluteOutputFilePath = absolutePathFor(outputFilePath);
				
				FileUtil.write(absoluteOutputFilePath, output, appendToFile);
				((IEglContext)module.getContext()).getFineGrainedTraceManager().addDestinationResourceForUnclaimedPropertyAccesses(absoluteOutputFilePath);
				
				EpsilonConsole.getInstance().getInfoStream().println("Output " + verb + " to " + outputFilePath);
				
			} catch (IOException e) {
				module.getContext().getErrorStream().println("Could not write to " + outputFilePath + ":");
				module.getContext().getErrorStream().print('\t');
				module.getContext().getErrorStream().println(e);
			}
		}
	}
	
	private void storeTraceModel(IEglContext context) throws CoreException {
		final Trace trace = context.getFineGrainedTraceManager().getFineGrainedTrace();
		trace.setDestination(configuration.getAttribute(TRACE_DESTINATION, ""));
		
		for (FineGrainedTracePostprocessorSpecification spec : new FineGrainedTracePostprocessorSpecificationFactory().loadAllFromExtensionPoints()) {
			spec.instantiate().postprocess(trace);
		}
	}
	
	private String absolutePathFor(String workspaceRelativePath) {
		return ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toPortableString() + workspaceRelativePath;
	}
	
	protected boolean isEgx() {
		try {
			return configuration.getAttribute(EolLaunchConfigurationAttributes.SOURCE, "").endsWith("egx");
		} catch (CoreException e) {
			return false;
		}
	}
	
	@Override
	protected EolDebugger createDebugger() {
		if (isEgx()) {
			return new EgxDebugger();
		}
		else {
			return super.createDebugger();
		}
	}
}

