/*
 * 
 */
package filesystem.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import filesystem.diagram.edit.parts.Drive2EditPart;
import filesystem.diagram.edit.parts.DriveDriveContentsCompartment2EditPart;
import filesystem.diagram.edit.parts.DriveDriveContentsCompartmentEditPart;
import filesystem.diagram.edit.parts.DriveEditPart;
import filesystem.diagram.edit.parts.FileEditPart;
import filesystem.diagram.edit.parts.FilesystemEditPart;
import filesystem.diagram.edit.parts.FolderEditPart;
import filesystem.diagram.edit.parts.FolderFolderContentsCompartmentEditPart;
import filesystem.diagram.edit.parts.ShortcutEditPart;
import filesystem.diagram.part.FilesystemDiagramEditorPlugin;
import filesystem.diagram.part.Messages;

/**
 * @generated
 */
public class FilesystemModelingAssistantProvider extends
		ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof DriveDriveContentsCompartmentEditPart) {
			ArrayList types = new ArrayList(4);
			types.add(FilesystemElementTypes.Drive_3001);
			types.add(FilesystemElementTypes.Folder_3002);
			types.add(FilesystemElementTypes.Shortcut_3003);
			types.add(FilesystemElementTypes.File_3004);
			return types;
		}
		if (editPart instanceof DriveDriveContentsCompartment2EditPart) {
			ArrayList types = new ArrayList(4);
			types.add(FilesystemElementTypes.Drive_3001);
			types.add(FilesystemElementTypes.Folder_3002);
			types.add(FilesystemElementTypes.Shortcut_3003);
			types.add(FilesystemElementTypes.File_3004);
			return types;
		}
		if (editPart instanceof FolderFolderContentsCompartmentEditPart) {
			ArrayList types = new ArrayList(4);
			types.add(FilesystemElementTypes.Drive_3001);
			types.add(FilesystemElementTypes.Folder_3002);
			types.add(FilesystemElementTypes.Shortcut_3003);
			types.add(FilesystemElementTypes.File_3004);
			return types;
		}
		if (editPart instanceof FilesystemEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(FilesystemElementTypes.Drive_2001);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof DriveEditPart) {
			return ((DriveEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Drive2EditPart) {
			return ((Drive2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FolderEditPart) {
			return ((FolderEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ShortcutEditPart) {
			return ((ShortcutEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FileEditPart) {
			return ((FileEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof DriveEditPart) {
			return ((DriveEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Drive2EditPart) {
			return ((Drive2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FolderEditPart) {
			return ((FolderEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ShortcutEditPart) {
			return ((ShortcutEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FileEditPart) {
			return ((FileEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof DriveEditPart) {
			return ((DriveEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Drive2EditPart) {
			return ((Drive2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FolderEditPart) {
			return ((FolderEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ShortcutEditPart) {
			return ((ShortcutEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FileEditPart) {
			return ((FileEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof DriveEditPart) {
			return ((DriveEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Drive2EditPart) {
			return ((Drive2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FolderEditPart) {
			return ((FolderEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ShortcutEditPart) {
			return ((ShortcutEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FileEditPart) {
			return ((FileEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof DriveEditPart) {
			return ((DriveEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Drive2EditPart) {
			return ((Drive2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FolderEditPart) {
			return ((FolderEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ShortcutEditPart) {
			return ((ShortcutEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FileEditPart) {
			return ((FileEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target,
				relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source,
				relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				FilesystemDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(Messages.FilesystemModelingAssistantProviderMessage);
		dialog.setTitle(Messages.FilesystemModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
