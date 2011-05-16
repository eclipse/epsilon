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
package org.eclipse.epsilon.workflow.tasks.eugenia;

import java.io.InputStream;

import org.eclipse.ant.core.AntRunner;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.junit.After;
import org.junit.Before;

/**
 * <p>
 * Base class for all the tests of the Eugenia Ant task.
 * </p>
 * 
 * <p>
 * Note: all tests based on this class must run as JUnit Plug-In tests, not as
 * regular tests, and the ui.workbench product needs to be run. We need a
 * working, open workbench for these tests.
 * </p>
 */
public class EugeniaTest {

	protected static final String[] CASE_EXTENSIONS = new String[] {
		"ecore", "emf", "genmodel", "gmfgen", "gmfgraph", "gmfmap", "gmftool"
	};
	protected static final String RES_PREFIX = "/eugenia/";

	private static final String ANT_BUILDFILE_PATH = RES_PREFIX + "eunit.xml";
	private final String caseName;
	private IProject testProject;

	/**
	 * Creates a new instance of this class.
	 * 
	 * @param caseName
	 *            Name of the subfolder in <code>resources</code> to be copied
	 *            to the test project. Please make sure that all the files in
	 *            that folder follow the pattern <code>casename.ext</code>,
	 *            where <code>casename</code> is the name of the subfolder, and
	 *            <code>ext</code> is one of the extensions in
	 *            {@link #CASE_EXTENSIONS}.
	 */
	public EugeniaTest(String caseName) {
		this.caseName = caseName;
	}

	public String getCaseName() {
		return caseName;
	}

	public IProject getTestProject() {
		return testProject;
	}

	@Before
	public void createTestProject() throws CoreException {
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IWorkspaceRoot root = workspace.getRoot();

		testProject = root.getProject("eugenia.test");
		testProject.create(null);
		testProject.open(null);

		copyIntoProject(ANT_BUILDFILE_PATH);
		for (String ext : CASE_EXTENSIONS) {
			final String srcPath = RES_PREFIX + caseName + "/" + caseName + "."	+ ext;
			copyIntoProject(srcPath);
		}
	}

	@After
	public void deleteTestProject() throws CoreException {
		testProject.delete(true, true, null);
	}

	public void runAntTarget(String target) throws CoreException {
		AntRunner runner = getAntRunner();
		runner.setExecutionTargets(new String[] { target });
		runner.run();
	}

	public void copyIntoProject(String path)
			throws CoreException {
		final InputStream source = getClass().getResourceAsStream(path);
		final IFile destFile = testProject.getFile(new Path(path));
		createParentFolders(destFile);
		destFile.create(source, true, null);
	}

	private void createParentFolders(IResource res) throws CoreException {
		final IContainer parent = res.getParent();
		if (parent instanceof IFolder) {
			createParentFolders(parent);
		}
		if (res instanceof IFolder && !res.exists()) {
			((IFolder) res).create(false, true, null);
		}
	}

	private AntRunner getAntRunner() {
		AntRunner runner = new AntRunner();
		runner.setBuildFileLocation(testProject.getFile(ANT_BUILDFILE_PATH)
				.getLocation().toOSString());
		runner.setArguments("-Dcase.name=" + caseName);
		return runner;
	}

}