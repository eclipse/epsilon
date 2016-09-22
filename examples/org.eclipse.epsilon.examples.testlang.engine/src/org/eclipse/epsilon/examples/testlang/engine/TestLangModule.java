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
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.types.EolNoType;

public class TestLangModule extends EolModule {

	public class TestLangOperationContributor extends OperationContributor {
		@Override
		public boolean contributesTo(Object target) {
			// We only contribute "global" functions
			return target == EolNoType.NoInstance;
		}

		public void areEqual(Object a, Object b) throws FailedAssertionException {
			if (a != b) {
				if (a == null || b == null || !a.equals(b)) {
					throw new FailedAssertionException("Expected " + a + ", got " + b);
				}
			}
		}
	}

	@Override
	protected void prepareContext(IEolContext context) {
		super.prepareContext(context);
		context.getOperationContributorRegistry().add(new TestLangOperationContributor());
	}

	@Override
	public Object execute() throws EolRuntimeException {
		super.execute();

		final IEolContext ctx = getContext();
		for (Operation op : getOperations()) {
			if (op.hasAnnotation("test")) {
				runTest(ctx, op);
			}
		}

		return super.execute();
	}

	protected void runTest(final IEolContext ctx, final Operation op) throws EolRuntimeException {
		try {
			op.execute(null, Collections.emptyList(), ctx);
			getContext().getOutputStream().println("Test " + op.getName() + " PASSED");
		} catch (EolRuntimeException ex) {
			if (ex.getCause() instanceof FailedAssertionException) {
				getContext().getErrorStream().println("Test " + op.getName() + " FAILED: " + ex.getMessage());
			} else {
				throw ex;
			}
		}
	}

}
