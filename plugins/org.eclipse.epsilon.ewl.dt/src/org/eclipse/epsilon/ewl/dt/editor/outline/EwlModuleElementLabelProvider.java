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
package org.eclipse.epsilon.ewl.dt.editor.outline;

import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleElementLabelProvider;
import org.eclipse.epsilon.ewl.EwlWizard;
import org.eclipse.epsilon.ewl.dt.EwlPlugin;
import org.eclipse.swt.graphics.Image;

public class EwlModuleElementLabelProvider extends EolModuleElementLabelProvider{

	@Override
	public Image getImage(Object element) {
		
		if (element instanceof EwlWizard){
			return EwlPlugin.getDefault().createImage("icons/wizard.png");
		}
		/*else if (element instanceof EvlConstraintContext) {
			return EwlPlugin.getDefault().createImage("icons/context.gif");
		} 
		else if (element instanceof EvlConstraint) {
			if (((EwlConstraint) element).isCritique()) {
				return EwlPlugin.getDefault().createImage("icons/critique.gif");
			}
			else {
				return EwlPlugin.getDefault().createImage("icons/error.gif");
			}
		} */
		else {
			return super.getImage(element);
		}
	}

}
