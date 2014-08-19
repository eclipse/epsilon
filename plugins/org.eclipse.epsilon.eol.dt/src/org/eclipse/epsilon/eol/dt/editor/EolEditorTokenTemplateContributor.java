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
import java.util.HashSet;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditor;
import org.eclipse.epsilon.common.dt.editor.IModuleParseListener;
import org.eclipse.epsilon.common.dt.editor.contentassist.IAbstractModuleEditorTemplateContributor;
import org.eclipse.epsilon.common.dt.editor.contentassist.TemplateWithImage;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dt.EolPlugin;
import org.eclipse.epsilon.eol.util.EolParserUtil;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.swt.graphics.Image;

public class EolEditorTokenTemplateContributor implements IAbstractModuleEditorTemplateContributor, IModuleParseListener {
	
	protected List<Template> templates = new ArrayList<Template>();
	protected HashSet<String> tokens = new HashSet<String>();
	Image tokenImage = EolPlugin.getDefault().createImage("icons/token.gif");
	
	public List<Template> getTemplates() {
		return templates;
	}

	public void moduleParsed(AbstractModuleEditor editor, IModule module) {
		templates.clear();
		tokens.clear();
		findTokens(module.getAst());
		for (String token : tokens) {
			templates.add(new TemplateWithImage(token, "token", "", token, false, tokenImage));
		}
	}
	
	protected void findTokens(AST root) {
		if (!EolParserUtil.isProperty(root) && root.getText().length() > 2 && Character.isJavaIdentifierStart(root.getText().charAt(0))) { 
			tokens.add(root.getText()); 
		}
		for (AST child : root.getChildren()) {
			findTokens(child);
		}
		
	}
	
}
