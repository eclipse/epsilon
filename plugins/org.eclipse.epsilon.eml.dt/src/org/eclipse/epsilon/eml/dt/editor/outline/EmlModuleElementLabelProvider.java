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
package org.eclipse.epsilon.eml.dt.editor.outline;

import org.eclipse.epsilon.eml.dom.MergeRule;
import org.eclipse.epsilon.eml.dt.EmlPlugin;
import org.eclipse.epsilon.etl.dt.editor.outline.EtlModuleElementLabelProvider;
import org.eclipse.swt.graphics.Image;

public class EmlModuleElementLabelProvider extends EtlModuleElementLabelProvider {

	public EmlModuleElementLabelProvider() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Image getImage(Object element) {
		
		if (element instanceof MergeRule){
			return EmlPlugin.getDefault().createImage("icons/mergerule.gif");
		}
		
		return super.getImage(element);
	}

}
