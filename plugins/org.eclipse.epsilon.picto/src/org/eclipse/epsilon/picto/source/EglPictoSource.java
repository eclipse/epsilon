/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto.source;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.launching.extensions.ModelTypeExtension;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.common.util.UriUtil;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dt.ExtensionPointToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.epsilon.eol.types.EolAny;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.picto.Layer;
import org.eclipse.epsilon.picto.LazyEgxModule;
import org.eclipse.epsilon.picto.LazyEgxModule.LazyGenerationRule;
import org.eclipse.epsilon.picto.LazyEgxModule.LazyGenerationRuleContentPromise;
import org.eclipse.epsilon.picto.ResourceLoadingException;
import org.eclipse.epsilon.picto.StaticContentPromise;
import org.eclipse.epsilon.picto.ViewTree;
import org.eclipse.epsilon.picto.dom.CustomView;
import org.eclipse.epsilon.picto.dom.Model;
import org.eclipse.epsilon.picto.dom.Parameter;
import org.eclipse.epsilon.picto.dom.Patch;
import org.eclipse.epsilon.picto.dom.Picto;
import org.eclipse.epsilon.picto.dom.PictoFactory;
import org.eclipse.epsilon.picto.dom.PictoPackage;
import org.eclipse.ui.IEditorPart;

public abstract class EglPictoSource implements PictoSource {
	
	protected List<IModel> models = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	@Override
	public ViewTree getViewTree(IEditorPart editor) throws Exception {
		
		IFile iFile = waitForFile(editor);
		if (iFile == null) return createEmptyViewTree();
		
		File modelFile = new File(iFile.getLocation().toOSString());
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
				((InMemoryEmfModel) model).setExpand(true);
			}
			//}
			
			if (renderingMetadata.getFormat() == null) renderingMetadata.setFormat("egx");
			
			if ("egx".equals(renderingMetadata.getFormat())) {
				module = new LazyEgxModule();
			}
			else {
				module = new EglTemplateFactoryModuleAdapter(new EglFileGeneratingTemplateFactory());
			}
			
			module.getContext().getNativeTypeDelegates().add(new ExtensionPointToolNativeTypeDelegate());
			
			URI transformationUri = null;
			
			if (renderingMetadata.getTransformation() != null) {			
				transformationUri = UriUtil.resolve(renderingMetadata.getTransformation(), modelFile.toURI());
				module.parse(transformationUri);
			}
			else {
				module.parse("");
			}
			
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
			
			if ("egx".equals(renderingMetadata.getFormat())) {
								
				List<LazyGenerationRuleContentPromise> instances = (List<LazyGenerationRuleContentPromise>) module.execute();
				
				// Handle dynamic views (i.e. where type != null)
				for (CustomView customView : renderingMetadata.getCustomViews().stream().filter(cv -> cv.getType() != null).collect(Collectors.toList())) {
					
					LazyGenerationRule generationRule = (LazyGenerationRule)((LazyEgxModule) module).
							getGenerationRules().stream().filter(r -> r.getName().
							equals(customView.getType())).findFirst().orElse(null);
					
					if (generationRule != null) {
						Object source = null;
						if (generationRule.getSourceParameter() != null) {
							String sourceParameterName = generationRule.getSourceParameter().getName();
							Parameter sourceParameter = customView.getParameters().stream().
									filter(sp -> sp.getName().equals(sourceParameterName)).findFirst().orElse(null);
							if (sourceParameter != null) {
								customView.getParameters().remove(sourceParameter);
								source = sourceParameter.getValue(); 
							}
						}
						
						if (customView.getPath() != null) customView.getParameters().add(createParameter("path", customView.getPath()));
						if (customView.getIcon() != null) customView.getParameters().add(createParameter("icon", customView.getIcon()));
						if (customView.getFormat() != null) customView.getParameters().add(createParameter("format", customView.getFormat()));
						customView.getParameters().add(createParameter("patches", customView.getPatches()));
						if (customView.getPosition() != null) customView.getParameters().add(createParameter("position", customView.getPosition()));
						if (customView.eIsSet(PictoPackage.eINSTANCE.getCustomView_Layers())) {
							customView.getParameters().add(createParameter("activeLayers", customView.getLayers()));
						}
						
						for (Parameter customViewParameter : customView.getParameters()) {
							module.getContext().getFrameStack().put(new Variable(customViewParameter.getName(), getValue(customViewParameter), EolAnyType.Instance));
						}
						
						LazyGenerationRuleContentPromise contentPromise = (LazyGenerationRuleContentPromise) 
								generationRule.execute(module.getContext(), source);
						
						for (Parameter parameter : customView.getParameters()) {
							Variable variable = contentPromise.getVariables().stream().filter(v -> v.getName().equals(parameter.getName())).findFirst().orElse(null);
							
							Object value = getValue(parameter);
							
							if (variable != null) {
								variable.setValue(value, module.getContext());
							}
							else {
								contentPromise.getVariables().add(new Variable(parameter.getName(), value, EolAnyType.Instance, false));
							}
						}
						
						instances.add(contentPromise);
						
					}
					
				}
				
				for (LazyGenerationRuleContentPromise instance : instances) {
					String format = getDefaultFormat();
					String icon = getDefaultIcon();
					List<Patch> patches = new ArrayList<>();
					Collection<String> path = new ArrayList<>(Arrays.asList(""));
					List<Layer> layers = new ArrayList<>();
					Variable layersVariable = null;
					Integer position = null;
					
					for (Variable variable : instance.getVariables()) {
						switch (variable.getName()) {
						case "format": format = variable.getValue() + ""; break;
						case "path": path = (Collection<String>) variable.getValue(); break;
						case "icon": icon = variable.getValue() + ""; break;
						case "position": position = (Integer) variable.getValue(); break;
						case "layers": {
								layersVariable = variable;
								List<Object> layerMaps = (List<Object>) variable.getValue();
								for (Object layerMapObject : layerMaps) {
									Map<Object, Object> layerMap = (Map<Object, Object>) layerMapObject;
									Layer layer = new Layer();
									layer.setId(layerMap.get("id") + "");
									layer.setTitle(layerMap.get("title") + "");
									if (layerMap.containsKey("active")) layer.setActive((Boolean) layerMap.get("active"));
									layers.add(layer);
								}
								break;
							}
						case "patches": patches = (List<Patch>) variable.getValue();
						}
						
					}
					
					// If this is a custom view there may be an activeLayers variable in the variables list
					Variable activeLayersVariable = instance.getVariables().stream().filter(v -> v.getName().equals("activeLayers")).findAny().orElse(null);
					if (activeLayersVariable != null) {
						List<String> activeLayers =  (List<String>) activeLayersVariable.getValue();
						for (Layer layer : layers) {
							layer.setActive(activeLayers.contains(layer.getId()));
						}
					}
					
					// Replace layers variable from list of maps to list of Layer objects
					if (layersVariable != null) instance.getVariables().remove(layersVariable);
					instance.getVariables().add(Variable.createReadOnlyVariable("layers", layers));
					viewTree.add(new ArrayList<>(path), new ViewTree(instance, format, icon, position, patches, layers));
				}
				
			}
			else {
				String content = module.execute() + "";
				viewTree = new ViewTree();
				viewTree.setPromise(new StaticContentPromise(content));
				viewTree.setFormat(renderingMetadata.getFormat());
			}
			
			// Handle static views (i.e. where source != null)
			for (CustomView customView : renderingMetadata.getCustomViews().stream().filter(cv -> cv.getSource() != null).collect(Collectors.toList())) {
				String format = customView.getFormat() != null ? customView.getFormat() : getDefaultFormat();
				String icon = customView.getIcon() != null ? customView.getIcon() : getDefaultIcon();
				
				viewTree.add(customView.getPath(), new ViewTree(new StaticContentPromise(new File(new File(customView.eResource().getURI().toFileString()).getParentFile(), customView.getSource())), 
						format, icon, customView.getPosition(), customView.getPatches(), Collections.emptyList()));
			}
			
			// Handle patches for existing views (i.e. where source == null and type/rule == null)
			for (CustomView customView : renderingMetadata.getCustomViews().stream().filter(cv -> cv.getSource() == null && cv.getType() == null).collect(Collectors.toList())) {
				ArrayList<String> path = new ArrayList<>();
				path.add(viewTree.getName());
				path.addAll(customView.getPath());
				
				ViewTree existingView = viewTree.forPath(path);
				
				if (existingView != null) {
					if (customView.getIcon() != null) existingView.setIcon(customView.getIcon());
					if (customView.getFormat() != null) existingView.setFormat(customView.getFormat());
					if (customView.getPosition() != null) existingView.setPosition(customView.getPosition());
					
					existingView.getPatches().addAll(customView.getPatches());
					if (customView.eIsSet(PictoPackage.eINSTANCE.getCustomView_Layers())) {
						List<String> layers = customView.getLayers();
						for (Layer layer : existingView.getLayers()) {
							layer.setActive(layers.contains(layer.getId()));
						}
					}
				}
			}
			
			if (transformationUri != null) {
				viewTree.getBaseUris().add(transformationUri);
				viewTree.getBaseUris().add(transformationUri.resolve("./icons/"));
			}
			
			return viewTree;
		}
		else {
			return createEmptyViewTree();
		}
		
	}
	
	protected Parameter createParameter(String name, Object value) {
		Parameter parameter = PictoFactory.eINSTANCE.createParameter();
		parameter.setName(name);
		parameter.setValue(value);
		return parameter;
	}
	
	protected IFile waitForFile(IEditorPart editorPart) {
		int attempts = 0;
		int maxAttempts = 50;
		IFile file = getFile(editorPart);
		while (file == null && attempts < maxAttempts) {
			try { Thread.sleep(100); } catch (InterruptedException e) {}
			file = getFile(editorPart);
			attempts++;
		}
		return file;
	}
	
	protected ViewTree createEmptyViewTree() {
		ViewTree viewTree = new ViewTree();
		viewTree.setPromise(new StaticContentPromise("Nothing to render"));
		viewTree.setFormat("text");
		return viewTree;
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
		IRelativePathResolver relativePathResolver = new IRelativePathResolver() {
			
			@Override
			public String resolve(String relativePath) {
				return new File(baseFile.getParentFile(), relativePath).getAbsolutePath();
			}
		};
		
		for (Parameter parameter : model.getParameters()) {
			if (parameter.getFile() != null) {
				properties.put(parameter.getName(), relativePathResolver.resolve(parameter.getFile()));
			}
			else {
				properties.put(parameter.getName(), parameter.getValue());
			}
		}
		m.load(properties, relativePathResolver);
		return m;
	}
	
	protected String getDefaultFormat() {
		return "html";
	}
	
	protected String getDefaultIcon() {
		return "diagram-cccccc";
	}
	
	@Override
	public boolean supports(IEditorPart editorPart) {
		return supportsEditorType(editorPart) && getRenderingMetadata(editorPart) != null;
	}
	
	public Object getValue(Parameter parameter) {
		Object value = parameter.getValue();
		if (value == null) {
			if (parameter.eIsSet(PictoPackage.Literals.PARAMETER__VALUES)) {
				value = parameter.getValues();
			}
		}
		
		if (value == null) {
			if (!parameter.getItems().isEmpty()) {
				// If one of the nested items has a name, then the parameter is a map
				boolean map = parameter.getItems().stream().anyMatch(item -> item.getName() != null);
				if (map) {
					HashMap<String, Object> values = new LinkedHashMap<String, Object>();
					for (Parameter item : parameter.getItems()) {
						String key = item.getName();
						if (key == null) key = "";
						values.put(key, getValue(item));
					}
					value = values;
				}
				else {
					List<Object> values = new ArrayList<Object>();
					values.addAll(parameter.getItems().stream().map(item -> getValue(item)).collect(Collectors.toList()));
					value = values;
				}
			}
		}
		
		return value;
	}
	
	protected abstract Picto getRenderingMetadata(IEditorPart editorPart);
	
	protected abstract Resource getResource(IEditorPart editorPart);
	
	protected abstract IFile getFile(IEditorPart editorPart);
	
	protected abstract boolean supportsEditorType(IEditorPart editorPart);
}
