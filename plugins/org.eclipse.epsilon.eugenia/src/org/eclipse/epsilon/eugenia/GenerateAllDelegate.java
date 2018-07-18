/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eugenia;

import java.util.Arrays;
import java.util.List;

import org.eclipse.epsilon.eugenia.patches.ApplyPatchesDelegate;
import org.eclipse.epsilon.eugenia.patches.GeneratePatchesDelegate;

public class GenerateAllDelegate extends EugeniaWorkflowDelegate {

	protected List<EugeniaActionDelegate> getDelegates() {
		return Arrays.asList(
				new ClearGmfFileSetAction(),
				new Emfatic2EcoreDelegate(),
				//new AnnotateEcoreDelegate(),
				new Ecore2GenModelDelegate().setClearConsole(false),
				new FixGenModelDelegate().setClearConsole(false),
				new GenerateToolGraphMapDelegate().setClearConsole(false),
				new GmfMap2GmfGenDelegate().setClearConsole(false),
				new FixGmfGenDelegate().setClearConsole(false),
				new GenerateEmfCodeDelegate(),
				new GenerateDiagramCodeDelegate().setTargetPart(targetPart),
				new GeneratePatchesDelegate(),
				new ApplyPatchesDelegate());
	}

}
