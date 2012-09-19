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
package org.eclipse.epsilon.eunit.dt.ui;

import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.jface.action.Action;

abstract class OpenEOLEditorAction extends Action {
	public OpenEOLEditorAction() {
		super("Open in EOL editor");
	}

	protected void openInEOLEditor(AST astNode) {
		EclipseUtil.openEditorAt(astNode);
	}
}