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

import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.dt.editor.outline.EclModuleElementLabelProvider;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class EclEditor extends EolEditor{
		
	@Override
	public List getKeywords() {
		
		List eclKeywords = new ArrayList();
		
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
	public List getBuiltinVariables() {
		
		ArrayList eclBuiltin = new ArrayList();
		
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
	public IModule createModule(){
		return new EclModule();
	}
	
	List<Template> templates = null;
	public List<Template> getTemplates() {
		if (templates == null) {
			templates = super.getTemplates();
			templates.add(new Template("matches", "check if two objects match", "", "matches(${cursor})",false));
			templates.add(new Template("match", "match rule", "", "rule ${rulename} \r\n\tmatch l : ${leftmodel}!${lefttype}\r\n\twith r : ${rightmodel}!${righttype} {\r\n\tcompare : ${cursor}\r\n}",false));
			templates.add(new Template("common match", "match rule", "", "rule ${name} \r\n\tmatch l : Left!${name}\r\n\twith r : Right!${name} {\r\n\r\n\tcompare : ${cursor}\r\n}",false));
			templates.add(new Template("do", "do block of a match rule", "", "do {\r\n\t${cursor}\r\n}",false));
			templates.add(new Template("pre", "block executed before the rules", "", "pre ${name} {\r\n\t${cursor}\r\n}",false));
			templates.add(new Template("post", "block executed after the rules", "", "post ${name} {\r\n\t${cursor}\r\n}",false));
			
		}
		return templates;
	}
}
