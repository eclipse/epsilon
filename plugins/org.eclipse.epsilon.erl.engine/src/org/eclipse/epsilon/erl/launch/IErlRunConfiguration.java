/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.erl.launch;

import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.erl.IErlModule;
import org.eclipse.epsilon.erl.execute.context.IErlContext;

public abstract class IErlRunConfiguration<M extends IErlModule, R> extends IEolRunConfiguration<M, R> {

	public IErlRunConfiguration(IEolRunConfiguration<? extends M, ? extends R> other) {
		super(other);
	}

	public IErlRunConfiguration(Path eolFile, Map<IModel, StringProperties> modelsAndProperties, M eolModule, Map<String, ?> parameters) {
		super(eolFile, modelsAndProperties, eolModule, parameters);
	}

	public IErlRunConfiguration(Path eolFile, Map<IModel, StringProperties> modelsAndProperties, M eolModule) {
		super(eolFile, modelsAndProperties, eolModule);
	}

	public IErlRunConfiguration(Path eolFile, Map<IModel, StringProperties> modelsAndProperties, Optional<M> eolModule, Optional<Map<String, ?>> parameters, Optional<Boolean> showResults, Optional<Boolean> profileExecution, Optional<Integer> configID, Optional<Path> scratchFile) {
		super(eolFile, modelsAndProperties, eolModule, parameters, showResults, profileExecution, configID, scratchFile);
	}

	@Override
	protected void postExecute() throws Exception {
		super.postExecute();
		if (profileExecution && module.getContext() instanceof IErlContext) {
			writeOut(((IErlContext) module.getContext()).getExecutorFactory().getRuleProfiler(), printMarker);
		}
	}
	
}
