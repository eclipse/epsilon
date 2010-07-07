package org.eclipse.epsilon.eol.execute.operations.contributors.compatibility;

import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributor;

public class StringCompatibilityOperationContributor extends OperationContributor {

	@Override
	public boolean contributesTo(Object target) {
		return target instanceof String;
	}

	/**
	 * In the previous version of EOL, EolString.replace
	 * mapped to String.replaceAll.
	 * @param regex
	 * @param replacement
	 * @return
	 */
	public String replace(String regex, String replacement) {
		return ((String) target).replaceAll(regex, replacement);
	}
	
}
