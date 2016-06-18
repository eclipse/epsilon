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

import org.eclipse.epsilon.erl.dt.editor.outline.ErlModuleElementLabelProvider;
import org.eclipse.epsilon.etl.dom.TransformationRule;
import org.eclipse.epsilon.etl.dt.EtlPlugin;
import org.eclipse.swt.graphics.Image;

public class EtlModuleElementLabelProvider extends ErlModuleElementLabelProvider{

	@Override
	public Image getImage(Object element) {
		if (element instanceof TransformationRule) {
			return EtlPlugin.getDefault().createImage("icons/transformrule.gif");
		} 
		else {
			return super.getImage(element);
		}
	}

}
