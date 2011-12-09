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
package org.eclipse.epsilon.egl.execute.context;

import java.io.PrintStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.config.ContentTypeRepository;
import org.eclipse.epsilon.egl.config.XMLContentTypeRepository;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.TraceManager;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.TraceManager.PositionReporter;
import org.eclipse.epsilon.egl.execute.EglExecutorFactory;
import org.eclipse.epsilon.egl.execute.EglOperationFactory;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.internal.IEglModule;
import org.eclipse.epsilon.egl.merge.partition.CompositePartitioner;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class EglContext extends EolContext implements IEglContext {

	private final EglTemplateFactory templateFactory;
	
	private final List<StatusMessage> statusMessages = new LinkedList<StatusMessage>();
	private final EglExecutionManager executionManager = new EglExecutionManager(new EglFrameStackManager(getFrameStack()));
	
	private CompositePartitioner partitioner = new CompositePartitioner();
	private ContentTypeRepository repository = new XMLContentTypeRepository(this);
	private TraceManager traceManager;
	
	private IEglContext parentContext;
	
	public EglContext(EglTemplateFactory templateFactory) {
		this.templateFactory = templateFactory;
		this.traceManager = new TraceManager(new PositionInParentReporter());
		
		populateScope();
		setOperationFactory(new EglOperationFactory());
		setExecutorFactory(new EglExecutorFactory());
	}
	
	@Override
	public IEglModule getModule() {
		return (IEglModule)module;
	}

	public EglTemplateFactory getTemplateFactory() {
		return templateFactory;
	}

	private void populateScope() {
		getFrameStack().put(Variable.createReadOnlyVariable("TemplateFactory", templateFactory));
		
		getFrameStack().put(Variable.createReadOnlyVariable("openTag",       "[%"));
		getFrameStack().put(Variable.createReadOnlyVariable("openOutputTag", "[%="));
		getFrameStack().put(Variable.createReadOnlyVariable("closeTag",       "%]"));
	}
	
	public void copyInto(IEolContext context, boolean preserveFrameStack) {
		context.setErrorStream(getErrorStream());
		context.setExecutorFactory(getExecutorFactory());
		context.setIntrospectionManager(getIntrospectionManager());
		context.setModelRepository(getModelRepository());
		context.setOperationFactory(getOperationFactory());
		context.setOutputStream(getOutputStream());
		if (!preserveFrameStack) context.setFrameStack(getFrameStack());
		context.setUserInput(getUserInput());
		context.setNativeTypeDelegates(getNativeTypeDelegates());
		context.setExtendedProperties(getExtendedProperties());		
	}
	
	public void copyInto(IEolContext context) {
		copyInto(context, false);
	}

	public CompositePartitioner getPartitioner() {
		return partitioner;
	}
	
	public void setPartitioner(CompositePartitioner partitioner) {
		this.partitioner = partitioner;
	}
	
	public boolean usePartitionerFor(String contentType) {
		final CompositePartitioner partitioner = repository.partitionerFor(contentType);
		
		if (partitioner == null) {
			return false;
		} else {
			this.partitioner = partitioner;
			return true;
		}
	}
	
	public List<String> getPartitioningProblems() {
		return getPartitioner().partition(getOutputBuffer().toString()).getProblems();
	}
	
	public ContentTypeRepository getContentTypeRepository() {
		return repository;
	}
	
	public void setContentTypeRepository(ContentTypeRepository repository) {
		this.repository = repository;
	}

	public void addStatusMessage(StatusMessage message) {
		statusMessages.add(message);
		
		// Chain messages to parent
		if (parentContext != null)
			parentContext.addStatusMessage(message);
	}

	public List<StatusMessage> getStatusMessages() {
		return Collections.unmodifiableList(statusMessages);
	}
	
	@Override
	public void setOutputStream(PrintStream outputStream) {
		super.setOutputStream(outputStream);
	}
		
	public void enter(Template template) {
		executionManager.prepareFor(new ExecutableTemplateSpecification(template, new OutputBuffer(this)));
	}
	
	public void exit() {
		executionManager.restore();
	}

	public OutputBuffer getOutputBuffer() {
		return executionManager.getCurrent().outputBuffer;
	}
	
	public Template getBaseTemplate() {
		return executionManager.getBase().template;
	}
	
	public void formatWith(Formatter formatter) {
		getOutputBuffer().formatWith(formatter);
	}

	@Override
	public TraceManager getFineGrainedTraceManager() {
		return traceManager;
	}
	
	
	protected class PositionInParentReporter implements PositionReporter {
		
		@Override
		public int getCurrentOffset() {
			if (executionManager.hasParent()) {
				return executionManager.getParent().outputBuffer.getOffset();
				
			} else {
				return 0;
			}			
		}
	}


	@Override
	public void setTraceManager(TraceManager traceManager) {
		this.traceManager = traceManager;
	}

	@Override
	public TraceManager getTraceManager() {
		return traceManager;
	}
}
