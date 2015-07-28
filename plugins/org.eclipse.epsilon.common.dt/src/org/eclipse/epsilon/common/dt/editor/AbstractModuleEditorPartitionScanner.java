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

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class AbstractModuleEditorPartitionScanner extends RuleBasedPartitionScanner {
	public final static String COMMENT = "__comment";
	public final static String STRING = "__string";
	
	public AbstractModuleEditorPartitionScanner() {
		final IToken comment = new Token(COMMENT);
		final IToken str = new Token(STRING);

		IPredicateRule[] rules = new IPredicateRule[] {
				new MultiLineRule("/*", "*/", comment, (char) 0, true),
				new MultiLineRule("-*", "*-", comment, (char) 0, true),
				new MultiLineRule("\"", "\"", str, (char) 0, true),
				new MultiLineRule("'", "'", str, (char) 0, true)
		};

		setPredicateRules(rules);
	}
}

 