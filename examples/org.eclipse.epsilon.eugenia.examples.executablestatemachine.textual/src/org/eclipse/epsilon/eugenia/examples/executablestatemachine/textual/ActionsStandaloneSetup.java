
package org.eclipse.epsilon.eugenia.examples.executablestatemachine.textual;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ActionsStandaloneSetup extends ActionsStandaloneSetupGenerated{

	public static void doSetup() {
		new ActionsStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

