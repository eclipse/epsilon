/*******************************************************************************
 * Copyright (c) 2011 Antonio García-Domínguez
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Antonio García Domínguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eunit.operations;

import java.io.File;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.eol.exceptions.EolAssertionException;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.simple.AbstractSimpleOperation;

public class TreeEqualityAssertionOperation extends AbstractSimpleOperation {

	private final boolean mustBeEqual;

	public TreeEqualityAssertionOperation(boolean mustBeEqual) {
		this.mustBeEqual = mustBeEqual;
	}

	@Override
	public Object execute(
			Object source, List<?> parameters, IEolContext context, AST ast)
			throws EolRuntimeException
	{
		if (parameters.size() != 2) {
			throw new EolRuntimeException(
				"Expected 2 paths, but got " + parameters.size() + " arguments");
		}

		// Make sure both files exist
		final String pathExpected = (String)parameters.remove(0);
		final String pathActual = (String)parameters.remove(0);
		File fileExpected = new File(pathExpected);
		File fileActual = new File(pathActual);
		try {
			// Compare and check against results
			FileUtil.checkFileExists(fileExpected);
			FileUtil.checkFileExists(fileActual);
			if (FileUtil.sameContents(fileExpected, fileActual) == mustBeEqual) {
				return true;
			}

			if (mustBeEqual) {
				// If they were expected to be equal and they were different,
				// the user may want to see the differences later. We need
				// to copy the files to a temporary location so they can be
				// safely compared later on.
				fileExpected = FileUtil.copyToTemp(fileExpected);
				fileActual   = FileUtil.copyToTemp(fileActual);
			}
			else {
				// There are no differences: disable the 'Compare' button
				fileExpected = fileActual = null;
			}
		} catch (Exception ex) {
			throw new EolInternalException(ex);
		}

		String message = String.format(
			"Expected %s and %s to be %s, but they weren't",
			pathExpected, pathActual, mustBeEqual ? "equal" : "different");
		
		// Since the assertion has failed, !mustBeEqual shows whether the
		// trees were equal or not. If they are equal, there is no point
		// in showing differences in the UI.
		throw new EolAssertionException(
			message, ast, fileExpected, fileActual, null);
	}
}
