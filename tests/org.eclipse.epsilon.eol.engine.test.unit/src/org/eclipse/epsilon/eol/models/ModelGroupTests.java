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
package org.eclipse.epsilon.eol.models;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.reset;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModelGroupTests {
	
	private static final ModelRepository repository = new ModelRepository();
	private static IModel first;
	private static IModel second;
	
	@BeforeClass
	public static void setup() {
		first  = createMock(IModel.class);
		second = createMock(IModel.class);
		
		repository.addModel(first);
		repository.addModel(second);
	}
	
	@Before
	public void resetMocks() {
		reset(first, second);
		
		expect(first.getAliases()) .andReturn(Arrays.asList("first",  "Ecore"));
		expectLastCall().anyTimes();
		
		expect(second.getAliases()).andReturn(Arrays.asList("second", "Ecore"));
		expectLastCall().anyTimes();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void allContentsDelegatesToGroupedModels() throws EolModelNotFoundException {		
		final Object pkg = EcoreFactory.eINSTANCE.createEPackage();
		final Object cls = EcoreFactory.eINSTANCE.createEClass();
		
		expect(first.allContents()) .andReturn((Collection)Arrays.asList(pkg));		
		expect(second.allContents()).andReturn((Collection)Arrays.asList(cls));
		
		replay(first, second);
		
		final ModelGroup group = new ModelGroup(repository, "Ecore");
		assertEquals(Arrays.asList(pkg, cls), group.allContents());
		verify(first, second);
	}
	
	
	@Test
	public void typeNameOfDelegatesToGroupedModels() throws EolModelNotFoundException {		
		final EObject pkg = EcoreFactory.eINSTANCE.createEPackage();
		
		expect(first.isModelElement(pkg)) .andReturn(false);		
		expect(second.isModelElement(pkg)).andReturn(true);		
		
		expect(second.getTypeNameOf(pkg)).andReturn("EPackage");
		
		replay(first, second);
		
		final ModelGroup group = new ModelGroup(repository, "Ecore");
		assertEquals("EPackage", group.getTypeNameOf(pkg));
		verify(first, second);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void exceptionWhenNoGroupedModelKnowsTypeNameOfInstance() throws EolModelNotFoundException {		
		expect(first.isModelElement("foo")) .andReturn(false);		
		expect(second.isModelElement("foo")).andReturn(false);		
		
		replay(first, second);
		
		final ModelGroup group = new ModelGroup(repository, "Ecore");
		group.getTypeNameOf("foo");
	}
}
