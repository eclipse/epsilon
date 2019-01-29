/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.util.collection;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.model.element.StateflowBlock;
import org.eclipse.epsilon.emc.simulink.util.manager.StateflowBlockManager;

public class StateflowBlockCollection extends AbstractSimulinkCollection<StateflowBlock, Double, StateflowBlockManager> {

	
	public StateflowBlockCollection(Object primitive, SimulinkModel model) {
		super(primitive, new StateflowBlockManager(model));
	}
	
	@Override
	protected boolean isInstanceOf(Object object) {
		return object instanceof SimulinkBlock;
	}

	@Override
	protected boolean isInstanceOfPrimitive(Object object) {
		return object instanceof Double;
	}

	@Override
	protected boolean isInstanceOfPrimitiveArray(Object object) {
		return object instanceof Double[];
	}
	
	@Override
	public List<ISimulinkModelElement> subList(int fromIndex, int toIndex) {
		return new StateflowBlockCollection(getPrimitive().subList(fromIndex, toIndex), getManager().getModel());
	}
	
	@Override
	public ListIterator<ISimulinkModelElement> listIterator() {
		return new StateflowBlockListIterator();
	}

	@Override
	public ListIterator<ISimulinkModelElement> listIterator(int index) {
		return new StateflowBlockListIterator(index);
	}

	@Override
	protected Iterator<ISimulinkModelElement> getInternalIterator() {
		return new StateflowBlockIterator();
	}
		
	protected class StateflowBlockIterator extends AbstractBlockIterator<StateflowBlock, Double, StateflowBlockManager>{
		
		StateflowBlockIterator(){
			super(getPrimitive(), getManager());
		}
		
	}
	
	protected class StateflowBlockListIterator extends AbstractListIterator<StateflowBlock, Double, StateflowBlockManager> {
		
		StateflowBlockListIterator(){
			super(getPrimitive(), getManager());
		}
		
		StateflowBlockListIterator(int index){
			super(index, getPrimitive(), getManager());
		}
		
	}


}
