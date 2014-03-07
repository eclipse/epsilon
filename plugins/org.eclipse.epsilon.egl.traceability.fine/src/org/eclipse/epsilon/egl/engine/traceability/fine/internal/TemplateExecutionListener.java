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
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceLink;
import org.eclipse.epsilon.egl.execute.control.ITemplateExecutionListener;

public class TemplateExecutionListener implements ITemplateExecutionListener {
			
		private final Trace trace;
		private final Foo foo;
		
		public TemplateExecutionListener(Trace trace, Foo foo) {
			this.trace = trace;
			this.foo = foo;
		}

		@Override
		public void aboutToProcess(EglTemplate template) {
			System.out.println("About to process: " + template);
			foo.templates.push(template);
		}
		
		@Override
		public void finishedProcessing(EglTemplate template) {
			System.out.println("Finished processing: " + template);
			foo.templates.pop();
		}

		@Override
		public void finishedGenerating(EglPersistentTemplate template, String path) {
			System.out.println("Finished generating: " + template + " to " + path);
			System.out.println("Adjusting " + foo.currentLinks.get(template).size() + " links");
			System.out.println(template.getTemplate().getOutputFiles());
			
			for (PropertyAccessWithPosition access : foo.currentLinks.get(template)) {
				TextLocation destination = new TextLocation(access.region, path);
				ModelLocation source = new ModelLocation(access.propertyAccess.getModelElement(), access.propertyAccess.getPropertyName());
				TraceLink link = new TraceLink(source, destination);	
				this.trace.getTraceLinks().add(link);
			}
		}
		
	}