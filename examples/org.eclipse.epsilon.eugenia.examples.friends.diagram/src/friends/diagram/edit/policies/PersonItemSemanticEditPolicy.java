/*
 * 
 */
package friends.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

import friends.diagram.edit.commands.PersonEnemyOfCreateCommand;
import friends.diagram.edit.commands.PersonEnemyOfReorientCommand;
import friends.diagram.edit.commands.PersonFriendOfCreateCommand;
import friends.diagram.edit.commands.PersonFriendOfReorientCommand;
import friends.diagram.edit.parts.PersonEnemyOfEditPart;
import friends.diagram.edit.parts.PersonFriendOfEditPart;
import friends.diagram.part.FriendsVisualIDRegistry;
import friends.diagram.providers.FriendsElementTypes;

/**
 * @generated
 */
public class PersonItemSemanticEditPolicy extends
		FriendsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PersonItemSemanticEditPolicy() {
		super(FriendsElementTypes.Person_2001);
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
			if (FriendsVisualIDRegistry.getVisualID(incomingLink) == PersonFriendOfEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (FriendsVisualIDRegistry.getVisualID(incomingLink) == PersonEnemyOfEditPart.VISUAL_ID) {
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
			if (FriendsVisualIDRegistry.getVisualID(outgoingLink) == PersonFriendOfEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (FriendsVisualIDRegistry.getVisualID(outgoingLink) == PersonEnemyOfEditPart.VISUAL_ID) {
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
		if (FriendsElementTypes.PersonFriendOf_4001 == req.getElementType()) {
			return getGEFWrapper(new PersonFriendOfCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (FriendsElementTypes.PersonEnemyOf_4002 == req.getElementType()) {
			return getGEFWrapper(new PersonEnemyOfCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (FriendsElementTypes.PersonFriendOf_4001 == req.getElementType()) {
			return getGEFWrapper(new PersonFriendOfCreateCommand(req,
					req.getSource(), req.getTarget()));
		}
		if (FriendsElementTypes.PersonEnemyOf_4002 == req.getElementType()) {
			return getGEFWrapper(new PersonEnemyOfCreateCommand(req,
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
		case PersonFriendOfEditPart.VISUAL_ID:
			return getGEFWrapper(new PersonFriendOfReorientCommand(req));
		case PersonEnemyOfEditPart.VISUAL_ID:
			return getGEFWrapper(new PersonEnemyOfReorientCommand(req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
