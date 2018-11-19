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

	private final List<StatusMessage> statusMessages = new LinkedList<>();
	private EglExecutionManager executionManager = new EglExecutionManager(new EglFrameStackManager(getFrameStack()));
	private EglTemplateFactory templateFactory;
	private IOutputBufferFactory outputBufferFactory = () -> new OutputBuffer(this);
	private CompositePartitioner partitioner = new CompositePartitioner();
	private ContentTypeRepository repository = new XMLContentTypeRepository(this);
	private IEglContext parentContext;
	
	public EglContext() {
		this(new EglTemplateFactory());
	}
	
	public EglContext(EglTemplateFactory templateFactory) {
		super(new EolClasspathNativeTypeDelegate(EglContext.class.getClassLoader()));
		this.templateFactory = templateFactory != null ? templateFactory : new EglTemplateFactory();
		populateScope();
		setOperationFactory(new EglOperationFactory());
	}

	protected void setExecutionManager(EglExecutionManager executionManager) {
		this.executionManager = executionManager;
	}
	
	public void setTemplateFactory(EglTemplateFactory templateFactory) {
		this.templateFactory = templateFactory;
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
		getFrameStack().put(
			Variable.createReadOnlyVariable("TemplateFactory", templateFactory),
			Variable.createReadOnlyVariable("openTag",       "[%"),
			Variable.createReadOnlyVariable("openOutputTag", "[%="),
			Variable.createReadOnlyVariable("closeTag",       "%]")
		);
	}
	
	@Override
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
	
	@Override
	public void copyInto(IEolContext context) {
		copyInto(context, false);
	}

	@Override
	public CompositePartitioner getPartitioner() {
		return partitioner;
	}
	
	@Override
	public void setPartitioner(CompositePartitioner partitioner) {
		this.partitioner = partitioner;
	}
	
	@Override
	public boolean usePartitionerFor(String contentType) {
		final CompositePartitioner partitioner = repository.partitionerFor(contentType);
		
		if (partitioner == null) {
			return false;
		}
		else {
			this.partitioner = partitioner;
			return true;
		}
	}
	
	@Override
	public List<String> getPartitioningProblems() {
		return getPartitioner().partition(getOutputBuffer().toString()).getProblems();
	}
	
	@Override
	public ContentTypeRepository getContentTypeRepository() {
		return repository;
	}
	
	@Override
	public void setContentTypeRepository(ContentTypeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void addStatusMessage(StatusMessage message) {
		statusMessages.add(message);
		
		// Chain messages to parent
		if (parentContext != null)
			parentContext.addStatusMessage(message);
	}

	@Override
	public List<StatusMessage> getStatusMessages() {
		return Collections.unmodifiableList(statusMessages);
	}
	
	@Override
	public void setOutputStream(PrintStream outputStream) {
		super.setOutputStream(outputStream);
	}
		
	@Override
	public void enter(EglTemplate template) {
		executionManager.prepareFor(new ExecutableTemplateSpecification(template, outputBufferFactory.create()));
	}
	
	@Override
	public void exit() {
		executionManager.restore();
	}

	@Override
	public IOutputBuffer getOutputBuffer() {
		return executionManager.getCurrent().outputBuffer;
	}
	
	@Override
	public Template getTrace() {
		return executionManager.getBase().template.getTemplate();
	}
	
	@Override
	public EglTemplate getCurrentTemplate() {
		return executionManager.getCurrent().template;
	}
	
	@Override
	public void formatWith(Formatter formatter) {
		getOutputBuffer().formatWith(formatter);
	}
}
