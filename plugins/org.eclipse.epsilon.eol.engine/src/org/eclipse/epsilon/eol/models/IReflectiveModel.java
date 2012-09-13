/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.eol.models;

import java.util.Collection;

import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotAnEnumerationValueException;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;

public interface IReflectiveModel extends IModel {

	/**
	 * Prevents the loading of model elements that are referenced by 
	 * this model but are not contained in this model. This is useful
	 * for clients, such as Epsilon Flock, which create a clone or 
	 * conservative copy of this model.

	 * @return true iff this method had an effect (i.e. when this model 
	 * supports external references, was configured to load external
	 * references and is no longer configured to load external 
	 * references).
	 */
	public boolean preventLoadingOfExternalModelElements();
	
	/**
	 * Returns a collection containing all of the properties that instances
	 * of type know about.
	 * 
	 * @param type The type of model object whose properties are to be determined.
	 * @return all of the properties that instances of type knows about.
	 * @throws EolModelElementTypeNotFoundException when this model has no such type
	 */
	public Collection<String> getPropertiesOf(String type) throws EolModelElementTypeNotFoundException;
	
	public IReflectivePropertySetter getPropertySetter();

	public boolean hasProperty(String type, String property) throws EolModelElementTypeNotFoundException;

	/**
	 * Returns true iff object is an enumeration value.
	 */
	public boolean isEnumerationValue(Object object);
	
	/**
	 * Returns the name of the enumeration type of the literal parameter.
	 * 
	 * @throws EolEnumerationTypeNotFoundException when the enumeration type of literal is
	 *                                             not present in this model
	 * @throws EolNotAnEnumerationValueException when literal is not an enumeration value
	 */
	public String getEnumerationTypeOf(Object literal) throws EolNotAnEnumerationValueException;
	
	/**
	 * Returns the enumeration label of the literal parameter.
	 * 
	 * @throws EolEnumerationTypeNotFoundException when the enumeration type of literal is
	 *                                             not present in this model
	 * @throws EolNotAnEnumerationValueException when literal is not an enumeration value
	 */
	public String getEnumerationLabelOf(Object literal) throws EolNotAnEnumerationValueException;
}
