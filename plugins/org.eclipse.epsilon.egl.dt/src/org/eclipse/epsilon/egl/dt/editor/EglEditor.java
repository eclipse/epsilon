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

import java.util.List;

import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditor;
import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditorSourceViewerConfiguration;
import org.eclipse.epsilon.common.dt.editor.IModuleParseListener;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleContentProvider;
import org.eclipse.epsilon.common.dt.editor.outline.ModuleElementLabelProvider;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.Position;
import org.eclipse.epsilon.common.parse.Region;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.egl.dt.editor.outline.EglModuleContentProvider;
import org.eclipse.epsilon.egl.dt.editor.outline.EglModuleElementLabelProvider;
import org.eclipse.epsilon.egl.model.EglMarkerSection;
import org.eclipse.epsilon.egl.model.EglSection;
import org.eclipse.epsilon.eol.dom.StatementBlock;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.jface.viewers.IContentProvider;

public class EglEditor extends AbstractModuleEditor {
	
	public static final String ID = "org.eclipse.epsilon.egl.dt.editor.EglEditor";
	
	private final EolEditor eolEditor = new EolEditor();
	
	public EglEditor() {
		setDocumentProvider(new EglProvider());
		addTemplateContributor(new EglEditorStaticTemplateContributor());
		addModuleParsedListener(new IModuleParseListener() {
			
			@Override
			public void moduleParsed(AbstractModuleEditor editor, IModule module_) {
				EglTemplateFactoryModuleAdapter module = (EglTemplateFactoryModuleAdapter) module_;
				for (IModuleParseListener moduleParseListener : eolEditor.getModuleParsedListeners()) {
					moduleParseListener.moduleParsed(eolEditor, module);
				}
			}
		});
	}
	
	@Override
	public SourceViewerConfiguration createSourceViewerConfiguration() {
		return new EglConfiguration(new AbstractModuleEditorSourceViewerConfiguration(this), eolEditor);
	}

	@Override
	public List<String> getKeywords() {
		return eolEditor.getKeywords();
	}

	@Override
	public List<String> getBuiltinVariables() {
		List<String> vars = eolEditor.getBuiltinVariables();
		
		vars.add("out");
		vars.add("TemplateFactory");
		
		vars.add("openTag");
		vars.add("openOutputTag");
		vars.add("closeTag");
		
		return vars;
	}
	
	@Override
	public ModuleElement adaptToAST(Object o) {
		// For some reason the AST of EglMarkerSections appears to be 
		// starting in +1 characters off where it should be starting
		// TODO: Investigate with Louis why this happens and
		//       get rid of this ugly hack
		if (o instanceof EglMarkerSection) {
			EglMarkerSection ast = ((EglMarkerSection) o);
			StatementBlock copy = new StatementBlock();
			copy.setUri(ast.getUri());
			Region astRegion = ast.getRegion();
			Region copyRegion = new Region();
			copyRegion.setStart(new Position(astRegion.getStart().getLine(), astRegion.getStart().getColumn()-1));
			copyRegion.setEnd(astRegion.getEnd());
			copy.setRegion(copyRegion);
			return copy;
		}
		return super.adaptToAST(o);
	}
	
	@Override
	public List<String> getTypes() {
		List<String> types = super.getTypes();
		
		types.add("Template");
		
		return types;
	}

	@Override
	public IModule createModule() {
		return new EglTemplateFactoryModuleAdapter(new EglTemplateFactory());
	}
	
	@Override
	public ModuleElementLabelProvider createModuleElementLabelProvider() {
		return new EglModuleElementLabelProvider();
	}

	@Override
	protected ModuleContentProvider createModuleContentProvider() {
		return new EglModuleContentProvider();
	}
	
	@Override
	protected boolean supportsHyperlinks() {
		return true;
	}
	
	@Override
	protected boolean supportsDirtyTextParsing() {
		return true;
	}
	
}
