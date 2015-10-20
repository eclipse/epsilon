package org.eclipse.epsilon.dt.exeed.extensions;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.dt.exeed.ExeedEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;

public interface IExeedCustomizer {

	/**
	 * Returns true if the customizer should be used for this particular instance.
	 */
	boolean isEnabledFor(Resource r);

	void createPages(ExeedEditor editor, Composite container, AdapterFactory adapterFactory);

	boolean hasChildren(Resource r, EObject eob);

	Collection<IAction> generateCreateChildActions(Collection<?> descriptors, ISelection selection);

	Collection<IAction> generateCreateSiblingActions(Collection<?> descriptors, ISelection selection);

}
