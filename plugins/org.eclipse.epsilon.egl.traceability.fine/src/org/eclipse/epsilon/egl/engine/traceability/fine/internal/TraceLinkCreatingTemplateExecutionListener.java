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
package org.eclipse.epsilon.egl.engine.traceability.fine.internal;

import org.eclipse.epsilon.egl.EglPersistentTemplate;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceLink;
import org.eclipse.epsilon.egl.execute.control.DefaultTemplateExecutionListener;
import org.eclipse.epsilon.egl.execute.control.ITemplateExecutionListener;
import org.eclipse.epsilon.eol.execute.introspection.recording.IPropertyAccess;

public class TraceLinkCreatingTemplateExecutionListener extends DefaultTemplateExecutionListener implements ITemplateExecutionListener {

	private final Trace trace;
	private final TracedPropertyAccessLedger ledger;

	public TraceLinkCreatingTemplateExecutionListener(Trace trace, TracedPropertyAccessLedger ledger) {
		this.trace = trace;
		this.ledger = ledger;
	}

	@Override
	public void finishedGenerating(EglPersistentTemplate template, String path) {
		for (TracedPropertyAccess access : ledger.retrieve(template)) {
			trace.getTraceLinks().add(createTraceLink(path, access));
		}
	}

	private TraceLink createTraceLink(String path, TracedPropertyAccess access) {
		return new TraceLink(createSource(access), createDestination(access.getRegion(), path));
	}

	private ModelLocation createSource(IPropertyAccess access) {
		return new ModelLocation(access.getModelElement(), access.getPropertyName());
	}

	private TextLocation createDestination(Region region, String path) {
		return new TextLocation(region, path);
	}

}