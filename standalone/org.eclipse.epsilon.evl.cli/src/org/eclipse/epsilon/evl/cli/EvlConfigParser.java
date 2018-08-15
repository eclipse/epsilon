/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.cli;

import org.eclipse.epsilon.eol.cli.EolConfigParser;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.launch.EvlRunConfiguration;

public class EvlConfigParser extends EolConfigParser<IEvlModule, EvlRunConfiguration> {

	public static void main(String[] args) {
		new EvlConfigParser(EvlRunConfiguration.class).apply(args).run();
	}
	
	public EvlConfigParser(Class<EvlRunConfiguration> configurationClass) {
		super(configurationClass);
	}
	
}
