/*
 * 
 */
package filesystem.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import filesystem.FilesystemPackage;
import filesystem.diagram.edit.commands.Drive2CreateCommand;
import filesystem.diagram.edit.commands.FileCreateCommand;
import filesystem.diagram.edit.commands.FolderCreateCommand;
import filesystem.diagram.edit.commands.ShortcutCreateCommand;
import filesystem.diagram.providers.FilesystemElementTypes;

/**
 * @generated
 */
public class DriveDriveContentsCompartment2ItemSemanticEditPolicy extends
		FilesystemBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DriveDriveContentsCompartment2ItemSemanticEditPolicy() {
		super(FilesystemElementTypes.Drive_3001);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (FilesystemElementTypes.Drive_3001 == req.getElementType()) {
			return getGEFWrapper(new Drive2CreateCommand(req));
		}
		if (FilesystemElementTypes.Folder_3002 == req.getElementType()) {
			return getGEFWrapper(new FolderCreateCommand(req));
		}
		if (FilesystemElementTypes.Shortcut_3003 == req.getElementType()) {
			return getGEFWrapper(new ShortcutCreateCommand(req));
		}
		if (FilesystemElementTypes.File_3004 == req.getElementType()) {
			return getGEFWrapper(new FileCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
