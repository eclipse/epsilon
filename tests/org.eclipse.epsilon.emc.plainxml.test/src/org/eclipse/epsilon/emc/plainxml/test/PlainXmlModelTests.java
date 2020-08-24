/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.plainxml.test;

import org.eclipse.epsilon.emc.plainxml.PlainXmlModel;
import org.eclipse.epsilon.eol.EolEvaluator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlainXmlModelTests {
	
	protected PlainXmlModel model;
	protected EolEvaluator evaluator;
	
	@Before
	public void setup() throws Exception {
		model = new PlainXmlModel();
		model.setName("M");
		model.setReadOnLoad(true);
		model.setXml(
			"<?xml version='1.0'?>" + newline() +
			"<library>" + newline() +
				"<book name='b1' pages='212' authors='a1,a2' editor='e1' text='b1-text'/>" + newline() + 
				"<book name='b1' pages='122' editor='e2'>b2-text</book>" + newline() + 
				"<book name='b3' pages='351' editor='e3'/>" + newline() + 
				"<author name='a1'/>" + newline() + 
				"<author name='a2'/>" + newline() +
				"<author name='a3'/>" + newline() +
				"<editor name='e1'/>" + newline() + 
				"<editor name='e2'/>" + newline() +
				"<editor name='e3'/>" + newline() +
			"</library>" + newline()
		);
		model.bind("book", "authors", "author", "name", true);
		model.bind("book", "editor", "editor", "name", false);
		model.load();
		evaluator = new EolEvaluator(model);
		
	}
	
	public String newline() {
		return System.getProperty("line.separator");
	}
	
	@Test
	public void testAllOfKind() {
		assertEquals(evaluator.evaluate("t_library.all.size()"), 1);
		assertEquals(evaluator.evaluate("t_book.all.size()"), 3);
	}
	
	@Test
	public void testStringAttribute() {
		assertEquals(evaluator.evaluate("t_book.all.first().a_name"), "b1");
	}
	
	@Test
	public void testTextAttribute() {
		assertEquals("b1-text", evaluator.evaluate("t_book.all.first().a_text"));
	}
	
	@Test
	public void testText() {
		assertEquals("b2-text", evaluator.evaluate("t_book.all.second().text"));
	}
	
	@Test
	public void testIntegerAttribute() {
		assertEquals(evaluator.evaluate("t_book.all.first().i_pages"), 212);
	}
	
	@Test
	public void testMultipleReferenceAttribute() {
		assertEquals(evaluator.evaluate("t_book.all.first().x_authors.size()"), 2);				
	}
	
	@Test
	public void testSingleReferenceAttribute() {
		assertEquals(evaluator.evaluate("t_book.all.first().x_editor.a_name"), "e1");				
	}
	
	@Test 
	public void testAddRemoveToMultipleReference() {
		evaluator.execute("t_book.all.first().x_authors.add(t_author.all.third());");
		assertEquals(evaluator.evaluate("t_book.all.first().x_authors.size()"), 3);				
		evaluator.execute("t_book.all.first().x_authors.remove(t_author.all.third());");
		assertEquals(evaluator.evaluate("t_book.all.first().x_authors.size()"), 2);	
	}
	
	@Test
	public void testSetSingleReference() {
		evaluator.execute("t_book.all.first().x_editor = t_editor.all.second();");		
		assertEquals(evaluator.evaluate("t_book.all.first().x_editor.a_name"), "e2");				
		evaluator.execute("t_book.all.first().x_editor = t_editor.all.first();");		
	}
	
	@Test
	public void testSetMultipleReference() {
		evaluator.execute("t_book.all.third().x_authors = Sequence{t_author.all.first(), t_author.all.second()};");
		assertEquals(evaluator.evaluate("t_book.all.third().x_authors.collect(a|a.a_name).concat(',')"), "a1,a2");
		evaluator.execute("t_book.all.third().x_authors = Sequence{};");
		assertEquals(evaluator.evaluate("t_book.all.third().a_authors"), "");
	}
	
}
