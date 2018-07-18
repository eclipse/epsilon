/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eugenia;

/**
 * Names of the different steps in the Eugenia workflow. Useful in
 * {@link GenerateAllDelegate#setLastStep(EugeniaActionDelegateStep)}.
 * 
 * Please note that these enum values must be kept in the same order
 * as the steps in Eugenia. We use lowercase names instead of the
 * usual uppercase names so the Ant tasks look nicer.
 */
public enum EugeniaActionDelegateStep {
	clean,
	ecore,
	annotate,
	validateforgenmodel,
	validateforgmf,
	genmodel,
	gmf,
	gmfgen,
	emfcode,
	gmfcode,
	generatepatches,
	applypatches,
	unapplypatches
}
