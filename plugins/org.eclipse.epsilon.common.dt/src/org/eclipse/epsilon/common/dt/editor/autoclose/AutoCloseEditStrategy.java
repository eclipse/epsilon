/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.dt.editor.autoclose;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;

public class AutoCloseEditStrategy implements IAutoEditStrategy {

	protected List<AutoClosePair> autoClosePairs = new ArrayList<AutoClosePair>();
	protected AutoCloseAction lastAutoCloseAction = AutoCloseAction.NoAutoCloseAction;
	
	public AutoCloseEditStrategy() {
		autoClosePairs.add(new AutoClosePair('"', '"'));
		autoClosePairs.add(new AutoClosePair('\'', '\''));
		autoClosePairs.add(new AutoClosePair('(', ')'));
		autoClosePairs.add(new AutoClosePair('{', '}'));
		autoClosePairs.add(new AutoClosePair('[', ']'));
	}
	
	public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
		
		AutoCloseCandidate autoCloseCandidate = new AutoCloseCandidate(document, command);
		
		AutoCloseAction autoCloseAction = AutoCloseAction.NoAutoCloseAction;
		if (autoCloseCandidate.isBackspace() 
				&& lastAutoCloseAction != AutoCloseAction.NoAutoCloseAction
				&& lastAutoCloseAction.getOffset() == command.offset) {
			
			command.text = "";
			command.length = 2;
			command.shiftsCaret = false;
		}
		else if (autoCloseCandidate.isSingleChar() && Character.isWhitespace(autoCloseCandidate.getNextChar()) /*!Character.isJavaIdentifierPart(autoCloseCandidate.getNextChar())*/) {
		
			char ch = autoCloseCandidate.getChar();
			
			for (AutoClosePair pair : autoClosePairs) {
				if (pair.getLeft() == ch || pair.getRight() == ch) {
					if (pair.getRight() == ch && lastAutoCloseAction.matches(pair, command.offset)) {
						autoCloseCandidate.ignore();
					}
					else if (pair.getLeft() == ch){
						if (pair.isDifferent() || autoCloseCandidate.evenInCurrentLine(ch)) {
							autoCloseAction = autoCloseCandidate.close(pair);
						}
					}
					break;
				}
			}
		}
		this.lastAutoCloseAction = autoCloseAction;
	}
}
