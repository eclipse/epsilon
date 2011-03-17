/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eunit.dt.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.epsilon.eol.eunit.EUnitTest;
import org.eclipse.epsilon.eol.execute.context.Frame;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IViewSite;

/**
 * Content provider for the failure trace tree. It has two levels: the first level
 * lists the frames, and the second level lists the variables in each stack frame.
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
class FailureTraceTreeContentProvider implements ITreeContentProvider {
	private EUnitTest currentTest;
	private Object[] currentTestFrames;
	private Map<Variable, Frame> mapVarToFrame = new HashMap<Variable, Frame>();
	private final IViewSite viewSite;

	public FailureTraceTreeContentProvider(IViewSite viewSite) {
		this.viewSite = viewSite;
	}

	@Override
	public void dispose() {}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (newInput instanceof EUnitTest) {
			this.currentTest = (EUnitTest)newInput;

			ArrayList lFrames = new ArrayList<Frame>();
			if (currentTest.getFrameStack() != null) {
				ListIterator itFrames = currentTest.getFrameStack().getFrames();
				while (itFrames.hasNext()) {
					final Frame frame = (Frame)itFrames.next();
					lFrames.add(frame);
					for (Variable v : frame.getAll().values()) {
						mapVarToFrame.put(v, frame);
					}
				}
			}
			currentTestFrames = lFrames.toArray();
		}
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement.equals(viewSite)) {
			return getChildren(currentTest);
		}
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof EUnitTest) {
			return currentTestFrames;
		}
		else if (parentElement instanceof Frame) {
			Frame frame = (Frame)parentElement;
			return frame.getAll().values().toArray();
		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		if (element instanceof Frame) {
			return currentTest;
		}
		else if (element instanceof Variable) {
			return mapVarToFrame.get((Variable)element);
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof EUnitTest) {
			return true;
		}
		else if (element instanceof Frame) {
			return !((Frame)element).getAll().isEmpty();
		}
		return false;
	}

	/**
	 * Returns the stack frame which contains this variable, or
	 * <code>null</code> if none of the stack frames in this failure trace
	 * contains it.
	 */
	public Frame getContainingFrame(Variable v) {
		return mapVarToFrame.get(v);
	}
}