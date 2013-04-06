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
package org.eclipse.epsilon.eol.dt.debug;

import java.util.Arrays;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.ISourceLocator;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.ISourcePresentation;
import org.eclipse.debug.ui.sourcelookup.ISourceDisplay;
import org.eclipse.debug.ui.sourcelookup.ISourceLookupResult;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.dt.EolPlugin;
import org.eclipse.epsilon.eol.execute.context.Frame;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.AbstractTextEditor;

public class EolStackFrame extends EolDebugElement implements IStackFrame {

	private static final class EolSourceDisplay implements ISourceDisplay {
		@Override
		public void displaySource(Object element, IWorkbenchPage page, boolean forceSourceLookup) {
			if (element instanceof EolStackFrame) {
				ISourceLookupResult lookupResult = DebugUITools.lookupSource(element, new EolSourceLocator());
				DebugUITools.displaySource(lookupResult, page);
			}
		}
	}

	private static final class EolSourceLocator implements ISourceLocator, ISourcePresentation {
		@Override
		public Object getSourceElement(IStackFrame stackFrame) {
			if (stackFrame instanceof EolStackFrame) {
				final EolStackFrame eolSF = (EolStackFrame)stackFrame;
				IFile file = EclipseUtil.findIFile(eolSF.frame.getCurrentStatement());
				if (file == null) {
					file = EclipseUtil.findIFile(eolSF.frame.getEntryPoint());
				}
				return file;
			}
			return null;
		}

		@Override
		public IEditorInput getEditorInput(Object element) {
			if (element instanceof IFile) {
				return new FileEditorInput((IFile)element);
			}
			return null;
		}

		@Override
		public String getEditorId(IEditorInput input, Object element) {
			if (element instanceof IFile) {
				final IEditorDescriptor editor = IDE.getDefaultEditor((IFile)element);
				if (editor != null) {
					return editor.getId();
				}
			}
			return null;
		}
	}

	protected IThread thread;
	protected Frame frame;
	protected String name;
	
	public EolStackFrame(IThread thread, Frame frame, String name) {
		super(thread.getDebugTarget());
		this.thread = thread;
		this.frame = frame;
		this.name = name;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter.equals(ISourceDisplay.class)) {
			return new EolSourceDisplay();
		}
		return super.getAdapter(adapter);
	}

	public boolean canStepInto() {
		return thread.canStepInto();
	}

	public boolean canStepOver() {
		return thread.canStepOver();
	}

	public boolean canStepReturn() {
		return thread.canStepReturn();
	}

	public boolean isStepping() {
		return thread.isStepping();
	}

	public void stepInto() throws DebugException {
		thread.stepInto();
	}

	public void stepOver() throws DebugException {
		thread.stepOver();
	}

	public void stepReturn() throws DebugException {
		thread.stepReturn();
	}

	public boolean canResume() {
		return thread.canResume();
	}

	public boolean canSuspend() {
		return thread.canSuspend();
	}

	public boolean isSuspended() {
		return thread.isSuspended();
	}

	public void resume() throws DebugException {
		thread.resume();
	}

	public void suspend() throws DebugException {
		thread.suspend();
	}

	public boolean canTerminate() {
		return thread.canTerminate();
	}

	public boolean isTerminated() {
		return thread.isTerminated();
	}

	public void terminate() throws DebugException {
		thread.terminate();
	}

	public IThread getThread() {
		return thread;
	}

	public IVariable[] getVariables() throws DebugException {
		int i = 0;
		EolVariable[] eolVariables = new EolVariable[frame.getAll().size()];
		for (Variable v : frame.getAll().values()) {
			eolVariables[i] = new EolVariable(getDebugTarget(), v.getName(), v.getValue());
			i++;
		}
		Arrays.sort(eolVariables, new IVariableNameComparator());
		return eolVariables;
	}

	public boolean hasVariables() throws DebugException {
		return getVariables().length > 0;
	}

	public int getLineNumber() throws DebugException {
		if (frame.getCurrentStatement() != null) {
			return frame.getCurrentStatement().getLine();
		}
		return -1;
	}

	public int getCharStart() throws DebugException {
		int charStart = getCharStart(frame.getCurrentStatement());
		if (charStart < 0) {
			charStart = getCharStart(frame.getEntryPoint());
		}
		return charStart;
	}

	public int getCharEnd() throws DebugException {
		int charEnd = getCharEnd(frame.getCurrentStatement());
		if (charEnd < 0) {
			return getCharEnd(frame.getEntryPoint());
		}
		return charEnd;
	}

	public String getName() throws DebugException {
		return name;
	}

	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return null;
	}

	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}

	private int getCharStart(final AST ast) throws DebugException {
		if (ast != null) {
			final IDocument doc = getDocument(ast);
			try {
				if (doc != null) {
						return doc.getLineOffset(ast.getLine() - 1);
				}
			} catch (BadLocationException e) {
				LogUtil.log(e);
			}
		}
		return -1;
	}

	private int getCharEnd(final AST ast) throws DebugException {
		if (ast != null) {
			final IDocument doc = getDocument(ast);
			try {
				if (doc != null) {
					return doc.getLineOffset(ast.getLine());
				}
			} catch (BadLocationException e) {
				LogUtil.log(e);
			}
		}
		return -1;
	}

	private IDocument getDocument(final AST current) {
		final IFile file = EclipseUtil.findIFile(current);
		try {
			if (file != null) {
				IEditorPart editor = IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file, false);
				if (editor instanceof AbstractTextEditor) {
					return ((AbstractTextEditor)editor).getDocumentProvider().getDocument(new FileEditorInput(file));
				}
			}
		} catch (PartInitException e) {
			LogUtil.log(e);
		}

		return null;
	}
}
