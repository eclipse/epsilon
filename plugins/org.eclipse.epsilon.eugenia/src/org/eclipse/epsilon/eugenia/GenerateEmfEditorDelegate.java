/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eugenia;

import java.util.Arrays;
import java.util.List;

public class GenerateEmfEditorDelegate extends EugeniaWorkflowDelegate {

	@Override
	protected List<EugeniaActionDelegate> getDelegates() {
		return Arrays.asList(
				new ClearGmfFileSetAction().setClearGmfFiles(false),
				new Emfatic2EcoreDelegate(),
				/*new AnnotateEcoreDelegate(),*/
				new Ecore2GenModelDelegate().setClearConsole(false),
				new GenerateEmfCodeDelegate());
	}

}
