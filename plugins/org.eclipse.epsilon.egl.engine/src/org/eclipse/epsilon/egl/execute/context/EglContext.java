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

import org.eclipse.epsilon.egl.IEglModule;
import org.eclipse.epsilon.egl.config.ContentTypeRepository;
import org.eclipse.epsilon.egl.config.XMLContentTypeRepository;
import org.eclipse.epsilon.egl.merge.partition.CompositePartitioner;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.template.FileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.template.TemplateFactory;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class EglContext extends EolContext implements IEglContext {

	private final TemplateFactory tf = new FileGeneratingTemplateFactory(this);
	
	private OutputBuffer out;
	private CompositePartitioner partitioner = new CompositePartitioner();
	private ContentTypeRepository repository = new XMLContentTypeRepository(this);
	
	private Template template = new Template();
	
	private final List<StatusMessage> statusMessages = new LinkedList<StatusMessage>();
	
	private IEglContext parentContext;
	private IEolContext delegateContext;
	
	public EglContext() {
		populateScope();
	}
	
	public EglContext(IEglContext context) {
		parentContext = context;
		
		setErrorStream(context.getErrorStream());
		setExecutorFactory(context.getExecutorFactory());
		setIntrospectionManager(context.getIntrospectionManager());
		setModelRepository(context.getModelRepository());
		setOperationFactory(context.getOperationFactory());
		setOutputStream(context.getOutputStream());
		setUserInput(context.getUserInput());
		setPartitioner(context.getPartitioner());
		setContentTypeRepository(context.getContentTypeRepository());
		setNativeTypeDelegates(context.getNativeTypeDelegates());
		setExtendedProperties(context.getExtendedProperties());
		
		tf.imitate(context.getTemplateFactory());

// Scope cloning only required if Templates did not have a populate method
//		setScope(context.getScope().clone());
		
		populateScope();
	}
	
	@Override
	public IEglModule getModule() {
		return (IEglModule)module;
	}

	public TemplateFactory getTemplateFactory() {
		return tf;
	}
	
	public OutputBuffer getOutputBuffer() {
		return out;
	}
	
	public void clearOutputBuffer() {
		out = new OutputBuffer(this);
		getFrameStack().put(Variable.createReadOnlyVariable("out", out));
	}

	private void populateScope() {
		out = new OutputBuffer(this);
		getFrameStack().put(Variable.createReadOnlyVariable("out", out));
		getFrameStack().put(Variable.createReadOnlyVariable("TemplateFactory", tf));
		
		getFrameStack().put(Variable.createReadOnlyVariable("openTag",       "[%"));
		getFrameStack().put(Variable.createReadOnlyVariable("openOutputTag", "[=%"));
		getFrameStack().put(Variable.createReadOnlyVariable("closeTag",       "%]"));
	}
	
	public void copyInto(IEolContext context) {
		delegateContext = context;
		
		context.setErrorStream(getErrorStream());
		context.setExecutorFactory(getExecutorFactory());
		context.setIntrospectionManager(getIntrospectionManager());
		context.setModelRepository(getModelRepository());
		context.setOperationFactory(getOperationFactory());
		context.setOutputStream(getOutputStream());
		context.setFrameStack(getFrameStack());
		context.setUserInput(getUserInput());
		context.setNativeTypeDelegates(getNativeTypeDelegates());
		context.setExtendedProperties(getExtendedProperties());
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
	
	public Template getTemplate() {
		return template;
	}
	
	public void setTemplate(Template template) {
		this.template = template;
	}
	
	@Override
	public void setOutputStream(PrintStream outputStream) {
		super.setOutputStream(outputStream);
		
		if (delegateContext != null)
			delegateContext.setOutputStream(outputStream);
	}

}
