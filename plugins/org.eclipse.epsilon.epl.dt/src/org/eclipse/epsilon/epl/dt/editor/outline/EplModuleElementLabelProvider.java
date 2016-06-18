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
package org.eclipse.epsilon.epl.dt.editor.outline;

import org.eclipse.epsilon.epl.dom.Pattern;
import org.eclipse.epsilon.epl.dt.EplPlugin;
import org.eclipse.epsilon.erl.dt.editor.outline.ErlModuleElementLabelProvider;
import org.eclipse.swt.graphics.Image;

public class EplModuleElementLabelProvider extends ErlModuleElementLabelProvider{
	
	Image patternImage = EplPlugin.getDefault().createImage("icons/pattern.gif");
	
	@Override
	public String getText(Object element) {
		if (element instanceof Pattern) {
			return ((Pattern) element).getName();
		}
		return super.getText(element);
	}
	
	@Override
	public Image getImage(Object element) {
	
		if (element instanceof Pattern) {
			return patternImage;
		}
		else {
			return super.getImage(element);
		}
	}

}
