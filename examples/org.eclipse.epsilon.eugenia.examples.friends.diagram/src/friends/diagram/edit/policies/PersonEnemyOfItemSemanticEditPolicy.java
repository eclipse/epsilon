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
public class PersonEnemyOfItemSemanticEditPolicy extends
		FriendsBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PersonEnemyOfItemSemanticEditPolicy() {
		super(FriendsElementTypes.PersonEnemyOf_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
