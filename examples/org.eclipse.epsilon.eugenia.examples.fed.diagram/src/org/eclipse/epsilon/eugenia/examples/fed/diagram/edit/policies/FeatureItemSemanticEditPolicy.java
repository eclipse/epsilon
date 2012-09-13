/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.commands.FeatureDependsCreateCommand;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.commands.FeatureDependsReorientCommand;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.commands.FeatureIncludesCreateCommand;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.commands.FeatureIncludesReorientCommand;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureDependsEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureFeaturePluginsCompartmentEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.FeatureIncludesEditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.edit.parts.Plugin2EditPart;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.part.FedVisualIDRegistry;
import org.eclipse.epsilon.eugenia.examples.fed.diagram.providers.FedElementTypes;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class FeatureItemSemanticEditPolicy extends
		FedBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public FeatureItemSemanticEditPolicy() {
		super(FedElementTypes.Feature_2001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator<?> it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (FedVisualIDRegistry.getVisualID(incomingLink) == FeatureDependsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (FedVisualIDRegistry.getVisualID(incomingLink) == FeatureIncludesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator<?> it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (FedVisualIDRegistry.getVisualID(outgoingLink) == FeatureDependsEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (FedVisualIDRegistry.getVisualID(outgoingLink) == FeatureIncludesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyChildNodesCommand(cmd);
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	private void addDestroyChildNodesCommand(ICompositeCommand cmd) {
		View view = (View) getHost().getModel();
		for (Iterator<?> nit = view.getChildren().iterator(); nit.hasNext();) {
			Node node = (Node) nit.next();
			switch (FedVisualIDRegistry.getVisualID(node)) {
			case FeatureFeaturePluginsCompartmentEditPart.VISUAL_ID:
				for (Iterator<?> cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (FedVisualIDRegistry.getVisualID(cnode)) {
					case Plugin2EditPart.VISUAL_ID:
						cmd.add(new DestroyElementCommand(
								new DestroyElementRequest(getEditingDomain(),
										cnode.getElement(), false))); // directlyOwned: true
						// don't need explicit deletion of cnode as parent's view deletion would clean child views as well 
						// cmd.add(new org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand(getEditingDomain(), cnode));
						break;
					}
				}
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (FedElementTypes.FeatureDepends_4001 == req.getElementType()) {
			return getGEFWrapper(new FeatureDependsCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (FedElementTypes.FeatureIncludes_4002 == req.getElementType()) {
			return getGEFWrapper(new FeatureIncludesCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (FedElementTypes.FeatureDepends_4001 == req.getElementType()) {
			return getGEFWrapper(new FeatureDependsCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (FedElementTypes.FeatureIncludes_4002 == req.getElementType()) {
			return getGEFWrapper(new FeatureIncludesCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case FeatureDependsEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureDependsReorientCommand(req));
		case FeatureIncludesEditPart.VISUAL_ID:
			return getGEFWrapper(new FeatureIncludesReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
