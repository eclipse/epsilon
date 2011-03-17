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
import org.apache.tools.ant.Project;
import org.apache.tools.ant.helper.ProjectHelper2;
import org.apache.tools.ant.taskdefs.CallTarget;
import org.apache.tools.ant.taskdefs.Property;
import org.apache.tools.ant.taskdefs.optional.junit.XMLResultAggregator;
import org.eclipse.epsilon.workflow.tasks.EUnitTask;
import org.eclipse.epsilon.workflow.tasks.emf.LoadModel;
import org.junit.AfterClass;
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
public class EUnitJUnitXMLOutputTest implements ErrorHandler {

	private final static String ANT_BUILDFILE_NAME = "eunit.xml";
	private final static File BASE_DIR = new File("../org.eclipse.epsilon.workflow.test/resources/eunit/");

	@AfterClass
	public static void cleanUp() {
		for (String file : BASE_DIR.list()) {
			if (file.startsWith("TEST-") && file.endsWith(".xml")) {
				new File(BASE_DIR, file).delete();
			}
		}
	}

	@Test
	public void allPassProducesGoodOutput() throws Exception {
		runTarget("allPass");
		checkOutput(new File(BASE_DIR, "TEST-sample.eunit.xml"),
				new String[]{"twoElements", "firstElement"},
				new HashSet<String>(),
				new HashSet<String>());
	}

	@Test
	public void allPassProducesGoodOutputWithCustomRelativePathFromBuildDir() throws Exception {
		runTarget("allPassCustom");
		checkOutput(new File(BASE_DIR, "TEST-custom.xml"),
				new String[]{"twoElements", "firstElement"},
				new HashSet<String>(),
				new HashSet<String>());
	}

	@Test
	public void failingTestProducesGoodOutput() throws Exception {
		runTarget("failure");
		checkOutput(new File(BASE_DIR, "TEST-sample-failing.eunit.xml"),
				new String[]{"twoElements", "firstElement", "iAmAFailure"},
				new HashSet<String>(Arrays.asList("iAmAFailure")),
				new HashSet<String>());
	}

	@Test
	public void failingTestProducesGoodOutputEvenIfAborted() throws Exception {
		try {
			runTarget("failureFailOnError");
			fail("Should have thrown a BulidException (failed build)");
		} catch (BuildException ex) {
			// OK, build failed
		}
		// But it should *still* have generated a report
		checkOutput(new File(BASE_DIR, "TEST-sample-failing.eunit.xml"),
				new String[]{"twoElements", "firstElement", "iAmAFailure"},
				new HashSet<String>(Arrays.asList("iAmAFailure")),
				new HashSet<String>());
	}

	@Test
	public void testWithErrorsProducesGoodOutput() throws Exception {
		runTarget("error");
		checkOutput(new File(BASE_DIR, "TEST-sample-error.eunit.xml"),
				new String[]{"twoElements", "firstElement", "iAmError"},
				new HashSet<String>(),
				new HashSet<String>(Arrays.asList("iAmError")));
	}

	@Test
	public void parametric1LevelProducesGoodOutput() throws Exception {
		runTarget("parametric1level");
		checkOutput(new File(BASE_DIR, "TEST-sample-parametric-1level.eunit.xml"),
				new String[]{
					"twoElements (x = 1)", "firstElement (x = 1)",
					"twoElements (x = 2)", "firstElement (x = 2)"},
				new HashSet<String>(),
				new HashSet<String>());
	}

	@Test
	public void parametric2LevelsProducesGoodOutput() throws Exception {
		runTarget("parametric2levels");
		checkOutput(new File(BASE_DIR, "TEST-sample-parametric-2levels.eunit.xml"),
				new String[]{
					"twoElements (x = 1, y = 1)", "firstElement (x = 1, y = 1)",
					"twoElements (x = 1, y = 2)", "firstElement (x = 1, y = 2)",
					"twoElements (x = 2, y = 1)", "firstElement (x = 2, y = 1)",
					"twoElements (x = 2, y = 2)", "firstElement (x = 2, y = 2)",
				},
				new HashSet<String>(),
				new HashSet<String>());
	}

	private void runTarget(String targetName) {
		Project project = new Project();
		ProjectHelper2.configureProject(project, new File(BASE_DIR, ANT_BUILDFILE_NAME));
		project.setProperty("ant.file", ANT_BUILDFILE_NAME);
		project.addTaskDefinition("epsilon.eunit", EUnitTask.class);
		project.addTaskDefinition("epsilon.emf.loadModel", LoadModel.class);
		project.addTaskDefinition("junitreport", XMLResultAggregator.class);
		project.addTaskDefinition("antcall", CallTarget.class);
		project.addTaskDefinition("property", Property.class);
		project.executeTarget(targetName);
	}

	/**
	 * Checks that the JUnit-style XML reports are well-formed. There is no
	 * official schema for these, so we have defined our own schema for internal
	 * testing. We've based it on <a href="http://goo.gl/N5ZgP">the Ant source
	 * code</a> and <a href="http://goo.gl/Sznbo">this mailing list post</a>.
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
			String[] expectedTestCases,
			Set<String> expectedCasesWithFailures,
			Set<String> expectedCasesWithErrors)
		throws SAXException, ParserConfigurationException, IOException 
	{
		Schema junitXSD = loadJUnitSchema();
		Document doc = parseAndValidate(file, junitXSD);

		NodeList docChildren = doc.getDocumentElement().getChildNodes();
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
			assertTrue(sysOut.contains(testCase) || sysErr.contains(testCase));
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
