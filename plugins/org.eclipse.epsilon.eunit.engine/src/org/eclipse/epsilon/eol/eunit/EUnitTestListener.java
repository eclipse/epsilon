package org.eclipse.epsilon.eol.eunit;

/**
 * Simple interface for objects which receive notifications regarding the
 * progress of a test suite.
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public interface EUnitTestListener {

	/**
	 * Notification sent before running a test case.
	 * @param module EUnit module under execution.
	 * @param test Description of the test case: its result has not been set yet.
	 */
	void beforeCase(EUnitModule module, EUnitTest test);

	/**
	 * Notification sent after running a test case.
	 * @param module EUnit module under execution.
	 * @param test Test case, with its result set.
	 */
	void afterCase(EUnitModule module, EUnitTest test);

}
