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
package org.eclipse.epsilon.common.dt.editor.contentassist;

import java.util.List;

import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditor;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateCompletionProcessor;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.swt.graphics.Image;

public class AbstractModuleEditorCompletionProcessor extends TemplateCompletionProcessor {
	
	IRegion region = null;
	ITextViewer viewer = null;
	AbstractModuleEditor editor = null;
	
	public AbstractModuleEditorCompletionProcessor(AbstractModuleEditor editor) {
		this.editor = editor;
	}
	
	@Override
	protected TemplateContextType getContextType(ITextViewer viewer,
			IRegion region) {
		this.region = region;
		this.viewer = viewer;
		return AbstractModuleEditorContentType.INSTANCE;
	}
	
	protected int getIndent() {
		int indent = 0;
		try {
			int lineNumber = viewer.getDocument().getLineOfOffset(
					region.getOffset());
			
			IRegion lineInfo = viewer.getDocument().getLineInformation(lineNumber);
			
			String line = viewer.getDocument().get(lineInfo.getOffset(), region.getOffset() - lineInfo.getOffset());
			
			for (char c : line.toCharArray()) {
				if (c == '\t') {
					indent ++;
				}
				else {
					break;
				}
			}
		}
		catch (Exception ex) {
			// log exception
		}
		return indent;
	}
	
	Image templateImage = EpsilonCommonsPlugin.createImage("icons/template.gif");
	@Override
	protected Image getImage(Template template) {
		return templateImage;
	}

	@Override
	protected Template[] getTemplates(String contextTypeId) {
		
		//System.err.println(contextTypeId);
		
		//Template t = new Template("for", "iterate over collection", "", "for (${iterator} in ${collection}) { \r\n\t${cursor}\r\n}",true);
		//Template t2 = new Template("while", "while loop with condition", "", "while (${condition}) {\r\n\t${cursor}\r\n}",false);
		//Template t3 = new Template("transform", "transform rule", "", "transform ${rulename} \r\n\ttransform s : ${sourcemodel}!${sourcetype}\r\n\tto t : ${targetmodel}!${targettype} {\r\n\t${cursor}\r\n}",false);
		//Template t4 = new Template("operation", "operation with return type", "", "operation ${context} ${name} () : ${returntype} {\r\n\t${cursor}\r\n}",false);
		
		//return new Template[]{indentTemplate(t), indentTemplate(t2), indentTemplate(t3), indentTemplate(t4)};
	
		List<Template> templates = editor.getTemplates();
		Template[] indented = new Template[templates.size()];
		
		int loopCount = 0;
		for (Template template : templates) {
			indented[loopCount] = indentTemplate(template);
			loopCount++;
		}
		return indented;
	}
	
	protected Template indentTemplate(Template original) {
		return new Template(original.getName(), original.getDescription(), original.getContextTypeId(), addIndent(original.getPattern(),getIndent()), original.isAutoInsertable());
	}
	
	protected String addIndent(String text, int indent) {
		
		String tabs = "";
		for (int i=0;i<indent;i++) {
			tabs = tabs + "\t";
		}
		
		int loopCount = 0;
		String indented = "";
		String[] parts = text.split("\r\n");
		for (String line : parts) {
			if (loopCount == 0) {
				indented = line;
			}
			else {
				indented = indented + tabs + line;
			}
			if (loopCount < parts.length - 1) {
				indented = indented + "\r\n";
			}
			loopCount ++;
		}
		
		return indented;
	}
	
}
