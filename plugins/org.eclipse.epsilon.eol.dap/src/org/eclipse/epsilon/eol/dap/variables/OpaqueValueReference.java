/*******************************************************************************
 * Copyright (c) 2024 The University of York.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.epsilon.eol.dap.variables;

import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class OpaqueValueReference extends IdentifiableReference<Object> {

	private final String name;

	public OpaqueValueReference(IEolContext context, String name, Object value) {
		super(context, value);
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

}
