/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egl.launch;

import java.net.URI;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.egl.concurrent.EgxModuleParallelAnnotation;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.concurrent.EgxContextParallel;
import org.eclipse.epsilon.erl.launch.IErlRunConfiguration;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EgxRunConfiguration extends IErlRunConfiguration {
	
	public static class Builder<C extends EgxRunConfiguration, B extends Builder<C, B>> extends IErlRunConfiguration.Builder<C, B> {
		protected Builder() {
			super();
		}
		protected Builder(Class<C> runConfigClass) {
			super(runConfigClass);
		}
		
		@Override
		protected IEgxModule createModule() {
			return isParallel() ? new EgxModuleParallelAnnotation(new EgxContextParallel(parallelism)) : new EgxModule();
		}
	}
	
	public static Builder<? extends EgxRunConfiguration, ?> Builder() {
		return new Builder<>(EgxRunConfiguration.class);
	}
	
	public EgxRunConfiguration(Builder<? extends EgxRunConfiguration, ?> builder) {
		super(builder);
	}
	
	public EgxRunConfiguration(EgxRunConfiguration other) {
		super(other);
	}

	protected URI getDefaultOutputRoot() {
		return (outputFile != null ? outputFile : script).getParent().toUri();
	}
	
	protected EglTemplateFactory getDefaultTemplateFactory() throws EglRuntimeException {
		EglFileGeneratingTemplateFactory templateFactory = new EglFileGeneratingTemplateFactory();
		templateFactory.setOutputRoot(getDefaultOutputRoot().toString());
		return templateFactory;
	}
	
	@Override
	public IEgxModule getModule() {
		return (IEgxModule) super.getModule();
	}
	
	@Override
	public void preExecute() throws Exception {
		getModule().getContext().setTemplateFactory(getDefaultTemplateFactory());
		super.preExecute();
	}
}