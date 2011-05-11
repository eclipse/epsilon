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
package org.eclipse.epsilon.eml.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.eml.EmlModule;
import org.eclipse.epsilon.eml.dt.editor.outline.EmlModuleElementLabelProvider;
import org.eclipse.epsilon.etl.dt.editor.EtlEditor;

public class EmlEditor extends EtlEditor {

	public EmlEditor() {
		super();
		addTemplateContributor(new EmlEditorStaticTemplateContributor());
	}
	
	@Override
	public List<String> getKeywords() {
		
		List<String> emlKeywords = new ArrayList<String>();
		
		emlKeywords.add("merge");
		emlKeywords.add("mid");
		emlKeywords.add("with");
		emlKeywords.add("into");
		
		emlKeywords.addAll(super.getKeywords());

		return emlKeywords;
	}
	
	@Override
	public List<String> getBuiltinVariables() {
		
		ArrayList<String> emlBuiltin = new ArrayList<String>();
		
		emlBuiltin.add("matchTrace");
		emlBuiltin.add("mergeTrace");
		emlBuiltin.add("transTrace");
		
		emlBuiltin.addAll(super.getBuiltinVariables());
		
		return emlBuiltin;
	}
	
	@Override
	public ModuleElementLabelProvider createModuleElementLabelProvider() {
		return new EmlModuleElementLabelProvider();
	}
	
	@Override
	public IModule createModule(){
		return new EmlModule();
	}
	
}
