/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eugenia;

import java.util.Arrays;
import java.util.List;

public class GenerateEcoreDelegate extends EugeniaWorkflowDelegate {

	protected List<EugeniaActionDelegate> getDelegates() {
		return Arrays.asList(
				new ClearGmfFileSetAction().setClearGmfFiles(false),
				new Emfatic2EcoreDelegate()/*,
				new AnnotateEcoreDelegate().setSaveEcore(true)*/);
	}

}
