/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.internal;

import java.util.Objects;

public class EglResult {

	public final String generatedText;
	
	public EglResult(String generatedText) {
		this.generatedText = generatedText;
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public int hashCode() {
		return Objects.hash(generatedText);
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (!(other instanceof EglResult))
			return false;
		
		EglResult er = (EglResult) other;
		return Objects.equals(this.generatedText, er.generatedText);
	}
	
	/**
	 * @since 1.6
	 */
	@Override
	public String toString() {
		return generatedText;
	}
}
