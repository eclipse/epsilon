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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.config.ContentTypeRepository;
import org.eclipse.epsilon.egl.config.XMLContentTypeRepository;
import org.eclipse.epsilon.egl.execute.EglOperationFactory;
import org.eclipse.epsilon.egl.merge.partition.CompositePartitioner;
import org.eclipse.epsilon.egl.output.IOutputBuffer;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolClasspathNativeTypeDelegate;

public class EglContext extends EolContext implements IEglContext {

	private List<StatusMessage> statusMessages = new LinkedList<>();
	private EglTemplateFactory templateFactory;
	private Supplier<? extends IOutputBuffer> outputBufferFactory = () -> new OutputBuffer(this);
	private CompositePartitioner partitioner = new CompositePartitioner();
	private ContentTypeRepository repository = new XMLContentTypeRepository(this);
	private EglExecutionManager executionManager = new EglExecutionManager();
	
	public EglContext() {
		this((EglTemplateFactory) null);
	}
	
	public EglContext(EglTemplateFactory templateFactory) {
		super(new EolClasspathNativeTypeDelegate(EglContext.class.getClassLoader()));
		this.templateFactory = templateFactory != null ? templateFactory : new EglTemplateFactory(this);
		populateScope();
		setOperationFactory(new EglOperationFactory());
	}
	
	public EglContext(IEglContext other) {
		this();
		if (other != null) {
			copyFrom(other, false);
		}
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
	public void copyFrom(IEolContext context, boolean preserveFramestack) {
		IEglContext.super.copyFrom(context, preserveFramestack);
		this.methodContributorRegistry = context.getOperationContributorRegistry();
		
		if (context instanceof EglContext) {
			EglContext other = (EglContext) context;
		 	this.templateFactory = other.templateFactory;
		 	this.statusMessages = other.statusMessages;
		 	this.executionManager = other.executionManager;
		}
	}
	
	@Override
	public EglTemplateFactory getTemplateFactory() {
		return templateFactory;
	}
	
	@Override
	public Supplier<? extends IOutputBuffer> getOutputBufferFactory() {
		return outputBufferFactory;
	}
	
	@Override
	public void setOutputBufferFactory(Supplier<? extends IOutputBuffer> outputBufferFactory) {
		this.outputBufferFactory = outputBufferFactory;
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
	}

	@Override
	public List<StatusMessage> getStatusMessages() {
		return Collections.unmodifiableList(statusMessages);
	}
	
	@Override
	public void enter(EglTemplate template) {
		executionManager.prepareFor(
			new ExecutableTemplateSpecification(template, outputBufferFactory.get()),
			getFrameStack()
		);
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
}
