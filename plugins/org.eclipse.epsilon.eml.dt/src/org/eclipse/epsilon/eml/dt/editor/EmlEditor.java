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

import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.eml.EmlModule;
import org.eclipse.epsilon.eml.dt.editor.outline.EmlModuleElementLabelProvider;
import org.eclipse.epsilon.etl.dt.editor.EtlEditor;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class EmlEditor extends EtlEditor {

	@Override
	public List getKeywords() {
		
		List emlKeywords = new ArrayList();
		
		emlKeywords.add("merge");
		emlKeywords.add("mid");
		emlKeywords.add("with");
		emlKeywords.add("into");
		
		emlKeywords.addAll(super.getKeywords());

		return emlKeywords;
	}
	
	@Override
	public List getBuiltinVariables() {
		
		ArrayList emlBuiltin = new ArrayList();
		
		emlBuiltin.add("matchTrace");
		emlBuiltin.add("mergeTrace");
		emlBuiltin.add("transTrace");
		
		emlBuiltin.addAll(super.getBuiltinVariables());
		
		return emlBuiltin;
	}

	@Override
	public IContentOutlinePage createOutlinePage() {
		ModuleContentOutlinePage outline = 
			new ModuleContentOutlinePage(
					this.getDocumentProvider(), 
					this, 
					new EmlModule(), 
					new EmlModuleElementLabelProvider());
		
		return outline;
	}
	
	@Override
	public IModule getModule(){
		return new EmlModule();
	}
	
	List<Template> templates = null;
	public List<Template> getTemplates() {
		if (templates == null) {
			templates = super.getTemplates();
			templates.add(new Template("merge", "merge rule", "", "rule ${rulename} \r\n\tmerge l : ${leftmodel}!${lefttype}\r\n\twith r : ${rightmodel}!${righttype}\r\n\tinto t : ${targetmodel}!${targettype} {\r\n\t${cursor}\r\n}",false));
			templates.add(new Template("common merge", "merge rule", "", "rule ${Type} \r\n\tmerge l : Left!${Type}\r\n\twith r : Right!${Type}\r\n\tinto t : Target!${Type} {\r\n\t${cursor}\r\n}",false));
		}
		return templates;
	}
}
