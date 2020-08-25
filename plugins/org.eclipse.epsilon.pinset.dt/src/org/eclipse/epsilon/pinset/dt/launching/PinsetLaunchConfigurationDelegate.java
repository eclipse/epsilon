/*********************************************************************
 * Copyright (c) 2020 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *********************************************************************/
package org.eclipse.epsilon.pinset.dt.launching;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.common.dt.launching.extensions.ModuleImplementationExtension;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.pinset.PinsetModule;
import org.eclipse.epsilon.pinset.dt.launching.tabs.PinsetOutputConfigurationTab;

/**
 * PinsetLaunchConfigurationDelegate.
 *
 * @author Alfonso de la Vega
 * @since 2.1
 */
public class PinsetLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {

	@Override
	public IEolModule createModule() {
		PinsetModule module = new PinsetModule();
		if (configuration != null) {
			try {
				IFile file =
						ResourcesPlugin.getWorkspace()
								.getRoot()
								.getFile(new Path(configuration.getAttribute(
										PinsetOutputConfigurationTab.OUTPUT_FOLDER,
										PinsetOutputConfigurationTab.DEFAULT_OUTPUT_FOLDER)));
				String outputFolder = file.getRawLocation().toOSString();
				module.setOutputFolder(outputFolder);
				module.setSilent(configuration.getAttribute(
						PinsetOutputConfigurationTab.SILENT_EXECUTION,
						PinsetOutputConfigurationTab.DEFAULT_SILENT_EXECUTION));
			}
			catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return module;
	}

	@Override
	protected EolDebugger createDebugger() {
		return new PinsetDebugger();
	}

	@Override
	public String getLanguage() {
		return "Pinset";
	}

	@Override
	public PinsetModule getDefaultModule(ILaunchConfiguration configuration) {
		try {
			return ModuleImplementationExtension.defaultImplementation(getLanguage()).createModule();
		}
		catch (CoreException e) {
		}
		return null;
	}

}
