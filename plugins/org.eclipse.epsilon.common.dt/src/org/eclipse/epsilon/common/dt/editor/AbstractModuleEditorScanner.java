/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
******************************************************************************/

package org.eclipse.epsilon.common.dt.editor;

import java.util.List;
import java.util.ListIterator;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class AbstractModuleEditorScanner extends RuleBasedScanner {
	
	protected AbstractModuleEditor editor;
	protected List<String> keywords;
	protected List<String> builtinVariables;
	protected List<String> types;
	protected List<String> assertions;
	
	public AbstractModuleEditorScanner(AbstractModuleEditor editor) {
		
		this.editor = editor;
		this.keywords = editor.getKeywords();
		this.builtinVariables = editor.getBuiltinVariables();
		this.types = editor.getTypes();
		this.assertions = editor.getAssertions();
		
		//addSmartTyping();
		
		final Color backgroundColor = editor.getBackgroundColor();
		
		fDefaultReturnToken = new Token(new TextAttribute(null, backgroundColor,
				SWT.NORMAL));
		
		WordRule keywordsRule = new WordRule(new IWordDetector() {
			public boolean isWordStart(char c) {
				return Character.isJavaIdentifierStart(c);// || c == '.';
			}

			public boolean isWordPart(char c) {
				return Character.isJavaIdentifierPart(c);
			}
		}, new Token(new TextAttribute(null, backgroundColor, SWT.NORMAL)));

		ListIterator li = keywords.listIterator();
		while (li.hasNext()) {
			keywordsRule.addWord(li.next().toString(), new Token(
					new TextAttribute(AbstractModuleEditor.KEYWORD, backgroundColor,
							SWT.BOLD)));
		}

		WordRule builtinRule = new WordRule(new IWordDetector() {
			public boolean isWordStart(char c) {
				return Character.isJavaIdentifierStart(c);// || c == '.';
			}

			public boolean isWordPart(char c) {
				return Character.isJavaIdentifierPart(c);
			}
		}, new Token(new TextAttribute(null)));

		li = builtinVariables.listIterator();
		while (li.hasNext()) {
			keywordsRule.addWord(li.next().toString(), new Token(
					new TextAttribute(AbstractModuleEditor.BUILTIN, backgroundColor,
							SWT.ITALIC)));
		}
		
		WordRule typesRule = new WordRule(new IWordDetector() {
			public boolean isWordStart(char c) {
				return Character.isJavaIdentifierStart(c);// || c == '.';
			}

			public boolean isWordPart(char c) {
				return Character.isJavaIdentifierPart(c);
			}
		}, new Token(new TextAttribute(null)));

		li = types.listIterator();
		while (li.hasNext()) {
			keywordsRule.addWord(li.next().toString(), new Token(
					new TextAttribute(AbstractModuleEditor.TYPE, backgroundColor,
							SWT.BOLD)));
		}
		
		WordRule assertionsRule = new WordRule(new IWordDetector() {
			public boolean isWordStart(char c) {
				return Character.isJavaIdentifierStart(c);// || c == '.';
			}

			public boolean isWordPart(char c) {
				return Character.isJavaIdentifierPart(c);
			}
		}, new Token(new TextAttribute(null)));

		li = assertions.listIterator();
		while (li.hasNext()) {
			assertionsRule.addWord(li.next().toString(), new Token(
					new TextAttribute(AbstractModuleEditor.ASSERTION, backgroundColor,
							SWT.BOLD)));
		}
		
		setRules(new IRule[] {
				new EndOfLineRule("--", new Token(new TextAttribute(
						AbstractModuleEditor.COMMENT, backgroundColor, SWT.NORMAL))),
				new MultiLineRule("-*", "*-",new Token(new TextAttribute(
						AbstractModuleEditor.COMMENT, backgroundColor, SWT.NORMAL))),
				new EndOfLineRule("//", new Token(new TextAttribute(
						AbstractModuleEditor.COMMENT, backgroundColor, SWT.NORMAL))),
				new MultiLineRule("/*", "*/",new Token(new TextAttribute(
						AbstractModuleEditor.COMMENT, backgroundColor, SWT.NORMAL))),
				new EndOfLineRule("@", new Token(new TextAttribute(
						AbstractModuleEditor.ANNOTATION, backgroundColor, SWT.NORMAL))),
				new EndOfLineRule("$", new Token(new TextAttribute(
						AbstractModuleEditor.EXECUTABLEANNOTATION, backgroundColor, SWT.NORMAL))),
				new SingleLineRule("\"", "\"", new Token(new TextAttribute(
						AbstractModuleEditor.STRING, backgroundColor, SWT.NORMAL)), '\\'),
				new SingleLineRule("'", "'", new Token(new TextAttribute(
						AbstractModuleEditor.STRING, backgroundColor, SWT.NORMAL)), '\\'),
				new SingleLineRule("`", "`", new Token(new TextAttribute(
						AbstractModuleEditor.DEFAULT, backgroundColor, SWT.ITALIC)), '\\'),
				keywordsRule, builtinRule, typesRule});
	}
}

 