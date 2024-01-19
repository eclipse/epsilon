package org.eclipse.epsilon.examples.staticanalyser.eol;

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dom.ModelDeclaration;
import org.eclipse.epsilon.eol.launch.EolRunConfiguration;
import org.eclipse.epsilon.eol.staticanalyser.EolStaticAnalyser;
import org.eclipse.epsilon.eol.staticanalyser.EolStaticAnalysisContext;

public class EolPreExecuteConfiguration extends EolRunConfiguration {
	IEolModule module;

	public EolPreExecuteConfiguration(EolRunConfiguration other) {
		super(other);
		module = super.getModule();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void preExecute() throws Exception {
		super.preExecute();
		
		module.getContext().setModule(module);
		long startTime = System.currentTimeMillis();
		if (module instanceof EolModule) {
			EolStaticAnalyser staticAnalyser = new EolStaticAnalyser();
		//	staticAnalyser.setContext(new EolStaticAnalysisContext());
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
