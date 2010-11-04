package org.eclipse.epsilon.emc.emf;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

public class EmfXMIResource extends XMIResourceImpl {
	
	protected boolean useXmiIds = false;
	
	public boolean isUseXmiIds() {
		return useXmiIds;
	}
	
	public void setUseXmiIds(boolean useXmiIds) {
		this.useXmiIds = useXmiIds;
	}
	
	public EmfXMIResource(URI uri) {
		super(uri);
	}
	
	@Override
	protected boolean useUUIDs() {
		return isUseXmiIds();
	}
	
}
