/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine;

import org.eclipse.epsilon.egl.engine.traceability.fine.internal.EglOutputBufferPrintExecutionListener;
import org.eclipse.epsilon.egl.engine.traceability.fine.internal.Foo;
import org.eclipse.epsilon.egl.engine.traceability.fine.internal.TemplateExecutionListener;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.eol.execute.introspection.recording.IPropertyAccessRecorder;
import org.eclipse.epsilon.eol.execute.introspection.recording.PropertyAccessExecutionListener;
import org.eclipse.epsilon.eol.execute.introspection.recording.PropertyAccessRecorder;

/**
 * The entry point to the EGL fine-grained traceability functionality. This adaptor can
 * be used to non-destructively enhance an EglModule with execution listeners that build
 * a trace model when the module is executed.
 * 
 * @see Trace
 */
public class EglFineGrainedTraceContextAdaptor {

	/**
	 * Prepares to build a trace model for the specified context, returning an empty
	 * trace. Subsequent execution of the module attached to this context will cause
	 * the trace to be populated. 
	 */
	public Trace adapt(IEglContext context) {
		final Trace trace = new Trace();
		final Foo foo = new Foo();
		
		selectivelyRecordPropertyAccesses(context, foo);
		listenForTemplateExecution(context, trace, foo);
		
		return trace;
	}

	protected void listenForTemplateExecution(IEglContext context, final Trace trace, final Foo foo) {
		context.getTemplateFactory().getTemplateExecutionListeners().add(new TemplateExecutionListener(trace, foo));
	}

	protected void selectivelyRecordPropertyAccesses(IEglContext context, final Foo foo) {
		final IPropertyAccessRecorder recorder = new PropertyAccessRecorder();
		context.getExecutorFactory().addExecutionListener(new PropertyAccessExecutionListener(recorder));
		context.getExecutorFactory().addExecutionListener(new EglOutputBufferPrintExecutionListener(recorder, foo));
	}
}
