/*******************************************************************************
 * Copyright (c) 2008-2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - tree structure, time reporting
 ******************************************************************************/
package org.eclipse.epsilon.eol.eunit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.execute.context.FrameStack;

public class EUnitTest {
	
	private EolOperation operation;
	private EUnitTestResultType result = EUnitTestResultType.NOT_RUN_YET;
	private Exception exception;

	private EUnitTest parent;
	private List<EUnitTest> children = new ArrayList<EUnitTest>();

	private String dataVariable;
	private Object dataValue;

	public final static long UNSET_TIME = -1;
	private long startCpuTime = UNSET_TIME;
	private long endCpuTime = UNSET_TIME;
	private long startWallclockTime = UNSET_TIME;
	private long endWallclockTime = UNSET_TIME;
	private FrameStack frameStack;

	public EolOperation getOperation() {
		return operation;
	}

	public void setOperation(EolOperation operation) {
		this.operation = operation;
	}
	
	public EUnitTestResultType getResult() {
		return result;
	}
	
	public void setResult(EUnitTestResultType result) {
		this.result = result;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public EUnitTest getParent() {
		return parent;
	}

	public void setParent(EUnitTest parent) {
		this.parent = parent;
	}

	public String getDataVariableName() {
		return dataVariable;
	}

	public void setDataVariableName(String dataVariable) {
		this.dataVariable = dataVariable;
	}

	public Object getDataValue() {
		return dataValue;
	}

	public void setDataValue(Object dataValue) {
		this.dataValue = dataValue;
	}

	public List<EUnitTest> getChildren() {
		return children;
	}

	public void addChildren(EUnitTest child) {
		children.add(child);
	}

	/**
	 * Sets the start time of the test, measured in nanoseconds of CPU time of the thread running the test.
	 */
	public void setStartCpuTime(long startCpuTime) {
		this.startCpuTime = startCpuTime;
	}

	/**
	 * Gets the start time of the test, measured in nanoseconds of CPU time of the thread running the test.
	 */
	public long getStartCpuTime() {
		return startCpuTime;
	}

	/**
	 * Gets the end time of the test, measured in nanoseconds of CPU time of the thread running the test.
	 */
	public void setEndCpuTime(long endCpuTime) {
		this.endCpuTime = endCpuTime;
	}

	/**
	 * Gets the end time of the test, measured in nanoseconds of CPU time of the thread running the test.
	 */
	public long getEndCpuTime() {
		return endCpuTime;
	}

	/**
	 * Gets the CPU time used by the test, in milliseconds. CPU time includes both user and system operations,
	 * and is much more stable than wallclock time in regards to system load.
	 */
	public long getCpuTimeMillis() {
		return (getEndCpuTime() - getStartCpuTime())/1000000;
	}

	/**
	 * Gets the start time of the test, as returned by {@link System#currentTimeMillis()}.
	 */
	public long getStartWallclockTime() {
		return startWallclockTime;
	}

	/**
	 * Sets the start time of the test, as returned by {@link System#currentTimeMillis()}.
	 */
	public void setStartWallclockTime(long startWallclockTime) {
		this.startWallclockTime = startWallclockTime;
	}

	/**
	 * Gets the end time of the test, as returned by {@link System#currentTimeMillis()}.
	 */
	public long getEndWallclockTime() {
		return endWallclockTime;
	}

	/**
	 * Sets the end time of the test, as returned by {@link System#currentTimeMillis()}.
	 */
	public void setEndWallclockTime(long endWallclockTime) {
		this.endWallclockTime = endWallclockTime;
	}

	/**
	 * Gets the wallclock time used by the test, in milliseconds.
	 */
	public long getWallclockTimeMillis() {
		return getEndWallclockTime() - getStartWallclockTime();
	}

	/**
	 * Returns the name of the operation, or <code>root</code> if this is the root of the test tree.
	 */
	public String getOperationName() {
		return getParent() == null ? "root" : getOperation().getName();
	}

	/**
	 * Returns the name of the test case, which includes the name of the operation and all data bindings performed.
	 */
	public String getCaseName() {
		final String sDataBindings = getAllDataBindings();
		if (sDataBindings != null && sDataBindings.length() > 0) {
			return getOperationName() + " (" + sDataBindings + ")";
		}
		else {
			return getOperationName();
		}
	}

	/**
	 * Stores the frame stack storing the state of the EOL program when the error or failure
	 * happened. This method should receive a copy of the original, so it won't be modified by
	 * the following tests.
	 */
	public void setFrameStack(FrameStack frameStack) {
		this.frameStack = frameStack;
	}

	/**
	 * Returns the frame stack with the state where the test failed.
	 */
	public FrameStack getFrameStack() {
		return frameStack;
	}

	/**
	 * Returns a string explaining the data binding used in this node. If no data binding has been
	 * used, returns the empty string.
	 */
	public String getDataBinding() {
		if (getDataVariableName() == null) return "";

		StringBuffer sbuf = new StringBuffer(getDataVariableName());
		sbuf.append(" = ");

		final String sValue = getDataValue().toString();
		if (sValue.length() < 10) {
			sbuf.append(sValue);
		} else {
			sbuf.append(sValue, 0, 7);
			sbuf.append("...");
		}

		return sbuf.toString();
	}

	/**
	 * Returns a string explaining all the data bindings used in this node, including those done in
	 * its ancestors. If no data binding has been used, returns the empty string.
	 */
	public String getAllDataBindings() {
		List<String> lBindings = new LinkedList<String>();
		for (EUnitTest t = this; t != null; t = t.getParent()) {
			if (t.getDataVariableName() == null) continue;
			lBindings.add(0, t.getDataBinding());
		}

		StringBuffer sbuf = new StringBuffer();
		boolean bFirst = true;
		for (String s : lBindings) {
			if (bFirst) {
				bFirst = false;
			} else {
				sbuf.append(", ");
			}
			sbuf.append(s);
		}
		return sbuf.toString();
	}

	public String toString() {
		StringBuffer sbuf = new StringBuffer(getOperationName());

		// data binding
		if (getDataVariableName() != null) {
			sbuf.append(" (");
			sbuf.append(getDataBinding());
			sbuf.append(")");
		}

		if (getEndWallclockTime() != UNSET_TIME) {
			sbuf.append(" [");
			sbuf.append(getWallclockTimeMillis());
			sbuf.append("ms]");
		}

		return sbuf.toString();
	}

	/**
	 * Returns the number of leaf tests contained in this node. Returns 1 for leaf nodes,
	 * and 1 or more for inner nodes. Takes test case filtering into account.
	 *
	 * @see #collectLeafTests(List, EUnitTestResultType)
	 */
	@SuppressWarnings("rawtypes")
	public int countLeafTests(List selectedOperations) {
		return countLeafTests(selectedOperations, null);
	}

	/**
	 * Returns the number of leaf tests contained in this node with results of a
	 * particular type. Returns 1 for leaf nodes, and 1 or more for inner nodes.
	 * Takes test case filtering into account.
	 *
	 * @see #collectLeafTests(List, EUnitTestResultType)
	 */
	@SuppressWarnings("rawtypes")
	public int countLeafTests(List selectedOperations, EUnitTestResultType resultFilter) {
		return collectLeafTests(selectedOperations, resultFilter).size();
	}

	/**
	 * Collects the leaf tests contained in this node with results of a particular type
	 * into a new list. Takes test filtering into account.
	 *
	 * @see #collectLeafTests(List, EUnitTestResultType, Collection)
	 */
	@SuppressWarnings("rawtypes")
	public List<EUnitTest> collectLeafTests(List selectedOperations, EUnitTestResultType resultFilter) {
		final List<EUnitTest> tests = new ArrayList<EUnitTest>();
		collectLeafTests(selectedOperations, resultFilter, tests);
		return tests;
	}

	/**
	 * Collects the leaf tests contained in this node with results of a particular type
	 * into the provided collection. Takes test filtering into account.
	 */
	@SuppressWarnings("rawtypes")
	public void collectLeafTests(List selectedOperations, EUnitTestResultType resultFilter, Collection<EUnitTest> collection) {
		if (!isSelected(selectedOperations)) {
			return;
		}

		if (isLeafTest()) {
			if (resultFilter == null || resultFilter.equals(getResult())) {
				collection.add(this);
			}
		}
		else {
			for (EUnitTest child : getChildren()) {
				child.collectLeafTests(selectedOperations, resultFilter, collection);
			}
		}
	}

	/**
	 * Returns <code>true</code> if this test case should be run with a certain list
	 * of selected operations to be tested.
	 */
	@SuppressWarnings("rawtypes")
	public boolean isSelected(List selectedOperations) {
		return selectedOperations == null
			|| selectedOperations.isEmpty()
			|| getOperationName() == null
			|| selectedOperations.contains(getOperationName());
	}

	/**
	 * Returns <code>true</code> iff this test has no children.
	 */
	public boolean isLeafTest() {
		return getChildren().isEmpty();
	}

	/**
	 * Returns <code>true</code> iff this test is the root of the test tree.
	 */
	public boolean isRootTest() {
		return getParent() == null;
	}

}
