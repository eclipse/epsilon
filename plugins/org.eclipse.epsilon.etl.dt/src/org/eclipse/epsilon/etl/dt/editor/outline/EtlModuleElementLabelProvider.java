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
package org.eclipse.epsilon.etl.dt.editor.outline;

import org.eclipse.epsilon.eol.EolLabeledBlock;
import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleElementLabelProvider;
import org.eclipse.epsilon.etl.TransformRule;
import org.eclipse.epsilon.etl.dt.EtlPlugin;
import org.eclipse.swt.graphics.Image;

public class EtlModuleElementLabelProvider extends EolModuleElementLabelProvider{

	@Override
	public Image getImage(Object element) {
		if (element instanceof EolLabeledBlock){
			return EtlPlugin.getDefault().createImage("icons/" + ((EolLabeledBlock) element).getLabel() +".gif");
		}
		else if (element instanceof TransformRule) {
			return EtlPlugin.getDefault().createImage("icons/transformrule.gif");
		} else {
			return super.getImage(element);
		}
	}

}
