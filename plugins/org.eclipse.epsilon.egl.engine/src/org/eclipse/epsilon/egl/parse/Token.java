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

import org.antlr.runtime.CommonToken;

public class Token extends CommonToken {

	public enum TokenType {
		PROGRAM,
		PLAIN_TEXT,
		NEW_LINE,
		START_TAG,
		START_OUTPUT_TAG,
		END_TAG,
		START_COMMENT_TAG,
		END_COMMENT_TAG,
		EOF;
		
		public static TokenType typeOf(int ordinal) {
			for (TokenType type : values()) {
				if (type.ordinal() == ordinal)
					return type;
			}
			
			throw new IllegalArgumentException(ordinal+" is not the ordinal of any TokenType");
		}
	}
	
	private TokenType type;
	private String text;
	private int line;

	public Token(TokenType type, String text, int line, int col) {
		super(type.ordinal(), text);
		
		if (type==null)
			throw new NullPointerException("type cannot be null");
		
		if (text==null)
			throw new NullPointerException("text cannot be null");
		
		this.type = type;
		this.text = text;
		this.line = line;
		this.charPositionInLine = col;
	}

	public int getColumn() {
		return super.charPositionInLine;
	}

	@Override
	public int getLine() {
		return line;
	}


	@Override
	public String getText() {
		return text;
	}
	
	@Override
	public int getType() {
		return type.ordinal();
	}
	
	public TokenType getTokenType() {
		return type;
	}

	public void setColumn(int column) {
		this.charPositionInLine = column;
	}


	@Override
	public void setLine(int line) {
		this.line = line;
	}


	@Override
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public void setType(int type) {
		this.type = TokenType.typeOf(type);
	}

	
	public void setTokenType(TokenType type) {
		this.type = type;
	}

	
	@Override
	public boolean equals(Object o) {
		if (o==null) return false;
		if (!(o instanceof Token)) return false;
		
		Token that = (Token)o;
		
		return type.equals(that.type) &&
		       getText().equals(that.getText()) &&
		       getLine()   == that.getLine() &&
		       getColumn() == that.getColumn();
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		
		result = 37*result + type.hashCode();
		result = 37*result + getText().hashCode();
		result = 37*result + getLine();
		result = 37*result + getColumn();
		
		return result;
	}
	
	@Override
	public String toString() {
		return type + " " + getText() + ", line " + getLine() + " col " + getColumn(); 
	}
}
