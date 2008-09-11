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
package org.eclipse.epsilon.evl.dt.views;


import java.util.Collections;
import java.util.ListIterator;

import org.eclipse.epsilon.common.dt.util.ListContentProvider;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.EvlFixInstance;
import org.eclipse.epsilon.evl.EvlUnsatisfiedConstraint;
import org.eclipse.epsilon.evl.IEvlFixer;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dt.EvlPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

public class ValidationView extends ViewPart {
	
	protected boolean done = false;
	protected IEvlModule module = null;
	private TableViewer viewer;
	private Action resumeAction;
	private IEvlFixer fixer;
	//private Action cancelAction;
	
	class UnsatisfiedConstraintLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return ((EvlUnsatisfiedConstraint) obj).getMessage();
		}
		public Image getColumnImage(Object obj, int index) {
			EvlUnsatisfiedConstraint unsatisfiedConstraint = (EvlUnsatisfiedConstraint) obj;
			if (unsatisfiedConstraint.isFixed()) {
				return EvlPlugin.getImageDescriptor("icons/fix.gif").createImage();
			}
			else if (unsatisfiedConstraint.getConstraint().isCritique()) {
				return EvlPlugin.getImageDescriptor("icons/critique.gif").createImage();
			}
			else {
				return EvlPlugin.getImageDescriptor("icons/error.gif").createImage();
			}
		}
	}
	
	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public ValidationView() {
	
	}
	
	public void fix(final IEvlModule module, IEvlFixer fixer) {
		this.setDone(false);
		this.fixer = fixer;
		this.module = module;
		if (module.getContext().getUnsatisfiedConstraints().size() > 0) {
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
				public void run() {
					viewer.setInput(module.getContext().getUnsatisfiedConstraints());
				}
			});
		}
		else {
			this.setDone(true);
		}
	}
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ListContentProvider());
		viewer.setLabelProvider(new UnsatisfiedConstraintLabelProvider());
		viewer.setSorter(new NameSorter());
		makeActions();
		hookContextMenu();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				ValidationView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(resumeAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		
		EvlUnsatisfiedConstraint unsatisfiedConstraint = (EvlUnsatisfiedConstraint)((StructuredSelection) viewer.getSelection()).getFirstElement();
		if (unsatisfiedConstraint == null) return;
		
		ListIterator li = unsatisfiedConstraint.getFixes().listIterator();
		while (li.hasNext()){
			EvlFixInstance fixInstance = (EvlFixInstance) li.next();
			manager.add(new PerformFixAction(unsatisfiedConstraint, fixInstance));
		}
		
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	class PerformFixAction extends Action {
		
		EvlUnsatisfiedConstraint unsatisfiedConstraint = null;
		EvlFixInstance fixInstance = null;
		
		public PerformFixAction(EvlUnsatisfiedConstraint unsatisfiedConstraint, EvlFixInstance fixInstance) {
			this.unsatisfiedConstraint = unsatisfiedConstraint;
			this.fixInstance = fixInstance;
			this.setImageDescriptor(EvlPlugin.getImageDescriptor("icons/fix.gif"));
			try {
				this.setText(fixInstance.getTitle());
			} catch (EolRuntimeException e) {
				module.getContext().getErrorStream().println(e.toString());
				this.setText("An exception occured while evaluating the title of the fix");
			}
		}
		
		@Override
		public void run() {
			
			//PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

			//	public void run() {
					try {
						fixInstance.perform();
						unsatisfiedConstraint.setFixed(true);
						viewer.refresh();
					} catch (Exception e) {
						module.getContext().getErrorStream().println(e.toString());
					}
			//}
				
			//});
			
		}
		
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(resumeAction);
	}

	private void makeActions() {
		resumeAction = new Action() {
			@Override
			public void run() {
				setDone(true);
			}
		};
		resumeAction.setText("Resume");
		resumeAction.setToolTipText("Finish with performing fixes and resume to the post section of the EVL specification");
		resumeAction.setImageDescriptor(EvlPlugin.getImageDescriptor("icons/resume.gif"));
	}

	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
	
	public boolean isDone() {
		return done;
	}
	
	protected void setDone(boolean done) {
		this.done = done;
		if (this.done) {
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					viewer.setInput(Collections.EMPTY_LIST);
				}
				
			});
			
		}
	}
}
