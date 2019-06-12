/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.testmanager.model;

import java.util.Collection;

import org.eclipse.epsilon.emc.simulink.model.AbstractSimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkModelElement;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.models.IModel;

public class SimulinkTestManagerModel extends AbstractSimulinkModel implements ISimulinkModelElement {

	@Override
	public Object getProperty(String property) throws EolIllegalPropertyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProperty(String property, Object value) throws EolIllegalPropertyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<String> getAllTypeNamesOf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteElementInModel() throws EolRuntimeException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getHandle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IModel getOwningModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTypeNameOf(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getElementById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getElementId(Object instance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setElementId(Object instance, String newId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean owns(Object instance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInstantiable(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasType(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean store(String location) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean store() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Collection<ISimulinkModelElement> allContentsFromModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Collection<ISimulinkModelElement> getAllOfTypeFromModel(String type)
			throws EolModelElementTypeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Collection<ISimulinkModelElement> getAllOfKindFromModel(String kind)
			throws EolModelElementTypeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ISimulinkModelElement createInstanceInModel(String type)
			throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean deleteElementInModel(Object instance) throws EolRuntimeException {
		// TODO Auto-generated method stub
		return false;
	}

}
