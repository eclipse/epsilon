package org.eclipse.epsilon.picto.source;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.launching.extensions.ModelTypeExtension;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.egl.IEgxModule;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.epsilon.picto.LazyEgxModule;
import org.eclipse.epsilon.picto.LazyEgxModule.LazyGenerationRuleContentPromise;
import org.eclipse.epsilon.picto.PictoSource;
import org.eclipse.epsilon.picto.ResourceLoadingException;
import org.eclipse.epsilon.picto.StringContentPromise;
import org.eclipse.epsilon.picto.ViewTree;
import org.eclipse.epsilon.picto.dom.Model;
import org.eclipse.epsilon.picto.dom.Parameter;
import org.eclipse.epsilon.picto.dom.Picto;
import org.eclipse.ui.IEditorPart;

public abstract class EglPictoSource implements PictoSource {
	
	protected List<IModel> models = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	@Override
	public ViewTree getViewTree(IEditorPart editor) throws Exception {
		
		File modelFile = new File(getFile(editor).getLocation().toOSString());
		Resource resource;
		ViewTree viewTree = new ViewTree();
		
		try {
			resource = getResource(editor);
		}
		catch (Exception ex) {
			throw new ResourceLoadingException(ex);
		}
		
		Picto renderingMetadata = getRenderingMetadata(editor);
		
		if (renderingMetadata != null) {
			IEolModule module;	
			IModel model = null;
			
			//if (renderingMetadata.getNsuri() != null) {
			//	EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(renderingMetadata.getNsuri());
			//	model = new InMemoryEmfModel("M", resource, ePackage);
			//}
			//else {
			if (resource != null) {
				model = new InMemoryEmfModel("M", resource);
				((InMemoryEmfModel) model).setExpand(false);
			}
			//}
			
			if (renderingMetadata.getFormat().equals("egx")) {
				module = new LazyEgxModule();
			}
			else {
				module = new EglTemplateFactoryModuleAdapter(new EglFileGeneratingTemplateFactory());
			}
			
			if (renderingMetadata.getTemplate() == null) throw new Exception("No EGL file specified.");
			
			File eglFile = new File(renderingMetadata.getTemplate()); 
			if (!eglFile.isAbsolute()) {
				eglFile = new File(modelFile.getParentFile(), renderingMetadata.getTemplate());
			}
			
			if (!eglFile.exists()) throw new Exception("Cannot find file " + eglFile.getAbsolutePath());
			
			module.parse(eglFile);
			
			IEolContext context = module.getContext();
			context.setOutputStream(EpsilonConsole.getInstance().getDebugStream());
			context.setErrorStream(EpsilonConsole.getInstance().getErrorStream());
			context.setWarningStream(EpsilonConsole.getInstance().getWarningStream());		
			if (model != null) context.getModelRepository().addModel(model);
			
			for (Model pictoModel : renderingMetadata.getModels()) {
				model = loadModel(pictoModel, modelFile);
				if (model != null) models.add(model);
			}
			
			context.getModelRepository().addModels(models);
			
			if (renderingMetadata.getFormat().equals("egx")) {
				
				EglTemplateFactory templateFactory = new EglTemplateFactory();
				templateFactory.setTemplateRoot(eglFile.getParentFile().toURI().toString());
				((IEgxModule) module).getContext().setTemplateFactory(templateFactory);
				
				List<LazyGenerationRuleContentPromise> instances = (List<LazyGenerationRuleContentPromise>) module.execute();
				for (LazyGenerationRuleContentPromise instance : instances) {
					String format = "html";
					String icon = "cccccc";
					Collection<String> path = new ArrayList<>(Arrays.asList(""));
					
					for (Variable variable : instance.getVariables()) {
						switch (variable.getName()) {
						case "format": format = variable.getValue() + ""; break;
						case "path": path = (Collection<String>) variable.getValue(); break;
						case "icon": icon = variable.getValue() + ""; break;
						}
					}
					
					viewTree.addPath(new ArrayList<>(path), instance, format, icon);
				}
				
			}
			else {
				String content = module.execute() + "";
				viewTree = new ViewTree();
				viewTree.setPromise(new StringContentPromise(content));
				viewTree.setFormat(renderingMetadata.getFormat());
			}
			
			return viewTree;
		}
		else {
			viewTree = new ViewTree();
			viewTree.setPromise(new StringContentPromise("Nothing to render"));
			viewTree.setFormat("text");
			return viewTree;
		}
		
	}
	
	public void dispose() {
		for (IModel model : models) {
			try {
				model.dispose();
			}
			catch (Exception ex) {
				LogUtil.log(ex);
			}
		}
		models.clear();
	}
	
	protected IModel loadModel(Model model, File baseFile) throws Exception {
		IModel m = ModelTypeExtension.forType(model.getType()).createModel();
		m.setName(model.getName());
		m.setReadOnLoad(true);
		m.setStoredOnDisposal(false);
		StringProperties properties = new StringProperties();
		for (Parameter parameter : model.getParameters()) {
			properties.put(parameter.getName(), parameter.getValue());
		}
		m.load(properties, new IRelativePathResolver() {
			
			@Override
			public String resolve(String relativePath) {
				return new File(baseFile.getParentFile(), relativePath).getAbsolutePath();
			}
		});
		return m;
	}
	
	protected abstract Picto getRenderingMetadata(IEditorPart editorPart);
	
	protected abstract Resource getResource(IEditorPart editorPart);
	
}
