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

import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleElementLabelProvider;
import org.eclipse.epsilon.epl.dom.Pattern;
import org.eclipse.epsilon.epl.dt.EplPlugin;
import org.eclipse.epsilon.erl.dom.Post;
import org.eclipse.epsilon.erl.dom.Pre;
import org.eclipse.swt.graphics.Image;

public class EplModuleElementLabelProvider extends EolModuleElementLabelProvider{
	
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
		else if (element instanceof Pre){
			return EplPlugin.getDefault().createImage("icons/pre.gif");
		}
		else if (element instanceof Post){
			return EplPlugin.getDefault().createImage("icons/post.gif");
		}
		else {
			return super.getImage(element);
		}
	}

}
