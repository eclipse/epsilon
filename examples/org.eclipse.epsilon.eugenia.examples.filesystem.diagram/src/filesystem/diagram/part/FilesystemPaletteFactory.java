/*
 * 
 */
package filesystem.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import filesystem.diagram.providers.FilesystemElementTypes;

/**
 * @generated
 */
public class FilesystemPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createDrive1CreationTool());
		paletteContainer.add(createFile2CreationTool());
		paletteContainer.add(createFolder3CreationTool());
		paletteContainer.add(createShortcut4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createSync1CreationTool());
		paletteContainer.add(createTarget2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDrive1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(FilesystemElementTypes.Drive_2001);
		types.add(FilesystemElementTypes.Drive_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Drive1CreationTool_title,
				Messages.Drive1CreationTool_desc, types);
		entry.setId("createDrive1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FilesystemElementTypes
				.getImageDescriptor(FilesystemElementTypes.Drive_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFile2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(FilesystemElementTypes.File_3004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.File2CreationTool_title,
				Messages.File2CreationTool_desc, types);
		entry.setId("createFile2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FilesystemElementTypes
				.getImageDescriptor(FilesystemElementTypes.File_3004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFolder3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(FilesystemElementTypes.Folder_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Folder3CreationTool_title,
				Messages.Folder3CreationTool_desc, types);
		entry.setId("createFolder3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FilesystemElementTypes
				.getImageDescriptor(FilesystemElementTypes.Folder_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShortcut4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(FilesystemElementTypes.Shortcut_3003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Shortcut4CreationTool_title,
				Messages.Shortcut4CreationTool_desc, types);
		entry.setId("createShortcut4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FilesystemElementTypes
				.getImageDescriptor(FilesystemElementTypes.Shortcut_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSync1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(FilesystemElementTypes.Sync_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Sync1CreationTool_title,
				Messages.Sync1CreationTool_desc, types);
		entry.setId("createSync1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FilesystemElementTypes
				.getImageDescriptor(FilesystemElementTypes.Sync_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTarget2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(FilesystemElementTypes.ShortcutTarget_4002);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Target2CreationTool_title,
				Messages.Target2CreationTool_desc, types);
		entry.setId("createTarget2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(FilesystemElementTypes
						.getImageDescriptor(FilesystemElementTypes.ShortcutTarget_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
