/*
 * 
 */
package filesystem.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import filesystem.Filesystem;
import filesystem.FilesystemPackage;
import filesystem.diagram.edit.parts.Drive2EditPart;
import filesystem.diagram.edit.parts.DriveDriveContentsCompartment2EditPart;
import filesystem.diagram.edit.parts.DriveDriveContentsCompartmentEditPart;
import filesystem.diagram.edit.parts.DriveEditPart;
import filesystem.diagram.edit.parts.DriveName2EditPart;
import filesystem.diagram.edit.parts.DriveNameEditPart;
import filesystem.diagram.edit.parts.FileEditPart;
import filesystem.diagram.edit.parts.FileNameEditPart;
import filesystem.diagram.edit.parts.FilesystemEditPart;
import filesystem.diagram.edit.parts.FolderEditPart;
import filesystem.diagram.edit.parts.FolderFolderContentsCompartmentEditPart;
import filesystem.diagram.edit.parts.FolderNameEditPart;
import filesystem.diagram.edit.parts.ShortcutEditPart;
import filesystem.diagram.edit.parts.ShortcutNameEditPart;
import filesystem.diagram.edit.parts.ShortcutTargetEditPart;
import filesystem.diagram.edit.parts.SyncEditPart;
import filesystem.diagram.edit.parts.SyncLastSyncEditPart;
import filesystem.diagram.edit.parts.WrappingLabelEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class FilesystemVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.eclipse.epsilon.eugenia.examples.filesystem.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (FilesystemEditPart.MODEL_ID.equals(view.getType())) {
				return FilesystemEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return filesystem.diagram.part.FilesystemVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				FilesystemDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (FilesystemPackage.eINSTANCE.getFilesystem().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Filesystem) domainElement)) {
			return FilesystemEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = filesystem.diagram.part.FilesystemVisualIDRegistry
				.getModelID(containerView);
		if (!FilesystemEditPart.MODEL_ID.equals(containerModelID)
				&& !"filesystem".equals(containerModelID)) { //$NON-NLS-1$
			return -1;
		}
		int containerVisualID;
		if (FilesystemEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = filesystem.diagram.part.FilesystemVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = FilesystemEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case DriveDriveContentsCompartmentEditPart.VISUAL_ID:
			if (FilesystemPackage.eINSTANCE.getDrive().isSuperTypeOf(
					domainElement.eClass())) {
				return Drive2EditPart.VISUAL_ID;
			}
			if (FilesystemPackage.eINSTANCE.getFolder().isSuperTypeOf(
					domainElement.eClass())) {
				return FolderEditPart.VISUAL_ID;
			}
			if (FilesystemPackage.eINSTANCE.getShortcut().isSuperTypeOf(
					domainElement.eClass())) {
				return ShortcutEditPart.VISUAL_ID;
			}
			if (FilesystemPackage.eINSTANCE.getFile().isSuperTypeOf(
					domainElement.eClass())) {
				return FileEditPart.VISUAL_ID;
			}
			break;
		case DriveDriveContentsCompartment2EditPart.VISUAL_ID:
			if (FilesystemPackage.eINSTANCE.getDrive().isSuperTypeOf(
					domainElement.eClass())) {
				return Drive2EditPart.VISUAL_ID;
			}
			if (FilesystemPackage.eINSTANCE.getFolder().isSuperTypeOf(
					domainElement.eClass())) {
				return FolderEditPart.VISUAL_ID;
			}
			if (FilesystemPackage.eINSTANCE.getShortcut().isSuperTypeOf(
					domainElement.eClass())) {
				return ShortcutEditPart.VISUAL_ID;
			}
			if (FilesystemPackage.eINSTANCE.getFile().isSuperTypeOf(
					domainElement.eClass())) {
				return FileEditPart.VISUAL_ID;
			}
			break;
		case FolderFolderContentsCompartmentEditPart.VISUAL_ID:
			if (FilesystemPackage.eINSTANCE.getDrive().isSuperTypeOf(
					domainElement.eClass())) {
				return Drive2EditPart.VISUAL_ID;
			}
			if (FilesystemPackage.eINSTANCE.getFolder().isSuperTypeOf(
					domainElement.eClass())) {
				return FolderEditPart.VISUAL_ID;
			}
			if (FilesystemPackage.eINSTANCE.getShortcut().isSuperTypeOf(
					domainElement.eClass())) {
				return ShortcutEditPart.VISUAL_ID;
			}
			if (FilesystemPackage.eINSTANCE.getFile().isSuperTypeOf(
					domainElement.eClass())) {
				return FileEditPart.VISUAL_ID;
			}
			break;
		case FilesystemEditPart.VISUAL_ID:
			if (FilesystemPackage.eINSTANCE.getDrive().isSuperTypeOf(
					domainElement.eClass())) {
				return DriveEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = filesystem.diagram.part.FilesystemVisualIDRegistry
				.getModelID(containerView);
		if (!FilesystemEditPart.MODEL_ID.equals(containerModelID)
				&& !"filesystem".equals(containerModelID)) { //$NON-NLS-1$
			return false;
		}
		int containerVisualID;
		if (FilesystemEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = filesystem.diagram.part.FilesystemVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = FilesystemEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case DriveEditPart.VISUAL_ID:
			if (DriveNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DriveDriveContentsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Drive2EditPart.VISUAL_ID:
			if (DriveName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DriveDriveContentsCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FolderEditPart.VISUAL_ID:
			if (FolderNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FolderFolderContentsCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ShortcutEditPart.VISUAL_ID:
			if (ShortcutNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FileEditPart.VISUAL_ID:
			if (FileNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DriveDriveContentsCompartmentEditPart.VISUAL_ID:
			if (Drive2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FolderEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ShortcutEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FileEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DriveDriveContentsCompartment2EditPart.VISUAL_ID:
			if (Drive2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FolderEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ShortcutEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FileEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FolderFolderContentsCompartmentEditPart.VISUAL_ID:
			if (Drive2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FolderEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ShortcutEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FileEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case FilesystemEditPart.VISUAL_ID:
			if (DriveEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SyncEditPart.VISUAL_ID:
			if (SyncLastSyncEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ShortcutTargetEditPart.VISUAL_ID:
			if (WrappingLabelEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (FilesystemPackage.eINSTANCE.getSync().isSuperTypeOf(
				domainElement.eClass())) {
			return SyncEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Filesystem element) {
		return true;
	}

}
