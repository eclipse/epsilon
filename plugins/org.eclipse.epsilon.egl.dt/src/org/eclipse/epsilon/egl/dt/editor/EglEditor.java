/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.dt.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.dt.editor.ASTLocation;
import org.eclipse.epsilon.common.dt.editor.ASTLocator;
import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditor;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.dt.editor.outline.EglModuleElementLabelProvider;
import org.eclipse.epsilon.egl.preprocessor.Trace;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;


public class EglEditor extends AbstractModuleEditor {
	
	public static final String ID = "org.eclipse.epsilon.egl.dt.editor.EglEditor";

	private final EolEditor eolEditor = new EolEditor();
	
	public EglEditor() {
		setBackgroundColor(new Color(Display.getCurrent(), 251, 242, 184));
		setDocumentProvider(new EglProvider());
	}
		
	@Override
	public void init(IEditorSite site, IEditorInput input) {
		super.init(site, input);
		
		// Syntax highlight according to partitioning
		setSourceViewerConfiguration(new EglConfiguration(super.getSourceViewerConfiguration()));
	}

	@Override
	public List<?> getKeywords() {
		return eolEditor.getKeywords();
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List getBuiltinVariables() {
		List<String> vars = eolEditor.getBuiltinVariables();
		
		vars.add("out");
		vars.add("TemplateFactory");
		
		vars.add("openTag");
		vars.add("openOutputTag");
		vars.add("closeTag");
		
		return vars;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getTypes() {
		List<Object> types = super.getTypes();
		
		types.add("Template");
		
		return types;
	}

	@Override
	public IModule createModule() {
		return new EglTemplateFactoryModuleAdapter(new EglTemplateFactory());
	}

	List<Template> templates = null;
	@Override
	public List<Template> getTemplates() {
		if (templates==null) {
			templates = new ArrayList<Template>();
			templates.add(new Template("[% %]","dynamic block","","[%${cursor}%]",false));
			templates.add(new Template("[%= %]","output block","","[%=${cursor}%]",false));
			templates.add(new Template("[* *]","multiline comment","","[*${cursor}*]",false));
			templates.add(new Template("for", "iterate over collection", "", "[%for (${iterator} in ${collection}) { %]\r\n\t${cursor}\r\n[%}%]",false));
			String storeTemplate = "var ${templateName} : Template;\r\n" + 
									"-- Pass parameters to the template\r\n" + 
									"${templateName} := TemplateFactory.load('${templateName}.egl');\r\n" + 
									"${templateName}.populate('${parameterName}', ${parameterValue});\r\n" + 
									"${templateName}.store('${targetFile}');";
			templates.add(new Template("store", "invoke other template and store results", "", storeTemplate, false));
			
			String processTemplate = "var ${templateName} : Template;\r\n" + 
									 "-- Pass parameters to the template\r\n" + 
									 "${templateName} := TemplateFactory.load('${templateName}.egl');\r\n" + 
									 "${templateName}.populate('${parameterName}', ${parameterValue});\r\n" + 
									 "var ${result} := ${templateName}.process();";
			
			templates.add(new Template("process", "invoke other template and return results", "org.eclipse.epsilon.egl.dt.editor.EOL", processTemplate, false));

		}
		return templates;
	}

	@Override
	public ModuleElementLabelProvider createModuleElementLabelProvider() {
		return new EglModuleElementLabelProvider();
	}

	@Override
	protected boolean supportsHyperlinks() {
		return true;
	}
	
	@Override
	protected boolean supportsDirtyTextParsing() {
		return true;
	}
	
	@Override
	public ASTLocator getASTLocator(IModule module) {
		return new EglASTLocator(((EglTemplateFactoryModuleAdapter)module).getTrace());
	}
	
	class EglASTLocator implements ASTLocator {
		
		protected Trace trace;
		
		public EglASTLocator(Trace trace) {
			this.trace = trace;
		}

		public ASTLocation getLocation(AST ast) {
			if (ast.getFile() != null) {
				if (!ast.getFile().getName().endsWith(".egl"))
					return new ASTLocation(ast.getLine(), ast.getColumn());
			}
			return new ASTLocation(trace.getEglLineNumberFor(ast.getLine()), trace.getEglColumnNumberFor(ast.getLine(), ast.getColumn()));
		}
	}
	
}
