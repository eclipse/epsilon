/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.epsilon.flock.FlockModule;
import org.eclipse.epsilon.flock.dt.editor.outline.FlockModuleElementLabelProvider;
import org.eclipse.jface.text.templates.Template;

public class FlockEditor extends EolEditor {
		
	@Override
	public List<String> getKeywords() {
		final List<String> keywords = new ArrayList<String>(super.getKeywords());

		keywords.add("delete");
		keywords.add("retype");
		keywords.add("to");
		keywords.add("migrate");
		keywords.add("when");
		keywords.add("ignoring");
		
		return keywords;
	}
	
	@Override
	public List<String> getBuiltinVariables() {
		final List<String> builtIn = new ArrayList<String>(super.getBuiltinVariables());
		
		builtIn.add("original");
		builtIn.add("migrated");
		
		
		return builtIn;
	}
	
	@Override
	public IModule getModule(){
		return new FlockModule();
	}
	
	@Override
	public ModuleElementLabelProvider createModuleElementLabelProvider() {
		return new FlockModuleElementLabelProvider();
	}
	
	private List<Template> templates = null;
	
	public List<Template> getTemplates() {
		if (templates == null) {
			templates = super.getTemplates();
			templates.add(new Template("migrate", "migration strategy", "", "migrate ${strategyname} ${originaltype} {\r\n\t${cursor}\r\n}", false));
		}
		return templates;
	}
}
