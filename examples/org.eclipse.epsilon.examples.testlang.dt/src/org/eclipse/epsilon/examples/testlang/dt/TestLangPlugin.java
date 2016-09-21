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
package org.eclipse.epsilon.examples.testlang.dt;

import org.eclipse.epsilon.common.dt.AbstractEpsilonUIPlugin;

public class TestLangPlugin extends AbstractEpsilonUIPlugin {

	public static TestLangPlugin getDefault() {
		return (TestLangPlugin) plugins.get(TestLangPlugin.class);
	}
}
