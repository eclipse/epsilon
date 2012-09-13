/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.policies;

import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.commands.Plugin2CreateCommand;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.providers.FedElementTypes;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class FeatureFeaturePluginsCompartmentItemSemanticEditPolicy extends
		FedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FeatureFeaturePluginsCompartmentItemSemanticEditPolicy() {
		super(FedElementTypes.Feature_2001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (FedElementTypes.Plugin_3001 == req.getElementType()) {
			return getGEFWrapper(new Plugin2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
