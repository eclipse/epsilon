package org.eclipse.epsilon.eunit.execute.operations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
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
		File fileExpected = new File(pathExpected);
		File fileActual = new File(pathActual);
		try {
			// Compare and check against results
			checkFileExists(fileExpected);
			checkFileExists(fileActual);
			if (sameContents(fileExpected, fileActual) == mustBeEqual) {
				return true;
			}

			if (mustBeEqual) {
				// If they were expected to be equal and they were different,
				// the user may want to see the differences later. We need
				// to copy the files to a temporary location so they can be
				// safely compared later on.
				fileExpected = copyToTemp(fileExpected);
				fileActual   = copyToTemp(fileActual);
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
			message, ast, fileExpected, fileActual, new Boolean(!mustBeEqual));				
	}

	private static void checkFileExists(final File file) throws FileNotFoundException {
		if (!file.exists()) {
			throw new FileNotFoundException(
				"File " + file.getPath() + " does not exist");
		}
	}

	private static File copyToTemp(File srcFile) throws IOException {
		File tmpFile = File.createTempFile("filecompare", "tmp");
		if (srcFile.isDirectory()) {
			tmpFile.delete();
			tmpFile.mkdir();
		}
		copy(srcFile, tmpFile);
		return tmpFile;
	}

	private static void copy(File srcFile, File dstFile) throws IOException {
		if (srcFile.isDirectory()) {
			dstFile.mkdir();
			for (File entry : srcFile.listFiles()) {
				copy(entry, new File(dstFile, entry.getName()));
			}
		}
		else {
			// Based on the second answer in http://stackoverflow.com/questions/106770.
			FileInputStream isSrc = null;
			FileOutputStream osDst = null;
			FileChannel chSrc = null;
			FileChannel chDst = null;
			try {
				isSrc = new FileInputStream(srcFile);
				osDst = new FileOutputStream(dstFile);
				chSrc = isSrc.getChannel();
				chDst = osDst.getChannel();
				final long srcBytes = srcFile.length();
				long transferred = 0;
				while (transferred < srcBytes) {
					transferred += chDst.transferFrom(chSrc, transferred, srcBytes);
					chDst.position(transferred);
				}
			}
			finally {
				if (chDst != null) {
					chDst.close();
				}
				else if (osDst != null) {
					osDst.close();
				}

				if (chSrc != null) {
					chSrc.close();
				}
				else if (isSrc != null) {
					isSrc.close();
				}
			}
		}
	}

	private static HashSet<String> listFilesAsSet(File fileExpected) {
		return new HashSet<String>(Arrays.asList(fileExpected.list()));
	}

	/**
	 * We implement our own comparison algorithm here, so we don't need Eclipse
	 * Compare to compute differences, but rather only to show them in the UI.
	 */
	private static boolean sameContents(File fileExpected, File fileActual) throws IOException {
		if (fileExpected.isDirectory() != fileActual.isDirectory()) {
			// One is a file, the other is a directory: not the same
			return false;
		}

		if (fileExpected.isDirectory()) {
			// Both are directories: they should contain the same filenames,
			// and each pair should have the same contents
			final Set<String> expectedFilenames = listFilesAsSet(fileExpected);
			final Set<String> actualFilenames = listFilesAsSet(fileActual);
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

	private static boolean sameContents(InputStream isExpected, InputStream isActual) throws IOException {
		int chExpected, chActual;

		do {
			chExpected = isExpected.read();
			chActual = isActual.read();
		}
		while (chExpected == chActual && chExpected > 0 && chActual > 0);

		return chExpected == chActual;
	}
}
