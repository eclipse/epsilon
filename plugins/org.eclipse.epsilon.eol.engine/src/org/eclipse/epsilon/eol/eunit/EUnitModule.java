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
	
	@Override
	public Object execute() throws EolRuntimeException {
		prepare();
		
		testResults = new ArrayList<EUnitTestResult>();
		
		for (EolOperation o : this.getOperations()) {
			boolean isSetUp = EolAnnotationsUtil.getBooleanAnnotationValue(o.getAst(), "setup", context, false, true);
			if (isSetUp) {
				o.execute(null, Collections.EMPTY_LIST, context, false);
			}
		}
		
		for (EolOperation o : this.getOperations()) {
			boolean isTest = EolAnnotationsUtil.getBooleanAnnotationValue(o.getAst(), "test", context, false, true);
			
			if (isTest) {
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
		}
		
		for (EolOperation o : this.getOperations()) {
			boolean isTearDown = EolAnnotationsUtil.getBooleanAnnotationValue(o.getAst(), "teardown", context, false, true);
			if (isTearDown) {
				o.execute(null, Collections.EMPTY_LIST, context, true);
			}
		}
		
		return null;
	}

	public List<EUnitTestResult> getTestResults() {
		return testResults;
	}
	
}
