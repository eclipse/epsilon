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

import java.nio.file.Path;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.erl.launch.IErlRunConfiguration;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EgxRunConfiguration extends IErlRunConfiguration {
	
	public static Builder<? extends EgxRunConfiguration, ?> Builder() {
		return Builder(EgxRunConfiguration.class);
	}
	
	public EgxRunConfiguration(Builder<? extends EgxRunConfiguration, ?> builder) {
		super(builder);
	}
	
	public EgxRunConfiguration(EgxRunConfiguration other) {
		super(other);
	}

	protected EglTemplateFactory getDefaultTemplateFactory() {
		EglFileGeneratingTemplateFactory templateFactory = new EglFileGeneratingTemplateFactory();
		try {
			Path outputDir = (outputFile != null ? outputFile : script).getParent();
			templateFactory.setOutputRoot(outputDir.toString());
		}
		catch (EglRuntimeException ex) {
			ex.printStackTrace();
		}
		return templateFactory;
	}
	
	@Override
	public IEgxModule getModule() {
		return (IEgxModule) super.getModule();
	}
	
	@Override
	protected IEgxModule getDefaultModule() {
		return new EgxModule();
	}
	
	@Override
	public void preExecute() throws Exception {
		getModule().setTemplateFactory(getDefaultTemplateFactory());
		super.preExecute();
	}
	
	@Override
	protected void postExecute() throws Exception {
		super.postExecute();
	}
}