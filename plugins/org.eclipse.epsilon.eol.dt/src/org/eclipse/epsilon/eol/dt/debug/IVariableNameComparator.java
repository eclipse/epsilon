/*******************************************************************************
 * Copyright (c) 2012 Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio García-Domínguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.dt.debug;

import java.util.Comparator;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.epsilon.eol.dt.EolPlugin;

/**
 * Compares IVariable instances using their names.
 */
final class IVariableNameComparator implements Comparator<IVariable> {
	@Override
	public int compare(IVariable o1, IVariable o2) {
		try {
			return o1.getName().compareTo(o2.getName());
		} catch (DebugException e) {
			EolPlugin.getDefault().logException(e);
			return 0;
		}
	}
}