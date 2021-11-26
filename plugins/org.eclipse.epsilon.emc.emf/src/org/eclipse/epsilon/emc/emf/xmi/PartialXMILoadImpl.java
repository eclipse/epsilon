package org.eclipse.epsilon.emc.emf.xmi;

import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMILoadImpl;
import org.xml.sax.helpers.DefaultHandler;

class PartialXMILoadImpl extends XMILoadImpl {

	public PartialXMILoadImpl(XMLHelper helper) {
		super(helper);
	}

	@Override
	protected DefaultHandler makeDefaultHandler() {
		return new PartialXMIHander(resource, helper, options);
	}
	
}