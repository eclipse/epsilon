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
package org.eclipse.epsilon.egl.config;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.egl.merge.partition.CommentBlockPartitioner;
import org.eclipse.epsilon.egl.merge.partition.CompositePartitioner;
import org.eclipse.epsilon.commons.util.FileUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestXMLConfigFileReader {

	private final ConfigFileReader reader = new XMLConfigFileReader();
	
	private static String invalidPath;
	private static String nonExistentPath;
	
	private static String empty;
	private static String incorrectRoot;
	
	private static String contentTypesContainingCDATA;
	private static String contentTypesContainingWrongChild;
	private static String contentTypesExtraAttributes;
	private static String emptyContentTypes;
	
	private static String contentTypeContainingCDATA;
	private static String contentTypeContainingWrongChild;
	private static String contentTypeExtraAttributes;
	private static String emptyContentType;
	private static String unnamedContentType;
	
	private static String commentStyleContainingCDATA;
	private static String commentStyleEmptyEndsWith;
	private static String commentStyleEmptyStartsWith;
	private static String commentStyleExtraAttributes;
	private static String emptyCommentStyle;
	
	private static String valid;
	
	@BeforeClass
	public static void setUpOnce() throws UnsupportedEncodingException {
		invalidPath      = FileUtil.getPath("In*alid.xml", TestXMLConfigFileReader.class);
		nonExistentPath  = FileUtil.getPath("Absent.xml", TestXMLConfigFileReader.class);
		
		empty          = FileUtil.getPath("Empty.xml", TestXMLConfigFileReader.class);
		incorrectRoot  = FileUtil.getPath("IncorrectRoot.xml", TestXMLConfigFileReader.class);
		
		contentTypesContainingCDATA      = FileUtil.getPath("ContentTypesContainingCDATA.xml", TestXMLConfigFileReader.class);
		contentTypesContainingWrongChild = FileUtil.getPath("ContentTypesContainingWrongChild.xml", TestXMLConfigFileReader.class);
		contentTypesExtraAttributes      = FileUtil.getPath("ContentTypesExtraAttributes.xml", TestXMLConfigFileReader.class);
		emptyContentTypes                = FileUtil.getPath("EmptyContentTypes.xml", TestXMLConfigFileReader.class);
		
		contentTypeContainingCDATA      = FileUtil.getPath("ContentTypeContainingCDATA.xml", TestXMLConfigFileReader.class);
		contentTypeContainingWrongChild = FileUtil.getPath("ContentTypeContainingWrongChild.xml", TestXMLConfigFileReader.class);
		contentTypeExtraAttributes      = FileUtil.getPath("ContentTypeExtraAttributes.xml", TestXMLConfigFileReader.class);
		emptyContentType                = FileUtil.getPath("EmptyContentType.xml", TestXMLConfigFileReader.class);
		unnamedContentType              = FileUtil.getPath("UnnamedContentType.xml", TestXMLConfigFileReader.class);
		
		commentStyleContainingCDATA = FileUtil.getPath("CommentStyleContainingCDATA.xml", TestXMLConfigFileReader.class);
		commentStyleEmptyEndsWith   = FileUtil.getPath("CommentStyleEmptyEndsWith.xml", TestXMLConfigFileReader.class);
		commentStyleEmptyStartsWith = FileUtil.getPath("CommentStyleEmptyStartsWith.xml", TestXMLConfigFileReader.class);
		commentStyleExtraAttributes = FileUtil.getPath("CommentStyleExtraAttributes.xml", TestXMLConfigFileReader.class);
		emptyCommentStyle           = FileUtil.getPath("EmptyCommentStyle.xml", TestXMLConfigFileReader.class);
		
		valid = FileUtil.getPath("Valid.xml", TestXMLConfigFileReader.class);
	}
	
	private Map<String, CompositePartitioner> read(String path) throws FileNotFoundException, PersistenceException {
		final InputStream is = new FileInputStream(new File(path));	
		return reader.read(is);
	}
	
	@Test (expected=FileNotFoundException.class)
	public void readInvalid() throws PersistenceException, FileNotFoundException {
		read(invalidPath);
	}
	
	@Test (expected=FileNotFoundException.class)
	public void readNonExistent() throws PersistenceException, FileNotFoundException {
		read(nonExistentPath);
	}
	
	
	@Test (expected=PersistenceException.class)
	public void readEmpty() throws PersistenceException, FileNotFoundException {
		read(empty);
	}
	
	@Test (expected=PersistenceException.class)
	public void readIncorrectRoot() throws PersistenceException, FileNotFoundException {
		read(incorrectRoot);
	}
	
	
	
	@Test (expected=PersistenceException.class)
	public void readContentTypesContainingCDATA() throws PersistenceException, FileNotFoundException {
		read(contentTypesContainingCDATA);
	}
	
	@Test (expected=PersistenceException.class)
	public void readContentTypesContainingWrongChild() throws PersistenceException, FileNotFoundException {
		read(contentTypesContainingWrongChild);
	}
	
	@Test (expected=PersistenceException.class)
	public void readContentTypesExtraAttributes() throws PersistenceException, FileNotFoundException {
		read(contentTypesExtraAttributes);
	}
	
	@Test
	public void readEmptyContentTypes() throws PersistenceException, FileNotFoundException {
		final Map<String, CompositePartitioner> expected = new HashMap<String, CompositePartitioner>();
		
		assertEquals(expected, read(emptyContentTypes));
	}
	
	
	
	@Test (expected=PersistenceException.class)
	public void readContentTypeContainingCDATA() throws PersistenceException, FileNotFoundException {
		read(contentTypeContainingCDATA);
	}
	
	@Test (expected=PersistenceException.class)
	public void readContentTypeContainingWrongChild() throws PersistenceException, FileNotFoundException {
		read(contentTypeContainingWrongChild);
	}
	
	@Test (expected=PersistenceException.class)
	public void readContentTypeExtraAttributes() throws PersistenceException, FileNotFoundException {
		read(contentTypeExtraAttributes);
	}
	
	@Test (expected=PersistenceException.class)
	public void readEmptyContentType() throws PersistenceException, FileNotFoundException {
		read(emptyContentType);
	}
	
	@Test (expected=PersistenceException.class)
	public void readUnnamedContentType() throws PersistenceException, FileNotFoundException {
		read(unnamedContentType);
	}
	
	
	
	@Test (expected=PersistenceException.class)
	public void readCommentStyleContainingCDATA() throws PersistenceException, FileNotFoundException {
		read(commentStyleContainingCDATA);
	}
	
	@Test
	public void readCommentStyleEmptyEndsWith() throws PersistenceException, FileNotFoundException {
		final Map<String, CompositePartitioner> expected = new HashMap<String, CompositePartitioner>();
		expected.put("Java", new CompositePartitioner(new CommentBlockPartitioner("//", null)));
		
		assertEquals(expected, read(commentStyleEmptyEndsWith));
	}
	
	@Test
	public void readCommentStyleEmptyStartsWith() throws PersistenceException, FileNotFoundException {
		final Map<String, CompositePartitioner> expected = new HashMap<String, CompositePartitioner>();
		expected.put("OddLanguage", new CompositePartitioner(new CommentBlockPartitioner(null, "**")));
		
		assertEquals(expected, read(commentStyleEmptyStartsWith));
	}
	
	@Test (expected=PersistenceException.class)
	public void readCommentStyleExtraAttributes() throws PersistenceException, FileNotFoundException {
		read(commentStyleExtraAttributes);
	}
	
	@Test
	public void readEmptyCommentStyle() throws PersistenceException, FileNotFoundException {
		final Map<String, CompositePartitioner> expected = new HashMap<String, CompositePartitioner>();
		expected.put("PlainText", new CompositePartitioner(new CommentBlockPartitioner(null, null)));
		
		assertEquals(expected, read(emptyCommentStyle));
	}
	
	
	@Test
	public void readValid() throws PersistenceException, FileNotFoundException {
		final Map<String, CompositePartitioner> expected = new HashMap<String, CompositePartitioner>();
		expected.put("Java", new CompositePartitioner(new CommentBlockPartitioner("//", null),
		                                              new CommentBlockPartitioner("/*", "*/")));
		
		expected.put("HTML", new CompositePartitioner(new CommentBlockPartitioner("<!--", "-->")));
		
		expected.put("EGL", new CompositePartitioner(new CommentBlockPartitioner("--", null)));
		
		expected.put("VisualBasic", new CompositePartitioner(new CommentBlockPartitioner("'", null)));
		
		assertEquals(expected, read(valid));
	}
}
