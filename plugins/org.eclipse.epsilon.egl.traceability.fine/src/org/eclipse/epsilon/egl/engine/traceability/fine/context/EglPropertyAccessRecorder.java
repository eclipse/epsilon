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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.ModelLocationBuilder;
import org.eclipse.epsilon.eol.execute.introspection.recording.PropertyAccess;
import org.eclipse.epsilon.eol.execute.introspection.recording.PropertyAccessRecorder;

public class EglPropertyAccessRecorder extends PropertyAccessRecorder {
	
	private final ModelLocationBuilder builder = new ModelLocationBuilder();
	private Map<String, String> customData = new HashMap<String, String>();

	@Override
	protected PropertyAccess createPropertyAccess(Object modelElement, String propertyName) {
		return new EglPropertyAccess(modelElement, propertyName, customData);
	}
	
	public void setCustomData(Map<String, String> customData) {
		this.customData = new HashMap<String, String>(customData);
	}

	public class EglPropertyAccess extends PropertyAccess {
		
		private final Map<String, String> customData;
		
		public EglPropertyAccess(Object modelElement, String propertyName, Map<String, String> customData) {
			super(modelElement, propertyName);
			this.customData = new HashMap<String, String>(customData);
		}
		
		public Map<String, String> getCustomData() {
			return customData;
		}
		
		public ModelLocation toModelLocation() {
			return builder.buildModelLocation(modelElement, propertyName);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof EglPropertyAccess)) return false;
			
			final EglPropertyAccess other = (EglPropertyAccess)obj;
			
			return super.equals(other) &&
			       customData.equals(other.customData);
		}
		
		@Override
		public int hashCode() {
			return super.hashCode() + customData.hashCode();
		}
		
		@Override
		public String toString() {
			return super.toString() + " with custom data: " + customData;
		}
	}
}