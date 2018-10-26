/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.egx.engine.test.acceptance;

import static org.eclipse.epsilon.test.util.EpsilonTestUtil.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.egl.concurrent.*;
import org.eclipse.epsilon.egl.launch.EgxRunConfiguration;
import org.eclipse.epsilon.eol.engine.test.acceptance.util.EolAcceptanceTestUtil;

public class EgxAcceptanceTestUtil extends EolAcceptanceTestUtil {
	private EgxAcceptanceTestUtil() {}
	
	public static final String
		testsBase = getTestBaseDir(EgxAcceptanceTestSuite.class),
		thriftBase = testsBase+"thrift/",
		thriftMetamodel = "thrift.ecore",
		thriftModels[] = {"ThriftTest.xmi", "fb303.xmi"},
		thriftScripts[] = {"thrift-java", "thrift-rb"};
		
	public static final List<String[]> thriftInputs;
	
	static {
		thriftInputs = addAllInputs(
			new String[]{thriftScripts[0]},
			thriftModels, thriftMetamodel, "egx",
			thriftBase+"java/", thriftBase, thriftBase
		);
		thriftInputs.addAll(addAllInputs(
			new String[]{thriftScripts[1]},
			thriftModels, thriftMetamodel, "egx",
			thriftBase+"ruby/", thriftBase, thriftBase
		));
	}
	
	public static Collection<Supplier<? extends IEgxModule>> modules(boolean includeStandard) {
		return parallelModules(THREADS, includeStandard ? EgxModule::new : null, EgxModuleParallel::new);
	}
	
	public static Collection<EgxRunConfiguration> getScenarios(
		List<String[]> testInputs,
		Collection<Supplier<? extends IEgxModule>> moduleGetters) {
			return getScenarios(EgxRunConfiguration.class, testInputs, moduleGetters, null);
	}
	
	public static void deleteOutputDirectories() throws IOException {
		deleteOutputDirectory(thriftBase+"java");
		deleteOutputDirectory(thriftBase+"ruby");
	}
	
	/**
	 * WARNIING: Use with caution!
	 * @param dir
	 * @throws IOException
	 */
	static void deleteOutputDirectory(String dir) throws IOException {
		Files.walk(Paths.get(dir+"/output/"))
	        .map(Path::toFile)
	        .sorted((o1, o2) -> -o1.compareTo(o2))
	        .forEach(File::delete);
	}
}
