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
package org.eclipse.epsilon.eol.dt.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditor;
import org.eclipse.epsilon.common.dt.editor.IModuleParseListener;
import org.eclipse.epsilon.common.dt.editor.contentassist.IAbstractModuleEditorTemplateContributor;
import org.eclipse.epsilon.common.dt.editor.contentassist.TemplateWithImage;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.eol.EolFormalParameter;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.dt.EolPlugin;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.swt.graphics.Image;

public class EolEditorOperationTemplateContributor implements IAbstractModuleEditorTemplateContributor, IModuleParseListener {

	protected List<Template> templates = new ArrayList<Template>();
	
	public void moduleParsed(AbstractModuleEditor editor, IModule module) {
		templates.clear();
		if (module == null || !(module instanceof IEolLibraryModule)) return;
		for (EolOperation op : ((IEolLibraryModule) module).getOperations()) {
			templates.add(createTemplate(op));
		}
		
	}

	public List<Template> getTemplates() {
		return templates;
	}
	
	Image operationImage = EolPlugin.getDefault().createImage("icons/operation.gif");
	
	protected Template createTemplate(EolOperation op) {
		
		String call = op.getName();
		
		call += "(";
		
		Iterator it = op.getFormalParameters().iterator();
		while (it.hasNext()) {
			EolFormalParameter fp = (EolFormalParameter) it.next();
			call += "${" + fp.getName() + "}";
			if (it.hasNext()) call += ", ";
		}
		
		call += ")";
		
		return new TemplateWithImage(op.toString(), "operation", "", call, false, operationImage);
	}
	
}
