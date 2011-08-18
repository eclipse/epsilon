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
package org.eclipse.epsilon.egl.parse;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.egl.parse.EglLexer;
import org.eclipse.epsilon.egl.parse.RecognitionException;
import org.eclipse.epsilon.egl.parse.Token;
import org.eclipse.epsilon.egl.parse.Token.TokenType;
import org.eclipse.epsilon.commons.util.FileUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.eclipse.epsilon.egl.util.FileUtil.NEWLINE;

public class TestEglLexer {
	
	private static File TEST_FILE;
	
	@BeforeClass
	public static void setUpOnce() throws IOException {
		TEST_FILE = FileUtil.getFile("Test.txt", TestEglLexer.class);
		
		final String program = "[% for(i in Sequence(1..10) { %]" + NEWLINE +
		                       "i is [%=i%]" + NEWLINE +
		                       "[% } %]";
		
		org.eclipse.epsilon.egl.util.FileUtil.write(TEST_FILE, program);
	}
	
	@AfterClass
	public static void tearDownOnce() throws IOException {
		if (TEST_FILE != null && TEST_FILE.exists()) TEST_FILE.delete();
	}
	
	@Test
	public void testStartTag() throws RecognitionException {
		final EglLexer l = new EglLexer("[%");
		
		Token expected = new Token(TokenType.START_TAG, "[%", 1, 1);
		Token actual = l.nextToken();
		
		assertTrue(expected.equals(actual));
	}
	
	
	@Test
	public void testStartOutputTag() throws RecognitionException {
		final EglLexer l = new EglLexer("[%=");
		
		Token expected = new Token(TokenType.START_OUTPUT_TAG, "[%=", 1, 1);
		Token actual = l.nextToken();
		
		assertTrue(expected.equals(actual));
	}
	
	@Test
	public void testEndTag() throws RecognitionException {
		final EglLexer l = new EglLexer("%]");
		
		Token expected = new Token(TokenType.END_TAG, "%]", 1, 1);
		Token actual = l.nextToken();
		
		assertTrue(expected.equals(actual));
	}
	
	@Test
	public void testStartCommentTag() throws RecognitionException {
		final EglLexer l = new EglLexer("[*");
		
		Token expected = new Token(TokenType.START_COMMENT_TAG, "[*", 1, 1);
		Token actual = l.nextToken();
		
		assertTrue(expected.equals(actual));
	}
	
	@Test
	public void testEndCommentTag() throws RecognitionException {
		final EglLexer l = new EglLexer("*]");
		
		Token expected = new Token(TokenType.END_COMMENT_TAG, "*]", 1, 1);
		Token actual = l.nextToken();
		
		assertTrue(expected.equals(actual));
	}
	
	@Test
	public void testPlainText() throws RecognitionException {
		final String program = "ab[c%d]";
		final EglLexer l = new EglLexer(program);
		
		Token expected = new Token(TokenType.PLAIN_TEXT, program, 1, 1);
		Token actual = l.nextToken();
		
		assertTrue(expected.equals(actual));
	}
	
	@Test
	public void testNewLine() throws RecognitionException {
		final String program = NEWLINE;
		final EglLexer l = new EglLexer(program);
		
		Token expected = new Token(TokenType.NEW_LINE, program, 1, 1);
		Token actual = l.nextToken();
		
		assertTrue(expected.equals(actual));
	}

	@Test
	public void testEOF() throws RecognitionException {
		final String program = "";
		final EglLexer l = new EglLexer(program);
		
		Token expected = new Token(TokenType.EOF, program, 1, 1);
		Token actual = l.nextToken();
		
		assertTrue(expected.equals(actual));
	}
	
	
	@Test
	public void testMultipleTokens() throws RecognitionException {
		//                      0        1         2         3
		//                      12345678901234567890123456789012
		final String program = "plaintext[% eol %] moreplaintext";
		final EglLexer l = new EglLexer(program);
		
		List<Token> expectedTokens = new LinkedList<Token>();
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT, "plaintext",      1, 1));
		expectedTokens.add(new Token(TokenType.START_TAG,  "[%",             1, 10));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT, " eol ",          1, 12));
		expectedTokens.add(new Token(TokenType.END_TAG,    "%]",             1, 17));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT, " moreplaintext", 1, 19));
		expectedTokens.add(new Token(TokenType.EOF,        "",               1, 33));
		
		for (Token expected : expectedTokens) {
			final Token actual = l.nextToken();
			assertTrue(expected.equals(actual));
		}
	}
	
	
	@Test
	public void testMultipleLines() throws RecognitionException {
		//                      0        1         2         3
		//                      12345678901234567890123456789012
		final String program = "[% for(i in Sequence(1..10) { %]" + NEWLINE +
		                       "i is [%=i%]" + NEWLINE +
		                       "[% } %]";
		final EglLexer l = new EglLexer(program);
		
		List<Token> expectedTokens = new LinkedList<Token>();
		expectedTokens.add(new Token(TokenType.START_TAG,        "[%",                           1, 1));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       " for(i in Sequence(1..10) { ", 1, 3));
		expectedTokens.add(new Token(TokenType.END_TAG,          "%]",                           1, 31));
		expectedTokens.add(new Token(TokenType.NEW_LINE,         NEWLINE,                        1, 33));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       "i is ",                        2, 1));
		expectedTokens.add(new Token(TokenType.START_OUTPUT_TAG, "[%=",                          2, 6));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       "i",                            2, 9));
		expectedTokens.add(new Token(TokenType.END_TAG,          "%]",                           2, 10));
		expectedTokens.add(new Token(TokenType.NEW_LINE,         NEWLINE,                        2, 12));
		expectedTokens.add(new Token(TokenType.START_TAG,        "[%",                           3, 1));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       " } ",                          3, 3));
		expectedTokens.add(new Token(TokenType.END_TAG,          "%]",                           3, 6));
		expectedTokens.add(new Token(TokenType.EOF,              "",                             3, 8));
		
		for (Token expected : expectedTokens) {
			final Token actual = l.nextToken();
			assertTrue(expected.equals(actual));
		}
	}
	
	
	@Test
	public void testMultipleLinesReader() throws RecognitionException, IOException {
		//                      0        1         2         3
		//                      12345678901234567890123456789012
		final String program = "[% for(i in Sequence(1..10) { %]" + NEWLINE +
		                       "i is [%=i%]" + NEWLINE +
		                       "[% } %]";
		final EglLexer l = new EglLexer(new StringReader(program));
		
		List<Token> expectedTokens = new LinkedList<Token>();
		expectedTokens.add(new Token(TokenType.START_TAG,        "[%",                           1, 1));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       " for(i in Sequence(1..10) { ", 1, 3));
		expectedTokens.add(new Token(TokenType.END_TAG,          "%]",                           1, 31));
		expectedTokens.add(new Token(TokenType.NEW_LINE,         NEWLINE,                        1, 33));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       "i is ",                        2, 1));
		expectedTokens.add(new Token(TokenType.START_OUTPUT_TAG, "[%=",                          2, 6));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       "i",                            2, 9));
		expectedTokens.add(new Token(TokenType.END_TAG,          "%]",                           2, 10));
		expectedTokens.add(new Token(TokenType.NEW_LINE,         NEWLINE,                        2, 12));
		expectedTokens.add(new Token(TokenType.START_TAG,        "[%",                           3, 1));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       " } ",                          3, 3));
		expectedTokens.add(new Token(TokenType.END_TAG,          "%]",                           3, 6));
		expectedTokens.add(new Token(TokenType.EOF,              "",                             3, 8));
		
		for (Token expected : expectedTokens) {
			final Token actual = l.nextToken();
			assertTrue(expected.equals(actual));
		}
	}
	
	
	@Test
	public void testMultipleLinesInputStream() throws RecognitionException, IOException {
		final EglLexer l = new EglLexer(new FileInputStream(TEST_FILE));
		
		List<Token> expectedTokens = new LinkedList<Token>();
		expectedTokens.add(new Token(TokenType.START_TAG,        "[%",                           1, 1));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       " for(i in Sequence(1..10) { ", 1, 3));
		expectedTokens.add(new Token(TokenType.END_TAG,          "%]",                           1, 31));
		expectedTokens.add(new Token(TokenType.NEW_LINE,         NEWLINE,                        1, 33));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       "i is ",                        2, 1));
		expectedTokens.add(new Token(TokenType.START_OUTPUT_TAG, "[%=",                          2, 6));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       "i",                            2, 9));
		expectedTokens.add(new Token(TokenType.END_TAG,          "%]",                           2, 10));
		expectedTokens.add(new Token(TokenType.NEW_LINE,         NEWLINE,                        2, 12));
		expectedTokens.add(new Token(TokenType.START_TAG,        "[%",                           3, 1));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       " } ",                          3, 3));
		expectedTokens.add(new Token(TokenType.END_TAG,          "%]",                           3, 6));
		expectedTokens.add(new Token(TokenType.EOF,              "",                             3, 8));
		
		for (Token expected : expectedTokens) {
			final Token actual = l.nextToken();
			assertTrue(expected.equals(actual));
		}
	}
	
	
	
	@Test
	public void testMultiLineTaggedText() throws RecognitionException, IOException {
		//                               1         2         3         4
		//                      123456789012345678901234567890123456789012345678
		final String program = "[%for (i in Sequence{1..10})" + NEWLINE + 
                               "  var y : String;  %] [%var x : Integer := i+2%]";
		
		final EglLexer l = new EglLexer(program);
		
		List<Token> expectedTokens = new LinkedList<Token>();
		expectedTokens.add(new Token(TokenType.START_TAG,        "[%",                         1, 1));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       "for (i in Sequence{1..10})", 1, 3));
		expectedTokens.add(new Token(TokenType.NEW_LINE,         NEWLINE,                      1, 29));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       "  var y : String;  ",        2, 1));
		expectedTokens.add(new Token(TokenType.END_TAG,          "%]",                         2, 20));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       " ",                          2, 22));
		expectedTokens.add(new Token(TokenType.START_TAG,        "[%",                         2, 23));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       "var x : Integer := i+2",     2, 25));
		expectedTokens.add(new Token(TokenType.END_TAG,          "%]",                         2, 47));
		expectedTokens.add(new Token(TokenType.EOF,              "",                           2, 49));
		
		for (Token expected : expectedTokens) {
			final Token actual = l.nextToken();
			assertTrue(expected.equals(actual));
		}
	}
	
	@Test
	public void testStartTagInLiteralString() throws RecognitionException {
		//                               123456789
		final EglLexer l = new EglLexer("[%='[%'%]");
		
		List<Token> expectedTokens = new LinkedList<Token>();
		expectedTokens.add(new Token(TokenType.START_OUTPUT_TAG, "[%=",  1, 1));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       "'[%'", 1, 4));
		expectedTokens.add(new Token(TokenType.END_TAG,          "%]",   1, 8));
		
		for (Token expected : expectedTokens) {
			final Token actual = l.nextToken();
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testEndTagInLiteralString() throws RecognitionException {
		//                               1234 56789012345 6
		final EglLexer l = new EglLexer("[%=\"abc %] def\"%]");
		
		List<Token> expectedTokens = new LinkedList<Token>();
		expectedTokens.add(new Token(TokenType.START_OUTPUT_TAG, "[%=",            1, 1));
		expectedTokens.add(new Token(TokenType.PLAIN_TEXT,       "\"abc %] def\"", 1, 4));
		expectedTokens.add(new Token(TokenType.END_TAG,          "%]",             1, 16));
		
		for (Token expected : expectedTokens) {
			final Token actual = l.nextToken();
			assertEquals(expected, actual);
		}
	}
}