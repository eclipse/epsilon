/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.policies;

import org.eclipse.epsilon.eugenia.examples.fed.diagram.providers.FedElementTypes;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

/**
 * @generated
 */
public class FeatureDependsItemSemanticEditPolicy extends
		FedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FeatureDependsItemSemanticEditPolicy() {
		super(FedElementTypes.FeatureDepends_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
