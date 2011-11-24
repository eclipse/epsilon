/*******************************************************************************
 * Copyright (c) 2010 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.bibtex.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BibtexPropertyValueCompleter {
	
	private final String rawProperties;

	private String value;
	private int endOfPartialValue;
	
	public BibtexPropertyValueCompleter(String partialValue, int endOfPartialValue, String rawProperties) {
		this.value             = partialValue;
		this.endOfPartialValue = endOfPartialValue;

		this.rawProperties = rawProperties;
	}

	public String complete() {		
		ensureValueIsComplete();
		
		return value;
	}

	private void ensureValueIsComplete() {
		while (!valueIsComplete()) {
			extendValueUpToNextClosingBracket();
		}
	}

	private boolean valueIsComplete() {
		return characterAfterPartialValue().matches(",|\\n");
	}
	
	private String characterAfterPartialValue() {
		return rawProperties.substring(endOfPartialValue + 1, endOfPartialValue + 2);
	}

	private void extendValueUpToNextClosingBracket() {
		final Matcher m = getNotAClosingBracketPattern().matcher(rawProperties);
		
		m.find(endOfPartialValue + 1);
		
		value += "}" + m.group();
		endOfPartialValue = m.end();
	}

	private static Pattern getNotAClosingBracketPattern() {
		final String ANYTHING_BUT_A_BRACKET = "[^\\}]*";
		
		return Pattern.compile(ANYTHING_BUT_A_BRACKET);
	}
}
