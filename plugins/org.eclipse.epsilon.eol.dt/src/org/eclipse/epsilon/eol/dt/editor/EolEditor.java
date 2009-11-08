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
package org.eclipse.epsilon.eol.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditor;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentOutlinePage;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.dt.editor.outline.EolModuleElementLabelProvider;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class EolEditor extends AbstractModuleEditor {
	
	public EolEditor(){
        setRulerContextMenuId("editor.rulerMenu");
	}
	
	@Override
	public List<String> getKeywords() {
		ArrayList<String> keywords = new ArrayList<String>();

		keywords.add("import");
		//keywords.add("input");
		//keywords.add("output");
		keywords.add("if");
		keywords.add("operation");
		keywords.add("function");
		keywords.add("new");
		keywords.add("else");
		keywords.add("for");
		keywords.add("var");
		keywords.add("return");
		keywords.add("async");
		keywords.add("break");
		keywords.add("breakAll");
		keywords.add("and");
		keywords.add("or");
		keywords.add("not");
		keywords.add("xor");
		keywords.add("implies");
		keywords.add("in");
		keywords.add("continue");
		keywords.add("while");
		keywords.add("throw");
		keywords.add("delete");
		keywords.add("transaction");
		keywords.add("abort");
		keywords.add("model");
		keywords.add("group");
		keywords.add("as");
		
		return keywords;
	}

	@Override
	public List<String> getBuiltinVariables() {
		ArrayList<String> builtIn = new ArrayList<String>();
		builtIn.add("hasMore");
		builtIn.add("loopCount");
		builtIn.add("self");
		builtIn.add("true");
		builtIn.add("false");
		builtIn.add("null");

		return builtIn;
	}

	@Override
	public IContentOutlinePage createOutlinePage() {
		ModuleContentOutlinePage outline = 
			new ModuleContentOutlinePage(
					this.getDocumentProvider(), 
					this, 
					new EolModule(), 
					new EolModuleElementLabelProvider());
		return outline;
	}

	@Override
	public IModule getModule() {
		return new EolModule();
	}

	private List<Template> templates;
	public List<Template> getTemplates() {
		if (templates == null) {
			templates = new ArrayList<Template>();
			templates.add(new Template("function", "function with return type", "", "function ${context} ${name} () : ${returntype} {\r\n\t${cursor}\r\n}",false));
			templates.add(new Template("operation", "operation with return type", "", "operation ${context} ${name} () : ${returntype} {\r\n\t${cursor}\r\n}",false));
			templates.add(new Template("for", "iterate over collection", "", "for (${iterator} in ${collection}) { \r\n\t${cursor}\r\n}",true));
			templates.add(new Template("forp", "iterate over collection and print something", "", "for (${iterator} in ${collection}) { \r\n\t(${cursor}).println();\r\n}",true));
			templates.add(new Template("while", "while loop with condition", "", "while (${condition}) {\r\n\t${cursor}\r\n}",false));
			templates.add(new Template("if", "if branch", "", "if (${condition}) {\r\n\t${cursor}\r\n}",false));
			templates.add(new Template("if else", "if branch with else part", "", "if (${condition}) {\r\n\t${cursor}\r\n}\r\nelse {\r\n\t${cursor}\r\n}",false));
			templates.add(new Template("assert", "assertion", "", "assert(${condition}, ${message});",false));
			templates.add(new Template("assertError", "assertion of error", "", "assertError(${expression}, ${message});",false));
			templates.add(new Template("import", "import", "", "import '${filename}';",false));
			templates.add(new Template("var", "variable declaration", "", "var ${name} : ${type} := ${initial_value};",false));
			
			templates.add(new Template("select", "select items from a collection", "", "select(${iterator}|${condition})",false));
			templates.add(new Template("forAll", "verify that condition holds for all items in a collection", "", "forAll(${iterator}|${condition})",false));
			templates.add(new Template("println", "print to the output stream", "", "println()",false));
			
		}
		return templates;
	}


}
