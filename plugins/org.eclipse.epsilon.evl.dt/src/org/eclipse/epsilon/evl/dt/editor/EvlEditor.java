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
package org.eclipse.epsilon.evl.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.dt.editor.outline.EvlModuleElementLabelProvider;

public class EvlEditor extends EolEditor{
	
	public EvlEditor() {
		this.addTemplateContributor(new EvlEditorStaticTemplateContributor());
	}
	
	@Override
	public List<String> getKeywords() {
		
		List<String> keywords = new ArrayList<String>();
		
		keywords.add("context");
		keywords.add("constraint");
		keywords.add("guard");
		keywords.add("pre");
		keywords.add("post");
		keywords.add("assumes");
		keywords.add("critique");
		keywords.add("message");
		keywords.add("title");
		keywords.add("do");
		keywords.add("check");
		keywords.add("fix");
		keywords.add("typeOf");
		keywords.add("kindOf");
		keywords.add("high");
		keywords.add("medium");
		keywords.add("low");

		keywords.addAll(super.getKeywords());
		
		return keywords;
	}
	
	@Override
	public List<String> getBuiltinVariables() {
		
		ArrayList<String> builtIn = new ArrayList<String>();
		
		builtIn.add("constraintTrace");
		builtIn.add("extras");
		
		builtIn.addAll(super.getBuiltinVariables());
		
		return builtIn;
	}

	@Override
	public ModuleElementLabelProvider createModuleElementLabelProvider() {
		return new EvlModuleElementLabelProvider();
	}
	
	@Override
	public IModule createModule(){
		return new EvlModule();
	}
	
}
