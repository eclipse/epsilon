package org.eclipse.epsilon.eunit.execute.operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.epsilon.commons.parse.AST;
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

	@SuppressWarnings("rawtypes")
	@Override
	public Object execute(
			Object source, List parameters, IEolContext context, AST ast)
			throws EolRuntimeException
	{
		if (parameters.size() != 2) {
			throw new EolRuntimeException(
				"Expected 2 paths, but got " + parameters.size() + " arguments");
		}

		// Make sure both files exist
		final String pathExpected = (String)parameters.remove(0);
		final String pathActual = (String)parameters.remove(0);
		final File fileExpected = new File(pathExpected);
		final File fileActual = new File(pathActual);
		try {
			// Compare and check against results
			checkFileExists(fileExpected);
			checkFileExists(fileActual);
			if (sameContents(fileExpected, fileActual) == mustBeEqual) {
				return true;
			}
		} catch (Exception ex) {
			throw new EolInternalException(ex);
		}
		
		String message = String.format(
			"Expected %s and %s to be %s, but they weren't",
			pathExpected, pathActual, mustBeEqual ? "equal" : "different");
		throw new EolAssertionException(
			message, ast, fileExpected, fileActual, null);
	}

	private void checkFileExists(final File file) throws FileNotFoundException {
		if (!file.exists()) {
			throw new FileNotFoundException(
				"File " + file.getPath() + " does not exist");
		}
	}

	/**
	 * We implement our own comparison algorithm here, so we don't need Eclipse
	 * Compare to compute differences, but rather only to show them in the UI.
	 */
	private boolean sameContents(File fileExpected, File fileActual) throws IOException {
		if (fileExpected.isDirectory() != fileActual.isDirectory()) {
			// One is a file, the other is a directory: not the same
			return false;
		}

		if (fileExpected.isDirectory()) {
			// Both are directories: they should contain the same filenames,
			// and each pair should have the same contents
			final Set<String> expectedFilenames = getFilenameSet(fileExpected);
			final Set<String> actualFilenames = getFilenameSet(fileActual);
			if (!expectedFilenames.equals(actualFilenames)) {
				return false;
			}
			for (String filename : expectedFilenames) {
				final File expectedEntry = new File(fileExpected, filename);
				final File actualEntry = new File(fileActual, filename);
				if (!sameContents(expectedEntry, actualEntry)) {
					return false;
				}
			}
			return true;
		}
		else {
			if (fileExpected.length() != fileActual.length()) {
				// Different length: no need to read the files
				return false;
			}

			final FileInputStream isExpected = new FileInputStream(fileExpected);
			final FileInputStream isActual   = new FileInputStream(fileActual);
			return sameContents(isExpected, isActual);
		}
	}

	private HashSet<String> getFilenameSet(File fileExpected) {
		return new HashSet<String>(Arrays.asList(fileExpected.list()));
	}

	private boolean sameContents(InputStream isExpected, InputStream isActual) throws IOException {
		int chExpected, chActual;

		do {
			chExpected = isExpected.read();
			chActual = isActual.read();
		}
		while (chExpected == chActual && chExpected > 0 && chActual > 0);

		return chExpected == chActual;
	}
}
