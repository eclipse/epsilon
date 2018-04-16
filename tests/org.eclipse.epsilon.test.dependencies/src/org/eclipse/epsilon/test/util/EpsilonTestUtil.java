package org.eclipse.epsilon.test.util;

import static org.junit.Assert.fail;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Objects;

public class EpsilonTestUtil {
	private EpsilonTestUtil() {}
	
	/**
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
	
	/**
	 * 
	 * @param condition
	 * @param expected
	 * @param actual
	 * @param dataLabel
	 * @return The condition
	 */
	public static <T> boolean failIfDifferent(boolean condition, T expected, T actual, String dataLabel) {
		if (condition) {
			String intermediary, message = "";
			
			System.err.println(intermediary = dataLabel+" differ! ");
			message += intermediary;
			System.out.println(intermediary = "Expected "+expected.getClass().getSimpleName()+": ");
			message += intermediary;
			System.out.println(intermediary = Objects.toString(expected));
			message += intermediary+", ";
			System.out.println(intermediary = "Actual "+actual.getClass().getSimpleName()+": ");
			message += intermediary;
			System.out.println(intermediary = Objects.toString(actual));
			message += intermediary;
			System.out.println();
			
			fail(message);
		}
		return condition;
	}
	
	/**
	 * Tests the two collections for equality, irrespective of ordering.
	 * @param expected
	 * @param actual
	 * @param collectionName
	 * @return Whether the collections have the same elements.
	 */
	public static boolean testCollectionsHaveSameElements(Collection<?> expected, Collection<?> actual, String collectionName) {
		int actualSize = actual.size(), expectedSize = expected.size();
		return !(
			failIfDifferent(actualSize != expectedSize, expectedSize, actualSize, collectionName) &&
			failIfDifferent(!actual.containsAll(expected), expected, actual, collectionName)
		);
	}
}
