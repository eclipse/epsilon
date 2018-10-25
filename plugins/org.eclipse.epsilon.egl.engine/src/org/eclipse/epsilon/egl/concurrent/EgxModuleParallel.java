/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egl.concurrent;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.egl.execute.context.concurrent.EgxContextParallel;
import org.eclipse.epsilon.egl.execute.context.concurrent.IEgxContextParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EgxModuleParallel extends EgxModule {

	public EgxModuleParallel() {
		this(new EgxContextParallel());
	}
	
	public EgxModuleParallel(int parallelism) {
		this(new EgxContextParallel(null, parallelism));
	}
	
	public EgxModuleParallel(IEgxContextParallel egxContext) {
		this.context = egxContext;
		this.invokedTemplates = new ConcurrentLinkedQueue<>();
	}
	
	@Override
	protected void generateRules() throws EolRuntimeException {
		IEgxContextParallel context = getContext();
		EglTemplateFactory templateFactory = context.newTemplateFactory();
		Map<URI, EglTemplate> templateCache = ConcurrencyUtils.concurrentMap();
		
		for (GenerationRule rule : getGenerationRules()) {
			Collection<?> allElements = rule.getAllElements(context);
			ArrayList<Runnable> genJobs = new ArrayList<>(allElements.size());
			
			for (Object element : allElements) {
				genJobs.add(() -> {
					try {
						rule.generate(context, templateFactory, this, element, templateCache);
					}
					catch (EolRuntimeException exception) {
						context.handleException(exception);
					}
				});
			}
			
			context.executeParallel(rule, genJobs);
		}
	}
	
	@Override
	protected void prepareExecution() throws EolRuntimeException {
		super.prepareExecution();
		getContext().goParallel();
	}
	
	@Override
	protected void postExecution() throws EolRuntimeException {
		getContext().endParallel();
		super.postExecution();
	}
	
	@Override
	public IEgxContextParallel getContext() {
		return (IEgxContextParallel) context;
	}
	
	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEgxContextParallel) {
			super.setContext(context);
		}
	}
}
