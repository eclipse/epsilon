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
package org.eclipse.epsilon.eol.eunit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.EolOperation;
import org.eclipse.epsilon.eol.annotations.EolAnnotationsUtil;
import org.eclipse.epsilon.eol.exceptions.EolAssertionException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EUnitModule extends EolModule {
	
	List<EUnitTestResult> testResults = null;
	
	public ArrayList<EolOperation> getTests() {
		ArrayList<EolOperation> tests = new ArrayList<EolOperation>();
		for (EolOperation operation : getOperations()) {
			if (isAnnotatedAs(operation, "test")){
				tests.add(operation);
			}
		}
		return tests;
	}
	
	public ArrayList<EolOperation> getSetups() {
		ArrayList<EolOperation> setups = new ArrayList<EolOperation>();
		for (EolOperation operation : getOperations()) {
			if (isAnnotatedAs(operation, "setup")){
				setups.add(operation);
			}
		}
		return setups;
	}
	
	public ArrayList<EolOperation> getTeardowns() {
		ArrayList<EolOperation> teardowns = new ArrayList<EolOperation>();
		for (EolOperation operation : getOperations()) {
			if (isAnnotatedAs(operation, "teardown")){
				teardowns.add(operation);
			}
		}
		return teardowns;
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
		
		testResults = new ArrayList<EUnitTestResult>();
		
		for (EolOperation o : this.getSetups()) {
			o.execute(null, Collections.EMPTY_LIST, context, false);
		}
		
		for (EolOperation o : this.getTests()) {
			
			EUnitTestResult testResult = new EUnitTestResult();
			testResult.operation = o;
			Object result = null;
			try {
				result = o.execute(null, Collections.EMPTY_LIST, context);
				testResult.setType(EUnitTestResultType.SUCCESS);
			}
			catch (EolAssertionException asex) {
				testResult.setType(EUnitTestResultType.FAILURE);
				testResult.setMessage(asex.getReason());
			}
			catch (Exception ex) {
				testResult.setType(EUnitTestResultType.ERROR);
				testResult.setException(ex);
			}
			testResults.add(testResult);
		
		}
		
		for (EolOperation o : this.getTeardowns()) {
			o.execute(null, Collections.EMPTY_LIST, context, true);
		}
		
		return null;
	}

	public List<EUnitTestResult> getTestResults() {
		return testResults;
	}
	
}
