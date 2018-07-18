/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks.eugenia;

import org.eclipse.epsilon.eugenia.EugeniaActionDelegateStep;

/**
 * Nested element for the Eugenia Ant task which represents an extra model
 * to be used in one of the polishing transformations.
 */
public class EugeniaExtraModel {

	private String sRef, sAs;
	private EugeniaActionDelegateStep step;

	/**
	 * Changes the name of the model in the project repository to be used. This
	 * attribute is mandatory.
	 * @param sRef Name to be used to find the model in the project repository.
	 */
	public void setRef(String sRef) {
		this.sRef = sRef;
	}

	/**
	 * Returns the name of the model in the project repository to be used.
	 */
	public String getRef() {
		return sRef;
	}

	/**
	 * Changes the name of the model to be used inside the polishing transformation.
	 * This attribute is optional: if not set, the value of the "ref" attribute will
	 * be used.
	 * @param sRef Name to be used inside the polishing transformation.
	 */
	public void setAs(String sAs) {
		this.sAs = sAs;
	}

	/**
	 * Returns the name of the model to be used inside the polishing transformation.
	 */
	public String getAs() {
		return sAs;
	}

	/**
	 * Changes the step at which this model will be added, if applicable.
	 */
	public void setStep(EugeniaActionDelegateStep step) {
		this.step = step;
	}

	/**
	 * Returns the step at which this model will be added, if applicable.
	 */
	public EugeniaActionDelegateStep getStep() {
		return step;
	}

}
