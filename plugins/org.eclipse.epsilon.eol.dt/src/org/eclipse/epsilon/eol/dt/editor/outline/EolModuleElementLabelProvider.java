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
package org.eclipse.epsilon.eol.dt.editor.outline;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.dt.EolPlugin;
import org.eclipse.swt.graphics.Image;

public class EolModuleElementLabelProvider extends ModuleElementLabelProvider{

	@Override
	public Image getImage(Object element) {
		if (element instanceof Operation){
			return EolPlugin.getDefault().createImage("icons/operation.gif");
		}
		else if (element instanceof StatementBlock){
			return EolPlugin.getDefault().createImage("icons/program.gif");
		}
		else if (element instanceof Import){
			return EolPlugin.getDefault().createImage("icons/import.gif");
		}
		else if (element instanceof ModelDeclaration){
			return EolPlugin.getDefault().createImage("icons/import.gif");
		}
		return null;
	}

}
