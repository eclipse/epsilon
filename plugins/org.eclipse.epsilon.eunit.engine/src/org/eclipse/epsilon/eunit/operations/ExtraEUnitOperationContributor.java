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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.epsilon.common.dt.extensions.ClassBasedExtension;
import org.eclipse.epsilon.common.dt.extensions.IllegalExtensionException;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.eol.exceptions.EolAssertionException;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelNotFoundException;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eunit.extensions.IModelComparator;

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

	public void assertEqualModels(String expectedModelName, String obtainedModelName) throws EolModelNotFoundException, EolAssertionException, EolInternalException, IllegalExtensionException {
		compareModels(null, expectedModelName, obtainedModelName, true, new HashMap<String, Object>());
	}

	public void assertEqualModels(String expectedModelName, String obtainedModelName, Map<String, Object> options) throws EolModelNotFoundException, EolAssertionException, EolInternalException, IllegalExtensionException {
		compareModels(null, expectedModelName, obtainedModelName, true, options);
	}

	public void assertEqualModels(String message, String expectedModelName, String obtainedModelName) throws EolModelNotFoundException, EolAssertionException, EolInternalException, IllegalExtensionException {
		compareModels(message, expectedModelName, obtainedModelName, true, new HashMap<String, Object>());
	}

	public void assertEqualModels(String message, String expectedModelName, String obtainedModelName, Map<String, Object> options) throws EolModelNotFoundException, EolAssertionException, EolInternalException, IllegalExtensionException {
		compareModels(message, expectedModelName, obtainedModelName, true, options);
	}

	public void assertNotEqualFiles(String pathExpected, String pathActual) throws EolAssertionException, EolInternalException {
		compareTrees(pathExpected, pathActual, false);
	}

	public void assertNotEqualDirectories(String pathExpected, String pathActual) throws EolAssertionException, EolInternalException {
		compareTrees(pathExpected, pathActual, false);
	}

	public void assertNotEqualModels(String expectedModelName, String obtainedModelName) throws EolModelNotFoundException, EolAssertionException, EolInternalException, IllegalExtensionException {
		compareModels(null, expectedModelName, obtainedModelName, false, new HashMap<String, Object>());
	}

	public void assertNotEqualModels(String expectedModelName, String obtainedModelName, Map<String, Object> options) throws EolModelNotFoundException, EolAssertionException, EolInternalException, IllegalExtensionException {
		compareModels(null, expectedModelName, obtainedModelName, false, options);
	}

	public void assertNotEqualModels(String message, String expectedModelName, String obtainedModelName) throws EolModelNotFoundException, EolAssertionException, EolInternalException, IllegalExtensionException {
		compareModels(message, expectedModelName, obtainedModelName, false, new HashMap<String, Object>());
	}

	public void assertNotEqualModels(String message, String expectedModelName, String obtainedModelName, Map<String, Object> options) throws EolModelNotFoundException, EolAssertionException, EolInternalException, IllegalExtensionException {
		compareModels(message, expectedModelName, obtainedModelName, false, options);
	}

	public void assertMatchingLine(String pathExpected, String regexp) throws EolInternalException {
		assertMatchingLine(null, pathExpected, regexp);
	}

	public void assertMatchingLine(String message, String pathExpected, String regexp) throws EolInternalException {
		BufferedReader reader = null;
		try {
			final Pattern regex = Pattern.compile(regexp);
			
			reader = new BufferedReader(new FileReader(new File(pathExpected)));
			String line;
			while ((line = reader.readLine()) != null) {
				if (regex.matcher(line).matches()) {
					return;
				}
			}

			final AST ast = context.getFrameStack().getCurrentStatement();
			throw new EolAssertionException(
					message != null ? message : String.format("No lines matched '%s'", regexp),
					ast, null, null, null);
		}
		catch (Exception ex) {
			throw new EolInternalException(ex);
		}
		finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new EolInternalException(e);
				}
			}
		}
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

	private IModel getModel(String name) throws EolModelNotFoundException
	{
		return context.getModelRepository().getModelByName(name);
	}

	private void compareModels(String message, String expectedModelName, String actualModelName, boolean mustBeEqual, Map options) throws EolModelNotFoundException, EolAssertionException, EolInternalException, IllegalExtensionException {
		final IModel expectedCModel = getModel(expectedModelName);
		final IModel actualCModel = getModel(actualModelName);
		final IModelComparator comparator = getComparator(expectedCModel, actualCModel);
		if (comparator == null) {
			throw new IllegalArgumentException("No matching comparator has been found for " + expectedCModel + " and " + actualCModel);
		}
		comparator.configure(options);

		// Compare the models
		Object delta = null;
		final boolean bExpectedEmpty = expectedCModel.allContents().isEmpty();
		final boolean bActualEmpty = actualCModel.allContents().isEmpty();
		try {
			if (!bExpectedEmpty && !bActualEmpty) {
				// We only use the driver-specific comparison if both models are not empty
				delta = comparator.compare(expectedCModel, actualCModel);
			}
			else if (bExpectedEmpty != bActualEmpty) {
				delta = "expected "
					+ (bExpectedEmpty ? "is" : "is not")
					+ " empty, actual "
					+ (bActualEmpty ? "is" : "is not")
					+ " empty";
			}
		} catch (Exception e) {
			throw new EolInternalException(e);
		}

		// Does the comparison result match our expectations?
		if ((delta == null) == mustBeEqual) {
			return;
		}

		if (message == null) {
			if (bExpectedEmpty) {
				message = "Expected " + actualModelName
					+ (mustBeEqual ? " to be also" : " not to be") + " empty, but it is "
					+ (bActualEmpty ? "empty" : "not");
			}
			else {
				message = "Expected " + actualModelName
					+ " to be " + (mustBeEqual ? "equal" : "different") + " to "
					+ expectedModelName + ", but it is " + (bActualEmpty ? "empty" : "not");
			}
		}

		if (mustBeEqual) {
			throw new EolAssertionException(message.toString(), context.getFrameStack().getCurrentStatement(), expectedCModel, actualCModel, delta);
		}
		else {
			throw new EolAssertionException(message.toString(), context.getFrameStack().getCurrentStatement(), null, null, null);
		}
	}

	private IModelComparator getComparator(IModel expectedCModel, IModel actualCModel) throws IllegalExtensionException {
		try {
			Class.forName("org.eclipse.epsilon.common.dt.extensions.ClassBasedExtension");
			List<IModelComparator> comparators = ClassBasedExtension.getImplementations(IModelComparator.EXTENSION_POINT_ID, IModelComparator.class);
			for (IModelComparator comparator : comparators) {
				if (comparator.canCompare(expectedCModel, actualCModel)) {
					return comparator;
				}
			}
		} catch (ClassNotFoundException ex) {
			// do nothing
		}
		return null;
	}

}
