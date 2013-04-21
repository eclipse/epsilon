package org.eclipse.epsilon.eugenia;

import java.util.Arrays;
import java.util.List;

public class GenerateGenModelDelegate extends EugeniaWorkflowDelegate {

	@Override
	protected List<EugeniaActionDelegate> getDelegates() {
		return Arrays.asList(new ClearGmfFileSetAction().setClearGmfFiles(false),
				new Emfatic2EcoreDelegate(),
				new AnnotateEcoreDelegate(),
				new Ecore2GenModelDelegate().setClearConsole(false),
				new FixGenModelDelegate().setClearConsole(false));
	}

}
