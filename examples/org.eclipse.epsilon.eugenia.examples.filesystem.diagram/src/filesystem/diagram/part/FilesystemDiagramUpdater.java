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

import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
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
	public static List<FilesystemNodeDescriptor> getSemanticChildren(View view) {
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {
		case FilesystemEditPart.VISUAL_ID:
			return getFilesystem_1000SemanticChildren(view);
		case DriveDriveContentsCompartmentEditPart.VISUAL_ID:
			return getDriveDriveContentsCompartment_7001SemanticChildren(view);
		case DriveDriveContentsCompartment2EditPart.VISUAL_ID:
			return getDriveDriveContentsCompartment_7002SemanticChildren(view);
		case FolderFolderContentsCompartmentEditPart.VISUAL_ID:
			return getFolderFolderContentsCompartment_7003SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FilesystemNodeDescriptor> getDriveDriveContentsCompartment_7001SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Drive modelElement = (Drive) containerView.getElement();
		LinkedList<FilesystemNodeDescriptor> result = new LinkedList<FilesystemNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContents().iterator(); it
				.hasNext();) {
			File childElement = (File) it.next();
			int visualID = FilesystemVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Drive2EditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FolderEditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ShortcutEditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FileEditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemNodeDescriptor> getDriveDriveContentsCompartment_7002SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Drive modelElement = (Drive) containerView.getElement();
		LinkedList<FilesystemNodeDescriptor> result = new LinkedList<FilesystemNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContents().iterator(); it
				.hasNext();) {
			File childElement = (File) it.next();
			int visualID = FilesystemVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Drive2EditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FolderEditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ShortcutEditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FileEditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemNodeDescriptor> getFolderFolderContentsCompartment_7003SemanticChildren(
			View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.emptyList();
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.emptyList();
		}
		Folder modelElement = (Folder) containerView.getElement();
		LinkedList<FilesystemNodeDescriptor> result = new LinkedList<FilesystemNodeDescriptor>();
		for (Iterator<?> it = modelElement.getContents().iterator(); it
				.hasNext();) {
			File childElement = (File) it.next();
			int visualID = FilesystemVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Drive2EditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FolderEditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == ShortcutEditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
			if (visualID == FileEditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemNodeDescriptor> getFilesystem_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Filesystem modelElement = (Filesystem) view.getElement();
		LinkedList<FilesystemNodeDescriptor> result = new LinkedList<FilesystemNodeDescriptor>();
		for (Iterator<?> it = modelElement.getDrives().iterator(); it.hasNext();) {
			Drive childElement = (Drive) it.next();
			int visualID = FilesystemVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == DriveEditPart.VISUAL_ID) {
				result.add(new FilesystemNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getContainedLinks(View view) {
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
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getIncomingLinks(View view) {
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
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getOutgoingLinks(View view) {
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
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFilesystem_1000ContainedLinks(
			View view) {
		Filesystem modelElement = (Filesystem) view.getElement();
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getContainedTypeModelFacetLinks_Sync_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getDrive_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getDrive_3001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFolder_3002ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getShortcut_3003ContainedLinks(
			View view) {
		Shortcut modelElement = (Shortcut) view.getElement();
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getOutgoingFeatureModelFacetLinks_Shortcut_Target_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFile_3004ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getSync_4001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getDrive_2001IncomingLinks(
			View view) {
		Drive modelElement = (Drive) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Sync_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Shortcut_Target_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getDrive_3001IncomingLinks(
			View view) {
		Drive modelElement = (Drive) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Sync_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Shortcut_Target_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFolder_3002IncomingLinks(
			View view) {
		Folder modelElement = (Folder) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Sync_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Shortcut_Target_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getShortcut_3003IncomingLinks(
			View view) {
		Shortcut modelElement = (Shortcut) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Sync_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Shortcut_Target_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFile_3004IncomingLinks(
			View view) {
		File modelElement = (File) view.getElement();
		Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences = EcoreUtil.CrossReferencer
				.find(view.eResource().getResourceSet().getResources());
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getIncomingTypeModelFacetLinks_Sync_4001(modelElement,
				crossReferences));
		result.addAll(getIncomingFeatureModelFacetLinks_Shortcut_Target_4002(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getSync_4001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getDrive_2001OutgoingLinks(
			View view) {
		Drive modelElement = (Drive) view.getElement();
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Sync_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getDrive_3001OutgoingLinks(
			View view) {
		Drive modelElement = (Drive) view.getElement();
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Sync_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFolder_3002OutgoingLinks(
			View view) {
		Folder modelElement = (Folder) view.getElement();
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Sync_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getShortcut_3003OutgoingLinks(
			View view) {
		Shortcut modelElement = (Shortcut) view.getElement();
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Sync_4001(modelElement));
		result.addAll(getOutgoingFeatureModelFacetLinks_Shortcut_Target_4002(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getFile_3004OutgoingLinks(
			View view) {
		File modelElement = (File) view.getElement();
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		result.addAll(getOutgoingTypeModelFacetLinks_Sync_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List<FilesystemLinkDescriptor> getSync_4001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	private static Collection<FilesystemLinkDescriptor> getContainedTypeModelFacetLinks_Sync_4001(
			Filesystem container) {
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		for (Iterator<?> links = container.getSyncs().iterator(); links
				.hasNext();) {
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
	private static Collection<FilesystemLinkDescriptor> getIncomingTypeModelFacetLinks_Sync_4001(
			File target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
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
	private static Collection<FilesystemLinkDescriptor> getIncomingFeatureModelFacetLinks_Shortcut_Target_4002(
			File target,
			Map<EObject, Collection<EStructuralFeature.Setting>> crossReferences) {
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		Collection<EStructuralFeature.Setting> settings = crossReferences
				.get(target);
		for (EStructuralFeature.Setting setting : settings) {
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
	private static Collection<FilesystemLinkDescriptor> getOutgoingTypeModelFacetLinks_Sync_4001(
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
			return Collections.emptyList();
		}
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		for (Iterator<?> links = container.getSyncs().iterator(); links
				.hasNext();) {
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
	private static Collection<FilesystemLinkDescriptor> getOutgoingFeatureModelFacetLinks_Shortcut_Target_4002(
			Shortcut source) {
		LinkedList<FilesystemLinkDescriptor> result = new LinkedList<FilesystemLinkDescriptor>();
		File destination = source.getTarget();
		if (destination == null) {
			return result;
		}
		result.add(new FilesystemLinkDescriptor(source, destination,
				FilesystemElementTypes.ShortcutTarget_4002,
				ShortcutTargetEditPart.VISUAL_ID));
		return result;
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<FilesystemNodeDescriptor> getSemanticChildren(View view) {
			return FilesystemDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<FilesystemLinkDescriptor> getContainedLinks(View view) {
			return FilesystemDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<FilesystemLinkDescriptor> getIncomingLinks(View view) {
			return FilesystemDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<FilesystemLinkDescriptor> getOutgoingLinks(View view) {
			return FilesystemDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
