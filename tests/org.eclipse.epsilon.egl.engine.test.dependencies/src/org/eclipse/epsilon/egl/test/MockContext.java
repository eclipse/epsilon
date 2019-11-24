/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.test;

import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.execute.context.EglContext;
import org.eclipse.epsilon.egl.internal.EglModule;

public class MockContext extends EglContext {
	
	public MockContext() {
		super(new EglTemplateFactory());
	}

	@Override
	public EglModule getModule() {
		return new MockModule(this);
	}
	
	private static class MockModule extends EglModule {
		public MockModule(IEglContext context) {
			super(context);
		}
	}
}
