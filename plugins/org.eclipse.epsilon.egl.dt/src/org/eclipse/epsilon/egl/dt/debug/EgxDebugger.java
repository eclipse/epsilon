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
package org.eclipse.epsilon.egl.dt.debug;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.egl.dom.GenerationRule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;

public class EgxDebugger extends EolDebugger {
	
	@Override
	protected boolean isStructuralBlock(ModuleElement ast) {
		return super.isStructuralBlock(ast) || ast instanceof GenerationRule;
	}
	
}
