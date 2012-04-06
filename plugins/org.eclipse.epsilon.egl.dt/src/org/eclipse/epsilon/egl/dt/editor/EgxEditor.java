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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;

public class EgxEditor extends EolEditor {
	
	public EgxEditor() {
		this.addTemplateContributor(new EgxEditorStaticTemplateContributor());
	}
	
	@Override
	public List<String> getKeywords() {
		
		List<String> keywords = new ArrayList<String>();
		
		keywords.add("transform");
		keywords.add("rule");
		keywords.add("guard");
		keywords.add("pre");
		keywords.add("post");
		keywords.add("target");
		keywords.add("extends");
		keywords.add("parameters");
		keywords.add("template");
		keywords.add("overwrite");
		keywords.add("protectRegions");

		keywords.addAll(super.getKeywords());
		
		return keywords;
	}
	
	/*
	@Override
	public List<String> getBuiltinVariables() {
		
		ArrayList<String> builtIn = new ArrayList<String>();
		
		builtIn.add("transTrace");
		
		builtIn.addAll(super.getBuiltinVariables());
		
		return builtIn;
	}*/

	@Override
	public ModuleElementLabelProvider createModuleElementLabelProvider() {
		return new EgxModuleElementLabelProvider();
	}
	
	@Override
	public IModule createModule(){
		return new EgxModule();
	}
}
