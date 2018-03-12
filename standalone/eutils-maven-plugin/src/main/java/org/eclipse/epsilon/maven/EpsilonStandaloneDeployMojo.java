/*******************************************************************************
 * Copyright (c) 2016 Aston University.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Antonio Garcia-Dominguez - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.maven;

import static org.twdata.maven.mojoexecutor.MojoExecutor.artifactId;
import static org.twdata.maven.mojoexecutor.MojoExecutor.configuration;
import static org.twdata.maven.mojoexecutor.MojoExecutor.element;
import static org.twdata.maven.mojoexecutor.MojoExecutor.executeMojo;
import static org.twdata.maven.mojoexecutor.MojoExecutor.executionEnvironment;
import static org.twdata.maven.mojoexecutor.MojoExecutor.goal;
import static org.twdata.maven.mojoexecutor.MojoExecutor.groupId;
import static org.twdata.maven.mojoexecutor.MojoExecutor.plugin;
import static org.twdata.maven.mojoexecutor.MojoExecutor.version;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.BuildPluginManager;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * Uses gpg:sign-and-deploy-file to deploy the standalone Epsilon JARs. Normally
 * we would have used a Bash script, but then it wouldn't be able to use the
 * settings.xml from HIPP.
 *
 * This plugin needs to be invoked manually: it is not bound to any lifecycle
 * phase by default. This would deploy directly to Sonatype OSSRH snapshots:
 *
 * <code>
 *   mvn org.eclipse.epsilon:eutils-maven-plugin:deploy
 * </code>
 *
 * If we want to stage to releases, we'd use:
 *
 * <code>
 *   mvn org.eclipse.epsilon:eutils-maven-plugin:deploy \
 *     -Ddeploy.url=https://oss.sonatype.org/service/local/staging/deploy/maven2
 * </code>
 */
@Mojo(name = "deploy", defaultPhase = LifecyclePhase.NONE)
public class EpsilonStandaloneDeployMojo extends AbstractMojo {
	@Component
	private MavenProject mavenProject;

	@Component
	private MavenSession mavenSession;

	@Component
	private BuildPluginManager pluginManager;

	@Parameter(property = "deploy.repo", defaultValue = "ossrh")
	private String repoId;

	@Parameter(property = "deploy.url", defaultValue = "https://oss.sonatype.org/content/repositories/snapshots")
	private String url;

	@Parameter(property = "deploy.assembly", defaultValue = "assembly")
	private String assemblyPath;

	private static final Pattern PATTERN_SOURCESJAR = Pattern.compile("(epsilon-[0-9.]+-([a-zA-Z-]+))-sources.jar");

	public void execute() throws MojoExecutionException {
		final File outDir = new File(mavenProject.getBuild().getDirectory());
		if (!outDir.exists()) {
			throw new MojoExecutionException(String.format("Build output directory {} does not exist: please run the build and try again", outDir.getPath()));
		}

		final File assemblyDir = new File(mavenProject.getBasedir(), assemblyPath);
		if (!assemblyDir.exists()) {
			throw new MojoExecutionException(String.format("Assembly directory {} does not exist: please run the build and try again", assemblyDir.getPath())); 
		}

		for (File sourcesJar : outDir.listFiles()) {
			final Matcher match = PATTERN_SOURCESJAR.matcher(sourcesJar.getName());
			if (!match.matches()) {
				continue;
			}

			final String prefix = match.group(1);
			final String name = match.group(2);
			final File pom = new File(assemblyDir, name + ".pom");
			final File binJar = new File(outDir, prefix + ".jar");
			final File docJar = new File(outDir, prefix + "-javadoc.jar");

			executeMojo(
				plugin(
					groupId("org.apache.maven.plugins"),
					artifactId("maven-gpg-plugin"),
					version("1.6")
				),
				goal("sign-and-deploy-file"),
				configuration(
					// target repository
					element("repositoryId", this.repoId),
					element("url", this.url),
					// files
					element("pomFile", pom.getAbsolutePath()),
					element("file", binJar.getAbsolutePath()),
					element("javadoc", docJar.getAbsolutePath()),
					element("sources", sourcesJar.getAbsolutePath())),
				executionEnvironment(mavenProject, mavenSession, pluginManager));
		}
	}
}
