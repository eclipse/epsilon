/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.introspection.java;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkElement;
import org.eclipse.epsilon.emc.simulink.model.element.SimulinkModelElement;
import org.eclipse.epsilon.emc.simulink.model.element.StateflowBlock;
import org.eclipse.epsilon.emc.simulink.types.Struct;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;

public class SimulinkPropertyGetter extends JavaPropertyGetter {

	private static final String TYPE = "type";

	protected MatlabEngine engine;

	public SimulinkPropertyGetter() {}

	@Override
	public boolean hasProperty(Object object, String property) {
		if (object instanceof Struct) {
			return ((Struct) object).containsKey(property);
		}
		return super.hasProperty(object, property);
	}

	
	@Override
	public Object invoke(Object object, String property) throws EolRuntimeException {

		try {
			return super.invoke(object, property);
		} catch (Exception e) {

			if ( object instanceof SimulinkModelElement ) {
				
				SimulinkModelElement element = (SimulinkModelElement) object;
				
				if (element instanceof SimulinkModelElement) {
					if (property.equalsIgnoreCase(TYPE)) {
						return ((SimulinkModelElement) element).getType();
					}
					try {
						if (element instanceof StateflowBlock)
							return ((StateflowBlock) element).getProperty(property);

						if (element instanceof SimulinkElement)
							return ((SimulinkElement) element).getProperty(property);

					} catch (EolIllegalPropertyException me) {
						throw new EolRuntimeException(me.getMessage());
					}
				}
				
			}
			
			if (object instanceof Struct) {
				return ((Struct)object).get(property);
			}
			
			throw new EolRuntimeException(e.getMessage());
			
		}
		
		
	}

}
