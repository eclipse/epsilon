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
package org.eclipse.epsilon.ecl.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentProvider;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.dt.editor.outline.EclModuleContentProvider;
import org.eclipse.epsilon.ecl.dt.editor.outline.EclModuleElementLabelProvider;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;

public class EclEditor extends EolEditor{
		
	public EclEditor() {
		addTemplateContributor(new EclEditorStaticTemplateContributor());
	}
	
	@Override
	public List<String> getKeywords() {
		
		List<String> eclKeywords = new ArrayList<String>();
		
		eclKeywords.add("match");
		eclKeywords.add("auto");
		eclKeywords.add("do");
		eclKeywords.add("compare");
		eclKeywords.add("guard");
		eclKeywords.add("pre");
		eclKeywords.add("post");
		eclKeywords.add("with");
		eclKeywords.add("extends");
		eclKeywords.add("rule");
		eclKeywords.add("abstract");

		eclKeywords.addAll(super.getKeywords());
		
		return eclKeywords;
	}
	
	@Override
	public List<String> getBuiltinVariables() {
		
		ArrayList<String> eclBuiltin = new ArrayList<String>();
		
		eclBuiltin.add("matchTrace");
		eclBuiltin.add("autoCompare");
		eclBuiltin.add("matchInfo");
		
		eclBuiltin.addAll(super.getBuiltinVariables());
		
		return eclBuiltin;
	}
	
	@Override
	public ModuleElementLabelProvider createModuleElementLabelProvider() {
		return new EclModuleElementLabelProvider();
	}
	
	@Override
	protected ModuleContentProvider createModuleContentProvider() {
		return new EclModuleContentProvider();
	}
	
	@Override
	public IModule createModule(){
		return new EclModule();
	}
	
}
