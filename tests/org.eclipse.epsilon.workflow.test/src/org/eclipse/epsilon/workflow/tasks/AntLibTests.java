/*******************************************************************************
 * Copyright (c) 2012 Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio García-Domínguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks;

import java.io.File;
import java.net.URL;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Typedef;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Checks that the &lt;antlib&gt; document for the workflow tasks is valid.
 *
 * @author Antonio García-Domínguez
 */
public class AntLibTests {

	private static final String ANTLIB_PATH = "/org/eclipse/epsilon/workflow/tasks/epsilontasks.xml";

	@Test
	public void antlibIsValid() throws Exception {
		final Project p = new Project();
		final URL antlibURL = AntLibTests.class.getResource(ANTLIB_PATH);
		final String antlibPath = antlibURL.toURI().getPath();
		final File antlibFile = new File(antlibPath);

		final Typedef td = new Typedef();
		td.setProject(p);
		td.setFile(antlibFile);
		td.execute();

		final Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(antlibFile);
		final NodeList taskdefs = d.getElementsByTagName("taskdef");
		for (int i = 0; i < taskdefs.getLength(); ++i) {
			final Element e = (Element)taskdefs.item(i);
			p.createTask(e.getAttribute("name"));
		}
	}
}
