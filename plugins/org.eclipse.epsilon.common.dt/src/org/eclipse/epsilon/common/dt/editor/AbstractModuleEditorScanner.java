/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
******************************************************************************/

package org.eclipse.epsilon.common.dt.editor;

import java.util.List;
import java.util.ListIterator;

import org.eclipse.epsilon.common.dt.editor.highlighting.EpsilonHighlightingManager;
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

public class AbstractModuleEditorScanner extends RuleBasedScanner {
	
	protected AbstractModuleEditor editor;
	protected EpsilonHighlightingManager highlightingManager;
	protected List<String> keywords;
	protected List<String> builtinVariables;
	protected List<String> types;
	protected List<String> assertions;

	public AbstractModuleEditorScanner(final AbstractModuleEditor editor) {
		
		this.editor = editor;
		this.keywords = editor.getKeywords();
		this.builtinVariables = editor.getBuiltinVariables();
		this.types = editor.getTypes();
		this.assertions = editor.getAssertions();
		this.highlightingManager = editor.getHighlightingManager();
		
		final Color backgroundColor = null; //editor.getBackgroundColor();
		
		fDefaultReturnToken = new Token(
				new TextAttribute(highlightingManager.getDefaultColor(), backgroundColor, SWT.NORMAL));
		
		WordRule wordRules = new WordRule(new IWordDetector() {
			@Override
			public boolean isWordStart(char c) {
				return Character.isJavaIdentifierStart(c);// || c == '.';
			}

			@Override
			public boolean isWordPart(char c) {
				return Character.isJavaIdentifierPart(c);
			}
		}, new Token(new TextAttribute(highlightingManager.getDefaultColor(), backgroundColor, SWT.NORMAL)));

		Token keywordToken = new Token(new TextAttribute(highlightingManager.getKeywordColor(), null, SWT.BOLD));
		ListIterator<String> li = keywords.listIterator();
		while (li.hasNext()) {
			wordRules.addWord(li.next(), keywordToken);
		}

		Token builtinToken = new Token(new TextAttribute(highlightingManager.getBuiltinColor(), null, SWT.ITALIC));
		li = builtinVariables.listIterator();
		while (li.hasNext()) {
			wordRules.addWord(li.next(), builtinToken);
		}

		Token typeToken = new Token(new TextAttribute(highlightingManager.getTypeColor(), null, SWT.BOLD));
		li = types.listIterator();
		while (li.hasNext()) {
			wordRules.addWord(li.next(), typeToken);
		}

		Token assertionToken = new Token(new TextAttribute(highlightingManager.getAssertionColor(), null, SWT.BOLD));
		li = assertions.listIterator();
		while (li.hasNext()) {
			wordRules.addWord(li.next(), assertionToken);
		}
		
		setRules(new IRule[] {
				new EndOfLineRule("--", new Token(new TextAttribute(highlightingManager.getCommentColor(), null, SWT.NORMAL))),
				new MultiLineRule("-*", "*-", new Token(new TextAttribute(highlightingManager.getCommentColor(), null, SWT.NORMAL))),
				new EndOfLineRule("//", new Token(new TextAttribute(highlightingManager.getCommentColor(), null, SWT.NORMAL))),
				new MultiLineRule("/*", "*/", new Token(new TextAttribute(highlightingManager.getCommentColor(), null, SWT.NORMAL))),
				new EndOfLineRule("@", new Token(new TextAttribute(highlightingManager.getAnnotationColor(), null, SWT.NORMAL))),
				new EndOfLineRule("$", new Token(new TextAttribute(highlightingManager.getAnnotationColor(), null, SWT.NORMAL))),
				new SingleLineRule("\"", "\"", new Token(new TextAttribute(highlightingManager.getStringColor(), null, SWT.NORMAL)), '\\'),
				new SingleLineRule("'", "'", new Token(new TextAttribute(highlightingManager.getStringColor(), null, SWT.NORMAL)), '\\'),
				new SingleLineRule("`", "`", new Token(new TextAttribute(highlightingManager.getDefaultColor(), null, SWT.ITALIC)), '\\'), 
				wordRules});
	}
	
	public Color getCommentColor() {
		return highlightingManager.getCommentColor();
	}
}

 
