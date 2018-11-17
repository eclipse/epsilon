/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.launch;

import org.eclipse.epsilon.eol.EolModule;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EolRunConfiguration extends IEolRunConfiguration<EolModule, Object> {
	
	public EolRunConfiguration(Builder<EolModule, EolRunConfiguration> builder) {
		super(builder);
	}
	
	public EolRunConfiguration(IEolRunConfiguration<? extends EolModule, ?> other) {
		super(other);
	}
	
	@Override
	protected EolModule getDefaultModule() {
		return new EolModule();
	}
}
