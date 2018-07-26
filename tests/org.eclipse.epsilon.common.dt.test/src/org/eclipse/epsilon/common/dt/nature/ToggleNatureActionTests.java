/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.common.dt.nature;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.test.util.TestThatUsesAProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.junit.Before;
import org.junit.Test;

public class ToggleNatureActionTests extends TestThatUsesAProject {

	private final FakeToggleNatureAction action = new FakeToggleNatureAction();

	private final IAction              dummyActionProxy = createNiceMock("dummyActionProxy", IAction.class);
	private final IAction              mockActionProxy  = createMock("mockActionProxy", IAction.class);
	private final IStructuredSelection selectionStub    = createMock("selectionStub",   IStructuredSelection.class);
	
	@Before
	public void resetMock() {
		reset(dummyActionProxy, mockActionProxy, selectionStub);
		
		expect(selectionStub.getFirstElement()).andStubReturn(project);
	}
	
	@Test
	public void addsNatureWhenProjectDoesNotHaveNature() throws CoreException {
		replay(dummyActionProxy, selectionStub);
		
		
		action.selectionChanged(dummyActionProxy, selectionStub);
		action.run(dummyActionProxy);
		
		verify(dummyActionProxy, selectionStub);
		
		
		assertEquals(1, project.getDescription().getNatureIds().length);
		assertEquals(action.getNatureId(), project.getDescription().getNatureIds()[0]);
	}
	
	@Test
	public void removesNatureWhenProjectHasNature() throws CoreException {
		replay(dummyActionProxy, selectionStub);
		
		
		addNature(project, action.getNatureId());
		action.selectionChanged(dummyActionProxy, selectionStub);
		action.run(dummyActionProxy);
		
		verify(dummyActionProxy, selectionStub);
		
		
		assertEquals(0, project.getDescription().getNatureIds().length);
	}

	@Test
	public void checksProxyWhenSelectionAProjectThatDoesHaveNature() throws CoreException {
		mockActionProxy.setChecked(true);
		
		replay(mockActionProxy, selectionStub);
		
		
		addNature(project, action.getNatureId());
		action.selectionChanged(mockActionProxy, selectionStub);
		
		verify(mockActionProxy, selectionStub);
	}
	
	@Test
	public void unchecksProxyWhenSelectingAProjectThatDoesNotHaveNature() throws CoreException {
		mockActionProxy.setChecked(false);
		
		replay(mockActionProxy, selectionStub);
		
		
		action.selectionChanged(mockActionProxy, selectionStub);
		
		verify(mockActionProxy, selectionStub);
	}
	
	
	public static class FakeToggleNatureAction extends ToggleNatureAction {

		@Override
		public String getNatureId() {
			return "test.nature";
		}
		
	}
	
	// Used by extensions defined in plugin.xml
	public static class FakeNature implements IProjectNature {

		public void configure() throws CoreException {}

		public void deconfigure() throws CoreException {}

		public IProject getProject() { return null; }

		public void setProject(IProject project) {}
		
	}
}
