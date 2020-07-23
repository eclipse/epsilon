/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egl.dt.editor.outline;

import java.util.List;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.egl.IEglModule;
import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleContentProvider;

public class EglModuleContentProvider extends EolModuleContentProvider {
	
	@SuppressWarnings("restriction")
	@Override
	public List<ModuleElement> getVisibleChildren(ModuleElement moduleElement) {
		List<ModuleElement> visible = super.getVisibleChildren(moduleElement);
		
		if (moduleElement instanceof IEglModule) {
			IEglModule module = (IEglModule) moduleElement;
			visible.addAll(module.getImports());
			visible.addAll(module.getDeclaredModelDeclarations());
			visible.addAll(module.getCurrentTemplate().getModule().getMarkers());
			visible.addAll(module.getDeclaredOperations());
		}
		
		return visible;
	}
	
}
