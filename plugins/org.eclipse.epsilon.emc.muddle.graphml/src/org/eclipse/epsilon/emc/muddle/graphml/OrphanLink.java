package org.eclipse.epsilon.emc.muddle.graphml;

import org.eclipse.epsilon.emc.muddle.MuddleElement;

public class OrphanLink {
	
	protected MuddleElement source;
	protected MuddleElement target;
	
	public MuddleElement getSource() {
		return source;
	}
	
	public void setSource(MuddleElement source) {
		this.source = source;
	}
	
	public MuddleElement getTarget() {
		return target;
	}
	
	public void setTarget(MuddleElement target) {
		this.target = target;
	}

	public OrphanLink(MuddleElement source, MuddleElement target) {
		super();
		this.source = source;
		this.target = target;
	}
	
	
	
	
}
