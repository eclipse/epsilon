/*
 * 
 */
package flowchart.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import flowchart.diagram.providers.FlowchartElementTypes;

/**
 * @generated
 */
public class FlowchartPaletteFactory {

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
		paletteContainer.add(createAction1CreationTool());
		paletteContainer.add(createDecision2CreationTool());
		paletteContainer.add(createSubflow3CreationTool());
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
		paletteContainer.add(createTransition1CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAction1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Action1CreationTool_title,
				Messages.Action1CreationTool_desc,
				Collections.singletonList(FlowchartElementTypes.Action_2004));
		entry.setId("createAction1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FlowchartElementTypes
				.getImageDescriptor(FlowchartElementTypes.Action_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDecision2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Decision2CreationTool_title,
				Messages.Decision2CreationTool_desc,
				Collections.singletonList(FlowchartElementTypes.Decision_2003));
		entry.setId("createDecision2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FlowchartElementTypes
				.getImageDescriptor(FlowchartElementTypes.Decision_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubflow3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Subflow3CreationTool_title,
				Messages.Subflow3CreationTool_desc,
				Collections.singletonList(FlowchartElementTypes.Subflow_2001));
		entry.setId("createSubflow3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FlowchartElementTypes
				.getImageDescriptor(FlowchartElementTypes.Subflow_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTransition1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Transition1CreationTool_title,
				Messages.Transition1CreationTool_desc,
				Collections
						.singletonList(FlowchartElementTypes.Transition_4001));
		entry.setId("createTransition1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(FlowchartElementTypes
				.getImageDescriptor(FlowchartElementTypes.Transition_4001));
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
