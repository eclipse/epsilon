/*
 * 
 */
package filesystem.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import filesystem.diagram.edit.parts.Drive2EditPart;
import filesystem.diagram.edit.parts.DriveEditPart;
import filesystem.diagram.edit.parts.DriveName2EditPart;
import filesystem.diagram.edit.parts.DriveNameEditPart;
import filesystem.diagram.edit.parts.FileEditPart;
import filesystem.diagram.edit.parts.FileNameEditPart;
import filesystem.diagram.edit.parts.FilesystemEditPart;
import filesystem.diagram.edit.parts.FolderEditPart;
import filesystem.diagram.edit.parts.FolderNameEditPart;
import filesystem.diagram.edit.parts.ShortcutEditPart;
import filesystem.diagram.edit.parts.ShortcutNameEditPart;
import filesystem.diagram.edit.parts.ShortcutTargetEditPart;
import filesystem.diagram.edit.parts.SyncEditPart;
import filesystem.diagram.edit.parts.SyncLastSyncEditPart;
import filesystem.diagram.part.FilesystemDiagramEditorPlugin;
import filesystem.diagram.part.FilesystemVisualIDRegistry;
import filesystem.diagram.providers.FilesystemElementTypes;
import filesystem.diagram.providers.FilesystemParserProvider;

/**
 * @generated
 */
public class FilesystemNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		FilesystemDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		FilesystemDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put("Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof FilesystemNavigatorItem
				&& !isOwnView(((FilesystemNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof FilesystemNavigatorGroup) {
			FilesystemNavigatorGroup group = (FilesystemNavigatorGroup) element;
			return FilesystemDiagramEditorPlugin.getInstance().getBundledImage(
					group.getIcon());
		}

		if (element instanceof FilesystemNavigatorItem) {
			FilesystemNavigatorItem navigatorItem = (FilesystemNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getImage(view);
			}
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {
		case SyncEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?filesystem?Sync", FilesystemElementTypes.Sync_4001); //$NON-NLS-1$
		case FileEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?filesystem?File", FilesystemElementTypes.File_3004); //$NON-NLS-1$
		case FolderEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?filesystem?Folder", FilesystemElementTypes.Folder_3002); //$NON-NLS-1$
		case Drive2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?filesystem?Drive", FilesystemElementTypes.Drive_3001); //$NON-NLS-1$
		case ShortcutEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?filesystem?Shortcut", FilesystemElementTypes.Shortcut_3003); //$NON-NLS-1$
		case DriveEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?filesystem?Drive", FilesystemElementTypes.Drive_2001); //$NON-NLS-1$
		case ShortcutTargetEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?filesystem?Shortcut?target", FilesystemElementTypes.ShortcutTarget_4002); //$NON-NLS-1$
		case FilesystemEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?filesystem?Filesystem", FilesystemElementTypes.Filesystem_1000); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = FilesystemDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& FilesystemElementTypes.isKnownElementType(elementType)) {
			image = FilesystemElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof FilesystemNavigatorGroup) {
			FilesystemNavigatorGroup group = (FilesystemNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof FilesystemNavigatorItem) {
			FilesystemNavigatorItem navigatorItem = (FilesystemNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		// Due to plugin.xml content will be called only for "own" views
		if (element instanceof IAdaptable) {
			View view = (View) ((IAdaptable) element).getAdapter(View.class);
			if (view != null && isOwnView(view)) {
				return getText(view);
			}
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (FilesystemVisualIDRegistry.getVisualID(view)) {
		case SyncEditPart.VISUAL_ID:
			return getSync_4001Text(view);
		case FileEditPart.VISUAL_ID:
			return getFile_3004Text(view);
		case FolderEditPart.VISUAL_ID:
			return getFolder_3002Text(view);
		case Drive2EditPart.VISUAL_ID:
			return getDrive_3001Text(view);
		case ShortcutEditPart.VISUAL_ID:
			return getShortcut_3003Text(view);
		case DriveEditPart.VISUAL_ID:
			return getDrive_2001Text(view);
		case ShortcutTargetEditPart.VISUAL_ID:
			return getShortcutTarget_4002Text(view);
		case FilesystemEditPart.VISUAL_ID:
			return getFilesystem_1000Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getFilesystem_1000Text(View view) {
		return ""; //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private String getDrive_2001Text(View view) {
		IParser parser = FilesystemParserProvider
				.getParser(FilesystemElementTypes.Drive_2001,
						view.getElement() != null ? view.getElement() : view,
						FilesystemVisualIDRegistry
								.getType(DriveNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FilesystemDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getDrive_3001Text(View view) {
		IParser parser = FilesystemParserProvider.getParser(
				FilesystemElementTypes.Drive_3001,
				view.getElement() != null ? view.getElement() : view,
				FilesystemVisualIDRegistry
						.getType(DriveName2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FilesystemDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFolder_3002Text(View view) {
		IParser parser = FilesystemParserProvider.getParser(
				FilesystemElementTypes.Folder_3002,
				view.getElement() != null ? view.getElement() : view,
				FilesystemVisualIDRegistry
						.getType(FolderNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FilesystemDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getShortcut_3003Text(View view) {
		IParser parser = FilesystemParserProvider.getParser(
				FilesystemElementTypes.Shortcut_3003,
				view.getElement() != null ? view.getElement() : view,
				FilesystemVisualIDRegistry
						.getType(ShortcutNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FilesystemDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFile_3004Text(View view) {
		IParser parser = FilesystemParserProvider.getParser(
				FilesystemElementTypes.File_3004,
				view.getElement() != null ? view.getElement() : view,
				FilesystemVisualIDRegistry.getType(FileNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FilesystemDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getSync_4001Text(View view) {
		IParser parser = FilesystemParserProvider.getParser(
				FilesystemElementTypes.Sync_4001,
				view.getElement() != null ? view.getElement() : view,
				FilesystemVisualIDRegistry
						.getType(SyncLastSyncEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FilesystemDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getShortcutTarget_4002Text(View view) {
		IParser parser = FilesystemParserProvider.getParser(
				FilesystemElementTypes.ShortcutTarget_4002,
				view.getElement() != null ? view.getElement() : view,
				CommonParserHint.DESCRIPTION);
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			FilesystemDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return FilesystemEditPart.MODEL_ID.equals(FilesystemVisualIDRegistry
				.getModelID(view));
	}

}
