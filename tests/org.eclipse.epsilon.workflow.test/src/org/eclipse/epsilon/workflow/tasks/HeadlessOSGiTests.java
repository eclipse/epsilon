package org.eclipse.epsilon.workflow.tasks;

import java.io.File;

import org.eclipse.ant.core.AntRunner;
import org.eclipse.epsilon.common.util.FileUtil;
import org.junit.Test;

public class HeadlessOSGiTests {
	
	@Test
	public void test() throws Exception {
		
		File buildFile = FileUtil.getFileStandalone("headlessosgi.xml", HeadlessOSGiTests.class);
		
		AntRunner runner = new AntRunner();
		runner.setBuildFileLocation(buildFile.getAbsolutePath());
		runner.run();
		
	}
}
