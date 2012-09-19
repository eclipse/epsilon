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
package org.eclipse.epsilon.etl.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.dt.editor.outline.EtlModuleElementLabelProvider;
import org.eclipse.jface.text.templates.Template;

public class EtlEditor extends EolEditor{
	
	public EtlEditor() {
		this.addTemplateContributor(new EtlEditorStaticTemplateContributor());
	}
	
	@Override
	public List<String> getKeywords() {
		
		List<String> keywords = new ArrayList<String>();
		
		keywords.add("transform");
		keywords.add("auto");
		keywords.add("guard");
		keywords.add("pre");
		keywords.add("post");
		keywords.add("to");
		keywords.add("extends");
		keywords.add("rule");
		keywords.add("abstract");

		keywords.addAll(super.getKeywords());
		
		return keywords;
	}
	
	@Override
	public List<String> getBuiltinVariables() {
		
		ArrayList<String> builtIn = new ArrayList<String>();
		
		builtIn.add("transTrace");
		
		builtIn.addAll(super.getBuiltinVariables());
		
		return builtIn;
	}

	@Override
	public ModuleElementLabelProvider createModuleElementLabelProvider() {
		return new EtlModuleElementLabelProvider();
	}
	
	@Override
	public IModule createModule(){
		return new EtlModule();
	}
	
}
