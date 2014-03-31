package org.eclipse.epsilon.egx.engine.test.acceptance.util;

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
