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
import java.util.Map;
import java.util.Optional;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.EglContext;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;
import org.eclipse.epsilon.eol.models.IModel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EgxRunConfiguration extends IEolRunConfiguration<IEgxModule, Object> {

	public EgxRunConfiguration(IEolRunConfiguration<? extends IEgxModule, ?> other) {
		super(other);
	}

	public EgxRunConfiguration(Path eolFile, Map<IModel, StringProperties> modelsAndProperties, Optional<IEgxModule> eolModule, Optional<Map<String, ?>> parameters, Optional<Boolean> showResults, Optional<Boolean> profileExecution, Optional<Integer> configID, Optional<Path> scratchFile) {
		super(eolFile, modelsAndProperties, eolModule, parameters, showResults, profileExecution, configID, scratchFile);
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
	protected IEgxModule getDefaultModule() {
		return new EgxModule();
	}
	
	@Override
	public void preExecute() throws Exception {
		((EglContext) module.getContext()).setTemplateFactory(getDefaultTemplateFactory());
		super.preExecute();
	}
	
	@Override
	protected void postExecute() throws Exception {
		super.postExecute();
	}
}