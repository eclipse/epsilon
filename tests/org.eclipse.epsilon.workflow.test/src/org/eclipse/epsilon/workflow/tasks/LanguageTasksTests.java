package org.eclipse.epsilon.workflow.tasks;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.apache.tools.ant.BuildFileRule;
import org.apache.tools.ant.Task;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.workflow.tasks.ExecutableModuleTask.ModuleProperty;
import org.junit.Rule;
import org.junit.Test;

/**
 * We are only interested in what properties where used by the language task, not the outcome of executing
 * the script.
 * @author Horacio Hoyos Rodriguez
 *
 */
public class LanguageTasksTests {
	
	protected static final File BASE_DIR = new File("../org.eclipse.epsilon.workflow.test/resources/epsilon/");
	
	@Rule
    public final BuildFileRule buildRule = new BuildFileRule();

	@Test
	public void eolModuleInLine() throws Exception {
		
		final String eolExp = "      \"Hello world\".println();";
		final String initTask = createTaskDefTarget("Eol");
		final StringBuilder mainBuilder = new StringBuilder();
		mainBuilder.append("<target name=\"main\" depends=\"eol.init\">");
		mainBuilder.append("  <epsilon.eol id=\"eol\">");		// Use id so its not disposed
		mainBuilder.append("    <![CDATA[");
		mainBuilder.append(eolExp);
        mainBuilder.append("    ]]>");
        mainBuilder.append("  </epsilon.eol>");
        mainBuilder.append("</target>");
        //builder.append('\n');
        File buildFile = createBuildFile("main", initTask, mainBuilder.toString());
        buildRule.configureProject(buildFile.getAbsolutePath());   
        buildRule.executeTarget("main");
        
        Task task = buildRule.getProject().getTargets().get("main").getTasks()[0];
        assertThat(task, instanceOf(EolTask.class));
        EolTask eolTask = (EolTask)task;
        assertThat(eolTask.code.trim(), is(eolExp.trim()));
        assertThat(eolTask.src, is(nullValue()));
        buildFile.delete();
        
	}
	
	@Test
	public void eolModuleFromSource() throws Exception {
		
		final String eolExp = "\"Hello world\".println();";
		final File eolSrc = File.createTempFile("eolTest", ".eol");
		FileUtil.setFileContents(eolExp, eolSrc);		
		
		final String initTask = createTaskDefTarget("Eol");
		final StringBuilder mainBuilder = new StringBuilder();
		mainBuilder.append("<target name=\"main\" depends=\"eol.init\">");
		mainBuilder.append(String.format("  <epsilon.eol id=\"eol\" src=\"%s\"/>", eolSrc.getAbsolutePath()));	// Use id so its not disposed
		mainBuilder.append("</target>");
        //builder.append('\n');
        File buildFile = createBuildFile("main", initTask, mainBuilder.toString());
        buildRule.configureProject(buildFile.getAbsolutePath());   
        buildRule.executeTarget("main");
        
        Task task = buildRule.getProject().getTargets().get("main").getTasks()[0];
        assertThat(task, instanceOf(EolTask.class));
        EolTask eolTask = (EolTask)task;
        assertThat(eolTask.code, isEmptyString());
        assertThat(eolTask.src.getAbsolutePath(), is(eolSrc.getAbsolutePath()));
        buildFile.delete();
	}
	
	@Test
	public void eclModuleFromSource() throws Exception {
		
		File basedir = new File("resources/");
		File eclFile = new File("resources/epsilon/ecl/tree.ecl");
		
		String modelTarget = createModelLoadTarget(basedir.getAbsolutePath());
		final String initTask = createTaskDefTarget("Ecl");
		final StringBuilder mainBuilder = new StringBuilder();
		mainBuilder.append("<target name=\"main\" depends=\"ecl.init, loadModels\">");
		mainBuilder.append(String.format("  <epsilon.ecl id=\"ecl\" src=\"%s\">", eclFile.getAbsolutePath()));	// Use id so its not disposed
		mainBuilder.append("test<model ref=\"T1\"/>");
		mainBuilder.append("<model ref=\"T2\"/>");
		mainBuilder.append("</epsilon.ecl>");
		mainBuilder.append("</target>");
		
		File buildFile = createBuildFile("main", modelTarget, initTask, mainBuilder.toString());
        buildRule.configureProject(buildFile.getAbsolutePath());   
        buildRule.executeTarget("main");
        
        Task task = buildRule.getProject().getTargets().get("main").getTasks()[0];
        assertThat(task, instanceOf(EclTask.class));
        EclTask eclTask = (EclTask)task;
        assertThat(eclTask.code, isEmptyString());
        assertThat(eclTask.src.getAbsolutePath(), is(eclFile.getAbsolutePath()));
        buildFile.delete();
	}
	
	@Test
	public void evlModuleFromSource() throws Exception {
		
		File basedir = new File("resources/");
		File evlFile = new File("resources/epsilon/evl/tree.evl");
		
		String modelTarget = createModelLoadTarget(basedir.getAbsolutePath());
		final String initTask = createTaskDefTarget("Evl");
		final StringBuilder mainBuilder = new StringBuilder();
		mainBuilder.append("<target name=\"main\" depends=\"evl.init, loadModels\">");
		mainBuilder.append(String.format("  <epsilon.evl id=\"evl\" src=\"%s\" ", evlFile.getAbsolutePath()));	// Use id so its not disposed
		mainBuilder.append("moduleimplementation=\"org.eclipse.epsilon.evl.concurrent.EvlModuleParallelAnnotation\">");
		mainBuilder.append("  <moduleProperty name=\"optimizeConstraints\" value=\"true\"/>");
		mainBuilder.append("  <moduleproperty name=\"parallelism\" value=\"6\"/>");
		mainBuilder.append("  <model ref=\"T1\"/>");
		mainBuilder.append("</epsilon.evl>");
		mainBuilder.append("</target>");
		
		File buildFile = createBuildFile("main", modelTarget, initTask, mainBuilder.toString());
        buildRule.configureProject(buildFile.getAbsolutePath());   
        buildRule.executeTarget("main");
        
        Task task = buildRule.getProject().getTargets().get("main").getTasks()[0];
        assertThat(task, instanceOf(EvlTask.class));
        EvlTask evlTask = (EvlTask)task;
        assertThat(evlTask.code, isEmptyString());
        assertThat(evlTask.src.getAbsolutePath(), is(evlFile.getAbsolutePath()));
        assertThat(evlTask.properties, is(not(empty())));
        ModuleProperty oc = evlTask.properties.get(0);
        assertThat(oc.name, is("optimizeConstraints"));
        assertThat(oc.value, is("true"));
        ModuleProperty parallelism = evlTask.properties.get(1);
        assertThat(parallelism.name, is("parallelism"));
        assertThat(parallelism.value, is("6"));
        buildFile.delete();
	}

	
	/**
	 * Create an ant target to init the language task definition
	 * @param language the name of the language, e.g. Eol, Etl, etc.
	 * @return
	 */
	public static String createTaskDefTarget(String language) {
		
		final StringBuilder builder = new StringBuilder();
		builder.append(String.format("<target name=\"%s.init\"", language.toLowerCase()));
		builder.append(String.format("        description=\"Load the %s task\">", language.toLowerCase()));
		builder.append(String.format("  <taskdef name=\"epsilon.%s\"", language.toLowerCase()));
		builder.append(String.format("    classname=\"org.eclipse.epsilon.workflow.tasks.%sTask\"/>", language));
		builder.append("</target>");
		return builder.toString();
	}
	
	/**
	 * Creates 
	 */
	public static String createModelLoadTarget(String baseDir) {
		
		final StringBuilder builder = new StringBuilder();
		builder.append(String.format("<property name=\"models.location\" location=\"%s/models\" />", baseDir));
		builder.append(String.format("<property name=\"metamodels.location\" location=\"%s/metamodels\" />", baseDir));
		builder.append("<property name=\"tree.model.location\" location=\"${models.location}/tree.model\" />");
		builder.append("<property name=\"tree.metamodel.location\" location=\"${metamodels.location}/tree.ecore\" />");
		builder.append("<property name=\"tree.metamodel.uri\" value=\"Tree\" />");
		builder.append("<target name=\"loadModels\">");
		builder.append("  <taskdef name=\"epsilon.emf.loadModel\"");
		builder.append("    classname=\"org.eclipse.epsilon.workflow.tasks.emf.LoadEmfModelTask\"/>");
		builder.append("  <epsilon.emf.loadModel name=\"T1\"");
		builder.append("    modelfile=\"${tree.model.location}\" metamodelfile=\"${tree.metamodel.location}\"");
		builder.append("    read=\"true\" store=\"false\"/>");
		builder.append("  <epsilon.emf.loadModel name=\"T2\"");
		builder.append("    modelfile=\"${tree.model.location}\" metamodelfile=\"${tree.metamodel.location}\"");
		builder.append("    read=\"true\" store=\"false\"/>");
		builder.append("</target>");
		return builder.toString();
	}
	
	/**
	 * Create a build file (xml) by adding the task definitions to a basic proejct structure
	 * @param taskDefinition
	 * @return
	 * @throws Exception If there is an error creating the file or adding the contents
	 */
	public static File createBuildFile(String defaultTarget, String... targetDefinition) throws Exception {
		final StringBuilder builder = new StringBuilder();
		builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		builder.append('\n');
		builder.append(String.format("<project default=\"%s\">", defaultTarget));
		builder.append('\n');
		for (String task : targetDefinition) {
			builder.append(task);
			builder.append('\n');
		}
		builder.append("</project>");
		final File tmp = File.createTempFile("EpsilonWorkflowTaskTest", ".xml");
		FileUtil.setFileContents(builder.toString(), tmp);
		return tmp;
	}

}
