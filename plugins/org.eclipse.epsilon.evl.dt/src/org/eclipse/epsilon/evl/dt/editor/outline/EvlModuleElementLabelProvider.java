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
package org.eclipse.epsilon.evl.dt.editor.outline;

import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleElementLabelProvider;
import org.eclipse.epsilon.erl.dom.Post;
import org.eclipse.epsilon.erl.dom.Pre;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.dt.EvlPlugin;
import org.eclipse.swt.graphics.Image;

public class EvlModuleElementLabelProvider extends EolModuleElementLabelProvider{

	@Override
	public Image getImage(Object element) {
		if (element instanceof ConstraintContext) {
			return EvlPlugin.getDefault().createImage("icons/context.gif");
		} 
		else if (element instanceof Constraint) {
			if (((Constraint) element).isCritique()) {
				return EvlPlugin.getDefault().createImage("icons/critique.gif");
			}
			else {
				return EvlPlugin.getDefault().createImage("icons/error.gif");
			}
		}
		else if (element instanceof Pre){
			return EvlPlugin.getDefault().createImage("icons/pre.gif");
		}
		else if (element instanceof Post){
			return EvlPlugin.getDefault().createImage("icons/post.gif");
		}
		else {
			return super.getImage(element);
		}
	}

}
