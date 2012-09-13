/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.commands.FeatureCreateCommand;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.commands.PluginCreateCommand;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.providers.FedElementTypes;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

/**
 * @generated
 */
public class ConfigurationItemSemanticEditPolicy extends
		FedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ConfigurationItemSemanticEditPolicy() {
		super(FedElementTypes.Configuration_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (FedElementTypes.Feature_2001 == req.getElementType()) {
			return getGEFWrapper(new FeatureCreateCommand(req));
		}
		if (FedElementTypes.Plugin_2002 == req.getElementType()) {
			return getGEFWrapper(new PluginCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
