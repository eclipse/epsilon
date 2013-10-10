/*******************************************************************************
 * Copyright (c) 2013 Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio García-Domínguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.ewl;

import java.util.Collection;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.ewl.execute.context.IEwlContext;

/**
 * Applies the same EWL wizard to a collection of applicable objects. In this case, 
 */
public class EwlWizardLoopInstance extends EwlWizardInstance {

	private Collection<Object> collection;

	public EwlWizardLoopInstance(EwlWizard wizard, Collection<Object> objects, IEwlContext context) {
		super(wizard, null, context);
		this.collection = objects;
	}

	public Collection<Object> getCollection() {
		return collection;
	}

	public void setCollection(Collection<Object> collection) {
		this.collection = collection;
	}

	@Override
	public void setSelf(Object self) {
		throw new UnsupportedOperationException("Cannot set 'self' for EWL loop instances");
	}

	@Override
	public void process() throws EolRuntimeException {
		try {
			for (Object o : collection) {
				super.setSelf(o);
				super.process();
			}
		} finally {
			super.setSelf(null);
		}
	}

}
