/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.template;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.test.MockContext;
import org.junit.Before;
import org.junit.Test;

public class TestTemplateFactory {
	
	private TemplateFactory tf = new TemplateFactory(new MockContext());
	
	@Before
	public void setUp() {
		tf = new TemplateFactory(new MockContext());
	}
	
	@Test
	public void testResolveAbsolute() throws EglRuntimeException, URISyntaxException {
		final String expected = "file:///c:/foo/bar.txt";
		
		assertEquals(new URI(expected), tf.resolveTemplate(expected));
	}
	
	@Test
	public void testResolveRelativeToRoot() throws EglRuntimeException, URISyntaxException {
		final String expected = "file:///c:/foo/bar.txt";
		final String root     = "file:///c:/foo/";
		final String relative = "bar.txt"; 
		
		tf.setRoot(new URI(root));
		
		assertEquals(new URI(expected), tf.resolveTemplate(relative));
	}
	
	@Test
	public void testResolveRelativeToRootComplex() throws EglRuntimeException, URISyntaxException {
		final String expected = "file:///c:/foo/b%20a%20r.txt";
		final String root     = "file:///c:/foo/baz/";
		final String relative = "..\\b a r.txt"; 
		
		tf.setRoot(new URI(root));
		
		assertEquals(new URI(expected), tf.resolveTemplate(relative));
	}
	
	@Test
	public void testResolveRelativeToTemplateRoot() throws EglRuntimeException, URISyntaxException {
		final String expected = "file:///c:/foo/bar/b%20a%20z.txt";
		final String root     = "file:///c:/foo/";
		final String template = "bar";
		final String relative = "b a z.txt"; 
		
		tf.setRoot(new URI(root));
		tf.setTemplateRoot(template);
		
		assertEquals(new URI(expected), tf.resolveTemplate(relative));
	}
	
	@Test
	public void testResolveRelativeToTemplateRootWithSlash() throws EglRuntimeException, URISyntaxException {
		final String expected = "file:///c:/foo/bar/b%20a%20z.txt";
		final String root     = "file:///c:/foo/";
		final String template = "bar/";
		final String relative = "b a z.txt"; 
		
		tf.setRoot(new URI(root));
		tf.setTemplateRoot(template);
		
		assertEquals(new URI(expected), tf.resolveTemplate(relative));
	}
	
	@Test
	public void testResolveRelativeToTemplateRootComplex() throws EglRuntimeException, URISyntaxException {
		final String expected = "file:///c:/foo/bar/f%20o%20o/b%20a%20z.txt";
		final String root     = "file:///c:/foo/";
		final String template = "bar\\f o o";
		final String relative = "b a z.txt"; 
		
		tf.setRoot(new URI(root));
		tf.setTemplateRoot(template);
		
		assertEquals(new URI(expected), tf.resolveTemplate(relative));
	}
	
	@Test
	public void testResolveRelativeToTemplateRootAbsolute() throws EglRuntimeException, URISyntaxException {
		final String expected = "file:///c:/abs/b%20a%20r/b%20a%20z.txt";
		final String root     = "file:///c:/foo/";
		final String template = "file:///c:/abs/";
		final String relative = "b a r\\b a z.txt"; 
		
		tf.setRoot(new URI(root));
		tf.setTemplateRoot(template);
		
		assertEquals(new URI(expected), tf.resolveTemplate(relative));
	}
}
