/*
 * 
 */
package esm.diagram.providers;

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
import esm.diagram.edit.parts.EsmEditPartFactory;
import esm.diagram.edit.parts.MachineEditPart;
import esm.diagram.part.EsmVisualIDRegistry;

/**
 * @generated
 */
public class EsmEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public EsmEditPartProvider() {
		super(new EsmEditPartFactory(), EsmVisualIDRegistry.TYPED_INSTANCE,
				MachineEditPart.MODEL_ID);
	}
}
