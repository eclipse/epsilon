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

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.eclipse.epsilon.egl.parse.Token.TokenType;

public class EglLexer {

	private String program;
	private int col = 1;
	private int line = 1;
	
	private int index = 0;
	
	public EglLexer(InputStream is) throws IOException {
		final StringBuilder program = new StringBuilder();
		int next = is.read();
		
		while (next != -1) {
			program.append(((char)next));
			
			next = is.read();
		}
		
		this.program = program.toString();
	}
	
	public EglLexer(Reader reader) throws IOException {
		final StringBuilder program = new StringBuilder();
		int next = reader.read();
		
		while (next != -1) {
			program.append(((char)next));
			
			next = reader.read();
		}
		
		this.program = program.toString();
	}
	
	public EglLexer(String program) {
		if (program == null)
			throw new NullPointerException();
		
		this.program = program;
	}
	
	public Token nextToken() throws RecognitionException {
		if (program.length()==0) {
			return tokenise(TokenType.EOF, "");
		
		} else if (program.startsWith("\r\n")) {
			return tokenise(TokenType.NEW_LINE, "\r\n");
			
		} else if (program.startsWith("\n")) {
			return tokenise(TokenType.NEW_LINE, "\n");
			
		} else if (program.startsWith("[*")) {
			return tokenise(TokenType.START_COMMENT_TAG, "[*");
		
		} else if (program.startsWith("*]")) {
			return tokenise(TokenType.END_COMMENT_TAG, "*]");
		
		} else if (program.startsWith("[%=")) {
			return tokenise(TokenType.START_OUTPUT_TAG, "[%=");
		
		} else if (program.startsWith("[%")) {
			return tokenise(TokenType.START_TAG, "[%");
		
		} else if (program.startsWith("%]")) {
			return tokenise(TokenType.END_TAG, "%]");
		
		} else {
			
			boolean inStringLiteral = false;
			
			for (index = 0; index < program.length(); index++) {
				
				if (programMatches("'", "\"")) {
					inStringLiteral = !inStringLiteral;
				}
				
				// Check if any other token is next
				if (programMatches("\n", "\r\n")) {
					return tokenise(TokenType.PLAIN_TEXT, program.substring(0, index));
				
				} else if (!inStringLiteral && programMatches("[%", "%]", "[*", "*]")) {
					
					return tokenise(TokenType.PLAIN_TEXT, program.substring(0, index));
				}
			}
			
			return tokenise(TokenType.PLAIN_TEXT, program);
		}
	}
	
	private static String unescape(String text) {
		String result = new String(text);
		
		result = result.replaceAll("\\\\\\[%", "\\[%");
		result = result.replaceAll("\\\\%\\]", "%\\]");
		
		// Replace all double slashes with single slashes
		// Java's Pattern class makes this messy as it uses
		// backslash as an escape character. Coupling this
		// with Java already using backslash as an escape
		// sequence, results in 4 slashes equating to 1 slash!
		//result = result.replaceAll("\\\\\\\\", "\\\\");
		
		return result;
	}
	
	private void newLine() {
		line++;
		col = 1;
	}
	
	private Token tokenise(TokenType type, String text) {
		Token t;
		
		if (type == TokenType.PLAIN_TEXT)
			t = new Token(type, unescape(text), line, col);
		else
			t = new Token(type, text, line, col);
		
		program = program.substring(text.length());
		col += text.length();
		
		if (type==TokenType.NEW_LINE) newLine();
		
		return t;
	}
	
	private boolean programMatches(String... patterns) {
		for (String pattern : patterns) {
			if (programMatches(pattern)) return true;
		}
		
		return false;
	}
	
	private boolean programMatches(String pattern) {
		if (index < 0)
			throw new IllegalStateException("index is less than zero");
		
		if (index + pattern.length() > program.length())
			return false;
		
		return program.substring(index, index + pattern.length()).equals(pattern);
	} 
}
