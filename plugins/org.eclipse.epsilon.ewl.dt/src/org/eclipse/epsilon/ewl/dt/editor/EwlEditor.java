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
package org.eclipse.epsilon.ewl.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.epsilon.ewl.EwlModule;
import org.eclipse.epsilon.ewl.dt.editor.outline.EwlModuleElementLabelProvider;
import org.eclipse.jface.text.templates.Template;

public class EwlEditor extends EolEditor{
		
	@Override
	public List<String> getKeywords() {
		
		List<String> keywords = new ArrayList<String>();
		
		keywords.add("wizard");
		keywords.add("guard");
		keywords.add("do");
		keywords.add("title");

		keywords.addAll(super.getKeywords());
		
		return keywords;
	}
	
	List<Template> templates = null;
	public List<Template> getTemplates() {
		if (templates == null) {
			templates = super.getTemplates();
			templates.add(new Template("wizard", "wizard", "", "wizard ${name} {\r\n\r\n\tguard : self.isKindOf(${type})\r\n\r\n\ttitle : '${title}'\r\n\r\n\tdo {\r\n\t\t${cursor}\r\n\t}\r\n}",false));
		}
		return templates;
	}
	
	@Override
	public ModuleElementLabelProvider createModuleElementLabelProvider() {
		return new EwlModuleElementLabelProvider();
	}
	
	@Override
	public IModule createModule(){
		return new EwlModule();
	}
}
