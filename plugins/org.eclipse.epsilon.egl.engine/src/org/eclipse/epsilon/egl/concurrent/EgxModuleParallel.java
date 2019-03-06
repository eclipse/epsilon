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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.execute.context.concurrent.EgxContextParallel;
import org.eclipse.epsilon.egl.execute.context.concurrent.IEgxContextParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;

/**
 * A no-op parallel module, useful only for extending or setting number of threads used in
 * parallel operations.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EgxModuleParallel extends EgxModule {

	protected static final Set<String> CONFIG_PROPERTIES = new HashSet<>(2);
	static {
		CONFIG_PROPERTIES.add(IEolContextParallel.NUM_THREADS_CONFIG);
	}
	
	public EgxModuleParallel() {
		this(new EgxContextParallel());
	}
	
	public EgxModuleParallel(int parallelism) {
		this(new EgxContextParallel(null, parallelism));
	}
	
	public EgxModuleParallel(IEgxContextParallel egxContext) {
		setContext(egxContext);
		this.invokedTemplates = new ConcurrentLinkedQueue<>();
	}

	@Override
	public Object executeImpl() throws EolRuntimeException {
		prepareExecution();
		int numberOfRules = getGenerationRules().size();
		generateRules(getTemplateFactory(), ConcurrencyUtils.concurrentMap(numberOfRules, (numberOfRules/2)+1), getContext());
		postExecution();
		return null;
	}
	
	protected void generateRules(EglTemplateFactory templateFactory, Map<URI, EglTemplate> templateCache, IEgxContextParallel context) throws EolRuntimeException {
		generateRules(templateFactory);
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
		return (IEgxContextParallel) super.getContext();
	}
	
	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEgxContextParallel) {
			super.setContext(context);
		}
	}
	
	/**
	 * WARNING: This method should only be called by the DT plugin for initialization purposes,
	 * as the context will be reset!
	 */
	@Override
	public void configure(Map<String, ?> properties) throws IllegalArgumentException {
		super.configure(properties);
		IEgxContextParallel context = getContext();
		setContext(IEolContextParallel.configureContext(
			properties,
			threads -> new EgxContextParallel(context.getTemplateFactory(), threads),
			context
		));
	}
	
	@Override
	public Set<String> getConfigurationProperties() {
		return CONFIG_PROPERTIES;
	}
}
