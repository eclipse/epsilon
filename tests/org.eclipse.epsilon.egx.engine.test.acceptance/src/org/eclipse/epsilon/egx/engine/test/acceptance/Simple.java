package org.eclipse.epsilon.egx.engine.test.acceptance;

import static org.junit.Assert.*;

import java.io.File;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EgxModule;
import org.eclipse.epsilon.egx.engine.test.acceptance.util.FamiliesModelConstructor;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.hutn.test.model.HutnTestWithFamiliesMetaModel;
import org.junit.Test;

public class Simple extends EgxAcceptanceTest {

	private static final String egx = "rule Person2Greeting transform p : Person { template: \"hello.egl\" target: \"out.txt\" }";
	private static final String egl = "Hello [%=p.name%]";
	
	private static final String model = "Families { Person { name: \"John\" } }";
	
	@Test
	public void egxRuleAppliesToModelElement() throws Exception {
		File egxFile = FileUtil.getFile("simple.egx", Simple.class);
		File eglFile = FileUtil.getFile("hello.egl", Simple.class);
		
		FileUtil.setFileContents(egx, egxFile);
		FileUtil.setFileContents(egl, eglFile);
		
		runEgx(egxFile, model);
		
		File outFile = FileUtil.getFile("out.txt", Simple.class);
		String result = FileUtil.getFileContents(outFile);
		
		assertEquals("Hello John", result.trim());
	}
}
