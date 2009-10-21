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

public class AbstractModuleEditorScanner extends RuleBasedScanner {
	
	protected AbstractModuleEditor editor;
	protected List keywords;
	protected List builtinVariables;
	protected List types;
	protected List assertions;
	
	public AbstractModuleEditorScanner(AbstractModuleEditor editor) {
		
		this.editor = editor;
		this.keywords = editor.getKeywords();
		this.builtinVariables = editor.getBuiltinVariables();
		this.types = editor.getTypes();
		this.assertions = editor.getAssertions();
		
		//addSmartTyping();
		
		fDefaultReturnToken = new Token(new TextAttribute(null, editor.getBackgroundColor(),
				SWT.NORMAL));
		
		WordRule keywordsRule = new WordRule(new IWordDetector() {
			public boolean isWordStart(char c) {
				return Character.isJavaIdentifierStart(c);// || c == '.';
			}

			public boolean isWordPart(char c) {
				return Character.isJavaIdentifierPart(c);
			}
		}, new Token(new TextAttribute(null, editor.getBackgroundColor(), SWT.NORMAL)));

		ListIterator li = keywords.listIterator();
		while (li.hasNext()) {
			keywordsRule.addWord(li.next().toString(), new Token(
					new TextAttribute(AbstractModuleEditor.KEYWORD, editor.getBackgroundColor(),
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
					new TextAttribute(AbstractModuleEditor.BUILTIN, editor.getBackgroundColor(),
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
					new TextAttribute(AbstractModuleEditor.TYPE, editor.getBackgroundColor(),
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
					new TextAttribute(AbstractModuleEditor.ASSERTION, editor.getBackgroundColor(),
							SWT.BOLD)));
		}
		
		setRules(new IRule[] {
				new EndOfLineRule("--", new Token(new TextAttribute(
						AbstractModuleEditor.COMMENT, editor.getBackgroundColor(), SWT.NORMAL))),
				new MultiLineRule("-*", "*-",new Token(new TextAttribute(
						AbstractModuleEditor.COMMENT, editor.getBackgroundColor(), SWT.NORMAL))),
				new EndOfLineRule("//", new Token(new TextAttribute(
						AbstractModuleEditor.COMMENT, editor.getBackgroundColor(), SWT.NORMAL))),
				new MultiLineRule("/*", "*/",new Token(new TextAttribute(
						AbstractModuleEditor.COMMENT, editor.getBackgroundColor(), SWT.NORMAL))),
				new EndOfLineRule("@", new Token(new TextAttribute(
						AbstractModuleEditor.ANNOTATION, editor.getBackgroundColor(), SWT.NORMAL))),
				new EndOfLineRule("$", new Token(new TextAttribute(
						AbstractModuleEditor.EXECUTABLEANNOTATION, editor.getBackgroundColor(), SWT.NORMAL))),
				new SingleLineRule("\"", "\"", new Token(new TextAttribute(
						AbstractModuleEditor.STRING, editor.getBackgroundColor(), SWT.NORMAL)), '\\'),
				new SingleLineRule("'", "'", new Token(new TextAttribute(
						AbstractModuleEditor.STRING, editor.getBackgroundColor(), SWT.NORMAL)), '\\'),
				new SingleLineRule("`", "`", new Token(new TextAttribute(
						AbstractModuleEditor.DEFAULT, editor.getBackgroundColor(), SWT.ITALIC)), '\\'),
				new WhitespaceRule(new IWhitespaceDetector() {
					public boolean isWhitespace(char c) {
						return Character.isWhitespace(c);
					}
				}), keywordsRule, builtinRule, typesRule});
	}
}

 