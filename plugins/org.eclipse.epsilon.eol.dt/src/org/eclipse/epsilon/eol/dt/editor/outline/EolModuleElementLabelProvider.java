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
import org.eclipse.epsilon.eol.EolImport;
import org.eclipse.epsilon.eol.EolMain;
import org.eclipse.epsilon.eol.EolModelDefinition;
import org.eclipse.epsilon.eol.EolModelGroupDefinition;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.dt.EolPlugin;
import org.eclipse.swt.graphics.Image;

public class EolModuleElementLabelProvider extends ModuleElementLabelProvider{

	@Override
	public Image getImage(Object element) {
		if (element instanceof EolOperation){
			return EolPlugin.getDefault().createImage("icons/operation.gif");
		}
		else if (element instanceof EolMain){
			return EolPlugin.getDefault().createImage("icons/program.gif");
		}
		else if (element instanceof EolImport){
			return EolPlugin.getDefault().createImage("icons/import.gif");
		}
		else if (element instanceof EolModelDefinition){
			return EolPlugin.getDefault().createImage("icons/import.gif");
		}
		else if (element instanceof EolModelGroupDefinition){
			return EolPlugin.getDefault().createImage("icons/import.gif");
		}
		return null;
	}

}
