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
import java.util.Arrays;
import java.util.Collection;

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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * <p>
 * Regression tests for Eugenia, based on EUnit.
 * </p>
 * 
 * <p>
 * Note 1: this test must be run as a Plug-in Test, as it needs to run inside a
 * workspace.
 * </p>
 * 
 * <p>
 * It is parameterized over several cases. To add a new case, add the name of
 * the subfolder in <code>resources/eugenia</code> to the
 * {@link #getCaseNames()} method. Please make sure that all the files in that
 * folder follow the pattern <code>casename.ext</code>, where
 * <code>casename</code> is the name of the subfolder, and <code>ext</code> is
 * one of the extensions in {@link #CASE_EXTENSIONS}.
 * </p>
 */
@RunWith(Parameterized.class)
public class EugeniaRegressionTest {
	private static final String RES_PREFIX = "/eugenia/";
	private static final String EUNIT_PATH = RES_PREFIX + "regression.eunit";
	private static final String ANT_BUILDFILE_PATH = RES_PREFIX + "eunit.xml";

	// Extensions of the files inside a case
	private static final String[] CASE_EXTENSIONS = new String[]{
		"ecore", "emf", "genmodel", "gmfgen", "gmfgraph", "gmfmap", "gmftool"
	};

	private final String caseName;
	private IProject testProject;

	@Parameters
	public static Collection<String[]> getCaseNames() {
		// These should be names of the folders in resources/eugenia
		// and the names of the Ant targets in eunit.xml
		return Arrays.asList(
				new String[] { "filesystem" },
				new String[] { "flowchart" },
				new String[] { "friends" }
		);
	}

	public EugeniaRegressionTest(String caseName) {
		this.caseName = caseName;
	}

	@Before
	public void createTestProject() throws CoreException {
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IWorkspaceRoot root  = workspace.getRoot();

		testProject = root.getProject("eugenia.test");
		testProject.create(null);
		testProject.open(null);

		copyIntoProject(ANT_BUILDFILE_PATH, testProject);
		copyIntoProject(EUNIT_PATH, testProject);
		for (String ext : CASE_EXTENSIONS) {
			final String srcPath = RES_PREFIX + caseName + "/" + caseName + "." + ext;
			copyIntoProject(srcPath, testProject);
		}
	}

	@After
	public void deleteTestProject() throws CoreException {
		testProject.delete(true, true, null);
	}

	@Test
	public void obtainExpectedModels() throws Exception {
		AntRunner runner = new AntRunner();
		runner.setBuildFileLocation(testProject.getFile(ANT_BUILDFILE_PATH).getLocation().toOSString());
		runner.setArguments("-Dcase.name=" + caseName);
		runner.setExecutionTargets(new String[]{"base-test"});
		runner.run();
	}

	private void copyIntoProject(String path, IProject project) throws CoreException {
		final InputStream source = getClass().getResourceAsStream(path);
		final IFile destFile = project.getFile(new Path(path));
		createParentFolders(destFile);
		destFile.create(source, true, null);
	}

	private void createParentFolders(IResource res) throws CoreException {
		final IContainer parent = res.getParent();
		if (parent instanceof IFolder) {
			createParentFolders(parent);
		}
		if (res instanceof IFolder && !res.exists()) {
			((IFolder)res).create(false, true, null);
		}
	}
}
