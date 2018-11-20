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
	 * @since 1.6
	 */
	public default void copyInto(IEolContext context) {
		copyInto(context, false);
	}

	public default void copyInto(IEolContext context, boolean preserveFrameStack) {
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
