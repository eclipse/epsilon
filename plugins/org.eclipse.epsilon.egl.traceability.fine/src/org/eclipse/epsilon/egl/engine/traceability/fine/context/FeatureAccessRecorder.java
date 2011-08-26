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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder.ModelLocationBuilder;


public class FeatureAccessRecorder {
	
	private final ModelLocationBuilder builder = new ModelLocationBuilder();
	private final Set<FeatureAccess> recentFeatureAccesses = new HashSet<FeatureAccess>();
	private boolean recording = false;

	public void startRecording() {
		recording = true;
		recentFeatureAccesses.clear();
	}
	
	public void stopRecording() {
		recording = false;
	}

	public void record(EObject modelElement, String featureName) {
		if (recording) recentFeatureAccesses.add(new FeatureAccess(modelElement, featureName));
	}

	public List<ModelLocation> getFeatureAccesses() {
		final List<ModelLocation> modelLocations = new LinkedList<ModelLocation>();
		
		for (FeatureAccess featureAccess : recentFeatureAccesses) {
			modelLocations.add(featureAccess.toModelLocation());
		}

		return modelLocations;
	}
	
	private class FeatureAccess {
		
		public final EObject modelElement;
		public final String  featureName;
		
		public FeatureAccess(EObject modelElement, String featureName) {
			this.modelElement = modelElement;
			this.featureName  = featureName;
		}
		
		public ModelLocation toModelLocation() {
			return builder.buildModelLocation(modelElement, featureName);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof FeatureAccess)) return false;
			
			final FeatureAccess other = (FeatureAccess)obj;
			
			return modelElement.equals(other.modelElement) &&
			       featureName.equals(other.featureName);
		}
		
		@Override
		public int hashCode() {
			return modelElement.hashCode() + featureName.hashCode();
		}
		
		@Override
		public String toString() {
			return "FeatureAccess: " + featureName + " on " + modelElement;
		}
	}
}