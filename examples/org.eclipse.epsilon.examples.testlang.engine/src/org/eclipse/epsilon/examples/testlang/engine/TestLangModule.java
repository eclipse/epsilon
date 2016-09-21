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
package org.eclipse.epsilon.examples.testlang.engine;

import java.util.Collections;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class TestLangModule extends EolModule {

	@Override
	public Object execute() throws EolRuntimeException {
		super.execute();

		final IEolContext ctx = getContext();
		for (Operation op : getOperations()) {
			if (op.hasAnnotation("test")) {
				op.execute(null, Collections.emptyList(), ctx);
			}
		}

		return super.execute();
	}

}
