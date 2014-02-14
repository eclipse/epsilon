/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.introspection.recording;


public class PropertyAccessRecorder implements IPropertyAccessRecorder {

	private boolean recording = false;
	private PropertyAccesses currentPropertyAccesses = new PropertyAccesses();
	
	@Override
	public void record(Object modelElement, String propertyName) {
		if (recording) {
			currentPropertyAccesses.add(createPropertyAccess(modelElement, propertyName));
		}
	}

	/**
	 * Subclasses should override this method to customise the type of PropertyAccess that is created.
	 */
	protected PropertyAccess createPropertyAccess(Object modelElement, String propertyName) {
		return new PropertyAccess(modelElement, propertyName);
	}

	@Override
	public void startRecording() {
		currentPropertyAccesses = new PropertyAccesses();
		recording = true;
	}

	@Override
	public void stopRecording() {
		recording = false;
	}
	
	@Override
	public PropertyAccesses getPropertyAccesses() {
		return currentPropertyAccesses;
	}
}
