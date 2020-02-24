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

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.epsilon.emc.simulink.model.SimulinkModel;
import org.eclipse.epsilon.emc.simulink.model.element.ISimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.model.element.StateflowBlock;
import org.eclipse.epsilon.emc.simulink.operations.StateflowCollectOperation;
import org.eclipse.epsilon.emc.simulink.operations.StateflowSelectOperation;
import org.eclipse.epsilon.emc.simulink.util.manager.StateflowBlockManager;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.execute.operations.declarative.IAbstractOperationContributor;

public class StateflowBlockCollection extends AbstractSimulinkCollection<StateflowBlock, Double, StateflowBlockManager> implements IAbstractOperationContributor{

	
	public StateflowBlockCollection(Object primitive, SimulinkModel model) {
		super(primitive, new StateflowBlockManager(model));
	}
	
	@Override
	protected boolean isInstanceOf(Object object) {
		return object instanceof StateflowBlock;
	}

	@Override
	protected boolean isInstanceOfPrimitive(Object object) {
		return object instanceof Double;
	}

	@Override
	protected boolean isInstanceOfPrimitiveArray(Object object) {
		if (object instanceof Double[])
			return true;
		if (object instanceof Object[]) {
			return (Arrays.asList((Object[])object)).stream().allMatch(h -> isInstanceOfPrimitive(h));
		}
		return false;
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
		
	protected class StateflowBlockIterator extends AbstractElementIterator<StateflowBlock, Double, StateflowBlockManager>{
		
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

	@Override
	public AbstractOperation getAbstractOperation(String name) {
		if ("select".equals(name)) {
			return new StateflowSelectOperation(getManager().getEngine());
		}
		else if ("collect".equals(name)) {
			return new StateflowCollectOperation(getManager().getEngine());
		}
		else return null;
	}

}
