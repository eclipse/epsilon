/*
 * 
 */
package people.diagram.part;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;

import people.Model;
import people.Person;
import people.diagram.edit.parts.ModelEditPart;
import people.diagram.edit.parts.PersonEditPart;

/**
 * @generated
 */
public class PeopleDiagramUpdater {

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
	public static List<PeopleNodeDescriptor> getSemanticChildren(View view) {
		switch (PeopleVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_1000SemanticChildren(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PeopleNodeDescriptor> getModel_1000SemanticChildren(
			View view) {
		if (!view.isSetElement()) {
			return Collections.emptyList();
		}
		Model modelElement = (Model) view.getElement();
		LinkedList<PeopleNodeDescriptor> result = new LinkedList<PeopleNodeDescriptor>();
		for (Iterator<?> it = modelElement.getPeople().iterator(); it.hasNext();) {
			Person childElement = (Person) it.next();
			int visualID = PeopleVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == PersonEditPart.VISUAL_ID) {
				result.add(new PeopleNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List<PeopleLinkDescriptor> getContainedLinks(View view) {
		switch (PeopleVisualIDRegistry.getVisualID(view)) {
		case ModelEditPart.VISUAL_ID:
			return getModel_1000ContainedLinks(view);
		case PersonEditPart.VISUAL_ID:
			return getPerson_2001ContainedLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PeopleLinkDescriptor> getIncomingLinks(View view) {
		switch (PeopleVisualIDRegistry.getVisualID(view)) {
		case PersonEditPart.VISUAL_ID:
			return getPerson_2001IncomingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PeopleLinkDescriptor> getOutgoingLinks(View view) {
		switch (PeopleVisualIDRegistry.getVisualID(view)) {
		case PersonEditPart.VISUAL_ID:
			return getPerson_2001OutgoingLinks(view);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PeopleLinkDescriptor> getModel_1000ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PeopleLinkDescriptor> getPerson_2001ContainedLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PeopleLinkDescriptor> getPerson_2001IncomingLinks(
			View view) {
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public static List<PeopleLinkDescriptor> getPerson_2001OutgoingLinks(
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
		public List<PeopleNodeDescriptor> getSemanticChildren(View view) {
			return PeopleDiagramUpdater.getSemanticChildren(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PeopleLinkDescriptor> getContainedLinks(View view) {
			return PeopleDiagramUpdater.getContainedLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PeopleLinkDescriptor> getIncomingLinks(View view) {
			return PeopleDiagramUpdater.getIncomingLinks(view);
		}

		/**
		 * @generated
		 */
		@Override
		public List<PeopleLinkDescriptor> getOutgoingLinks(View view) {
			return PeopleDiagramUpdater.getOutgoingLinks(view);
		}
	};

}
