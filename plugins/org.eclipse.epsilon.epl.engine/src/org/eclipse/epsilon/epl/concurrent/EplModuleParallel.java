/*********************************************************************
 * Copyright (c) 2020 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.epl.concurrent;

import org.eclipse.epsilon.epl.EplModule;
import org.eclipse.epsilon.epl.execute.context.concurrent.EplContextParallel;
import org.eclipse.epsilon.epl.execute.context.concurrent.IEplContextParallel;

/**
 * Only useful for parallel first-order operations.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EplModuleParallel extends EplModule {

	public EplModuleParallel() {
		this(null);
	}

	public EplModuleParallel(IEplContextParallel context) {
		super(context == null ? new EplContextParallel() : context);
	}

	@Override
	public IEplContextParallel getContext() {
		return (IEplContextParallel) super.getContext();
	}
}
