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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.epsilon.common.dt.extensions.ClassBasedExtension;
import org.eclipse.epsilon.common.dt.extensions.IllegalExtensionException;
import org.eclipse.epsilon.eol.eunit.EUnitModule;
import org.eclipse.epsilon.eol.eunit.EUnitTest;
import org.eclipse.epsilon.eol.eunit.EUnitTestListener;
import org.eclipse.epsilon.eol.eunit.EUnitTestResultType;
import org.eclipse.epsilon.eol.exceptions.EolAssertionException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.Frame;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eunit.dt.EUnitPlugin;
import org.eclipse.epsilon.eunit.dt.diff.IDifferenceViewer;
import org.eclipse.epsilon.eunit.dt.listener.ShowEUnitViewTestListener;
import org.eclipse.epsilon.internal.eunit.dt.diff.StringBasedDifferenceViewer;
import org.eclipse.epsilon.internal.eunit.dt.history.EUnitHistory;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

/**
 * View part for the EUnit test case runner.
 *
 * <p><b>Note:</b> this class implements the {@link EUnitTestListener} interface,
 * but it is does <emph>not</emph> use the EUnit Ant extension point. That is the
 * role of the {@link ShowEUnitViewTestListener}, which creates this view and sets
 * it up. After setting it up, {@link ShowEUnitViewTestListener} delegates all
 * notifications to this class.</p>
 * 
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public class EUnitRunnerView extends ViewPart implements EUnitTestListener {
	public EUnitRunnerView() {
	}
	private class CompareResultsAction extends Action {
		private static final String EUNIT_DIFFVIEWER_EXTPOINT_ID = "org.eclipse.epsilon.eunit.dt.diffviewer";
		private List<IDifferenceViewer> diffViewers = new ArrayList<IDifferenceViewer>();

		public CompareResultsAction() {
			setText("Compare Results");
			setToolTipText("Compares the expected result with the actual result");
			setImageDescriptor(
					EUnitPlugin.getImageDescriptor("icons/elcl16/compare.gif"));
			setEnabled(false);
			loadDiffViewers();
		}

		public void run() {
			final EolAssertionException ex = getCurrentAssertionException();
			if (ex == null) return;
			for (IDifferenceViewer dv : diffViewers) {
				if (dv.canCompare(ex.getExpected(), ex.getActual(), ex.getDelta())) {
					dv.compare(ex.getExpected(), ex.getActual(), ex.getDelta());
					return;
				}
			}
			MessageDialog.openError(getViewSite().getShell(), EUnitRunnerView.EUNIT_DIALOG_TITLE,
				String.format("Could not find a difference viewer for expected=%s, actual=%s and delta=%s.",
						ex.getExpected().getClass().getName(),
						ex.getActual().getClass().getName(),
						ex.getDelta() != null ? ex.getDelta().getClass().getName() : "null"));
		}

		private void loadDiffViewers() {
			try {
				for (IDifferenceViewer dv :
						ClassBasedExtension.getImplementations(
								EUNIT_DIFFVIEWER_EXTPOINT_ID,
								IDifferenceViewer.class))
				{
					diffViewers.add(dv);
				}
			} catch (IllegalExtensionException e) {
				EUnitPlugin.getDefault().logException(e);
			}

			// Fallback: use regular strings
			diffViewers.add(new StringBasedDifferenceViewer());
		}

		/**
		 * If there's a test currently selected which failed due to an EolAssertionException for
		 * which actual values are available, returns the exception. Otherwise, returns <code>null</code>.
		 */
		public EolAssertionException getCurrentAssertionException() {
			// Obtain the currently selected test
			if (!(treeViewerTests.getSelection() instanceof IStructuredSelection)) {
				return null;
			}
			IStructuredSelection sel = (IStructuredSelection)treeViewerTests.getSelection();
			Object currentElement = sel.getFirstElement();
			if (!(currentElement instanceof EUnitTest)) {
				return null;
			}
			EUnitTest currentTest = (EUnitTest)currentElement;

			// This action only works on test which have failed due to a violated assertion
			if (!(currentTest.getException() instanceof EolAssertionException)) {
				return null;
			}
			EolAssertionException ex = (EolAssertionException)currentTest.getException();

			// We're only interested in the assertion exceptions which provide values
			if (ex.getActual() == null) {
				return null;
			}
			else {
				return ex;
			}
		}

	}

	private static final String EUNIT_DIALOG_MSG_NOT_RUN_YET
		= "EUnit has not been successfully launched yet: cannot rerun any suite!";

	private final class RerunAllAction extends Action {
		public RerunAllAction() {
			setText("Rerun All Tests");
			setToolTipText("Tests all the operations in the current EUnit launch");
			setImageDescriptor(
					EUnitPlugin.getImageDescriptor("icons/eunit.png"));
		}

		public void run() {
			rerunCurrentLaunch(new ArrayList<EUnitTest>());
		}
	}

	private final class RerunSameAction extends Action {
		public RerunSameAction() {
			setText("Rerun Same Tests");
			setToolTipText("Tests the same operations as in the current EUnit launch");
			setImageDescriptor(
					EUnitPlugin.getImageDescriptor("icons/eunit-same.png"));
		}

		public void run() {
			rerunCurrentLaunch(null);
		}
	}

	private final class RerunOnlyFailedAction extends Action {
		public RerunOnlyFailedAction() {
			setText("Rerun Failed Tests");
			setToolTipText("Tests the operations which failed in the current EUnit launch");
			setImageDescriptor(
					EUnitPlugin.getImageDescriptor("icons/eunit-err.png"));
		}

		public void run() {
			final EUnitHistory history = EUnitPlugin.getDefault().getHistory();
			final ILaunch currentLaunch = history.getCurrentLaunch();
			if (currentLaunch == null) {
				MessageDialog.openError(getViewSite().getShell(),
						EUnitRunnerView.EUNIT_DIALOG_TITLE, EUnitRunnerView.EUNIT_DIALOG_MSG_NOT_RUN_YET);
				return;
			}

			try {
				final List<EUnitModule> modules = history.getModules(currentLaunch);
				final List<EUnitTest> tests = new ArrayList<EUnitTest>();
				for (EUnitModule module : modules) {
					final EUnitTest result = module.getSuiteRoot();
					result.collectLeafTests(module.getSelectedOperations(), EUnitTestResultType.ERROR, tests);
					result.collectLeafTests(module.getSelectedOperations(), EUnitTestResultType.FAILURE, tests);
				}
				rerunCurrentLaunch(tests);
			} catch (EolRuntimeException e) {
				EUnitPlugin.getDefault().logException(e);
			}
		}
	}

	private final class JumpFromStackFrameAction extends OpenEOLEditorAction {
		public void run() {
			ISelection selection = treeViewerFailureTrace.getSelection();
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			if (obj instanceof Variable) {
				obj = failureTraceContentProvider.getContainingFrame((Variable)obj);
			}
			if (obj instanceof Frame) {
				Frame frame = (Frame)obj;
				if (frame.getCurrentStatement() != null) {
					openInEOLEditor(frame.getCurrentStatement());
				}
				else if (frame.getEntryPoint() != null) {
					openInEOLEditor(frame.getEntryPoint());
				}
			}
			else if (obj instanceof EolAssertionException) {
				actCompareResults.run();
			}
		}
	}

	private final class JumpFromTestAction extends OpenEOLEditorAction {
		public void run() {
			ISelection selection = treeViewerTests.getSelection();
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			if (obj instanceof EUnitTest) {
				EUnitTest test = (EUnitTest)obj;
				if (test.getException() instanceof EolRuntimeException) {
					EolRuntimeException eolEx = (EolRuntimeException)test.getException();
					openInEOLEditor(eolEx.getAst());
				}
				else if (test.getOperation() != null) {
					openInEOLEditor(test.getOperation().getAst());
				}
			}
		}
	}

	private final class RerunSelectedTestCasesAction extends Action {
		public RerunSelectedTestCasesAction() {
			setText("Rerun These Tests");
			setToolTipText("Tests the selected operations");
		}

		public void run() {
			ISelection selection = treeViewerTests.getSelection();
			if (selection instanceof IStructuredSelection) {
				rerunCurrentLaunch(getSelectedTestCases(selection));
			}
			else {
				MessageDialog.openError(
					getViewSite().getShell(), EUNIT_DIALOG_TITLE, "No tests have been selected.");
			}
		}

		private List<EUnitTest> getSelectedTestCases(ISelection selection) {
			IStructuredSelection selectedTestCases = (IStructuredSelection)selection;
			List<EUnitTest> testCases = new ArrayList<EUnitTest>();
			for (Object o : selectedTestCases.toList()) {
				if (o instanceof EUnitTest) {
					testCases.add((EUnitTest)o);
				}
			}
			return testCases;
		}
	}

	private final class OnlyFailedTestsAction extends Action {
		public OnlyFailedTestsAction() {
			super("Show only failed tests", Action.AS_CHECK_BOX);
			setToolTipText("Shows only the tests that have errors or failures");
			setImageDescriptor(EUnitPlugin.getImageDescriptor("icons/obj16/failures.gif"));
		}

		public void run() {
			showOnlyFailedTestsFilter.setEnabled(isChecked());
			treeViewerTests.refresh();
		}
	}

	private static final String EUNIT_DIALOG_TITLE = "EUnit";

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.epsilon.eunit.runner.views.EUnitRunnerView";

	private TreeViewer treeViewerTests;
	private TreeViewer treeViewerFailureTrace;
	private FailureTraceTreeLabelProvider failureTreeLabelProvider;
	private FailureTraceTreeContentProvider failureTraceContentProvider;

	private Label lblNErrors;
	private Label lblNFailures;
	private Label lblNRun;

	private JUnitProgressBar barProgress;
	private int nTotalTestCases;
	private int nRunTestCases;
	private int nErrors;
	private int nFailures;

	private Action actRerunAll;
	private Action actRerunSome;
	private Action actRerunPrev;
	private Action actRerunFailed;
	private Action actJumpFromTest;
	private Action actJumpFromStackFrame;
	private Action actHistory;
	private Action actOnlyFailedTests;
	private CompareResultsAction actCompareResults;

	private ShowOnlyFailedTestsViewerFilter showOnlyFailedTestsFilter;

	private ToolBar toolbarFailureTrace;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		final GridLayout gl_parent = new GridLayout(6, true);
		gl_parent.marginHeight = 0;
		gl_parent.marginWidth = 0;
		gl_parent.horizontalSpacing = 0;
		parent.setLayout(gl_parent);

		Label lblRun = new Label(parent, SWT.NONE);
		lblRun.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblRun.setText("Runs:");

		lblNRun = new Label(parent, SWT.NONE);
		GridData gd_lblNRun = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_lblNRun.horizontalIndent = 10;
		lblNRun.setLayoutData(gd_lblNRun);
		lblNRun.setText("0/0");
		lblNRun.setAlignment(SWT.LEFT);

		Label lblFailures = new Label(parent, SWT.NONE);
		lblFailures.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFailures.setText("Failures:");

		lblNFailures = new Label(parent, SWT.NONE);
		GridData gd_lblNFailures = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNFailures.horizontalIndent = 10;
		lblNFailures.setLayoutData(gd_lblNFailures);
		lblNFailures.setText("0");

		Label lblErrors = new Label(parent, SWT.NONE);
		lblErrors.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblErrors.setText("Errors:");

		lblNErrors = new Label(parent, SWT.NONE);
		GridData gd_lblNErrors = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNErrors.horizontalIndent = 10;
		lblNErrors.setLayoutData(gd_lblNErrors);
		lblNErrors.setText("0");

		barProgress = new JUnitProgressBar(parent);
		barProgress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));

		SashForm sashBetweenTestsAndFailures = new SashForm(parent, SWT.BORDER | SWT.SMOOTH | SWT.VERTICAL);
		GridData gd_sashBetweenTestsAndFailures = new GridData(SWT.FILL, SWT.FILL, true, true, 6, 1);
		gd_sashBetweenTestsAndFailures.widthHint = 593;
		sashBetweenTestsAndFailures.setLayoutData(gd_sashBetweenTestsAndFailures);

		treeViewerTests = new TreeViewer(sashBetweenTestsAndFailures, SWT.MULTI);
		treeViewerTests.setContentProvider(new TestTreeContentProvider(getViewSite()));

		Composite failureTraceComposite = new Composite(sashBetweenTestsAndFailures, SWT.NONE);
		GridLayout gl_composite = new GridLayout(2, false);
		gl_composite.marginTop = 0;
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		gl_composite.horizontalSpacing = 0;
		failureTraceComposite.setLayout(gl_composite);

		CLabel lblFailureTrace = new CLabel(failureTraceComposite, SWT.NONE);
		lblFailureTrace.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblFailureTrace.setText("Failure Trace");
		lblFailureTrace.setImage(
			EUnitPlugin.imageDescriptorFromPlugin(EUnitPlugin.PLUGIN_ID, "icons/eview16/stackframe.gif").createImage());

		toolbarFailureTrace = new ToolBar(failureTraceComposite, SWT.FLAT);
		toolbarFailureTrace.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

		treeViewerFailureTrace = new TreeViewer(failureTraceComposite, SWT.SINGLE);
		Tree treeFailureTrace = treeViewerFailureTrace.getTree();
		treeFailureTrace.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		showOnlyFailedTestsFilter = new ShowOnlyFailedTestsViewerFilter();
		failureTraceContentProvider = new FailureTraceTreeContentProvider(getViewSite());
		failureTreeLabelProvider = new FailureTraceTreeLabelProvider();
		treeViewerFailureTrace.setContentProvider(failureTraceContentProvider);
		treeViewerFailureTrace.setLabelProvider(failureTreeLabelProvider);
		treeViewerTests.setContentProvider(new TestTreeContentProvider(getViewSite()));
		treeViewerTests.setLabelProvider(new TestTreeLabelProvider());
		treeViewerTests.addFilter(new DiscardSkippedTestsViewerFilter());
		treeViewerTests.addFilter(showOnlyFailedTestsFilter);

		sashBetweenTestsAndFailures.setWeights(new int[] {1, 1});

		// Create the help context id for the viewer's control
		PlatformUI
				.getWorkbench()
				.getHelpSystem()
				.setHelp(treeViewerTests.getControl(),
						"org.eclipse.epsilon.eunit.runner.viewer");
		makeActions();
		hookContextMenuForTests();
		hookContextMenuForStackFrames();
		hookClickAction();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenuForStackFrames() {
		hookContextMenu("#FramePopupMenu", new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				EUnitRunnerView.this.fillContextMenuForStackFrames(manager);
			}
		}, treeViewerFailureTrace);
	}

	private void hookContextMenuForTests() {
		hookContextMenu("#TestPopupMenu", new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				EUnitRunnerView.this.fillContextMenuForTests(manager);
			}
		}, treeViewerTests);
	}

	private void hookContextMenu(final String menuManagerName,
			final IMenuListener menuListener, final Viewer component) {
		MenuManager menuMgr = new MenuManager(menuManagerName);
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(menuListener);
		Menu menu = menuMgr.createContextMenu(component.getControl());
		component.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, component);
	}


	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());

		ToolBarManager manager = new ToolBarManager(toolbarFailureTrace);
		manager.add(actCompareResults);
		manager.add(new Separator());
		// Other plug-ins can contribute their actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		manager.update(true);
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(actOnlyFailedTests);
		manager.add(actRerunAll);
		manager.add(actRerunPrev);
		manager.add(actRerunFailed);
		manager.add(new Separator());
		// Other plug-ins can contribute their actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillContextMenuForTests(IMenuManager manager) {
		manager.add(actRerunSome);
		manager.add(actJumpFromTest);
		manager.add(new Separator());
		// Other plug-ins can contribute their actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillContextMenuForStackFrames(IMenuManager manager) {
		manager.add(actJumpFromStackFrame);
		manager.add(new Separator());
		// Other plug-ins can contribute their actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(actOnlyFailedTests);
		manager.add(actRerunAll);
		manager.add(actRerunPrev);
		manager.add(actRerunFailed);
		manager.add(actHistory);
		manager.add(new Separator());
		// Other plug-ins can contribute their actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void makeActions() {
		actRerunAll = new RerunAllAction();
		actRerunPrev = new RerunSameAction();
		actRerunSome = new RerunSelectedTestCasesAction();
		actRerunFailed = new RerunOnlyFailedAction();
		actJumpFromTest = new JumpFromTestAction();
		actJumpFromStackFrame = new JumpFromStackFrameAction();

		actOnlyFailedTests = new OnlyFailedTestsAction();
		actCompareResults = new CompareResultsAction();

		final EUnitHistory history = EUnitPlugin.getDefault().getHistory();
		actHistory = new HistoryDropDownAction(history, this);
	}

	private void hookClickAction() {
		treeViewerTests.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					final IStructuredSelection sel = (IStructuredSelection)event.getSelection();
					treeViewerFailureTrace.setInput(sel.getFirstElement());
					final CompareResultsAction act = actCompareResults;
					actCompareResults.setEnabled(act.getCurrentAssertionException() != null);
				}
			}
		});
	}

	private void hookDoubleClickAction() {
		treeViewerTests.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				actJumpFromTest.run();
			}
		});

		treeViewerFailureTrace.addDoubleClickListener(new IDoubleClickListener(){
			public void doubleClick(DoubleClickEvent event) {
				actJumpFromStackFrame.run();
			}
		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		treeViewerTests.getControl().setFocus();
	}

	/**
	 * Changes the module which is currently displayed in this view.
	 * @param module EUnit module to be shown.
	 */
	public void setCurrentModules(final List<EUnitModule> modules) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				try {
					treeViewerTests.setInput(modules);
					treeViewerTests.refresh();
					failureTreeLabelProvider.setPrettyPrinterManager(
							modules.get(0).getContext().getPrettyPrinterManager());
					initializeTestCaseCounts(modules);
				} catch (EolRuntimeException e) {
					EUnitPlugin.getDefault().logException(e);
				}
			}
		});
	}

	@Override
	public void beforeCase(final EUnitModule module, EUnitTest test) {
		if (test.isRootTest()) {
			EUnitHistory history = EUnitPlugin.getDefault().getHistory();
			List<EUnitModule> modules = history.getModules(history.getCurrentLaunch());
			setCurrentModules(modules);
		}
	}

	@Override
	public void afterCase(final EUnitModule module, final EUnitTest test) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				treeViewerTests.update(test, null);
				treeViewerTests.update(module, null);

				if (test.isLeafTest()) {
					if (test.getResult() != EUnitTestResultType.SKIPPED) {
						++nRunTestCases;
					}
					switch (test.getResult()) {
					case ERROR:
						++nErrors;
						break;
					case FAILURE:
						++nFailures;
						break;
					}
					updateTestCaseCounts();
				}
			}
		});
	}

	@SuppressWarnings("rawtypes")
	private void initializeTestCaseCounts(List<EUnitModule> modules) throws EolRuntimeException {
		nTotalTestCases = nErrors = nFailures = nRunTestCases = 0;

		for (EUnitModule module : modules) {
			final EUnitTest results = module.getSuiteRoot();
			final List selOps = module.getSelectedOperations();

			final int allTests = results.countLeafTests(selOps);
			final int withErrors = results.countLeafTests(selOps, EUnitTestResultType.ERROR);
			final int withFailures = results.countLeafTests(selOps, EUnitTestResultType.FAILURE);
			final int successfulTests = results.countLeafTests(selOps, EUnitTestResultType.SUCCESS);

			nTotalTestCases += allTests;
			nErrors += withErrors;
			nFailures += withFailures;
			nRunTestCases += withErrors + withFailures + successfulTests;
		}

		updateTestCaseCounts();
	}

	private void updateTestCaseCounts() {
		lblNErrors.setText(Integer.toString(nErrors));
		lblNFailures.setText(Integer.toString(nFailures));
		lblNRun.setText(String.format("%d/%d", nRunTestCases, nTotalTestCases));

		final boolean hasErrors = nErrors > 0 || nFailures > 0;
		barProgress.reset(hasErrors, false, nRunTestCases, nTotalTestCases);
	}

	/**
	 * Reruns the last EUnit launch.
	 *
	 * @see #rerunLaunch(List, ILaunch)
	 */
	private void rerunCurrentLaunch(List<EUnitTest> tests) {
		final EUnitHistory history = EUnitPlugin.getDefault().getHistory();
		rerunLaunch(tests, history.getCurrentLaunch());
	}

	/**
	 * Reruns the EUnit launch in <code>lastLaunch</code>, using a working copy
	 * of its launch configuration. If <code>testCases</code> is null, the same
	 * operations as in the previous lunch will be run. Otherwise, if it is
	 * empty, all test cases will be run. If it is not empty, only the operations
	 * tested in the selected test cases will be run.
	 */
	private void rerunLaunch(List<EUnitTest> testCases, ILaunch launch) {
		if (launch != null) {
			ILaunchConfigurationWorkingCopy copy;
			try {
				copy = launch.getLaunchConfiguration().getWorkingCopy();
				if (testCases != null) {
					final Set<String> opNames = new HashSet<String>();
					collectOperationNamesFromSubtree(testCases, opNames);
					EUnitPlugin.getDefault().setSelectedOperations(copy, new ArrayList<String>(opNames));
				}
				copy.launch(launch.getLaunchMode(), null, true);
			} catch (CoreException e) {
				EUnitPlugin.getDefault().logException(e);
			}
		} else {
			MessageDialog.openError(getViewSite().getShell(), EUNIT_DIALOG_TITLE,
				EUNIT_DIALOG_MSG_NOT_RUN_YET);
		}
	}

	private void collectOperationNamesFromSubtree(List<EUnitTest> tests, Collection<String> opNames) {
		for (EUnitTest test : tests) {
			// This tests, its ancestors and its descendants should be listed
			for (EUnitTest curr = test; curr != null; curr = curr.getParent()) {
				opNames.add(curr.getOperationName());
			}
			collectOperationNamesFromSubtree(test.getChildren(), opNames);
		}
	}
}
