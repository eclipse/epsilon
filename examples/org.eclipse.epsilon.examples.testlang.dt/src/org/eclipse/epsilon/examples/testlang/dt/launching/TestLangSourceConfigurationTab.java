/*******************************************************************************
 * Copyright (c) 2016 Aston University.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.examples.testlang.dt.launching;

import org.eclipse.epsilon.common.dt.EpsilonPlugin;
import org.eclipse.epsilon.common.dt.launching.AbstractSourceConfigurationTab;
import org.eclipse.epsilon.examples.testlang.dt.TestLangPlugin;

public class TestLangSourceConfigurationTab extends AbstractSourceConfigurationTab {

	@Override
	public EpsilonPlugin getPlugin() {
		return TestLangPlugin.getDefault();
	}

	@Override
	public String getImagePath() {
		return "icons/testlang.png";
	}

	@Override
	public String getSelectionTitle() {
		return "Select TestLang Program source";
	}

	@Override
	public String getSelectionSubtitle() {
		return "TestLang Programs in Workspace";
	}

}
