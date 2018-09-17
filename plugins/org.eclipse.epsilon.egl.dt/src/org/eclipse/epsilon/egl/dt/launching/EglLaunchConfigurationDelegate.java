/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.dt.launching;

import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.launching.extensions.ModuleImplementationExtension;
import org.eclipse.epsilon.common.dt.launching.tabs.AbstractAdvancedConfigurationTab;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.common.util.StringUtil;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplate;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplate;
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
import org.eclipse.epsilon.egl.engine.traceability.fine.EglFineGrainedTraceContextAdaptor;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.EgxContext;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IOConsoleOutputStream;

public class EglLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {

	protected Trace fineGrainedTrace;
		
	/**
	 * The language provided by the plugin. It allows other plugins to contribute
	 * alternate IModule implementation of the language.
	 * @since 1.6
	 * @param configuration 	The Eclipse configuration that has the source file information.
	 */
	public static String getLanguageFromSource(ILaunchConfiguration configuration) {
		String result = "EVL";	// USe EVL by default
		String source = null;
		try {
			source = configuration.getAttribute(EolLaunchConfigurationAttributes.SOURCE, "");
		} catch (CoreException e) {
		
		}
		if (source != null) {
			int extPoint = source.lastIndexOf('.');
			if (extPoint > 0) {
				String fileExtension = source.substring(extPoint+1);
				result = fileExtension.toUpperCase();
			}
		}
		return result;
	}
	

	@Override
	public IEolModule createModule() throws CoreException {
		String implName = configuration.getAttribute(AbstractAdvancedConfigurationTab.IMPL_NAME, "");
		IEolModule module = null;
		EglTemplateFactory templateFactory = createTemplateFactoryFromConfiguration();
		if (implName.length() > 0) {
			module = ModuleImplementationExtension.forImplementation(implName).createModule();
			Set<String> requiredProperties = module.getConfigurationProperties();
			Map<String, Object> attr = configuration.getAttributes();
			requiredProperties.stream()
		    	.filter(k -> !attr.containsKey(k))
		    	.forEach(attr::remove);
			module.configure(attr);
		}
		if (module == null) {
			// Backwards compatibility. For existing configurations, we will use the default module.
			System.out.println("Configuration does not have specific module implementation information. "
					+ "Falling back to default module.");
			//IEolModule module = ModuleImplementationExtension.defaultImplementation().createModule();
			module = getDefaultModule(configuration);
			if (module == null) {
				IStatus result = new Status(IStatus.ERROR, "org.eclipse.epsilon.eol.dt",
						"There was no default module found for the target language. Since this is defined "
						+ "in the Epsilon plugins it is either a bug or your installation may have been "
						+ "corrupted. Please raise a bug: https://bugs.eclipse.org/bugs/enter_bug.cgi?product=epsilon");
				throw new CoreException(result);
			}
		}
		if (isEgx()) {
			((EgxModule)module).setTemplateFactory(templateFactory);
			((EgxModule)module).setContext(new EgxContext(templateFactory));;
		}
		else {
			((EglTemplateFactoryModuleAdapter)module).setFactory(templateFactory); 
		}
		return module;		
	}
	
	public EglTemplateFactory createTemplateFactoryFromConfiguration() throws CoreException {
		final TemplateFactoryTypeSpecificationFactory factory = new TemplateFactoryTypeSpecificationFactory();
		
		final String templateFactoryTypeIdentifier = configuration.getAttribute(EglLaunchConfigurationAttributes.TEMPLATE_FACTORY_TYPE, factory.findByIndex(0).getIdentifier());
		return factory.findByIdentifier(templateFactoryTypeIdentifier).instantiate();
	}

	@Override
	protected void preParse(IEolModule module) {
		// The default formatters must be set when the template is instantiated.
		// EglTemplateFactoryModuleAdapter#parse instantiates templates.
		// Therefore, the default formatters must be set before parsing occurs.
		loadDefaultFormatters(module);
		
		// The fine-grained trace extension registers as a template execution
		// listener, and so we need to attach it before any templates are created
		// (i.e., pre-parse, and not pre-execute).
		prepareToTrace(module);
		
		if (isEgx()) {
			EgxModule egxModule = (EgxModule) module;
			if (egxModule.getTemplateFactory() instanceof EglFileGeneratingTemplateFactory) {
				try {
					if (configuration.getAttribute(EGX_GENERATE_TO, GENERATE_TO_DEFAULT_DIR) == GENERATE_TO_CUSTOM_DIR) {
						((EglFileGeneratingTemplateFactory) egxModule.getTemplateFactory()).setOutputRoot(EclipseUtil.getWorkspaceContainerAbsolutePath(configuration.getAttribute(OUTPUT_DIR_PATH, "")));
					}
				}
				catch (Exception e) {
					LogUtil.log(e);
				}
			}
		}
		
	}

	private void prepareToTrace(IEolModule module) {
		try {
			if (configuration.getAttribute(PRODUCE_TRACE, false)) {
				fineGrainedTrace = new EglFineGrainedTraceContextAdaptor().adapt((IEglContext)module.getContext());
			}
			
		} catch (CoreException e) {
			LogUtil.log("Error encountered whilst preparing to perform fine-grained tracing", e);
		}
	}
	
	private void loadDefaultFormatters(IEolModule module) {
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

	private Collection<Formatter> loadDefaultFormattersFromConfiguration() throws CoreException {
		final List<Formatter> defaultFormatters = new LinkedList<Formatter>();
		final Collection<String> identifiers = configuration.getAttribute(EglLaunchConfigurationAttributes.DEFAULT_FORMATTERS, new ArrayList<String>());
		
		for (FormatterSpecification spec : new FormatterSpecificationFactory().findByIdentifiers(identifiers)) {
			defaultFormatters.add(spec.instantiate());
		}
		
		return defaultFormatters;
	}
	
	@Override
	protected void preExecute(IEolModule module) throws CoreException, EolRuntimeException {
		super.preExecute(module);
		
		addEglPrintStream(module);
	}
	
	private void addEglPrintStream(final IEolModule module) {
		final Display display = PlatformUI.getWorkbench().getDisplay();
		display.syncExec(new Runnable() {

			public void run() {
				IOConsoleOutputStream outputStream = EpsilonConsole.getInstance().createConsoleOutputStream();
				if (EclipseUtil.isDarkThemeEnabled()) {
					outputStream.setColor(display.getSystemColor(SWT.COLOR_CYAN));
				}
				else {
					outputStream.setColor(display.getSystemColor(SWT.COLOR_DARK_MAGENTA));
				}
				module.getContext().setOutputStream(new PrintStream(outputStream));	
			}
			
		});
	}
	
	@Override
	protected void postExecute(IEolModule module) throws CoreException, EolRuntimeException {
		super.postExecute(module);
		
		final String output = StringUtil.toString(result);
		
		if (output!=null && output.length() > 0 && module instanceof EglTemplateFactoryModuleAdapter) {
			if (configuration.getAttribute(EGL_GENERATE_TO, GENERATE_TO_CONSOLE) == GENERATE_TO_CONSOLE) {
				EpsilonConsole.getInstance().getDebugStream().println(output);
			} else {
				storeOutput((EglTemplateFactoryModuleAdapter)module, output);
			}
		}
		
		if (configuration.getAttribute(PRODUCE_TRACE, false)) {
			storeTraceModel();
		}
		
		final IEglContext context = (IEglContext) module.getContext();
		
		for (StatusMessage message : context.getStatusMessages())
			EpsilonConsole.getInstance().getInfoStream().println(message);
		
		CurrentTemplate.getInstance().setTemplate(context.getTrace());
		
	}

	private void storeOutput(EglTemplateFactoryModuleAdapter module, final String output) throws CoreException {
		final String outputFilePath = configuration.getAttribute(OUTPUT_FILE_PATH, "");
		
		final EglTemplate template = module.getCurrentTemplate();
		
		if (template instanceof EglFileGeneratingTemplate && outputFilePath.length() > 0) {
			try {
				final boolean appendToFile = configuration.getAttribute(APPEND_TO_FILE, false);
				final String verb = appendToFile ? "appended" : "generated";
			
				final String absoluteOutputFilePath = absolutePathFor(outputFilePath);
				
				if (appendToFile) {
					((EglFileGeneratingTemplate)template).append(absoluteOutputFilePath);
				} else {
					((EglFileGeneratingTemplate)template).generate(absoluteOutputFilePath);
				}
				
				EpsilonConsole.getInstance().getInfoStream().println("Output " + verb + " to " + outputFilePath);
				
			} catch (EglRuntimeException e) {
				module.getContext().getErrorStream().println("Could not write to " + outputFilePath + ":");
				module.getContext().getErrorStream().print('\t');
				module.getContext().getErrorStream().println(e);
			}
		}
	}
	
	private void storeTraceModel() throws CoreException {
		fineGrainedTrace.setDestination(configuration.getAttribute(TRACE_DESTINATION, ""));
		
		for (FineGrainedTracePostprocessorSpecification spec : new FineGrainedTracePostprocessorSpecificationFactory().loadAllFromExtensionPoints()) {
			spec.instantiate().postprocess(fineGrainedTrace);
		}
	}
	
	private String absolutePathFor(String relativePath) {
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(relativePath));
		if (file != null) { 
			return file.getLocation().toOSString(); 
		}
		else {
			// Old behaviour - use as fallback
			return ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toPortableString() + relativePath;
		}
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


	@Override
	public IEolModule getDefaultModule(ILaunchConfiguration configuration) {
		try {
			return ModuleImplementationExtension.defaultImplementation(getLanguageFromSource(configuration)).createModule();
		} catch (CoreException e) {
		}
		return null;
	}
}

