/*
 * 
 */
package rcpapp.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import rcpapp.Component;
import rcpapp.Model;
import rcpapp.diagram.edit.parts.ComponentEditPart;
import rcpapp.diagram.edit.parts.ModelEditPart;

/**
 * @generated
 */
public class RcpappDiagramUpdater {

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
	public static List<RcpappNodeDescriptor> getSemanticChildren(View view) {
		switch (RcpappVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RcpappNodeDescriptor> getModel_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Model modelElement = (Model) view.getElement();
		LinkedList<RcpappNodeDescriptor> result = new LinkedList<RcpappNodeDescriptor>();
		for (Iterator<?> it = modelElement.getComponents().iterator(); it
				.hasNext();) {
			Component childElement = (Component) it.next();
			int visualID = RcpappVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ComponentEditPart.VISUAL_ID) {
				result.add(new RcpappNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<RcpappLinkDescriptor> getContainedLinks(View view) {
		switch (RcpappVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_1000ContainedLinks(view);
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RcpappLinkDescriptor> getIncomingLinks(View view) {
		switch (RcpappVisualIDRegistry.getVisualID(view)) {
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RcpappLinkDescriptor> getOutgoingLinks(View view) {
		switch (RcpappVisualIDRegistry.getVisualID(view)) {
		case ComponentEditPart.VISUAL_ID:
			return getComponent_2001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RcpappLinkDescriptor> getModel_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RcpappLinkDescriptor> getComponent_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RcpappLinkDescriptor> getComponent_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<RcpappLinkDescriptor> getComponent_2001OutgoingLinks(
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
		public List<RcpappNodeDescriptor> getSemanticChildren(View view) {
			return RcpappDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<RcpappLinkDescriptor> getContainedLinks(View view) {
			return RcpappDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<RcpappLinkDescriptor> getIncomingLinks(View view) {
			return RcpappDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<RcpappLinkDescriptor> getOutgoingLinks(View view) {
			return RcpappDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
