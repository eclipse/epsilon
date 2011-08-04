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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.eol.exceptions.EolAssertionException;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;

/**
 * Operation contributor for the EUnit operations which may require external
 * dependencies, or are particularly complex. The simplest operations are in
 * {@link org.eclipse.epsilon.eol.execute.operations.contributors.BasicEUnitOperationContributor}
 * .
 */
public class ExtraEUnitOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return true;
	}

	public void assertEqualFiles(String pathExpected, String pathActual) throws EolAssertionException, EolInternalException {
		compareTrees(pathExpected, pathActual, true);
	}

	public void assertEqualDirectories(String pathExpected, String pathActual) throws EolAssertionException, EolInternalException {
		compareTrees(pathExpected, pathActual, true);
	}

	public void assertNotEqualFiles(String pathExpected, String pathActual) throws EolAssertionException, EolInternalException {
		compareTrees(pathExpected, pathActual, false);
	}

	public void assertNotEqualDirectories(String pathExpected, String pathActual) throws EolAssertionException, EolInternalException {
		compareTrees(pathExpected, pathActual, false);
	}

	private void compareTrees(final String pathExpected, final String pathActual, boolean mustBeEqual) throws EolAssertionException, EolInternalException {
		File fileExpected = new File(pathExpected);
		File fileActual = new File(pathActual);
		try {
			// Compare and check against results
			FileUtil.checkFileExists(fileExpected);
			FileUtil.checkFileExists(fileActual);
			if (FileUtil.sameContents(fileExpected, fileActual) == mustBeEqual) {
				return;
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
		final AST ast = context.getFrameStack().getCurrentStatement();
		throw new EolAssertionException(
			message, ast, fileExpected, fileActual, null);
	}
}
