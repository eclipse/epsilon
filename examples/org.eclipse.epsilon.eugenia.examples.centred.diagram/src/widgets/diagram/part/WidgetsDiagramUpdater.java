/*
 * 
 */
package widgets.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import widgets.System;
import widgets.Widget;
import widgets.diagram.edit.parts.SystemEditPart;
import widgets.diagram.edit.parts.WidgetEditPart;

/**
 * @generated
 */
public class WidgetsDiagramUpdater {

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
	public static List<WidgetsNodeDescriptor> getSemanticChildren(View view) {
		switch (WidgetsVisualIDRegistry.getVisualID(view)) {
		case SystemEditPart.VISUAL_ID:
			return getSystem_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WidgetsNodeDescriptor> getSystem_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		System modelElement = (System) view.getElement();
		LinkedList<WidgetsNodeDescriptor> result = new LinkedList<WidgetsNodeDescriptor>();
		for (Iterator<?> it = modelElement.getWidgets().iterator(); it
				.hasNext();) {
			Widget childElement = (Widget) it.next();
			int visualID = WidgetsVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == WidgetEditPart.VISUAL_ID) {
				result.add(new WidgetsNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<WidgetsLinkDescriptor> getContainedLinks(View view) {
		switch (WidgetsVisualIDRegistry.getVisualID(view)) {
		case SystemEditPart.VISUAL_ID:
			return getSystem_1000ContainedLinks(view);
		case WidgetEditPart.VISUAL_ID:
			return getWidget_2001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WidgetsLinkDescriptor> getIncomingLinks(View view) {
		switch (WidgetsVisualIDRegistry.getVisualID(view)) {
		case WidgetEditPart.VISUAL_ID:
			return getWidget_2001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WidgetsLinkDescriptor> getOutgoingLinks(View view) {
		switch (WidgetsVisualIDRegistry.getVisualID(view)) {
		case WidgetEditPart.VISUAL_ID:
			return getWidget_2001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WidgetsLinkDescriptor> getSystem_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WidgetsLinkDescriptor> getWidget_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WidgetsLinkDescriptor> getWidget_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<WidgetsLinkDescriptor> getWidget_2001OutgoingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static final DiagramUpdater TYPED_INSTANCE = new DiagramUpdater() {
		/**
		 * @generated
		 */
		@Override
		public List<WidgetsNodeDescriptor> getSemanticChildren(View view) {
			return WidgetsDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<WidgetsLinkDescriptor> getContainedLinks(View view) {
			return WidgetsDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<WidgetsLinkDescriptor> getIncomingLinks(View view) {
			return WidgetsDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<WidgetsLinkDescriptor> getOutgoingLinks(View view) {
			return WidgetsDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
