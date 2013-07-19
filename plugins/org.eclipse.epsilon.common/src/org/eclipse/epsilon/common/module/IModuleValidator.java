package org.eclipse.epsilon.common.module;

import java.util.List;


public interface IModuleValidator {
	
	public List<ModuleMarker> validate(IModule module);

	/**
	 * An identifier that indicates the type of marker that 
	 * should be displayed for the markers returned by this 
	 * validator. If no marker type is specified, the client
	 * will decide what type of marker to display for this
	 * validator.
	 */
	public String getMarkerType();
	
}
