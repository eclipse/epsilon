/*
 * 
 */
package filesystem.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import filesystem.Drive;
import filesystem.File;
import filesystem.Filesystem;
import filesystem.FilesystemPackage;
import filesystem.Folder;
import filesystem.Shortcut;
import filesystem.Sync;
import filesystem.diagram.edit.parts.Drive2EditPart;
import filesystem.diagram.edit.parts.DriveDriveContentsCompartment2EditPart;
import filesystem.diagram.edit.parts.DriveDriveContentsCompartmentEditPart;
import filesystem.diagram.edit.parts.DriveEditPart;
import filesystem.diagram.edit.parts.FileEditPart;
import filesystem.diagram.edit.parts.FilesystemEditPart;
import filesystem.diagram.edit.parts.FolderEditPart;
import filesystem.diagram.edit.parts.FolderFolderContentsCompartmentEditPart;
import filesystem.diagram.edit.parts.ShortcutEditPart;
import filesystem.diagram.edit.parts.ShortcutTargetEditPart;
import filesystem.diagram.edit.parts.SyncEditPart;
import filesystem.diagram.providers.FilesystemElementTypes;

/**
 * @generated
 */
public class FilesystemDiagramUpdater {

	/**
	 * @generated
	 */
	public static boolean isShortcutOrphaned(View view) {
		return !view.isSetElement() || view.getElement() == null
				|| view.getElement().eIsProxy();
	}

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {
		case DriveDriveContentsCompartmentEditPart.VISUAL_ID:
			return getDriveDriveContentsCompartment_7001SemanticChildren(view);
		case DriveDriveContentsCompartment2EditPart.VISUAL_ID:
			return getDriveDriveContentsCompartment_7002SemanticChildren(view);
		case FolderFolderContentsCompartmentEditPart.VISUAL_ID:
			return getFolderFolderContentsCompartment_7003SemanticChildren(view);
		case FilesystemEditPart.VISUAL_ID:
			return getFilesystem_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDriveDriveContentsCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Drive modelElement = (Drive) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getContents().iterator(); it.hasNext();) {
			File childElement = (File) it.next();
			int visualID = FilesystemVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Drive2EditPart.VISUAL_ID) {
				result
						.add(new FilesystemNodeDescriptor(childElement,
								visualID));
				continue;
			}
			if (visualID == FolderEditPart.VISUAL_ID) {
				result
						.add(new FilesystemNodeDescriptor(childElement,
								visualID));
				continue;
			}
			if (visualID == ShortcutEditPart.VISUAL_ID) {
				result
						.add(new FilesystemNodeDescriptor(childElement,
								visualID));
				continue;
			}
			if (visualID == FileEditPart.VISUAL_ID) {
				result
						.add(new FilesystemNodeDescriptor(childElement,
								visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDriveDriveContentsCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Drive modelElement = (Drive) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getContents().iterator(); it.hasNext();) {
			File childElement = (File) it.next();
			int visualID = FilesystemVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Drive2EditPart.VISUAL_ID) {
				result
						.add(new FilesystemNodeDescriptor(childElement,
								visualID));
				continue;
			}
			if (visualID == FolderEditPart.VISUAL_ID) {
				result
						.add(new FilesystemNodeDescriptor(childElement,
								visualID));
				continue;
			}
			if (visualID == ShortcutEditPart.VISUAL_ID) {
				result
						.add(new FilesystemNodeDescriptor(childElement,
								visualID));
				continue;
			}
			if (visualID == FileEditPart.VISUAL_ID) {
				result
						.add(new FilesystemNodeDescriptor(childElement,
								visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFolderFolderContentsCompartment_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Folder modelElement = (Folder) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getContents().iterator(); it.hasNext();) {
			File childElement = (File) it.next();
			int visualID = FilesystemVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Drive2EditPart.VISUAL_ID) {
				result
						.add(new FilesystemNodeDescriptor(childElement,
								visualID));
				continue;
			}
			if (visualID == FolderEditPart.VISUAL_ID) {
				result
						.add(new FilesystemNodeDescriptor(childElement,
								visualID));
				continue;
			}
			if (visualID == ShortcutEditPart.VISUAL_ID) {
				result
						.add(new FilesystemNodeDescriptor(childElement,
								visualID));
				continue;
			}
			if (visualID == FileEditPart.VISUAL_ID) {
				result
						.add(new FilesystemNodeDescriptor(childElement,
								visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFilesystem_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Filesystem modelElement = (Filesystem) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getDrives().iterator(); it.hasNext();) {
			Drive childElement = (Drive) it.next();
			int visualID = FilesystemVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == DriveEditPart.VISUAL_ID) {
				result
						.add(new FilesystemNodeDescriptor(childElement,
								visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {
		case FilesystemEditPart.VISUAL_ID:
			return getFilesystem_1000ContainedLinks(view);
		case DriveEditPart.VISUAL_ID:
			return getDrive_2001ContainedLinks(view);
		case Drive2EditPart.VISUAL_ID:
			return getDrive_3001ContainedLinks(view);
		case FolderEditPart.VISUAL_ID:
			return getFolder_3002ContainedLinks(view);
		case ShortcutEditPart.VISUAL_ID:
			return getShortcut_3003ContainedLinks(view);
		case FileEditPart.VISUAL_ID:
			return getFile_3004ContainedLinks(view);
		case SyncEditPart.VISUAL_ID:
			return getSync_4001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {
		case DriveEditPart.VISUAL_ID:
			return getDrive_2001IncomingLinks(view);
		case Drive2EditPart.VISUAL_ID:
			return getDrive_3001IncomingLinks(view);
		case FolderEditPart.VISUAL_ID:
			return getFolder_3002IncomingLinks(view);
		case ShortcutEditPart.VISUAL_ID:
			return getShortcut_3003IncomingLinks(view);
		case FileEditPart.VISUAL_ID:
			return getFile_3004IncomingLinks(view);
		case SyncEditPart.VISUAL_ID:
			return getSync_4001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {
		case DriveEditPart.VISUAL_ID:
			return getDrive_2001OutgoingLinks(view);
		case Drive2EditPart.VISUAL_ID:
			return getDrive_3001OutgoingLinks(view);
		case FolderEditPart.VISUAL_ID:
			return getFolder_3002OutgoingLinks(view);
		case ShortcutEditPart.VISUAL_ID:
			return getShortcut_3003OutgoingLinks(view);
		case FileEditPart.VISUAL_ID:
			return getFile_3004OutgoingLinks(view);
		case SyncEditPart.VISUAL_ID:
			return getSync_4001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFilesystem_1000ContainedLinks(View view) {
		Filesystem modelElement = (Filesystem) view.getElement();
		List result = new LinkedList();
		result.addAll(getContainedTypeModelFacetLinks_Sync_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDrive_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDrive_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFolder_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getShortcut_3003ContainedLinks(View view) {
		Shortcut modelElement = (Shortcut) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Shortcut_Target_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFile_3004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getSync_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDrive_2001IncomingLinks(View view) {
		Drive modelElement = (Drive) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Sync_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Shortcut_Target_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDrive_3001IncomingLinks(View view) {
		Drive modelElement = (Drive) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Sync_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Shortcut_Target_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFolder_3002IncomingLinks(View view) {
		Folder modelElement = (Folder) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Sync_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Shortcut_Target_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getShortcut_3003IncomingLinks(View view) {
		Shortcut modelElement = (Shortcut) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Sync_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Shortcut_Target_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFile_3004IncomingLinks(View view) {
		File modelElement = (File) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Sync_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Shortcut_Target_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSync_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getDrive_2001OutgoingLinks(View view) {
		Drive modelElement = (Drive) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Sync_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getDrive_3001OutgoingLinks(View view) {
		Drive modelElement = (Drive) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Sync_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFolder_3002OutgoingLinks(View view) {
		Folder modelElement = (Folder) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Sync_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getShortcut_3003OutgoingLinks(View view) {
		Shortcut modelElement = (Shortcut) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Sync_4001(modelElement));
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Shortcut_Target_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFile_3004OutgoingLinks(View view) {
		File modelElement = (File) view.getElement();
		List result = new LinkedList();
		result.addAll(getOutgoingTypeModelFacetLinks_Sync_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getSync_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Sync_4001(
			Filesystem container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getSyncs().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Sync) {
				continue;
			}
			Sync link = (Sync) linkObject;
			if (SyncEditPart.VISUAL_ID != FilesystemVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			File dst = link.getTarget();
			File src = link.getSource();
			result.add(new FilesystemLinkDescriptor(src, dst, link,
					FilesystemElementTypes.Sync_4001, SyncEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Sync_4001(
			File target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != FilesystemPackage.eINSTANCE
					.getSync_Target()
					|| false == setting.getEObject() instanceof Sync) {
				continue;
			}
			Sync link = (Sync) setting.getEObject();
			if (SyncEditPart.VISUAL_ID != FilesystemVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			File src = link.getSource();
			result.add(new FilesystemLinkDescriptor(src, target, link,
					FilesystemElementTypes.Sync_4001, SyncEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Shortcut_Target_4002(
			File target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == FilesystemPackage.eINSTANCE
					.getShortcut_Target()) {
				result.add(new FilesystemLinkDescriptor(setting.getEObject(),
						target, FilesystemElementTypes.ShortcutTarget_4002,
						ShortcutTargetEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Sync_4001(
			File source) {
		Filesystem container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Filesystem) {
				container = (Filesystem) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getSyncs().iterator(); links.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Sync) {
				continue;
			}
			Sync link = (Sync) linkObject;
			if (SyncEditPart.VISUAL_ID != FilesystemVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			File dst = link.getTarget();
			File src = link.getSource();
			if (src != source) {
				continue;
			}
			result.add(new FilesystemLinkDescriptor(src, dst, link,
					FilesystemElementTypes.Sync_4001, SyncEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Shortcut_Target_4002(
			Shortcut source) {
		Collection result = new LinkedList();
		File destination = source.getTarget();
		if (destination == null) {
			return result;
		}
		result.add(new FilesystemLinkDescriptor(source, destination,
				FilesystemElementTypes.ShortcutTarget_4002,
				ShortcutTargetEditPart.VISUAL_ID));
		return result;
	}

}
