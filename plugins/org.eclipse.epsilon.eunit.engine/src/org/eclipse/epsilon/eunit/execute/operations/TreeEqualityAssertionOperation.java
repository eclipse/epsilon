package org.eclipse.epsilon.eunit.execute.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.eclipse.compare.structuremergeviewer.Differencer;
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
			if (!fileExpected.exists()) {
				throw new FileNotFoundException(fileExpected.getPath() + " does not exist");
			}
			else if (!fileActual.exists()) {
				throw new FileNotFoundException(fileActual.getPath() + " does not exist");
			}
		} catch (FileNotFoundException ex) {
			throw new EolInternalException(ex);
		}

		// Compare and check against results
		final FilesystemTreeNode expected = new FilesystemTreeNode(fileExpected);
		final FilesystemTreeNode actual = new FilesystemTreeNode(fileActual);
		final Differencer diffEngine = new Differencer();
		final Object delta
			= diffEngine.findDifferences(false, null, null, null, expected, actual);
		if ((delta == null) == mustBeEqual) {
			return true;
		}

		String message = String.format(
			"Expected %s and %s to be %s, but they weren't",
			pathExpected, pathActual, mustBeEqual ? "equal" : "different");
		throw new EolAssertionException(
			message, ast, fileExpected, fileActual, delta);
	}

}
