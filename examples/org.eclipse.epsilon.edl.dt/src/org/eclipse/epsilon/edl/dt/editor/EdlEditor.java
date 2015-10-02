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
package org.eclipse.epsilon.edl.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.edl.EdlModule;
import org.eclipse.epsilon.edl.dt.editor.outline.EdlModuleElementLabelProvider;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;

public class EdlEditor extends EolEditor{
		
	public EdlEditor() {
		//addTemplateContributor(new EclEditorStaticTemplateContributor());
	}
	
	@Override
	public List<String> getKeywords() {
		
		List<String> edlKeywords = new ArrayList<String>();
		
		edlKeywords.add("pre");
		edlKeywords.add("post");
		edlKeywords.add("process");

		edlKeywords.addAll(super.getKeywords());
		
		return edlKeywords;
	}
	
	@Override
	public ModuleElementLabelProvider createModuleElementLabelProvider() {
		return new EdlModuleElementLabelProvider();
	}
	
	@Override
	public IModule createModule(){
		return new EdlModule();
	}
	
}
