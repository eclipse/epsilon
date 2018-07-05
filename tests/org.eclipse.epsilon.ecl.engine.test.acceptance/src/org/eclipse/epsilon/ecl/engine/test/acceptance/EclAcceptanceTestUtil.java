package org.eclipse.epsilon.ecl.engine.test.acceptance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;
import org.eclipse.epsilon.ecl.IEclModule;
import org.eclipse.epsilon.eol.launch.IEolRunConfiguration;

public class EclAcceptanceTestUtil {
	private EclAcceptanceTestUtil() {}
	
	@SafeVarargs
	public static Collection<IEolRunConfiguration<IEclModule, ?>> getScenarios(Supplier<? extends IEclModule>... moduleGetters) {
		ArrayList<IEolRunConfiguration<IEclModule, ?>> scenarios = new ArrayList<>();
		//TODO implement
		return scenarios;
	}
}
