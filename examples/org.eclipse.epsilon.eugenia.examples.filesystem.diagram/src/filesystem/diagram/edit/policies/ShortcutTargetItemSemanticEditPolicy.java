/*
 * 
 */
package filesystem.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import filesystem.diagram.providers.FilesystemElementTypes;

/**
 * @generated
 */
public class ShortcutTargetItemSemanticEditPolicy extends
		FilesystemBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ShortcutTargetItemSemanticEditPolicy() {
		super(FilesystemElementTypes.ShortcutTarget_4002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {
		return getGEFWrapper(new DestroyReferenceCommand(req));
	}

}
