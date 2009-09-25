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
package org.eclipse.epsilon.hutn.dt.editor;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class HutnScanner extends RuleBasedScanner {

	public static final Color COMMENT = new Color(Display.getCurrent(), new RGB(63, 127, 95));
	public static final Color STRING  = new Color(Display.getCurrent(), new RGB(42, 0, 255));
	public static final Color BOOLEAN = new Color(Display.getCurrent(), new RGB(0, 192, 0));
	public static final Color KEYWORD = new Color(Display.getCurrent(), new RGB(127, 0, 85));
	
	private final List<IRule> basicRules = new LinkedList<IRule>();
	
	public HutnScanner() {
		basicRules.add(new EndOfLineRule("//", new Token(new TextAttribute(COMMENT))));
		
		basicRules.add(new SingleLineRule("\"", "\"", new Token(new TextAttribute(STRING)), '\\'));
		
		final WordRule booleanRule = new WordRule(new HutnWordDetector());
		booleanRule.addWord("true",  new Token(new TextAttribute(BOOLEAN)));
		booleanRule.addWord("false", new Token(new TextAttribute(BOOLEAN)));
		basicRules.add(booleanRule);
		
		setRules(basicRules);
	}
	
	public void setKeywords(List<String> keywords) {
		final List<IRule> rules = new LinkedList<IRule>(basicRules);
		
		final WordRule keywordRule = new WordRule(new HutnWordDetector());		
		for (String keyword : keywords) {
			keywordRule.addWord(keyword, new Token(new TextAttribute(KEYWORD, null, SWT.BOLD)));
		}
		
		rules.add(keywordRule);
		setRules(rules);
	}
	
	private void setRules(List<IRule> rules) {
		setRules(rules.toArray(new IRule[]{}));
	}
	
	private static class HutnWordDetector implements IWordDetector {
		public boolean isWordPart(char c) {
			return Character.isLetterOrDigit(c);
		}

		public boolean isWordStart(char c) {
			return Character.isLetter(c);
		}		
	}
}
