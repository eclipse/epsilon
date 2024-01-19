package org.eclipse.epsilon.examples.staticanalyser.ecl;

import org.eclipse.epsilon.ecl.launch.EclRunConfiguration;
import org.eclipse.epsilon.ecl.staticanalyser.EclStaticAnalyser;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.staticanalyser.SubEmfModelFactory;

public class EclPreExecuteConfiguration extends EclRunConfiguration {
	IEolModule module;

	public EclPreExecuteConfiguration(EclRunConfiguration runConfig) {
		super(runConfig);
		module = super.getModule();
	}

	@Override
	protected void preExecute() throws Exception {
		super.preExecute();

		EclStaticAnalyser staticAnalyser = new EclStaticAnalyser();
		staticAnalyser.getContext().setModelFactory(new SubEmfModelFactory());

		staticAnalyser.validate(module);
	}

}
