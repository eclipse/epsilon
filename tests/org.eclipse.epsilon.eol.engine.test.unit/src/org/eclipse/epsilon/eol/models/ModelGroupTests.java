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
import java.util.LinkedList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.epsilon.emc.emf.xml.XmlModel;
import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.operations.contributors.IOperationContributorProvider;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Element;

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
	
	@Test
	public void testProperties() throws Exception {
		ModelRepository repository = new ModelRepository();
		repository.addModel(createReadOnlyPlainXmlModel("Foo", "Xml", "<a p=\"\"/>"));
		repository.addModel(createReadOnlyPlainXmlModel("Bar", "Xml", "<a p=\"\"/>"));
		IModel modelGroup = repository.getModelByName("Xml");
		
		EolModule module = new EolModule();
		module.getContext().getModelRepository().addModel(modelGroup);
		module.parse("for (a in Xml!t_a.all) { a.a_p = 'something'; } "
				+ "assertEquals(Xml!t_a.all.first().a_p, 'something');"
				+ "assertEquals(Xml!t_a.all.second().a_p, 'something');"
				);
		module.execute();
	}
	
	@Test
	public void testModelGroupOperationContributor() throws Exception {
		
		PlainXmlModel m1 = new PlainXmlModelExt();
		m1.setName("M1");
		m1.getAliases().add("Xml");
		m1.getAliases().add("Alias1");
		m1.setXml("<?xml version=\"1.0\"?>" + "<foo/>");
		m1.setReadOnLoad(true);
		m1.load();
		
		PlainXmlModel m2 = new PlainXmlModelExt();
		m2.setName("M1");
		m2.getAliases().add("Xml");
		m2.getAliases().add("Alias2");
		m2.setXml("<?xml version=\"1.0\"?>" + "<foo/>");
		m2.setReadOnLoad(true);
		m2.load();
		
		EolModule module = new EolModule();
		module.getContext().getModelRepository().addModel(m1);
		module.getContext().getModelRepository().addModel(m2);
		
		module.parse("return Sequence{"
				+ "Xml!t_foo.all.class.simpleName, "
				+ "Xml!t_foo.getAllOfType().class.simpleName, "
				+ "Xml.allContents().class.simpleName, "
				+ "Alias1!t_foo.all.class.simpleName, "
				+ "Alias1!t_foo.getAllOfType().class.simpleName, "
				+ "Alias1.allContents().class.simpleName"
				+ "};");
		assertEquals(Arrays.asList("ArrayList", "ArrayList", "ArrayList", "LinkedList", "LinkedList", "LinkedList"), module.execute());
		
	}
	
	protected PlainXmlModel createReadOnlyPlainXmlModel(String name, String alias, String xml) {
		PlainXmlModel m = new PlainXmlModel();
		m.setName(name);	
		m.getAliases().add(alias);
		m.setXml("<?xml version=\"1.0\"?>" + xml);
		try {
			m.load();
		} catch (EolModelLoadingException e) {
			throw new RuntimeException(e);
		}
		return m;
	}
	
	class PlainXmlModelExt extends PlainXmlModel {
		
		@Override
		public Collection<Element> getAllOfType(String type) throws EolModelElementTypeNotFoundException {
			return new LinkedList<>(super.getAllOfType(type));
		}
		
		@Override
		public Collection<Element> getAllOfKind(String type) throws EolModelElementTypeNotFoundException {
			return new LinkedList<>(super.getAllOfKind(type));
		}
		
		@Override
		public Collection<Element> allContents() {
			return new LinkedList<>(super.allContents());
		}
	}
}
