/*******************************************************************************
 * Copyright (c) 2012 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - implement getVariables() and hasVariables()
 ******************************************************************************/
package org.eclipse.epsilon.eol.dt.debug;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.epsilon.eol.util.ReflectionUtil;

public class EolVariableValue extends EolDebugElement implements IValue {
	private Object value = null;
	private IVariable[] variables = null;
	
	public EolVariableValue(IDebugTarget target, Object value) {
		super(target);
		this.value = value;
	}

	public String getReferenceTypeName() throws DebugException {
		return value != null ? value.getClass().getCanonicalName() : "(null)";
	}

	public String getValueString() throws DebugException {
		return value + "";
	}

	public boolean isAllocated() throws DebugException {
		return true;
	}

	@SuppressWarnings("unchecked")
	public synchronized IVariable[] getVariables() throws DebugException {
		if (variables == null) {
			if (value != null) {
				final List<IVariable> subvars = new ArrayList<IVariable>();

				// Elements (for collections and arrays)
				if (value instanceof Collection) {
					int i = 0;
					for (Iterator<Object> it = ((Collection<Object>)value).iterator(); it.hasNext(); ) {
						subvars.add(new EolVariable(getDebugTarget(), "[" + i++ + "]", it.next()));
					}
				}
				else if (value instanceof Object[]) {
					final Object[] array = (Object[])value;
					for (int i = 0; i < array.length; ++i) {
						subvars.add(new EolVariable(getDebugTarget(), "[" + i + "]", array[i]));
					}
				}

				// Fields (for any object)
				final List<Field> fields = ReflectionUtil.getAllInheritedInstanceFields(value.getClass());
				for (Field f : fields) {
					boolean oldAccessible = f.isAccessible();
					try {
						f.setAccessible(true);
						subvars.add(new EolVariable(getDebugTarget(), f.getName(), f.get(value)));
						f.setAccessible(oldAccessible);
					} catch (IllegalAccessException ex) {
						// could not access the field
					}
					catch (SecurityException ex) {
						// could not make the field accessible
					}
				}

				// Extended properties
				final EolDebugTarget dt = (EolDebugTarget)getDebugTarget();
				final Map<Object, Map<String, Object>> allExtProps = dt.getModule().getContext().getExtendedProperties();
				if (allExtProps.containsKey(value)) {
					for (Map.Entry<String, Object> eP : allExtProps.get(value).entrySet()) {
						subvars.add(new EolVariable(getDebugTarget(), "~" + eP.getKey(), eP.getValue()));
					}
				}

				// Sort fields by name
				Collections.sort(subvars, new IVariableNameComparator());
				variables = subvars.toArray(new IVariable[subvars.size()]);
			}
			else {
				variables = new IVariable[0];
			}
		}
		return variables;
	}

	public boolean hasVariables() throws DebugException {
		final IVariable[] vars = getVariables();
		return vars != null && vars.length > 0;
	}
}
