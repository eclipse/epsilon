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
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.config.ContentTypeRepository;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.internal.EglPreprocessorContext;
import org.eclipse.epsilon.egl.merge.partition.CompositePartitioner;
import org.eclipse.epsilon.egl.output.IOutputBuffer;
import org.eclipse.epsilon.egl.output.IOutputBufferFactory;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IEglContext extends IEolContext {
		
	public List<String> getPartitioningProblems();	
	
	public EglTemplateFactory getTemplateFactory();

	/**
	 * 
	 * @param context
	 * @param preserveFramestack
	 * @since 1.6
	 */
	public default void copyFrom(IEolContext context, boolean preserveFramestack) {
		this.setErrorStream(context.getErrorStream());
		this.setExecutorFactory(context.getExecutorFactory());
		this.setIntrospectionManager(context.getIntrospectionManager());
		this.setModelRepository(context.getModelRepository());
		this.setOperationFactory(context.getOperationFactory());
		this.setOutputStream(context.getOutputStream());
		if (!preserveFramestack) this.setFrameStack(context.getFrameStack());
		this.setUserInput(context.getUserInput());
		this.setNativeTypeDelegates(context.getNativeTypeDelegates());
		this.setExtendedProperties(context.getExtendedProperties());
		this.setPrettyPrinterManager(context.getPrettyPrinterManager());
		if (context instanceof IEglContext) {
			IEglContext other = (IEglContext) context;
			other.getStatusMessages().forEach(this::addStatusMessage);
			this.setOutputBufferFactory(other.getOutputBufferFactory());
			this.setPartitioner(other.getPartitioner());
			this.setContentTypeRepository(other.getContentTypeRepository());
			if (this instanceof EglPreprocessorContext) {
				((EglPreprocessorContext) this).setEglContext(other);
			}
		}
	}
	
	public CompositePartitioner getPartitioner();
	
	public void setPartitioner(CompositePartitioner partitioner);
	
	public boolean usePartitionerFor(String contentType);
	
	public ContentTypeRepository getContentTypeRepository();
	
	public void setContentTypeRepository(ContentTypeRepository repository);
	
	public void addStatusMessage(StatusMessage message);
	
	public List<StatusMessage> getStatusMessages();

	public void enter(EglTemplate template);

	public void exit();

	public IOutputBuffer getOutputBuffer();
	
	public Template getTrace();
	
	public EglTemplate getCurrentTemplate();

	public default void formatWith(Formatter formatter) {
		getOutputBuffer().formatWith(formatter);
	}

	public IOutputBufferFactory getOutputBufferFactory();
	
	public void setOutputBufferFactory(IOutputBufferFactory outputBufferFactory);
}
