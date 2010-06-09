/**
 * 
 */
package org.eclipse.epsilon.hutn.xmi.dt;

import java.util.Collection;

import org.eclipse.epsilon.commons.parse.problem.ParseProblem;

public interface ConformanceReporter {
	public void reportConformant(String name);

	public void reportNonConformant(String name, Collection<ParseProblem> conformanceProblems);
}