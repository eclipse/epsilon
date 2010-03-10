/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.dt.editor.outline;

import org.eclipse.epsilon.egl.EglTemplateOperation;
import org.eclipse.epsilon.egl.dt.EglPlugin;
import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleElementLabelProvider;
import org.eclipse.swt.graphics.Image;

public class EglModuleElementLabelProvider extends EolModuleElementLabelProvider{

	@Override
	public Image getImage(Object element) {
		
		if (element instanceof EglTemplateOperation) {
			return EglPlugin.getDefault().createImage("icons/template.png");
		}
		
		return super.getImage(element);
	}

}
