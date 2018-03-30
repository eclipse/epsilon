package org.eclipse.epsilon.test.util;

import static org.junit.Assert.fail;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Collection;

public class EpsilonTestUtil {
	private EpsilonTestUtil() {}
	
	/*
	 * Convenience hack for handling exceptions when resolving this class's package source directory.
	 */
	public static String getTestBaseDir(Class<?> clazz) {
		try {
			return Paths.get(clazz.getResource("").toURI()).toString().replace("bin", "src")+'/';
		}
		catch (URISyntaxException urx) {
			System.err.println(urx.getMessage());
			return null;
		}
	}
	
	public static <T> void failIfDifferent(boolean condition, T expected, T actual) {
		if (condition) {
			String datatype = expected.getClass().getSimpleName();
			System.err.println();
			System.out.println("Expected "+datatype+": ");
			System.out.println(expected);
			System.out.println(); System.err.println();
			System.out.println("Actual "+datatype+": ");
			System.out.println(actual);
			
			fail(datatype+"s differ!");
		}
	}
	
	public static void testCollectionsHaveSameElements(Collection<?> expected, Collection<?> actual) {
		boolean sizesDiffer = actual.size() != expected.size();
		boolean contentsDiffer = !actual.containsAll(expected);
		
		failIfDifferent(sizesDiffer || contentsDiffer, expected, actual);
	}
}
