/*
 * 
 */
package people.diagram.providers;

import java.lang.ref.WeakReference;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;
import people.diagram.edit.parts.ModelEditPart;
import people.diagram.edit.parts.PeopleEditPartFactory;
import people.diagram.part.PeopleVisualIDRegistry;

/**
 * @generated
 */
public class PeopleEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public PeopleEditPartProvider() {
		super(new PeopleEditPartFactory(),
				PeopleVisualIDRegistry.TYPED_INSTANCE, ModelEditPart.MODEL_ID);
	}
}
