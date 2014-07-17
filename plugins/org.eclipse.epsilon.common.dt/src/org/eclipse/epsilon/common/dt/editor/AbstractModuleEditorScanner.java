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

import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

public class AbstractModuleEditorScanner extends RuleBasedScanner {
	
	protected Color commentColor;
	protected Color markerColor;
	protected Color annotationColor;
	protected Color stringColor;
	protected Color defaultColor;
	protected Color keywordColor;
	protected Color builtinColor;
	protected Color assertionColor;
	protected Color typeColor;
	
	protected AbstractModuleEditor editor;
	protected List<String> keywords;
	protected List<String> builtinVariables;
	protected List<String> types;
	protected List<String> assertions;
	
	public void initialiseColours() {
		
		if (EclipseUtil.isDarkThemeEnabled()) {
			commentColor = new Color(Display.getCurrent(), new RGB(190, 218, 0));
			keywordColor = new Color(Display.getCurrent(), new RGB(243, 191, 0));
			defaultColor = new Color(Display.getCurrent(), new RGB(255, 255, 255));
			annotationColor = new Color(Display.getCurrent(), new RGB(182, 67, 63));
			stringColor = new Color(Display.getCurrent(), new RGB(115, 148, 255));
			builtinColor = new Color(Display.getCurrent(), new RGB(182, 252, 255));
			assertionColor = new Color(Display.getCurrent(), new RGB(243, 0, 70));
			typeColor = new Color(Display.getCurrent(), new RGB(118, 167, 37));
		}
		else {
			commentColor = new Color(Display.getCurrent(), new RGB(63, 127, 95));
			annotationColor = new Color(Display.getCurrent(), new RGB(184, 160, 0));
			stringColor = new Color(Display.getCurrent(), new RGB(42, 0, 255));
			defaultColor = new Color(Display.getCurrent(), new RGB(0, 0, 0));
			keywordColor = new Color(Display.getCurrent(), new RGB(127, 0, 85));
			builtinColor = new Color(Display.getCurrent(), new RGB(42, 0, 255));
			assertionColor = new Color(Display.getCurrent(), new RGB(255, 0, 0));
			typeColor = new Color(Display.getCurrent(), new RGB(0, 192, 0));			
		}
		
		markerColor = commentColor;
	}
	
	public AbstractModuleEditorScanner(final AbstractModuleEditor editor) {
		
		this.editor = editor;
		this.keywords = editor.getKeywords();
		this.builtinVariables = editor.getBuiltinVariables();
		this.types = editor.getTypes();
		this.assertions = editor.getAssertions();
		
		initialiseColours();
		
		final Color backgroundColor = null; //editor.getBackgroundColor();
		
		fDefaultReturnToken = new Token(new TextAttribute(null, backgroundColor, SWT.NORMAL));
		
		WordRule keywordsRule = new WordRule(new IWordDetector() {
			public boolean isWordStart(char c) {
				return Character.isJavaIdentifierStart(c);// || c == '.';
			}

			public boolean isWordPart(char c) {
				return Character.isJavaIdentifierPart(c);
			}
		}, new Token(new TextAttribute(null, backgroundColor, SWT.NORMAL)));

		ListIterator<String> li = keywords.listIterator();
		while (li.hasNext()) {
			keywordsRule.addWord(li.next(), new Token(new TextAttribute(keywordColor, null, SWT.BOLD)));
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
			keywordsRule.addWord(li.next(), new Token(new TextAttribute(builtinColor, null, SWT.ITALIC)));
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
			keywordsRule.addWord(li.next(), new Token(new TextAttribute(typeColor, null, SWT.BOLD)));
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
			assertionsRule.addWord(li.next(), new Token(new TextAttribute(assertionColor, null, SWT.BOLD)));
		}
		
		setRules(new IRule[] {
				new EndOfLineRule("--", new Token(new TextAttribute(commentColor, null, SWT.NORMAL))),
				new MultiLineRule("-*", "*-", new Token(new TextAttribute(commentColor, null, SWT.NORMAL))),
				new EndOfLineRule("//", new Token(new TextAttribute(commentColor, null, SWT.NORMAL))),
				new MultiLineRule("/*", "*/", new Token(new TextAttribute(commentColor, null, SWT.NORMAL))),
				new EndOfLineRule("@", new Token(new TextAttribute(annotationColor, null, SWT.NORMAL))),
				new EndOfLineRule("$", new Token(new TextAttribute(annotationColor, null, SWT.NORMAL))),
				new SingleLineRule("\"", "\"", new Token(new TextAttribute(stringColor, null, SWT.NORMAL)), '\\'),
				new SingleLineRule("'", "'", new Token(new TextAttribute(stringColor, null, SWT.NORMAL)), '\\'),
				new SingleLineRule("`", "`", new Token(new TextAttribute(defaultColor, null, SWT.ITALIC)), '\\'), 
				keywordsRule, builtinRule, typesRule});
	}
	
	public Color getCommentColor() {
		return commentColor;
	}
	
	public Color getMarkerColor() {
		return markerColor;
	}
}

 