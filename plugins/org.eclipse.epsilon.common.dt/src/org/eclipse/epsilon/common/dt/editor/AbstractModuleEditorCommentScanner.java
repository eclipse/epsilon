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

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;

public class AbstractModuleEditorCommentScanner extends RuleBasedScanner {

	public AbstractModuleEditorCommentScanner() {
		setDefaultReturnToken(new Token(new TextAttribute(AbstractModuleEditor.COMMENT)));
	}
}
 