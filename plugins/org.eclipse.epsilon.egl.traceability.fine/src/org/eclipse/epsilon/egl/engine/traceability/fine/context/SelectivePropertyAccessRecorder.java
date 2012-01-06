/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine.context;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.ModelLocationBuilder;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyAccessRecorder;


public class SelectivePropertyAccessRecorder implements IPropertyAccessRecorder {
	
	private final ModelLocationBuilder builder = new ModelLocationBuilder();
	private final Set<PropertyAccess> recentPropertyAccesses = new HashSet<PropertyAccess>();
	private boolean recording = false;
	private Map<String, String> customData = new HashMap<String, String>();

	public void startRecording() {
		recording = true;
		recentPropertyAccesses.clear();
	}
	
	public void stopRecording() {
		recording = false;
	}

	@Override
	public void record(Object modelElement, String propertyName) {
		if (recording) recentPropertyAccesses.add(new PropertyAccess(modelElement, propertyName, customData));
	}
	
	public void setCustomData(Map<String, String> customData) {
		this.customData = new HashMap<String, String>(customData);
	}

	public Collection<PropertyAccess> getPropertyAccesses() {
		return recentPropertyAccesses;
	}
	
	public class PropertyAccess {
		
		public final Object modelElement;
		public final String propertyName;
		public final Map<String, String> customData;
		
		public PropertyAccess(Object modelElement, String propertyName, Map<String, String> customData) {
			this.modelElement = modelElement;
			this.propertyName = propertyName;
			this.customData   = customData;
		}
		
		public ModelLocation toModelLocation() {
			return builder.buildModelLocation(modelElement, propertyName);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof PropertyAccess)) return false;
			
			final PropertyAccess other = (PropertyAccess)obj;
			
			return modelElement.equals(other.modelElement) &&
			       propertyName.equals(other.propertyName) &&
			       customData.equals(other.customData);
		}
		
		@Override
		public int hashCode() {
			return modelElement.hashCode() + propertyName.hashCode() + customData.hashCode();
		}
		
		@Override
		public String toString() {
			return "PropertyAccess: " + propertyName + " on " + modelElement + " with custom data: " + customData;
		}
	}
}