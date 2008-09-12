package org.epsilon.egl.doc;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.epsilon.egl.EglModule;
import org.epsilon.egl.EglModuleImpl;
import org.epsilon.egl.doc.egl.Egl;
import org.epsilon.egl.doc.util.FileUtil;
import org.epsilon.egl.doc.util.GraphVizUtil;
import org.epsilon.egl.exceptions.EglRuntimeException;
import org.epsilon.egl.status.StatusMessage;
import org.epsilon.egl.traceability.OutputFile;
import org.epsilon.egl.traceability.Template;
import org.epsilon.egl.util.UriUtil;
import org.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.epsilon.eol.execute.context.scope.Variable;
import org.epsilon.eol.models.emf.EmfModel;

public class EglDocFacade {
	
	private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String MOF2_URI = "http://www.eclipse.org/emf/2002/Ecore";
	
	private final EglModule module = new EglModuleImpl();
	
	private final String pathToDot;
	private final boolean generatePng;
	
	public EglDocFacade(String pathToDot) {
		this.pathToDot = pathToDot;
		this.generatePng = pathToDot != null;
	}
	
	private void loadModel(String modelName, File modelFile) throws EolModelLoadingException {
		final EmfModel model = new EmfModel();
		model.setModelFile(modelFile.getAbsolutePath());
		model.setName(modelName);
		model.setMetamodelUri(MOF2_URI);
		model.setMetamodelFileBased(false);
		
		model.load();
		module.getContext().getModelRepository().addModel(model);
	}
	
	public void generate(File model, String outputDirPath) throws IOException, EglRuntimeException, EolModelLoadingException, URISyntaxException {			
		final String metaModelName = model.getName().contains(".") ?
		                             model.getName().substring(0, model.getName().lastIndexOf(".")) : 
		                             model.getName();
		final URI  outputDirUri = UriUtil.fileToUri(new File(outputDirPath));
		final File outputDir    = new File(outputDirUri);
		
		System.out.println("Generating documentation for "+metaModelName);
		
		// Set directory from which nested templates will be loaded
		module.getContext().getTemplateFactory().setRoot(Egl.getBase());
		
		// Load model
		loadModel("OO", model);
		
		// Generate HTML
		module.getContext().getScope().put(Variable.createReadOnlyVariable("metaModelName", metaModelName));
		module.getContext().getScope().put(Variable.createReadOnlyVariable("outputDir", outputDirUri));
		
		module.parse(Egl.getToHtmlProgram());
		module.execute();
		
		for (StatusMessage message : module.getContext().getStatusMessages())
			System.out.println(message);
		
		if (generatePng) {
			// Generate DOT file
			module.parse(Egl.getToDotProgram());
			module.execute();
			
			for (StatusMessage message : module.getContext().getStatusMessages())
				System.out.println(message);
			
			// Get the subtemplate that generated the DOT file
			final Template sub = (Template)module.getContext().getTemplate().getChildren().get(0);
			// Get the output file
			final OutputFile of = (OutputFile)sub.getChildren().get(0);
			
			final File dotFile = new File(of.getURI());
			final File pngFile = new File(dotFile.getAbsolutePath().replaceFirst("\\.dot$", ".png"));
			
			// Generate PNG - determine the png's file name by replacing the extension
			generatePng(dotFile.getAbsolutePath(), pngFile.getAbsolutePath());
			
			// Move the png file
			FileUtil.moveFileToDir(pngFile, new File(outputDir + FILE_SEP + "img"));
		}
		
		// Copy the common files
		FileUtil.copyFile(Egl.getScreenCss(), new File(outputDir + FILE_SEP + "css"     + FILE_SEP + "screen.css"));
		FileUtil.copyFile(Egl.getUpArrow(),   new File(outputDir + FILE_SEP + "img"     + FILE_SEP + "arrow_up.png"));
		FileUtil.copyFile(Egl.getControls(),  new File(outputDir + FILE_SEP + "scripts" + FILE_SEP + "controls.js"));
	}
	
	private boolean generatePng(String inputFile, String outputFile) {
		final GraphVizUtil ig = new GraphVizUtil(pathToDot);
		return ig.generatePng(inputFile, outputFile);
	}
	
//	public static void main(String[] args) throws IOException, EglRuntimeException, EolModelLoadingException, URISyntaxException {
//		final EglDocFacade facade = new EglDocFacade();
//		
//		final String outputDir = "file:///" +
//		                         System.getProperty("user.dir") +
//		                         System.getProperty("file.separator") +
//		                         "output";
//		
//		System.out.println(outputDir);
//		
//		facade.generate(new File("c:\\temp\\OO.ecore"), outputDir);
//	}
}
