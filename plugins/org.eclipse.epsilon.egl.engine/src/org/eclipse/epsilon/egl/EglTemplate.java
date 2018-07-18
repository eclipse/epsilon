/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl;

import java.net.URI;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.execute.control.ITemplateExecutionListener;
import org.eclipse.epsilon.egl.formatter.CompositeFormatter;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.formatter.NullFormatter;
import org.eclipse.epsilon.egl.incremental.IncrementalitySettings;
import org.eclipse.epsilon.egl.internal.EglModule;
import org.eclipse.epsilon.egl.internal.EglResult;
import org.eclipse.epsilon.egl.merge.DefaultMerger;
import org.eclipse.epsilon.egl.merge.Merger;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecification;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecificationFactory;
import org.eclipse.epsilon.egl.status.ProtectedRegionWarning;
import org.eclipse.epsilon.egl.traceability.Template;

public class EglTemplate extends AbstractEglTemplate {

	protected final String name;
	protected final Template template;
	protected final Collection<ITemplateExecutionListener> listeners;
	
	private IncrementalitySettings incrementalitySettings;
	private Formatter formatter;
	private String contents = "";
	private boolean processed = false;
	
	// For tests
	protected EglTemplate(URI path, IEglContext context) throws Exception {
		this(new EglTemplateSpecificationFactory(new NullFormatter(), new IncrementalitySettings()).fromResource(path.toString(), path), context);
	}

	public EglTemplate(EglTemplateSpecification spec, IEglContext context) throws Exception {
		this(spec.getName(), context, spec.createTemplate(), spec.getDefaultFormatter(), spec.getIncrementalitySettings(), spec.getTemplateExecutionListeners());
		
		spec.parseInto(module);
	}
	
	private EglTemplate(String name, IEglContext context, Template template, Formatter formatter, IncrementalitySettings incrementalitySettings, Collection<ITemplateExecutionListener> listeners) {
		super(new EglModule(context));
		
		this.name     = name;
		this.template = template;
		this.formatter = formatter;
		this.incrementalitySettings = incrementalitySettings;
		this.listeners = listeners;
	}
	
	public String getName() {
		return name;
	}

	public void populate(String name, Object value) {
		template.addVariable(name, value);
	}
	
	public String process() throws EglRuntimeException {
		for (ITemplateExecutionListener listener : listeners) {
			listener.aboutToProcess(this);
		}
		
		final EglResult result = module.execute(this, formatter);
		
		contents = result.generatedText;
		processed = true;

		for (ITemplateExecutionListener listener : listeners) {
			listener.finishedProcessing(this);
		}
		
		return contents;
	}
	
	public String merge(String existing) throws EglRuntimeException {
		if (!isProcessed()) process();
		 
		final Merger merger = new DefaultMerger(module.getContext().getPartitioner(),
				                                contents,
				                                existing);
		
		final String result = merger.merge();
		
		for (ProtectedRegionWarning warning : merger.getMergeWarnings()) {
			addProtectedRegionWarning(warning);
		}
		
		return result;
	}
	
	protected void addProtectedRegionWarning(ProtectedRegionWarning warning) {
		module.getContext().addStatusMessage(warning);
	}
	
	protected String getContents() {
		return contents;
	}
	
	protected boolean isProcessed() {
		return processed;
	}
	
	public Formatter getFormatter() {
		return formatter;
	}
	
	public void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}
	
	public IncrementalitySettings getIncrementalitySettings() {
		return incrementalitySettings;
	}
	
	public void setIncrementalitySettings(IncrementalitySettings incrementalitySettings) {
		this.incrementalitySettings = incrementalitySettings;
	}
	
	public void setFormatters(Formatter... formatters) {
		setFormatters(Arrays.asList(formatters));
	}
	
	public void setFormatters(Collection<Formatter> formatters) {
		setFormatter(new CompositeFormatter(formatters));
	}

	public Template getTemplate() {
		return template;
	}
	
	@Override
	public void reset() {
		this.processed = false;
		this.template.reset();
	}
}
