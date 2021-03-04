/*******************************************************************************
 * Copyright (c) 2014 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egx.engine.test.acceptance.hutn;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.epsilon.egl.EgxModule;
import org.junit.Test;

public class AppendTests {
	
	@Test
	public void testAppendWithAnnotation() throws Exception {
		String egx = "@append\n"       +
				 "rule I2T transform i : Integer in: 1.to(2) {"    +
		         "    template: _template " +
		         "    target: 'out.txt' "    + 
		         "}";
		
		testAppend(egx, "1\n2");	
	}
	
	@Test
	public void testAppendWithTrueBlock() throws Exception {
		String egx = "rule I2T transform i : Integer in: 1.to(2) {"    +
			         "    template: _template " +
			         "    append: true " +
		             "    target: 'out.txt' "    + 
		             "}";
		
		testAppend(egx, "1\n2");	
	}
	
	@Test
	public void testAppendWithFalseBlock() throws Exception {
		String egx = "rule I2T transform i : Integer in: 1.to(2) {"    +
			         "    template: _template " +
			         "    append: false " +
		             "    target: 'out.txt' "    + 
		             "}";
		
		testAppend(egx, "2");	
	}
	
	@Test
	public void testNoAppend() throws Exception {
		String egx = "rule I2T transform i : Integer in: 1.to(2) {"    +
			         "    template: _template " +
			         "    target: 'out.txt' "    + 
		             "}";
		
		testAppend(egx, "2");	
	}
	
	public void testAppend(String egx, String expected) throws Exception {
		
		String egl = "[%=i%]";
		File template = toFile(egl);
		Path outputRoot = Files.createTempDirectory(null);
		
		EgxModule module = new EgxModule(outputRoot);
		module.parse(egx);
		module.getContext().getFrameStack().put("_template", template.getAbsolutePath());
		module.execute();
		
		assertEquals(expected, new String(Files.readAllBytes(new File(outputRoot.toFile(), "out.txt").toPath())));
		
	}
	
	public File toFile(String content) throws Exception {
		Path path = Files.createTempFile(null, "egl");
		Files.write(path, content.getBytes(StandardCharsets.UTF_8));
		return path.toFile();

	}
	
}
