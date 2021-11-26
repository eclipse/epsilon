package org.eclipse.epsilon.emc.emf.xmi;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class XMIIDApp {
	
	public static void main(String[] args) throws Exception {
		
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		XMIResource resource = (XMIResource) resourceSet.createResource(URI.createFileURI("src/org/eclipse/epsilon/emc/emf/xmi/psl.ecore"));
		resource.load(null);
		
		XMIResource resourceWithIDs = new XMIResourceImpl() {
			protected boolean useUUIDs() {
				return true;
			};
		};
		
		resourceWithIDs.getContents().add(EcoreUtil.copy(resource.getContents().get(0)));
		resourceWithIDs.save(System.out, null);
	}
	
}
