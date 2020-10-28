package org.eclipse.epsilon.eol.engine.test.acceptance.unparser;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.engine.test.acceptance.EolAcceptanceTestSuite;
import org.eclipse.epsilon.eol.parse.EolUnparser;
import org.junit.Test;

public class UnparserTests {
	
	@Test
	public void testEcore2GMF() throws Exception {
		testEolFile("ECore2GMF.eol", UnparserTests.class);
	}
	
	@Test
	public void testFormatting() throws Exception {
		testEolFile("Formatting.eol", UnparserTests.class);
	}
	
	@Test
	public void testElvis() throws Exception {
		testEolFile("ElvisTestsNoShortcut.eol", UnparserTests.class);
	}
	
	@Test
	public void testExistingEolTests() throws Exception {
		testEolFiles(EolAcceptanceTestSuite.class,
				"AnnotatedOperationTests.eol",
				"BooleanTests.eol",
				"BuiltInVariablesTests.eol",
				"CllectionPropertyTests.eol",
				"CollectionsTests.eol",
				"ComparisonTests.eol",
				"CreateDeleteTests.eol",
				"EqualityTests.eol",
				"IsDefinedTests.eol",
				"IterableTests.eol",
				"MathTests.eol",
				"ModelElementConstructorTests.eol",
				"ModelElementTypeResolutionTests.eol",
				"OperationOrderTests.eol",
				"PostfixOperatorTests.eol",
				"ReturnTypeTests.eol",
				"SafeNavigationTests.eol",
				"ScopeTests.eol",
				"StringTests.eol",
				"SwitchTests.eol",
				"TransactionTests.eol",
				"TypeConversionTests.eol"
				);
	}
	
	@SuppressWarnings("rawtypes")
	protected void testEolFiles(Class clazz, String... fileNames) throws Exception {
		for (String fileName : fileNames) {
			testEolFile(fileName, clazz);
		}
	}
	
	@SuppressWarnings("rawtypes")
	protected void testEolFile(String fileName, Class clazz) throws Exception {
		EolModule module = new EolModule();
		File file = FileUtil.getFileStandalone(fileName, clazz);
		module.parse(file);
		assertEquals(stripCommentsAndEmptyLines(file), stripCommentsAndEmptyLines(new EolUnparser().unparse(module)));
		
	}
	
	protected String stripCommentsAndEmptyLines(File file) throws Exception {
		List<String> lines = Files.readAllLines(file.toPath());
		return stripCommentsAndEmptyLines(lines);
	}
	
	protected String stripCommentsAndEmptyLines(String string) {
		return stripCommentsAndEmptyLines(Arrays.asList(string.split(System.lineSeparator())));
	}
	
	protected String stripCommentsAndEmptyLines(List<String> lines) {
		StringBuffer buffer = new StringBuffer();
		for (String line : lines) {
			if (!line.trim().isEmpty() && !line.trim().startsWith("//")) {
				buffer.append(line);
				buffer.append(System.lineSeparator());
			}
		}
		return buffer.toString();
	}
}
