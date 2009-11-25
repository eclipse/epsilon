/*
 * 
 */
package filesystem.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import filesystem.FilesystemPackage;
import filesystem.diagram.edit.parts.Drive2EditPart;
import filesystem.diagram.edit.parts.DriveEditPart;
import filesystem.diagram.edit.parts.FileEditPart;
import filesystem.diagram.edit.parts.FilesystemEditPart;
import filesystem.diagram.edit.parts.FolderEditPart;
import filesystem.diagram.edit.parts.ShortcutEditPart;
import filesystem.diagram.edit.parts.ShortcutTargetEditPart;
import filesystem.diagram.edit.parts.SyncEditPart;
import filesystem.diagram.part.FilesystemDiagramEditorPlugin;

/**
 * @generated
 */
public class FilesystemElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private FilesystemElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Filesystem_1000 = getElementType("org.eclipse.epsilon.eugenia.examples.filesystem.diagram.Filesystem_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Drive_2001 = getElementType("org.eclipse.epsilon.eugenia.examples.filesystem.diagram.Drive_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Drive_3001 = getElementType("org.eclipse.epsilon.eugenia.examples.filesystem.diagram.Drive_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Folder_3002 = getElementType("org.eclipse.epsilon.eugenia.examples.filesystem.diagram.Folder_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Shortcut_3003 = getElementType("org.eclipse.epsilon.eugenia.examples.filesystem.diagram.Shortcut_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType File_3004 = getElementType("org.eclipse.epsilon.eugenia.examples.filesystem.diagram.File_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Sync_4001 = getElementType("org.eclipse.epsilon.eugenia.examples.filesystem.diagram.Sync_4001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ShortcutTarget_4002 = getElementType("org.eclipse.epsilon.eugenia.examples.filesystem.diagram.ShortcutTarget_4002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return FilesystemDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(Filesystem_1000, FilesystemPackage.eINSTANCE
					.getFilesystem());

			elements.put(Drive_2001, FilesystemPackage.eINSTANCE.getDrive());

			elements.put(Drive_3001, FilesystemPackage.eINSTANCE.getDrive());

			elements.put(Folder_3002, FilesystemPackage.eINSTANCE.getFolder());

			elements.put(Shortcut_3003, FilesystemPackage.eINSTANCE
					.getShortcut());

			elements.put(File_3004, FilesystemPackage.eINSTANCE.getFile());

			elements.put(Sync_4001, FilesystemPackage.eINSTANCE.getSync());

			elements.put(ShortcutTarget_4002, FilesystemPackage.eINSTANCE
					.getShortcut_Target());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Filesystem_1000);
			KNOWN_ELEMENT_TYPES.add(Drive_2001);
			KNOWN_ELEMENT_TYPES.add(Drive_3001);
			KNOWN_ELEMENT_TYPES.add(Folder_3002);
			KNOWN_ELEMENT_TYPES.add(Shortcut_3003);
			KNOWN_ELEMENT_TYPES.add(File_3004);
			KNOWN_ELEMENT_TYPES.add(Sync_4001);
			KNOWN_ELEMENT_TYPES.add(ShortcutTarget_4002);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case FilesystemEditPart.VISUAL_ID:
			return Filesystem_1000;
		case DriveEditPart.VISUAL_ID:
			return Drive_2001;
		case Drive2EditPart.VISUAL_ID:
			return Drive_3001;
		case FolderEditPart.VISUAL_ID:
			return Folder_3002;
		case ShortcutEditPart.VISUAL_ID:
			return Shortcut_3003;
		case FileEditPart.VISUAL_ID:
			return File_3004;
		case SyncEditPart.VISUAL_ID:
			return Sync_4001;
		case ShortcutTargetEditPart.VISUAL_ID:
			return ShortcutTarget_4002;
		}
		return null;
	}

}
