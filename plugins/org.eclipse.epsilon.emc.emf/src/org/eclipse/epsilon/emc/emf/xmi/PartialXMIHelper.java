package org.eclipse.epsilon.emc.emf.xmi;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;

public class PartialXMIHelper extends XMIHelperImpl {
	
	protected PartialXMILoadConfiguration configuration;
	
	public PartialXMIHelper(XMLResource resource, Map<?, ?> options) {
		super(resource);
		if (options != null) configuration = (PartialXMILoadConfiguration) options.get(PartialXMIResource.OPTION_PARTIAL_LOADING_CONFIGURATION);
	}
	
	@Override
	public void setValue(EObject object, EStructuralFeature feature, Object value, int position) {
		
		if (configuration != null && 
				configuration.isPlaceholder(object) 
				&& feature instanceof EReference 
				&& ((EReference) feature).isContainment() 
				&& value instanceof EObject) {
			resource.getContents().add((EObject) value);
		}
		else {
			super.setValue(object, feature, value, position);
		}
	}
	
}
