/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package friends.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.View;
import friends.diagram.edit.commands.PersonEnemyOfCreateCommand;
import friends.diagram.edit.commands.PersonEnemyOfReorientCommand;
import friends.diagram.edit.commands.PersonFriendOfCreateCommand;
import friends.diagram.edit.commands.PersonFriendOfReorientCommand;
import friends.diagram.edit.parts.PersonEnemyOfEditPart;
import friends.diagram.edit.parts.PersonFriendOfEditPart;
import friends.diagram.providers.FriendsElementTypes;

/**
 * @generated
 */
public class PersonItemSemanticEditPolicy extends
		FriendsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
		View view = (View) getHost().getModel();
		if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
			req.setElementToDestroy(view);
		}
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
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
		if (FriendsElementTypes.PersonFriendOf_3001 == req.getElementType()) {
			return getGEFWrapper(new PersonFriendOfCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (FriendsElementTypes.PersonEnemyOf_3002 == req.getElementType()) {
			return getGEFWrapper(new PersonEnemyOfCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (FriendsElementTypes.PersonFriendOf_3001 == req.getElementType()) {
			return getGEFWrapper(new PersonFriendOfCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (FriendsElementTypes.PersonEnemyOf_3002 == req.getElementType()) {
			return getGEFWrapper(new PersonEnemyOfCreateCommand(req, req
					.getSource(), req.getTarget()));
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
