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
package util;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.hutn.test.model.families.FamiliesPackage;
import org.eclipse.epsilon.test.fixtures.hutn.AbstractEmfModelConstructor;

public class FamiliesModelConstructor extends AbstractEmfModelConstructor {

	@Override
	protected List<String> getNsUris() {
		return Collections.singletonList(FamiliesPackage.eNS_URI);
	}
		
	@Override
	protected List<String> getConfigFiles() {
		return Collections.singletonList(null);
	}
}
