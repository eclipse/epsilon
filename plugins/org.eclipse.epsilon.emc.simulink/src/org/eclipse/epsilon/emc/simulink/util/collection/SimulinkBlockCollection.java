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
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkBlock;
import org.eclipse.epsilon.emc.simulink.util.manager.SimulinkBlockManager;

public class SimulinkBlockCollection extends AbstractSimulinkCollection<SimulinkBlock, Double, SimulinkBlockManager> {

	
	public SimulinkBlockCollection(Object primitive, SimulinkModel model) {
		super(primitive, new SimulinkBlockManager(model));
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
		if (object instanceof Double[])
			return true;
		if (object instanceof Object[]) {
			return (Arrays.asList((Object[])object)).stream().allMatch(h -> isInstanceOfPrimitive(h));
		}
		return false;
	}
	
	@Override
	public List<ISimulinkModelElement> subList(int fromIndex, int toIndex) {
		return new SimulinkBlockCollection(getPrimitive().subList(fromIndex, toIndex), getManager().getModel());
	}
	
	@Override
	public ListIterator<ISimulinkModelElement> listIterator() {
		return new SimulinkBlockListIterator();
	}

	@Override
	public ListIterator<ISimulinkModelElement> listIterator(int index) {
		return new SimulinkBlockListIterator(index);
	}

	@Override
	protected Iterator<ISimulinkModelElement> getInternalIterator() {
		return new SimulinkBlockIterator();
	}
		
	protected class SimulinkBlockIterator extends AbstractElementIterator<SimulinkBlock, Double, SimulinkBlockManager>{
		
		SimulinkBlockIterator(){
			super(getPrimitive(), getManager());
		}
		
	}
	
	protected class SimulinkBlockListIterator extends AbstractListIterator<SimulinkBlock, Double, SimulinkBlockManager> {
		
		SimulinkBlockListIterator(){
			super(getPrimitive(), getManager());
		}
		
		SimulinkBlockListIterator(int index){
			super(index, getPrimitive(), getManager());
		}
		
	}


}
