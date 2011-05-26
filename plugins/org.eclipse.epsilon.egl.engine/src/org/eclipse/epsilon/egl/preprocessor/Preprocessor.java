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
package org.eclipse.epsilon.egl.preprocessor;

import static org.eclipse.epsilon.egl.util.FileUtil.NEWLINE;
import static org.eclipse.epsilon.egl.util.StringUtil.isWhitespace;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.parse.Token.TokenType;



public class Preprocessor {
	
	private StringBuffer eol = new StringBuffer();
	private final Map<Integer, Integer> colNumber = new TreeMap<Integer, Integer>();
	private PreprocessorTrace trace = new PreprocessorTrace();
	private AST child = null;
	
	
	private static String escape(String s){
		String escaped = s;
		
		escaped = escaped.replaceAll("\\\\","\\\\\\\\");
		escaped = escaped.replaceAll("\r","\\\\r");
		escaped = escaped.replaceAll("\n","\\\\n");
		escaped = escaped.replaceAll("\t","\\\\t");
		escaped = escaped.replaceAll("\b","\\\\b");
		escaped = escaped.replaceAll("\f","\\\\f");
		escaped = escaped.replace("'", "\\'");
		escaped = escaped.replace("\"", "\\\"");
		
		return escaped;
	}
	
	
	private int getOffset(int lineNumber) {
		if (colNumber.containsKey(lineNumber))
			return colNumber.get(lineNumber);
		
		return 0;
	}
	
	private void addToOffset(int lineNumber, int addend) {
		colNumber.put(lineNumber, getOffset(lineNumber) + addend);
	}

	private void updateOffset(int eglLineNumber, int correction, int textLength) {	
		// Update trace
		trace.incrementColumnCorrectionNumber(getOffset(eglLineNumber) + correction);
		
		// Store new column number as current position + text length + length of %]
		addToOffset(eglLineNumber, correction + textLength + 2);
	}

	private void appendNewLineToEol(int eglLineNumber) {
		appendNewLineToEol(eglLineNumber, eol.length() > 0);
	}
	
	private void appendNewLineToEol(int eglLineNumber, boolean appendNewLine) {
		if (appendNewLine) eol.append(NEWLINE);
		trace.setEglLineNumberForCurrentEolLineNumber(eglLineNumber);
	}

	private void appendToEolOnANewLine(String text, int eglLineNumber) {
		appendNewLineToEol(eglLineNumber);
		eol.append(text);
	}
	
	private boolean eolEndsWith(String suffix) {
		if (suffix.length() > eol.length()) return false;
		
		return eol.substring(eol.length() - suffix.length(), eol.length()).equals(suffix);
	}
	
	public String convertToEol(AST ast) {
		
		// Reset vars
		eol = new StringBuffer();
		colNumber.clear();
		trace.reset();
		
		child = ast.getFirstChild();
		
		while (child != null){
			switch (TokenType.typeOf(child.getType())) {
				case START_COMMENT_TAG:
					int commentLength = child.getText().length();
					
					AST current = child.getFirstChild();
					while (current != null) {
						commentLength += current.getText().length();
						current = current.getNextSibling();
					}
					
					addToOffset(child.getLine(), commentLength);
					
					// Gobble new lines after [* *] pairs
					gobbleNextIfNewLine();
					
					break;
					
				case NEW_LINE:
				case PLAIN_TEXT:
					addToOffset(child.getLine(), child.getText().length());
					
					boolean isWhitespacePrecedingTagged = TokenType.typeOf(child.getType()) != TokenType.NEW_LINE &&
					                                      isWhitespace(child.getText())  &&
					                                      child.getNextSibling() != null &&
					                                      (TokenType.typeOf(child.getNextSibling().getType()) == TokenType.START_TAG ||
					                                       TokenType.typeOf(child.getNextSibling().getType()) == TokenType.START_COMMENT_TAG);
					
					// Gobble whitespace before [% %] and [* *] pairs
					if (!isWhitespacePrecedingTagged) {
						appendToEolOnANewLine("out.print('" + escape(child.getText()) + "');", child.getLine());
					}
					
					break;
					
				case START_TAG:
				case START_OUTPUT_TAG:
					
					// Ensure that this section generates a new line of EOL
					if (!eolEndsWith(NEWLINE)) {
						appendNewLineToEol(child.getLine());
					}
					
					if (TokenType.typeOf(child.getType()) == TokenType.START_TAG) {
						// This is a dynamic section
						
						AST textAst = child.getFirstChild();
						boolean firstLine = true;
						
						while (textAst != null && TokenType.typeOf(textAst.getType()) != TokenType.END_TAG) {
							
							if (TokenType.typeOf(textAst.getType()) == TokenType.NEW_LINE) {
								
								if (TokenType.typeOf(textAst.getNextSibling().getType()) != TokenType.END_TAG) {
									appendNewLineToEol(textAst.getLine()+1, true);
									firstLine = false;
								}
							
							} else {
								final int correction = firstLine ? 2 : 0;
								updateOffset(textAst.getLine(), correction, textAst.getText().length());
								
								eol.append(textAst.getText());
							}
							
							textAst = textAst.getNextSibling();
						}
						
						// Gobble new lines after [% %] pairs
						gobbleNextIfNewLine();
					
					} else {
						// This is a dynamic output section 
						
						updateOffset(child.getLine(), 3, child.getFirstChild().getText().length());
						
						String printCall = "out.printdyn(";
						
						// Update trace to account for length of printCall
						trace.incrementColumnCorrectionNumber(-printCall.length());
						
//						appendToEolOnANewLine("out.print(" + child.getFirstChild().getText() + ");", child.getLine());
						eol.append(printCall + child.getFirstChild().getText() + ");");
					}
					
					break;
			}
			
			child = child.getNextSibling();
		}
		
		return eol.toString();
	}
	
	private void gobbleNextIfNewLine() {
		boolean nextNodeIsNewLine = child.getNextSibling() != null &&
		                            TokenType.typeOf(child.getNextSibling().getType()) == TokenType.NEW_LINE;
		
		if (nextNodeIsNewLine) {
			child = child.getNextSibling(); // skip the next node
		}
	}
	
	public PreprocessorTrace getTrace(){
		return trace;
	}	
}
