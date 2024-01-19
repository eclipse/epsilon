package org.eclipse.epsilon.examples.staticanalyser.evl;

import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.staticanalyser.EvlStaticAnalyser;
import org.eclipse.epsilon.examples.staticanalyser.eol.SubEmfModelFactory;

public class EvlPreExecuteConfiguration extends EolRunConfiguration {
	IEolModule module;

	public EvlPreExecuteConfiguration(EolRunConfiguration other) {
		super(other);
		module = super.getModule();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void preExecute() throws Exception {
		super.preExecute();
		module.getContext().setModule(module);
		long startTime = System.currentTimeMillis();
		if (module instanceof EvlModule) {
			EvlStaticAnalyser staticAnalyser = new EvlStaticAnalyser();
			for (ModelDeclaration modelDeclaration : module.getDeclaredModelDeclarations()) {
				if (modelDeclaration.getDriverNameExpression().getName().equals("EMF"))
					staticAnalyser.getContext().setModelFactory(new SubEmfModelFactory());
			}
			staticAnalyser.validate(module);
			long stopTime = System.currentTimeMillis();
			System.out.println("Static Analysis Took : " + (stopTime - startTime));
		}

	}
}
