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

import java.util.List;
import java.util.function.Supplier;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.config.ContentTypeRepository;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.merge.partition.CompositePartitioner;
import org.eclipse.epsilon.egl.output.IOutputBuffer;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IEglContext extends IEolContext {
	
	public EglTemplateFactory getTemplateFactory();
	
	public CompositePartitioner getPartitioner();
	
	public void setPartitioner(CompositePartitioner partitioner);
	
	public ContentTypeRepository getContentTypeRepository();
	
	public void setContentTypeRepository(ContentTypeRepository repository);
	
	public void addStatusMessage(StatusMessage message);
	
	public List<StatusMessage> getStatusMessages();

	public void enter(EglTemplate template);

	public void exit();
	
	public EglTemplate getCurrentTemplate();
	
	public Template getTrace();

	public IOutputBuffer getOutputBuffer();
	
	public default Supplier<? extends IOutputBuffer> getOutputBufferFactory() {
		return () -> new OutputBuffer(this);
	}
	
	public void setOutputBufferFactory(Supplier<? extends IOutputBuffer> outputBufferFactory);
	
	public default void formatWith(Formatter formatter) {
		getOutputBuffer().formatWith(formatter);
	}
	
	public default List<String> getPartitioningProblems() {
		return getPartitioner().partition(getOutputBuffer().toString()).getProblems();
	}
	
	public default boolean usePartitionerFor(String contentType) {
		final CompositePartitioner partitioner = getContentTypeRepository().partitionerFor(contentType);
		if (partitioner == null) {
			return false;
		}
		else {
			setPartitioner(partitioner);
			return true;
		}
	}
	
	/**
	 * Copies the state from the given context into this.
	 * There are no guarantees about whether this is a shallow or deep copy.
	 * 
	 * @param context The context to copy from.
	 * @param preserveFramestack Whether to leave this context's FrameStack
	 * untouched.
	 * 
	 * @since 1.6
	 */
	public default void copyFrom(IEolContext context, boolean preserveFramestack) {
		this.setErrorStream(context.getErrorStream());
		this.setOutputStream(context.getOutputStream());
		this.setIntrospectionManager(context.getIntrospectionManager());
		this.setModelRepository(context.getModelRepository());
		this.setOperationFactory(context.getOperationFactory());
		this.setUserInput(context.getUserInput());
		this.setNativeTypeDelegates(context.getNativeTypeDelegates());
		this.setExtendedProperties(context.getExtendedProperties());
		this.setPrettyPrinterManager(context.getPrettyPrinterManager());		
		this.setExecutorFactory(new ExecutorFactory(context.getExecutorFactory()));
		
		if (!preserveFramestack) {
			this.setFrameStack(context.getFrameStack());
		}
		
		if (context instanceof IEglContext) {
			IEglContext other = (IEglContext) context;
			other.getStatusMessages().forEach(this::addStatusMessage);
			this.setOutputBufferFactory(other.getOutputBufferFactory());
			this.setPartitioner(other.getPartitioner());
			this.setContentTypeRepository(other.getContentTypeRepository());
		}
	}
}
