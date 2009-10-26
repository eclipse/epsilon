/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.common.dt.nature;

import static org.junit.Assert.assertEquals;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.test.util.TestThatUsesAProject;
import org.junit.Test;

public class BuilderConfiguringNatureTests extends TestThatUsesAProject {
	
	@Test
	public void addsBuilderToNatureOnConfigure() throws CoreException {
		final FakeBuilderConfiguringNature nature = new FakeBuilderConfiguringNature();
		
		nature.setProject(project);
		nature.configure();
		
		final ICommand[] buildSpec = project.getDescription().getBuildSpec();
		
		assertEquals(1, buildSpec.length);
		assertEquals(nature.getBuilderID(), buildSpec[0].getBuilderName());
	}
	
	@Test
	public void doesNotAddSecondBuilderToNatureOnSecondCallToConfigure() throws CoreException {
		final FakeBuilderConfiguringNature nature = new FakeBuilderConfiguringNature();
		
		nature.setProject(project);
		nature.configure();
		nature.configure();
		
		final ICommand[] buildSpec = project.getDescription().getBuildSpec();
		
		assertEquals(1, buildSpec.length);
	}
	
	
	
	private static class FakeBuilderConfiguringNature extends BuilderConfiguringNature {

		@Override
		public String getBuilderID() {
			return "test.id";
		}
		
	}
}
