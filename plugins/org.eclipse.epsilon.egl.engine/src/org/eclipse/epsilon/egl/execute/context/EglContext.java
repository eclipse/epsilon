/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.execute.context;

import java.io.PrintStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.config.ContentTypeRepository;
import org.eclipse.epsilon.egl.config.XMLContentTypeRepository;
import org.eclipse.epsilon.egl.execute.EglOperationFactory;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.internal.EglPreprocessorContext;
import org.eclipse.epsilon.egl.merge.partition.CompositePartitioner;
import org.eclipse.epsilon.egl.output.IOutputBuffer;
import org.eclipse.epsilon.egl.output.IOutputBufferFactory;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolClasspathNativeTypeDelegate;

public class EglContext extends EolContext implements IEglContext {

	private final EglTemplateFactory templateFactory;
	
	private final List<StatusMessage> statusMessages = new LinkedList<StatusMessage>();
	private final EglExecutionManager executionManager = new EglExecutionManager(new EglFrameStackManager(getFrameStack()));
	
	private IOutputBufferFactory outputBufferFactory = new IOutputBufferFactory() {
		public IOutputBuffer create() {
			return new OutputBuffer(EglContext.this);
		}
	};
	
	private CompositePartitioner partitioner = new CompositePartitioner();
	private ContentTypeRepository repository = new XMLContentTypeRepository(this);
	private IEglContext parentContext;
	
	public EglContext(EglTemplateFactory templateFactory) {
		super(new EolClasspathNativeTypeDelegate(EglContext.class.getClassLoader()));
		
		this.templateFactory = templateFactory;
		
		populateScope();
		setOperationFactory(new EglOperationFactory());
	}
	
	@Override
	public IModule getModule() {
		return module;
	}

	@Override
	public EglTemplateFactory getTemplateFactory() {
		return templateFactory;
	}
	
	@Override
	public IOutputBufferFactory getOutputBufferFactory() {
		return outputBufferFactory;
	}
	
	@Override
	public void setOutputBufferFactory(IOutputBufferFactory outputBufferFactory) {
		this.outputBufferFactory = outputBufferFactory;
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
		context.setPrettyPrinterManager(getPrettyPrinterManager());
		if (context instanceof EglPreprocessorContext)
			((EglPreprocessorContext) context).setEglContext(this);
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
		
	public void enter(EglTemplate template) {
		executionManager.prepareFor(new ExecutableTemplateSpecification(template, outputBufferFactory.create()));
	}
	
	public void exit() {
		executionManager.restore();
	}

	public IOutputBuffer getOutputBuffer() {
		return executionManager.getCurrent().outputBuffer;
	}
	
	public Template getTrace() {
		return executionManager.getBase().template.getTemplate();
	}
	
	public EglTemplate getCurrentTemplate() {
		return executionManager.getCurrent().template;
	}
	
	public void formatWith(Formatter formatter) {
		getOutputBuffer().formatWith(formatter);
	}
}
