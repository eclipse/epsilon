/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.ecl.launch;

import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.IEclModule;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;
import org.eclipse.epsilon.eol.models.IModel;

public class EclRunConfiguration extends IEolRunConfiguration<IEclModule, MatchTrace> {

	public EclRunConfiguration(
		Path eolFile,
		Map<IModel, StringProperties> modelsAndProperties,
		Optional<IEclModule> eolModule,
		Optional<Map<String, ?>> parameters,
		Optional<Boolean> showResults,
		Optional<Boolean> profileExecution,
		Optional<Integer> configID,
		Optional<Path> scratchFile) {
			super(
				eolFile,
				modelsAndProperties,
				eolModule,
				parameters,
				showResults,
				profileExecution,
				configID,
				scratchFile
			);
	}

	@Override
	protected IEclModule getDefaultModule() {
		return new EclModule();
	}
	
	@Override
	protected void postExecute() throws Exception {
		// TODO Auto-generated method stub
		super.postExecute();
	}
}
