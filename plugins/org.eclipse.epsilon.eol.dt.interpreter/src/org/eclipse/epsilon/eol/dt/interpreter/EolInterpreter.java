/*********************************************************************
* Copyright (c) 2020 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.dt.interpreter;

import java.util.List;
import java.util.concurrent.Callable;
import org.eclipse.acceleo.ui.interpreter.language.AbstractLanguageInterpreter;
import org.eclipse.acceleo.ui.interpreter.language.CompilationResult;
import org.eclipse.acceleo.ui.interpreter.language.EvaluationContext;
import org.eclipse.acceleo.ui.interpreter.language.EvaluationResult;
import org.eclipse.acceleo.ui.interpreter.language.InterpreterContext;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.common.dt.editor.AbstractModuleEditorSourceViewerConfiguration;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

/**
 * 
 * @since 2.3
 */
public class EolInterpreter extends AbstractLanguageInterpreter {
	
	public void configureSourceViewer(SourceViewer viewer) {
		SourceViewerConfiguration configuration = new AbstractModuleEditorSourceViewerConfiguration(new EolEditor());
		configuration.getPresentationReconciler(viewer).install(viewer);
	};
	
	@Override
	public Callable<CompilationResult> getCompilationTask(InterpreterContext context) {
		return () -> {
			EolModule module = new EolModule();
			try {
				module.parse(context.getExpression());
				if (!module.getParseProblems().isEmpty()) {
					return new CompilationResult(new Status(IStatus.ERROR, this.getClass(), 
							module.getParseProblems().get(0).toString()));
				}
				return new CompilationResult(IStatus.OK);
			}
			catch (Exception ex) {
				return new CompilationResult(new Status(IStatus.ERROR, this.getClass(), 
							module.getParseProblems().get(0).toString()));
			}
		};
	}
	
	@Override
	public Callable<EvaluationResult> getEvaluationTask(EvaluationContext context) {
		return () -> {
			EolModule module = new EolModule();
			module.parse(context.getExpression());
			FrameStack frameStack = module.getContext().getFrameStack();
			
			List<EObject> eObjects = context.getTargetEObjects();
			if (eObjects.isEmpty()) {
				frameStack.put("self", null);
			}
			else {
				module.getContext().getModelRepository().addModel(new InMemoryEmfModel(eObjects.get(0).eResource()));
				
				if (eObjects.size() == 1) {
					frameStack.put("self", eObjects.get(0));
				}
				else {
					frameStack.put("self", eObjects);
				}
			}
			
			for (org.eclipse.acceleo.ui.interpreter.view.Variable variable : context.getVariables()) {
				frameStack.put(variable.getName(), variable.getValue());
			}
			
			Object result = module.execute();
			return new EvaluationResult(result);
		};
	}

}
