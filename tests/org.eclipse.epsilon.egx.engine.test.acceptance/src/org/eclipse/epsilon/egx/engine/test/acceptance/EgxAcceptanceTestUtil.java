package org.eclipse.epsilon.egx.engine.test.acceptance;

import static org.eclipse.epsilon.eol.engine.test.acceptance.util.EolAcceptanceTestUtil.*;
import static org.eclipse.epsilon.test.util.EpsilonTestUtil.*;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolAcceptanceTestUtil;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;

public class EgxAcceptanceTestUtil {
	private EgxAcceptanceTestUtil() {}
	
	public static final String
		//Core
		testsBase = getTestBaseDir(EgxAcceptanceTestSuite.class),
		metamodelsRoot = testsBase+"metamodels/",
		scriptsRoot = testsBase+"scripts/",
		modelsRoot = testsBase+"models/",
	
	//Metamodels and scripts
	thriftMetamodel = "thrift.ecore",
	thriftModels[] = {"ThriftTest.xmi", "fb303.xmi"},
	thriftScripts[] = {"thrift-java", "thrift-rb"};
		
	public static final List<String[]>
		thriftInputs,
		allInputs;
	
	static {
		thriftInputs = addAllInputs(thriftScripts, thriftModels, thriftMetamodel);
		allInputs = CollectionUtil.composeArrayListFrom(thriftInputs);
	}
	
	public static Collection<Supplier<? extends IEgxModule>> modules(boolean includeStandard) {
		//TODO
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static Collection<IEolRunConfiguration<IEgxModule, ?>> getScenarios(
		List<String[]> testInputs,
		boolean includeTest,
		Collection<Supplier<? extends IEgxModule>> moduleGetters
		) {
			Collection<IEolRunConfiguration<IEgxModule, ?>> scenarios = EolAcceptanceTestUtil
				.getScenarios(IEolRunConfiguration.class, testInputs, moduleGetters, null);
			//TODO
			return scenarios;
	}
	
	public static List<String[]> addAllInputs(String[] scripts, String[] models, String metamodel) {
		return EolAcceptanceTestUtil.addAllInputs(scripts, models, metamodel, "egx", scriptsRoot, modelsRoot, metamodelsRoot);
	}
}
