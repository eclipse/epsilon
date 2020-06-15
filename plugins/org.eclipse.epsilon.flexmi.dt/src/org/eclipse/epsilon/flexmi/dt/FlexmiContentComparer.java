package org.eclipse.epsilon.flexmi.dt;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.IElementComparer;

public class FlexmiContentComparer implements IElementComparer {
	
	@Override
	public int hashCode(Object element) {
		if (element instanceof ResourceSet) return 1;
		else if (element instanceof Resource) return ((Resource) element).getURI().hashCode();
		else if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			return (eObject.eResource().getURIFragment(eObject) + eObject.eResource().getURI()).hashCode();
		}
		else return element.hashCode();
	}
	
	@Override
	public boolean equals(Object a, Object b) {
		return hashCode(a) == hashCode(b);
	}
	
}
