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
package org.eclipse.epsilon.egl.dt.editor;

import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.egl.dt.EglPlugin;
import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleElementLabelProvider;
import org.eclipse.epsilon.erl.dom.Post;
import org.eclipse.epsilon.erl.dom.Pre;
import org.eclipse.swt.graphics.Image;

public class EgxModuleElementLabelProvider extends EolModuleElementLabelProvider {

	@Override
	public Image getImage(Object element) {
		if (element instanceof GenerationRule) {
			return EglPlugin.getDefault().createImage("icons/generationrule.gif");
		} 
		else if (element instanceof Pre){
			return EglPlugin.getDefault().createImage("icons/pre.gif");
		}
		else if (element instanceof Post){
			return EglPlugin.getDefault().createImage("icons/post.gif");
		}
		else {
			return super.getImage(element);
		}
	}
	
	
}
