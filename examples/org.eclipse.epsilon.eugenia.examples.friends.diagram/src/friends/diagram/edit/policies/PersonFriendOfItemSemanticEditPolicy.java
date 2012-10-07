/*
 * 
 */
package friends.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;

import friends.diagram.providers.FriendsElementTypes;

/**
 * @generated
 */
public class PersonFriendOfItemSemanticEditPolicy extends
		FriendsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PersonFriendOfItemSemanticEditPolicy() {
		super(FriendsElementTypes.PersonFriendOf_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
