/*******************************************************************************
 * Copyright (c) 2008-2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - test listeners, parametric testing
 ******************************************************************************/
package org.eclipse.epsilon.eol.eunit;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.exceptions.EolAssertionException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolSequence;

public class EUnitModule extends EolModule {
	
	private static ThreadMXBean THREAD_MXBEAN;
	private List<EUnitTestListener> testListeners = new ArrayList<EUnitTestListener>();
	private EUnitTest suiteRoot;

	// Destination file for the JUnit XML report
	private File reportFile = null;

	@SuppressWarnings("rawtypes")
	private List selectedOperations;

	static {
		THREAD_MXBEAN = ManagementFactory.getThreadMXBean();
		THREAD_MXBEAN.setThreadCpuTimeEnabled(true);
	}

	public ArrayList<EolOperation> getTests() {
		return getOperationsAnnotatedWith("test");
	}

	public ArrayList<EolOperation> getSetups() {
		return getOperationsAnnotatedWith("setup");
	}
	
	public ArrayList<EolOperation> getTeardowns() {
		return getOperationsAnnotatedWith("teardown");
	}

	public Map<EolOperation, String> getDataVariableNames() {
		final Map<EolOperation, String> results = new LinkedHashMap<EolOperation, String>();
	    for (EolOperation op : getOperations()) {
			try {
				String variableName = (String)EolAnnotationsUtil.getAnnotationValue(op.getAst(), "data", getContext());
				if (variableName != null) {
					results.put(op, variableName);
				}
			} catch (EolRuntimeException e) {}
		}
	    return results;
	}

	public boolean isAnnotatedAs(EolOperation operation, String annotation) {
		try {
			return EolAnnotationsUtil.getBooleanAnnotationValue(operation.getAst(), annotation, context, false, true);
		}
		catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Object execute() throws EolRuntimeException {
		prepare();
		try {
			runSuite(getSuiteRoot());
		} finally {
			writeReport();
		}
		return null;
	}

	public EUnitTest getSuiteRoot() throws EolRuntimeException {
		if (suiteRoot != null) {
			return suiteRoot;
		}

		Map<EolOperation, String> dataVariables = getDataVariableNames();
		List<Map.Entry<EolOperation, String>> pairs
			= new ArrayList<Map.Entry<EolOperation, String>>(dataVariables.entrySet());
		suiteRoot = new EUnitTest();
		populateSuiteTree(suiteRoot, pairs.listIterator());

		return suiteRoot;
	}

	private void populateSuiteTree(EUnitTest parent, ListIterator<Map.Entry<EolOperation,String>> dataIterator) throws EolRuntimeException {
		if (dataIterator.hasNext()) {
			final Map.Entry<EolOperation, String> entry = dataIterator.next();
			final EolSequence values
				= (EolSequence) entry.getKey().execute(null, Collections.EMPTY_LIST, context, true);
			final String variableName = entry.getValue();
			for (Object value : values) {
				EUnitTest child = new EUnitTest();
				child.setParent(parent);
				child.setDataVariableName(variableName);
				child.setDataValue(value);
				child.setOperation(entry.getKey());
				parent.addChildren(child);
				populateSuiteTree(child, dataIterator);
			}
			if (dataIterator.hasPrevious()) {
				dataIterator.previous();
			}
		} else {
			for (EolOperation opTest : this.getTests()) {
				EUnitTest child = new EUnitTest();
				child.setParent(parent);
				child.setOperation(opTest);
				parent.addChildren(child);
			}
		}
	}

	public void runSuite(EUnitTest node) throws EolRuntimeException {
		if (node.getResult().equals(EUnitTestResultType.SKIPPED)) {
			// The test case is to be skipped
			return;
		}

		// We need separate stack frames to ensure everything is clean after each test case
		if (node.getOperation() != null) {
			getContext().getFrameStack().enter(FrameType.UNPROTECTED, node.getOperation().getAst());
		}

		if (node.getDataVariableName() != null) {
			// This node has a variable binding: use it
			Variable dataVariable = new Variable(node.getDataVariableName(), node.getDataValue(), EolAnyType.Instance, true);
			getContext().getFrameStack().put(dataVariable);
		}

		// We need to set test start time *before* firing the beforeCase notification
		// so the time taken by the nested tasks in the setup part is included.
		node.setStartCpuTime(THREAD_MXBEAN.getCurrentThreadCpuTime());
		node.setStartWallclockTime(System.currentTimeMillis());
		node.setResult(EUnitTestResultType.RUNNING);
		fireBeforeCase(node);

		if (node.isRootTest()) {
			// We need to wrap the original streams to capture all their output, for the JUnit-like reports.
			// We can't do it in #initialize(), as the EUnit Ant task changes stdout/stderr to point to the
			// Epsilon console in the beforeCase EUnitTestListener handler.
			getContext().setOutputStream(new ByteBufferTeePrintStream(getContext().getOutputStream()));
			getContext().setErrorStream(new ByteBufferTeePrintStream(getContext().getErrorStream()));
		}

		if (node.getChildren().isEmpty()) {
			// Leaf test case: simply run it
			runLeafTestCase(node.getOperation(), node);
		} else {
			runInnerTestCase(node);
		}

		// Wipe any EOL operation caches
		wipeCaches();
		// Save the time required to run the test
		node.setEndCpuTime(THREAD_MXBEAN.getCurrentThreadCpuTime());
		node.setEndWallclockTime(System.currentTimeMillis());
		// Notify all users that the test is done
		fireAfterCase(node);

		if (node.getOperation() != null) {
			getContext().getFrameStack().leave(node.getOperation().getAst());
		}
	}

	private void runInnerTestCase(EUnitTest node) throws EolRuntimeException {
		// Inner node: run its children. The result of this
		// node is as follows:
		//
		// * ERROR if at least one child had an ERROR result.
		// * Otherwise, FAILURE if at least one child had a FAILURE result.
		// * Otherwise, SUCCESS.
		for (EUnitTest child : node.getChildren()) {
			runSuite(child);
			switch (child.getResult()) {
			case ERROR: node.setResult(EUnitTestResultType.ERROR);
			case FAILURE:
				if (node.getResult() != EUnitTestResultType.ERROR) {
					node.setResult(EUnitTestResultType.FAILURE);
				}
			}
		}
		if (node.getResult() != EUnitTestResultType.ERROR && node.getResult() != EUnitTestResultType.FAILURE) {
			node.setResult(EUnitTestResultType.SUCCESS);
		}
	}

	private void runLeafTestCase(EolOperation opTest, EUnitTest node) throws EolRuntimeException {
		/*
		 * NOTE: the @setup, @test and @teardown operations are all called within
		 * the same unprotected stack frame, so they can reuse the same variables
		 * and access the variables bound by the @data operations.
		 */

		// SETUP
		// EUnitTask will listen to this event and run its nested Ant tasks
		fireBeforeCase(node);
		// Call the @setup operations
		for (EolOperation opSetup : this.getSetups()) {
			opSetup.execute(null, Collections.EMPTY_LIST, context, false);
		}

		// EXECUTION
		try {
			opTest.execute(null, Collections.EMPTY_LIST, context, false);
			node.setResult(EUnitTestResultType.SUCCESS);
		} catch (EolAssertionException asex) {
			node.setResult(EUnitTestResultType.FAILURE);
			node.setException(asex);
			node.setFrameStack(getContext().getFrameStack().clone());
		} catch (Exception ex) {
			node.setResult(EUnitTestResultType.ERROR);
			node.setException(ex);
			node.setFrameStack(getContext().getFrameStack().clone());
		}

		// TEARDOWN
		// Call the @teardown operations
		for (EolOperation opTeardown : this.getTeardowns()) {
			opTeardown.execute(null, Collections.EMPTY_LIST, context, false);
		}
	}

	private void wipeCaches() {
		for (EolOperation op : getOperations()) {
			op.clearCache();
		}
		getContext().getExtendedProperties().clear();
	}

	private ArrayList<EolOperation> getOperationsAnnotatedWith(
			String annotationName) {
		ArrayList<EolOperation> results = new ArrayList<EolOperation>();
		for (EolOperation operation : getOperations()) {
			if (isAnnotatedAs(operation, annotationName)){
				results.add(operation);
			}
		}
		return results;
	}

	/* EVENT NOTIFICATION METHODS */

	public void addTestListener(EUnitTestListener listener) {
		testListeners.add(listener);
	}

	private void fireAfterCase(EUnitTest test) {
		for (EUnitTestListener listener : testListeners) {
			listener.afterCase(this, test);
		}
	}

	private void fireBeforeCase(EUnitTest test) {
		for (EUnitTestListener listener : testListeners) {
			listener.beforeCase(this, test);
		}
	}

	/* OPERATION FILTERING */

	@SuppressWarnings("rawtypes")
	public List getSelectedOperations() {
		return selectedOperations;
	}

	@SuppressWarnings("rawtypes")
	public void setSelectedOperations(List attribute) throws EolRuntimeException {
		this.selectedOperations = attribute;

		// Scan the test tree and mark entries as skipped as necessary
		markSkippedEntries(getSuiteRoot());
	}

	private void markSkippedEntries(EUnitTest node) {
		if (!node.isSelected(selectedOperations)) {
			node.setResult(EUnitTestResultType.SKIPPED);
		}
		else {
			if (node.getResult().equals(EUnitTestResultType.SKIPPED)) {
				node.setResult(EUnitTestResultType.NOT_RUN_YET);
			}
			for (EUnitTest child : node.getChildren()) {
				markSkippedEntries(child);
			}
		}
	}

	/* JUNIT-LIKE REPORTS */

	/**
	 * Changes the destination file for the JUnit-style XML report.
	 * By default, it is {@link EUnitModule#DEFAULT_REPORT_FILE}. If <code>null</code>,
	 * no report will be written.
	 */
	public void setReportFile(File reportFile) {
		this.reportFile = reportFile;
	}

	/**
	 * Returns the destination file for the JUnit-style XML report.
	 */
	public File getReportFile() {
		return reportFile;
	}

	private void writeReport() throws EolRuntimeException {
		if (reportFile != null) {
			EUnitXMLFormatter formatter = new EUnitXMLFormatter(this);
			formatter.generate(reportFile);
		}
	}
}
