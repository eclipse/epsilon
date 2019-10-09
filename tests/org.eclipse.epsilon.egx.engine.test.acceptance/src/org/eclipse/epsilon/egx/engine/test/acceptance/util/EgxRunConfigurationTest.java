/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egx.engine.test.acceptance.util;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import org.eclipse.epsilon.egl.launch.EgxRunConfiguration;
import org.eclipse.epsilon.egx.engine.test.acceptance.EgxAcceptanceTestUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

/**
 * 
 *
 * @author Sina Madani
 * @since 1.6
 */
public class EgxRunConfigurationTest extends EgxRunConfiguration {
	
	public EgxRunConfigurationTest(Builder<? extends EgxRunConfiguration, ?> builder) {
		super(builder);
	}

	@Override
	protected Object execute() throws EolRuntimeException {
		getModule().execute();
		return getResult();
	}
	
	@Override
	protected void postExecute() throws Exception {
		EgxAcceptanceTestUtil.deleteOutputDirectories();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Path, byte[]> getResult() {
		if (!(result instanceof Map)) try {
			result = EgxAcceptanceTestUtil.getOutputFiles();
		}
		catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return (Map<Path, byte[]>) result;
	}

}
