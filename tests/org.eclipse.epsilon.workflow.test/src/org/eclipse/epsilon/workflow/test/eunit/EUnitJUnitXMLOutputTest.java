/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.test.eunit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.apache.tools.ant.BuildException;
import org.eclipse.epsilon.eol.eunit.EUnitModule;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Tests that the EUnit Ant task produces well-formed JUnit XML reports.
 *
 * @author Antonio García-Domínguez
 * @version 1.0
 */
public class EUnitJUnitXMLOutputTest extends EUnitTestCase implements ErrorHandler {

	@Test
	public void allPassProducesGoodOutput() throws Exception {
		runTarget(ANT_BUILD_FILE, "allPass");
		checkOutput(new File(BASE_DIR, "TEST-default.sample.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{"twoElements", "firstElement"},
				new HashSet<String>(), new HashSet<String>());
	}

	@Test
	public void allPassProducesGoodOutputWithCustomRelativePathFromBuildDir() throws Exception {
		runTarget(ANT_BUILD_FILE, "allPassCustom");
		checkOutput(new File(BASE_DIR.getParentFile(), "TEST-default.sample.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{"twoElements", "firstElement"},
				new HashSet<String>(), new HashSet<String>());
	}

	@Test
	public void failingTestProducesGoodOutput() throws Exception {
		runTarget(ANT_BUILD_FILE, "failure");
		checkOutput(new File(BASE_DIR, "TEST-default.sample-failing.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{"twoElements", "firstElement", "iAmAFailure"},
				new HashSet<String>(Arrays.asList("iAmAFailure")), new HashSet<String>());
	}

	@Test
	public void failingTestProducesGoodOutputEvenIfAborted() throws Exception {
		try {
			runTarget(ANT_BUILD_FILE, "failureFailOnError");
			fail("Should have thrown a BulidException (failed build)");
		} catch (BuildException ex) {
			// OK, build failed
		}
		// But it should *still* have generated a report
		checkOutput(new File(BASE_DIR, "TEST-default.sample-failing.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{"twoElements", "firstElement", "iAmAFailure"},
				new HashSet<String>(Arrays.asList("iAmAFailure")), new HashSet<String>());
	}

	@Test
	public void testWithErrorsProducesGoodOutput() throws Exception {
		runTarget(ANT_BUILD_FILE, "error");
		checkOutput(new File(BASE_DIR, "TEST-default.sample-error.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{"twoElements", "firstElement", "iAmError"},
				new HashSet<String>(), new HashSet<String>(Arrays.asList("iAmError")));
	}

	@Test
	public void parametricHandleErrors() throws Exception {
		final String[] expectedTestCases = new String[]{"root"};

		runTarget(ANT_BUILD_FILE, "parametricHandleErrors");
		checkOutput(new File(BASE_DIR, "TEST-default.sample-parametric-handle-errors.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				expectedTestCases,
				new HashSet<String>(),
				new HashSet<String>(Arrays.asList(expectedTestCases)));
	}

	@Test
	public void parametric1LevelProducesGoodOutput() throws Exception {
		runTarget(ANT_BUILD_FILE, "parametric1level");
		checkOutput(new File(BASE_DIR, "TEST-default.sample-parametric-1level.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{
					"twoElements[1]", "firstElement[1]",
					"twoElements[2]", "firstElement[2]"},
				new HashSet<String>(), new HashSet<String>());
	}

	@Test
	public void parametric2LevelsProducesGoodOutput() throws Exception {
		runTarget(ANT_BUILD_FILE, "parametric2levels");
		checkOutput(new File(BASE_DIR, "TEST-default.sample-parametric-2levels.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{
					"twoElements[1][1]", "firstElement[1][1]",
					"twoElements[1][2]", "firstElement[1][2]",
					"twoElements[2][1]", "firstElement[2][1]",
					"twoElements[2][2]", "firstElement[2][2]",
				},
				new HashSet<String>(), new HashSet<String>());
	}

	@Test
	public void customPackageIsHonored() throws Exception {
		runTarget(ANT_BUILD_FILE, "package");
		checkOutput(new File(BASE_DIR, "TEST-mypackage.sample.xml"),
				"mypackage",
				new String[]{"twoElements", "firstElement"},
				new HashSet<String>(), new HashSet<String>());
	}

	@Test
	public void withIsHonored() throws Exception {
		runTarget(ANT_BUILD_FILE, "withAnnotation");
		checkOutput(new File(BASE_DIR, "TEST-default.with-annotation.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{
					"hasOneA[1]", "hasOneA[2]",
					"hasOneB", "hasTwoB",
				},
				new HashSet<String>(), new HashSet<String>());
	}

	@Test
	public void withUsingMissingModelsIsFailedTestCase() throws Exception {
		runTarget(ANT_BUILD_FILE, "withAnnotationMissingModel");
		checkOutput(new File(BASE_DIR, "TEST-default.with-annotation-missing-model.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{
					"hasOneA[1]", "hasOneA[2]"
				},
				new HashSet<String>(), new HashSet<String>(Arrays.asList("hasOneA[2]")));
	}

	@Test
	public void withCanUseDataVariables() throws Exception {
		runTarget(ANT_BUILD_FILE, "withAnnotationCombineData");
		checkOutput(new File(BASE_DIR, "TEST-default.with-annotation-combine-data.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{
					"hasOneA[1]", "hasOneA[2]"
				},
				new HashSet<String>(), new HashSet<String>());
	}

	@Test
	public void withCanUseDataVariablesHandleErrors() throws Exception {
		runTarget(ANT_BUILD_FILE, "withAnnotationCombineDataHandleErrors");
		checkOutput(new File(BASE_DIR, "TEST-default.with-annotation-combine-data-handle-errors.xml"),
				EUnitModule.DEFAULT_PACKAGE,
				new String[]{
					"hasOneA[1]", "hasOneA[2]"
				},
				new HashSet<String>(), new HashSet<String>(Arrays.asList("hasOneA[1]", "hasOneA[2]")));
	}

	/**
	 * Checks that the JUnit-style XML reports are well-formed. There is no
	 * official schema for these, so we have defined our own schema for internal
	 * testing. We've based it on <a href="http://goo.gl/N5ZgP">the Ant source
	 * code</a> and <a href="http://goo.gl/Sznbo">this mailing list post</a>.
	 * @param expectedPackage TODO
	 * @throws SAXException
	 *             XML Schema could not be loaded, or the JUnit XML output could
	 *             not be parsed or was invalid.
	 * @throws ParserConfigurationException
	 *             There was a problem while configuring the XML parser for the
	 *             JUnit XML output.
	 * @throws IOException
	 *             There was a problem while reading from the specified path.
	 */
	private void checkOutput(File file,
			String expectedPackage,
			String[] expectedTestCases,
			Set<String> expectedCasesWithFailures, Set<String> expectedCasesWithErrors)
		throws SAXException, ParserConfigurationException, IOException 
	{
		Schema junitXSD = loadJUnitSchema();
		Document doc = parseAndValidate(file, junitXSD);

		final Element suiteElem = doc.getDocumentElement();
		final String qualifiedSuiteName = suiteElem.getAttribute("name");
		final String expectedPackagePrefix = expectedPackage + ".";
		assertTrue(qualifiedSuiteName.startsWith(expectedPackagePrefix));

		NodeList docChildren = suiteElem.getChildNodes();
		int nTestCases = 0;
		String sysOut = null;
		String sysErr = null;
		for (int i = 0; i < docChildren.getLength(); ++i) {
			Node n = docChildren.item(i);
			if (n instanceof Element) {
				Element e = (Element)n;
				final String tagName = e.getTagName();
				if (tagName.equals("testcase")) {
					final String testCaseName = e.getAttribute("name");
					assertThat(
						String.format("The %d-th test case in the report should be %s",
								nTestCases+1, expectedTestCases[nTestCases]),
						testCaseName,
						is(equalTo(expectedTestCases[nTestCases])));

					final String className = e.getAttribute("classname");
					assertTrue(className.startsWith(expectedPackagePrefix));

					if (expectedCasesWithFailures.contains(testCaseName)) {
						assertHasChildWithTag(e, "failure");
					}
					else if (expectedCasesWithErrors.contains(testCaseName)) {
						assertHasChildWithTag(e, "error");
					}
					nTestCases++;
				}
				else if (tagName.equals("system-out")) {
					sysOut = e.getTextContent();
				}
				else if (tagName.equals("system-err")) {
					sysErr = e.getTextContent();
				}
			}
		}
		assertThat(
			"There should be " + expectedTestCases.length + " test cases in the report",
			nTestCases, is(equalTo(expectedTestCases.length)));

		assertThat("Report should include stdout", sysOut, is(notNullValue()));
		assertThat("Report should include stderr", sysErr, is(notNullValue()));
		for (String testCase : expectedTestCases) {
			assertTrue("Report should mention test case " + testCase,
					sysOut.contains(testCase) || sysErr.contains(testCase));
		}
	}

	private Schema loadJUnitSchema() throws SAXException {
		SchemaFactory schemaFactory
			= SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema junitXSD = schemaFactory.newSchema(new File(BASE_DIR, "junit.xsd"));
		return junitXSD;
	}

	private Document parseAndValidate(File file, Schema junitXSD)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory docBuilderFactory
			= DocumentBuilderFactory.newInstance();
		docBuilderFactory.setSchema(junitXSD);
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		docBuilder.setErrorHandler(this);
		Document doc = docBuilder.parse(file);
		return doc;
	}

	private void assertHasChildWithTag(Element e, final String findTagName) {
		final NodeList caseChildren = e.getChildNodes();
		for (int iCase = 0; iCase < caseChildren.getLength(); ++iCase) {
			Node nCase = caseChildren.item(iCase);
			if (nCase instanceof Element) {
				Element elemCase = (Element)nCase;
				if (elemCase.getTagName().equals(findTagName)) {
					return;
				}
			}
		}
		fail("Element does not have a child with the tag " + findTagName);
	}

	public void warning(SAXParseException exception) throws SAXException {
		failSAXParseException("warning", exception);
	}

	public void error(SAXParseException exception) throws SAXException {
		failSAXParseException("error", exception);
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		failSAXParseException("fatal error", exception);
	}

	private void failSAXParseException(String type, SAXParseException exception) {
		fail(String.format("SAX %s at %d:%d: %s",
				type,
				exception.getLineNumber(),
				exception.getColumnNumber(),
				exception.getMessage()));
	}

}
