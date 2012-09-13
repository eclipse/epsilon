/*
 * 
 */
package org.eclipse.epsilon.eugenia.examples.fed.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.eugenia.examples.fed.diagram.providers.FedElementTypes;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class FedPaletteFactory {

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
		paletteContainer.add(createFeature1CreationTool());
		paletteContainer.add(createPlugin2CreationTool());
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
		paletteContainer.add(createDepends1CreationTool());
		paletteContainer.add(createIncludes2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFeature1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Feature1CreationTool_title,
				Messages.Feature1CreationTool_desc,
				Collections.singletonList(FedElementTypes.Feature_2001));
		entry.setId("createFeature1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FedElementTypes
				.getImageDescriptor(FedElementTypes.Feature_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPlugin2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(FedElementTypes.Plugin_3001);
		types.add(FedElementTypes.Plugin_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Plugin2CreationTool_title,
				Messages.Plugin2CreationTool_desc, types);
		entry.setId("createPlugin2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FedElementTypes
				.getImageDescriptor(FedElementTypes.Plugin_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDepends1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Depends1CreationTool_title,
				Messages.Depends1CreationTool_desc,
				Collections.singletonList(FedElementTypes.FeatureDepends_4001));
		entry.setId("createDepends1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FedElementTypes
				.getImageDescriptor(FedElementTypes.FeatureDepends_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createIncludes2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Includes2CreationTool_title,
				Messages.Includes2CreationTool_desc,
				Collections.singletonList(FedElementTypes.FeatureIncludes_4002));
		entry.setId("createIncludes2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FedElementTypes
				.getImageDescriptor(FedElementTypes.FeatureIncludes_4002));
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
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
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
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List<IElementType> relationshipTypes) {
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
