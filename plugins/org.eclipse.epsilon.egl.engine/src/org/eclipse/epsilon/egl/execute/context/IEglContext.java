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
import org.eclipse.epsilon.egl.internal.IEglModule;
import org.eclipse.epsilon.egl.merge.partition.CompositePartitioner;
import org.eclipse.epsilon.egl.output.IOutputBuffer;
import org.eclipse.epsilon.egl.output.OutputBuffer;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributorRegistry;

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
	
	@Override
	IEglModule getModule();
	
	/**
	 * 
	 * @return
	 * @since 1.6
	 */
	public default IOutputBuffer newOutputBuffer() {
		return new OutputBuffer(this);
	}
	
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
	 *
	 * @param ocr
	 * @since 1.6
	 */
	public void setOperationContributorRegistry(OperationContributorRegistry ocr);
	
}
