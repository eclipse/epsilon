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
package org.eclipse.epsilon.migration.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.epsilon.migration.MigrationModule;
import org.eclipse.epsilon.migration.dt.editor.outline.MigrationModuleElementLabelProvider;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class MigrationEditor extends EolEditor{
		
	@Override
	public List getKeywords() {
		final List<String> keywords = new ArrayList<String>(super.getKeywords());
		
		keywords.add("migrate");
		
		return keywords;
	}
	
	@Override
	public List getBuiltinVariables() {
		final List<String> builtIn = new ArrayList<String>(super.getBuiltinVariables());
		
		builtIn.add("original");
		builtIn.add("target");
		
		
		return builtIn;
	}

	@Override
	public IContentOutlinePage createOutlinePage() {
		ModuleContentOutlinePage outline = 
			new ModuleContentOutlinePage(
					this.getDocumentProvider(), 
					this, 
					new MigrationModule(), 
					new MigrationModuleElementLabelProvider());
		
		return outline;
	}
	
	@Override
	public IModule getModule(){
		return new MigrationModule();
	}
	
	private List<Template> templates = null;
	
	public List<Template> getTemplates() {
		if (templates == null) {
			templates = super.getTemplates();
			templates.add(new Template("migrate", "migration strategy", "", "migrate ${strategyname} ${sourcetype} {\r\n\t${cursor}\r\n}", false));
		}
		return templates;
	}
}
