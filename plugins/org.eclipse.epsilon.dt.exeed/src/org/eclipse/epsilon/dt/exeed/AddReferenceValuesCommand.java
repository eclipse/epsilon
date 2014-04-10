/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.dt.exeed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class AddReferenceValuesCommand implements Command {
	
	protected EReference reference;
	protected EObject object;
	protected Collection<?> newValues;
	
	public AddReferenceValuesCommand(EObject object, Collection<?> newValues, EReference reference) {
		this.object = object;
		this.newValues = newValues;
		this.reference = reference;
	}
	
	public boolean canExecute() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean canUndo() {
		// TODO Auto-generated method stub
		return true;
	}

	public Command chain(Command arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void execute() {
		Collection oldValues = (Collection) object.eGet(reference);
		oldValues.addAll(newValues);
	}

	public Collection<EObject> getAffectedObjects() {
		List<EObject> col = new ArrayList<EObject>();
		col.add(object);
		return col;
	}

	public String getDescription() {
		return "Add to " + reference.getName();
	}

	public String getLabel() {
		return "Add to " + reference.getName();
	}

	public Collection<?> getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	public void redo() {
		execute();
	}

	public void undo() {
		Collection newValues = (Collection) object.eGet(reference);
		newValues.removeAll(this.newValues);
	}

}
